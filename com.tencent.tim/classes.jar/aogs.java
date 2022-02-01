import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeSwitcher.a;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class aogs
{
  ThemeSwitcher.a a = new aogt(this);
  ArrayList<aogs.a> callbacks = new ArrayList();
  private WeakReference<Activity> hY;
  AppRuntime mRuntime;
  Handler mUiHandler = new aogu(this, Looper.getMainLooper());
  aoha themeSwitchManager;
  
  public aogs(AppRuntime paramAppRuntime)
  {
    this.mRuntime = paramAppRuntime;
    this.themeSwitchManager = ((aoha)paramAppRuntime.getManager(185));
  }
  
  public int KF()
  {
    int i = 2;
    if (azC())
    {
      if (QLog.isColorLevel()) {
        QLog.i("NightModeLogic", 2, "switchRightViewImage status: juhua");
      }
      i = 0;
    }
    do
    {
      return i;
      if (ThemeUtil.isInNightMode(this.mRuntime))
      {
        if (QLog.isColorLevel()) {
          QLog.i("NightModeLogic", 2, "switchRightViewImage status: sun");
        }
        return 1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NightModeLogic", 2, "switchRightViewImage status: moon");
    return 2;
  }
  
  public void M(int paramInt, Bundle paramBundle)
  {
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext())
    {
      aogs.a locala = (aogs.a)localIterator.next();
      if (1 == paramInt) {
        locala.bp(paramBundle);
      } else if (-2 == paramInt) {
        locala.bq(paramBundle);
      }
    }
  }
  
  public void a(aogs.a parama, boolean paramBoolean)
  {
    if (parama != null)
    {
      this.callbacks.remove(parama);
      if (paramBoolean) {
        this.callbacks.add(parama);
      }
    }
  }
  
  public boolean azC()
  {
    boolean bool = ThemeSwitcher.azc();
    QLog.e("NightModeLogic", 1, "isDownloadOrSwtich: " + bool);
    return bool;
  }
  
  public boolean azD()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NightModeLogic", 2, "setupNightTheme");
    }
    if (this.mRuntime == null)
    {
      QLog.e("NightModeLogic", 1, "setupNightTheme Err mRuntime == null");
      return false;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("start_status", 1);
    M(1, (Bundle)localObject);
    boolean bool1 = ThemeUtil.isNowThemeIsNight(this.mRuntime, false, null);
    boolean bool2 = anlm.ayn();
    if (!bool1) {
      if (bool2)
      {
        localObject = "2920";
        anot.a((QQAppInterface)this.mRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "1", "", "", "");
        VasWebviewUtil.reportVasStatus("Setting_tab", "Night_mode", "0", 0, 0);
      }
    }
    for (;;)
    {
      QLog.d("NightModeLogic", 1, "setupNightTheme themeID=" + (String)localObject);
      ThemeSwitcher.a((String)localObject, "202", this.a);
      return true;
      localObject = "1103";
      break;
      if (!bool2) {
        break label187;
      }
      int i = anlm.Ke();
      localObject = anlj.gS[i];
    }
    label187:
    Bundle localBundle = aohc.c((QQAppInterface)this.mRuntime);
    localObject = localBundle.getString("themeID");
    QLog.d("NightModeLogic", 1, "setupNightTheme, pre themeID=" + (String)localObject + ",version=" + localBundle.getString("version"));
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      anot.a((QQAppInterface)this.mRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "0", "", "", "");
      break;
      localObject = "1000";
    }
  }
  
  public void ch(Activity paramActivity)
  {
    if (this.mRuntime == null) {
      QLog.e("NightModeLogic", 1, "startNightMode Err mRuntime == null");
    }
    boolean bool;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NightModeLogic", 2, "startNightMode, isNightMode=" + ThemeUtil.isInNightMode(this.mRuntime) + ", nowThemeId=" + ThemeUtil.getCurrentThemeId() + ", userThemeId=" + ThemeUtil.getUserCurrentThemeId(this.mRuntime) + ", mRuntime=" + this.mRuntime);
      }
      this.hY = new WeakReference(paramActivity);
      bool = azD();
    } while (!QLog.isColorLevel());
    QLog.i("NightModeLogic", 2, "startNightMode result=" + bool);
  }
  
  public void destroy()
  {
    this.mRuntime = null;
  }
  
  public void m(AppRuntime paramAppRuntime)
  {
    this.mRuntime = paramAppRuntime;
  }
  
  public void onPostThemeChanged()
  {
    this.themeSwitchManager.onPostThemeChanged();
    if ((this.mRuntime instanceof QQAppInterface)) {
      ((anlk)((QQAppInterface)this.mRuntime).getBusinessHandler(154)).onPostThemeChanged();
    }
  }
  
  public static abstract interface a
  {
    public abstract void bp(Bundle paramBundle);
    
    public abstract void bq(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogs
 * JD-Core Version:    0.7.0.1
 */