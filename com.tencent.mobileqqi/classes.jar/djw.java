import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class djw
  implements BusinessObserver
{
  public djw(SplashActivity paramSplashActivity) {}
  
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
          mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          localGetPublicAccountDetailInfoResponse.mergeFrom(paramBundle);
          if ((localGetPublicAccountDetailInfoResponse.ret_info.has()) && (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.has()) && (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0))
          {
            if ((this.a.a == null) || ((this.a.a != null) && (localGetPublicAccountDetailInfoResponse.seqno.has()) && (localGetPublicAccountDetailInfoResponse.seqno.get() != this.a.a.seqno)))
            {
              SplashActivity.a(this.a, localGetPublicAccountDetailInfoResponse);
              new AccountDetail(SplashActivity.a(this.a));
              paramBundle = this.a.getSharedPreferences(this.a.b.a(), 0);
              if ((paramBundle != null) && (paramBundle.getBoolean("qqi_public_account_first_login", true)))
              {
                SplashActivity.d(this.a);
                paramBundle.edit().putBoolean("qqi_public_account_first_login", false).commit();
              }
            }
          }
          else {
            SplashActivity.e(this.a);
          }
        }
        else
        {
          SplashActivity.e(this.a);
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
    SplashActivity.e(this.a);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     djw
 * JD-Core Version:    0.7.0.1
 */