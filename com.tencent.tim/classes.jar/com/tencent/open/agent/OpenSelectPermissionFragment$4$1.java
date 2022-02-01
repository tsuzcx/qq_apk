package com.tencent.open.agent;

import acfp;
import android.os.SystemClock;
import android.text.TextUtils;
import arsd;
import arte;
import artw;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.appType.PassData;
import com.tencent.qconn.protofile.auth.ProxyAuthResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSelectPermissionFragment$4$1
  implements Runnable
{
  public OpenSelectPermissionFragment$4$1(arsd paramarsd, boolean paramBoolean, arte paramarte, int paramInt) {}
  
  public void run()
  {
    if ((this.val$isSuccess) && (this.jdField_a_of_type_Arte != null))
    {
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Arsd.this$0, true);
      this.jdField_a_of_type_Arsd.this$0.WN(this.jdField_a_of_type_Arte.openid.get());
      this.jdField_a_of_type_Arsd.this$0.iE(this.jdField_a_of_type_Arte.openid.get(), this.jdField_a_of_type_Arte.encrytoken.get());
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", this.jdField_a_of_type_Arte.ret.get());
        localJSONObject.put("openid", this.jdField_a_of_type_Arte.openid.get());
        localJSONObject.put("access_token", this.jdField_a_of_type_Arte.access_token.get());
        localJSONObject.put("pay_token", this.jdField_a_of_type_Arte.pay_token.get());
        localJSONObject.put("expires_in", this.jdField_a_of_type_Arte.expires_in.get());
        localJSONObject.put("code", this.jdField_a_of_type_Arte.code.get());
        localJSONObject.put("proxy_code", this.jdField_a_of_type_Arte.proxy_auth_resp.code.get());
        localJSONObject.put("proxy_expires_in", this.jdField_a_of_type_Arte.proxy_auth_resp.expires_in.get());
        localJSONObject.put("pf", this.jdField_a_of_type_Arte.pf.get());
        localJSONObject.put("pfkey", this.jdField_a_of_type_Arte.pfkey.get());
        localJSONObject.put("msg", this.jdField_a_of_type_Arte.msg.get());
        localJSONObject.put("login_cost", OpenSelectPermissionFragment.c(this.jdField_a_of_type_Arsd.this$0));
        localJSONObject.put("query_authority_cost", OpenSelectPermissionFragment.d(this.jdField_a_of_type_Arsd.this$0));
        localJSONObject.put("authority_cost", SystemClock.elapsedRealtime() - OpenSelectPermissionFragment.e(this.jdField_a_of_type_Arsd.this$0));
        if (this.jdField_a_of_type_Arte.sendinstall.has()) {
          localJSONObject.put("sendinstall", this.jdField_a_of_type_Arte.sendinstall.get());
        }
        if ((this.jdField_a_of_type_Arte.installwording.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_Arte.installwording.get()))) {
          localJSONObject.put("installwording", this.jdField_a_of_type_Arte.installwording.get());
        }
        if ((this.jdField_a_of_type_Arte.passDataResp.has()) && (this.jdField_a_of_type_Arte.passDataResp.size() > 0))
        {
          Iterator localIterator = this.jdField_a_of_type_Arte.passDataResp.get().iterator();
          while (localIterator.hasNext())
          {
            appType.PassData localPassData = (appType.PassData)localIterator.next();
            localJSONObject.put(localPassData.key.get(), localPassData.value.get());
            continue;
            this.jdField_a_of_type_Arsd.this$0.jf();
          }
        }
      }
      catch (JSONException localJSONException) {}
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Arsd.this$0.l(this.jdField_a_of_type_Arte.ret.get(), localJSONException.toString(), null, null);
      continue;
      if (this.val$code == 110509)
      {
        QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "onDoAuthorize mAuthRetryCountBy110509=" + OpenSelectPermissionFragment.a(this.jdField_a_of_type_Arsd.this$0));
        if (OpenSelectPermissionFragment.a(this.jdField_a_of_type_Arsd.this$0) >= 2) {
          OpenSelectPermissionFragment.a(this.jdField_a_of_type_Arsd.this$0);
        }
        for (;;)
        {
          OpenSelectPermissionFragment.a(this.jdField_a_of_type_Arsd.this$0, false);
          break;
          OpenSelectPermissionFragment.b(this.jdField_a_of_type_Arsd.this$0);
          OpenSelectPermissionFragment.a(this.jdField_a_of_type_Arsd.this$0, 3);
        }
      }
      if (this.val$code != 110537) {
        break;
      }
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "onDoAuthorize 110537");
      artw.f(this.jdField_a_of_type_Arsd.this$0.getActivity(), acfp.m(2131709376), false);
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Arsd.this$0);
    }
    if ((this.jdField_a_of_type_Arte != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Arte.msg.get()))) {
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Arsd.this$0, this.jdField_a_of_type_Arte.msg.get() + acfp.m(2131709369) + this.val$code, false);
    }
    for (;;)
    {
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Arsd.this$0, false);
      break;
      OpenSelectPermissionFragment.a(this.jdField_a_of_type_Arsd.this$0, acfp.m(2131709384) + this.val$code, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.4.1
 * JD-Core Version:    0.7.0.1
 */