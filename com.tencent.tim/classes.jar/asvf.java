import android.content.Intent;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class asvf
  implements IActivityResultListener
{
  asvf(asuz paramasuz, IMiniAppContext paramIMiniAppContext) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1002) && (paramInt2 == -1))
    {
      AppLoaderFactory.g().getActivityResultManager().removeActivityResultListener(this);
      String str = paramIntent.getStringExtra("uin");
      paramIntent = paramIntent.getStringExtra("uinname");
      QLog.d("MiniAppProxyImpl", 1, "group uin: " + str + ", group name: " + paramIntent);
      TroopApplicationListUtil.addMiniAppToTroopApplicationList(str, this.val$miniAppContext.getMiniAppInfo().appId, null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvf
 * JD-Core Version:    0.7.0.1
 */