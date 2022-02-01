import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class asvu
  implements MiniAppLauncher.MiniAppLaunchListener
{
  asvu(asvt paramasvt, RequestEvent paramRequestEvent) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvu
 * JD-Core Version:    0.7.0.1
 */