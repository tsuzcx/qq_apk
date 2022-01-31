package com.tencent.open.agent;

import android.annotation.SuppressLint;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import fcb;
import fcc;
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
  protected static final int a = 1;
  public static final long a = 16L;
  protected static final String a = "SwitchAccountActivity";
  public static final String c = "result_data";
  public static final String d = "SwitchAccountActivity";
  protected float a;
  protected SharedPreferences.Editor a;
  protected SharedPreferences a;
  protected View.OnTouchListener a;
  protected LinearLayout a;
  protected QQProgressDialog a;
  public OpenSDKAppInterface a;
  protected ArrayList a;
  public WtloginManager a;
  protected SSOAccountObserver a;
  public boolean a;
  protected int b;
  public long b;
  protected String b;
  protected ArrayList b;
  
  public SwitchAccountActivity()
  {
    this.jdField_a_of_type_MqqManagerWtloginManager = null;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new fcb(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new fcc(this);
  }
  
  public static String a(String paramString1, String paramString2)
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
  
  protected void a(String paramString)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");
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
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("accList", (String)localObject1);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
    if (paramString.equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_account", ""))) {
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove("last_account").commit();
    }
    long l = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    localObject1 = new File(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b("" + l));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).delete();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (!((View)localObject1).getTag().equals(paramString)) {
          break label386;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)localObject1);
        if (i == 0)
        {
          paramString = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 1) {
            break label379;
          }
          paramString.setBackgroundResource(2130837924);
        }
      }
      return;
      label379:
      paramString.setBackgroundResource(2130837927);
      return;
      label386:
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "loginSucess");
      }
      paramString2 = new WloginSimpleInfo();
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.jdField_b_of_type_JavaLangString, paramString2);
      paramString2 = new Intent();
      paramString1 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
      paramString2.putExtra("last_account", paramString1);
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString1))
      {
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
        paramString2.putExtra("isLogin", false);
      }
    }
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString1, (WloginSimpleInfo)localObject);
    Intent localIntent = new Intent();
    String str = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
    localObject = new String(((WloginSimpleInfo)localObject)._nick);
    if (paramString2 != null)
    {
      paramString1 = new String(paramString2);
      label245:
      localIntent.putExtra("result_data", a(str, paramString1));
      localIntent.putExtra("nick", (String)localObject);
      localIntent.putExtra("last_account", str);
      if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(str)) && (!this.jdField_b_of_type_JavaUtilArrayList.contains(str))) {
        break label367;
      }
      localIntent.putExtra("isLogin", true);
    }
    for (;;)
    {
      if (paramBundle != null)
      {
        paramString1 = paramBundle.getByteArray("st_temp");
        paramString2 = paramBundle.getByteArray("st_temp_key");
        localIntent.putExtra("st_temp", paramString1);
        localIntent.putExtra("st_temp_key", paramString2);
      }
      super.setResult(-1, localIntent);
      break;
      paramString1 = null;
      break label245;
      label367:
      localIntent.putExtra("isLogin", false);
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void c()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");
    }
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int j;
    Object localObject2;
    if (localObject1 != null)
    {
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        i += 1;
      }
    }
    while (this.jdField_a_of_type_JavaUtilArrayList.contains("")) {
      this.jdField_a_of_type_JavaUtilArrayList.remove("");
    }
    localObject1 = super.getIntent().getStringExtra("param_uin");
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (!((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(localObject1)) {
          break label233;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList = MsfSdkUtils.getLoginedAccountList();
    int i = 0;
    label181:
    if (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      localObject2 = (SimpleAccount)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (!((SimpleAccount)localObject2).isLogined()) {
        this.jdField_b_of_type_JavaUtilArrayList.remove(i);
      }
      for (j = i - 1;; j = i - 1)
      {
        i = j + 1;
        break label181;
        label233:
        i += 1;
        break;
        if (!((SimpleAccount)localObject2).getUin().equals(localObject1)) {
          break label269;
        }
        this.jdField_b_of_type_JavaUtilArrayList.remove(i);
      }
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        if (((String)this.jdField_a_of_type_JavaUtilArrayList.get(k)).equals(((SimpleAccount)localObject2).getUin())) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(k);
        }
        k += 1;
      }
    }
    label269:
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return;
    }
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    LayoutInflater localLayoutInflater = super.getLayoutInflater();
    int k = 0;
    int i = 0;
    int j = i;
    Object localObject4;
    Object localObject6;
    Object localObject5;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      j = i;
      if (k < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject4 = localLayoutInflater.inflate(2130903041, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        localObject6 = (TextView)((View)localObject4).findViewById(2131296443);
        TextView localTextView = (TextView)((View)localObject4).findViewById(2131296444);
        localObject5 = (ImageView)((View)localObject4).findViewById(2131296439);
        localObject1 = new WloginSimpleInfo();
        SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_b_of_type_JavaUtilArrayList.get(k);
        localObject2 = localSimpleAccount.getUin();
        this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo((String)localObject2, (WloginSimpleInfo)localObject1);
        localObject3 = new String(((WloginSimpleInfo)localObject1)._nick);
        localObject1 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = localObject2;
        }
        ((TextView)localObject6).setText((CharSequence)localObject1);
        localTextView.setText((CharSequence)localObject2);
        localObject1 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a("" + localSimpleAccount.getUin(), (int)(60.0F * this.jdField_a_of_type_Float), true);
        if (localObject1 != null)
        {
          localObject3 = AuthorityUtil.a(this, (Bitmap)localObject1, 63, 63);
          ((Bitmap)localObject1).recycle();
          if (localObject3 != null) {
            ((ImageView)localObject5).setImageBitmap((Bitmap)localObject3);
          }
        }
        if (i == 0) {
          ((View)localObject4).setBackgroundResource(2130837927);
        }
        ((Button)((View)localObject4).findViewById(2131296442)).setOnClickListener(this);
        ((View)localObject4).setOnClickListener(this);
        ((View)localObject4).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((View)localObject4).setTag(localObject2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
        i += 1;
        if (i < 10) {
          break label664;
        }
        j = i;
      }
    }
    i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (i >= 0))
      {
        localObject1 = localLayoutInflater.inflate(2130903041, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        localObject4 = (TextView)((View)localObject1).findViewById(2131296443);
        localObject5 = (TextView)((View)localObject1).findViewById(2131296444);
        localObject2 = (ImageView)((View)localObject1).findViewById(2131296439);
        localObject3 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject6 = new WloginSimpleInfo();
        this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo((String)localObject3, (WloginSimpleInfo)localObject6);
        localObject6 = new String(((WloginSimpleInfo)localObject6)._nick);
        ((TextView)localObject4).setText(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.c((String)localObject6));
        ((TextView)localObject5).setText((CharSequence)localObject3);
        localObject4 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a("" + (String)localObject3, (int)(60.0F * this.jdField_a_of_type_Float), true);
        if (localObject4 != null)
        {
          localObject5 = AuthorityUtil.a(this, (Bitmap)localObject4, 63, 63);
          ((Bitmap)localObject4).recycle();
          if (localObject5 != null) {
            ((ImageView)localObject2).setImageBitmap((Bitmap)localObject5);
          }
        }
        if (j == 0) {
          ((View)localObject1).setBackgroundResource(2130837927);
        }
        ((Button)((View)localObject1).findViewById(2131296442)).setOnClickListener(this);
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((View)localObject1).setTag(localObject3);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        j += 1;
        if (j < 10) {}
      }
      else
      {
        localObject1 = localLayoutInflater.inflate(2130903046, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(this);
        return;
        label664:
        k += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    Intent localIntent = new Intent(this, Login.class);
    localIntent.putExtra("key_req_src", this.jdField_b_of_type_Int);
    super.startActivityForResult(localIntent, 1);
  }
  
  protected void f()
  {
    if (this.jdField_b_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.jdField_b_of_type_JavaLangString, 16L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "has aone");
        }
        a(this.jdField_b_of_type_JavaLangString, null, null);
        return;
      }
      e();
      return;
    }
    if (this.jdField_b_of_type_Int == 3)
    {
      if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_b_of_type_JavaLangString, 16))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "has atwo");
        }
        a(this.jdField_b_of_type_JavaLangString, null, null);
        return;
      }
      e();
      return;
    }
    if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.jdField_b_of_type_JavaLangString, 16)) {
      e();
    }
    for (;;)
    {
      g();
      return;
      QLog.d("SwitchAccountActivity", 1, "send | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.jdField_b_of_type_JavaLangString, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(super.getString(2131363827));
    if ((!super.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        super.getIntent().getStringExtra("key_action");
        if (paramInt2 != 0) {
          break;
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    } while (-1 != paramInt2);
    super.setResult(-1, paramIntent);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131296442: 
    case 2131296438: 
      do
      {
        do
        {
          return;
          paramView = (View)paramView.getParent().getParent();
        } while ((paramView == null) || (paramView.getTag() == null));
        a((String)paramView.getTag());
        return;
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_b_of_type_JavaLangString = ((String)paramView.getTag());
      f();
      return;
    }
    e();
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903655);
    this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    if (super.getIntent().getExtras() != null) {
      this.jdField_b_of_type_Int = super.getIntent().getExtras().getInt("key_req_src", 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.SwitchAccountActivity", 2, "mReqSrc:" + this.jdField_b_of_type_Int);
    }
    super.setTitle(2131363819);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131298835));
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    c();
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity
 * JD-Core Version:    0.7.0.1
 */