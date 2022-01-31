package com.tencent.mobileqq.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import cxl;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class JumpActivity
  extends BaseActivity
{
  public static final int a = 18;
  private static final String jdField_a_of_type_JavaLangString = "JumpAction";
  public static boolean a = false;
  public static final int b = 19;
  public static final int c = 20;
  public static final int d = 21;
  public static final int e = 1;
  private Uri jdField_a_of_type_AndroidNetUri;
  private QQMapActivityProxy jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  private void a(String paramString)
  {
    if ((paramString == null) || (this.jdField_d_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ("app".equals(this.jdField_b_of_type_JavaLangString));
        if (!"web".equals(this.jdField_b_of_type_JavaLangString)) {
          break;
        }
      } while (!"javascript".equals(this.jdField_c_of_type_JavaLangString));
      paramString = "javascript:" + this.jdField_d_of_type_JavaLangString + "('" + paramString + "')";
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localIntent.setData(Uri.parse(paramString));
      startActivity(localIntent);
      return;
    } while (!"internal".equals(this.jdField_b_of_type_JavaLangString));
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = getIntent();
    Bundle localBundle = ((Intent)localObject1).getExtras();
    if (localBundle == null) {
      localBundle = new Bundle();
    }
    for (;;)
    {
      Object localObject2;
      if ((paramBoolean) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()))
      {
        localObject2 = new Intent(this, LoginActivity.class);
        ((Intent)localObject2).putExtras(localBundle);
        ((Intent)localObject2).putExtras((Intent)localObject1);
        startActivityForResult((Intent)localObject2, 20);
      }
      do
      {
        return;
        localObject2 = ((Intent)localObject1).getType();
        localObject1 = ((Intent)localObject1).getData();
      } while (TextUtils.isEmpty((CharSequence)localObject2));
      StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_open_via_qq");
      Intent localIntent = new Intent(this, ForwardRecentActivity.class);
      if (((String)localObject2).startsWith("image")) {}
      for (int i = 1;; i = 0)
      {
        localBundle.putParcelable("android.intent.extra.STREAM", (Parcelable)localObject1);
        localIntent.putExtras(localBundle);
        localIntent.putExtra("isFromShare", true);
        localIntent.putExtra("forward_type", i);
        localIntent.setData((Uri)localObject1);
        localIntent.putExtra("sendMultiple", false);
        startActivity(localIntent);
        finish();
        return;
        localBundle.putBoolean("not_forward", true);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject1 = getIntent().getExtras();
    if (localObject1 == null) {
      finish();
    }
    do
    {
      return;
      if ((paramBoolean) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()))
      {
        localObject2 = new Intent(this, LoginActivity.class);
        ((Intent)localObject2).putExtra("isActionSend", true);
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ((Intent)localObject2).putExtras((Intent)localObject2);
        startActivityForResult((Intent)localObject2, 19);
        return;
      }
      ((Bundle)localObject1).getString("android.intent.extra.TITLE");
      ((Bundle)localObject1).getString("android.intent.extra.SUBJECT");
      localObject2 = ((Bundle)localObject1).getString("android.intent.extra.TEXT");
      ((Bundle)localObject1).getString("image_url");
      ((Bundle)localObject1).getString("detail_url");
      localObject3 = getIntent().getType();
    } while (TextUtils.isEmpty((CharSequence)localObject3));
    StatisticAssist.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "dl_share_frd");
    if ((((String)localObject3).startsWith("text")) && (!((Bundle)localObject1).containsKey("android.intent.extra.STREAM")))
    {
      localObject1 = new Intent(this, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("k_favorites", true);
      ((Intent)localObject1).putExtra("forward_type", -1);
      ((Intent)localObject1).putExtra("forward_text", (String)localObject2);
      startActivity((Intent)localObject1);
    }
    for (;;)
    {
      localObject1 = getIntent().getScheme();
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals("geo"))) {
        break label734;
      }
      localObject1 = new Intent(this, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtras(new Bundle());
      ((Intent)localObject1).putExtra("isFromShare", true);
      ((Intent)localObject1).putExtra("forward_type", -2);
      ((Intent)localObject1).setData(getIntent().getData());
      startActivity((Intent)localObject1);
      finish();
      return;
      if (!((String)localObject3).startsWith("message")) {
        break;
      }
      localObject2 = new Intent(this, ForwardRecentActivity.class);
      ((Intent)localObject2).putExtras(new Bundle());
      ((Intent)localObject2).putExtra("isFromShare", true);
      ((Intent)localObject2).putExtra("k_favorites", true);
      ((Intent)localObject2).putExtra("forward_type", -1);
      ((Intent)localObject2).putExtra("forward_text", (SpannableString)((Bundle)localObject1).get("android.intent.extra.TEXT"));
      startActivity((Intent)localObject2);
      finish();
    }
    if (((String)localObject3).startsWith("image"))
    {
      localObject2 = new Intent(this, ForwardRecentActivity.class);
      ((Intent)localObject2).putExtra("isFromShare", true);
      ((Intent)localObject2).putExtra("k_favorites", true);
      ((Intent)localObject2).putExtras(new Bundle());
      ((Intent)localObject2).putExtra("forward_type", 1);
      if (getIntent().getAction().equals("android.intent.action.SEND"))
      {
        localObject3 = ((Bundle)localObject1).get("android.intent.extra.STREAM");
        if (localObject3 != null) {
          if ((localObject3 instanceof Uri))
          {
            ((Intent)localObject2).setData((Uri)localObject3);
            label497:
            ((Intent)localObject2).putExtra("sendMultiple", false);
          }
        }
      }
      for (;;)
      {
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        startActivity((Intent)localObject2);
        break;
        if ((localObject3 instanceof String))
        {
          ((Intent)localObject2).setData(Uri.parse((String)localObject3));
          break label497;
        }
        finish();
        return;
        finish();
        return;
        ((Intent)localObject2).putExtra("sendMultiple", true);
        ((Intent)localObject2).putExtra("forward_text", getString(2131562870));
      }
    }
    Object localObject3 = getIntent().getAction();
    Object localObject2 = new Intent(this, ForwardRecentActivity.class);
    ((Intent)localObject2).putExtra("isFromShare", true);
    ((Intent)localObject2).putExtra("forward_type", 0);
    if (((String)localObject3).equals("android.intent.action.SEND"))
    {
      localObject3 = ((Bundle)localObject1).get("android.intent.extra.STREAM");
      if (localObject3 != null) {
        if ((localObject3 instanceof Uri))
        {
          ((Intent)localObject2).setData((Uri)localObject3);
          label654:
          ((Intent)localObject2).putExtra("sendMultiple", false);
        }
      }
    }
    for (;;)
    {
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      startActivity((Intent)localObject2);
      break;
      if ((localObject3 instanceof String))
      {
        ((Intent)localObject2).setData(Uri.parse((String)localObject3));
        break label654;
      }
      finish();
      return;
      finish();
      return;
      ((Intent)localObject2).putExtra("sendMultiple", true);
      ((Intent)localObject2).putExtra("forward_text", getString(2131562870));
    }
    label734:
    finish();
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = getIntent();
    if ((paramBoolean) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()))
    {
      jdField_a_of_type_Boolean = true;
      localObject = new Intent(this, LoginActivity.class);
      ((Intent)localObject).putExtra("isActionSend", true);
      ((Intent)localObject).putExtras((Intent)localObject);
      ((Intent)localObject).setFlags(16777216);
      startActivityForResult((Intent)localObject, 21);
      return;
    }
    jdField_a_of_type_Boolean = false;
    localObject = ((Intent)localObject).getDataString();
    JumpParser.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, (String)localObject).b();
    finish();
  }
  
  private void d()
  {
    String str1 = getPackageName();
    String str2 = InstallActivity.class.getName();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    localIntent.setComponent(new ComponentName(str1, str2));
    startActivity(localIntent);
    finish();
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      }
      startActivityForResult(new Intent(this, QQMapActivity.class).putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()), 18);
      return;
    }
    catch (Exception localException)
    {
      if (this.jdField_d_of_type_Boolean) {
        a("Google Map not exist");
      }
      finish();
    }
  }
  
  void a()
  {
    Object localObject = new File(AppConstants.an + "photo/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    this.jdField_a_of_type_AndroidNetUri = Uri.fromFile(new File(AppConstants.an + "photo/" + System.currentTimeMillis() + ".jpg"));
    localObject = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject).putExtra("output", this.jdField_a_of_type_AndroidNetUri);
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 100);
    startActivityForResult((Intent)localObject, 3);
  }
  
  void a(int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.setType("image/*");
    startActivityForResult(localIntent, paramInt);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("JumpActivity onActivityResult,requestCode=").append(paramInt1).append(",resultCode=").append(paramInt2).append(",data=");
      if (paramIntent == null) {
        break label149;
      }
    }
    label149:
    for (Object localObject = paramIntent.toString();; localObject = "null")
    {
      QLog.d("JumpAction", 2, (String)localObject);
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      if (paramInt2 != -1) {
        break;
      }
      switch (paramInt1)
      {
      default: 
        return;
      }
    }
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("changed", false);; bool = false)
    {
      if ((!bool) || (this.jdField_d_of_type_Boolean)) {
        a("HexUtil.bytes2HexStr(fileKey)");
      }
      finish();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = null;
      }
      localObject = paramIntent.getExtras();
      if (localObject == null) {
        break;
      }
      paramIntent = ((Bundle)localObject).getString("latitude");
      localObject = ((Bundle)localObject).getString("longitude");
      if (this.jdField_d_of_type_Boolean) {
        a("ret=0&lon=" + (String)localObject + "&lat=" + paramIntent);
      }
      finish();
      return;
      b(false);
      return;
      a(false);
      return;
      c(false);
      return;
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("roomId");
        if (paramIntent == null) {
          break;
        }
        localObject = new cxl(this);
        if (!ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, paramIntent, true, true, (Handler.Callback)localObject)) {
          break;
        }
        finish();
        return;
      }
      finish();
      return;
      finish();
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    super.doOnCreate(paramBundle);
    boolean bool1;
    if (BaseActivity.a(getIntent()))
    {
      finish();
      bool1 = true;
      return bool1;
    }
    paramBundle = getIntent();
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getAction())) && ((paramBundle.getAction().equals("android.intent.action.SEND")) || (paramBundle.getAction().equals("android.intent.action.SEND_MULTIPLE"))))
    {
      b(true);
      return false;
    }
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getAction())) && (paramBundle.getAction().equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(paramBundle.getScheme())) && ((paramBundle.getScheme().equals("file")) || (paramBundle.getScheme().equals("content"))))
    {
      a(true);
      return false;
    }
    if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle.getAction())) && (paramBundle.getAction().equals("android.intent.action.SENDTO")) && (!TextUtils.isEmpty(paramBundle.getScheme())) && (paramBundle.getScheme().equals("imto")))
    {
      d();
      return false;
    }
    paramBundle = getIntent().getDataString();
    Object localObject = getIntent().getStringExtra("from");
    String str = getCallingPackage();
    JumpAction localJumpAction;
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpAction", 2, "jump url:" + paramBundle);
      }
      localJumpAction = JumpParser.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, paramBundle);
      if (("webview".equals(localObject)) && (localJumpAction != null)) {
        localJumpAction.a((String)localObject);
      }
      if (localJumpAction != null) {
        if ((localJumpAction.bg == null) || (!localJumpAction.bg.equals("ptlogin")) || (localJumpAction.bh == null) || (!localJumpAction.bh.equals("qlogin"))) {
          break label885;
        }
      }
    }
    label885:
    for (int i = 0;; i = 1)
    {
      if (paramBundle.startsWith("mqqwpa://im"))
      {
        c(true);
        return false;
      }
      if ((!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) && (i != 0))
      {
        localObject = new StringBuilder().append(paramBundle);
        if (paramBundle.indexOf("?") > -1)
        {
          paramBundle = "&";
          paramBundle = paramBundle;
          paramBundle = paramBundle + "jfrom=login";
          localObject = new Intent(this, LoginActivity.class);
          ((Intent)localObject).putExtra("scheme_content", paramBundle);
          ((Intent)localObject).putExtra("pkg_name", str);
          ((Intent)localObject).putExtras((Intent)localObject);
          ((Intent)localObject).setFlags(268435456);
          startActivity((Intent)localObject);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpAction", 2, "JumpActivity is finish");
        }
        if ((localJumpAction.bg != null) && (localJumpAction.bh != null)) {
          break label638;
        }
        finish();
        return false;
        paramBundle = "?";
        break;
        if ((GesturePWDUtils.getJumpLock(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (!GesturePWDUtils.getAppForground(this)))
        {
          localObject = new Intent(a(), GesturePWDUnlockActivity.class);
          ((Intent)localObject).putExtra("key_gesture_from_jumpactivity", true);
          ((Intent)localObject).putExtra("scheme_content", paramBundle);
          ((Intent)localObject).putExtra("pkg_name", str);
          startActivity((Intent)localObject);
        }
        else
        {
          localJumpAction.b(str);
          bool2 = localJumpAction.b();
        }
      }
      label638:
      if ((localJumpAction.bg.equals("gav")) && (localJumpAction.bh.equals("request")))
      {
        bool1 = bool3;
        if ("0".equals(localJumpAction.a("relation_id"))) {
          break;
        }
        bool1 = bool3;
        if (!bool2) {
          break;
        }
        finish();
        return false;
      }
      if ((localJumpAction.bg.equals("videochat")) && (localJumpAction.bh.equals("request")))
      {
        bool1 = bool3;
        if (!bool2) {
          break;
        }
        finish();
        return false;
      }
      finish();
      return false;
      paramBundle = getIntent().getStringExtra("action");
      if (paramBundle == null)
      {
        finish();
        return false;
      }
      this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("doCallBack", false);
      this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("src_type");
      this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("callback_type");
      this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("callback_name");
      if ("photo".equals(paramBundle)) {
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        bool1 = bool3;
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        bool1 = bool3;
        if (!this.jdField_c_of_type_Boolean) {
          break;
        }
        e();
        return false;
        if ("select_location".equals(paramBundle)) {
          this.jdField_c_of_type_Boolean = true;
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_Boolean = false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("JumpAction", 2, "onAccountChanged" + localAppRuntime);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity
 * JD-Core Version:    0.7.0.1
 */