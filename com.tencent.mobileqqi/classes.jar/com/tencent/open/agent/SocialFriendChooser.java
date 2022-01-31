package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.open.agent.datamodel.FriendResponseInfo;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.StringAddition;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.settings.ServerSetting;
import com.tencent.qphone.base.util.QLog;
import hnt;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class SocialFriendChooser
  extends FriendChooser
  implements OpenSdkFriendService.GetFriendInfoListener, HttpCgiAsyncTask.Callback
{
  protected static final int f = 70;
  protected static final String f = SocialFriendChooser.class.getName();
  protected static final int g = 12;
  protected static final String g = "recImg";
  protected static final int h = 70;
  protected static final String h = "recImgDec";
  protected static final int i = 20;
  protected static final String i = "sendImg";
  protected static final int j = 10001;
  protected static final String j = "invitedopenids";
  protected static final int k = 10002;
  protected String A;
  protected ProgressDialog a;
  public Bundle a;
  public HttpCgiAsyncTask a;
  protected String[] a;
  protected Handler b;
  protected String k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  protected String p;
  protected String q;
  protected String r;
  protected String s;
  protected String t;
  protected String u;
  protected String v;
  protected String w;
  protected String x;
  protected String y;
  protected String z;
  
  public SocialFriendChooser()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = null;
    this.jdField_b_of_type_AndroidOsHandler = new hnt(this);
  }
  
  public void a(Intent paramIntent)
  {
    p();
    if (paramIntent.hasExtra("key_error_msg")) {
      Toast.makeText(CommonDataAdapter.a().a(), paramIntent.getStringExtra("key_error_msg"), 0).show();
    }
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0) {
      LogUtility.e(f, "onGetBuddyListError{KEY_ERROR_CODE:" + i1 + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void a(FriendResponseInfo paramFriendResponseInfo)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        p();
        if (("action_gift".equals(this.m)) || ("action_ask".equals(this.m)) || ("action_invite".equals(this.m)) || ("action_reactive".equals(this.m)) || ("action_story".equals(this.m)))
        {
          this.d = paramFriendResponseInfo.g;
          if (paramFriendResponseInfo.e != -1)
          {
            if (paramFriendResponseInfo.e - paramFriendResponseInfo.f == 0)
            {
              this.d = 0;
              this.e = paramFriendResponseInfo.e;
            }
          }
          else
          {
            if (this.d == 0) {
              Toast.makeText(this, super.getString(2131560036, new Object[] { Integer.valueOf(paramFriendResponseInfo.e) }), 0).show();
            }
            FriendDataManager localFriendDataManager = FriendDataManager.a();
            localFriendDataManager.a(paramFriendResponseInfo.a, paramFriendResponseInfo.h, paramFriendResponseInfo.i);
            if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
              break label357;
            }
            paramFriendResponseInfo = this.jdField_a_of_type_ArrayOfJavaLangString;
            int i2 = paramFriendResponseInfo.length;
            if (i1 >= i2) {
              break label357;
            }
            String str = paramFriendResponseInfo[i1];
            localFriendDataManager.a(str);
            this.jdField_b_of_type_JavaUtilArrayList.add(localFriendDataManager.a(str));
            i1 += 1;
            continue;
          }
          if (paramFriendResponseInfo.e - paramFriendResponseInfo.f >= this.d) {
            continue;
          }
          this.d = (paramFriendResponseInfo.e - paramFriendResponseInfo.f);
          continue;
        }
        b(true);
      }
      catch (Exception paramFriendResponseInfo)
      {
        LogUtility.c(f, "GetBuddyList exception." + paramFriendResponseInfo.getMessage(), paramFriendResponseInfo);
        paramFriendResponseInfo = new Intent();
        paramFriendResponseInfo.putExtra("key_error_code", -6);
        paramFriendResponseInfo.putExtra("key_error_msg", "未知错误!");
        a(paramFriendResponseInfo);
        if (QLog.isColorLevel())
        {
          if (!"action_story".equals(this.m)) {
            break;
          }
          QLog.d("SDKQQAgentPref", 2, "GetShareFriendSwitchEnd:" + SystemClock.elapsedRealtime());
        }
        return;
      }
      label357:
      ((OpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).g();
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10001, 5000L);
    }
    QLog.d("SDKQQAgentPref", 2, "GetInviteFriendSwitch_AGENT:" + SystemClock.elapsedRealtime());
  }
  
  public void a(Exception paramException)
  {
    p();
    LogUtility.c(f, "SendAppInvitation exception." + paramException.getMessage(), paramException);
    Intent localIntent = new Intent();
    if ((paramException instanceof ConnectTimeoutException))
    {
      localIntent.putExtra("key_error_code", -7);
      localIntent.putExtra("key_error_msg", "网络连接超时!");
    }
    for (;;)
    {
      b(localIntent);
      return;
      if ((paramException instanceof SocketTimeoutException))
      {
        localIntent.putExtra("key_error_code", -8);
        localIntent.putExtra("key_error_msg", "网络连接超时!");
      }
      else if ((paramException instanceof MalformedURLException))
      {
        localIntent.putExtra("key_error_code", -3);
        localIntent.putExtra("key_error_msg", "访问url有误!");
      }
      else if ((paramException instanceof HttpBaseUtil.HttpStatusException))
      {
        localIntent.putExtra("key_error_code", -10);
        localIntent.putExtra("key_error_msg", "Http返回码异常!");
      }
      else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException))
      {
        localIntent.putExtra("key_error_code", -9);
        localIntent.putExtra("key_error_msg", "网络连接异常，请检查后重试!");
      }
      else if ((paramException instanceof IOException))
      {
        localIntent.putExtra("key_error_code", -2);
        localIntent.putExtra("key_error_msg", "网络连接异常，请检查后重试!");
      }
      else
      {
        localIntent.putExtra("key_error_code", -6);
        localIntent.putExtra("key_error_msg", "未知错误!");
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int i1 = 2131560031;
    try
    {
      p();
      int i2 = paramJSONObject.getInt("ret");
      String str = paramJSONObject.getString("msg");
      if (i2 == 0)
      {
        if (!"action_invite".equals(this.m)) {
          break label111;
        }
        StaticAnalyz.a("400", "ANDROIDQQ.INVITE.ASSISTANT", this.k);
      }
      for (;;)
      {
        Toast.makeText(this, i1, 0).show();
        Intent localIntent = new Intent();
        localIntent.putExtra("key_error_code", i2);
        localIntent.putExtra("key_error_msg", str);
        localIntent.putExtra("key_response", paramJSONObject.toString());
        b(localIntent);
        return;
        label111:
        if ("action_ask".equals(this.m))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.REQUEST.ASSISTANT", this.k);
          i1 = 2131560041;
        }
        else if ("action_gift".equals(this.m))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.FREEGIFT.ASSISTANT", this.k);
          i1 = 2131560042;
        }
        else if ("action_reactive".equals(this.m))
        {
          StaticAnalyz.a("400", "ANDROIDQQ.REACTIVE.ASSISTANT", this.k);
          i1 = 2131560043;
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      LogUtility.c(f, "SendAppInvitation exception." + paramJSONObject.getMessage(), paramJSONObject);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_error_code", -4);
      paramJSONObject.putExtra("key_error_msg", "服务器返回数据格式有误!");
      b(paramJSONObject);
    }
  }
  
  protected void b(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("key_error_code", -6);
    if (i1 != 0)
    {
      Toast.makeText(this, paramIntent.getStringExtra("key_error_msg"), 0).show();
      LogUtility.e(f, "onSendAppInvitationComplete{KEY_ERROR_CODE:" + i1 + "; KEY_ERROR_MSG:" + paramIntent.getStringExtra("key_error_msg") + "}");
    }
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public String c()
  {
    return this.k;
  }
  
  protected boolean c()
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
        this.m = super.getIntent().getStringExtra("key_action");
        LogUtility.c(f, "-->action = " + this.m + " -- mParms = " + this.jdField_a_of_type_AndroidOsBundle);
        if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("appid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("hopenid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keystr")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keytype")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("platform")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("encrytoken")))
        {
          this.k = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
          this.l = this.jdField_a_of_type_AndroidOsBundle.getString("keystr");
          this.n = this.jdField_a_of_type_AndroidOsBundle.getString("hopenid");
          this.o = this.jdField_a_of_type_AndroidOsBundle.getString("keytype");
          this.p = this.jdField_a_of_type_AndroidOsBundle.getString("platform");
          this.q = this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken");
          if (("".equals(this.k.trim())) || ("".equals(this.n.trim())) || ("".equals(this.l.trim())) || ("".equals(this.p.trim())) || ("".equals(this.o.trim())) || ("".equals(this.q.trim())))
          {
            n();
            return false;
          }
          if (("action_gift".equals(this.m)) || ("action_ask".equals(this.m)) || ("action_reactive".equals(this.m)))
          {
            this.s = this.jdField_a_of_type_AndroidOsBundle.getString("type");
            this.v = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("title"), 12, true, false);
            this.u = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("msg"), 70, true, false);
            if (!"action_ask".equals(this.m)) {
              break label843;
            }
            String str1 = "50";
            this.t = str1;
            if (("".equals(this.s.trim())) || ("".equals(this.v.trim())) || ("".equals(this.u.trim())))
            {
              n();
              return false;
            }
            if ("action_reactive".equals(this.m))
            {
              this.t = "51";
              if ((!this.jdField_a_of_type_AndroidOsBundle.containsKey("recImg")) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("recImgDec")) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("sendImg")))
              {
                n();
                return false;
              }
              this.y = this.jdField_a_of_type_AndroidOsBundle.getString("recImg");
              this.z = StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("recImgDec"), 20, true, false);
              this.A = this.jdField_a_of_type_AndroidOsBundle.getString("sendImg");
              if (("".equals(this.y)) || ("".equals(this.z)) || ("".equals(this.A)))
              {
                n();
                return false;
              }
            }
            LogUtility.c(f, "-->typeid = " + this.t);
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
            this.r = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("img")) {
            this.w = this.jdField_a_of_type_AndroidOsBundle.getString("img");
          }
          if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
            this.x = this.jdField_a_of_type_AndroidOsBundle.getString("source");
          }
          OpenSdkFriendService.a().a(this.k, this.n);
          this.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_AndroidOsBundle.getStringArray("BuddiesSelected");
          return true;
        }
      }
      catch (Exception localException)
      {
        LogUtility.c(f, "initParams exception." + localException.getMessage(), localException);
        n();
        return false;
      }
      n();
      return false;
      label843:
      String str2 = "1";
    }
  }
  
  protected void k()
  {
    if (("action_invite".equals(this.m)) || ("action_gift".equals(this.m)) || ("action_ask".equals(this.m)) || ("action_reactive".equals(this.m))) {
      m();
    }
    while (!"action_story".equals(this.m)) {
      return;
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Friend[] arrayOfFriend = (Friend[])this.jdField_b_of_type_JavaUtilArrayList.toArray(new Friend[this.jdField_b_of_type_JavaUtilArrayList.size()]);
    localBundle.putInt("key_error_code", 0);
    localBundle.putParcelableArray("RESULT_BUDDIES_SELECTED", arrayOfFriend);
    localIntent.putExtras(localBundle);
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public void l()
  {
    String str = null;
    if (this.d == 0) {
      if ("action_invite".equals(this.m)) {
        str = super.getString(2131560036, new Object[] { Integer.valueOf(this.e) });
      }
    }
    for (;;)
    {
      ToastUtil.a().a(str, 0);
      return;
      if ("action_ask".equals(this.m))
      {
        str = super.getString(2131560037, new Object[] { Integer.valueOf(this.e) });
      }
      else if ("action_gift".equals(this.m))
      {
        str = super.getString(2131560038, new Object[] { Integer.valueOf(this.e) });
        continue;
        str = super.getString(2131560034, new Object[] { Integer.valueOf(this.d) });
      }
    }
  }
  
  protected void m()
  {
    String str1 = null;
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getString(2131560030), true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.k);
    localBundle.putString("hopenid", this.n);
    localBundle.putString("keystr", this.l);
    localBundle.putString("keytype", this.o);
    localBundle.putString("platform", this.p);
    localBundle.putString("encrytoken", this.q);
    localBundle.putString("agentversion", CommonDataAdapter.a().d());
    localBundle.putString("appid_for_getting_config", this.k);
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("desc")) {
      localBundle.putString("desc", StringAddition.a(this.jdField_a_of_type_AndroidOsBundle.getString("desc"), 70, true, false));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("picurl")) {
      localBundle.putString("picurl", this.jdField_a_of_type_AndroidOsBundle.getString("picurl"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
      localBundle.putString("source", this.jdField_a_of_type_AndroidOsBundle.getString("source"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
      localBundle.putString("pf", this.jdField_a_of_type_AndroidOsBundle.getString("pf"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sdkv")) {
      localBundle.putString("sdkv", this.jdField_a_of_type_AndroidOsBundle.getString("pf"));
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("sdkp")) {
      localBundle.putString("sdkp", this.jdField_a_of_type_AndroidOsBundle.getString("sdkp"));
    }
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      Friend localFriend = this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(str2);
      if (localFriend.a == -1) {
        ((StringBuilder)localObject).append(str2).append(",");
      } else {
        localStringBuilder.append(str2).append("_").append(localFriend.a).append(",");
      }
    }
    int i1 = ((StringBuilder)localObject).lastIndexOf(",");
    if (i1 != -1) {
      ((StringBuilder)localObject).deleteCharAt(i1);
    }
    i1 = localStringBuilder.lastIndexOf(",");
    if (i1 != -1) {
      localStringBuilder.deleteCharAt(i1);
    }
    localBundle.putString("app_rid", String.valueOf(this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c));
    localBundle.putString("app_tid", String.valueOf(this.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.d));
    localBundle.putString("recom_openids", localStringBuilder.toString());
    if ("action_invite".equals(this.m))
    {
      localBundle.putString("invitedopenids", ((StringBuilder)localObject).toString());
      str1 = ServerSetting.a().a("http://fusion.qq.com/cgi-bin/qzapps/mappinvite_invite.cgi");
      localObject = "GET";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask = new HttpCgiAsyncTask(str1, (String)localObject, this);
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a(localBundle);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10002, 45000L);
      return;
      if (("action_gift".equals(this.m)) || ("action_ask".equals(this.m)) || ("action_reactive".equals(this.m)))
      {
        if ("action_reactive".equals(this.m)) {
          localBundle.putString("imgurl", this.A);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.v)) {
            localBundle.putString("title", this.v);
          }
          if (!TextUtils.isEmpty(this.u)) {
            localBundle.putString("sendmsg", this.u);
          }
          localBundle.putString("receiver", ((StringBuilder)localObject).toString());
          localBundle.putString("typeid", this.t);
          str1 = ServerSetting.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_sendrequest.cgi");
          localObject = "POST";
          break;
          if (!TextUtils.isEmpty(this.w)) {
            localBundle.putString("imgurl", this.w);
          }
        }
      }
      localObject = null;
    }
  }
  
  protected void n()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", "传入参数有误!");
    LogUtility.e(f, "initParams:error code:-5; error msg:传入参数有误!");
    Bundle localBundle = super.getIntent().getBundleExtra("key_params");
    if (localBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + ": " + localBundle.get(str).toString() + " ");
      }
      LogUtility.e(f, "params=" + localStringBuilder.toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  protected void o()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", getResources().getString(2131560035), true);
    this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.k);
    localBundle.putString("hopenid", this.n);
    localBundle.putString("keystr", this.l);
    localBundle.putString("keytype", this.o);
    localBundle.putString("platform", this.p);
    localBundle.putString("encrytoken", this.q);
    if (this.r != null) {
      localBundle.putString("pf", this.r);
    }
    localBundle.putString("appid_for_getting_config", this.k);
    if (("action_gift".equals(this.m)) || ("action_ask".equals(this.m)) || ("action_reactive".equals(this.m))) {
      localBundle.putString("typeid", this.t);
    }
    localBundle.putString("agentversion", CommonDataAdapter.a().d());
    localBundle.putString("appid_for_getting_config", this.k);
    OpenSdkFriendService.a().a(localBundle, this, this.m);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c();
    o();
    if (this.m.equals("action_invite"))
    {
      paramBundle = super.getString(2131560044);
      ((GroupListOpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a(paramBundle);
    }
    do
    {
      while ("action_invite".equals(this.m))
      {
        StaticAnalyz.a("100", "ANDROIDQQ.INVITE.FS", this.k);
        return;
        if ((this.m.equals("action_reactive")) || (this.m.equals("action_gift")) || (this.m.equals("action_ask")))
        {
          paramBundle = super.getString(2131560045);
          ((GroupListOpenFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a(paramBundle);
        }
      }
      if ("action_ask".equals(this.m))
      {
        StaticAnalyz.a("100", "ANDROIDQQ.REQUEST.FS", this.k);
        return;
      }
      if ("action_gift".equals(this.m))
      {
        StaticAnalyz.a("100", "ANDROIDQQ.FREEGIFT.FS", this.k);
        return;
      }
    } while (!"action_reactive".equals(this.m));
    StaticAnalyz.a("100", "ANDROIDQQ.REACTIVE.FS", this.k);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(10001);
    OpenSdkFriendService.a().a();
  }
  
  public void p()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.SocialFriendChooser
 * JD-Core Version:    0.7.0.1
 */