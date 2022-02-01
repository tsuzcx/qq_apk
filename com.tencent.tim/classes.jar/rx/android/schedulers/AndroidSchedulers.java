package rx.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;

public final class AndroidSchedulers
{
  private AndroidSchedulers()
  {
    throw new AssertionError("No instances");
  }
  
  public static Scheduler mainThread()
  {
    Scheduler localScheduler = RxAndroidPlugins.getInstance().getSchedulersHook().getMainThreadScheduler();
    if (localScheduler != null) {
      return localScheduler;
    }
    return MainThreadSchedulerHolder.MAIN_THREAD_SCHEDULER;
  }
  
  static class MainThreadSchedulerHolder
  {
    static final Scheduler MAIN_THREAD_SCHEDULER = new HandlerScheduler(new Handler(Looper.getMainLooper()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.android.schedulers.AndroidSchedulers
 * JD-Core Version:    0.7.0.1
 */