package com.tencent.mobileqq.activity;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import arp;
import arq;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.qqfav.QfavUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.AppRuntime;

public class JumpActivity
  extends BaseActivity
{
  public static final int a = 18;
  private static final String jdField_a_of_type_JavaLangString = "JumpAction";
  public static boolean a = false;
  public static final int b = 19;
  public static final int c = 20;
  public static final int d = 21;
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
  
  public static String a(Context paramContext, Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        int i = paramContext.getColumnIndexOrThrow("_data");
        paramContext.moveToFirst();
        paramUri = paramContext.getString(i);
        paramContext.close();
        return paramUri;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    new arp(this, paramIntent, paramBundle).run();
  }
  
  private void a(Bundle paramBundle)
  {
    new arq(this, paramBundle).run();
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
      localIntent.putExtra("uin", this.app.a());
      localIntent.setData(Uri.parse(paramString));
      startActivity(localIntent);
      return;
    } while (!"internal".equals(this.jdField_b_of_type_JavaLangString));
  }
  
  private void a(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      localObject2 = new Intent(this, LoginActivity.class);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 20);
      return;
    }
    a(localIntent, (Bundle)localObject1);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    Object localObject = getIntent();
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      jdField_a_of_type_Boolean = true;
      paramString = new Intent(this, LoginActivity.class);
      paramString.putExtra("isActionSend", true);
      paramString.putExtras(paramString);
      paramString.setFlags(16777216);
      startActivityForResult(paramString, 21);
      return;
    }
    jdField_a_of_type_Boolean = false;
    localObject = ((Intent)localObject).getDataString();
    localObject = JumpParser.a(this.app, this, (String)localObject);
    ((JumpAction)localObject).a(paramString);
    ((JumpAction)localObject).b();
    finish();
  }
  
  private void b(boolean paramBoolean)
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      finish();
      return;
    }
    if ((paramBoolean) && (!this.app.isLogin()))
    {
      Intent localIntent = new Intent(this, LoginActivity.class);
      localIntent.putExtra("isActionSend", true);
      localIntent.putExtras(localBundle);
      localIntent.putExtras(localIntent);
      startActivityForResult(localIntent, 19);
      return;
    }
    if (localBundle.getBoolean("qqfav_extra_from_system_share", false))
    {
      if (a(localBundle) != 0) {
        QfavUtil.a(this, 2131362754, 1);
      }
      finish();
      return;
    }
    a(localBundle);
  }
  
  private void c()
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
  
  private void d()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.app.getAccount());
      }
      startActivityForResult(new Intent(this, QQMapActivity.class).putExtra("uin", this.app.getAccount()), 18);
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
  
  protected int a(Bundle paramBundle)
  {
    int j = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("qqfav|QfavJumpActivity", 4, "startSystemShareToQQFav|beg");
    }
    String str1 = paramBundle.getString("android.intent.extra.TITLE");
    Object localObject1 = paramBundle.getString("android.intent.extra.TEXT");
    Object localObject2 = getIntent().getType();
    int i;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|type null");
      }
      i = 1;
      return i;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("src_type", "app");
    localHashMap.put("version", "1");
    localHashMap.put("cflag", Base64Util.a("1".getBytes(), 0));
    if (TextUtils.isEmpty(str1))
    {
      str1 = "";
      localHashMap.put("title", str1);
      if ((!((String)localObject2).startsWith("text")) || (paramBundle.containsKey("android.intent.extra.STREAM"))) {
        break label396;
      }
      localHashMap.put("req_type", Base64Util.a("6".getBytes(), 0));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label383;
      }
    }
    label210:
    label383:
    for (paramBundle = "";; paramBundle = Base64Util.a(((String)localObject1).getBytes(), 0))
    {
      localHashMap.put("description", paramBundle);
      localObject1 = localHashMap.keySet();
      localObject2 = ((Set)localObject1).iterator();
      i = 0;
      paramBundle = "mqqapi://share/to_qqfav?";
      while (((Iterator)localObject2).hasNext())
      {
        str1 = (String)((Iterator)localObject2).next();
        paramBundle = paramBundle + str1;
        paramBundle = paramBundle + "=";
        str1 = paramBundle + (String)localHashMap.get(str1);
        paramBundle = str1;
        if (i != ((Set)localObject1).size() - 1) {
          paramBundle = str1 + "&";
        }
        i += 1;
      }
      str1 = Base64Util.a(str1.getBytes(), 0);
      break;
    }
    label396:
    if (((String)localObject2).startsWith("image"))
    {
      localHashMap.put("req_type", Base64Util.a("5".getBytes(), 0));
      if (getIntent().getAction().equals("android.intent.action.SEND"))
      {
        paramBundle = paramBundle.get("android.intent.extra.STREAM");
        if (paramBundle == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send extra_stream null");
          }
          return 1;
        }
        if ((paramBundle instanceof Uri)) {
          paramBundle = (Uri)paramBundle;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (paramBundle == null)
        {
          return 1;
          if (!(paramBundle instanceof String)) {
            break label1038;
          }
          paramBundle = Uri.parse((String)paramBundle);
        }
        else
        {
          paramBundle = a(this, paramBundle);
          if ((TextUtils.isEmpty(paramBundle)) || (!new File(paramBundle).exists()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send file path invalid. path=" + paramBundle);
            }
            return 1;
          }
          try
          {
            str1 = URLEncoder.encode(paramBundle, "UTF-8");
            localHashMap.put("file_data", Base64Util.a(str1.getBytes(), 0));
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|encode fail. path=" + paramBundle + ",exp:" + localUnsupportedEncodingException1.getMessage());
            }
            return 1;
          }
        }
      }
      try
      {
        paramBundle = (ArrayList)paramBundle.get("android.intent.extra.STREAM");
        if (paramBundle == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti extra_stream null");
          }
          return 1;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          paramBundle = null;
        }
        localObject1 = new ArrayList();
        i = 0;
        for (;;)
        {
          if (i < paramBundle.size())
          {
            String str2 = a(this, (Uri)paramBundle.get(i));
            if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists())) {}
            try
            {
              ((ArrayList)localObject1).add(URLEncoder.encode(str2, "UTF-8"));
              i += 1;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti path encode fail: %s" + localUnsupportedEncodingException2.getMessage());
                }
              }
            }
          }
        }
        if (((ArrayList)localObject1).isEmpty())
        {
          if (QLog.isColorLevel()) {
            QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|action_send_muti pathlist empty");
          }
          return 1;
        }
        paramBundle = "";
        i = 0;
        while (i < ((ArrayList)localObject1).size())
        {
          String str3 = paramBundle + (String)((ArrayList)localObject1).get(i);
          paramBundle = str3;
          if (i != ((ArrayList)localObject1).size() - 1) {
            paramBundle = str3 + ";";
          }
          i += 1;
        }
        localHashMap.put("file_data", Base64Util.a(paramBundle.getBytes(), 0));
      }
      break label210;
      if (QLog.isColorLevel()) {
        QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|unknown type. type=" + (String)localObject2);
      }
      return 1;
      paramBundle = JumpParser.a(this.app, this, paramBundle);
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav|QfavJumpActivity", 2, "startSystemShareToQQFav|jump parse fail");
        }
        return 1;
      }
      paramBundle.b();
      i = j;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("qqfav|QfavJumpActivity", 4, "startSystemShareToQQFav|end");
      return 0;
      label1038:
      paramBundle = null;
    }
  }
  
  void a()
  {
    Object localObject = new File(AppConstants.as + "photo/");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    this.jdField_a_of_type_AndroidNetUri = Uri.fromFile(new File(AppConstants.as + "photo/" + System.currentTimeMillis() + ".jpg"));
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
  
  protected boolean a(Intent paramIntent)
  {
    return false;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("JumpActivity onActivityResult,requestCode=").append(paramInt1).append(",resultCode=").append(paramInt2).append(",data=");
      if (paramIntent == null) {
        break label141;
      }
    }
    label141:
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
      a(false, null);
      return;
      finish();
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.doOnCreate(paramBundle);
    if (a(getIntent())) {
      finish();
    }
    for (;;)
    {
      return false;
      Object localObject6 = getIntent();
      if ((localObject6 != null) && (!TextUtils.isEmpty(((Intent)localObject6).getAction())) && ((((Intent)localObject6).getAction().equals("android.intent.action.SEND")) || (((Intent)localObject6).getAction().equals("android.intent.action.SEND_MULTIPLE"))))
      {
        b(true);
        return false;
      }
      if ((localObject6 != null) && (!TextUtils.isEmpty(((Intent)localObject6).getAction())) && (((Intent)localObject6).getAction().equals("android.intent.action.VIEW")) && (!TextUtils.isEmpty(((Intent)localObject6).getScheme())) && ((((Intent)localObject6).getScheme().equals("file")) || (((Intent)localObject6).getScheme().equals("content"))))
      {
        a(true);
        return false;
      }
      if ((localObject6 != null) && (!TextUtils.isEmpty(((Intent)localObject6).getAction())) && (((Intent)localObject6).getAction().equals("android.intent.action.SENDTO")) && (!TextUtils.isEmpty(((Intent)localObject6).getScheme())) && (((Intent)localObject6).getScheme().equals("imto")))
      {
        c();
        return false;
      }
      paramBundle = "";
      try
      {
        localObject1 = getIntent().getStringExtra("share_from");
        paramBundle = (Bundle)localObject1;
        localObject5 = ((Intent)localObject6).getExtras();
        paramBundle = (Bundle)localObject5;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Object localObject1;
          localObject2 = paramBundle;
          paramBundle = null;
        }
        str2 = getIntent().getDataString();
        localObject2 = "";
      }
      if ((localObject6 != null) && ("thridapp".equals(localObject1)))
      {
        localObject1 = new Intent(this, ChatActivity.class);
        if (paramBundle != null) {
          ((Intent)localObject1).putExtras(((Intent)localObject6).getExtras());
        }
        ((Intent)localObject1).addFlags(67108864);
        startActivity((Intent)localObject1);
        return false;
      }
      try
      {
        paramBundle = getIntent().getStringExtra("from");
        localObject2 = paramBundle;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Object localObject2;
          String str2;
          continue;
          Object localObject4 = null;
          continue;
          continue;
          int i = 1;
        }
      }
      Object localObject5 = getCallingPackage();
      paramBundle = (Bundle)localObject5;
      if (localObject5 == null) {}
      try
      {
        paramBundle = getIntent().getStringExtra("pkg_name");
        label1039:
        String str1;
        if (str2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("JumpAction", 2, "jump url:" + str2);
          }
          localObject5 = JumpParser.a(this.app, this, str2);
          if (("webview".equals(localObject2)) && (localObject5 != null)) {
            ((JumpAction)localObject5).a((String)localObject2);
          }
          if (localObject5 != null)
          {
            ((JumpAction)localObject5).jdField_a_of_type_Boolean = true;
            if ((((JumpAction)localObject5).ce != null) && (((JumpAction)localObject5).ce.equals("puzzle_verify_code")) && (((JumpAction)localObject5).cf != null))
            {
              paramBundle = new Intent(getIntent());
              if (((JumpAction)localObject5).cf.equals("PUZZLEVERIFYCODE")) {
                paramBundle.setClass(this, QQBrowserActivity.class);
              }
              for (;;)
              {
                super.startActivity(paramBundle);
                super.finish();
                return false;
                if (((JumpAction)localObject5).cf.equals("VERIFYCODE")) {
                  paramBundle.setClass(this, VerifyCodeActivity.class);
                } else if (((JumpAction)localObject5).cf.equals("DEVLOCK_CODE")) {
                  paramBundle.setClass(this, AuthDevUgActivity.class);
                }
              }
            }
            if ((((JumpAction)localObject5).ce == null) || (!((JumpAction)localObject5).ce.equals("ptlogin")) || (((JumpAction)localObject5).cf == null) || (!((JumpAction)localObject5).cf.equals("qlogin"))) {
              break label1368;
            }
            i = 0;
            if (!str2.startsWith("mqqwpa://im"))
            {
              if (!str2.startsWith(String.format("%s%s", new Object[] { "mqqvoipivr://", "crmivr" }))) {}
            }
            else
            {
              a(true, (String)localObject2);
              return false;
            }
            if ((!str2.startsWith("mqqapi:")) || ((paramBundle != null) && (!"com.tencent.qqlite".equals(paramBundle)))) {
              break label1365;
            }
            try
            {
              localObject2 = getIntent().getStringExtra("pkg_name");
              paramBundle = (Bundle)localObject2;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                continue;
                localObject3 = "?";
                continue;
                if ((!GesturePWDUtils.getJumpLock(this, this.app.a())) || (GesturePWDUtils.getAppForground(this))) {
                  break;
                }
                localObject3 = new Intent(getActivity(), GesturePWDUnlockActivity.class);
                ((Intent)localObject3).putExtra("key_gesture_from_jumpactivity", true);
                ((Intent)localObject3).putExtra("scheme_content", str2);
                ((Intent)localObject3).putExtra("pkg_name", paramBundle);
                startActivity((Intent)localObject3);
              }
              if (!str2.startsWith("mqqapi://tenpay/pay?")) {
                break label1039;
              }
            }
            if ((!this.app.isLogin()) && (i != 0))
            {
              localObject6 = new StringBuilder().append(str2);
              if (str2.indexOf("?") > -1)
              {
                localObject2 = "&";
                localObject2 = (String)localObject2;
                localObject2 = (String)localObject2 + "jfrom=login";
                localObject6 = new Intent(this, LoginActivity.class);
                ((Intent)localObject6).putExtra("scheme_content", (String)localObject2);
                ((Intent)localObject6).putExtra("pkg_name", paramBundle);
                ((Intent)localObject6).putExtras((Intent)localObject6);
                ((Intent)localObject6).setFlags(268435456);
                if (VersionUtils.e()) {
                  ((Intent)localObject6).addFlags(32768);
                }
                startActivity((Intent)localObject6);
              }
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("JumpAction", 2, "JumpActivity is finish");
              }
              if ((((JumpAction)localObject5).ce == null) || (((JumpAction)localObject5).cf == null))
              {
                finish();
                return false;
                Object localObject3;
                if (localObject6 == null) {
                  break label1359;
                }
                try
                {
                  localObject3 = ((Intent)localObject6).getStringExtra("url_app_info");
                  if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                    ((JumpAction)localObject5).a("url_app_info", (String)localObject3);
                  }
                  ((JumpAction)localObject5).b(paramBundle);
                  bool = ((JumpAction)localObject5).b();
                }
                catch (Exception localException3)
                {
                  for (;;)
                  {
                    str1 = null;
                  }
                }
              }
            }
            if ((((JumpAction)localObject5).ce.equals("gav")) && (((JumpAction)localObject5).cf.equals("request")))
            {
              if (("0".equals(((JumpAction)localObject5).a("relation_id"))) || (!bool)) {
                continue;
              }
              finish();
              return false;
            }
            if ((((JumpAction)localObject5).ce.equals("videochat")) && (((JumpAction)localObject5).cf.equals("request")))
            {
              if (!bool) {
                continue;
              }
              finish();
              return false;
            }
            if ((((JumpAction)localObject5).ce.equals("wallet")) && (((JumpAction)localObject5).cf.equals("modify_pass")))
            {
              if (!bool) {
                continue;
              }
              finish();
              return false;
            }
            finish();
            return false;
          }
        }
        paramBundle = "";
        try
        {
          str1 = getIntent().getStringExtra("action");
          paramBundle = str1;
        }
        catch (Exception localException5)
        {
          label1218:
          break label1218;
        }
        if (paramBundle == null)
        {
          finish();
          return false;
        }
        try
        {
          this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("doCallBack", false);
          this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("src_type");
          this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("callback_type");
          this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("callback_name");
          label1285:
          if ("photo".equals(paramBundle)) {
            this.jdField_b_of_type_Boolean = true;
          }
          while ((!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
          {
            d();
            return false;
            if ("select_location".equals(paramBundle)) {
              this.jdField_c_of_type_Boolean = true;
            }
          }
        }
        catch (Exception localException4)
        {
          break label1285;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle = (Bundle)localObject5;
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
      this.app = ((QQAppInterface)localAppRuntime);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity
 * JD-Core Version:    0.7.0.1
 */