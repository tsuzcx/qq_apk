package moai.daemon;

import java.lang.ref.WeakReference;
import moai.daemon.utils.DaemonSchedulers;
import moai.daemon.utils.DaemonSchedulers.Scheduler;
import moai.daemon.utils.Log;

final class DaemonManager$2
  implements Runnable
{
  public void run()
  {
    DaemonSchedulers.single.remove(DaemonManager.access$100());
    Object localObject = DaemonActivity.instance;
    DaemonActivity.instance = null;
    if (localObject != null)
    {
      localObject = (DaemonActivity)((WeakReference)localObject).get();
      if (localObject != null)
      {
        Log.i("DaemonManager", "finishDaemonActivity");
        ((DaemonActivity)localObject).finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.daemon.DaemonManager.2
 * JD-Core Version:    0.7.0.1
 */