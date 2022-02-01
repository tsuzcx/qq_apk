import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.DarkModeManager.6;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeSwitcher.a;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class aogc
{
  private static boolean cLw;
  private static boolean isOpened;
  
  public static void QM(boolean paramBoolean)
  {
    if (paramBoolean) {
      report("0X800A3E8");
    }
    SharedPreferences localSharedPreferences;
    for (;;)
    {
      isOpened = false;
      localSharedPreferences = getSharedPreferences();
      if (localSharedPreferences != null) {
        break;
      }
      return;
      report("0X800A3E7");
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "updateModeStatus isOpened  = " + isOpened);
    }
    localSharedPreferences.edit().putBoolean("dark_switch_key", isOpened).apply();
  }
  
  public static void QN(boolean paramBoolean)
  {
    cLw = paramBoolean;
  }
  
  public static void a(Activity paramActivity, String paramString, aogc.a parama)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("DarkModeManager", 2, "showThemeDarkModeTips error!: ");
      return;
    }
    paramActivity = aqha.b(paramActivity, 0, null, paramActivity.getString(2131719720), paramActivity.getString(2131721058), paramActivity.getString(2131691970), new aogf(parama), new aogg(parama));
    paramActivity.show();
    paramActivity.setCancelable(false);
    report("0X800A5C9");
  }
  
  public static void a(ThemeSwitcher.a parama)
  {
    if (isOpened()) {
      if ((BaseApplicationImpl.getApplication().getApplicationContext().getResources().getConfiguration().uiMode & 0x30) == 32)
      {
        bool1 = true;
        bool2 = ThemeUtil.isNowThemeIsNight(null, false, null);
        if (QLog.isColorLevel()) {
          QLog.d("DarkModeManager", 2, "updateDarkModeStatus isNightMode  = " + bool2 + ", isDarkMode = " + bool1);
        }
        a(bool1, bool2, parama);
      }
    }
    while ((!cLw) || (BaseApplicationImpl.isCurrentVersionFirstLaunch)) {
      for (;;)
      {
        boolean bool2;
        return;
        boolean bool1 = false;
      }
    }
    dUy();
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, ThemeSwitcher.a parama)
  {
    if ((paramBoolean1) && (!paramBoolean2)) {
      switchToNightMode();
    }
    while ((paramBoolean1) || (!paramBoolean2)) {
      return;
    }
    b(parama);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing()))
    {
      QLog.e("DarkModeManager", 2, "showDarkModeTips error!: ");
      return;
    }
    String str = localBaseActivity.getString(2131719723);
    if (!paramBoolean1) {
      str = localBaseActivity.getString(2131719719);
    }
    paramString1 = aqha.b(localBaseActivity, 0, null, str, localBaseActivity.getString(2131721058), localBaseActivity.getString(2131691970), new aogd(paramBoolean1, paramBoolean2), new aoge(paramString1, paramString2));
    paramString1.show();
    paramString1.setCancelable(false);
    dUx();
    report("0X800A5B4");
  }
  
  public static boolean a(Activity paramActivity, String paramString, aogc.a parama)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    while (!isOpened()) {
      return false;
    }
    boolean bool2;
    label40:
    boolean bool1;
    if ((paramActivity.getResources().getConfiguration().uiMode & 0x30) == 32)
    {
      bool2 = true;
      bool1 = ThemeUtil.isNowThemeIsNight(null, false, paramString);
      if (TextUtils.isEmpty(paramString))
      {
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label135;
        }
        bool1 = true;
      }
      label65:
      if (bool2 == bool1) {
        break label138;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeManager", 2, "userSetThemeAction isNightMode  = " + bool1 + ", isDarkMode = " + bool2);
      }
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label140;
      }
      a(paramActivity, paramString, parama);
    }
    for (;;)
    {
      return true;
      bool2 = false;
      break label40;
      label135:
      bool1 = false;
      break label65;
      label138:
      break;
      label140:
      ThreadManager.getUIHandler().post(new DarkModeManager.6(paramActivity, paramString, parama));
    }
  }
  
  public static boolean azy()
  {
    return Build.VERSION.SDK_INT >= 29;
  }
  
  public static boolean azz()
  {
    
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "getDarkModeSwitch isOpened  = " + isOpened);
    }
    return isOpened;
  }
  
  private static void b(ThemeSwitcher.a parama)
  {
    Object localObject;
    if (anlm.ayn())
    {
      int i = anlm.Ke();
      localObject = anlj.gS[i];
    }
    for (;;)
    {
      QLog.d("DarkModeManager", 1, "closedNightMode is called, will set themeID=" + (String)localObject);
      ThemeSwitcher.a((String)localObject, "202", parama);
      return;
      localObject = aohc.c(getQQAppInterface());
      String str = ((Bundle)localObject).getString("themeID");
      QLog.d("DarkModeManager", 1, "closedNightMode, pre themeID=" + str + ",version=" + ((Bundle)localObject).getString("version"));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "1000";
      }
    }
  }
  
  public static boolean bK(String paramString1, String paramString2)
  {
    return false;
  }
  
  private static void dUw()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences != null)
    {
      isOpened = localSharedPreferences.getBoolean("dark_switch_key", false);
      return;
    }
    isOpened = false;
  }
  
  private static void dUx()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "setShownPromtFlag is called!");
    }
    localSharedPreferences.edit().putBoolean("dialog_has_shown_key", true).apply();
  }
  
  private static void dUy()
  {
    bK("1000", "204");
  }
  
  @Nullable
  private static QQAppInterface getQQAppInterface()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  private static SharedPreferences getSharedPreferences()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = BaseApplicationImpl.getApplication();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((AppRuntime)localObject3).getApplication().getSharedPreferences("DarkModeManagerdark_mode_ui", 4);
        }
      }
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DarkModeManager", 2, "getSharedPreferences error!: ", localThrowable);
    }
    return null;
  }
  
  public static boolean isOpened()
  {
    return (azy()) && (azz());
  }
  
  public static boolean pX(String paramString)
  {
    if (isOpened()) {
      if ((BaseApplicationImpl.getApplication().getApplicationContext().getResources().getConfiguration().uiMode & 0x30) != 32) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = ThemeUtil.isNowThemeIsNight(null, false, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeManager", 2, "updateDarkModeStatus isNightMode  = " + bool2 + ", isDarkMode = " + bool1);
      }
      if (bool1 != bool2) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static void report(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeManager", 2, "report() called with: key = [" + paramString + "]");
    }
    anot.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  private static void switchToNightMode()
  {
    if (anlm.ayn()) {}
    for (String str = "2920";; str = "1103")
    {
      QLog.d("DarkModeManager", 1, "switchToNightMode themeID=" + str);
      ThemeSwitcher.a(str, "202", null);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onConfirm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogc
 * JD-Core Version:    0.7.0.1
 */