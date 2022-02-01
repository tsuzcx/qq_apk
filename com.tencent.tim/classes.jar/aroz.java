import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.BusinessObserver;

public class aroz
  implements BusinessObserver
{
  public aroz(AuthorityActivity paramAuthorityActivity, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("AuthorityActivity", 1, "getAppInfo observer onReceive isSuccess = " + paramBoolean);
    ahlw.a("KEY_GET_APP_INFO_REQUEST", this.this$0.a, paramBoolean);
    AuthorityActivity.c(this.this$0).timeCost = (System.currentTimeMillis() - AuthorityActivity.c(this.this$0).timeCost);
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.this$0.a.uin.equals(localObject)) {
      QLog.e("AuthorityActivity", 1, "mAccount.uin != ssoAccount");
    }
    do
    {
      return;
      this.this$0.b.removeCallbacks(this.this$0.ic);
    } while (!paramBoolean);
    GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("data");
        localObject = arrayOfByte;
        if (this.dcO) {
          localObject = asbp.b(arrayOfByte, this.this$0.a);
        }
        if (localObject == null) {
          break;
        }
        localGetAppinfoResponse.mergeFrom((byte[])localObject);
        if (!localGetAppinfoResponse.has()) {
          break;
        }
        paramInt = localGetAppinfoResponse.ret.get();
        if (paramInt == 0)
        {
          localObject = this.this$0.b.obtainMessage();
          ((Message)localObject).what = 3;
          ((Message)localObject).obj = localGetAppinfoResponse;
          this.this$0.b.sendMessage((Message)localObject);
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "103");
        ((Bundle)localObject).putString("act_type", "12");
        if (paramBundle.getBoolean("isShort", false))
        {
          paramBundle = "2";
          ((Bundle)localObject).putString("intext_3", paramBundle);
          ((Bundle)localObject).putString("stringext_1", AuthorityActivity.c(this.this$0).clW);
          ((Bundle)localObject).putString("intext_2", "" + paramInt);
          ((Bundle)localObject).putString("intext_5", "" + AuthorityActivity.c(this.this$0).timeCost);
          arts.a().a((Bundle)localObject, AuthorityActivity.cBq, this.this$0.aIE, false, true);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("AuthorityActivity", 1, "getAppInfoResponse deal exception : " + paramBundle.getMessage());
        paramBundle.printStackTrace();
        return;
      }
      paramBundle = "1";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aroz
 * JD-Core Version:    0.7.0.1
 */