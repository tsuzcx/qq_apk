import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class asue
  implements IActivityResultListener
{
  asue(astt paramastt, AsyncResult paramAsyncResult) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    if (paramInt1 == 9)
    {
      AppLoaderFactory.g().getActivityResultManager().removeActivityResultListener(this);
      paramIntent = this.val$result;
      if (paramInt2 == 0) {
        bool = true;
      }
      paramIntent.onReceiveResult(bool, null);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asue
 * JD-Core Version:    0.7.0.1
 */