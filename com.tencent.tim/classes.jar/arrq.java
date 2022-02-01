import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenAuthorityFragment.8.4;
import com.tencent.open.agent.OpenAuthorityFragment.8.5;
import com.tencent.open.agent.OpenAuthorityFragment.8.6;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.protofile.getappinfo.GetAppInfoProto.Ads;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class arrq
  implements Handler.Callback
{
  public arrq(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    preAuth.PreAuthResponse localPreAuthResponse;
    int i;
    switch (paramMessage.what)
    {
    case 2: 
    case 10: 
    default: 
    case 0: 
      for (;;)
      {
        return true;
        localPreAuthResponse = (preAuth.PreAuthResponse)paramMessage.obj;
        OpenAuthorityFragment.a(this.this$0, localPreAuthResponse);
        if (localPreAuthResponse != null) {
          break;
        }
        this.this$0.jf();
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "GET_API_LIST_DONE  response = null");
      }
      i = localPreAuthResponse.ret.get();
      if (i != 0) {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: G_A_L_D | uin : *" + artw.qx(OpenAuthorityFragment.a(this.this$0).uin) + " | ret : success | code : " + i);
      }
      break;
    }
    label2216:
    label3385:
    label3390:
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        Object localObject3;
        try
        {
          arts.a().a(OpenAuthorityFragment.a(this.this$0).uin, "", OpenAuthorityFragment.a(this.this$0), "1", "6", "" + i, false, true);
          if (TextUtils.isEmpty(localPreAuthResponse.msg.get()))
          {
            paramMessage = String.format(this.this$0.getResources().getString(2131696651), new Object[] { Integer.valueOf(i) });
            if (i == 110405)
            {
              this.this$0.e(paramMessage, new arrr(this));
              OpenAuthorityFragment.a(this.this$0, i, paramMessage);
              return true;
            }
          }
          else
          {
            paramMessage = String.format(this.this$0.getResources().getString(2131698727), new Object[] { localPreAuthResponse.msg.get(), Integer.valueOf(i) });
            continue;
          }
          if ((i == 110509) && (OpenAuthorityFragment.d(this.this$0) < 0))
          {
            OpenAuthorityFragment.b(this.this$0, 0);
            ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
            asaw.a().a(OpenAuthorityFragment.b(this.this$0), this.this$0.c, OpenAuthorityFragment.a(this.this$0), 3);
            OpenAuthorityFragment.a(this.this$0).timeCost = System.currentTimeMillis();
            return true;
          }
          if (i == 110513)
          {
            this.this$0.l(110513, "", "", "");
            return true;
          }
          if (i == 100044)
          {
            localObject2 = this.this$0.getActivity().getIntent().getBundleExtra("key_params");
            localObject1 = ((Bundle)localObject2).getString("packagename");
            if (localObject1 != null) {
              break label3390;
            }
            localObject1 = "";
            localObject3 = ((Bundle)localObject2).getString("packagesign");
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("uin", OpenAuthorityFragment.a(this.this$0).uin);
            ((Bundle)localObject3).putString("openid", "");
            ((Bundle)localObject3).putString("report_type", "1");
            ((Bundle)localObject3).putString("act_type", "7");
            ((Bundle)localObject3).putString("via", "2");
            ((Bundle)localObject3).putString("app_id", OpenAuthorityFragment.a(this.this$0));
            ((Bundle)localObject3).putString("packagename", (String)localObject1);
            ((Bundle)localObject3).putString("stringext_1", (String)localObject2);
            ((Bundle)localObject3).putString("result", "0");
            arts.a().a((Bundle)localObject3, OpenAuthorityFragment.a(this.this$0), OpenAuthorityFragment.a(this.this$0).uin, false, true);
          }
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("ret", localPreAuthResponse.ret.get());
          ((JSONObject)localObject1).put("msg", localPreAuthResponse.msg.get());
          this.this$0.e(paramMessage, new arrs(this, localPreAuthResponse, (JSONObject)localObject1));
          continue;
          OpenAuthorityFragment.c(this.this$0, SystemClock.elapsedRealtime());
        }
        catch (JSONException paramMessage) {}
        OpenAuthorityFragment.a(this.this$0).bA(OpenAuthorityFragment.a(this.this$0), OpenAuthorityFragment.e(this.this$0));
        if (OpenAuthorityFragment.a(this.this$0).i(OpenAuthorityFragment.a(this.this$0).a().bl(OpenAuthorityFragment.a(this.this$0)), localPreAuthResponse.authorized_union_text.get()))
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: G_A_L_D | authorized");
          OpenAuthorityFragment.b(this.this$0, true);
          OpenAuthorityFragment.a(this.this$0).setTag(OpenAuthorityFragment.e(this.this$0));
          if (!OpenAuthorityFragment.c(this.this$0)) {
            OpenAuthorityFragment.a(this.this$0).setEnabled(true);
          }
          paramMessage = new HashMap();
          paramMessage.put("appid", OpenAuthorityFragment.a(this.this$0));
          paramMessage.put("p1", "logged");
          paramMessage.put("p2", "auth");
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.this$0), "connect_sso_pageview", false, System.currentTimeMillis() - OpenAuthorityFragment.c(this.this$0), 0L, paramMessage, "");
          this.this$0.report("wtl_loggednunauthorized", OpenAuthorityFragment.a(this.this$0).uin);
          if ((OpenAuthorityFragment.c(this.this$0)) && (OpenAuthorityFragment.a(this.this$0) != null))
          {
            QLog.d("SDKQQAgentPref", 1, "AutoLogin");
            OpenAuthorityFragment.a(this.this$0).setEnabled(false);
            paramMessage = this.this$0.b.obtainMessage();
            paramMessage.what = 1;
            paramMessage.obj = OpenAuthorityFragment.a(this.this$0);
            this.this$0.b.sendMessage(paramMessage);
          }
          if (!OpenAuthorityFragment.d(this.this$0)) {
            this.this$0.jf();
          }
        }
        for (;;)
        {
          OpenAuthorityFragment.a(this.this$0);
          break;
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: G_A_L_D | not authorized");
          OpenAuthorityFragment.b(this.this$0, false);
          OpenAuthorityFragment.a(this.this$0).setTag(OpenAuthorityFragment.d(this.this$0));
          OpenAuthorityFragment.a(this.this$0).setEnabled(true);
          paramMessage = new HashMap();
          paramMessage.put("appid", OpenAuthorityFragment.a(this.this$0));
          paramMessage.put("p1", "logged");
          paramMessage.put("p2", "uauth");
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.this$0), "connect_sso_pageview", false, System.currentTimeMillis() - OpenAuthorityFragment.c(this.this$0), 0L, paramMessage, "");
          if (!OpenAuthorityFragment.e(this.this$0)) {
            this.this$0.report("wtl_loggednauthorized", OpenAuthorityFragment.a(this.this$0).uin);
          }
          this.this$0.jf();
        }
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "handleMessage AUTHORIZE_DONE");
        localObject1 = (arte)paramMessage.obj;
        i = ((arte)localObject1).ret.get();
        if (i != 0)
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: A_D | uin : *" + artw.qx(OpenAuthorityFragment.a(this.this$0).uin) + " | state : success | ret : " + i);
          try
          {
            localObject2 = ((arte)localObject1).msg.get();
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramMessage = String.format(this.this$0.getResources().getString(2131696651), new Object[] { Integer.valueOf(i) });
              if (i != 110405) {
                break label1395;
              }
              this.this$0.e(paramMessage, new arrt(this));
            }
            label1395:
            do
            {
              OpenAuthorityFragment.a(this.this$0, i, paramMessage);
              return true;
              paramMessage = String.format(this.this$0.getResources().getString(2131698727), new Object[] { localObject2, Integer.valueOf(i) });
              break;
              if ((i == 110509) && (OpenAuthorityFragment.d(this.this$0) < 1))
              {
                OpenAuthorityFragment.b(this.this$0, 1);
                QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "ret == SKEY_CHECK_ERROR && mSKeyErrorStep < AUTHORIZE_DONE");
                ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
                asaw.a().a(OpenAuthorityFragment.b(this.this$0), this.this$0.c, OpenAuthorityFragment.a(this.this$0), 3);
                OpenAuthorityFragment.a(this.this$0).timeCost = System.currentTimeMillis();
                return true;
              }
            } while (i != 1105030);
            OpenAuthorityFragment.b(this.this$0, i, (String)localObject2);
            paramMessage = asbp.j(OpenAuthorityFragment.a(this.this$0), OpenAuthorityFragment.a(this.this$0).uin);
            if ((paramMessage != null) && (paramMessage.length > 0))
            {
              localObject3 = new SdkAuthorize.AuthorizeResponse();
              try
              {
                paramMessage = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject3).mergeFrom(paramMessage);
                localObject3 = this.this$0.b.obtainMessage();
                ((Message)localObject3).what = 1;
                ((Message)localObject3).obj = arte.a(paramMessage);
                this.this$0.b.sendMessage((Message)localObject3);
                return true;
              }
              catch (InvalidProtocolBufferMicroException paramMessage) {}
            }
            OpenAuthorityFragment.c(this.this$0, i, (String)localObject2);
            return true;
          }
          catch (JSONException paramMessage) {}
        }
        this.this$0.WN(((arte)localObject1).openid.get());
        this.this$0.iE(((arte)localObject1).openid.get(), ((arte)localObject1).encrytoken.get());
        try
        {
          paramMessage = new JSONObject();
          paramMessage.put("ret", ((arte)localObject1).ret.get());
          paramMessage.put("openid", ((arte)localObject1).openid.get());
          paramMessage.put("access_token", ((arte)localObject1).access_token.get());
          paramMessage.put("pay_token", ((arte)localObject1).pay_token.get());
          paramMessage.put("expires_in", ((arte)localObject1).expires_in.get());
          paramMessage.put("code", ((arte)localObject1).code.get());
          paramMessage.put("proxy_code", ((arte)localObject1).proxy_auth_resp.code.get());
          paramMessage.put("proxy_expires_in", ((arte)localObject1).proxy_auth_resp.expires_in.get());
          paramMessage.put("pf", ((arte)localObject1).pf.get());
          paramMessage.put("pfkey", ((arte)localObject1).pfkey.get());
          paramMessage.put("msg", ((arte)localObject1).msg.get());
          paramMessage.put("login_cost", OpenAuthorityFragment.a(this.this$0) - OpenAuthorityFragment.b(this.this$0));
          paramMessage.put("query_authority_cost", OpenAuthorityFragment.f(this.this$0) - OpenAuthorityFragment.g(this.this$0));
          if (OpenAuthorityFragment.h(this.this$0) == 0L)
          {
            paramMessage.put("authority_cost", 0);
            label1894:
            if (((arte)localObject1).sendinstall.has()) {
              paramMessage.put("sendinstall", ((arte)localObject1).sendinstall.get());
            }
            if ((((arte)localObject1).installwording.has()) && (!TextUtils.isEmpty(((arte)localObject1).installwording.get()))) {
              paramMessage.put("installwording", ((arte)localObject1).installwording.get());
            }
            if ((!((arte)localObject1).passDataResp.has()) || (((arte)localObject1).passDataResp.size() <= 0)) {
              break label2216;
            }
            localObject2 = ((arte)localObject1).passDataResp.get().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (appType.PassData)((Iterator)localObject2).next();
              paramMessage.put(((appType.PassData)localObject3).key.get(), ((appType.PassData)localObject3).value.get());
            }
          }
        }
        catch (JSONException paramMessage)
        {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "JSONException", paramMessage);
          for (;;)
          {
            paramMessage = new HashMap();
            paramMessage.put("autologin", "0");
            if (!OpenAuthorityFragment.e(this.this$0)) {
              break label2380;
            }
            if (!OpenAuthorityFragment.g(this.this$0)) {
              break label2285;
            }
            paramMessage.put("appid", OpenAuthorityFragment.a(this.this$0));
            paramMessage.put("p1", "notlogged");
            paramMessage.put("p2", "auth");
            anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.this$0), "connect_sso_lognback", true, System.currentTimeMillis() - OpenAuthorityFragment.i(this.this$0), 0L, paramMessage, "");
            this.this$0.report("wtl_lognback", OpenAuthorityFragment.a(this.this$0).uin);
            break;
            paramMessage.put("authority_cost", OpenAuthorityFragment.h(this.this$0) - OpenAuthorityFragment.e(this.this$0));
            break label1894;
            if (OpenAuthorityFragment.f(this.this$0))
            {
              ForwardUtils.a(((arte)localObject1).ret.get(), OpenAuthorityFragment.a(this.this$0));
              arsg.a().c(OpenAuthorityFragment.a(this.this$0), true);
            }
            else
            {
              this.this$0.l(((arte)localObject1).ret.get(), paramMessage.toString(), null, null);
            }
          }
          label2285:
          paramMessage.put("appid", OpenAuthorityFragment.a(this.this$0));
          paramMessage.put("p1", "notlogged");
          paramMessage.put("p2", "uauth");
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.this$0), "connect_sso_lognback", true, System.currentTimeMillis() - OpenAuthorityFragment.i(this.this$0), 0L, paramMessage, "");
          this.this$0.report("wtl_lognauthorizenback", OpenAuthorityFragment.a(this.this$0).uin);
          break;
          label2380:
          if (OpenAuthorityFragment.g(this.this$0))
          {
            paramMessage.put("appid", OpenAuthorityFragment.a(this.this$0));
            paramMessage.put("p1", "logged");
            paramMessage.put("p2", "auth");
            anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.this$0), "connect_sso_lognback", true, System.currentTimeMillis() - OpenAuthorityFragment.i(this.this$0), 0L, paramMessage, "");
            this.this$0.report("wtl_loggednunauthorizedback", OpenAuthorityFragment.a(this.this$0).uin);
            break;
          }
          paramMessage.put("appid", OpenAuthorityFragment.a(this.this$0));
          paramMessage.put("p1", "logged");
          paramMessage.put("p2", "uauth");
          anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(OpenAuthorityFragment.b(this.this$0), "connect_sso_lognback", true, System.currentTimeMillis() - OpenAuthorityFragment.i(this.this$0), 0L, paramMessage, "");
          this.this$0.report("wtl_loggednauthorizedback", OpenAuthorityFragment.a(this.this$0).uin);
        }
      }
      break;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "handleMessage GET_APP_INFO_DONE");
      paramMessage = (ahgf)paramMessage.obj;
      if ((paramMessage != null) && (!TextUtils.isEmpty(paramMessage.getAppName()))) {
        OpenAuthorityFragment.a(this.this$0).F(paramMessage.getAppName(), null);
      }
      int k;
      int j;
      label2666:
      int n;
      if ((!OpenAuthorityFragment.h(this.this$0)) && (paramMessage != null) && (paramMessage.BV != null) && (!paramMessage.BV.isEmpty()))
      {
        k = 0;
        j = 0;
        i = 0;
        if (i >= paramMessage.BV.size()) {
          break label3385;
        }
        n = ForwardUtils.parseInt(((svi.a)paramMessage.BV.get(i)).size.get());
        if (n < 100) {
          break label3020;
        }
      }
      for (;;)
      {
        localObject1 = (svi.a)paramMessage.BV.get(i);
        if (localObject1 != null) {
          ThreadManager.executeOnNetWorkThread(new OpenAuthorityFragment.8.4(this, (svi.a)localObject1));
        }
        if (OpenAuthorityFragment.a(this.this$0) != null) {
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "user uin = ", artw.qx(OpenAuthorityFragment.a(this.this$0)) });
        }
        if (paramMessage != null)
        {
          if ((paramMessage.ads != null) && (paramMessage.ads.has()))
          {
            paramMessage = (GetAppInfoProto.Ads)paramMessage.ads.get();
            if ((paramMessage.beginTime.has()) && (paramMessage.endTime.has()))
            {
              long l1 = paramMessage.beginTime.get();
              long l2 = paramMessage.endTime.get();
              long l3 = paramMessage.serverTime.get();
              localObject1 = paramMessage.imgURL.get();
              QLog.i("AuthorityActivity", 1, "Ads begin time = " + l1 + " endTime = " + l2 + " serverTime = " + l3 + " imgURL = " + (String)localObject1 + " adsTxt = " + paramMessage.txt.get());
              if ((l3 >= l1) && (l3 <= l2))
              {
                localObject2 = new Message();
                ((Message)localObject2).obj = paramMessage.txt.get();
                ((Message)localObject2).what = 8;
                this.this$0.b.sendMessage((Message)localObject2);
                ThreadManager.executeOnNetWorkThread(new OpenAuthorityFragment.8.5(this, (String)localObject1));
                break;
                label3020:
                int m = k;
                if (n > k)
                {
                  j = i;
                  m = n;
                }
                i += 1;
                k = m;
                break label2666;
              }
              OpenAuthorityFragment.a(this.this$0).dcP = false;
              OpenAuthorityFragment.a(this.this$0).WR(null);
              break;
            }
            OpenAuthorityFragment.a(this.this$0).dcP = false;
            OpenAuthorityFragment.a(this.this$0).WR(null);
            QLog.i("AuthorityActivity", 1, "Ads begin time or endTime = null");
            break;
          }
          OpenAuthorityFragment.a(this.this$0).dcP = false;
          OpenAuthorityFragment.a(this.this$0).WR(null);
          QLog.i("AuthorityActivity", 1, "Ads = null");
          break;
        }
        OpenAuthorityFragment.a(this.this$0).dcP = false;
        OpenAuthorityFragment.a(this.this$0).WR(null);
        QLog.i("AuthorityActivity", 1, "response = null");
        break;
        paramMessage = (Bitmap)paramMessage.obj;
        OpenAuthorityFragment.c(this.this$0, true);
        OpenAuthorityFragment.a(this.this$0).F("", paramMessage);
        break;
        OpenAuthorityFragment.a(this.this$0).dcP = true;
        paramMessage = (String)paramMessage.obj;
        OpenAuthorityFragment.a(this.this$0).WR(paramMessage);
        break;
        paramMessage = (Bitmap)paramMessage.obj;
        OpenAuthorityFragment.a(this.this$0).ak(paramMessage);
        break;
        this.this$0.ddP();
        break;
        ThreadManager.postImmediately(new OpenAuthorityFragment.8.6(this), null, true);
        break;
        i = paramMessage.arg1;
        paramMessage = (String)paramMessage.obj;
        OpenAuthorityFragment.a(this.this$0, i, paramMessage);
        break;
        this.this$0.jf();
        localObject2 = paramMessage.getData();
        i = ((Bundle)localObject2).getInt("error", -1);
        paramMessage = ((Bundle)localObject2).getString("response");
        localObject1 = ((Bundle)localObject2).getString("msg");
        localObject2 = ((Bundle)localObject2).getString("detail");
        this.this$0.l(i, paramMessage, (String)localObject1, (String)localObject2);
        break;
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrq
 * JD-Core Version:    0.7.0.1
 */