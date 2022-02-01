package com.tencent.qqmail.notificationshortcut;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.CustomDialogBuilder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.BrandUtil;
import java.util.Calendar;
import moai.oss.KvHelper;

public class ShortcutGuidance
{
  public static final String FEATURE_CALENDAR = "FEATURE_CALENDAR";
  public static final String FEATURE_COMPOSE_MAIL = "FEATURE_COMPOSE_MAIL";
  public static final String FEATURE_COMPOSE_NOTE = "FEATURE_COMPOSE_NOTE";
  public static final String FEATURE_SCAN = "FEATURE_SCAN";
  private static final String TAG = "ShortcutGuidance";
  private static SharedPreferences sharedPreferences = QMApplicationContext.sharedInstance().getSharedPreferences("ShortcutGuidance", 0);
  
  public static void addUsedTimes(String paramString)
  {
    Log.i("ShortcutGuidance", "getDateString = " + getDateString());
    int i = getUsedTimes(paramString);
    paramString = paramString + getDateString();
    sharedPreferences.edit().putInt("used_times_" + paramString, i + 1).commit();
  }
  
  public static void checkPopupGuideDialog(Context paramContext)
  {
    if ((getGuidanceShown()) || (!needToShowGuidance()) || (QMSettingManager.sharedInstance().getNotificationShortCutEnable())) {}
    while (!needGuide()) {
      return;
    }
    TextView localTextView = (TextView)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559715, null);
    String str2 = paramContext.getResources().getString(getGuidanceMessage());
    String str1 = str2;
    if (!PermissionUtils.hasNotificationPostPermission()) {
      str1 = str2 + paramContext.getResources().getString(2131696456);
    }
    localTextView.setText(str1);
    ((QMUIDialog.CustomDialogBuilder)((QMUIDialog.CustomDialogBuilder)new QMUIDialog.CustomDialogBuilder(paramContext).setLayout(localTextView).addAction(2131691246, new ShortcutGuidance.2())).addAction(0, 2131693129, 0, new ShortcutGuidance.1(paramContext))).create().show();
    setGuidanceShown(true);
    KvHelper.notificationPanelPopGuide(new double[0]);
  }
  
  private static String getDateString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    Calendar localCalendar = Calendar.getInstance();
    localStringBuilder.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      localObject = "0" + i;
      localStringBuilder.append(localObject);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label115;
      }
    }
    label115:
    for (Object localObject = "0" + i;; localObject = Integer.valueOf(i))
    {
      localStringBuilder.append(localObject);
      return localStringBuilder.toString();
      localObject = Integer.valueOf(i);
      break;
    }
  }
  
  private static int getGuidanceMessage()
  {
    if (getUsedTimes("FEATURE_COMPOSE_MAIL") >= 3) {
      return 2131696453;
    }
    if (getUsedTimes("FEATURE_COMPOSE_NOTE") >= 3) {
      return 2131696454;
    }
    if (getUsedTimes("FEATURE_SCAN") >= 3) {
      return 2131696457;
    }
    return 2131696452;
  }
  
  private static boolean getGuidanceShown()
  {
    return sharedPreferences.getBoolean("guidance_shown", false);
  }
  
  private static int getUsedTimes(String paramString)
  {
    paramString = paramString + getDateString();
    return sharedPreferences.getInt("used_times_" + paramString, 0);
  }
  
  private static void launchNotifyPermissionPage(Context paramContext)
  {
    int i = 2131690412;
    Intent localIntent;
    QMApplicationContext localQMApplicationContext;
    if (BrandUtil.isColorOSV21())
    {
      localIntent = new Intent().setClassName("com.oppo.notification.center", "com.oppo.notification.center.AppDetailActivity").putExtra("pkg_name", QMApplicationContext.sharedInstance().getPackageName());
      localQMApplicationContext = QMApplicationContext.sharedInstance();
      if (AppConfig.isBeta()) {
        localIntent = localIntent.putExtra("app_name", localQMApplicationContext.getString(i)).putExtra("class_name", "com.tencent.qqmail.launcher.desktop.LaucherActivity");
      }
    }
    for (;;)
    {
      try
      {
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Exception paramContext) {}
      i = 2131690411;
      break;
      if (BrandUtil.isColorOS())
      {
        localIntent = new Intent().setClassName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity").putExtra("pkg_name", QMApplicationContext.sharedInstance().getPackageName());
        localQMApplicationContext = QMApplicationContext.sharedInstance();
        if (AppConfig.isBeta()) {
          localIntent = localIntent.putExtra("app_name", localQMApplicationContext.getString(i)).putExtra("class_name", "com.tencent.qqmail.launcher.desktop.LaucherActivity");
        } else {
          i = 2131690411;
        }
      }
      else
      {
        localIntent = new Intent().setAction("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", QMApplicationContext.sharedInstance().getPackageName(), null));
      }
    }
  }
  
  private static boolean needGuide()
  {
    return false;
  }
  
  private static boolean needToShowGuidance()
  {
    return (getUsedTimes("FEATURE_COMPOSE_NOTE") >= 3) || (getUsedTimes("FEATURE_COMPOSE_MAIL") >= 3) || (getUsedTimes("FEATURE_CALENDAR") >= 5) || (getUsedTimes("FEATURE_SCAN") >= 3);
  }
  
  public static void popNotificationPermissionDialog(Context paramContext)
  {
    paramContext = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(paramContext).setTitle(2131696458)).setMessage(2131696455).addAction(2131691246, new ShortcutGuidance.4())).addAction(0, 2131693129, 0, new ShortcutGuidance.3(paramContext))).create();
    paramContext.setCancelable(false);
    paramContext.show();
  }
  
  public static void reset()
  {
    setUsedTimes("FEATURE_COMPOSE_MAIL", 0);
    setUsedTimes("FEATURE_COMPOSE_NOTE", 0);
    setUsedTimes("FEATURE_SCAN", 0);
    setUsedTimes("FEATURE_CALENDAR", 0);
  }
  
  public static void setGuidanceShown(boolean paramBoolean)
  {
    sharedPreferences.edit().putBoolean("guidance_shown", paramBoolean).commit();
  }
  
  private static void setUsedTimes(String paramString, int paramInt)
  {
    paramString = paramString + getDateString();
    sharedPreferences.edit().putInt("used_times_" + paramString, paramInt).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.notificationshortcut.ShortcutGuidance
 * JD-Core Version:    0.7.0.1
 */