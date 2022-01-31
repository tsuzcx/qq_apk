package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.settings.ServerSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;

public abstract class ChallengeBragBase
  extends BaseActivity
  implements View.OnClickListener
{
  protected static final int k = 12;
  protected ProgressDialog a;
  protected Bundle a;
  protected EditText a;
  protected TextView a;
  protected TextView b;
  protected TextView c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  protected String l = null;
  protected String m = null;
  protected String n;
  protected String o;
  protected String p;
  protected String q;
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getResources().getString(2131362144), true);
    this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.d);
    localBundle.putString("hopenid", this.e);
    localBundle.putString("keystr", this.f);
    localBundle.putString("keytype", this.g);
    localBundle.putString("encrytoken", this.n);
    localBundle.putString("platform", this.h);
    paramString = TextUtils.split(paramString, ",");
    if ((paramString == null) || (paramString.length == 0)) {
      e();
    }
    do
    {
      return;
      localBundle.putString("fopenids", paramString[0]);
      if (this.m != null) {
        localBundle.putString("pf", this.m);
      }
      localBundle.putString("appid_for_getting_config", this.d);
    } while (this.o == null);
    new HttpCgiAsyncTask(this.o, "GET", new ChallengeBragBase.GetNickNameCallback(this)).a(localBundle);
  }
  
  protected boolean c()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
      this.q = super.getIntent().getStringExtra("key_action");
      if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("appid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("hopenid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keystr")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("keytype")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("platform")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("img")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("receiver")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("encrytoken")))
      {
        this.d = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
        this.e = this.jdField_a_of_type_AndroidOsBundle.getString("hopenid");
        this.f = this.jdField_a_of_type_AndroidOsBundle.getString("keystr");
        this.g = this.jdField_a_of_type_AndroidOsBundle.getString("keytype");
        this.h = this.jdField_a_of_type_AndroidOsBundle.getString("platform");
        this.k = this.jdField_a_of_type_AndroidOsBundle.getString("img");
        this.i = this.jdField_a_of_type_AndroidOsBundle.getString("receiver");
        this.j = this.jdField_a_of_type_AndroidOsBundle.getString("msg");
        this.n = this.jdField_a_of_type_AndroidOsBundle.getString("encrytoken");
        if (("".equals(this.d.trim())) || ("".equals(this.e.trim())) || ("".equals(this.f.trim())) || ("".equals(this.g.trim())) || ("".equals(this.h.trim())) || ("".equals(this.k.trim())) || ("".equals(this.i.trim())))
        {
          e();
          return false;
        }
      }
      else
      {
        e();
        return false;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("qqBaseActivity", "initParams exception." + localException.getMessage(), localException);
      e();
      return false;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("pf")) {
      this.m = this.jdField_a_of_type_AndroidOsBundle.getString("pf");
    }
    if (this.jdField_a_of_type_AndroidOsBundle.containsKey("source")) {
      this.l = this.jdField_a_of_type_AndroidOsBundle.getString("source");
    }
    this.o = ServerSetting.a().a("http://fusion.qq.com/cgi-bin/qzapps/mapp_getuserinfo.cgi");
    this.p = ServerSetting.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_sendbragging.cgi");
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "GetPKFriendInfoSwitch_AGENT:" + SystemClock.elapsedRealtime());
    }
  }
  
  protected void e()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", -5);
    localIntent.putExtra("key_error_msg", "传入参数有误!");
    LogUtility.e("qqBaseActivity", "initParams:error code:-5; error msg:传入参数有误!");
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_AndroidOsBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append(str + ": " + this.jdField_a_of_type_AndroidOsBundle.get(str).toString() + " ");
      }
      LogUtility.e("qqBaseActivity", "params=" + localStringBuilder.toString());
    }
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  protected void f()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b)
    {
      paramView = new Bundle();
      paramView.putString("appid", this.d);
      paramView.putString("hopenid", this.e);
      paramView.putString("keystr", this.f);
      paramView.putString("keytype", this.g);
      paramView.putString("encrytoken", this.n);
      paramView.putString("platform", this.h);
      paramView.putString("sendmsg", this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      paramView.putString("imgurl", this.k);
      paramView.putString("receiver", this.i);
      i1 = 2131362137;
      if ("action_brag".equals(this.q)) {
        paramView.putString("typeid", "52");
      }
    }
    while (paramView != this.c)
    {
      int i1;
      for (;;)
      {
        paramView.putString("appid_for_getting_config", this.d);
        if (this.l != null) {
          paramView.putString("app_custom", this.l);
        }
        if (this.m != null) {
          paramView.putString("pf", this.m);
        }
        this.jdField_a_of_type_AndroidAppProgressDialog = ProgressDialog.show(this, "", super.getResources().getString(i1), true);
        new HttpCgiAsyncTask(this.p, "POST", new ChallengeBragBase.SendChallengeCallback(this)).a(paramView);
        return;
        if ("action_challenge".equals(this.q))
        {
          paramView.putString("typeid", "53");
          i1 = 2131362136;
        }
      }
    }
    super.setResult(0);
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeBragBase
 * JD-Core Version:    0.7.0.1
 */