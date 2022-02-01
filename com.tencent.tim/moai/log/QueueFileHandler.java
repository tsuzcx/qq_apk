package moai.log;

import java.util.concurrent.LinkedBlockingQueue;

import android.util.Log;

/**
 * <pre>
 * 队列缓存器
 * LogData进入队列，等flush时，写文件writeToFile
 * 
 * 提供：
 * 1. 追加到文件
 * 2. 文件名用日期区分
 * 3. 每个日志，作为message，放入队列，在flush时，写入文件
 * 4. 在Strategy中，监控队列有message，就flush
 * 
 * 背景：遇到flush文件到sdcard过慢，使用BufferedWriter的write的锁导致ANR 
 * 把FileHandler的publish和flush重写
 * 
 * 算法：
 * 两个byteBuffer，一个在I/O操作，一个在writeToFile接收数据，如果满，就丢日志
 * 目的：多线程的log，仅加锁的内存操作；
 * 
 * </pre>
 */
public class QueueFileHandler extends FileHandlerDelegate {
	
	private static final String TAG = QueueFileHandler.class.getSimpleName();
	private final LinkedBlockingQueue<LogData> queue = new LinkedBlockingQueue<>();
	
	public QueueFileHandler(FileHandler fileHandler) {
		super(fileHandler);
	}
	
    /**
     * @param publishLog
     * @return 写入日志长度
     */
	@Override
    protected int onPrepareToWrite(LogData logData) {
		queue.add(LogData.obtain(logData)); // #onFlush中writeToFile是recyle
		if (BuildConfig.DEBUG && queue.size() > 1024) {
			// 容量过大
			throw new IllegalStateException("queue overflow: " + queue.size());
		}
		// ??这里有点疑惑，sb已经写入了cache，不能被修改，再调用super.onWriteToFile，会造成数据的二次修改，但是不回调，就外一层作处理
		int count = super.onPrepareToWrite(logData);
		if (count <= 0) {
			count = logData.sizeEstimated(); // 强制不让FileHandler处理
		}
		return count;
    }

	/**
	 * flush不要手工调用，如果不断有日志写入，这个flush不会返回
	 */
	@Override
	public void onFlush() {
        // Log.i(TAG, "flush thread:" + Thread.currentThread().getName());
		super.onFlush();
		while (queue.size() > 0) {
			LogData logData = queue.poll();
			if (logData != null) {
				super.writeToFile(logData);
			}
		}
	}

}
