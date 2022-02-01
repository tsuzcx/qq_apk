import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;

public class arqy
  extends acnd
{
  public arqy(JoinTroopPreVerificationFragment paramJoinTroopPreVerificationFragment) {}
  
  protected void z(boolean paramBoolean, String paramString1, String paramString2)
  {
    this.a.hideProgress();
    QLog.i("TroopAbility.PreVerification", 1, "onGetJoinTroopTokenForThirdApp, isSuccess: " + paramBoolean + " token: " + paramString1 + ", troopUin: " + paramString2);
    if (paramBoolean)
    {
      paramString2 = TroopInfoActivity.c(String.valueOf(paramString2), 32);
      paramString2.putString("authSig", paramString1);
      paramString2.putString("appid", this.a.mAppId);
      paramString2.putBoolean("fromThirdAppByOpenSDK", true);
      paramString2.putInt("action", 3);
      paramString2.putString("pkg_name", this.a.mPkgName);
      paramString2.putString("app_name", this.a.mAppName);
      apuh.a(this.a.mActivity, paramString2, 2);
      this.a.mActivity.finish();
      return;
    }
    this.a.WQ(acfp.m(2131707524));
    this.a.mActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arqy
 * JD-Core Version:    0.7.0.1
 */