package com.tencent.open.agent;

import ahlw;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import arhz;
import arsv;
import arsw;
import arts;
import artw;
import aryn;
import asaw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class SwitchAccountActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public OpenSDKAppInterface a;
  public WtloginManager a;
  public boolean aQV;
  protected SharedPreferences ac;
  protected ArrayList<String> accountList;
  public long awg;
  protected int bIi = 1;
  protected SharedPreferences.Editor c;
  protected SSOAccountObserver c;
  protected String cCc;
  protected LinearLayout container;
  protected float density;
  protected String mAccount;
  protected arhz mProgress;
  protected View.OnTouchListener p = new arsw(this);
  
  public SwitchAccountActivity()
  {
    this.jdField_c_of_type_MqqObserverSSOAccountObserver = new arsv(this);
  }
  
  public static String cf(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("uin:'").append(paramString1).append("',");
    localStringBuilder.append("skey:'");
    if (paramString2 != null) {
      localStringBuilder.append(paramString2);
    }
    localStringBuilder.append("'}");
    return localStringBuilder.toString();
  }
  
  protected void deleteAccount(String paramString)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("SwitchAccountActivity", 2, "-->deleteAccount--account to delete is " + paramString);
    }
    aryn.WF(paramString);
    if (this.ac.getString("accList", null) != null) {
      localObject1 = this.ac.getString("accList", null).split(",");
    }
    Object localObject2 = new ArrayList();
    if (localObject1 != null)
    {
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        ((ArrayList)localObject2).add(localObject1[i]);
        i += 1;
      }
    }
    while (((ArrayList)localObject2).contains("")) {
      ((ArrayList)localObject2).remove("");
    }
    if (((ArrayList)localObject2).contains(paramString))
    {
      ((ArrayList)localObject2).remove(paramString);
      localObject2 = ((ArrayList)localObject2).iterator();
      String str;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + "," + str) {
        str = (String)((Iterator)localObject2).next();
      }
      this.jdField_c_of_type_AndroidContentSharedPreferences$Editor.putString("accList", (String)localObject1);
      this.jdField_c_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
    if (paramString.equals(this.ac.getString("last_account", "")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwitchAccountActivity", 2, "-->deleteAccount--account to delete equals last account, clear last account");
      }
      this.jdField_c_of_type_AndroidContentSharedPreferences$Editor.remove("last_account").commit();
    }
    long l = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    localObject1 = new File(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ri("" + l));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.container.getChildCount())
      {
        localObject1 = this.container.getChildAt(i);
        if (!((View)localObject1).getTag().equals(paramString)) {
          break label435;
        }
        this.container.removeView((View)localObject1);
        if (i == 0)
        {
          paramString = this.container.getChildAt(i);
          if (this.container.getChildCount() != 1) {
            break label428;
          }
          paramString.setBackgroundResource(2130839682);
        }
      }
      return;
      label428:
      paramString.setBackgroundResource(2130839701);
      return;
      label435:
      i += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e(String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("-->loginSucess--mReqSrc = ").append(this.bIi).append(", userAccount = *").append(artw.qx(paramString1)).append(", bundle = null ? ");
      if (paramBundle == null)
      {
        bool = true;
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, bool);
      }
    }
    else
    {
      aryn.WE(paramString1);
      if ((this.bIi != 2) && (this.bIi != 3)) {
        break label221;
      }
      paramString2 = new WloginSimpleInfo();
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.mAccount, paramString2);
      paramString2 = new Intent();
      paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
      paramString2.putExtra("last_account", paramString1);
      if (!this.accountList.contains(paramString1)) {
        break label209;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "isLogin: true");
      }
      paramString2.putExtra("isLogin", true);
    }
    for (;;)
    {
      super.setResult(-1, paramString2);
      super.finish();
      return;
      bool = false;
      break;
      label209:
      paramString2.putExtra("isLogin", false);
    }
    label221:
    Object localObject2 = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString1, (WloginSimpleInfo)localObject2);
    Object localObject1 = new Intent();
    String str = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    ahlw.N("KEY_DELEGATE_GET_TICKET_NO_PASSWD", str, true);
    localObject2 = new String(((WloginSimpleInfo)localObject2)._nick);
    if (paramString2 != null)
    {
      paramString1 = new String(paramString2);
      label320:
      ((Intent)localObject1).putExtra("result_data", cf(str, paramString1));
      ((Intent)localObject1).putExtra("nick", (String)localObject2);
      ((Intent)localObject1).putExtra("last_account", str);
      if (this.accountList.contains(str)) {
        break label433;
      }
      ((Intent)localObject1).putExtra("isLogin", false);
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        paramString1 = paramBundle.getByteArray("st_temp");
        paramString2 = paramBundle.getByteArray("st_temp_key");
        ((Intent)localObject1).putExtra("st_temp", paramString1);
        ((Intent)localObject1).putExtra("st_temp_key", paramString2);
      }
      super.setResult(-1, (Intent)localObject1);
      break;
      paramString1 = null;
      break label320;
      label433:
      ((Intent)localObject1).putExtra("isLogin", true);
    }
  }
  
  public void elA()
  {
    if (this.accountList == null) {
      return;
    }
    this.density = super.getResources().getDisplayMetrics().density;
    LayoutInflater localLayoutInflater = super.getLayoutInflater();
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = i;
      Object localObject1;
      if (j < this.accountList.size())
      {
        View localView = localLayoutInflater.inflate(2131558440, this.container, false);
        TextView localTextView1 = (TextView)localView.findViewById(2131372361);
        TextView localTextView2 = (TextView)localView.findViewById(2131381218);
        ImageView localImageView = (ImageView)localView.findViewById(2131366624);
        String str = (String)this.accountList.get(j);
        localObject1 = new WloginSimpleInfo();
        this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(str, (WloginSimpleInfo)localObject1);
        Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = str;
        }
        localTextView1.setText((CharSequence)localObject1);
        localTextView2.setText(str);
        localObject1 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b("" + str, (int)(60.0F * this.density), true);
        if (localObject1 != null)
        {
          localObject2 = artw.a(this, (Bitmap)localObject1, 63, 63);
          ((Bitmap)localObject1).recycle();
          if (localObject2 != null) {
            localImageView.setImageBitmap((Bitmap)localObject2);
          }
        }
        if (i == 0) {
          localView.setBackgroundResource(2130839701);
        }
        ((Button)localView.findViewById(2131365671)).setOnClickListener(this);
        localView.setOnClickListener(this);
        localView.setOnTouchListener(this.p);
        localView.setTag(str);
        this.container.addView(localView);
        i += 1;
        if (i >= 10) {
          k = i;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwitchAccountActivity", 2, "-->showAccountList--count = " + k);
        }
        arts.a().a("", "", "", "1010", String.valueOf(k), "0", false, true);
        localObject1 = localLayoutInflater.inflate(2131558452, this.container, false);
        this.container.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(this);
        return;
      }
      j += 1;
    }
  }
  
  public void elB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwitchAccountActivity", 2, "-->showLoginActivity");
    }
    Intent localIntent = new Intent(this, Login.class);
    localIntent.putExtra("key_req_src", this.bIi);
    localIntent.putExtra("appid", this.cCc);
    super.startActivityForResult(localIntent, 1);
  }
  
  protected void elC()
  {
    this.mProgress.setMessage(super.getString(2131696662));
    if ((!super.isFinishing()) && (!this.mProgress.isShowing()) && (getWindow().isActive())) {
      this.mProgress.show();
    }
  }
  
  public void elD()
  {
    if ((this.mProgress != null) && (this.mProgress.isShowing())) {}
    try
    {
      this.mProgress.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void login()
  {
    if (this.bIi == 2)
    {
      if (artw.b(this.jdField_a_of_type_MqqManagerWtloginManager, this.mAccount))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "-->login--has aone");
        }
        e(this.mAccount, null, null);
        return;
      }
      elB();
      return;
    }
    if (this.bIi == 3)
    {
      if (!artw.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.mAccount))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "-->login--has atwo");
        }
        e(this.mAccount, null, null);
        return;
      }
      elB();
      return;
    }
    if (artw.a(this.jdField_a_of_type_MqqManagerWtloginManager, this.mAccount)) {
      elB();
    }
    for (;;)
    {
      elC();
      return;
      QLog.d("SwitchAccountActivity", 1, "send | cmd: g_t_n_p | uin : *" + artw.qx(this.mAccount));
      ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
      asaw.a().a(this.mAccount, this.jdField_c_of_type_MqqObserverSSOAccountObserver, this.cCc, 1);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("-->onActivityResult--reqCode = ").append(paramInt1).append(", resCode = ").append(paramInt2).append(", data = null ? ");
      if (paramIntent == null)
      {
        bool = true;
        QLog.d("SwitchAccountActivity", 2, bool);
      }
    }
    else
    {
      switch (paramInt1)
      {
      }
    }
    label124:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        super.getIntent().getStringExtra("key_action");
        if (paramInt2 != 0) {
          break label124;
        }
      } while (!this.mProgress.isShowing());
      this.mProgress.dismiss();
      return;
    } while (-1 != paramInt2);
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      View localView = (View)paramView.getParent().getParent();
      if ((localView != null) && (localView.getTag() != null))
      {
        deleteAccount((String)localView.getTag());
        continue;
        if (!this.aQV)
        {
          this.mAccount = ((String)paramView.getTag());
          login();
          continue;
          elB();
        }
      }
    }
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131563148);
    this.ac = super.getSharedPreferences("accountList", 0);
    this.jdField_c_of_type_AndroidContentSharedPreferences$Editor = this.ac.edit();
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getExtras();
      if (paramBundle != null)
      {
        this.bIi = paramBundle.getInt("key_req_src", 1);
        this.cCc = paramBundle.getString("third_app_id", "");
      }
    }
    QLog.d("Q.quicklogin.SwitchAccountActivity", 1, "mReqSrc:" + this.bIi);
    super.setTitle(2131696677);
    this.mProgress = new arhz(this, getTitleBarHeight());
    this.container = ((LinearLayout)super.findViewById(2131361915));
    this.awg = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    asaw.a().emz();
    this.accountList = aryn.eh();
    paramBundle = super.getIntent().getStringExtra("param_uin");
    if (this.accountList != null) {
      this.accountList.remove(paramBundle);
    }
    elA();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.mProgress != null) && (this.mProgress.isShowing())) {
      this.mProgress.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity
 * JD-Core Version:    0.7.0.1
 */