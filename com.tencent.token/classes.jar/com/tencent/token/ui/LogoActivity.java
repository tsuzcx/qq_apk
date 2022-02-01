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
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.aao;
import com.tencent.token.aap;
import com.tencent.token.abh;
import com.tencent.token.ahc;
import com.tencent.token.ais;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.rf;
import com.tencent.token.rw;
import com.tencent.token.sk;
import com.tencent.token.sz;
import com.tencent.token.th;
import com.tencent.token.upload.NetInfoService;
import com.tencent.token.xf;
import com.tencent.token.xj;
import com.tencent.token.yq;
import com.tencent.token.zw;

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
  private long cur_time;
  private Dialog dialog;
  private final int logo_time = 800;
  private boolean mFromH5 = false;
  private boolean mFromOtherApp = false;
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
          Object localObject = new abh();
          byte[] arrayOfByte = sz.a(paramString);
          StringBuilder localStringBuilder = new StringBuilder("decryptAndCheck sig=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" schemaKey=");
          localStringBuilder.append(this.schemaKey);
          xj.b(localStringBuilder.toString());
          paramString = ((abh)localObject).a(arrayOfByte, this.schemaKey.getBytes());
          localObject = new StringBuilder("temp =");
          if (paramString == null)
          {
            bool = true;
            ((StringBuilder)localObject).append(bool);
            xj.b(((StringBuilder)localObject).toString());
            if ((paramString != null) && (paramString.length >= 0))
            {
              paramString = new String(paramString);
              xj.b("result=".concat(String.valueOf(paramString)));
              paramString = paramString.split("&");
              if (paramString.length == 2)
              {
                int i = Integer.valueOf(paramString[0]).intValue();
                long l = Long.valueOf(paramString[1]).longValue();
                int j = (int)rf.a().h();
                paramString = new StringBuilder("timeStamp=");
                paramString.append(i);
                paramString.append("ad=");
                paramString.append(l);
                xj.a(paramString.toString());
                if (Math.abs(j - i) < this.schemaTimeout)
                {
                  this.success = th.a().a(l);
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
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        xj.c(paramString.getMessage());
        return;
      }
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
    if (!rf.a().d())
    {
      if (th.a().k.a() == 0)
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
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            if (paramAnonymousDialogInterface != null)
            {
              paramAnonymousDialogInterface.dismiss();
              LogoActivity.this.jumpActivity();
            }
          }
        }).setNegativeButton(2131493544, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface = new Intent(LogoActivity.this, WtLoginAccountInput.class);
            paramAnonymousDialogInterface.putExtra("page_id", 3);
            LogoActivity.this.startActivity(paramAnonymousDialogInterface);
            LogoActivity.this.finish();
          }
        }).create();
        this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
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
    if ((sk.a().c()) && (sk.a().a == 1))
    {
      localObject = new Intent(this, StartPwdDigitVerifyActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("enter_type", 1);
      ((Intent)localObject).putExtra("com.tencent.input_param", localBundle);
      startActivityForResult((Intent)localObject, 256);
      return;
    }
    if (aap.a.mStartUpImg != null)
    {
      setContentView(2131296454);
      localObject = (ImageView)findViewById(2131166036);
      ((ImageView)localObject).setImageBitmap(aap.a.mStartUpImg);
      ((ImageView)localObject).postDelayed(new Runnable()
      {
        public final void run()
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
      yq.a().a(this, localIntent, yq.b);
      finish();
    }
  }
  
  private void loadSchemaParm()
  {
    Object localObject = RqdApplication.p();
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("schemaparm_name", 0);
      this.schemaKey = ((SharedPreferences)localObject).getString("key_schemaparm_key", "");
      this.schemaTimeout = ((SharedPreferences)localObject).getInt("key_schemaparm_timeout", 0);
      localObject = new StringBuilder("load schemaKey=");
      ((StringBuilder)localObject).append(this.schemaKey);
      ((StringBuilder)localObject).append(" schemaTimeout=");
      ((StringBuilder)localObject).append(this.schemaTimeout);
      xj.b(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("SharedPreferences msg ");
      localStringBuilder.append(localException.getMessage());
      xj.c(localStringBuilder.toString());
    }
  }
  
  private void showOldPwdDeleteAlert()
  {
    if (isFinishing()) {
      return;
    }
    new AlertDialog.Builder(this).setMessage(2131493250).setNegativeButton(2131493286, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        LogoActivity.this.gotoWelcomeActivity();
      }
    }).setPositiveButton(2131493239, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = new Intent(LogoActivity.this, StartPwdGestureModifyActivity.class);
        LogoActivity.this.startActivityForResult(paramAnonymousDialogInterface, 260);
      }
    }).create().show();
  }
  
  private void showPrivacyDialog()
  {
    boolean bool1 = rw.a().b();
    boolean bool2 = RqdApplication.g();
    long l = ahc.a("privacy_dialog_agree_time");
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
      gotonext();
      return;
    }
    Object localObject2 = ahc.c("privacy_dialog_line2_wording", null);
    Object localObject1 = localObject2;
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
      public final void onClick(View paramAnonymousView)
      {
        aao.a(LogoActivity.this, "https://sdi.3g.qq.com/v/2019120415543611159");
      }
      
      public final void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        paramAnonymousTextPaint.setColor(-16740609);
      }
    };
    localObject2 = new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView)
      {
        aao.a(LogoActivity.this, "http://tools.3g.qq.com/j/qqsafety");
      }
      
      public final void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        paramAnonymousTextPaint.setColor(-16740609);
      }
    };
    localObject3 = new SpannableString((CharSequence)localObject3);
    ((SpannableString)localObject3).setSpan(localObject1, 15, 26, 33);
    ((SpannableString)localObject3).setSpan(localObject2, 27, 35, 33);
    localObject1 = new TextView(this);
    ((TextView)localObject1).setTextSize(0, getResources().getDimensionPixelSize(2131034254));
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setPadding(aao.a(this, 5.0F), 0, aao.a(this, 5.0F), 0);
    ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
    ((TextView)localObject1).setText((CharSequence)localObject3);
    if ((!bool2) && (bool1))
    {
      localObject1 = new AlertDialog.Builder(this).setTitle("欢迎使用QQ安全中心").setView((View)localObject1).setPositiveButton("我知道了", null).setCancelable(false).create();
      ((Dialog)localObject1).show();
      ((AlertDialog)localObject1).getButton(-1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          this.a.dismiss();
          ahc.a("privacy_dialog_agree_time", System.currentTimeMillis());
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
      public final void onClick(View paramAnonymousView)
      {
        rw.a().a(false);
        Toast.makeText(RqdApplication.p(), "需要获得您的同意后才可继续使用QQ安全中心提供的服务", 0).show();
      }
    });
    ((AlertDialog)localObject2).getButton(-2).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        this.a.dismiss();
        RqdApplication.f();
        ahc.a("privacy_dialog_agree_time", System.currentTimeMillis());
        RqdApplication.g = true;
        rw.a().a(true);
        LogoActivity.startNetService(LogoActivity.this);
        LogoActivity.this.gotonext();
      }
    });
  }
  
  public static void startNetService(Activity paramActivity)
  {
    try
    {
      NetInfoService.a(RqdApplication.b());
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
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
      sk.a().b(null);
      showOldPwdDeleteAlert();
      return;
    }
    if (paramInt1 == 260)
    {
      if (!sk.a().c())
      {
        showOldPwdDeleteAlert();
        return;
      }
      gotoWelcomeActivity();
      return;
    }
    if (paramInt1 == 261)
    {
      setResult(paramInt2);
    }
    else
    {
      if (paramInt1 != 262) {
        return;
      }
      if (paramInt2 == 263)
      {
        gotonext();
        return;
      }
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append(this);
    paramBundle.append(",task");
    paramBundle.append(getTaskId());
    xj.b(paramBundle.toString());
    requestWindowFeature(1);
    RqdApplication.i();
    xf.a(true);
    paramBundle = getIntent();
    try
    {
      Bundle localBundle = paramBundle.getBundleExtra("com.tencent.input_param");
      paramBundle = paramBundle.getData();
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
            localObject = paramBundle[i].split("=");
            if ((localObject.length == 2) && (localObject[0].equals("uin")) && (localObject[1].matches("^\\d+$")))
            {
              this.mFromOtherApp = true;
              this.mUin = aao.f(Long.parseLong(localObject[1]));
              break;
            }
            i -= 1;
          }
        }
        if (paramBundle.startsWith("qmtoken://index_activity?"))
        {
          paramBundle = paramBundle.substring(25).split("&");
          i = paramBundle.length - 1;
          while (i >= 0)
          {
            localObject = paramBundle[i];
            xj.c("path: ".concat(String.valueOf(localObject)));
            localObject = ((String)localObject).split("=");
            if ((localObject.length == 2) && (localObject[0].equals("tab")) && (localObject[1].equals("2")))
            {
              this.mFromH5 = true;
              break;
            }
            i -= 1;
          }
        }
        String[] arrayOfString1;
        String[] arrayOfString2;
        if (paramBundle.startsWith("qmtoken://gamelock_activity?"))
        {
          arrayOfString1 = paramBundle.substring(28).split("&");
          localObject = "";
          if (arrayOfString1.length == 2)
          {
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
            if ((localObject.length == 2) && (localObject[0].equals("page"))) {
              i = Integer.valueOf(localObject[1]).intValue();
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
          arrayOfString1 = paramBundle.substring(31).split("&");
          localObject = "";
          if (arrayOfString1.length == 2)
          {
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
            if ((localObject.length == 2) && (localObject[0].equals("page"))) {
              i = Integer.valueOf(localObject[1]).intValue();
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
          arrayOfString1 = paramBundle.substring(29).split("&");
          localObject = "";
          if (arrayOfString1.length == 2)
          {
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
            if ((localObject.length == 2) && (localObject[0].equals("page"))) {
              i = Integer.valueOf(localObject[1]).intValue();
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
        setContentView(2131296371);
        aap.a(this, findViewById(2131166119), 2130968678);
        this.mLogoBmp = aap.a(getResources(), 2131099960);
        this.cur_time = System.currentTimeMillis();
        if (this.mLogoBmp == null)
        {
          this.cur_time = 0L;
        }
        else
        {
          this.mLogoView = ((ImageView)findViewById(2131165714));
          this.mLogoView.setImageBitmap(this.mLogoBmp);
        }
      }
      else
      {
        xf.a(false);
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
          public final void run()
          {
            LogoActivity.this.nextPage();
          }
        }, 800L);
      }
      aap.a();
      ahc.b();
      if (rw.a().b()) {
        startNetService(this);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      Object localObject = new StringBuilder("OpenAppCrash ");
      ((StringBuilder)localObject).append(paramBundle.toString());
      xj.c(((StringBuilder)localObject).toString());
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
    if (aap.a.mStartUpImg != null)
    {
      aap.a.mStartUpImg.recycle();
      aap.a.mStartUpImg = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (zw.a)
    {
      zw.c = System.currentTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(zw.a());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder("start:");
      localStringBuilder.append(zw.b);
      xj.c(localStringBuilder.toString());
      localStringBuilder = new StringBuilder("end:");
      localStringBuilder.append(zw.c);
      xj.c(localStringBuilder.toString());
      xj.c("appTime:".concat(String.valueOf(localObject)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.LogoActivity
 * JD-Core Version:    0.7.0.1
 */