package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import fbt;
import fbu;
import fbv;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class QuickLoginAuthorityActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected static final int a = 50;
  public static final String a = "isLogin";
  protected static final int b = 100;
  public static final String b = "Q.quicklogin.";
  protected static final int c = 1000;
  protected static final String c = "http://ptlogin2.qq.com,http://ptlogin2.soso.com,http://ptlogin2.paipai.com,http://ptlogin2.tenpay.com,http://ptlogin2.taotao.com,http://ptlogin2.tencent.com,http://ptlogin2.oa.com,http://ptlogin2.webdev.com,http://ptlogin2.3366.com,http://ptlogin2.imqq.com,http://ptlogin2.pengyou.com,http://ptlogin2.qplus.com,http://ptlogin2.qzone.com,http://ptlogin2.id.qq.com,http://ptlogin2.myapp.com,http://ptlogin2.kuyoo.cn,http://ptlogin2.function.qq.com,http://ptlogin2.crm2.qq.com,http://ptlogin2.weiyun.com,http://ptlogin2.wechatapp.com,http://ptlogin2.51buy.com,http://ptlogin2.qcloud.com,http://ptlogin2.wechat.com,http://ptlogin2.qmail.com,http://ptlogin2.ejinshang.com,http://ptlogin2.lvren.com,http://ptlogin2.weishi.com,https://ssl.ptlogin2.qq.com,https://ssl.ptlogin2.tenpay.com,https://ssl.ptlogin2.paipai.com,https://ssl.ptlogin2.soso.com,https://ssl.ptlogin2.3366.com,https://ssl.ptlogin2.pengyou.com,https://ssl.ptlogin2.imqq.com,https://ssl.ptlogin2.qzone.com,https://ssl.ptlogin2.qcloud.com,https://ssl.ptlogin2.51buy.com,https://ssl.ptlogin2.weiyun.com,https://ssl.ptlogin2.myapp.com,https://ssl.ptlogin2.yixun.com,https://ssl.ptlogin2.wanggou.com,https://ssl.ptlogin2.ejinshang.com";
  protected static final int d = 1001;
  protected static final int e = 1002;
  protected static final int f = 1003;
  protected float a;
  protected ProgressDialog a;
  protected SharedPreferences.Editor a;
  protected SharedPreferences a;
  public Bundle a;
  protected Handler a;
  protected Button a;
  protected FrameLayout a;
  protected RelativeLayout a;
  public CardContainer a;
  public OpenSDKAppInterface a;
  protected ArrayList a;
  protected List a;
  public WtloginManager a;
  protected SSOAccountObserver a;
  protected boolean a;
  public byte[] a;
  public Handler b;
  protected boolean b;
  public String d = null;
  protected String e = null;
  protected String f = "";
  
  public QuickLoginAuthorityActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqManagerWtloginManager = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new fbt(this);
    this.jdField_a_of_type_AndroidOsHandler = new fbu(this, ThreadManager.b());
    this.jdField_b_of_type_AndroidOsHandler = new fbv(this, Looper.getMainLooper());
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_errmsg", paramString2);
    localIntent.putExtra("quicklogin_uin", paramString1);
    localIntent.putExtra("quicklogin_ret", paramInt);
    localIntent.putExtra("quicklogin_buff", paramArrayOfByte);
    super.setResult(-1, localIntent);
    k();
    super.finish();
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "setSdkResult:error:" + paramString2);
    }
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
    Object localObject1 = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1);
    Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
    if (!TextUtils.isEmpty(paramString)) {}
    for (localObject1 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramString, (int)(58.0F * this.jdField_a_of_type_Float), true);; localObject1 = null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramString, (String)localObject2, (Bitmap)localObject1, true);
      if (localObject1 != null)
      {
        localObject2 = Message.obtain();
        ((Message)localObject2).what = 1000;
        ((Message)localObject2).obj = localObject1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      }
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      for (;;)
      {
        try
        {
          localObject1 = WtloginHelper.GetFastLoginUrl((String)localObject2, Long.valueOf(Long.parseLong(paramString)).longValue());
          if (localObject1 == null) {
            break;
          }
          if (!TextUtils.isEmpty(((WFastLoginInfo)localObject1).iconUrl))
          {
            paramString = Message.obtain();
            paramString.what = 1001;
            paramString.obj = ((WFastLoginInfo)localObject1).iconUrl;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
          }
          str = "";
        }
        catch (NumberFormatException paramString)
        {
          for (;;)
          {
            try
            {
              paramString = super.getPackageManager();
            }
            catch (PackageManager.NameNotFoundException paramString)
            {
              String str;
              Object localObject3;
              paramString = null;
            }
            try
            {
              localObject3 = paramString.getApplicationInfo((String)localObject2, 0);
              localObject2 = paramString;
              paramString = (String)localObject3;
              localObject3 = str;
              if (paramString != null) {
                localObject3 = (String)((PackageManager)localObject2).getApplicationLabel(paramString);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a((String)localObject3, null);
              }
              if (TextUtils.isEmpty(((WFastLoginInfo)localObject1).adUrl)) {
                break;
              }
              paramString = new StringBuffer(((WFastLoginInfo)localObject1).adUrl);
              this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setAdImageByURL(null, paramString.replace(0, 4, "gamead").toString());
              return;
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException)
            {
              break label333;
            }
          }
          paramString = paramString;
          if (QLog.isColorLevel()) {
            QLog.d("Q.quicklogin.", 2, "Long.parseLong(uin) has NumberFormatException" + paramString.getMessage());
          }
          localObject1 = null;
          continue;
        }
        label333:
        localObject2 = paramString;
        paramString = null;
      }
    }
  }
  
  protected void c()
  {
    this.h.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131297484));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    setRightButton(2131363819, this);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131297483));
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("last_account", paramString);
    Object localObject2 = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "LocalAccountCache:");
    }
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
    this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    i();
    h();
  }
  
  protected void e()
  {
    f();
  }
  
  protected void f()
  {
    if (TextUtils.isEmpty(this.d)) {}
    Bitmap localBitmap;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.", 2, "updatePortrait");
      }
      localBitmap = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.d, (int)(58.0F * this.jdField_a_of_type_Float), true);
    } while (localBitmap == null);
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a("", "", localBitmap, false);
  }
  
  protected boolean f()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    for (;;)
    {
      return false;
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("retPath");
      Object localObject;
      try
      {
        localObject = new URL(str1);
        if (TextUtils.isEmpty(str1)) {
          continue;
        }
        String str2 = ((URL)localObject).getProtocol();
        localObject = ((URL)localObject).getHost();
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject)))
        {
          QLog.i("Q.quicklogin.", 2, "protocal:" + str2 + ",host:" + (String)localObject);
          return false;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.i("Q.quicklogin.", 2, "url:" + str1 + "err msg:" + localMalformedURLException.getMessage());
        localMalformedURLException.printStackTrace();
        return false;
      }
      String[] arrayOfString = "http://ptlogin2.qq.com,http://ptlogin2.soso.com,http://ptlogin2.paipai.com,http://ptlogin2.tenpay.com,http://ptlogin2.taotao.com,http://ptlogin2.tencent.com,http://ptlogin2.oa.com,http://ptlogin2.webdev.com,http://ptlogin2.3366.com,http://ptlogin2.imqq.com,http://ptlogin2.pengyou.com,http://ptlogin2.qplus.com,http://ptlogin2.qzone.com,http://ptlogin2.id.qq.com,http://ptlogin2.myapp.com,http://ptlogin2.kuyoo.cn,http://ptlogin2.function.qq.com,http://ptlogin2.crm2.qq.com,http://ptlogin2.weiyun.com,http://ptlogin2.wechatapp.com,http://ptlogin2.51buy.com,http://ptlogin2.qcloud.com,http://ptlogin2.wechat.com,http://ptlogin2.qmail.com,http://ptlogin2.ejinshang.com,http://ptlogin2.lvren.com,http://ptlogin2.weishi.com,https://ssl.ptlogin2.qq.com,https://ssl.ptlogin2.tenpay.com,https://ssl.ptlogin2.paipai.com,https://ssl.ptlogin2.soso.com,https://ssl.ptlogin2.3366.com,https://ssl.ptlogin2.pengyou.com,https://ssl.ptlogin2.imqq.com,https://ssl.ptlogin2.qzone.com,https://ssl.ptlogin2.qcloud.com,https://ssl.ptlogin2.51buy.com,https://ssl.ptlogin2.weiyun.com,https://ssl.ptlogin2.myapp.com,https://ssl.ptlogin2.yixun.com,https://ssl.ptlogin2.wanggou.com,https://ssl.ptlogin2.ejinshang.com".split(",");
      if ((str1 == null) || (arrayOfString == null) || (arrayOfString.length <= 0))
      {
        QLog.i("Q.quicklogin.", 2, "strArray null");
        return false;
      }
      int i;
      while (i < arrayOfString.length)
      {
        URL localURL = new URL(arrayOfString[i]);
        if (localMalformedURLException.equalsIgnoreCase(localURL.getProtocol()))
        {
          boolean bool = ((String)localObject).equalsIgnoreCase(localURL.getHost());
          if (bool) {
            return true;
          }
        }
        i += 1;
        continue;
        i = 0;
      }
    }
  }
  
  protected void g()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    int j = i;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      j = i + this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "changeAccountActivity count:" + j);
    }
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
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
    {
      g();
      return;
    }
    if (!TextUtils.isEmpty(super.getAppRuntime().getAccount()))
    {
      this.d = super.getAppRuntime().getAccount();
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.", 2, "getAppRuntime().getAccount(),currentAccount null?" + TextUtils.isEmpty(this.d));
      }
    }
    if (!TextUtils.isEmpty(this.e))
    {
      this.d = this.e;
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.", 2, "login mAccountString :" + this.e);
      }
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
      for (;;)
      {
        if (!bool) {
          break label217;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.quicklogin.", 2, "login have");
        return;
        bool = false;
        continue;
        bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.d, 16L);
      }
      label217:
      g();
      QQToast.a(this, 2131363835, 0).b(getResources().getDimensionPixelSize(2131492887));
      return;
    }
    g();
  }
  
  public void i()
  {
    this.d = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_account", null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "getLoginAccounts currentAccount empty?" + TextUtils.isEmpty(this.d));
    }
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
  
  public void j()
  {
    super.setResult(-1, new Intent());
    k();
    super.finish();
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "setPtloginSdkResult:");
    }
  }
  
  public void k()
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
  
  protected void l()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(super.getString(2131363832));
    if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "doAuthorize");
    }
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onActivityResult: resultcode:").append(paramInt2).append("requestCode:").append(paramInt1).append("data null?");
      if (paramIntent == null)
      {
        bool = true;
        QLog.d("Q.quicklogin.", 2, bool);
      }
    }
    else
    {
      if (paramInt1 != 100) {
        break label107;
      }
      if (paramInt2 != -1) {
        break label101;
      }
      if (paramIntent != null) {
        this.e = paramIntent.getStringExtra("uin");
      }
      d();
    }
    label101:
    label107:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        a(null);
        return;
        k();
        if (paramInt2 != 0) {
          break label128;
        }
      } while (this.d != null);
      a(paramIntent);
      return;
    } while ((-1 != paramInt2) || (!this.jdField_a_of_type_Boolean));
    label128:
    this.d = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null) {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.d, (WloginSimpleInfo)localObject);
    }
    for (paramIntent = new String(((WloginSimpleInfo)localObject)._nick);; paramIntent = paramIntent.getStringExtra("nick"))
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.d, paramIntent, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.", 2, "isLogin:" + bool);
        }
        c(this.d);
      }
      e();
      l();
      return;
    }
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "onBackPressed");
    }
    a(null);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {}
    do
    {
      return;
      if (paramView == this.h)
      {
        a(null);
        return;
      }
      if (paramView == this.j)
      {
        g();
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
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.", 2, "onClick login have");
      }
      l();
      return;
      bool = false;
      continue;
      bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.d, 16L);
    }
    g();
    QQToast.a(this, 2131363835, 0).b(super.getResources().getDimensionPixelSize(2131492887));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "onCreate:");
    }
    super.setContentView(2130903280);
    this.h.setText(2131363823);
    super.setTitle(2131363821);
    c();
    paramBundle = super.getIntent().getStringExtra("key_action");
    this.jdField_b_of_type_Boolean = "action_ptlogin_login".equals(paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    this.f = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
    if (!c())
    {
      Toast.makeText(this, "参数错误", 0).show();
      a(null);
    }
    label233:
    do
    {
      return;
      if ((this.jdField_b_of_type_Boolean) && (!f()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.", 2, "filter error:");
        }
        a(null);
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("publickey");
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("pubkey got. is null ?");
          if (this.jdField_a_of_type_ArrayOfByte != null) {
            break label233;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          QLog.d("Q.quicklogin.", 2, bool);
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
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QLog.d("Q.quicklogin.", 2, "ondestroy");
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity
 * JD-Core Version:    0.7.0.1
 */