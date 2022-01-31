import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.AuthorityActivity.AccountInfo;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.widget.PermissionView;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListRequest;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.PassData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class hio
  extends Handler
{
  public hio(AuthorityActivity paramAuthorityActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1;
    int i;
    label305:
    Object localObject2;
    label644:
    label950:
    label1354:
    label1497:
    label1532:
    int j;
    label1657:
    int m;
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      label1681:
      label1687:
      label1778:
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
                break label305;
              }
              paramMessage = String.format(this.a.getResources().getString(2131562322), new Object[] { Integer.valueOf(i) });
              this.a.a(paramMessage, new hip(this));
              this.a.b(i, paramMessage);
              return;
            }
            catch (JSONException paramMessage) {}
            this.a.i = SystemClock.elapsedRealtime();
            if (((SdkAuthorize.GetAuthApiListResponse)localObject1).redirect_time.has()) {
              this.a.y = (((SdkAuthorize.GetAuthApiListResponse)localObject1).redirect_time.get() * 2);
            }
            paramMessage = ((SdkAuthorize.GetAuthApiListResponse)localObject1).authorized_form_list.get();
            this.a.jdField_a_of_type_ComTencentOpenWidgetPermissionView = new PermissionView(this.a);
            if (this.a.jdField_a_of_type_ComTencentOpenWidgetPermissionView.a(paramMessage)) {
              break label644;
            }
            this.a.jdField_e_of_type_Boolean = true;
            if (!this.a.jdField_b_of_type_Boolean) {
              break;
            }
            this.a.p();
            return;
            paramMessage = String.format(this.a.getResources().getString(2131561498), new Object[] { ((SdkAuthorize.GetAuthApiListResponse)localObject1).msg.get(), Integer.valueOf(i) });
          }
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ret", ((SdkAuthorize.GetAuthApiListResponse)localObject1).ret.get());
        ((JSONObject)localObject2).put("msg", ((SdkAuthorize.GetAuthApiListResponse)localObject1).msg.get());
        if (TextUtils.isEmpty(((SdkAuthorize.GetAuthApiListResponse)localObject1).msg.get())) {}
        for (paramMessage = String.format(this.a.getResources().getString(2131562322), new Object[] { Integer.valueOf(i) });; paramMessage = String.format(this.a.getResources().getString(2131561498), new Object[] { ((SdkAuthorize.GetAuthApiListResponse)localObject1).msg.get(), Integer.valueOf(i) }))
        {
          this.a.a(paramMessage, new hiq(this, (SdkAuthorize.GetAuthApiListResponse)localObject1, (JSONObject)localObject2));
          break;
        }
        this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        this.a.jdField_a_of_type_AndroidViewView.setEnabled(true);
        paramMessage = new HashMap();
        paramMessage.put("appid", this.a.B);
        paramMessage.put("p1", "logged");
        paramMessage.put("p2", "auth");
        StatisticCollector.a(this.a).a("0", "connect_sso_pageview", false, System.currentTimeMillis() - this.a.jdField_b_of_type_Long, 0L, paramMessage, "");
        this.a.b("wtl_loggednunauthorized", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
        this.a.q();
        for (;;)
        {
          this.a.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
          long l = Long.parseLong(this.a.B);
          this.a.a(l);
          return;
          this.a.jdField_e_of_type_Boolean = false;
          this.a.n();
          this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.z);
          this.a.setTitle(2131562740);
          paramMessage = new HashMap();
          paramMessage.put("appid", this.a.B);
          paramMessage.put("p1", "logged");
          paramMessage.put("p2", "uauth");
          StatisticCollector.a(this.a).a("0", "connect_sso_pageview", false, System.currentTimeMillis() - this.a.jdField_b_of_type_Long, 0L, paramMessage, "");
          if (!this.a.d) {
            this.a.b("wtl_loggednauthorized", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
          }
          this.a.a(this.a.A);
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
              break label1532;
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1497;
            }
            paramMessage = String.format(this.a.getResources().getString(2131562322), new Object[] { Integer.valueOf(i) });
            this.a.a(paramMessage, new hir(this));
            this.a.b(i, paramMessage);
            return;
          }
          catch (JSONException paramMessage) {}
        }
        else
        {
          this.a.c(((SdkAuthorize.AuthorizeResponse)localObject1).openid.get());
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
              break label1657;
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
            break label1681;
          }
        }
        for (paramMessage = "1";; paramMessage = "0")
        {
          ((HashMap)localObject1).put("autologin", paramMessage);
          if (!this.a.d) {
            break label1778;
          }
          if (!this.a.jdField_e_of_type_Boolean) {
            break label1687;
          }
          ((HashMap)localObject1).put("appid", this.a.B);
          ((HashMap)localObject1).put("p1", "notlogged");
          ((HashMap)localObject1).put("p2", "auth");
          StatisticCollector.a(this.a).a("0", "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_c_of_type_Long, 0L, (HashMap)localObject1, "");
          this.a.b("wtl_lognback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
          return;
          paramMessage = String.format(this.a.getResources().getString(2131561498), new Object[] { localObject2, Integer.valueOf(i) });
          break;
          if (i != 110503) {
            break label950;
          }
          this.a.d(i, (String)localObject2);
          paramMessage = this.a.a(this.a.B, this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
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
          break label1354;
        }
        ((HashMap)localObject1).put("appid", this.a.B);
        ((HashMap)localObject1).put("p1", "notlogged");
        ((HashMap)localObject1).put("p2", "uauth");
        StatisticCollector.a(this.a).a("0", "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_c_of_type_Long, 0L, (HashMap)localObject1, "");
        this.a.b("wtl_lognauthorizenback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
        return;
        if (this.a.jdField_e_of_type_Boolean)
        {
          ((HashMap)localObject1).put("appid", this.a.B);
          ((HashMap)localObject1).put("p1", "logged");
          ((HashMap)localObject1).put("p2", "auth");
          StatisticCollector.a(this.a).a("0", "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_c_of_type_Long, 0L, (HashMap)localObject1, "");
          this.a.b("wtl_loggednunauthorizedback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
          return;
        }
        ((HashMap)localObject1).put("appid", this.a.B);
        ((HashMap)localObject1).put("p1", "logged");
        ((HashMap)localObject1).put("p2", "uauth");
        StatisticCollector.a(this.a).a("0", "connect_sso_lognback", true, System.currentTimeMillis() - this.a.jdField_c_of_type_Long, 0L, (HashMap)localObject1, "");
        this.a.b("wtl_loggednauthorizedback", this.a.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$AccountInfo.a);
        return;
        paramMessage = (SdkAuthorize.GetAuthApiListRequest)paramMessage.obj;
        this.a.a(paramMessage);
        return;
        localObject1 = (GetAppInfoProto.GetAppinfoResponse)paramMessage.obj;
        if ((TextUtils.isEmpty(this.a.A)) && (!TextUtils.isEmpty(((GetAppInfoProto.GetAppinfoResponse)localObject1).appName.get())))
        {
          this.a.A = ((GetAppInfoProto.GetAppinfoResponse)localObject1).appName.get();
          if (this.a.jdField_b_of_type_AndroidWidgetTextView != null) {
            this.a.jdField_b_of_type_AndroidWidgetTextView.setText(this.a.A);
          }
          if (this.a.jdField_c_of_type_AndroidWidgetTextView != null)
          {
            paramMessage = this.a.A;
            if (this.a.A.length() > 12) {
              paramMessage = this.a.A.substring(0, 12) + "...";
            }
            this.a.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(this.a.getResources().getString(2131562175), new Object[] { paramMessage }));
          }
        }
      } while ((this.a.jdField_f_of_type_Boolean) || (!((GetAppInfoProto.GetAppinfoResponse)localObject1).iconsURL.has()));
      i = 0;
      j = 0;
      m = 0;
      label2190:
      if (i < ((GetAppInfoProto.GetAppinfoResponse)localObject1).iconsURL.get().size()) {
        paramMessage = (GetAppInfoProto.MsgIconsurl)((GetAppInfoProto.GetAppinfoResponse)localObject1).iconsURL.get(i);
      }
      break;
    }
    for (;;)
    {
      try
      {
        k = Integer.parseInt(paramMessage.size.get());
        if (k >= 100)
        {
          paramMessage = (GetAppInfoProto.MsgIconsurl)((GetAppInfoProto.GetAppinfoResponse)localObject1).iconsURL.get(i);
          if (paramMessage == null) {
            break;
          }
          ThreadManager.a(new his(this, paramMessage));
          return;
        }
      }
      catch (NumberFormatException paramMessage)
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
      break label2190;
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_f_of_type_Boolean = true;
      this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a.B, paramMessage);
      localObject1 = ImageUtil.a(paramMessage, 24.0F, paramMessage.getWidth(), paramMessage.getHeight());
      paramMessage.recycle();
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      return;
      this.a.d();
      this.a.jdField_a_of_type_AndroidAppProgressDialog.setMessage(this.a.getResources().getString(2131561676));
      if ((this.a.isFinishing()) || (this.a.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
        break;
      }
      this.a.jdField_a_of_type_AndroidAppProgressDialog.show();
      return;
      i = paramMessage.arg1;
      paramMessage = (String)paramMessage.obj;
      this.a.b(i, paramMessage);
      return;
      this.a.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      if (this.a.k) {
        break;
      }
      localObject2 = paramMessage.getData();
      i = ((Bundle)localObject2).getInt("error", -1);
      paramMessage = ((Bundle)localObject2).getString("response");
      localObject1 = ((Bundle)localObject2).getString("msg");
      localObject2 = ((Bundle)localObject2).getString("detail");
      this.a.b(i, paramMessage, (String)localObject1, (String)localObject2);
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hio
 * JD-Core Version:    0.7.0.1
 */