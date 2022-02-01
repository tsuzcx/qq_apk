package moai.log;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import android.util.Log;

/**
 * <pre>
 * 提供：
 * 1. 追加到文件
 * 2. 文件名用日期区分
 * *3. 达到最大长度时
 * 
 * 从线程角度来看：
 *   publish,  onPrepareToWrite，与调用者相同线程
 *   writeToFile 写文件buf，如果使用委托，可能与publish不同一条线程
 *   flush 磁盘I/O操作
 * </pre>
 */
public class FileHandler extends Handler implements FileOperation {
	
	private static final String TAG = "FileHandler";
	
	protected FileHandler writeToFileDelegrate;
	
	/**
	 * <pre>
	 * 块分隔符\r\n
	 * 行分隔符\r
	 * 背景，由于可能会多行，如异常堆栈，引用block，以便分解出这块日志
	 * </pre>
	 */
	static final String BLOCK_SEPARATOR = "\r\n";
	
	protected volatile File mFile = null;
	private volatile FileChannel fileChannel = null;
	private static final int BUF_SIZE_TO_FLUSH = 4 * 1024; // 超过4K才flush，由于每页4K
	protected static final int MAX_BUF_SIZE = 64 * 1024; // 每个buffer 64K，超过4K就应该flush
	private final ByteBufferWrapper mOutputByteBuffer;  // IO的buffer，需要锁控制
	
	protected final String dirname;
	protected final String filename;
	private final Formatter filenameFormater; // 是否要求动态文件名，现在只支持日期
	private long previousTime = 0;
	
	// debug信息
	private int failedOpenFileCount = 0; // 打开文件失败次数
	private int failedWriteFileCount = 0; // 写文件失败次数
	private int failedForceOrCloseFileCount = 0; // FileChannel#force or #close失败次数
	private StringBuilder debugInfo = new StringBuilder();
	
	/**
	 * 内部用于代理 
	 */
	FileHandler() {
		super(Log.VERBOSE, null);
		this.dirname = null;
		this.filename = null;
		this.filenameFormater = null;
		this.mOutputByteBuffer = null;
	}
	
	/**
	 * @param dirname
	 * @param filename 支持%yyyy，%yy，%mm，%dd
	 */
	public FileHandler(String dirname, String filename, int level, String format) {
		super(level, format);
		this.dirname = dirname;
		this.filename = filename;
		this.filenameFormater = parseFilenameFormat(filename);
		this.mOutputByteBuffer = new ByteBufferWrapper(MAX_BUF_SIZE);
	}
	
	protected final void setWriteToFileDelegrate(FileHandler writeToFileDelegrate) {
		this.writeToFileDelegrate = writeToFileDelegrate;
	}

	// FileHandler的子类，只需重载onWriteToFile
	@Override
	public int publish(int level, String tag, String msg) {
		return publish(level, tag, msg, null);
	}

	@Override
	public int publish(int level, String tag, String msg, Throwable t) {
		if (level < getLevel()) {
			return 0;
		}
		LogData logData = LogData.obtain(level, tag, msg, t);
		return onPrepareToWrite(logData);
	}
	
	/**
	 * @return null使用旧的文件句柄
	 */
	private String parseFileName(boolean force) {
		if (filenameFormater == null) {
			return filename;
		} else {
			long now = System.currentTimeMillis();
			if (force || now - previousTime > 24 * 60 * 60 * 1000) {
				// 新一天开始
				previousTime = getTimesmorning();// 一天的开始时间
				ByteBufferWrapper buf = new ByteBufferWrapper(32); // 文件名
                Thread thread = Thread.currentThread();
				filenameFormater.append(buf, null, 0, now, thread.getId(), thread.getName());
				return buf.toString();
			}
			return null;
		}
	}

	//获得当天0点时间
	private static long getTimesmorning(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}
	
	
    /**
     * @param logData 临时数据，如需cache，用LogData.obtain拷贝出来
     * @return 准备写入长度，如果等于或小于0，就没处理
     */
    protected int onPrepareToWrite(LogData logData) {
		if (writeToFileDelegrate != null) {
			int count;
			if ((count = writeToFileDelegrate.onPrepareToWrite(logData)) > 0) {
				logData.recycle();
				return count;
			}
		}
    	return writeToFile(logData);
    }

    /**
     * <pre>
     * 实际写入文件的唯一入口
     * 每次调用log，都是一个block，以\r\n分割
     * 
     * writeToFile不会让子类重载，只能重载onWriteToFile
     * </pre>
     * @param rawLogData
     * @param buf 有点难理解，既是输入也是输出
     * @return true，已经处理，直接冒泡
     */
    protected boolean onWriteToBuf(LogData rawLogData, ByteBufferWrapper buf) {
    	formater.append(buf, rawLogData.tag, rawLogData.level, rawLogData.logTime, rawLogData.threadId, rawLogData.threadName);
    	buf.append(rawLogData.msg);
    	if (rawLogData.throwable != null) {
    		// 不想暴露byte直接操作
    		StringWriter sw = new StringWriter(1024);
    		PrintWriter pw = new PrintWriter(sw);
    		rawLogData.throwable.printStackTrace(pw);
    		buf.append(sw.toString());
    	}
    	if (writeToFileDelegrate != null) {
    		if (writeToFileDelegrate.onWriteToBuf(rawLogData, buf)) {
    			return true;
    		}
    	}
    	return true;
    }
    
    /**
     * @param pl
     * @return 写入长度
     */
    @SuppressWarnings("resource")
	protected int writeToFile(LogData logData) {
    	synchronized (this) { // 保证fileChannel不改变
    		if (fileChannel == null) {
    			new File(dirname).mkdirs();
    			String filename = parseFileName(true);
    			mFile = new File(dirname + File.separator + filename);
    			try {
					fileChannel = new FileOutputStream(dirname + File.separator + filename, true).getChannel();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					++failedOpenFileCount;
				}

    		} else if (mFile != null && !mFile.exists()) {
    			//针对文件创建后中途被改名或删除的情况，此时不能flush()，如果有未写入文件的直接抛弃掉。
    			String filename = parseFileName(false);
    			if (filename == null) {
    				//用旧的文件名
    				filename = mFile.getName();
    			}
    			FileChannel oldFileChannel = fileChannel;
    			mFile = new File(dirname + File.separator + filename);
    			try {
					fileChannel = new FileOutputStream(dirname + File.separator + filename, true).getChannel();
				} catch (FileNotFoundException e1) {
					++failedOpenFileCount;
				}
    			if (oldFileChannel != null) {
    				try {
						oldFileChannel.close();
					} catch (IOException e) {
					}
    			}
    		} else if (filenameFormater != null) {
    			String filename = parseFileName(false);
    			if (filename != null) {
    				flush();
    				FileChannel oldFileChannel = fileChannel;
    				mFile = new File(dirname + File.separator + filename);
    				try {
						fileChannel = new FileOutputStream(dirname + File.separator + filename, true).getChannel();
					} catch (FileNotFoundException e1) {
						++failedOpenFileCount;
					}
        			if (oldFileChannel != null) {
        				try {
    						oldFileChannel.close();
    					} catch (IOException e) {
    					}
        			}
    			}
    		}

    		if (fileChannel != null) {
    			ByteBufferWrapper bufferWrapper = mOutputByteBuffer;
    			int beforeLen = bufferWrapper.length();
    			try {
    				bufferWrapper.setPosition(beforeLen);
    				onWriteToBuf(logData, bufferWrapper);
    				bufferWrapper.append(BLOCK_SEPARATOR);
    			} catch (Exception e) {
    				// 猜测这部分会抛异常
    				if (BuildConfig.DEBUG) {
    					throw new RuntimeException("MLog crash", e);
    				}
    			}
    			logData.recycle();
    			int afterLen = bufferWrapper.length();
    			fileChannelWrite(BUF_SIZE_TO_FLUSH);
    			if (BuildConfig.BETA && beforeLen > BUF_SIZE_TO_FLUSH) {
    				// 为什么没有写入
    				appendDebugLog(String.format("filehandle overflow:%d", beforeLen));
    			}
    			return afterLen - beforeLen;
    		} else {
    			// 创建失败
    		}
    	}
    	return 0;
    }
    
    private void fileChannelWrite(int size) {
		if (mOutputByteBuffer.length() > size) {
			// TODO，如何判断，偶然写失败，下次重试
			try {
				// 小概率不能把buf全部写出
				fileChannel.write(mOutputByteBuffer.flip().toBuffer());
			} catch (IOException e) {
				++failedWriteFileCount;
				// 失败，就容忍丢日志
				e.printStackTrace();
			} finally {
				mOutputByteBuffer.clear();
			}
		}
    }
    
    protected void onFlush() {
    	if (writeToFileDelegrate != null) {
    		writeToFileDelegrate.onFlush();
    	}
    }

	@Override
	public void flush() {
		onFlush();
		synchronized (this) {
			if (fileChannel != null) {
				fileChannelWrite(0);
				try {
					fileChannel.force(false);
				} catch (IOException e) {
					++failedForceOrCloseFileCount;
					e.printStackTrace();
					fileChannel = null; // 
				}
			}
		}
	}
	
	// 如果文件改变，就强制close
	protected void close() {
		flush();
		synchronized (this) {
			if (fileChannel != null) {
				try {
					fileChannel.close();
				} catch (IOException e) {
					// e.printStackTrace();
					++failedForceOrCloseFileCount;
				}
				fileChannel = null;
			}
		}
	}

	/**
	 * <pre>
	 * 为了只比较时间部分，把前后部分相同部分抽出来比较
	 * 例如：qmlog目录下有
	 *   qm20160427.log
	 *   qm20160428.log
	 *   oss20160427.log
	 *   oss20160428.log
	 * format是qm%yyyy%mm%dd.log，list(null, 20160428)，只会得到qm20160427.log
	 * list(null, null)，得到qm20160427.log和qm20160428.log
	 * </pre>
	 * @see moai.log.FileOperation#list(java.util.GregorianCalendar, java.util.GregorianCalendar)
	 */
	@Override
	public List<String> list(GregorianCalendar begin, GregorianCalendar end) {
		if (filenameFormater == null) {
			return Arrays.asList(dirname + File.separator + filename);
		} else {
			final Pattern pattern = filenameFormater.formatDate();
			final String beginString = begin == null ? null : filenameFormater.formatDate(begin);
			final String endString = end == null ? null : filenameFormater.formatDate(end);
			String[] files = new File(dirname).list(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String filename) {
					return pattern.pattern().equals(filename) // 没有用通配符
							|| pattern.matcher(filename).matches() // 使用通配符而且格式一样
							&& (beginString == null || filename
									.compareTo(beginString) >= 0)
							&& (endString == null || filename
									.compareTo(endString) < 0);
				}
				
			});
			if (files == null) {
				return Collections.<String>emptyList();
			}
			for (int i = 0; i < files.length; i++) {
				files[i] = dirname + File.separator + files[i];
			}
			return Arrays.asList(files);
		}
	}
	
	/**
	 * 改为\r\n换行
	 */
	private static class LineBufferedReader extends BufferedReader {

		public LineBufferedReader(Reader in) {
			super(in);
		}

		/**
		 * 不含有"\r\n"
		 */
		@Override
		public String readLine() throws IOException {
			int ch;
			StringBuilder sb = new StringBuilder();
			int lastChar = super.read();
			while ((ch = super.read()) >= 0) {
				if (lastChar == '\r' && ch == '\n') {
					return sb.toString();
				}
				sb.append((char)lastChar);
				lastChar = ch;
			}
			if (lastChar >= 0) {
				sb.append((char)lastChar);
			}
			return sb.length() == 0 ? null : sb.toString();
		}
		
	}
	
	/**
	 * 每行(块)数据的过滤
	 * @param config
	 * @param line
	 * @return
	 */
	protected boolean filterContent(Config config, String line) {
		String patternString = config.getPatternString();
		if (patternString != null) {
			if (line.contains(patternString)) {
				return true;
			}
		}
		Pattern pattern = config.getPattern();
		if (pattern != null) {
			return pattern.matcher(line).matches();
		}
		return false;
	}
	
	@Override
	public void zip(Config config, String outFilePath) {
		if (outFilePath == null || outFilePath.length() == 0) {
			throw new IllegalArgumentException("outFilePath invalid");
		}
		GregorianCalendar begin = config.getBegin();
		GregorianCalendar end = config.getEnd();
		List<String> filelist = list(begin, end);
		
		ZipOutputStream out = null;
		try {
			out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFilePath)));
			ZipEntry classesDex = new ZipEntry("content");
			out.putNextEntry(classesDex);
			for (String filepath : filelist) {
				// 以\r\n为分割
				BufferedReader br = null;
				try {
					br = new LineBufferedReader(new FileReader(filepath));
					String line;
					while ((line = br.readLine()) != null) {
						if (filterContent(config, line)) {
							out.write(line.getBytes());
							out.write(BLOCK_SEPARATOR.getBytes());
						}
					}
					// read错误，write错误需要区分
				} finally {
					if (br != null) {
						try  {
							br.close();
						} catch (IOException e) {
						}
					}
				}
			}
			out.closeEntry();
		} catch (IOException e) {
			
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	protected static Formatter parseFilenameFormat(String filename) {
		final String[] fmts = new String[] { "%" + Formatter.FORMAT.YYYY.getContent(),
				"%" + Formatter.FORMAT.YY.getContent(),
				"%" + Formatter.FORMAT.MONTH.getContent(),
				"%" + Formatter.FORMAT.DD.getContent() };
		for (String f : fmts) {
			if (filename.contains(f)) {
				return new Formatter(filename);
			}
		}
		return null;
	}

	public String getDirname() {
		return dirname;
	}

	public String getFilename() {
		return filename;
	}
	
	/**
	 * <pre>
	 * 日志数据，分为原始的，和处理过的ByteBufferWrapper
	 * 对象池，能重用
	 * </pre>
	 */
	static final class LogData {
	    private static final int THROWABLE_ESTIMATED = 256;
	    private static final int TRIFLE_SIZE = 25;
		
	    int level;
	    String tag;
	    String msg;
	    Throwable throwable;
	    long threadId;
	    String threadName;
	    long logTime;
	    
		public int sizeEstimated() {
			return TRIFLE_SIZE + (tag == null ? 0 : tag.length())
					+ (msg == null ? 0 : msg.length())
					+ (throwable == null ? 0 : THROWABLE_ESTIMATED);
		}

	    // 对象池
	    private static final Object sPoolSync = new Object();
	    private static LogData sPool;
	    private LogData next;
	    private static int sPoolSize = 0;
	    private static final int MAX_POOL_SIZE = 128;
	    
	    private LogData() {
	    	// 只能使用obtain获取对象
	    }

		private static LogData obtain() {
			synchronized (sPoolSync) {
				if (sPool != null) {
					LogData m = sPool;
					sPool = m.next;
					m.next = null;
					sPoolSize--;
					return m;
				}
			}
			return new LogData();
		}
		
		public static LogData obtain(LogData logData) {
			return obtain(logData.level, logData.tag, logData.msg, logData.throwable);
		}
		
		private static LogData obtain(int level, String tag, String msg, Throwable t) {
			// 只用于FileHandler
			LogData logData = obtain();
			
			logData.level = level;
			logData.tag = tag;
			logData.msg = msg;
			logData.throwable = t;
			
			Thread thread = Thread.currentThread();
			logData.threadId = thread.getId();
			logData.threadName = thread.getName();
			logData.logTime = System.currentTimeMillis();
			
			return logData;
		}
		
		public void recycle() {
			synchronized (sPoolSync) {
				if (sPoolSize < MAX_POOL_SIZE) {
					// 断开数据引用
					level = 0;
					tag = null;
					msg = null;
					throwable = null;
					threadId = 0;
					threadName = null;
					logTime = 0;
					// 放回池
					this.next = sPool;
					sPool = this;
					sPoolSize++;
				}
			}
		}

	}
	
	/**
	 * 统计打开文件失败次数
	 * @return
	 */
	public int getAndClearFailedOpenFileCount() {
		// 不考虑线程安全
		int old = failedOpenFileCount;
		failedOpenFileCount = 0;
		return old;
	}
	/**
	 * 统计写文件失败次数
	 * @return
	 */
	public int getAndClearFailedWriteFileCount() {
		// 不考虑线程安全
		int old = failedWriteFileCount;
		failedWriteFileCount = 0;
		return old;
	}
	
	/**
	 * 统计flush文件失败次数
	 * @return
	 */
	public int getAndClearFailedForceOrCloseFileCount() {
		int old = failedForceOrCloseFileCount;
		failedForceOrCloseFileCount = 0;
		return old;
	}
	
	/**
	 * 用于把调试信息上报oss
	 * @return null，没有
	 */
	public String getAndClearDebugLog() {
		if (BuildConfig.BETA) {
			String old = debugInfo.toString();
			debugInfo = new StringBuilder();
			return old;
		}
		return null;
	}
	
	protected void appendDebugLog(String v) {
		if (BuildConfig.BETA) {
			if (debugInfo.length() < 128) {
				debugInfo.append(v).append("|");
			}
		}
	}
}
