import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityActivity.AccountInfo;
import com.tencent.open.agent.CardContainer;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.PassData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class faj
  extends Handler
{
  public faj(AuthorityActivity paramAuthorityActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1;
    int i;
    label320:
    Object localObject2;
    label644:
    label970:
    label1374:
    label1517:
    int j;
    label1552:
    label1697:
    label1704:
    int m;
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      label1673:
      do
      {
        return;
        localObject1 = (SdkAuthorize.GetAuthApiListResponse)paramMessage.obj;
        i = ((SdkAuthorize.GetAuthApiListResponse)localObject1).ret.get();
        if (i != 0)
        {
          QLog.d("AuthorityActivity", 1, "rec | cmd: G_A_L_D | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a) + " | ret : success" + " | code : " + i);
          if (i != 110405) {}
        }
        else
        {
          for (;;)
          {
            try
            {
              if (!TextUtils.isEmpty(((SdkAuthorize.GetAuthApiListResponse)localObject1).msg.get())) {
                break label320;
              }
              paramMessage = String.format(this.a.getResources().getString(2131363826), new Object[] { Integer.valueOf(i) });
              this.a.a(paramMessage, new fak(this));
              this.a.b(i, paramMessage);
              return;
            }
            catch (JSONException paramMessage) {}
            this.a.i = SystemClock.elapsedRealtime();
            if (((SdkAuthorize.GetAuthApiListResponse)localObject1).redirect_time.has()) {
              this.a.jdField_y_of_type_Int = (((SdkAuthorize.GetAuthApiListResponse)localObject1).redirect_time.get() * 2);
            }
            if (!this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a((SdkAuthorize.GetAuthApiListResponse)localObject1)) {
              break label644;
            }
            this.a.jdField_e_of_type_Boolean = true;
            if ((localObject1 != null) && (((SdkAuthorize.GetAuthApiListResponse)localObject1).auth_response != null)) {
              this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = ((SdkAuthorize.AuthorizeResponse)((SdkAuthorize.GetAuthApiListResponse)localObject1).auth_response.get());
            }
            if ((this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null) || (!this.a.jdField_b_of_type_Boolean)) {
              break;
            }
            this.a.l();
            return;
            paramMessage = String.format(this.a.getResources().getString(2131363830), new Object[] { ((SdkAuthorize.GetAuthApiListResponse)localObject1).msg.get(), Integer.valueOf(i) });
          }
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ret", ((SdkAuthorize.GetAuthApiListResponse)localObject1).ret.get());
        ((JSONObject)localObject2).put("msg", ((SdkAuthorize.GetAuthApiListResponse)localObject1).msg.get());
        if (TextUtils.isEmpty(((SdkAuthorize.GetAuthApiListResponse)localObject1).msg.get())) {}
        for (paramMessage = String.format(this.a.getResources().getString(2131363826), new Object[] { Integer.valueOf(i) });; paramMessage = String.format(this.a.getResources().getString(2131363830), new Object[] { ((SdkAuthorize.GetAuthApiListResponse)localObject1).msg.get(), Integer.valueOf(i) }))
        {
          this.a.a(paramMessage, new fal(this, (SdkAuthorize.GetAuthApiListResponse)localObject1, (JSONObject)localObject2));
          break;
        }
        this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        paramMessage = new HashMap();
        paramMessage.put("appid", AuthorityActivity.A);
        paramMessage.put("p1", "logged");
        paramMessage.put("p2", "auth");
        StatisticCollector.a(this.a).a(this.a.m, "connect_sso_pageview", false, System.currentTimeMillis() - this.a.jdField_b_of_type_Long, 0L, paramMessage, "");
        this.a.b("wtl_loggednunauthorized", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
        this.a.m();
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          long l = Long.parseLong(AuthorityActivity.A);
          this.a.a(l);
          return;
          this.a.jdField_e_of_type_Boolean = false;
          this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.jdField_y_of_type_JavaLangString);
          this.a.setTitle(2131363821);
          paramMessage = new HashMap();
          paramMessage.put("appid", AuthorityActivity.A);
          paramMessage.put("p1", "logged");
          paramMessage.put("p2", "uauth");
          StatisticCollector.a(this.a).a(this.a.m, "connect_sso_pageview", false, System.currentTimeMillis() - this.a.jdField_b_of_type_Long, 0L, paramMessage, "");
          if (!this.a.d) {
            this.a.b("wtl_loggednauthorized", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
          }
          this.a.c();
        }
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPref", 2, "AUTHORIZE_DONE:" + SystemClock.elapsedRealtime());
        }
        localObject1 = (SdkAuthorize.AuthorizeResponse)paramMessage.obj;
        i = ((SdkAuthorize.AuthorizeResponse)localObject1).ret.get();
        Object localObject3;
        if (i != 0)
        {
          QLog.d("AuthorityActivity", 1, "rec | cmd: A_D | uin : *" + AuthorityUtil.a(this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a) + " | ret : success" + " | code : " + i);
          try
          {
            localObject2 = ((SdkAuthorize.AuthorizeResponse)localObject1).msg.get();
            paramMessage = "";
            if (i != 110405) {
              break label1552;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1517;
            }
            paramMessage = String.format(this.a.getResources().getString(2131363826), new Object[] { Integer.valueOf(i) });
            this.a.a(paramMessage, new fam(this));
            this.a.b(i, paramMessage);
            return;
          }
          catch (JSONException paramMessage) {}
        }
        else
        {
          this.a.b(((SdkAuthorize.AuthorizeResponse)localObject1).openid.get());
          this.a.a(((SdkAuthorize.AuthorizeResponse)localObject1).openid.get(), ((SdkAuthorize.AuthorizeResponse)localObject1).encrytoken.get());
          try
          {
            paramMessage = new JSONObject();
            paramMessage.put("ret", ((SdkAuthorize.AuthorizeResponse)localObject1).ret.get());
            paramMessage.put("openid", ((SdkAuthorize.AuthorizeResponse)localObject1).openid.get());
            paramMessage.put("access_token", ((SdkAuthorize.AuthorizeResponse)localObject1).access_token.get());
            paramMessage.put("pay_token", ((SdkAuthorize.AuthorizeResponse)localObject1).pay_token.get());
            paramMessage.put("expires_in", ((SdkAuthorize.AuthorizeResponse)localObject1).expires_in.get());
            paramMessage.put("pf", ((SdkAuthorize.AuthorizeResponse)localObject1).pf.get());
            paramMessage.put("pfkey", ((SdkAuthorize.AuthorizeResponse)localObject1).pfkey.get());
            paramMessage.put("msg", ((SdkAuthorize.AuthorizeResponse)localObject1).msg.get());
            paramMessage.put("login_cost", this.a.jdField_f_of_type_Long - this.a.jdField_e_of_type_Long);
            paramMessage.put("query_authority_cost", this.a.h - this.a.jdField_g_of_type_Long);
            paramMessage.put("authority_cost", this.a.j - this.a.i);
            if (((SdkAuthorize.AuthorizeResponse)localObject1).sendinstall.has()) {
              paramMessage.put("sendinstall", ((SdkAuthorize.AuthorizeResponse)localObject1).sendinstall.get());
            }
            if ((((SdkAuthorize.AuthorizeResponse)localObject1).installwording.has()) && (!TextUtils.isEmpty(((SdkAuthorize.AuthorizeResponse)localObject1).installwording.get()))) {
              paramMessage.put("installwording", ((SdkAuthorize.AuthorizeResponse)localObject1).installwording.get());
            }
            if ((!((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.has()) || (((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.size() <= 0)) {
              break label1673;
            }
            localObject2 = ((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.get().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (SdkAuthorize.PassData)((Iterator)localObject2).next();
              paramMessage.put(((SdkAuthorize.PassData)localObject3).key.get(), ((SdkAuthorize.PassData)localObject3).value.get());
            }
            localObject1 = new HashMap();
          }
          catch (JSONException paramMessage) {}
          if (!this.a.jdField_g_of_type_Boolean) {
            break label1697;
          }
        }
        for (paramMessage = "1";; paramMessage = "0")
        {
          ((HashMap)localObject1).put("autologin", paramMessage);
          if (!this.a.d) {
            break label1795;
          }
          if (!this.a.jdField_e_of_type_Boolean) {
            break label1704;
          }
          ((HashMap)localObject1).put("appid", AuthorityActivity.A);
          ((HashMap)localObject1).put("p1", "notlogged");
          ((HashMap)localObject1).put("p2", "auth");
          StatisticCollector.a(this.a).a(this.a.m, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.c, 0L, (HashMap)localObject1, "");
          this.a.b("wtl_lognback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
          return;
          paramMessage = String.format(this.a.getResources().getString(2131363830), new Object[] { localObject2, Integer.valueOf(i) });
          break;
          if (i != 110503) {
            break label970;
          }
          this.a.d(i, (String)localObject2);
          paramMessage = this.a.a(AuthorityActivity.A, this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
          if ((paramMessage != null) && (paramMessage.length > 0))
          {
            localObject3 = new SdkAuthorize.AuthorizeResponse();
            try
            {
              paramMessage = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject3).mergeFrom(paramMessage);
              if (localObject1 != null)
              {
                localObject3 = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
                ((Message)localObject3).what = 1;
                ((Message)localObject3).obj = paramMessage;
                this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject3);
                return;
              }
            }
            catch (InvalidProtocolBufferMicroException paramMessage) {}
          }
          this.a.c(i, (String)localObject2);
          return;
          this.a.a(((SdkAuthorize.AuthorizeResponse)localObject1).ret.get(), paramMessage.toString(), null, null);
          break label1374;
        }
        ((HashMap)localObject1).put("appid", AuthorityActivity.A);
        ((HashMap)localObject1).put("p1", "notlogged");
        ((HashMap)localObject1).put("p2", "uauth");
        StatisticCollector.a(this.a).a(this.a.m, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.c, 0L, (HashMap)localObject1, "");
        this.a.b("wtl_lognauthorizenback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
        return;
        if (this.a.jdField_e_of_type_Boolean)
        {
          ((HashMap)localObject1).put("appid", AuthorityActivity.A);
          ((HashMap)localObject1).put("p1", "logged");
          ((HashMap)localObject1).put("p2", "auth");
          StatisticCollector.a(this.a).a(this.a.m, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.c, 0L, (HashMap)localObject1, "");
          this.a.b("wtl_loggednunauthorizedback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
          return;
        }
        ((HashMap)localObject1).put("appid", AuthorityActivity.A);
        ((HashMap)localObject1).put("p1", "logged");
        ((HashMap)localObject1).put("p2", "uauth");
        StatisticCollector.a(this.a).a(this.a.m, "connect_sso_lognback", true, System.currentTimeMillis() - this.a.c, 0L, (HashMap)localObject1, "");
        this.a.b("wtl_loggednauthorizedback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
        return;
        paramMessage = (SdkAuthorize.GetAuthApiListRequest)paramMessage.obj;
        this.a.a(paramMessage);
        return;
        paramMessage = (GetAppInfoProto.GetAppinfoResponse)paramMessage.obj;
        if ((paramMessage != null) && (paramMessage.appName != null) && (!TextUtils.isEmpty(paramMessage.appName.get())))
        {
          localObject1 = paramMessage.appName.get();
          this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a((String)localObject1, null);
        }
      } while ((this.a.jdField_f_of_type_Boolean) || (!paramMessage.iconsURL.has()));
      label1795:
      i = 0;
      j = 0;
      m = 0;
      label2082:
      if (i < paramMessage.iconsURL.get().size()) {
        localObject1 = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
      }
      break;
    }
    for (;;)
    {
      try
      {
        k = Integer.parseInt(((GetAppInfoProto.MsgIconsurl)localObject1).size.get());
        if (k >= 100)
        {
          paramMessage = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
          if (paramMessage == null) {
            break;
          }
          ThreadManager.a(new fan(this, paramMessage));
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int k = 0;
        continue;
        int n = m;
        if (k > m)
        {
          j = i;
          n = k;
        }
        i += 1;
        m = n;
      }
      break label2082;
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_f_of_type_Boolean = true;
      this.a.jdField_a_of_type_ComTencentOpenAgentCardContainer.a("", paramMessage);
      return;
      this.a.c();
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getResources().getString(2131363829));
      if ((this.a.isFinishing()) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
      i = paramMessage.arg1;
      paramMessage = (String)paramMessage.obj;
      this.a.b(i, paramMessage);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (this.a.k) {
        break;
      }
      localObject2 = paramMessage.getData();
      i = ((Bundle)localObject2).getInt("error", -1);
      paramMessage = ((Bundle)localObject2).getString("response");
      String str = ((Bundle)localObject2).getString("msg");
      localObject2 = ((Bundle)localObject2).getString("detail");
      this.a.b(i, paramMessage, str, (String)localObject2);
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     faj
 * JD-Core Version:    0.7.0.1
 */