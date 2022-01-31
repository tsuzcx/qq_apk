package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import hnp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class QuickLoginAuthorityActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected static final int a = 100;
  public static final String a = "isLogin";
  public static String b;
  protected static final String c = "http://ptlogin2.qq.com/jump,ptlogin2.qq.com,ptlogin2.soso.com,ptlogin2.paipai.com,ptlogin2.tenpay.com,ptlogin2.taotao.com,ptlogin2.tencent.com,ptlogin2.oa.com,ptlogin2.webdev.com,ptlogin2.3366.com,ptlogin2.imqq.com,ptlogin2.pengyou.com,ptlogin2.qplus.com,ptlogin2.qzone.com,ptlogin2.server.com,ptlogin2.id.qq.com,ptlogin2.myapp.com,ptlogin2.kuyoo.cn,ptlogin2.function.qq.com,ptlogin2.crm2.qq.com,ptlogin2.weiyun.com,ptlogin2.wechatapp.com,ptlogin2.51buy.com,ptlogin2.qcloud.com,ptlogin2.wechat.com,ssl.ptlogin2.qq.com,ssl.ptlogin2.tenpay.com,ssl.ptlogin2.paipai.com,ssl.ptlogin2.soso.com,ssl.ptlogin2.3366.com,ssl.ptlogin2.pengyou.com,ssl.ptlogin2.imqq.com,ssl.ptlogin2.qzone.com,ssl.ptlogin2.qcloud.com,ssl.ptlogin2.51buy.com,ssl.ptlogin2.weiyun.com,ssl.ptlogin2.myapp.com,ptlogin2.qmail.com,ptlogin2.ejinshang.com,ptlogin2.lvren.com,ssl.ptlogin2.yixun.com,ssl.ptlogin2.wanggou.com,ssl.ptlogin2.ejinshang.com,ptlogin2.weishi.com";
  protected float a;
  protected ProgressDialog a;
  protected SharedPreferences.Editor a;
  protected SharedPreferences a;
  public Bundle a;
  protected Button a;
  protected FrameLayout a;
  protected ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  public OpenSDKAppInterface a;
  protected ArrayList a;
  protected List a;
  public WtloginManager a;
  protected SSOAccountObserver a;
  protected boolean a;
  public byte[] a;
  protected TextView b;
  protected boolean b;
  public String d = null;
  protected String e = null;
  protected String f = "";
  
  static
  {
    jdField_b_of_type_JavaLangString = "Q.quicklogin.";
  }
  
  public QuickLoginAuthorityActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqManagerWtloginManager = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new hnp(this);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_errmsg", paramString2);
    localIntent.putExtra("quicklogin_uin", paramString1);
    localIntent.putExtra("quicklogin_ret", paramInt);
    localIntent.putExtra("quicklogin_buff", paramArrayOfByte);
    super.setResult(-1, localIntent);
    m();
    super.finish();
    QLog.d(jdField_b_of_type_JavaLangString, 2, "setSdkResult:error:" + paramString2);
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      super.setResult(0);
    }
    for (;;)
    {
      super.finish();
      return;
      super.setResult(0, paramIntent);
    }
  }
  
  public void a(String paramString)
  {
    Intent localIntent = new Intent(this, Login.class);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    if (this.jdField_b_of_type_Boolean) {
      localIntent.putExtra("key_req_src", 3);
    }
    for (;;)
    {
      super.startActivityForResult(localIntent, 1);
      return;
      localIntent.putExtra("key_req_src", 2);
    }
  }
  
  public String[] a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new String[] { paramString1 };
    }
    return new String[] { paramString1.substring(0, i), paramString1.substring(i + paramString2.length(), paramString1.length()) };
  }
  
  protected void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject);
    localObject = new String(((WloginSimpleInfo)localObject)._nick);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    h();
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    QLog.d(jdField_b_of_type_JavaLangString, 2, "LocalAccountCache:");
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {}
    for (Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          ((ArrayList)localObject2).add(localObject1[i]);
          i += 1;
        }
      }
      while (((ArrayList)localObject2).contains("")) {
        ((ArrayList)localObject2).remove("");
      }
      if (!((ArrayList)localObject2).contains(paramString)) {
        ((ArrayList)localObject2).add(paramString);
      }
      for (;;)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        for (paramString = ""; ((Iterator)localObject1).hasNext(); paramString = paramString + "," + (String)localObject2) {
          localObject2 = (String)((Iterator)localObject1).next();
        }
        ((ArrayList)localObject2).remove(paramString);
        ((ArrayList)localObject2).add(paramString);
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("accList", paramString);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    do
    {
      return false;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("retPath")));
    do
    {
      return true;
      if ((this.jdField_a_of_type_AndroidOsBundle.getByteArray("publickey") == null) || (this.f == null) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("dstSsoVer")) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("subDstAppid")) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("dstAppid"))) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstAppVer"));
    return false;
  }
  
  protected void d()
  {
    this.k.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232095));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131232093));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232090));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232092));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232091));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131232096));
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    e();
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  protected void f()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    k();
    j();
  }
  
  protected boolean f()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    for (;;)
    {
      return false;
      Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("retPath");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = a((String)localObject, "?");
        if (localObject.length >= 2)
        {
          localObject = localObject[0];
          String[] arrayOfString = "http://ptlogin2.qq.com/jump,ptlogin2.qq.com,ptlogin2.soso.com,ptlogin2.paipai.com,ptlogin2.tenpay.com,ptlogin2.taotao.com,ptlogin2.tencent.com,ptlogin2.oa.com,ptlogin2.webdev.com,ptlogin2.3366.com,ptlogin2.imqq.com,ptlogin2.pengyou.com,ptlogin2.qplus.com,ptlogin2.qzone.com,ptlogin2.server.com,ptlogin2.id.qq.com,ptlogin2.myapp.com,ptlogin2.kuyoo.cn,ptlogin2.function.qq.com,ptlogin2.crm2.qq.com,ptlogin2.weiyun.com,ptlogin2.wechatapp.com,ptlogin2.51buy.com,ptlogin2.qcloud.com,ptlogin2.wechat.com,ssl.ptlogin2.qq.com,ssl.ptlogin2.tenpay.com,ssl.ptlogin2.paipai.com,ssl.ptlogin2.soso.com,ssl.ptlogin2.3366.com,ssl.ptlogin2.pengyou.com,ssl.ptlogin2.imqq.com,ssl.ptlogin2.qzone.com,ssl.ptlogin2.qcloud.com,ssl.ptlogin2.51buy.com,ssl.ptlogin2.weiyun.com,ssl.ptlogin2.myapp.com,ptlogin2.qmail.com,ptlogin2.ejinshang.com,ptlogin2.lvren.com,ssl.ptlogin2.yixun.com,ssl.ptlogin2.wanggou.com,ssl.ptlogin2.ejinshang.com,ptlogin2.weishi.com".split(",");
          if ((localObject != null) && (arrayOfString != null) && (arrayOfString.length > 0))
          {
            int i = 0;
            while (i < arrayOfString.length)
            {
              if (((String)localObject).contains(arrayOfString[i])) {
                return true;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  protected void g()
  {
    h();
  }
  
  protected void h()
  {
    if (TextUtils.isEmpty(this.d)) {
      return;
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "updatePortrait");
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.d, (int)(58.0F * this.jdField_a_of_type_Float), true);
    if (localBitmap != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838016);
  }
  
  protected void i()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    int j = i;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      j = i + this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "changeAccountActivity count:" + j);
    if (j > 1)
    {
      Intent localIntent = new Intent(this, SwitchAccountActivity.class);
      if (this.d != null) {
        localIntent.putExtra("param_uin", this.d);
      }
      if (this.jdField_b_of_type_Boolean) {
        localIntent.putExtra("key_req_src", 3);
      }
      for (;;)
      {
        super.startActivityForResult(localIntent, 1);
        return;
        localIntent.putExtra("key_req_src", 2);
      }
    }
    a(this.d);
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
    {
      i();
      return;
    }
    if (!TextUtils.isEmpty(super.getAppRuntime().getAccount()))
    {
      this.d = super.getAppRuntime().getAccount();
      QLog.d(jdField_b_of_type_JavaLangString, 2, "getAppRuntime().getAccount(),currentAccount null?" + TextUtils.isEmpty(this.d));
    }
    if (!TextUtils.isEmpty(this.e))
    {
      this.d = this.e;
      QLog.d(jdField_b_of_type_JavaLangString, 2, "login mAccountString :" + this.e);
    }
    b(this.d);
    if (!TextUtils.isEmpty(this.d))
    {
      boolean bool;
      if (this.jdField_b_of_type_Boolean) {
        if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.d, 16)) {
          bool = true;
        }
      }
      while (bool)
      {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "login have");
        return;
        bool = false;
        continue;
        bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.d, 16L);
      }
      i();
      QQToast.a(this, 2131562634, 0).b(getResources().getDimensionPixelSize(2131427376));
      return;
    }
    i();
  }
  
  public void k()
  {
    this.d = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_account", null);
    QLog.d(jdField_b_of_type_JavaLangString, 2, "getLoginAccounts currentAccount empty?" + TextUtils.isEmpty(this.d));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {}
    for (Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");; localObject1 = null)
    {
      int j;
      if (localObject1 != null)
      {
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      while (this.jdField_a_of_type_JavaUtilList.contains("")) {
        this.jdField_a_of_type_JavaUtilList.remove("");
      }
      this.jdField_a_of_type_JavaUtilArrayList = MsfSdkUtils.getLoginedAccountList();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (!((SimpleAccount)localObject1).isLogined())
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          j = i - 1;
          i = j + 1;
        }
        else
        {
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= this.jdField_a_of_type_JavaUtilList.size()) {
              break;
            }
            if (((String)this.jdField_a_of_type_JavaUtilList.get(k)).equals(((SimpleAccount)localObject1).getUin())) {
              this.jdField_a_of_type_JavaUtilList.remove(k);
            }
            k += 1;
          }
        }
      }
      return;
    }
  }
  
  public void l()
  {
    super.setResult(-1, new Intent());
    m();
    super.finish();
    QLog.d(jdField_b_of_type_JavaLangString, 2, "setPtloginSdkResult:");
  }
  
  public void m()
  {
    if ((!super.isFinishing()) && (this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void n()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(super.getString(2131562312));
    if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "doAuthorize");
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.d, 32, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      return;
    }
    long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("dstSsoVer", 0L);
    long l2 = this.jdField_a_of_type_AndroidOsBundle.getLong("subDstAppid", 0L);
    long l3 = this.jdField_a_of_type_AndroidOsBundle.getLong("dstAppid", 0L);
    byte[] arrayOfByte1 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("dstAppVer");
    byte[] arrayOfByte2 = this.jdField_a_of_type_MqqManagerWtloginManager.getPkgSigFromApkName(this, this.f);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetA1WithA1(this.d, this.f.getBytes(), l1, l3, l2, arrayOfByte1, arrayOfByte2, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onActivityResult: resultcode:").append(paramInt2).append("requestCode:").append(paramInt1).append("data null?");
    if (paramIntent == null)
    {
      bool = true;
      QLog.d((String)localObject, 2, bool);
      if (paramInt1 != 100) {
        break label106;
      }
      if (paramInt2 != -1) {
        break label100;
      }
      if (paramIntent != null) {
        this.e = paramIntent.getStringExtra("uin");
      }
      f();
    }
    label100:
    label106:
    label127:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        a(null);
        return;
        m();
        if (paramInt2 != 0) {
          break label127;
        }
      } while (this.d != null);
      a(paramIntent);
      return;
    } while ((-1 != paramInt2) || (!this.jdField_a_of_type_Boolean));
    this.d = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    localObject = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null) {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.d, (WloginSimpleInfo)localObject);
    }
    for (paramIntent = new String(((WloginSimpleInfo)localObject)._nick);; paramIntent = paramIntent.getStringExtra("nick"))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramIntent);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
      if (bool)
      {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "isLogin:" + bool);
        c(this.d);
      }
      g();
      n();
      return;
    }
  }
  
  public void onBackPressed()
  {
    QLog.d(jdField_b_of_type_JavaLangString, 2, "onBackPressed");
    a(null);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {}
    do
    {
      return;
      if (paramView == this.k)
      {
        a(null);
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidWidgetRelativeLayout)
      {
        i();
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetButton);
    boolean bool;
    if (this.jdField_b_of_type_Boolean) {
      if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.d, 16)) {
        bool = true;
      }
    }
    while (bool)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onClick login have");
      n();
      return;
      bool = false;
      continue;
      bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.d, 16L);
    }
    i();
    QQToast.a(this, 2131562634, 0).b(super.getResources().getDimensionPixelSize(2131427376));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d(jdField_b_of_type_JavaLangString, 2, "onCreate:");
    super.setContentView(2130903326);
    this.k.setText(2131561690);
    super.setTitle(2131562740);
    d();
    paramBundle = super.getIntent().getStringExtra("key_action");
    this.jdField_b_of_type_Boolean = "action_ptlogin_login".equals(paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    this.f = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
    if (!c())
    {
      Toast.makeText(this, "参数错误", 0).show();
      a(null);
    }
    do
    {
      return;
      if ((this.jdField_b_of_type_Boolean) && (!f()))
      {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "filter error:");
        a(null);
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("publickey");
        String str = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("pubkey got. is null ?");
        if (this.jdField_a_of_type_ArrayOfByte == null) {}
        for (boolean bool = true;; bool = false)
        {
          QLog.d(str, 2, bool);
          if (this.jdField_a_of_type_ArrayOfByte != null) {
            break;
          }
          a(null);
          return;
        }
      }
      OpensdkPreference.a(this, "uin_store");
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCanceledOnTouchOutside(false);
    } while ((!"action_ptlogin_login".equals(paramBundle)) && (!"action_quick_login".equals(paramBundle)));
    this.jdField_a_of_type_Boolean = true;
    paramBundle = super.getAppRuntime().getAccount();
    if ((GesturePWDUtils.getJumpLock(this, paramBundle)) && (!GesturePWDUtils.getAppForground(this)))
    {
      this.e = paramBundle;
      paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
      paramBundle.putExtra("key_gesture_from_authority", true);
      super.startActivityForResult(paramBundle, 100);
      return;
    }
    f();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QLog.d(jdField_b_of_type_JavaLangString, 2, "ondestroy");
    m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity
 * JD-Core Version:    0.7.0.1
 */