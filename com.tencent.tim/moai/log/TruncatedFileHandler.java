package moai.log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 一个log文件，，设置大小，超过后，移除部分
 */
public class TruncatedFileHandler extends FileHandlerDelegate implements Runnable {
	
	private double truncateRatio = 0.5;
	
	private long maxSize = -1;
	private volatile boolean truncating = false;
	private LinkedBlockingQueue<LogData> truncatedCache = new LinkedBlockingQueue<>(); // 缓冲truncating时候的日志
	private volatile long fileSize = -1;
	private Object lock = new Object();

	/**
	 * @param fileHandler
	 * @param maxSize 最大字节数，超过就移除部分，可赋值-1，无限大
	 * @param truncateRatio truncateRatio之后剩余的比例
	 */
	public TruncatedFileHandler(FileHandler fileHandler, long maxSize, double truncateRatio) {
		this(fileHandler, maxSize);
		this.truncateRatio = truncateRatio;
	}

	/**
	 * @param fileHandler
	 * @param maxSize 最大字节数，超过就移除部分，可赋值-1，无限大
	 */
	public TruncatedFileHandler(FileHandler fileHandler, long maxSize) {
		super(fileHandler);
		if (getFilename().indexOf('%') >= 0) {
			throw new IllegalArgumentException("not support");
		}
		this.maxSize = maxSize;
	}
	
	@Override
	protected int onPrepareToWrite(LogData publishLog) {
		synchronized (lock) {
			if (truncating) {
				truncatedCache.add(LogData.obtain(publishLog)); // 会在super.writeToFile recyle
				// 不让写文件
				return publishLog.sizeEstimated(); // 不让writeToFile
			}
		}

		// 整理完文件后
		if (!truncatedCache.isEmpty()) {
			while (truncatedCache.size() > 0) {
				LogData logData = truncatedCache.poll();
				if (logData != null) {
					super.writeToFile(logData);
				}
			}
			truncatedCache.clear();
		}

		if (maxSize >= 0) {
			if (fileSize < 0) {
				fileSize = new File(getDirname() + File.separator + getFilename()).length();
			}

			synchronized (lock) {
				fileSize += publishLog.sizeEstimated();
				if (fileSize > maxSize) {
					// 由于不经常，不用线程池
					if (!truncating) {
						truncating = true;
						fileSize = -1;
						new Thread(this).start();
					}
				}
			}
		}
		
		return super.onPrepareToWrite(publishLog);
	}

	@Override
	public void run() {
		// 会丢一些日志
		File tmp = null;
		InputStream is = null;
		OutputStream os = null;
		int count = 0;
		try {
			File file = new File(getDirname() + File.separator + getFilename());
			if (file.length() < maxSize) {
				return;
			}
			is = new BufferedInputStream(new FileInputStream(file));
			long remainingSize = file.length();
			while (remainingSize > maxSize) {
				remainingSize = (long) (remainingSize * (1 - truncateRatio));
			}
			is.skip(file.length() - remainingSize);
			tmp = File.createTempFile(getFilename(), null, new File(getDirname()));
			os = new BufferedOutputStream(new FileOutputStream(tmp));
			// MARK 改为channel
			int b;
			while ((b = is.read()) != -1) {
				++count;
				os.write(b);
			}

			tmp.renameTo(new File(getDirname() + File.separator + getFilename()));
			tmp.delete();
			os.close();
			is.close();
			super.close();

			// TODO，错误如何处理
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			synchronized (lock) {
				fileSize = count;
				truncating = false;
			}

			if (tmp != null) {
				tmp.delete();
			}

			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
			deleteAllOldTempFile();
		}
	}

	private void deleteAllOldTempFile() {
		File file = new File(getDirname());//里面输入特定目录
		File temp;
		File[] files = file.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				temp = files[i];
				if (temp != null && temp.exists() && temp.getName().endsWith(".tmp")) {
					temp.delete();
				}
			}
		}
	}

}
