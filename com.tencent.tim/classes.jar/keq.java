import android.os.Bundle;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener;
import com.tencent.qphone.base.util.QLog;

public class keq
  implements MiniAppLauncher.MiniAppLaunchListener
{
  public keq(CustomTabView paramCustomTabView) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("EcshopCustomTabView", 2, "onLaunchResult" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     keq
 * JD-Core Version:    0.7.0.1
 */