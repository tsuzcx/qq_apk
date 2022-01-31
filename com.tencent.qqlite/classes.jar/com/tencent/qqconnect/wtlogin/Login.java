package com.tencent.qqconnect.wtlogin;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import fil;
import fim;
import fin;
import fio;
import fip;
import fiq;
import fir;
import fis;
import fit;
import java.util.HashMap;
import java.util.List;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginLoginInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class Login
  extends IphoneTitleBarActivity
{
  public static final int a = 10000;
  protected static final String a = "Login";
  public static boolean a = false;
  protected static final int b = 1;
  protected static final String b = "Login";
  protected static final int c = 2;
  public static String c;
  protected static final int d = 6;
  public static String d;
  public static final int e = 7;
  public static final String e = "result_data";
  protected static final int f = 3100;
  public static final String f = "is_first_login";
  protected static final int g = 3101;
  protected static final int h = 3103;
  protected static final int i = 3104;
  public long a;
  public Handler a;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new fip(this);
  protected View.OnClickListener a;
  View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new fin(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new fio(this);
  public View a;
  public Button a;
  public EditText a;
  public TextView a;
  protected QQProgressDialog a;
  public OpenSDKAppInterface a;
  protected List a;
  public WtloginManager a;
  protected SSOAccountObserver a;
  public long b;
  TextWatcher b;
  public View b;
  public EditText b;
  public boolean b;
  boolean c;
  public int j = 1;
  
  static
  {
    jdField_c_of_type_JavaLangString = "";
    d = "";
    jdField_a_of_type_Boolean = false;
  }
  
  public Login()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new fil(this);
    this.jdField_b_of_type_AndroidTextTextWatcher = new fiq(this);
    this.jdField_a_of_type_AndroidOsHandler = new fir(this);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fis(this);
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
  
  public void a(String paramString)
  {
    if (!isFinishing()) {
      DialogUtil.b(this, 230).setMessageWithUrl(paramString).setTitle(getString(2131363284)).setPositiveButton(17039370, new fit(this)).show();
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((this.j == 2) || (this.j == 3))
    {
      paramString2 = "" + this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.Login", 2, "loginSucess");
      }
      paramString1 = new Intent();
      paramString1.putExtra("last_account", paramString2);
      paramString1.putExtra("isLogin", true);
      if (paramBundle != null)
      {
        paramString2 = paramBundle.getByteArray("st_temp");
        localObject1 = paramBundle.getByteArray("st_temp_key");
        paramString1.putExtra("st_temp", paramString2);
        paramString1.putExtra("st_temp_key", (byte[])localObject1);
      }
      paramString1.putExtra("ssobundle", paramBundle);
      setResult(-1, paramString1);
      finish();
      return;
    }
    Object localObject2 = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString1, (WloginSimpleInfo)localObject2);
    String str = "" + ((WloginSimpleInfo)localObject2)._uin;
    Object localObject1 = new Intent();
    localObject2 = new String(((WloginSimpleInfo)localObject2)._nick);
    if (paramString2 != null) {}
    for (paramString1 = new String(paramString2);; paramString1 = null)
    {
      ((Intent)localObject1).putExtra("result_data", a(str, paramString1));
      ((Intent)localObject1).putExtra("last_account", str);
      ((Intent)localObject1).putExtra("isLogin", true);
      ((Intent)localObject1).putExtra("nick", (String)localObject2);
      if (paramBundle != null)
      {
        paramString1 = paramBundle.getByteArray("st_temp");
        paramString2 = paramBundle.getByteArray("st_temp_key");
        ((Intent)localObject1).putExtra("st_temp", paramString1);
        ((Intent)localObject1).putExtra("st_temp_key", paramString2);
      }
      setResult(-1, (Intent)localObject1);
      break;
    }
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return false;
      int k = 0;
      while (k < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (((WloginLoginInfo)this.jdField_a_of_type_JavaUtilList.get(k)).mUin == paramLong) {
          return true;
        }
        k += 1;
      }
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_MqqManagerWtloginManager.GetAllLoginInfo();
  }
  
  public void d()
  {
    boolean bool = false;
    if ("".equals(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131363841), new Object[] { getResources().getString(2131362927), Integer.valueOf(3103) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("error", "3103");
      StatisticCollector.a(this).a("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    if ("".equals(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().trim()))
    {
      a(String.format(getResources().getString(2131363841), new Object[] { getResources().getString(2131362928), Integer.valueOf(3104) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("error", "3104");
      StatisticCollector.a(this).a("0", "connect_sso_authfail", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_b_of_type_Long = (((String)localObject).length() + str.length());
    if ((this.j == 2) || (this.j == 3))
    {
      if (this.j == 2) {
        bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1((String)localObject, 16L);
      }
      while (bool) {
        if (this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.quicklogin.Login", 2, "has aone");
          }
          a((String)localObject, null, null);
          return;
          if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd((String)localObject, 16)) {
            bool = true;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
          e();
          return;
        }
      }
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      e();
      return;
    }
    if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd((String)localObject, 16))
    {
      QLog.d("Login", 1, "send | cmd: s_s_o_l | uin : *" + AuthorityUtil.a((String)localObject));
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
    }
    for (;;)
    {
      e();
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        QLog.d("Login", 1, "send | cmd: g_t_n_p | uin : *" + AuthorityUtil.a((String)localObject));
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd((String)localObject, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      }
      else
      {
        QLog.d("Login", 1, "send | cmd: s_s_o_l | uin : *" + AuthorityUtil.a((String)localObject));
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoLogin((String)localObject, str, 4096, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      }
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getResources().getString(2131363838));
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {}
    while (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100) {
      if (paramInt2 == -1) {
        if (paramIntent != null) {}
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          Message localMessage = new Message();
          paramIntent = paramIntent.getExtras();
          localMessage.what = 6;
          localMessage.setData(paramIntent);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
          return;
        } while (paramInt2 != 0);
        f();
        return;
      } while (paramInt1 != 10000);
      if (paramInt2 == -1)
      {
        a(paramIntent.getStringExtra("last_account"), paramIntent.getStringExtra("wtTicket"), paramIntent.getBundleExtra("ssobundle"));
        return;
      }
    } while (paramInt2 != 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (getIntent().getExtras() != null) {
      this.j = getIntent().getExtras().getInt("key_req_src", 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.Login", 2, "oncreate mReqSrc:" + this.j);
    }
    setContentView(2130903650);
    if (getIntent().getBooleanExtra("is_first_login", false))
    {
      setTitle(2131363832);
      this.h.setText(2131363123);
    }
    for (;;)
    {
      this.h.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131298824);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131298825);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298827));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296459));
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131297281));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297484));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      findViewById(2131298826).requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(new fim(this));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
      c();
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(Login.class, this.jdField_a_of_type_AndroidOsHandler);
      return;
      setTitle(2131363831);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    f();
    this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_b_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(Login.class);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (jdField_a_of_type_Boolean == true)
    {
      jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(jdField_c_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetEditText.setText(d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login
 * JD-Core Version:    0.7.0.1
 */