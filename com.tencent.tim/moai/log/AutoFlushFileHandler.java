package moai.log;

import java.util.ArrayList;

import android.os.SystemClock;

/**
 * <pre>
 * 自动flushFileHandler
 * </pre>
 */
public class AutoFlushFileHandler extends FileHandlerDelegate {
	
	public interface Strategy {
		void add(FileHandler fileHandler);
		void flush(long size);
	}
	
	/**
	 * <pre>
	 * 切换子线程，每1秒flush一次
	 * TODO，改进一个策略一个线程
	 * </pre>
	 */
	public static class DefaultStrategy implements Strategy {
		private final long maxTimeInterval;
		
		private final ArrayList<FileHandler> fileHandlerList = new ArrayList<FileHandler>();
		private FileHandler[] cacheFileHandler = new FileHandler[0];
//		private volatile FileHandler fileHandler = null;
		private boolean isAlive = true;
		private final Object lock = new Object();
		private boolean hasSize = false;
		
		private final Runnable runnable  = new Runnable() {
			
			@Override
			public void run() {
				while (isAlive) {
					synchronized (lock) {
						if (!hasSize) {
							try {
								lock.wait();
							} catch (InterruptedException e) {
							}
						}
						hasSize = true;
					}
					SystemClock.sleep(maxTimeInterval);
					for (FileHandler fh : cacheFileHandler) {
						if (fh != null) {
							fh.flush();
						}
					}
				}
				
			}
		};
		
		public DefaultStrategy() {
			this(1 * 1000);
		}

		public DefaultStrategy(int maxTimeInterval) {
			this.maxTimeInterval = maxTimeInterval;
			Thread ht = new Thread(runnable, "autoflush");
			ht.start();
		}

		@Override
		public void flush(long size) {
			synchronized (lock) {
				hasSize = hasSize || size > 0;
				lock.notifyAll();
			}
		}

		@Override
		public void add(FileHandler fileHandler) {
			synchronized (lock) {
				if (!fileHandlerList.contains(fileHandler)) {
					fileHandlerList.add(fileHandler);
					cacheFileHandler = fileHandlerList.toArray(new FileHandler[0]);
				}
			}
		}
	}
	
	private final Strategy strategy;

	public AutoFlushFileHandler(FileHandler fileHandler, Strategy strategy) {
		super(fileHandler);
		if (strategy == null) {
			throw new IllegalArgumentException("strategy null");
		}
		this.strategy = strategy;
		strategy.add(fileHandler);
	}
	
	@Override
	protected int onPrepareToWrite(LogData logData) {
		int len = logData.sizeEstimated();
		strategy.flush(len); // 如果同步，就flush之前的数据，异步，就可能flush之后数据
		return super.onPrepareToWrite(logData);
	}


}
