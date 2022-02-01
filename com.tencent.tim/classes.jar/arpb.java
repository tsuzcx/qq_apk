import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityActivity.8.5;
import com.tencent.open.agent.AuthorityActivity.8.6;
import com.tencent.open.agent.AuthorityActivity.8.7;
import com.tencent.open.agent.CardContainer;
import com.tencent.protofile.getappinfo.GetAppInfoProto.Ads;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class arpb
  implements Handler.Callback
{
  public arpb(AuthorityActivity paramAuthorityActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    SdkAuthorize.GetAuthApiListResponse localGetAuthApiListResponse;
    int i;
    label269:
    label567:
    Object localObject2;
    Object localObject1;
    switch (paramMessage.what)
    {
    case 10: 
    default: 
    case 0: 
      for (;;)
      {
        return true;
        localGetAuthApiListResponse = (SdkAuthorize.GetAuthApiListResponse)paramMessage.obj;
        if (localGetAuthApiListResponse != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "GET_API_LIST_DONE  response = null");
        }
      }
      i = localGetAuthApiListResponse.ret.get();
      if (i != 0)
      {
        QLog.d("AuthorityActivity", 1, "rec | cmd: G_A_L_D | uin : *" + artw.qx(this.this$0.jdField_a_of_type_Asav.uin) + " | ret : success | code : " + i);
        try
        {
          arts.a().a(this.this$0.jdField_a_of_type_Asav.uin, "", AuthorityActivity.cBq, "1", "6", "" + i, false, true);
          if (TextUtils.isEmpty(localGetAuthApiListResponse.msg.get())) {}
          for (paramMessage = String.format(this.this$0.getResources().getString(2131696651), new Object[] { Integer.valueOf(i) }); i == 110405; paramMessage = String.format(this.this$0.getResources().getString(2131698727), new Object[] { localGetAuthApiListResponse.msg.get(), Integer.valueOf(i) }))
          {
            this.this$0.e(paramMessage, new arpc(this));
            this.this$0.eg(i, paramMessage);
            return true;
          }
          if (i != 110509) {
            break label567;
          }
          if (AuthorityActivity.a(this.this$0) < 0)
          {
            AuthorityActivity.a(this.this$0, 0);
            ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
            asaw.a().a(this.this$0.aIE, this.this$0.c, AuthorityActivity.cBq, 3);
            AuthorityActivity.a(this.this$0).timeCost = System.currentTimeMillis();
          }
          else
          {
            QLog.d("AuthorityActivity", 1, "showLoginActivity GET_API_LIST_DONE 110509 ");
            QQToast.a(this.this$0, 1, acfp.m(2131709374), 0).show();
            this.this$0.WO(this.this$0.aIE);
          }
        }
        catch (JSONException paramMessage) {}
      }
      else
      {
        this.this$0.awk = SystemClock.elapsedRealtime();
        if (!this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.b(localGetAuthApiListResponse)) {
          break label1167;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "rec | cmd: G_A_L_D | authorized");
        }
        this.this$0.dcF = true;
        this.this$0.hA.setText(2131696659);
        this.this$0.hA.setTag(this.this$0.cBo);
        if (localGetAuthApiListResponse.auth_response != null) {
          this.this$0.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = ((SdkAuthorize.AuthorizeResponse)localGetAuthApiListResponse.auth_response.get());
        }
        if ((this.this$0.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null) || (!this.this$0.dcC)) {
          break label907;
        }
        this.this$0.bFf();
        return true;
      }
      if (i == 110513)
      {
        this.this$0.l(110513, "", "", "");
        return true;
      }
      if (i == 110537)
      {
        QLog.d("AuthorityActivity", 1, "GET_API_LIST_DONE 110537");
        QQToast.a(this.this$0, 1, acfp.m(2131709376), 0).show();
        this.this$0.WO(this.this$0.aIE);
        return true;
      }
      if (i == 100044)
      {
        localObject2 = AuthorityActivity.a(this.this$0).getBundleExtra("key_params");
        localObject1 = ((Bundle)localObject2).getString("packagename");
        if (localObject1 != null) {
          break label3811;
        }
        localObject1 = "";
      }
      break;
    }
    label907:
    label1167:
    label2074:
    label2222:
    label2487:
    label2999:
    label3541:
    label3806:
    label3811:
    for (;;)
    {
      Object localObject3 = ((Bundle)localObject2).getString("packagesign");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("uin", this.this$0.jdField_a_of_type_Asav.uin);
      ((Bundle)localObject3).putString("openid", "");
      ((Bundle)localObject3).putString("report_type", "1");
      ((Bundle)localObject3).putString("act_type", "7");
      ((Bundle)localObject3).putString("via", "2");
      ((Bundle)localObject3).putString("app_id", AuthorityActivity.cBq);
      ((Bundle)localObject3).putString("packagename", (String)localObject1);
      ((Bundle)localObject3).putString("stringext_1", (String)localObject2);
      ((Bundle)localObject3).putString("result", "0");
      arts.a().a((Bundle)localObject3, AuthorityActivity.cBq, this.this$0.jdField_a_of_type_Asav.uin, false, true);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("ret", localGetAuthApiListResponse.ret.get());
      ((JSONObject)localObject1).put("msg", localGetAuthApiListResponse.msg.get());
      this.this$0.e(paramMessage, new arpd(this, localGetAuthApiListResponse, (JSONObject)localObject1));
      break label269;
      if (!this.this$0.dcB) {
        this.this$0.hA.setEnabled(true);
      }
      paramMessage = new HashMap();
      paramMessage.put("appid", AuthorityActivity.cBq);
      paramMessage.put("p1", "logged");
      paramMessage.put("p2", "auth");
      anpc.a(this.this$0).collectPerformance(this.this$0.aIE, "connect_sso_pageview", false, System.currentTimeMillis() - this.this$0.abu, 0L, paramMessage, "");
      this.this$0.report("wtl_loggednunauthorized", this.this$0.jdField_a_of_type_Asav.uin);
      if ((this.this$0.dcB) && (this.this$0.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPref", 2, "AutoLogin: " + SystemClock.elapsedRealtime());
        }
        this.this$0.hA.setEnabled(false);
        paramMessage = this.this$0.b.obtainMessage();
        paramMessage.what = 1;
        paramMessage.obj = this.this$0.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
        this.this$0.b.sendMessage(paramMessage);
      }
      if (!AuthorityActivity.a(this.this$0)) {
        this.this$0.jf();
      }
      long l1;
      for (;;)
      {
        l1 = Long.parseLong(AuthorityActivity.cBq);
        this.this$0.mp(l1);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("AuthorityActivity", 2, "rec | cmd: G_A_L_D | not authorized");
        }
        this.this$0.dcF = false;
        this.this$0.hA.setText(2131696659);
        this.this$0.hA.setTag(this.this$0.cBp);
        this.this$0.hA.setEnabled(true);
        paramMessage = new HashMap();
        paramMessage.put("appid", AuthorityActivity.cBq);
        paramMessage.put("p1", "logged");
        paramMessage.put("p2", "uauth");
        anpc.a(this.this$0).collectPerformance(this.this$0.aIE, "connect_sso_pageview", false, System.currentTimeMillis() - this.this$0.abu, 0L, paramMessage, "");
        if (!this.this$0.dcE) {
          this.this$0.report("wtl_loggednauthorized", this.this$0.jdField_a_of_type_Asav.uin);
        }
        this.this$0.jf();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SDKQQAgentPref", 2, "AUTHORIZE_DONE:" + SystemClock.elapsedRealtime());
      }
      localObject1 = (SdkAuthorize.AuthorizeResponse)paramMessage.obj;
      i = ((SdkAuthorize.AuthorizeResponse)localObject1).ret.get();
      if (i != 0)
      {
        QLog.d("AuthorityActivity", 1, "rec | cmd: A_D | uin : *" + artw.qx(this.this$0.jdField_a_of_type_Asav.uin) + " | ret : success | code : " + i);
        try
        {
          localObject2 = ((SdkAuthorize.AuthorizeResponse)localObject1).msg.get();
          if (TextUtils.isEmpty((CharSequence)localObject2)) {}
          for (paramMessage = String.format(this.this$0.getResources().getString(2131696651), new Object[] { Integer.valueOf(i) }); i == 110405; paramMessage = String.format(this.this$0.getResources().getString(2131698727), new Object[] { localObject2, Integer.valueOf(i) }))
          {
            this.this$0.e(paramMessage, new arpe(this));
            label1519:
            this.this$0.eg(i, paramMessage);
            return true;
          }
          if (i != 110509) {
            break label2222;
          }
          if (AuthorityActivity.a(this.this$0) < 1)
          {
            AuthorityActivity.a(this.this$0, 1);
            ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
            asaw.a().a(this.this$0.aIE, this.this$0.c, AuthorityActivity.cBq, 3);
            AuthorityActivity.a(this.this$0).timeCost = System.currentTimeMillis();
          }
          else
          {
            QLog.d("AuthorityActivity", 1, "showLoginActivity AUTHORIZE_DONE 110509");
            QQToast.a(this.this$0, 1, acfp.m(2131709374), 0).show();
            this.this$0.WO(this.this$0.aIE);
          }
        }
        catch (JSONException paramMessage) {}
      }
      else
      {
        this.this$0.WN(((SdkAuthorize.AuthorizeResponse)localObject1).openid.get());
        this.this$0.iE(((SdkAuthorize.AuthorizeResponse)localObject1).openid.get(), ((SdkAuthorize.AuthorizeResponse)localObject1).encrytoken.get());
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
          paramMessage.put("login_cost", this.this$0.awh - this.this$0.awg);
          paramMessage.put("query_authority_cost", this.this$0.awj - this.this$0.awi);
          if (this.this$0.awl != 0L) {
            break label2461;
          }
          paramMessage.put("authority_cost", 0);
          if (((SdkAuthorize.AuthorizeResponse)localObject1).sendinstall.has()) {
            paramMessage.put("sendinstall", ((SdkAuthorize.AuthorizeResponse)localObject1).sendinstall.get());
          }
          if ((((SdkAuthorize.AuthorizeResponse)localObject1).installwording.has()) && (!TextUtils.isEmpty(((SdkAuthorize.AuthorizeResponse)localObject1).installwording.get()))) {
            paramMessage.put("installwording", ((SdkAuthorize.AuthorizeResponse)localObject1).installwording.get());
          }
          if ((!((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.has()) || (((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.size() <= 0)) {
            break label2487;
          }
          localObject2 = ((SdkAuthorize.AuthorizeResponse)localObject1).passDataResp.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (appType.PassData)((Iterator)localObject2).next();
            paramMessage.put(((appType.PassData)localObject3).key.get(), ((appType.PassData)localObject3).value.get());
          }
          localObject1 = new HashMap();
        }
        catch (JSONException paramMessage) {}
        if (!this.this$0.dcI) {
          break label2556;
        }
      }
      label2556:
      for (paramMessage = "1";; paramMessage = "0")
      {
        ((HashMap)localObject1).put("autologin", paramMessage);
        if (!this.this$0.dcE) {
          break label2659;
        }
        if (!this.this$0.dcF) {
          break label2563;
        }
        ((HashMap)localObject1).put("appid", AuthorityActivity.cBq);
        ((HashMap)localObject1).put("p1", "notlogged");
        ((HashMap)localObject1).put("p2", "auth");
        anpc.a(this.this$0).collectPerformance(this.this$0.aIE, "connect_sso_lognback", true, System.currentTimeMillis() - this.this$0.awf, 0L, (HashMap)localObject1, "");
        this.this$0.report("wtl_lognback", this.this$0.jdField_a_of_type_Asav.uin);
        break;
        if (i == 1105030)
        {
          this.this$0.ei(i, (String)localObject2);
          paramMessage = asbp.j(AuthorityActivity.cBq, this.this$0.jdField_a_of_type_Asav.uin);
          if ((paramMessage != null) && (paramMessage.length > 0))
          {
            localObject3 = new SdkAuthorize.AuthorizeResponse();
            try
            {
              paramMessage = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject3).mergeFrom(paramMessage);
              localObject3 = this.this$0.b.obtainMessage();
              ((Message)localObject3).what = 1;
              ((Message)localObject3).obj = paramMessage;
              this.this$0.b.sendMessage((Message)localObject3);
              return true;
            }
            catch (InvalidProtocolBufferMicroException paramMessage) {}
          }
          this.this$0.eh(i, (String)localObject2);
          return true;
        }
        if (i == 100044)
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("ret", ((SdkAuthorize.AuthorizeResponse)localObject1).ret.get());
          ((JSONObject)localObject2).put("msg", ((SdkAuthorize.AuthorizeResponse)localObject1).msg.get());
          this.this$0.e(paramMessage, new arpf(this, (SdkAuthorize.AuthorizeResponse)localObject1, (JSONObject)localObject2));
          break label1519;
        }
        if (i != 110537) {
          break label1519;
        }
        QLog.d("AuthorityActivity", 1, "AUTHORIZE_DONE 110537");
        QQToast.a(this.this$0, 1, acfp.m(2131709376), 0).show();
        this.this$0.WO(this.this$0.aIE);
        break label1519;
        paramMessage.put("authority_cost", this.this$0.awl - this.this$0.awk);
        break label1922;
        if (AuthorityActivity.b(this.this$0))
        {
          ForwardUtils.a(((SdkAuthorize.AuthorizeResponse)localObject1).ret.get(), this.this$0.jdField_a_of_type_Asav);
          arsg.a().c(this.this$0.mParams, true);
          break label2074;
        }
        this.this$0.l(((SdkAuthorize.AuthorizeResponse)localObject1).ret.get(), paramMessage.toString(), null, null);
        break label2074;
      }
      ((HashMap)localObject1).put("appid", AuthorityActivity.cBq);
      ((HashMap)localObject1).put("p1", "notlogged");
      ((HashMap)localObject1).put("p2", "uauth");
      anpc.a(this.this$0).collectPerformance(this.this$0.aIE, "connect_sso_lognback", true, System.currentTimeMillis() - this.this$0.awf, 0L, (HashMap)localObject1, "");
      this.this$0.report("wtl_lognauthorizenback", this.this$0.jdField_a_of_type_Asav.uin);
      break;
      label2659:
      if (this.this$0.dcF)
      {
        ((HashMap)localObject1).put("appid", AuthorityActivity.cBq);
        ((HashMap)localObject1).put("p1", "logged");
        ((HashMap)localObject1).put("p2", "auth");
        anpc.a(this.this$0).collectPerformance(this.this$0.aIE, "connect_sso_lognback", true, System.currentTimeMillis() - this.this$0.awf, 0L, (HashMap)localObject1, "");
        this.this$0.report("wtl_loggednunauthorizedback", this.this$0.jdField_a_of_type_Asav.uin);
        break;
      }
      ((HashMap)localObject1).put("appid", AuthorityActivity.cBq);
      ((HashMap)localObject1).put("p1", "logged");
      ((HashMap)localObject1).put("p2", "uauth");
      anpc.a(this.this$0).collectPerformance(this.this$0.aIE, "connect_sso_lognback", true, System.currentTimeMillis() - this.this$0.awf, 0L, (HashMap)localObject1, "");
      this.this$0.report("wtl_loggednauthorizedback", this.this$0.jdField_a_of_type_Asav.uin);
      break;
      paramMessage = (SdkAuthorize.GetAuthApiListRequest)paramMessage.obj;
      this.this$0.a(paramMessage);
      break;
      paramMessage = (GetAppInfoProto.GetAppinfoResponse)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.appName != null) && (!TextUtils.isEmpty(paramMessage.appName.get())))
      {
        localObject1 = paramMessage.appName.get();
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.F((String)localObject1, null);
        QLog.i("AuthorityActivity", 1, "get app info done, appName is " + (String)localObject1);
      }
      int m;
      int j;
      if ((!this.this$0.dcH) && (paramMessage != null) && (paramMessage.iconsURL != null) && (paramMessage.iconsURL.has()))
      {
        m = 0;
        j = 0;
        i = 0;
        if (i >= paramMessage.iconsURL.get().size()) {
          break label3806;
        }
        localObject1 = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
      }
      for (;;)
      {
        try
        {
          k = Integer.parseInt(((GetAppInfoProto.MsgIconsurl)localObject1).size.get());
          if (k >= 100)
          {
            localObject1 = (GetAppInfoProto.MsgIconsurl)paramMessage.iconsURL.get(i);
            if (localObject1 != null)
            {
              QLog.i("AuthorityActivity", 1, "get app info done, imgUrl is " + localObject1);
              ThreadManager.executeOnNetWorkThread(new AuthorityActivity.8.5(this, (GetAppInfoProto.MsgIconsurl)localObject1));
            }
            if ((this.this$0.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface != null) && (QLog.isColorLevel())) {
              QLog.i("AuthorityActivity", 2, "user uin = " + this.this$0.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getCurrentAccountUin());
            }
            if (paramMessage == null) {
              break label3541;
            }
            if ((paramMessage.ads == null) || (!paramMessage.ads.has())) {
              break label3501;
            }
            paramMessage = (GetAppInfoProto.Ads)paramMessage.ads.get();
            if ((!paramMessage.beginTime.has()) || (!paramMessage.endTime.has())) {
              break label3461;
            }
            l1 = paramMessage.beginTime.get();
            long l2 = paramMessage.endTime.get();
            long l3 = paramMessage.serverTime.get();
            localObject1 = paramMessage.imgURL.get();
            if (QLog.isColorLevel()) {
              QLog.i("AuthorityActivity", 2, "Ads begin time = " + l1 + " endTime = " + l2 + " serverTime = " + l3 + " imgURL = " + (String)localObject1 + " adsTxt = " + paramMessage.txt.get());
            }
            if ((l3 < l1) || (l3 > l2)) {
              break label3436;
            }
            localObject2 = new Message();
            ((Message)localObject2).obj = paramMessage.txt.get();
            ((Message)localObject2).what = 8;
            this.this$0.b.sendMessage((Message)localObject2);
            ThreadManager.executeOnNetWorkThread(new AuthorityActivity.8.6(this, (String)localObject1));
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
        break label2999;
        label3436:
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.dcP = false;
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.WR(null);
        break;
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.dcP = false;
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.WR(null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AuthorityActivity", 2, "Ads begin time or endTime = null");
        break;
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.dcP = false;
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.WR(null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AuthorityActivity", 2, "Ads = null");
        break;
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.dcP = false;
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.WR(null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AuthorityActivity", 2, "response = null");
        break;
        paramMessage = (Bitmap)paramMessage.obj;
        this.this$0.dcH = true;
        QLog.i("AuthorityActivity", 1, "get app icon done");
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.F("", paramMessage);
        break;
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.dcP = true;
        paramMessage = (String)paramMessage.obj;
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.WR(paramMessage);
        break;
        paramMessage = (Bitmap)paramMessage.obj;
        this.this$0.jdField_a_of_type_ComTencentOpenAgentCardContainer.ak(paramMessage);
        break;
        this.this$0.ddP();
        break;
        ThreadManager.postImmediately(new AuthorityActivity.8.7(this), null, true);
        break;
        i = paramMessage.arg1;
        paramMessage = (String)paramMessage.obj;
        this.this$0.eg(i, paramMessage);
        break;
        this.this$0.jf();
        if (this.this$0.dcK) {
          break;
        }
        localObject2 = paramMessage.getData();
        i = ((Bundle)localObject2).getInt("error", -1);
        paramMessage = ((Bundle)localObject2).getString("response");
        String str = ((Bundle)localObject2).getString("msg");
        localObject2 = ((Bundle)localObject2).getString("detail");
        this.this$0.l(i, paramMessage, str, (String)localObject2);
        break;
        i = j;
      }
    }
    label1922:
    label2461:
    label3501:
    return true;
    label2563:
    label3461:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpb
 * JD-Core Version:    0.7.0.1
 */