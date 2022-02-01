import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.BusinessObserver;

public class arox
  implements BusinessObserver
{
  public arox(AuthorityActivity paramAuthorityActivity, boolean paramBoolean, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    AuthorityActivity.b(this.this$0).timeCost = (System.currentTimeMillis() - AuthorityActivity.b(this.this$0).timeCost);
    Object localObject1 = paramBundle.getString("ssoAccount");
    if (!this.this$0.jdField_a_of_type_Asav.uin.equals(localObject1)) {
      return;
    }
    this.this$0.b.removeCallbacks(this.this$0.ic);
    if (!this.this$0.dcB) {
      this.this$0.hA.setEnabled(true);
    }
    paramInt = paramBundle.getInt("code");
    Object localObject2;
    if (paramBoolean)
    {
      this.this$0.ekH = 0;
      localObject2 = new SdkAuthorize.GetAuthApiListResponse();
    }
    label1287:
    for (;;)
    {
      try
      {
        localObject1 = paramBundle.getByteArray("data");
        if (!this.dcO) {
          break label1287;
        }
        localObject1 = asbp.b((byte[])localObject1, this.this$0.jdField_a_of_type_Asav);
        if (localObject1 != null)
        {
          l1 = localObject1.length;
          localObject2 = (SdkAuthorize.GetAuthApiListResponse)((SdkAuthorize.GetAuthApiListResponse)localObject2).mergeFrom((byte[])localObject1);
          if (localObject2 != null)
          {
            Message localMessage = this.this$0.b.obtainMessage();
            localMessage.what = 0;
            localMessage.obj = localObject2;
            this.this$0.b.sendMessage(localMessage);
            i = ((SdkAuthorize.GetAuthApiListResponse)localObject2).toByteArray().length;
            l2 = i;
          }
        }
      }
      catch (Exception paramBundle)
      {
        long l1;
        long l2;
        localObject1 = this.this$0.b.obtainMessage();
        ((Message)localObject1).what = 6;
        ((Message)localObject1).arg1 = 3001;
        ((Message)localObject1).obj = this.this$0.getResources().getString(2131696654);
        this.this$0.b.sendMessage((Message)localObject1);
        localObject1 = (String)((Message)localObject1).obj;
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + this.val$cmd + " | uin : *" + artw.qx(this.this$0.jdField_a_of_type_Asav.uin) + " | ret : success | code : " + paramInt, paramBundle);
        AuthorityActivity.a(this.this$0, "KEY_GET_AUTH_API_LIST_REQUEST", this.this$0.ekH, false);
        continue;
        int i = localObject1.length;
        paramBundle = Integer.valueOf(i);
        continue;
      }
      try
      {
        i = ((SdkAuthorize.GetAuthApiListResponse)localObject2).ret.get();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("report_type", "103");
        ((Bundle)localObject2).putString("act_type", "11");
        if (!paramBundle.getBoolean("isShort", false)) {
          continue;
        }
        paramBundle = "2";
        ((Bundle)localObject2).putString("intext_3", paramBundle);
        ((Bundle)localObject2).putString("stringext_1", AuthorityActivity.b(this.this$0).clW);
        ((Bundle)localObject2).putString("intext_2", "" + i);
        ((Bundle)localObject2).putString("intext_5", "" + AuthorityActivity.b(this.this$0).timeCost);
        arts.a().a((Bundle)localObject2, AuthorityActivity.cBq, this.this$0.aIE, false, true);
        paramBundle = new Bundle();
        paramBundle.putString("report_type", "103");
        paramBundle.putString("act_type", "14");
        paramBundle.putString("intext_5", "" + (System.currentTimeMillis() - this.this$0.abu));
        arts.a().a(paramBundle, AuthorityActivity.cBq, this.this$0.aIE, false, true);
        arxy.a().b("agent_query_authority", this.this$0.awi, l1, l2, 0, Long.parseLong(this.this$0.jdField_a_of_type_Asav.uin), "1000069", "ret: " + i, true);
        aryb.a().b(0, "LOGIN_GETAUTHLIST_AGENT", this.this$0.jdField_a_of_type_Asav.uin, AuthorityActivity.cBq, null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
        arts.a().a(this.this$0.jdField_a_of_type_Asav.uin, "", AuthorityActivity.cBq, "1", "2", "0", false, true);
        AuthorityActivity.a(this.this$0, "KEY_GET_AUTH_API_LIST_REQUEST", this.this$0.ekH, true);
      }
      catch (Exception paramBundle)
      {
        arwt.e("AuthorityActivity", "-->report exception cmd: agent_query_authority", paramBundle);
        continue;
      }
      localObject2 = new StringBuilder().append("rec | cmd: ").append(this.val$cmd).append(" | uin : *").append(artw.qx(this.this$0.jdField_a_of_type_Asav.uin)).append(" | ret : success | code : ").append(paramInt).append(" | data=");
      if (localObject1 == null)
      {
        paramBundle = "null";
        QLog.d("AuthorityActivity", 1, paramBundle);
        this.this$0.awj = SystemClock.elapsedRealtime();
        arwt.d("Authority_TimeCost", "<TimeStamp> query authority cost : " + (this.this$0.awj - this.this$0.awi));
        return;
        paramBundle = "1";
      }
      else
      {
        QLog.d("AuthorityActivity", 1, "rec | cmd: " + this.val$cmd + " | uin : *" + artw.qx(this.this$0.jdField_a_of_type_Asav.uin) + " | ret : failed | code : " + paramInt);
        this.this$0.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
        if ((paramInt == 1002) && (this.this$0.ekH < 2))
        {
          paramBundle = this.this$0;
          paramBundle.ekH += 1;
          this.this$0.ekT();
          return;
        }
        paramBundle = this.this$0.b.obtainMessage();
        paramBundle.what = 6;
        paramBundle.arg1 = 3001;
        paramBundle.obj = this.this$0.getResources().getString(2131696654);
        this.this$0.b.sendMessage(paramBundle);
        AuthorityActivity.a(this.this$0, "KEY_GET_AUTH_API_LIST_REQUEST", this.this$0.ekH, false);
        paramBundle = this.this$0.getResources().getString(2131696654);
        try
        {
          arxy.a().b("agent_query_authority", this.this$0.awi, 0L, 0L, paramInt, Long.parseLong(this.this$0.jdField_a_of_type_Asav.uin), "1000069", paramBundle, true);
          aryb.a().b(1, "LOGIN_GETAUTHLIST_AGENT", this.this$0.jdField_a_of_type_Asav.uin, AuthorityActivity.cBq, null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt, 1, paramBundle);
          arts.a().a(this.this$0.jdField_a_of_type_Asav.uin, "", AuthorityActivity.cBq, "1", "2", "" + paramInt, false, true);
          arts.a().a(this.this$0.jdField_a_of_type_Asav.uin, "", AuthorityActivity.cBq, "1", "6", "" + paramInt, false, true);
        }
        catch (Exception paramBundle) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arox
 * JD-Core Version:    0.7.0.1
 */