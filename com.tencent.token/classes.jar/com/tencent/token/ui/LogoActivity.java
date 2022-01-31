package com.tencent.token.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.cx;
import com.tencent.token.cy;
import com.tencent.token.dg;
import com.tencent.token.do;
import com.tencent.token.fk;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.h;
import com.tencent.token.global.j;
import com.tencent.token.upload.NetInfoService;
import com.tencent.token.upload.f;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import java.util.ArrayList;
import java.util.List;

public class LogoActivity
  extends Activity
{
  public static final int K_LOGO2DIGIT_PWD_REQUEST = 256;
  public static final int K_LOGO2DIGIT_PWD_RESPONSE = 257;
  public static final int K_LOGO2GUID_INTENT_REQUEST = 262;
  public static final int K_LOGO2GUID_INTENT_RESPONSE = 263;
  public static final int K_LOGO2MODIFY_INTENT_REQUEST = 260;
  public static final int K_LOGO2UPDATE_INFO_REQUEST = 258;
  public static final int K_LOGO2UPDATE_INFO_RESPONSE = 259;
  public static final int K_LOGO2VERFIY_INTENT_REQUEST = 261;
  private static String[] PERMISSIONS_DYNAMIC = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  private long cur_time;
  private Dialog dialog;
  private final int logo_time = 800;
  private boolean mFromH5 = false;
  private boolean mFromOtherApp = false;
  private dy mListener;
  private Bitmap mLogoBmp;
  private ImageView mLogoView;
  private long mUin;
  private String schemaKey;
  private int schemaTimeout;
  private boolean success = true;
  
  private void decryptAndCheck(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    loadSchemaParm();
    for (;;)
    {
      try
      {
        if (this.schemaTimeout <= 0) {
          return;
        }
        if (TextUtils.isEmpty(this.schemaKey)) {
          return;
        }
        Object localObject = new a();
        byte[] arrayOfByte = dg.a(paramString);
        h.b("decryptAndCheck sig=" + paramString + " schemaKey=" + this.schemaKey);
        paramString = ((a)localObject).a(arrayOfByte, this.schemaKey.getBytes());
        localObject = new StringBuilder().append("temp =");
        if (paramString == null)
        {
          h.b(bool);
          if ((paramString == null) || (paramString.length < 0)) {
            return;
          }
          paramString = new String(paramString);
          h.b("result=" + paramString);
          paramString = paramString.split("&");
          if (paramString.length != 2) {
            return;
          }
          int i = Integer.valueOf(paramString[0]).intValue();
          long l = Long.valueOf(paramString[1]).longValue();
          int j = (int)(cx.c().s() / 1000L);
          h.a("timeStamp=" + i + "ad=" + l);
          if (Math.abs(j - i) >= this.schemaTimeout) {
            return;
          }
          this.success = do.a().a(l);
          if (!this.success) {
            break;
          }
          launchActivity(paramInt2, paramInt1);
          return;
        }
      }
      catch (Exception paramString)
      {
        h.c(paramString.getMessage());
        return;
      }
      bool = false;
    }
    this.mFromH5 = true;
  }
  
  private void gotoWelcomeActivity()
  {
    if ((this.mFromOtherApp) || (this.mFromH5))
    {
      if (!cx.c().g())
      {
        if (do.a().d() == 0)
        {
          localIntent = new Intent(this, WtLoginAccountInput.class);
          localIntent.putExtra("page_id", 3);
          startActivity(localIntent);
          finish();
          return;
        }
        if (!this.success)
        {
          this.dialog = new AlertDialog.Builder(this).setTitle(2131230935).setMessage(2131231119).setPositiveButton(2131230867, new oe(this)).setNegativeButton(2131231400, new od(this)).create();
          this.dialog.setOnCancelListener(new of(this));
          this.dialog.show();
          return;
        }
        jumpActivity();
        return;
      }
      Intent localIntent = new Intent(this, WtLoginAccountInput.class);
      localIntent.putExtra("page_id", 3);
      startActivity(localIntent);
      finish();
      return;
    }
    startActivity(new Intent(this, WelcomeActivity.class));
    finish();
  }
  
  private void gotonext()
  {
    Object localObject;
    if ((cy.a().c()) && (cy.a().e() == 1))
    {
      localObject = new Intent(this, StartPwdDigitVerifyActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("enter_type", 1);
      ((Intent)localObject).putExtra("com.tencent.input_param", localBundle);
      startActivityForResult((Intent)localObject, 256);
      return;
    }
    if (x.a.mStartUpImg != null)
    {
      setContentView(2130968772);
      localObject = (ImageView)findViewById(2131559297);
      ((ImageView)localObject).setImageBitmap(x.a.mStartUpImg);
      ((ImageView)localObject).postDelayed(new oq(this), 1500L);
      return;
    }
    gotoWelcomeActivity();
  }
  
  private void jumpActivity()
  {
    if (this.mFromOtherApp)
    {
      localIntent = new Intent(this, IndexActivity.class);
      localIntent.putExtra("intent.qquser", this.mUin);
      localIntent.putExtra("index_from", 23);
      startActivityForResult(localIntent, 261);
      return;
    }
    Intent localIntent = new Intent(this, IndexActivity.class);
    localIntent.putExtra("index_from", 22);
    startActivity(localIntent);
    finish();
  }
  
  private void launchActivity(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      localIntent = new Intent(this, UtilsGameLockActivity.class);
      localIntent.putExtra("indexid", paramInt2);
      startActivity(localIntent);
      finish();
    }
    do
    {
      return;
      if (paramInt1 == 1)
      {
        localIntent = new Intent(this, UtilsGameProtectActivity.class);
        localIntent.putExtra("indexid", paramInt2);
        startActivity(localIntent);
        finish();
        return;
      }
    } while (paramInt1 != 2);
    Intent localIntent = new Intent(this, ModifyQQPwdActivity.class);
    localIntent.putExtra("indexid", paramInt2);
    pg.a().a(this, localIntent, pg.b);
    finish();
  }
  
  private void loadSchemaParm()
  {
    Object localObject = RqdApplication.l();
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("schemaparm_name", 0);
      this.schemaKey = ((SharedPreferences)localObject).getString("key_schemaparm_key", "");
      this.schemaTimeout = ((SharedPreferences)localObject).getInt("key_schemaparm_timeout", 0);
      h.b("load schemaKey=" + this.schemaKey + " schemaTimeout=" + this.schemaTimeout);
      return;
    }
    catch (Exception localException)
    {
      h.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  private void showOldPwdDeleteAlert()
  {
    if (isFinishing()) {
      return;
    }
    new AlertDialog.Builder(this).setMessage(2131231107).setNegativeButton(2131231143, new oh(this)).setPositiveButton(2131231096, new og(this)).create().show();
  }
  
  private void showPermissionDialog()
  {
    if (!need2RequestPermission())
    {
      Log.i("SecureGuideUtil", "权限已被授予，无需引导");
      gotonext();
      return;
    }
    new AlertDialog.Builder(this).setTitle("重要提醒").setMessage("为了您安全正常使用QQ安全中心，需要您授权读取设备文件权限，及读取本机的识别码权限。该操作不会泄露你的隐私。拒绝后无法正常运行").setNegativeButton("去允许", new oo(this)).setPositiveButton("放弃使用", new on(this)).setCancelable(false).create().show();
  }
  
  private void showPrivacyDialog()
  {
    int j = 1;
    boolean bool = RqdApplication.b();
    Log.i("SecureGuideUtil", "是否新用户|" + bool);
    long l = fk.b("privacy_dialog_agree_time", 0L);
    Log.i("SecureGuideUtil", "隐私条款上次允许时间戳|" + l);
    int i;
    if (l > 0L)
    {
      i = 1;
      if (bool) {
        break label475;
      }
      if (l == -1L) {
        break label116;
      }
      i = j;
    }
    label475:
    for (;;)
    {
      if (i != 0)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          showPermissionDialog();
          return;
          i = 0;
          break;
          label116:
          i = 0;
          continue;
        }
        Log.i("SecureGuideUtil", "andriod 版本小于23，无需引导权限");
        gotonext();
        return;
      }
      Object localObject2 = fk.b("privacy_dialog_line2_wording", null);
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "为了向您提供QQ帐号安全体检、QQ帐号足迹、QQ密保管理、QQ密码管理、动态密码、QQ帐号保护等多项功能和服务，我们需要收集设备信息等个人信息；您可以在相关页面访问、更正、删除您的个人信息并管理您的授权。";
      }
      Object localObject3 = "用户服务及隐私协议\n我们将通过《软件许可及服务协议》和《隐私保护指引》帮助您了解我们收集、使用、存储和共享个人信息的情况，以及您所享有的相关权利。" + "\n\n" + (String)localObject1;
      localObject1 = new oi(this);
      localObject2 = new oj(this);
      localObject3 = new SpannableString((CharSequence)localObject3);
      ((SpannableString)localObject3).setSpan(localObject1, 15, 26, 33);
      ((SpannableString)localObject3).setSpan(localObject2, 27, 35, 33);
      localObject1 = new TextView(this);
      ((TextView)localObject1).setTextSize(0, getResources().getDimensionPixelSize(2131296403));
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setPadding(w.a(this, 5.0F), 0, w.a(this, 5.0F), 0);
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      ((TextView)localObject1).setText((CharSequence)localObject3);
      if (bool)
      {
        localObject1 = new AlertDialog.Builder(this).setTitle("欢迎使用QQ安全中心").setView((View)localObject1).setPositiveButton("暂不使用", null).setNegativeButton("同意", null).setCancelable(false).create();
        ((Dialog)localObject1).show();
        ((AlertDialog)localObject1).getButton(-1).setOnClickListener(new ok(this));
        ((AlertDialog)localObject1).getButton(-2).setOnClickListener(new ol(this, (Dialog)localObject1));
        return;
      }
      localObject1 = new AlertDialog.Builder(this).setTitle("欢迎使用QQ安全中心").setView((View)localObject1).setPositiveButton("我知道了", null).setCancelable(false).create();
      ((Dialog)localObject1).show();
      ((AlertDialog)localObject1).getButton(-1).setOnClickListener(new om(this, (Dialog)localObject1));
      return;
    }
  }
  
  boolean need2RequestPermission()
  {
    boolean bool = false;
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = PERMISSIONS_DYNAMIC;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      String str;
      if (i < j) {
        str = arrayOfString[i];
      }
      try
      {
        if (ContextCompat.checkSelfPermission(this, str) != 0) {
          localArrayList.add(str);
        }
        label52:
        i += 1;
        continue;
        if (localArrayList.size() > 0) {
          bool = true;
        }
        return bool;
      }
      catch (Exception localException)
      {
        break label52;
      }
    }
  }
  
  public void nextPage()
  {
    if (isFinishing()) {
      return;
    }
    showPrivacyDialog();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 256) {
      if (paramInt2 == 257) {
        startActivityForResult(new Intent(this, StartPwdUpdateInfoActivity.class), 258);
      }
    }
    do
    {
      return;
      finish();
      return;
      if (paramInt1 == 258)
      {
        if (paramInt2 == 259)
        {
          gotoWelcomeActivity();
          return;
        }
        cy.a().a(this, null);
        showOldPwdDeleteAlert();
        return;
      }
      if (paramInt1 == 260)
      {
        if (!cy.a().c())
        {
          showOldPwdDeleteAlert();
          return;
        }
        j.b();
        j.a();
        gotoWelcomeActivity();
        return;
      }
      if (paramInt1 == 261)
      {
        setResult(paramInt2);
        finish();
        return;
      }
    } while (paramInt1 != 262);
    if (paramInt2 == 263)
    {
      gotonext();
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.b(this + ",task" + getTaskId());
    requestWindowFeature(1);
    RqdApplication.e();
    c.a(true);
    Intent localIntent = getIntent();
    label186:
    label470:
    for (;;)
    {
      int i;
      try
      {
        Bundle localBundle = localIntent.getBundleExtra("com.tencent.input_param");
        paramBundle = localIntent.getData();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.toString();
          if (!paramBundle.startsWith("qmtoken://dual_verify?")) {
            break label357;
          }
          paramBundle = paramBundle.substring("qmtoken://dual_verify?".length()).split("&");
          i = paramBundle.length - 1;
          if (i >= 0)
          {
            localObject = paramBundle[i].split("=");
            if ((localObject.length != 2) || (!localObject[0].equals("uin")) || (!localObject[1].matches("^\\d+$"))) {
              break label350;
            }
            this.mFromOtherApp = true;
            this.mUin = w.f(Long.parseLong(localObject[1]));
          }
        }
        if (localBundle == null) {
          break label963;
        }
        paramBundle = localBundle.getString("package");
        if (paramBundle != null) {
          break label920;
        }
        setContentView(2130968689);
        x.a(this, findViewById(2131558691), 2131492946);
        this.mLogoBmp = x.a(getResources(), 2130837813);
        this.cur_time = System.currentTimeMillis();
        if (this.mLogoBmp != null) {
          break label892;
        }
        this.cur_time = 0L;
        label244:
        paramBundle = (NotificationManager)getSystemService("notification");
        paramBundle.cancel(1);
        paramBundle.cancel(2);
        paramBundle.cancel(3);
        if (this.cur_time != 0L) {
          break label932;
        }
        nextPage();
        x.a();
        i -= 1;
      }
      catch (Exception paramBundle)
      {
        try
        {
          paramBundle = new Intent(this, NetInfoService.class);
          localIntent.setAction("com.tencent.token.upload.NetInfoService");
          startService(paramBundle);
          return;
        }
        catch (Exception paramBundle)
        {
          Object localObject;
          String[] arrayOfString1;
          String[] arrayOfString2;
          paramBundle.printStackTrace();
          return;
        }
        paramBundle = paramBundle;
        paramBundle.printStackTrace();
        h.d("OpenAppCrash " + paramBundle.toString());
        finish();
        return;
      }
      label350:
      continue;
      label357:
      if (paramBundle.startsWith("qmtoken://index_activity?"))
      {
        paramBundle = paramBundle.substring("qmtoken://index_activity?".length()).split("&");
        i = paramBundle.length - 1;
        for (;;)
        {
          if (i < 0) {
            break label470;
          }
          localObject = paramBundle[i];
          h.c("path: " + (String)localObject);
          localObject = ((String)localObject).split("=");
          if ((localObject.length == 2) && (localObject[0].equals("tab")) && (localObject[1].equals("2")))
          {
            this.mFromH5 = true;
            break;
          }
          i -= 1;
        }
      }
      else
      {
        if (paramBundle.startsWith("qmtoken://gamelock_activity?"))
        {
          arrayOfString1 = paramBundle.substring("qmtoken://gamelock_activity?".length()).split("&");
          localObject = "";
          if (arrayOfString1.length != 2) {
            continue;
          }
          arrayOfString2 = arrayOfString1[0].split("=");
          paramBundle = (Bundle)localObject;
          if (arrayOfString2.length == 2)
          {
            paramBundle = (Bundle)localObject;
            if (arrayOfString2[0].equals("sig")) {
              paramBundle = arrayOfString2[1];
            }
          }
          localObject = arrayOfString1[1].split("=");
          if ((localObject.length != 2) || (!localObject[0].equals("page"))) {
            break label978;
          }
        }
        for (i = Integer.valueOf(localObject[1]).intValue();; i = -1)
        {
          if ((TextUtils.isEmpty(paramBundle)) || (i == -1)) {
            break label981;
          }
          decryptAndCheck(paramBundle, i, 0);
          break;
          if (paramBundle.startsWith("qmtoken://gameprotect_activity?"))
          {
            arrayOfString1 = paramBundle.substring("qmtoken://gameprotect_activity?".length()).split("&");
            localObject = "";
            if (arrayOfString1.length != 2) {
              break;
            }
            arrayOfString2 = arrayOfString1[0].split("=");
            paramBundle = (Bundle)localObject;
            if (arrayOfString2.length == 2)
            {
              paramBundle = (Bundle)localObject;
              if (arrayOfString2[0].equals("sig")) {
                paramBundle = arrayOfString2[1];
              }
            }
            localObject = arrayOfString1[1].split("=");
            if ((localObject.length != 2) || (!localObject[0].equals("page"))) {
              break label973;
            }
          }
          for (i = Integer.valueOf(localObject[1]).intValue();; i = -1)
          {
            if ((TextUtils.isEmpty(paramBundle)) || (i == -1)) {
              break label976;
            }
            decryptAndCheck(paramBundle, i, 1);
            break;
            if (!paramBundle.startsWith("qmtoken://modifypwd_activity?")) {
              break;
            }
            arrayOfString1 = paramBundle.substring("qmtoken://modifypwd_activity?".length()).split("&");
            localObject = "";
            if (arrayOfString1.length != 2) {
              break;
            }
            arrayOfString2 = arrayOfString1[0].split("=");
            paramBundle = (Bundle)localObject;
            if (arrayOfString2.length == 2)
            {
              paramBundle = (Bundle)localObject;
              if (arrayOfString2[0].equals("sig")) {
                paramBundle = arrayOfString2[1];
              }
            }
            localObject = arrayOfString1[1].split("=");
            if ((localObject.length == 2) && (localObject[0].equals("page"))) {}
            for (i = Integer.valueOf(localObject[1]).intValue();; i = -1)
            {
              if ((TextUtils.isEmpty(paramBundle)) || (i == -1)) {
                break label971;
              }
              decryptAndCheck(paramBundle, i, 2);
              break;
              label892:
              this.mLogoView = ((ImageView)findViewById(2131559009));
              this.mLogoView.setImageBitmap(this.mLogoBmp);
              break label244;
              c.a(false);
              this.cur_time = 0L;
              break label244;
              new Handler().postDelayed(new oc(this), 800L);
              break label283;
              paramBundle = null;
              break label186;
            }
            break;
          }
          break;
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mLogoBmp != null)
    {
      this.mLogoBmp.recycle();
      this.mLogoBmp = null;
    }
    if (x.a.mStartUpImg != null)
    {
      x.a.mStartUpImg.recycle();
      x.a.mStartUpImg = null;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        if (paramArrayOfInt.length > 0)
        {
          localArrayList = new ArrayList();
          paramInt = 0;
          if (paramInt >= paramArrayOfInt.length) {
            break label58;
          }
          if (paramArrayOfInt[paramInt] == 0) {
            break label90;
          }
          localArrayList.add(paramArrayOfString[paramInt]);
        }
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
      }
      return;
      label58:
      if (!localArrayList.isEmpty())
      {
        this.mListener.a(localArrayList);
        return;
      }
      this.mListener.a();
      return;
      label90:
      paramInt += 1;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (f.a)
    {
      f.c = System.currentTimeMillis();
      String str = f.a() + "";
      h.c("start:" + f.b);
      h.c("end:" + f.c);
      h.c("appTime:" + str);
    }
  }
  
  public void requestRuntimePermissions(String[] paramArrayOfString, dy paramdy)
  {
    for (;;)
    {
      int i;
      try
      {
        this.mListener = paramdy;
        paramdy = new ArrayList();
        int j = paramArrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str = paramArrayOfString[i];
          if (ContextCompat.checkSelfPermission(this, str) != 0) {
            paramdy.add(str);
          }
        }
        else
        {
          if (!paramdy.isEmpty())
          {
            ActivityCompat.requestPermissions(this, (String[])paramdy.toArray(new String[paramdy.size()]), 1);
            return;
          }
          this.mListener.a();
          return;
        }
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.LogoActivity
 * JD-Core Version:    0.7.0.1
 */