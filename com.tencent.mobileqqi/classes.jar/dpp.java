import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class dpp
  implements BusinessObserver
{
  public dpp(SplashActivity paramSplashActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("SplashActivity", 2, "success:" + String.valueOf(paramBoolean));
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
          localFollowResponse.mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
          if (paramInt == 0)
          {
            SplashActivity.f(this.a);
            this.a.getSharedPreferences(this.a.b.a(), 0).edit().putBoolean("qqi_public_account", true).commit();
            return;
          }
          if (paramInt != 58)
          {
            SplashActivity.g(this.a);
            return;
          }
        }
      }
      catch (Exception paramBundle) {}
    }
    SplashActivity.g(this.a);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dpp
 * JD-Core Version:    0.7.0.1
 */