import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.BusinessObserver;

public class arpa
  implements BusinessObserver
{
  public arpa(AuthorityActivity paramAuthorityActivity, boolean paramBoolean, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    AuthorityActivity.d(this.this$0).timeCost = (System.currentTimeMillis() - AuthorityActivity.d(this.this$0).timeCost);
    Object localObject = paramBundle.getString("ssoAccount");
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityActivity", 2, "-->doAuthorize-onReceive, ssoAccount: " + (String)localObject + " | uin: " + this.this$0.a.uin);
    }
    if (!this.this$0.a.uin.equals(localObject)) {
      return;
    }
    this.this$0.hA.setEnabled(true);
    this.this$0.b.removeCallbacks(this.this$0.ic);
    paramInt = paramBundle.getInt("code");
    SdkAuthorize.AuthorizeResponse localAuthorizeResponse;
    if (paramBoolean)
    {
      this.this$0.ekI = 0;
      localAuthorizeResponse = new SdkAuthorize.AuthorizeResponse();
    }
    label1177:
    for (;;)
    {
      try
      {
        localObject = paramBundle.getByteArray("data");
        if (!this.dcO) {
          break label1177;
        }
        localObject = asbp.b((byte[])localObject, this.this$0.a);
        if (localObject != null)
        {
          l1 = localObject.length;
          localAuthorizeResponse = (SdkAuthorize.AuthorizeResponse)localAuthorizeResponse.mergeFrom((byte[])localObject);
          if (localAuthorizeResponse != null)
          {
            Message localMessage = this.this$0.b.obtainMessage();
            localMessage.what = 1;
            localMessage.obj = localAuthorizeResponse;
            this.this$0.b.sendMessage(localMessage);
            if (localAuthorizeResponse.ret.get() == 0) {
              asbp.a(AuthorityActivity.cBq, this.this$0.a.uin, localAuthorizeResponse.expires_in.get(), (byte[])localObject);
            }
            i = localAuthorizeResponse.toByteArray().length;
            l2 = i;
          }
        }
      }
      catch (Exception paramBundle)
      {
        long l1;
        int i;
        long l2;
        localObject = this.this$0.b.obtainMessage();
        ((Message)localObject).what = 6;
        ((Message)localObject).arg1 = 3002;
        ((Message)localObject).obj = this.this$0.getResources().getString(2131696664);
        this.this$0.b.sendMessage((Message)localObject);
        localObject = (String)((Message)localObject).obj;
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + this.val$cmd + " | uin : *" + artw.qx(this.this$0.a.uin) + " | ret : success | code : " + paramInt, paramBundle);
        AuthorityActivity.a(this.this$0, "KEY_AUTHORIZE_REQUEST", this.this$0.ekI, false);
        continue;
      }
      try
      {
        i = localAuthorizeResponse.ret.get();
        localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "103");
        ((Bundle)localObject).putString("act_type", "13");
        if (!paramBundle.getBoolean("isShort", false)) {
          continue;
        }
        paramBundle = "2";
        ((Bundle)localObject).putString("intext_3", paramBundle);
        ((Bundle)localObject).putString("stringext_1", AuthorityActivity.d(this.this$0).clW);
        ((Bundle)localObject).putString("intext_2", "" + i);
        ((Bundle)localObject).putString("intext_5", "" + AuthorityActivity.d(this.this$0).timeCost);
        arts.a().a((Bundle)localObject, AuthorityActivity.cBq, this.this$0.aIE, false, true);
        arxy.a().b("agent_authority", this.this$0.awk, l1, l2, 0, Long.parseLong(this.this$0.a.uin), "1000069", "ret: " + i, true);
        aryb.a().b(0, "LOGIN_AUTH", this.this$0.a.uin, AuthorityActivity.cBq, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
        AuthorityActivity.a(this.this$0, "KEY_AUTHORIZE_REQUEST", this.this$0.ekI, true);
      }
      catch (Exception paramBundle)
      {
        arwt.e("AuthorityActivity", "-->success report exception cmd: agent_authority", paramBundle);
        continue;
      }
      QLog.d("AuthorityActivity", 1, "rec | cmd: " + this.val$cmd + " | uin : *" + artw.qx(this.this$0.a.uin) + " | ret : success | code : " + paramInt);
      this.this$0.awl = SystemClock.elapsedRealtime();
      arwt.d("Authority_TimeCost", "<TimeStamp> authority cost : " + (this.this$0.awl - this.this$0.awk));
      return;
      paramBundle = "1";
      continue;
      QLog.d("AuthorityActivity", 1, "rec | cmd: " + this.val$cmd + " | uin : *" + artw.qx(this.this$0.a.uin) + " | ret : failed | code : " + paramInt);
      if ((paramInt == 1002) && (this.this$0.ekI < 2))
      {
        paramBundle = this.this$0;
        paramBundle.ekI += 1;
        this.this$0.bFf();
        return;
      }
      paramBundle = this.this$0.b.obtainMessage();
      paramBundle.what = 6;
      paramBundle.arg1 = 3002;
      paramBundle.obj = this.this$0.getResources().getString(2131696664);
      this.this$0.b.sendMessage(paramBundle);
      AuthorityActivity.a(this.this$0, "KEY_AUTHORIZE_REQUEST", this.this$0.ekI, false);
      paramBundle = this.this$0.getResources().getString(2131696664);
      try
      {
        arxy.a().b("agent_authority", this.this$0.awk, 0L, 0L, paramInt, Long.parseLong(this.this$0.a.uin), "1000069", paramBundle, true);
        aryb.a().b(1, "LOGIN_AUTH", this.this$0.a.uin, AuthorityActivity.cBq, null, Long.valueOf(SystemClock.elapsedRealtime()), 3002, 1, paramBundle);
        arts.a().a(this.this$0.a.uin, "", AuthorityActivity.cBq, "1", "6", "" + 3002, false, true);
      }
      catch (Exception paramBundle)
      {
        arwt.e("AuthorityActivity", "-->failed report exception cmd: agent_authority", paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpa
 * JD-Core Version:    0.7.0.1
 */