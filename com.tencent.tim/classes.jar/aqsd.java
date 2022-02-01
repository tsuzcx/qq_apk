import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import java.io.File;
import mqq.app.AppRuntime;

public class aqsd
  extends aqsa
{
  private static aqsd.a jdField_a_of_type_Aqsd$a = new aqsd.a();
  private static aqsd jdField_a_of_type_Aqsd;
  static anll b = new aqse();
  private static int ect;
  
  public aqsd(aqrn paramaqrn, AppRuntime paramAppRuntime, int paramInt)
  {
    super(paramaqrn, paramAppRuntime, paramInt);
  }
  
  public static void SS(boolean paramBoolean)
  {
    if (paramBoolean) {
      fF(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    if (!TextHook.getInstance().isDefault())
    {
      QLog.d("ThemeFontAdapter", 1, "resetDefaultFont");
      TextHook.getInstance().switchDefault();
      TextHook.getInstance().update(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    ect = 0;
  }
  
  public static void XT(int paramInt)
  {
    kp((int)ku.h(paramInt), ku.c(paramInt));
  }
  
  public static boolean bY(String paramString1, String paramString2)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label22;
      }
      bool2 = bool1;
    }
    for (;;)
    {
      return bool2;
      label22:
      String str = paramString2 + "." + Process.myPid() + ".tmp";
      try
      {
        ETEngine.getInstanceForSpace();
        bool1 = ETEngine.native_ftf2ttf(paramString1, str);
        if (bool1)
        {
          paramString1 = new File(str);
          paramString2 = new File(paramString2);
          if (!paramString2.exists()) {
            bool1 = paramString1.renameTo(paramString2);
          }
          bool2 = bool1;
          if (bool1) {
            continue;
          }
          QLog.e("ThemeFontAdapter", 1, "failed to move trueType font file, from path = " + paramString1.getAbsolutePath());
          return bool1;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("ThemeFontAdapter", 1, "call native_ftf2ttf error, errMsg = " + paramString1.toString());
        return false;
      }
    }
    QLog.e("ThemeFontAdapter", 1, "call native_ftf2ttf error");
    return bool1;
  }
  
  public static String bz(Context paramContext)
  {
    return paramContext.getSharedPreferences("theme", 4).getString("theme_font_root_pre", null);
  }
  
  public static void cV(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("theme", 4);
    paramContext.edit().putString("theme_font_root_pre", paramString).commit();
    paramContext.edit().remove("theme_font_root").commit();
  }
  
  public static void fF(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("theme", 4);
    paramContext.edit().remove("theme_font_root_pre").commit();
    paramContext.edit().remove("theme_font_root").commit();
  }
  
  public static void fG(Context paramContext)
  {
    TextHook.setSupportProcess(true);
    paramContext.registerReceiver(jdField_a_of_type_Aqsd$a, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.tim.msg.permission.pushnotify", null);
  }
  
  public static void fH(Context paramContext)
  {
    paramContext.unregisterReceiver(jdField_a_of_type_Aqsd$a);
  }
  
  private static void ko(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_Aqsd != null) {
      jdField_a_of_type_Aqsd.destroy();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    aqrn localaqrn = new aqrn(localAppRuntime, paramInt1);
    jdField_a_of_type_Aqsd = new aqsd(localaqrn, localAppRuntime, paramInt2);
    localaqrn.a(jdField_a_of_type_Aqsd);
  }
  
  public static void kp(int paramInt1, int paramInt2)
  {
    QLog.d("ThemeFontAdapter", 1, "switchFont  fontId:" + paramInt1 + " fontType:" + paramInt2);
    if (ect == paramInt1)
    {
      QLog.d("ThemeFontAdapter", 1, "switchFont already set fontId:" + paramInt1 + " fontType:" + paramInt2);
      return;
    }
    if (paramInt1 == 0)
    {
      SS(true);
      return;
    }
    ThreadManagerV2.executeOnFileThread(new ThemeFontAdapter.2(paramInt1, paramInt2));
  }
  
  public static void register()
  {
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(b);
  }
  
  public void load()
  {
    if (AppUtil.isMainProcess()) {}
    for (kt localkt = b(this.jdField_a_of_type_Aqrp.getId(), this.mFontType);; localkt = kx.a().b(this.jdField_a_of_type_Aqrp.getId(), this.mFontType))
    {
      QLog.e("ThemeFontAdapter", 2, "load   fontInfo:" + localkt);
      if (localkt != null) {
        kp(localkt.mFontId, this.mFontType);
      }
      return;
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getBooleanExtra("isFont", false)) {
        TextHook.getInstance().checkTypeface(paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsd
 * JD-Core Version:    0.7.0.1
 */