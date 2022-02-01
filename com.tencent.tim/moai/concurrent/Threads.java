/**
 * 
 */
package moai.concurrent;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;

import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import moai.log.MLog;
import moai.log.MLogManager;

/**
 * 线程工具类，提供线程池
 */
public final class Threads {
	private static final MLog logger = MLogManager.getLogger("moailog");

	private static final int CORE_CONCURRENT = 3; // 线程池至少有3个线程
	private static final int MAX_CONCURRENT = 64; // 最大数，不做限制，如果不够资源，由系统抛异常
	private static final long KEEP_ALIVE_TIME = 30; // 120秒，就清理多余的线程
	private static final int WAIT_COUNT = 256; // 最多排队个数，这里控制线程创建的频率
	protected static final String TAG = Threads.class.getSimpleName();

	// 用于记录后台等待的Runnable，第一个参数外面的Runnable，第二个参数是等待中的Runnable
	private static ConcurrentHashMap<Runnable, List<Runnable>> mapToMainHandler;// = new HashMap<Runnable, Runnable>();
	private static ConcurrentHashMap<Runnable, ScheduledFuture<?>> mapToMainHandlerSchedule;// = new HashMap<Runnable, ScheduledFuture<?>>();
	
	private static final boolean SWITCH = false;
	private static ThreadPoolExecutor threadPoolExecutor ;
	private static ScheduledThreadPoolExecutor threadPoolExecutorSchedule;
	private static Handler sSingleHandler;
	
	private static ExecutorService jobsForUI = Executors.newFixedThreadPool(
            CORE_CONCURRENT, new MThreadFactory("MJobsForUI", Thread.NORM_PRIORITY - 1));
	
	static {
		if (SWITCH) {
			threadPoolExecutorSchedule = createScheduleThreadPool();
			mapToMainHandlerSchedule = new ConcurrentHashMap<Runnable, ScheduledFuture<?>>();
		} else {
			mapToMainHandler = new ConcurrentHashMap<Runnable, List<Runnable>>();
			threadPoolExecutor = createThreadPool();
			initSingleHandler();
		}
	}
	
	public static void setThreadPoolExecutor(ThreadPoolExecutor executor) {
	    if (executor != null && executor != threadPoolExecutor) {
	        threadPoolExecutor.shutdown();
	        threadPoolExecutor = executor;
	    }
	}
	
	public static void setFutureTaskExecutor(ExecutorService executorService) {
	    if (executorService != null && executorService != jobsForUI) {
	        jobsForUI.shutdown();
	        jobsForUI = executorService;
	    }
	}
	
	private static void initSingleHandler() {
	    HandlerThread thread = new HandlerThread("moai-single-thread", Process.THREAD_PRIORITY_BACKGROUND);
	    thread.start();
        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            
            @Override
            public void uncaughtException(Thread thread, Throwable tr) {
                mainHandler.post(new Runnable() {
                    
                    @Override
                    public void run() {
                        initSingleHandler();
                    }
                });
            }
        });
        sSingleHandler = new Handler(thread.getLooper());
	}
	
	public final static void startLongRunJob(String prefix, String id, Runnable r) {
        new MThreadFactory(prefix, Thread.NORM_PRIORITY - 2).newThread(r, "" + id).start();
    }

	/**
	 * 启动一个消耗线程，常驻后台
	 * @param r
	 */
	public static void startConsumer(final Runnable r, final String name) {
		runInBackground(new Runnable() {
			@Override
			public void run() {
				new MThreadFactory(name, Thread.NORM_PRIORITY - 3).newThread(r).start();
			}
		});
	}
	
	private static class LogAndAbortPolicy extends ThreadPoolExecutor.AbortPolicy {
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
			logger.e(TAG, "rejectedExecution: " + r);
			String allStackTrace = logAllThreadStackTrace().toString();
			logger.e(TAG, allStackTrace);
			if (SWITCH) {
				threadPoolExecutorSchedule.shutdownNow();
				threadPoolExecutorSchedule = createScheduleThreadPool();
			} else {
				threadPoolExecutor.shutdownNow();
				threadPoolExecutor = createThreadPool();
			}
			// TODO，需要打日志
//			QMLogStream.logWithoutUmaNow(CommonDefine.ERROR_CODE_EVENT_APP_THREAD_POOL_FULL, allStackTrace, "Thread_Pool_Full");
		}
	}
	
	private static ThreadPoolExecutor createThreadPool() {
		
		return new ThreadPoolExecutor(CORE_CONCURRENT, MAX_CONCURRENT, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(WAIT_COUNT), new MThreadFactory("MPool",
				Thread.NORM_PRIORITY - 2), new LogAndAbortPolicy());
	}

	private static ScheduledThreadPoolExecutor createScheduleThreadPool() {
		ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(CORE_CONCURRENT, new MThreadFactory("MPool", Thread.NORM_PRIORITY - 2), new LogAndAbortPolicy());
		pool.setMaximumPoolSize(MAX_CONCURRENT);
		pool.setKeepAliveTime(KEEP_ALIVE_TIME, TimeUnit.SECONDS);
		return pool;
	}

	/**
	 * 提交到其他线程去跑，需要取数据的时候会等待任务完成再继续
	 * @param task
	 * @return
	 */
	public static <T> Future<T> submitTask(Callable<T> task) {
		return jobsForUI.submit(task);
	}
	
	/**
	 * 强制清理任务
	 * @param task
	 * @return
	 */
	public static <T> void cancelTask(Future<T> task) {
		if (task != null) {
			task.cancel(true);
		}
	}
	
	/**
	 * 从 Future 中获取值，如果发生异常，打日志
	 * @param future
	 * @param tag
	 * @param name
	 * @return
	 */
	public static <T> T getFromTask(Future<T> future, String tag, String name) {
		try {
			return future.get();
		} catch (Exception e) {
			logger.e(tag, (name != null ? name + ": " : "") + e.toString());
		}
		return null;
	}

	private static Thread mainThread;
	private static Handler mainHandler;
	static {
		Looper mainLooper = Looper.getMainLooper();
		mainThread = mainLooper.getThread();
		mainHandler = new Handler(mainLooper);
	}

	public static boolean isOnMainThread() {
		return mainThread == Thread.currentThread();
	}

	public static void runOnMainThread(Runnable r) {
		if (isOnMainThread()) {
			r.run();
		} else {
			mainHandler.post(r);
		}
	}

	public static void runOnMainThread(Runnable r, long delayMillis) {
		if (delayMillis <= 0) {
			runOnMainThread(r);
		} else {
			mainHandler.postDelayed(r, delayMillis);
		}
	}
	
	public static boolean hasCallbackOnMainThread(Runnable r) {
	    return hasCallback(mainHandler, r);
	}
	
	private static boolean hasCallback(Handler handler, Runnable r) {
        try {
            Method method = Handler.class.getMethod("hasCallbacks", new Class<?>[]{Runnable.class});
            return (boolean) method.invoke(handler, new Object[]{r});
        } catch (Exception e) {}
        return false;
	}

	/**
	 * 对runOnMainThread的，移除Runnable
	 * 
	 * @param r
	 */
	public static void removeCallbackOnMain(Runnable r) {
		mainHandler.removeCallbacks(r);
	}
	
	public static void replaceCallbackOnMainThread(Runnable r) {
	    replaceCallbackOnMainThread(r, 0);
	}
	
	/**
	 * 替换掉主线程队列中同一个task，重置delay时间
	 * 
	 * @param r
	 * @param delayMillis
	 */
	public static void replaceCallbackOnMainThread(Runnable r, long delayMillis) {
	    synchronized (r) {
            removeCallbackOnMain(r);
            runOnMainThread(r, delayMillis);
        }
	}
	
	public static void runOnMainThreadIfNotExist(Runnable r) {
	    runOnMainThread(r, 0);
	}
	
	/**
	 * 如果主线程队列中已经有同一个task，则不再post这个task
	 * 
	 * @param r
	 * @param delayMillis
	 */
	public static void runOnMainThreadIfNotExist(Runnable r, long delayMillis) {
        if (!hasCallbackOnMainThread(r)) {
            synchronized (r) {
                if (!hasCallbackOnMainThread(r)) {
                    runOnMainThread(r, delayMillis);
                }
            }
        }
    }

	private static int getThreadPoolIdleCount() {
		return threadPoolExecutor.getMaximumPoolSize() - threadPoolExecutor.getActiveCount();
	}

	public static void runInBackground(Runnable r) {
		if (SWITCH) {
			threadPoolExecutorSchedule.execute(r);
		} else {
			threadPoolExecutor.execute(r);
		}
	}

	public static void runInBackground(final Runnable r, long delayMillis) {
		if (delayMillis <= 0) {
			runInBackground(r);
		} else {
			if (SWITCH) {
				ScheduledFuture<?> f = threadPoolExecutorSchedule.schedule(r, delayMillis, TimeUnit.MILLISECONDS);
				mapToMainHandlerSchedule.put(r, f);
			} else {
				Runnable mainRunnable = new Runnable() {
					@Override
					public void run() {
						List<Runnable> taskList = mapToMainHandler.get(r);
						if (taskList != null && taskList.size() > 0) {
						    synchronized (taskList) {
                                taskList.remove(this);
                            }
						}
						if (taskList == null || taskList.size() == 0) {
						    mapToMainHandler.remove(r);
						}
						threadPoolExecutor.execute(r);
					}
				};
				List<Runnable> taskList = mapToMainHandler.get(r);
				if (taskList == null) {
				    synchronized (r) {
                        if (taskList == null) {
                            taskList = new ArrayList<Runnable>();
                            mapToMainHandler.put(r, taskList);
                        }
                    }
				}
				synchronized (taskList) {
				    taskList.add(mainRunnable);
                }
				mainHandler.postDelayed(mainRunnable, delayMillis);
			}
		}
	}

	public static void runOnNotMainThread(Runnable r) {
		if (!isOnMainThread()) {
			r.run();
		} else {
			runInBackground(r);
		}
	}
	
	public static boolean hasCallbackInBackground(Runnable r) {
	    if (SWITCH) {
	        return mapToMainHandlerSchedule.contains(r);
	    } else {
	        return mapToMainHandler.contains(r) || hasCallback(sSingleHandler, r);
	    }
	}

	public static void removeCallbackInBackground(Runnable r) {
		if (SWITCH) {
			ScheduledFuture<?> f = mapToMainHandlerSchedule.get(r);
			if (f != null) {
				f.cancel(false);
			}
		} else {
		    List<Runnable> taskList = mapToMainHandler.remove(r);
		    if (taskList != null && taskList.size() > 0) {
		        synchronized (taskList) {
                    for (Runnable task : taskList) {
                        mainHandler.removeCallbacks(task);
                    }
                }
		    }
		    sSingleHandler.removeCallbacks(r);
		}
	}
	
	public static void replaceCallbackInBackground(Runnable r) {
	    replaceCallbackInBackground(r, 0);
	}
	
	/**
	 * 替换掉队列中同一个task，重置delay时间，
	 * 
	 * @param r
	 * @param delayMillis
	 */
	public static void replaceCallbackInBackground(Runnable r, long delayMillis) {
	    synchronized (r) {
            removeCallbackInBackground(r);
            sSingleHandler.postDelayed(r, delayMillis);
        }
	}
	
	public static void runInBackgroundIfNotExist(Runnable r) {
	    runInBackgroundIfNotExist(r, 0);
	}
	
	/**
	 * 如果队列中有同一个task，不再post这个task
	 * 
	 * @param r
	 * @param delayMillis
	 */
	public static void runInBackgroundIfNotExist(Runnable r, long delayMillis) {
	    if (!hasCallbackInBackground(r)) {
	        synchronized (r) {
	            if (!hasCallbackInBackground(r)) {
	                sSingleHandler.postDelayed(r, delayMillis);
	            }
	        }
	    }
	}

	public static StringBuilder logAllThreadStackTrace() {
		StringBuilder builder = new StringBuilder();
		Map<Thread, StackTraceElement[]> liveThreads = Thread.getAllStackTraces();
		for (Iterator<Thread> i = liveThreads.keySet().iterator(); i.hasNext(); ) {
			Thread key = i.next();
			builder.append("Thread ").append(key.getName())
				   .append("\n");
			StackTraceElement[] trace = liveThreads.get(key);
			for (int j = 0; j < trace.length; j++) {
				builder.append("\tat ").append(trace[j]).append("\n");
			}
		}
		return builder;
	}

    public static void waitNoException(Object obj) {
        try {
            obj.wait();
        } catch (InterruptedException e) {
        } catch (Exception e) {
//            if (BuildConfig.DEBUG) throw e;
        }
    }

    public static void waitNoException(Object obj, long millis) {
        try {
            obj.wait(millis);
        } catch (InterruptedException e) {
        } catch (Exception e) {
//            if (BuildConfig.DEBUG) throw e;
        }
    }
}
