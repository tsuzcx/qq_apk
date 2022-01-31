package com.tencent.token.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.token.ag;
import com.tencent.token.ah;
import com.tencent.token.ap;
import com.tencent.token.ax;
import com.tencent.token.core.bean.ConfigResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.utils.encrypt.a;
import com.tencent.token.utils.s;
import com.tencent.token.utils.t;

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
        byte[] arrayOfByte = ap.a(paramString);
        e.b("decryptAndCheck sig=" + paramString + " schemaKey=" + this.schemaKey);
        paramString = ((a)localObject).a(arrayOfByte, this.schemaKey.getBytes());
        localObject = new StringBuilder().append("temp =");
        if (paramString == null)
        {
          e.b(bool);
          if ((paramString == null) || (paramString.length < 0)) {
            return;
          }
          paramString = new String(paramString);
          e.b("result=" + paramString);
          paramString = paramString.split("&");
          if (paramString.length != 2) {
            return;
          }
          int i = Integer.valueOf(paramString[0]).intValue();
          long l = Long.valueOf(paramString[1]).longValue();
          int j = (int)(ag.c().r() / 1000L);
          e.a("timeStamp=" + i + "ad=" + l);
          if (Math.abs(j - i) >= this.schemaTimeout) {
            return;
          }
          this.success = ax.a().a(l);
          if (!this.success) {
            break;
          }
          launchActivity(paramInt2, paramInt1);
          return;
        }
      }
      catch (Exception paramString)
      {
        e.c(paramString.getMessage());
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
      if (!ag.c().g())
      {
        if (ax.a().d() == 0)
        {
          localIntent = new Intent(this, WtLoginAccountInput.class);
          localIntent.putExtra("page_id", 3);
          startActivity(localIntent);
          finish();
          return;
        }
        if (!this.success)
        {
          this.dialog = new AlertDialog.Builder(this).setTitle(2131362104).setMessage(2131362549).setPositiveButton(2131361850, new pc(this)).setNegativeButton(2131362076, new pb(this)).create();
          this.dialog.setOnCancelListener(new pd(this));
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
    if ((ah.a().c()) && (ah.a().e() == 1))
    {
      localObject = new Intent(this, StartPwdDigitVerifyActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("enter_type", 1);
      ((Intent)localObject).putExtra("com.tencent.input_param", localBundle);
      startActivityForResult((Intent)localObject, 256);
      return;
    }
    if (t.a.mStartUpImg != null)
    {
      setContentView(2130903210);
      localObject = (ImageView)findViewById(2131297136);
      ((ImageView)localObject).setImageBitmap(t.a.mStartUpImg);
      ((ImageView)localObject).postDelayed(new pa(this), 1500L);
      return;
    }
    gotoWelcomeActivity();
  }
  
  private void jomptoGUIDActivity()
  {
    startActivityForResult(new Intent(this, AppGuidActivity.class), 262);
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
    pv.a().a(this, localIntent, pv.b);
    finish();
  }
  
  private void loadSchemaParm()
  {
    Object localObject = RqdApplication.i();
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("schemaparm_name", 0);
      this.schemaKey = ((SharedPreferences)localObject).getString("key_schemaparm_key", "");
      this.schemaTimeout = ((SharedPreferences)localObject).getInt("key_schemaparm_timeout", 0);
      e.b("load schemaKey=" + this.schemaKey + " schemaTimeout=" + this.schemaTimeout);
      return;
    }
    catch (Exception localException)
    {
      e.c("SharedPreferences msg " + localException.getMessage());
    }
  }
  
  private void showOldPwdDeleteAlert()
  {
    if (isFinishing()) {
      return;
    }
    new AlertDialog.Builder(this).setMessage(2131362149).setNegativeButton(2131361809, new pf(this)).setPositiveButton(2131362148, new pe(this)).create().show();
  }
  
  public void nextPage()
  {
    if (isFinishing()) {
      return;
    }
    SharedPreferences localSharedPreferences = RqdApplication.i().getSharedPreferences("sp_name_global", 0);
    if (localSharedPreferences.getBoolean("key_app_firsttime_facepsw", true))
    {
      startActivityForResult(new Intent(this, AppGuidActivity.class), 262);
      localSharedPreferences.edit().putBoolean("key_app_firsttime_facepsw", false).commit();
      return;
    }
    gotonext();
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
      ah.a().b(null);
      showOldPwdDeleteAlert();
      return;
    }
    if (paramInt1 == 260)
    {
      if (!ah.a().c())
      {
        showOldPwdDeleteAlert();
        return;
      }
      gotoWelcomeActivity();
      return;
    }
    if (paramInt1 == 261) {
      setResult(paramInt2);
    }
    do
    {
      finish();
      return;
      if (paramInt1 != 262) {
        break;
      }
    } while (paramInt2 != 263);
    gotonext();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e.b(this + ",task" + getTaskId());
    requestWindowFeature(1);
    RqdApplication.b();
    b.a(true);
    paramBundle = getIntent();
    label266:
    label426:
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        Bundle localBundle = paramBundle.getBundleExtra("com.tencent.input_param");
        paramBundle = paramBundle.getData();
        if (paramBundle != null)
        {
          paramBundle = paramBundle.toString();
          if (!paramBundle.startsWith("qmtoken://dual_verify?")) {
            break label313;
          }
          paramBundle = paramBundle.substring("qmtoken://dual_verify?".length()).split("&");
          i = paramBundle.length - 1;
          if (i >= 0)
          {
            localObject = paramBundle[i].split("=");
            if ((localObject.length != 2) || (!localObject[0].equals("uin")) || (!localObject[1].matches("^\\d+$"))) {
              break label306;
            }
            this.mFromOtherApp = true;
            this.mUin = s.f(Long.parseLong(localObject[1]));
          }
        }
        if (localBundle == null) {
          break label913;
        }
        paramBundle = localBundle.getString("package");
        label183:
        if (paramBundle != null) {
          break label876;
        }
        setContentView(2130903132);
        this.mLogoBmp = t.a(getResources(), 2130837736);
        this.cur_time = System.currentTimeMillis();
        if (this.mLogoBmp != null) {
          break label848;
        }
        this.cur_time = 0L;
        label227:
        paramBundle = (NotificationManager)getSystemService("notification");
        paramBundle.cancel(1);
        paramBundle.cancel(2);
        paramBundle.cancel(3);
        if (this.cur_time != 0L) {
          break label888;
        }
        nextPage();
        t.a();
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        e.d("OpenAppCrash " + paramBundle.toString());
        finish();
        return;
      }
      label306:
      i -= 1;
      continue;
      label313:
      if (paramBundle.startsWith("qmtoken://index_activity?"))
      {
        paramBundle = paramBundle.substring("qmtoken://index_activity?".length()).split("&");
        i = paramBundle.length - 1;
        for (;;)
        {
          if (i < 0) {
            break label426;
          }
          localObject = paramBundle[i];
          e.c("path: " + (String)localObject);
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
        String[] arrayOfString1;
        String[] arrayOfString2;
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
            break label928;
          }
        }
        for (i = Integer.valueOf(localObject[1]).intValue();; i = -1)
        {
          if ((TextUtils.isEmpty(paramBundle)) || (i == -1)) {
            break label931;
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
              break label923;
            }
          }
          for (i = Integer.valueOf(localObject[1]).intValue();; i = -1)
          {
            if ((TextUtils.isEmpty(paramBundle)) || (i == -1)) {
              break label926;
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
                break label921;
              }
              decryptAndCheck(paramBundle, i, 2);
              break;
              label848:
              this.mLogoView = ((ImageView)findViewById(2131296805));
              this.mLogoView.setImageBitmap(this.mLogoBmp);
              break label227;
              label876:
              b.a(false);
              this.cur_time = 0L;
              break label227;
              label888:
              new Handler().postDelayed(new oz(this), 800L);
              break label266;
              paramBundle = null;
              break label183;
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
    if (t.a.mStartUpImg != null)
    {
      t.a.mStartUpImg.recycle();
      t.a.mStartUpImg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.LogoActivity
 * JD-Core Version:    0.7.0.1
 */