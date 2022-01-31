package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpContinueDownloadFileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeSwitchManager
{
  private static final int ANIMATION_DURATION = 501;
  public static final String TAG = "ThemeSwitch";
  public static final int THEME_DOWNLOAD_FAIL = 256;
  public static final int THEME_DOWNLOAD_FAIL_NONETWORK = 259;
  public static final int THEME_DOWNLOAD_FAIL_NOSDCARD = 257;
  public static final int THEME_DOWNLOAD_FAIL_NOSPACE = 258;
  public static final int THEME_DOWNLOAD_FAIL_SAMETHEME = 260;
  public static final int THEME_DOWNLOAD_FAIL_STARTUP = 262;
  public static final int THEME_DOWNLOAD_FAIL_THEMEEXITS = 261;
  public static final int THEME_DOWNLOAD_SUCCESS = 1;
  public static final int THEME_DOWNLOAD_SUCCESS_PROCESSING = 3;
  public static final int THEME_SWITCH_FAIL = 512;
  public static final int THEME_SWITCH_FAIL_ISSAMETHEME = 514;
  public static final int THEME_SWITCH_FAIL_ISSWITCHING = 513;
  public static final int THEME_SWITCH_SUCCESS = 2;
  public static boolean isDownloadingInProgress = false;
  public static boolean isSwitchTheme = false;
  private static volatile ThemeSwitchManager singleton;
  private ArrayList callbacks = new ArrayList();
  private Runnable checkTopActivity;
  private WeakReference currActivityRef;
  private String currDownloadingThemeId = "";
  private ThemeSwitchManager.ThemeDownloadHandler downloadHandler;
  public HashMap downloadThemeMap = new HashMap();
  private Bitmap drawingCache;
  private Handler handler;
  boolean isAnimating = false;
  boolean isComplete = false;
  private Context mContext;
  private View rootView;
  BroadcastReceiver screenBroadcastReceiver;
  public QQProgressDialog themeSwitchDialog;
  private ImageView tmpScreenShot;
  
  private ThemeSwitchManager(Activity paramActivity)
  {
    this.mContext = paramActivity.getApplicationContext();
    setActivity(paramActivity);
  }
  
  private void addThemeSpecific(AppRuntime paramAppRuntime)
  {
    if ((this.downloadHandler != null) || (!(paramAppRuntime instanceof QQAppInterface))) {
      return;
    }
    this.downloadHandler = new ThemeSwitchManager.ThemeDownloadHandler(this, null);
    this.downloadHandler.addFilter(new Class[] { HttpContinueDownloadFileProcessor.class });
    ((QQAppInterface)paramAppRuntime).a().a(this.downloadHandler);
  }
  
  private void doAnimation(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "doAnimation, view is null");
      }
      return;
    }
    this.isAnimating = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.1F);
    localAlphaAnimation.setDuration(501L);
    localAlphaAnimation.setInterpolator(new LinearInterpolator());
    localAlphaAnimation.setFillAfter(true);
    paramView.setAnimation(localAlphaAnimation);
  }
  
  private void failAlert(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitch", 2, "failAlert result=" + paramBundle.getInt("result", -1) + ",message=" + paramBundle.getString("message"));
    }
    int i = paramBundle.getInt("result", -1);
    if ((i & 0x100) == 256)
    {
      notifyCallbacks(false, true, paramBundle);
      QQToast.a(this.mContext, 1, this.mContext.getResources().getString(2131562471), 0).b(this.mContext.getResources().getDimensionPixelSize(2131427376));
      paramBundle = BaseApplicationImpl.a.a();
      if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface))) {
        ReportController.b((QQAppInterface)paramBundle, "CliOper", "", "", "Setting_tab", "Night_mode_dl_fail", 0, 0, "", "", "", "");
      }
    }
    while ((i & 0x200) != 512) {
      return;
    }
    notifyCallbacks(false, true, paramBundle);
  }
  
  public static ThemeUtil.ThemeInfo getThemeInfo(String paramString)
  {
    boolean bool2 = false;
    localThemeInfo = new ThemeUtil.ThemeInfo();
    try
    {
      paramString = new JSONObject(URLDecoder.decode(paramString, "UTF-8"));
      localThemeInfo.version = paramString.getString("version");
      localThemeInfo.themeId = paramString.getString("id");
      boolean bool1 = bool2;
      if (paramString.has("isSound"))
      {
        bool1 = bool2;
        if (paramString.getInt("isSound") != 0) {
          bool1 = true;
        }
      }
      localThemeInfo.isVoiceTheme = bool1;
      localThemeInfo.downloadUrl = paramString.getString("url");
      try
      {
        localThemeInfo.size = Long.parseLong(paramString.getString("size"));
        return localThemeInfo;
      }
      catch (Exception paramString)
      {
        localThemeInfo.size = 0L;
        return localThemeInfo;
      }
      return localThemeInfo;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return localThemeInfo;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static ThemeSwitchManager getThemeSwitchManagerInstance(Activity paramActivity)
  {
    if (singleton == null) {}
    try
    {
      if (singleton == null) {
        singleton = new ThemeSwitchManager(paramActivity);
      }
      return singleton;
    }
    finally {}
  }
  
  private String[] getTopActivity(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (paramContext != null)
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = "";
      arrayOfString[1] = "";
      arrayOfString[0] = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).baseActivity.getPackageName();
      arrayOfString[1] = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
      return arrayOfString;
    }
    if (QLog.isColorLevel()) {
      QLog.w("ThemeSwitch", 2, "getTopActivity ret is null");
    }
    return null;
  }
  
  private boolean isLogin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return ((QQAppInterface)localAppRuntime).isLogin();
    }
    return false;
  }
  
  private void notifyCallbacks(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext())
    {
      ThemeSwitchManager.ThemeSwitchCallback localThemeSwitchCallback = (ThemeSwitchManager.ThemeSwitchCallback)localIterator.next();
      if (paramBoolean1) {
        localThemeSwitchCallback.c(paramBundle);
      } else if (paramBoolean2) {
        localThemeSwitchCallback.d(paramBundle);
      }
    }
  }
  
  public static void release()
  {
    isDownloadingInProgress = false;
    isSwitchTheme = false;
  }
  
  protected void doScreenShot()
  {
    try
    {
      if (this.currActivityRef != null)
      {
        Object localObject1 = (Activity)this.currActivityRef.get();
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ThemeSwitch", 2, "doScreenShot, currActivityRef is null");
          return;
        }
        if (this.rootView == null)
        {
          localObject1 = ((Activity)localObject1).getWindow();
          if (localObject1 != null)
          {
            localObject1 = ((Window)localObject1).getDecorView();
            if (localObject1 != null) {
              this.rootView = ((View)localObject1).getRootView();
            }
          }
        }
        if (this.rootView == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ThemeSwitch", 2, "doScreenShot, rootView is null");
          return;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitch", 2, "screen shot oom, no animation", localOutOfMemoryError);
        }
        this.drawingCache = null;
        if ((this.tmpScreenShot != null) && (this.tmpScreenShot.getParent() != null)) {
          ((ViewGroup)this.tmpScreenShot.getParent()).removeView(this.tmpScreenShot);
        }
        this.tmpScreenShot = null;
        while (QLog.isColorLevel())
        {
          QLog.d("ThemeSwitch", 2, "drawingCache is:" + this.drawingCache);
          return;
          boolean bool1 = this.rootView.isDrawingCacheEnabled();
          boolean bool2 = this.rootView.willNotCacheDrawing();
          this.rootView.setDrawingCacheEnabled(true);
          this.rootView.setWillNotCacheDrawing(false);
          localObject2 = this.rootView.getDrawingCache();
          if (localObject2 != null)
          {
            this.drawingCache = Bitmap.createBitmap((Bitmap)localObject2);
            this.tmpScreenShot = new ImageView((Context)this.currActivityRef.get());
            this.tmpScreenShot.setImageBitmap(this.drawingCache);
            localObject2 = (ViewGroup)this.rootView;
            this.tmpScreenShot.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            ((ViewGroup)localObject2).addView(this.tmpScreenShot);
          }
          this.rootView.setDrawingCacheEnabled(bool1);
          this.rootView.setWillNotCacheDrawing(bool2);
        }
        Object localObject2 = null;
      }
    }
  }
  
  public boolean isThemeExist(Context paramContext, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    paramContext = ThemeUtil.getThemeDownloadFilePath(paramContext, paramThemeInfo.themeId, paramThemeInfo.version);
    File localFile = new File(paramContext);
    if ((!localFile.exists()) && (QLog.isColorLevel())) {
      QLog.d("ThemeSwitch", 2, "themeZipFile is not exit");
    }
    if ((!localFile.isFile()) && (QLog.isColorLevel())) {
      QLog.d("ThemeSwitch", 2, "themeZipFile is not file");
    }
    if ((localFile.length() != paramThemeInfo.size) && (QLog.isColorLevel())) {
      QLog.d("ThemeSwitch", 2, "themeZipFile is not size:" + paramContext.length() + "-" + paramThemeInfo.size);
    }
    if ((localFile.exists()) && (localFile.isFile()) && (localFile.length() == paramThemeInfo.size))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "themeZipFile:" + paramThemeInfo.themeId + "," + paramThemeInfo.version + "," + paramThemeInfo.size + " already exists.");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitch", 2, "themeZipFile:" + paramThemeInfo.themeId + "," + paramThemeInfo.version + "," + paramThemeInfo.size + " not exist.");
    }
    return false;
  }
  
  public void manageCallbacks(ThemeSwitchManager.ThemeSwitchCallback paramThemeSwitchCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramThemeSwitchCallback != null) && (!this.callbacks.contains(paramThemeSwitchCallback))) {
      this.callbacks.add(paramThemeSwitchCallback);
    }
    if ((paramBoolean2) && (paramThemeSwitchCallback != null)) {
      this.callbacks.remove(paramThemeSwitchCallback);
    }
  }
  
  public void onPostThemeChanged()
  {
    if ((this.themeSwitchDialog != null) && (this.themeSwitchDialog.isShowing()))
    {
      this.themeSwitchDialog.dismiss();
      this.themeSwitchDialog = null;
    }
    if (this.rootView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "onPostThemeChanged rootView is null");
      }
      return;
    }
    if ((this.drawingCache != null) && (!this.isAnimating))
    {
      doAnimation(this.tmpScreenShot);
      this.rootView.postDelayed(new ThemeSwitchManager.1(this), 601L);
    }
    this.rootView = null;
  }
  
  public void setActivity(Activity paramActivity)
  {
    if ((this.currActivityRef != null) && (this.currActivityRef.get() == paramActivity)) {
      return;
    }
    this.currActivityRef = new WeakReference(paramActivity);
  }
  
  public void setup(AppRuntime paramAppRuntime, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    String str1 = paramThemeInfo.themeId;
    String str2 = paramThemeInfo.version;
    int i;
    if (paramThemeInfo.isVoiceTheme)
    {
      i = 1;
      paramThemeInfo = ThemeUtil.getThemeInfo(paramAppRuntime.getApplication(), str1);
      if (paramThemeInfo != null) {
        if (!paramThemeInfo.isVoiceTheme) {
          break label206;
        }
      }
    }
    label167:
    label173:
    label206:
    for (int j = 1;; j = 0)
    {
      if (j != i) {
        if (i != 1) {
          break label167;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramThemeInfo.isVoiceTheme = bool;
        ThemeUtil.setThemeInfo(paramAppRuntime.getApplication(), paramThemeInfo);
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "ThemeSwitchManager setup,themeId=" + str1 + ",version=" + str2 + ",isSound=" + i);
        }
        if (isSwitchTheme) {
          break label173;
        }
        new ThemeSwitchManager.SwitchThemeTask(this, paramAppRuntime).execute(new Object[] { str1, str2 });
        return;
        i = 0;
        break;
      }
      paramAppRuntime = new Bundle();
      paramAppRuntime.putInt("result", 513);
      paramAppRuntime.putCharSequence("message", "is switching theme");
      failAlert(paramAppRuntime);
      return;
    }
  }
  
  public void startDownload(AppRuntime paramAppRuntime, ThemeUtil.ThemeInfo paramThemeInfo)
  {
    Bundle localBundle = new Bundle();
    String str3;
    String str1;
    String str2;
    long l1;
    int i;
    try
    {
      str3 = paramThemeInfo.downloadUrl;
      str1 = paramThemeInfo.version;
      str2 = paramThemeInfo.themeId;
      l1 = paramThemeInfo.size;
      if (!paramThemeInfo.isVoiceTheme) {
        break label1115;
      }
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "ThemeSwitchManager start download theme ver=" + str1 + ",id=" + str2 + ",size=" + l1 + ",isSound=" + i);
      }
      if (!Utils.e())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitch", 2, "SDCard not available.");
        }
        localBundle.putInt("result", 257);
        localBundle.putCharSequence("message", "SDCard not available.");
        failAlert(localBundle);
        return;
      }
      long l2 = Utils.b();
      if (l2 >= 5242880 + l1) {
        break label328;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "Insufficient SDCard space, required:" + l1 + "| reserved:" + 5242880 + "|available:" + l2);
      }
      localBundle.putInt("result", 258);
      localBundle.putCharSequence("message", "Insufficient SDCard space.");
      failAlert(localBundle);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      isDownloadingInProgress = false;
      localBundle.putInt("result", 256);
      localBundle.putBoolean("isDownloadingInProgress", false);
      failAlert(localBundle);
      paramAppRuntime.printStackTrace();
      if (!QLog.isColorLevel()) {
        break label1114;
      }
    }
    QLog.i("ThemeSwitch", 2, "Err, " + paramAppRuntime.getMessage());
    return;
    label328:
    if (!NetworkUtil.e(paramAppRuntime.getApplication()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "No network access.");
      }
      localBundle.putInt("result", 259);
      localBundle.putCharSequence("message", "No network access.");
      failAlert(localBundle);
      return;
    }
    ThemeUtil.ThemeInfo localThemeInfo;
    label524:
    label613:
    String str4;
    if (isDownloadingInProgress)
    {
      localThemeInfo = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(str2);
      if ((this.currDownloadingThemeId.equals(str2)) && (localThemeInfo != null) && (str1 == localThemeInfo.version))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeSwitch", 2, "Redundant downloading request for one theme.");
        }
        localBundle.putInt("result", 260);
        localBundle.putCharSequence("message", "Downloading of theme=" + str2 + ",version=" + str1 + " already in progress.");
        failAlert(localBundle);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "pause downloading currentTheme");
      }
    }
    else if (isThemeExist(paramAppRuntime.getApplication(), paramThemeInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "Theme already exists, themeId=" + str2 + ",version=" + str1 + ",size=" + l1);
      }
      paramThemeInfo = ThemeUtil.getThemeInfo(paramAppRuntime.getApplication(), str2);
      if (paramThemeInfo == null)
      {
        paramThemeInfo = new ThemeUtil.ThemeInfo();
        paramThemeInfo.downsize = l1;
        paramThemeInfo.size = l1;
        paramThemeInfo.themeId = str2;
        paramThemeInfo.version = str1;
        paramThemeInfo.status = "3";
        if (i != 1) {
          break label1128;
        }
        bool = true;
        label652:
        paramThemeInfo.isVoiceTheme = bool;
        ThemeUtil.setThemeInfo(paramAppRuntime.getApplication(), paramThemeInfo);
        localBundle.putInt("result", 261);
        localBundle.putCharSequence("message", "Download target exists in local storage.");
        failAlert(localBundle);
      }
    }
    else
    {
      str4 = ThemeUtil.getThemeDownloadFilePath(paramAppRuntime.getApplication(), str2, str1);
      isDownloadingInProgress = true;
      localThemeInfo = (ThemeUtil.ThemeInfo)this.downloadThemeMap.get(str2);
      paramThemeInfo = localThemeInfo;
      if (localThemeInfo == null)
      {
        localThemeInfo = ThemeUtil.getThemeInfo(paramAppRuntime.getApplication(), str2);
        paramThemeInfo = localThemeInfo;
        if (localThemeInfo != null)
        {
          localThemeInfo.downloadUrl = str3;
          paramThemeInfo = localThemeInfo;
        }
      }
      if (paramThemeInfo != null)
      {
        localThemeInfo = paramThemeInfo;
        if (paramThemeInfo.version.equals(str1)) {}
      }
      else
      {
        localThemeInfo = new ThemeUtil.ThemeInfo();
        localThemeInfo.themeId = str2;
        localThemeInfo.downloadUrl = str3;
        localThemeInfo.size = l1;
        localThemeInfo.downsize = 0L;
        localThemeInfo.version = str1;
        localThemeInfo.status = "1";
        if (i != 1) {
          break label1134;
        }
      }
    }
    label1114:
    label1115:
    label1128:
    label1134:
    for (boolean bool = true;; bool = false)
    {
      localThemeInfo.isVoiceTheme = bool;
      this.downloadThemeMap.put(str2, localThemeInfo);
      this.currDownloadingThemeId = str2;
      addThemeSpecific(paramAppRuntime);
      paramAppRuntime = ((QQAppInterface)paramAppRuntime).a();
      if ((paramAppRuntime != null) && (paramAppRuntime.e(str3, str4, l1)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "wifi network start downloading of theme=" + str2 + ",version=" + str1 + ",themeInfo=" + localThemeInfo.toString());
        }
      }
      else if ((paramAppRuntime != null) && (paramAppRuntime.a(str3) != null))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "wifi network is downloading of theme=" + str2 + ",version=" + str1 + ",themeInfo=" + localThemeInfo.toString());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "Err, Start downloading of theme=" + str2 + ",version=" + str1);
        }
        localBundle.putInt("result", 262);
        localBundle.putBoolean("isDownloadingInProgress", false);
        this.downloadThemeMap.remove(str2);
        isDownloadingInProgress = false;
        failAlert(localBundle);
        return;
        break label613;
      }
      return;
      i = 0;
      break;
      if (localThemeInfo == null) {
        break label524;
      }
      break label524;
      bool = false;
      break label652;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager
 * JD-Core Version:    0.7.0.1
 */