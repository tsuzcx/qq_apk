import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class tye
  implements Runnable
{
  public tye(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    boolean bool = SettingCloneUtil.readValue(this.a.app.getApp(), this.a.app.getAccount(), null, "pcactive_notice_key", false);
    if ((!SettingCloneUtil.readValue(this.a.app.getApp(), this.a.app.getAccount(), null, "pcactive_has_notice", false)) && (bool))
    {
      SettingCloneUtil.writeValue(this.a.app.getApp(), this.a.app.getAccount(), null, "pcactive_has_notice", true);
      Intent localIntent = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
      localIntent.addFlags(268435456);
      localIntent.putExtra("uin", this.a.app.getAccount());
      BaseApplicationImpl.getApplication().startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tye
 * JD-Core Version:    0.7.0.1
 */