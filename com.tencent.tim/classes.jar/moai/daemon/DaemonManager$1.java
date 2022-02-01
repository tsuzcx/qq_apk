package moai.daemon;

import android.content.Context;
import android.content.Intent;
import moai.daemon.utils.Log;

final class DaemonManager$1
  implements Runnable
{
  public void run()
  {
    if (!DaemonManager.access$000()) {}
    Context localContext;
    do
    {
      return;
      localContext = DaemonManager.getContext();
    } while (localContext == null);
    Log.i("DaemonManager", "startDaemonActivity");
    try
    {
      localContext.startActivity(new Intent(localContext, DaemonActivity.class).addFlags(268435456));
      return;
    }
    catch (Exception localException)
    {
      Log.w("DaemonManager", "start DaemonActivity failed", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.daemon.DaemonManager.1
 * JD-Core Version:    0.7.0.1
 */