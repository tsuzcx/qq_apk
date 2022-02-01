import android.os.Bundle;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;

class tft
  implements MiniAppLauncher.MiniAppLaunchListener
{
  tft(tfs paramtfs) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    tkw.i("GdtQQMINIProgramAdapter", String.format("onLaunchResult %b", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tft
 * JD-Core Version:    0.7.0.1
 */