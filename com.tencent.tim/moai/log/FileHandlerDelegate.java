package moai.log;

import java.util.GregorianCalendar;
import java.util.List;


/**
 * FileHandler的委托
 * 
 */
public abstract class FileHandlerDelegate extends FileHandler {
	
	protected final FileHandler mDelegate;

	public FileHandlerDelegate(FileHandler delegate) {
		super();
		if (delegate == null) {
			throw new IllegalArgumentException("no null");
		}
		mDelegate = delegate;
		mDelegate.setWriteToFileDelegrate(this);
	}
	
	@Override
	public final int publish(int level, String tag, String msg) {
		return mDelegate.publish(level, tag, msg);
	}
	
	@Override
	public final int publish(int level, String tag, String msg, Throwable t) {
		return mDelegate.publish(level, tag, msg, t);
	}

	@Override
	public final void flush() {
		mDelegate.flush();
	}

	@Override
	public List<String> list(GregorianCalendar begin, GregorianCalendar end) {
		return mDelegate.list(begin, end);
	}

	@Override
	protected boolean filterContent(Config config, String line) {
		return mDelegate.filterContent(config, line);
	}

	@Override
	public void zip(Config config, String outFilePath) {
		mDelegate.zip(config, outFilePath);
	}

	@Override
	public void setLevel(int level) {
		mDelegate.setLevel(level);
	}

	@Override
	public int getLevel() {
		return mDelegate.getLevel();
	}
	
	@Override
	protected boolean onWriteToBuf(LogData rawLogData, ByteBufferWrapper buf) {
		if (writeToFileDelegrate != null) {
			if (writeToFileDelegrate.onWriteToBuf(rawLogData, buf)) {
				return true;
			}
		}
		return false;
	}
	
	// writeToFile不能让子类重载
	protected final int writeToFile(LogData logData) {
		return mDelegate.writeToFile(logData);
	}
	
	protected final void close() {
		mDelegate.close();
	}

	@Override
	protected int onPrepareToWrite(LogData logData) {
    	if (writeToFileDelegrate != null) {
    		int count;
    		if ((count = writeToFileDelegrate.onPrepareToWrite(logData)) > 0) {
    			return count;
    		}
    	}
		return 0;
	}

	// 使用FileHandle#onFlush
//    protected void onFlush() {
//    	if (writeToFileDelegrate != null) {
//    		writeToFileDelegrate.onFlush();
//    	}
//    }

	@Override
	public final String getDirname() {
		return mDelegate.getDirname();
	}

	@Override
	public final String getFilename() {
		return mDelegate.getFilename();
	}
	
	
	public final int getAndClearFailedOpenFileCount() {
		return mDelegate.getAndClearFailedOpenFileCount();
	}
	/**
	 * 统计写文件失败次数
	 * @return
	 */
	public final int getAndClearFailedWriteFileCount() {
		return mDelegate.getAndClearFailedWriteFileCount();
	}
	
	/**
	 * 统计flush文件失败次数
	 * @return
	 */
	public final int getAndClearFailedForceOrCloseFileCount() {
		return mDelegate.getAndClearFailedForceOrCloseFileCount();
	}
	
	/**
	 * 用于把调试信息上报oss
	 * @return null，没有
	 */
	public final String getAndClearDebugLog() {
		return mDelegate.getAndClearDebugLog();
	}
	
	protected final void appendDebugLog(String v) {
		mDelegate.appendDebugLog(v);
	}
}
