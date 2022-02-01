package moai.patch;

import android.content.Context;
import moai.patch.handle.ProcessKiller;
import moai.patch.log.PatchLog;
import moai.patch.sharedpref.SharedPrefUtil;

final class MoaiApplication$2
  implements Runnable
{
  MoaiApplication$2(boolean paramBoolean, Context paramContext) {}
  
  public void run()
  {
    try
    {
      PatchLog.i(2017, "reboot app activity count:" + MoaiApplication.access$000());
      if (this.val$shouldDelay) {
        Thread.sleep(3000L);
      }
      if (MoaiApplication.access$000() == 0)
      {
        SharedPrefUtil.setPatchRestarted(this.val$context);
        ProcessKiller.killAll(this.val$context, false);
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      PatchLog.e(2019, "kill process fail:" + localInterruptedException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.MoaiApplication.2
 * JD-Core Version:    0.7.0.1
 */