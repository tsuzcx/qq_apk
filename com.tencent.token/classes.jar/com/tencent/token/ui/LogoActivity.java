package com.tencent.token.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.cd;
import com.tencent.token.ce;
import com.tencent.token.ck;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.cs;
import com.tencent.token.ef;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.g;
import com.tencent.token.global.h;
import com.tencent.token.upload.NetInfoService;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
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
  private f mListener;
  private Bitmap mLogoBmp;
  private ImageView mLogoView;
  private long mUin;
  private String schemaKey;
  private int schemaTimeout;
  private boolean success = true;
  
  private void decryptAndCheck(String paramString, int paramInt1, int paramInt2)
  {
    loadSchemaParm();
    for (;;)
    {
      try
      {
        if (this.schemaTimeout > 0)
        {
          if (TextUtils.isEmpty(this.schemaKey)) {
            return;
          }
          Object localObject = new a();
          byte[] arrayOfByte = ck.a(paramString);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decryptAndCheck sig=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" schemaKey=");
          localStringBuilder.append(this.schemaKey);
          g.b(localStringBuilder.toString());
          paramString = ((a)localObject).a(arrayOfByte, this.schemaKey.getBytes());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("temp =");
          if (paramString != null) {
            break label343;
          }
          bool = true;
          ((StringBuilder)localObject).append(bool);
          g.b(((StringBuilder)localObject).toString());
          if ((paramString != null) && (paramString.length >= 0))
          {
            paramString = new String(paramString);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("result=");
            ((StringBuilder)localObject).append(paramString);
            g.b(((StringBuilder)localObject).toString());
            paramString = paramString.split("&");
            if (paramString.length == 2)
            {
              int i = Integer.valueOf(paramString[0]).intValue();
              long l = Long.valueOf(paramString[1]).longValue();
              int j = (int)(cd.c().s() / 1000L);
              paramString = new StringBuilder();
              paramString.append("timeStamp=");
              paramString.append(i);
              paramString.append("ad=");
              paramString.append(l);
              g.a(paramString.toString());
              if (Math.abs(j - i) < this.schemaTimeout)
              {
                this.success = cs.a().a(l);
                if (this.success)
                {
                  launchActivity(paramInt2, paramInt1);
                  return;
                }
                this.mFromH5 = true;
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        g.c(paramString.getMessage());
      }
      return;
      label343:
      boolean bool = false;
    }
  }
  
  private void gotoWelcomeActivity()
  {
    if ((!this.mFromOtherApp) && (!this.mFromH5))
    {
      startActivity(new Intent(this, WelcomeActivity.class));
      finish();
      return;
    }
    if (!cd.c().g())
    {
      if (cs.a().d() == 0)
      {
        localIntent = new Intent(this, WtLoginAccountInput.class);
        localIntent.putExtra("page_id", 3);
        startActivity(localIntent);
        finish();
        return;
      }
      if (!this.success)
      {
        this.dialog = new AlertDialog.Builder(this).setTitle(2131493078).setMessage(2131493262).setPositiveButton(2131493010, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.dismiss();
              LogoActivity.this.jumpActivity();
            }
          }
        }).setNegativeButton(2131493543, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface = new Intent(LogoActivity.this, WtLoginAccountInput.class);
            paramAnonymousDialogInterface.putExtra("page_id", 3);
            LogoActivity.this.startActivity(paramAnonymousDialogInterface);
            LogoActivity.this.finish();
          }
        }).create();
        this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.dismiss();
              LogoActivity.this.jumpActivity();
            }
          }
        });
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
  }
  
  private void gotonext()
  {
    Object localObject;
    if ((ce.a().c()) && (ce.a().e() == 1))
    {
      localObject = new Intent(this, StartPwdDigitVerifyActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("enter_type", 1);
      ((Intent)localObject).putExtra("com.tencent.input_param", localBundle);
      startActivityForResult((Intent)localObject, 256);
      return;
    }
    if (m.a.mStartUpImg != null)
    {
      setContentView(2131296453);
      localObject = (ImageView)findViewById(2131166028);
      ((ImageView)localObject).setImageBitmap(m.a.mStartUpImg);
      ((ImageView)localObject).postDelayed(new Runnable()
      {
        public void run()
        {
          LogoActivity.this.gotoWelcomeActivity();
        }
      }, 1500L);
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
    Intent localIntent;
    if (paramInt1 == 0)
    {
      localIntent = new Intent(this, UtilsGameLockActivity.class);
      localIntent.putExtra("indexid", paramInt2);
      startActivity(localIntent);
      finish();
      return;
    }
    if (paramInt1 == 1)
    {
      localIntent = new Intent(this, UtilsGameProtectActivity.class);
      localIntent.putExtra("indexid", paramInt2);
      startActivity(localIntent);
      finish();
      return;
    }
    if (paramInt1 == 2)
    {
      localIntent = new Intent(this, ModifyQQPwdActivity.class);
      localIntent.putExtra("indexid", paramInt2);
      o.a().a(this, localIntent, o.b);
      finish();
    }
  }
  
  private void loadSchemaParm()
  {
    Object localObject = RqdApplication.n();
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("schemaparm_name", 0);
      this.schemaKey = ((SharedPreferences)localObject).getString("key_schemaparm_key", "");
      this.schemaTimeout = ((SharedPreferences)localObject).getInt("key_schemaparm_timeout", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load schemaKey=");
      ((StringBuilder)localObject).append(this.schemaKey);
      ((StringBuilder)localObject).append(" schemaTimeout=");
      ((StringBuilder)localObject).append(this.schemaTimeout);
      g.b(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
  }
  
  private void showOldPwdDeleteAlert()
  {
    if (isFinishing()) {
      return;
    }
    new AlertDialog.Builder(this).setMessage(2131493250).setNegativeButton(2131493286, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        LogoActivity.this.gotoWelcomeActivity();
      }
    }).setPositiveButton(2131493239, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent(LogoActivity.this, StartPwdGestureModifyActivity.class);
        LogoActivity.this.startActivityForResult(paramAnonymousDialogInterface, 260);
      }
    }).create().show();
  }
  
  private void showPermissionDialog()
  {
    final SharedPreferences localSharedPreferences = RqdApplication.n().getSharedPreferences(ef.a, 0);
    long l = localSharedPreferences.getLong(ef.b, 0L);
    if (System.currentTimeMillis() - l <= 172800000L)
    {
      Log.i("SecureGuideUtil", "48小时内不再引导权限");
      gotonext();
      return;
    }
    if (!need2RequestPermission())
    {
      Log.i("SecureGuideUtil", "权限已被授予，无需引导");
      gotonext();
      return;
    }
    new AlertDialog.Builder(this).setTitle("权限申请").setMessage("为了您安全正常使用QQ安全中心，需要您授权读取设备文件权限，及读取本机的识别码权限。该操作不会泄露你的隐私。").setNegativeButton("去授权", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        LogoActivity.this.requestRuntimePermissions(LogoActivity.PERMISSIONS_DYNAMIC, new f()
        {
          public void a()
          {
            LogoActivity.this.gotonext();
          }
          
          public void a(List<String> paramAnonymous2List)
          {
            LogoActivity.this.gotonext();
          }
        });
        localSharedPreferences.edit().putLong(ef.b, System.currentTimeMillis()).apply();
      }
    }).setCancelable(false).create().show();
  }
  
  private void showPrivacyDialog()
  {
    boolean bool1 = com.tencent.service.update.e.a().c();
    boolean bool2 = RqdApplication.d();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("hasRecordAgreeOrNot=");
    ((StringBuilder)localObject1).append(bool1);
    Log.i("SecureGuideUtil", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("是否新用户|");
    ((StringBuilder)localObject1).append(bool2);
    Log.i("SecureGuideUtil", ((StringBuilder)localObject1).toString());
    long l = ef.b("privacy_dialog_agree_time", 0L);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("隐私条款上次允许时间戳|");
    ((StringBuilder)localObject1).append(l);
    Log.i("SecureGuideUtil", ((StringBuilder)localObject1).toString());
    int i;
    if (l > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (!bool2) {
      if (l != -1L) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((i != 0) && (bool1))
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        showPermissionDialog();
        return;
      }
      Log.i("SecureGuideUtil", "andriod 版本小于23，无需引导权限");
      gotonext();
      return;
    }
    Object localObject2 = ef.c("privacy_dialog_line2_wording", null);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "为了向您提供QQ帐号安全体检、QQ帐号足迹、QQ密保管理、QQ密码管理、动态密码、QQ帐号保护等多项功能和服务，我们需要收集设备信息等个人信息；您可以在相关页面访问、更正、删除您的个人信息并管理您的授权。";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("用户服务及隐私协议\n我们将通过《软件许可及服务协议》和《隐私保护指引》帮助您了解我们收集、使用、存储和共享个人信息的情况，以及您所享有的相关权利。");
    ((StringBuilder)localObject2).append("\n\n");
    ((StringBuilder)localObject2).append((String)localObject1);
    Object localObject3 = ((StringBuilder)localObject2).toString();
    localObject1 = new ClickableSpan()
    {
      public void onClick(@NonNull View paramAnonymousView)
      {
        l.a(LogoActivity.this, "https://sdi.3g.qq.com/v/2019120415543611159");
      }
      
      public void updateDrawState(@NonNull TextPaint paramAnonymousTextPaint)
      {
        paramAnonymousTextPaint.setColor(-16740609);
      }
    };
    localObject2 = new ClickableSpan()
    {
      public void onClick(@NonNull View paramAnonymousView)
      {
        l.a(LogoActivity.this, "http://tools.3g.qq.com/j/qqsafety");
      }
      
      public void updateDrawState(@NonNull TextPaint paramAnonymousTextPaint)
      {
        paramAnonymousTextPaint.setColor(-16740609);
      }
    };
    localObject3 = new SpannableString((CharSequence)localObject3);
    ((SpannableString)localObject3).setSpan(localObject1, 15, 26, 33);
    ((SpannableString)localObject3).setSpan(localObject2, 27, 35, 33);
    localObject1 = new TextView(this);
    ((TextView)localObject1).setTextSize(0, getResources().getDimensionPixelSize(2131034253));
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setPadding(l.a(this, 5.0F), 0, l.a(this, 5.0F), 0);
    ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
    ((TextView)localObject1).setText((CharSequence)localObject3);
    if ((!bool2) && (bool1))
    {
      localObject1 = new AlertDialog.Builder(this).setTitle("欢迎使用QQ安全中心").setView((View)localObject1).setPositiveButton("我知道了", null).setCancelable(false).create();
      ((Dialog)localObject1).show();
      ((AlertDialog)localObject1).getButton(-1).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          this.a.dismiss();
          ef.a("privacy_dialog_agree_time", System.currentTimeMillis());
          if (Build.VERSION.SDK_INT >= 23)
          {
            LogoActivity.this.showPermissionDialog();
            return;
          }
          Log.i("SecureGuideUtil", "andriod 版本小于23，无需引导权限");
          LogoActivity.this.gotonext();
        }
      });
      return;
    }
    localObject1 = new AlertDialog.Builder(this).setTitle("欢迎使用QQ安全中心").setView((View)localObject1).setPositiveButton("暂不使用", null).setNegativeButton("同意", null).setCancelable(false).create();
    ((Dialog)localObject1).show();
    localObject2 = (AlertDialog)localObject1;
    ((AlertDialog)localObject2).getButton(-1).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.tencent.service.update.e.a().a(false);
        Toast.makeText(RqdApplication.n(), "需要获得您的同意后才可继续使用QQ安全中心提供的服务", 0).show();
      }
    });
    ((AlertDialog)localObject2).getButton(-2).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.a.dismiss();
        RqdApplication.c();
        ef.a("privacy_dialog_agree_time", System.currentTimeMillis());
        com.tencent.service.update.e.a().a(true);
        RqdApplication.a().b();
        if (Build.VERSION.SDK_INT >= 23)
        {
          LogoActivity.this.showPermissionDialog();
          return;
        }
        Log.i("SecureGuideUtil", "andriod 版本小于23，无需引导权限");
        LogoActivity.this.gotonext();
      }
    });
  }
  
  boolean need2RequestPermission()
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = PERMISSIONS_DYNAMIC;
    int j = arrayOfString.length;
    boolean bool = false;
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
    if (paramInt1 == 256)
    {
      if (paramInt2 == 257)
      {
        startActivityForResult(new Intent(this, StartPwdUpdateInfoActivity.class), 258);
        return;
      }
      finish();
      return;
    }
    if (paramInt1 == 258)
    {
      if (paramInt2 == 259)
      {
        gotoWelcomeActivity();
        return;
      }
      ce.a().a(this, null);
      showOldPwdDeleteAlert();
      return;
    }
    if (paramInt1 == 260)
    {
      if (!ce.a().c())
      {
        showOldPwdDeleteAlert();
        return;
      }
      h.b();
      h.a();
      gotoWelcomeActivity();
      return;
    }
    if (paramInt1 == 261)
    {
      setResult(paramInt2);
      finish();
      return;
    }
    if (paramInt1 == 262)
    {
      if (paramInt2 == 263)
      {
        gotonext();
        return;
      }
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append(this);
    paramBundle.append(",task");
    paramBundle.append(getTaskId());
    g.b(paramBundle.toString());
    requestWindowFeature(1);
    RqdApplication.g();
    c.a(true);
    Intent localIntent = getIntent();
    try
    {
      Bundle localBundle = localIntent.getBundleExtra("com.tencent.input_param");
      paramBundle = localIntent.getData();
      Object localObject1;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.toString();
        int i;
        if (paramBundle.startsWith("qmtoken://dual_verify?"))
        {
          paramBundle = paramBundle.substring(22).split("&");
          i = paramBundle.length - 1;
          while (i >= 0)
          {
            localObject1 = paramBundle[i].split("=");
            if ((localObject1.length == 2) && (localObject1[0].equals("uin")) && (localObject1[1].matches("^\\d+$")))
            {
              this.mFromOtherApp = true;
              this.mUin = l.f(Long.parseLong(localObject1[1]));
              break;
            }
            i -= 1;
          }
        }
        Object localObject2;
        if (paramBundle.startsWith("qmtoken://index_activity?"))
        {
          paramBundle = paramBundle.substring(25).split("&");
          i = paramBundle.length - 1;
          while (i >= 0)
          {
            localObject1 = paramBundle[i];
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("path: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            g.c(((StringBuilder)localObject2).toString());
            localObject1 = ((String)localObject1).split("=");
            if ((localObject1.length == 2) && (localObject1[0].equals("tab")) && (localObject1[1].equals("2")))
            {
              this.mFromH5 = true;
              break;
            }
            i -= 1;
          }
        }
        String[] arrayOfString;
        if (paramBundle.startsWith("qmtoken://gamelock_activity?"))
        {
          localObject2 = paramBundle.substring(28).split("&");
          localObject1 = "";
          if (localObject2.length == 2)
          {
            arrayOfString = localObject2[0].split("=");
            paramBundle = (Bundle)localObject1;
            if (arrayOfString.length == 2)
            {
              paramBundle = (Bundle)localObject1;
              if (arrayOfString[0].equals("sig")) {
                paramBundle = arrayOfString[1];
              }
            }
            localObject1 = localObject2[1].split("=");
            if ((localObject1.length == 2) && (localObject1[0].equals("page"))) {
              i = Integer.valueOf(localObject1[1]).intValue();
            } else {
              i = -1;
            }
            if ((!TextUtils.isEmpty(paramBundle)) && (i != -1)) {
              decryptAndCheck(paramBundle, i, 0);
            }
          }
        }
        else if (paramBundle.startsWith("qmtoken://gameprotect_activity?"))
        {
          localObject2 = paramBundle.substring(31).split("&");
          localObject1 = "";
          if (localObject2.length == 2)
          {
            arrayOfString = localObject2[0].split("=");
            paramBundle = (Bundle)localObject1;
            if (arrayOfString.length == 2)
            {
              paramBundle = (Bundle)localObject1;
              if (arrayOfString[0].equals("sig")) {
                paramBundle = arrayOfString[1];
              }
            }
            localObject1 = localObject2[1].split("=");
            if ((localObject1.length == 2) && (localObject1[0].equals("page"))) {
              i = Integer.valueOf(localObject1[1]).intValue();
            } else {
              i = -1;
            }
            if ((!TextUtils.isEmpty(paramBundle)) && (i != -1)) {
              decryptAndCheck(paramBundle, i, 1);
            }
          }
        }
        else if (paramBundle.startsWith("qmtoken://modifypwd_activity?"))
        {
          localObject2 = paramBundle.substring(29).split("&");
          localObject1 = "";
          if (localObject2.length == 2)
          {
            arrayOfString = localObject2[0].split("=");
            paramBundle = (Bundle)localObject1;
            if (arrayOfString.length == 2)
            {
              paramBundle = (Bundle)localObject1;
              if (arrayOfString[0].equals("sig")) {
                paramBundle = arrayOfString[1];
              }
            }
            localObject1 = localObject2[1].split("=");
            if ((localObject1.length == 2) && (localObject1[0].equals("page"))) {
              i = Integer.valueOf(localObject1[1]).intValue();
            } else {
              i = -1;
            }
            if ((!TextUtils.isEmpty(paramBundle)) && (i != -1)) {
              decryptAndCheck(paramBundle, i, 2);
            }
          }
        }
      }
      if (localBundle != null) {
        paramBundle = localBundle.getString("package");
      } else {
        paramBundle = null;
      }
      if (paramBundle == null)
      {
        setContentView(2131296370);
        m.a(this, findViewById(2131166111), 2130968678);
        this.mLogoBmp = m.a(getResources(), 2131099959);
        this.cur_time = System.currentTimeMillis();
        if (this.mLogoBmp == null)
        {
          this.cur_time = 0L;
        }
        else
        {
          this.mLogoView = ((ImageView)findViewById(2131165710));
          this.mLogoView.setImageBitmap(this.mLogoBmp);
        }
      }
      else
      {
        c.a(false);
        this.cur_time = 0L;
      }
      paramBundle = (NotificationManager)getSystemService("notification");
      paramBundle.cancel(1);
      paramBundle.cancel(2);
      paramBundle.cancel(3);
      if (this.cur_time == 0L) {
        nextPage();
      } else {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            LogoActivity.this.nextPage();
          }
        }, 800L);
      }
      m.a();
      ef.b();
      try
      {
        paramBundle = new Intent(this, NetInfoService.class);
        localIntent.setAction("com.tencent.token.upload.NetInfoService");
        startService(paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OpenAppCrash ");
      ((StringBuilder)localObject1).append(paramBundle.toString());
      g.d(((StringBuilder)localObject1).toString());
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Bitmap localBitmap = this.mLogoBmp;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.mLogoBmp = null;
    }
    if (m.a.mStartUpImg != null)
    {
      m.a.mStartUpImg.recycle();
      m.a.mStartUpImg = null;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    for (;;)
    {
      try
      {
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        if (paramArrayOfInt.length > 0)
        {
          ArrayList localArrayList = new ArrayList();
          paramInt = 0;
          if (paramInt < paramArrayOfInt.length)
          {
            if (paramArrayOfInt[paramInt] == 0) {
              break label90;
            }
            localArrayList.add(paramArrayOfString[paramInt]);
            break label90;
          }
          if (!localArrayList.isEmpty())
          {
            this.mListener.a(localArrayList);
            return;
          }
          this.mListener.a();
          return;
        }
      }
      catch (Exception paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
      }
      return;
      label90:
      paramInt += 1;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (com.tencent.token.upload.e.a)
    {
      com.tencent.token.upload.e.c = System.currentTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(com.tencent.token.upload.e.a());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start:");
      localStringBuilder.append(com.tencent.token.upload.e.b);
      g.c(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("end:");
      localStringBuilder.append(com.tencent.token.upload.e.c);
      g.c(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("appTime:");
      localStringBuilder.append((String)localObject);
      g.c(localStringBuilder.toString());
    }
  }
  
  public void requestRuntimePermissions(String[] paramArrayOfString, f paramf)
  {
    for (;;)
    {
      int i;
      try
      {
        this.mListener = paramf;
        paramf = new ArrayList();
        int j = paramArrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str = paramArrayOfString[i];
          if (ContextCompat.checkSelfPermission(this, str) != 0) {
            paramf.add(str);
          }
        }
        else
        {
          if (!paramf.isEmpty())
          {
            ActivityCompat.requestPermissions(this, (String[])paramf.toArray(new String[paramf.size()]), 1);
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