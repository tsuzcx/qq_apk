package com.tencent.mobileqq.mini.appbrand.utils;

import acfp;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import aqhu;
import aqju;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;

public class ShortcutUtils
{
  public static final String ACTION_ANDROID = "android.settings.action.MANAGE_OVERLAY_PERMISSION";
  public static final String ACTION_HUAWEI = "huawei.intent.action.NOTIFICATIONMANAGER";
  public static final String ACTION_MEIZU = "com.meizu.safe.security.SHOW_APPSEC";
  public static final String ACTION_MIUI = "miui.intent.action.APP_PERM_EDITOR";
  public static final String ACTION_VIVO = "permission.intent.action.softPermissionDetail";
  public static final String CLASS_HUAWEI = "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity";
  public static final String CLASS_MEIZU = "com.meizu.safe.security.AppSecActivity";
  public static final String CLASS_MIUI = "com.miui.permcenter.permissions.AppPermissionsEditorActivity";
  public static final String EXTRA_MEIZU = "packageName";
  public static final String EXTRA_MIUI = "extra_pkgname";
  public static final String INTENT_ACTION_CREATE_MINI_SHORTCUT = "com.tencent.mini.CreateShortcutSucceedReceiver";
  public static final String PACKAGE_HUAWEI = "com.huawei.systemmanager";
  public static final String PACKAGE_MEIZU = "com.meizu.safe";
  public static final String PACKAGE_MIUI = "com.miui.securitycenter";
  public static final int RESULT_ADD_FAIL = 1;
  public static final int RESULT_ADD_FAIL_NO_PERMISSION = 2;
  public static final int RESULT_ADD_SUCC = 0;
  private static final String TAG = "Shortcut";
  
  public static void addShortcut(BaseActivity paramBaseActivity, ApkgInfo paramApkgInfo)
  {
    addShortcut(paramBaseActivity, paramApkgInfo, null);
  }
  
  public static void addShortcut(BaseActivity paramBaseActivity, ApkgInfo paramApkgInfo, AddShortcutCallback paramAddShortcutCallback)
  {
    if ((paramBaseActivity == null) || (paramApkgInfo == null) || (paramApkgInfo.appConfig == null)) {
      QLog.e("Shortcut", 1, "addShortcut params invalid!");
    }
    do
    {
      return;
      if (hasRightsToShortCutInVIVO(paramBaseActivity)) {
        break;
      }
      paramBaseActivity = PermissionDialog.createPermissionDialog(paramBaseActivity, acfp.m(2131714443), acfp.m(2131714456), acfp.m(2131714458), new ShortcutUtils.1(paramBaseActivity), new ShortcutUtils.2());
      paramBaseActivity.showCheckbox(false);
      paramBaseActivity.show();
    } while (paramAddShortcutCallback == null);
    paramAddShortcutCallback.onAddResult(2, acfp.m(2131714437));
    return;
    doAddShortcut(paramBaseActivity, paramApkgInfo, paramAddShortcutCallback);
  }
  
  public static void doAddShortcut(BaseActivity paramBaseActivity, ApkgInfo paramApkgInfo, AddShortcutCallback paramAddShortcutCallback)
  {
    ThreadManagerV2.executeOnSubThread(new ShortcutUtils.3(paramBaseActivity, paramApkgInfo, paramAddShortcutCallback));
  }
  
  private static Bitmap getLaunchBitmap(Activity paramActivity, ApkgInfo paramApkgInfo)
  {
    paramApkgInfo = ImageUtil.drawableToBitmap(URLDrawable.getDrawable(URLDecoder.decode(paramApkgInfo.iconUrl), null));
    int i = (int)paramActivity.getResources().getDimension(17104896);
    int j = ((ActivityManager)paramActivity.getSystemService("activity")).getLauncherLargeIconSize();
    if (j > i) {
      i = j;
    }
    for (;;)
    {
      return aqhu.c(getResizedBitmap(paramApkgInfo, i, i), (int)(i * 0.15D));
    }
  }
  
  public static Bitmap getResizedBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f1, f2);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
    paramBitmap.recycle();
    return localObject;
  }
  
  /* Error */
  public static boolean hasRightsToShortCutInVIVO(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 239	android/os/Build:MODEL	Ljava/lang/String;
    //   3: invokevirtual 245	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   6: ldc 247
    //   8: invokevirtual 251	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +198 -> 209
    //   14: getstatic 256	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 27
    //   19: if_icmplt +190 -> 209
    //   22: aload_0
    //   23: invokevirtual 262	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: ldc_w 264
    //   29: invokestatic 270	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   32: aconst_null
    //   33: ldc_w 272
    //   36: iconst_1
    //   37: anewarray 241	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc_w 274
    //   45: aastore
    //   46: aconst_null
    //   47: invokestatic 280	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +147 -> 199
    //   55: aload_2
    //   56: astore_0
    //   57: aload_2
    //   58: invokeinterface 285 1 0
    //   63: ifle +136 -> 199
    //   66: aload_2
    //   67: astore_0
    //   68: aload_2
    //   69: invokeinterface 289 1 0
    //   74: pop
    //   75: aload_2
    //   76: astore_0
    //   77: aload_2
    //   78: aload_2
    //   79: ldc_w 291
    //   82: invokeinterface 295 2 0
    //   87: invokeinterface 298 2 0
    //   92: astore_3
    //   93: aload_2
    //   94: astore_0
    //   95: aload_2
    //   96: aload_2
    //   97: ldc_w 300
    //   100: invokeinterface 295 2 0
    //   105: invokeinterface 304 2 0
    //   110: istore_1
    //   111: aload_2
    //   112: astore_0
    //   113: ldc 63
    //   115: iconst_1
    //   116: iconst_3
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: ldc_w 306
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: aload_3
    //   129: aastore
    //   130: dup
    //   131: iconst_2
    //   132: new 308	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 309	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 311
    //   142: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: iload_1
    //   146: invokevirtual 318	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: aastore
    //   153: invokestatic 327	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   156: aload_2
    //   157: astore_0
    //   158: aload_2
    //   159: invokeinterface 330 1 0
    //   164: iload_1
    //   165: iconst_1
    //   166: if_icmpeq +9 -> 175
    //   169: iload_1
    //   170: bipush 17
    //   172: if_icmpne +15 -> 187
    //   175: aload_2
    //   176: ifnull +9 -> 185
    //   179: aload_2
    //   180: invokeinterface 330 1 0
    //   185: iconst_0
    //   186: ireturn
    //   187: aload_2
    //   188: ifnull +9 -> 197
    //   191: aload_2
    //   192: invokeinterface 330 1 0
    //   197: iconst_1
    //   198: ireturn
    //   199: aload_2
    //   200: ifnull +9 -> 209
    //   203: aload_2
    //   204: invokeinterface 330 1 0
    //   209: iconst_1
    //   210: ireturn
    //   211: astore_3
    //   212: aconst_null
    //   213: astore_2
    //   214: aload_2
    //   215: astore_0
    //   216: ldc 63
    //   218: iconst_1
    //   219: ldc_w 332
    //   222: aload_3
    //   223: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_2
    //   227: ifnull -18 -> 209
    //   230: aload_2
    //   231: invokeinterface 330 1 0
    //   236: goto -27 -> 209
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_0
    //   242: aload_0
    //   243: ifnull +9 -> 252
    //   246: aload_0
    //   247: invokeinterface 330 1 0
    //   252: aload_2
    //   253: athrow
    //   254: astore_2
    //   255: goto -13 -> 242
    //   258: astore_3
    //   259: goto -45 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	paramContext	Context
    //   110	63	1	i	int
    //   50	181	2	localCursor	android.database.Cursor
    //   239	14	2	localObject1	Object
    //   254	1	2	localObject2	Object
    //   92	37	3	str	String
    //   211	12	3	localThrowable1	java.lang.Throwable
    //   258	1	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   22	51	211	java/lang/Throwable
    //   22	51	239	finally
    //   57	66	254	finally
    //   68	75	254	finally
    //   77	93	254	finally
    //   95	111	254	finally
    //   113	156	254	finally
    //   158	164	254	finally
    //   216	226	254	finally
    //   57	66	258	java/lang/Throwable
    //   68	75	258	java/lang/Throwable
    //   77	93	258	java/lang/Throwable
    //   95	111	258	java/lang/Throwable
    //   113	156	258	java/lang/Throwable
    //   158	164	258	java/lang/Throwable
  }
  
  public static boolean isIntentAvailable(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0;
  }
  
  @RequiresApi(api=25)
  public static boolean isShortcutCreated_O(String paramString, ShortcutManager paramShortcutManager)
  {
    if (paramShortcutManager == null) {
      return false;
    }
    paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
    do
    {
      if (!paramShortcutManager.hasNext()) {
        break;
      }
    } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getId()));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static void jumpToAppDetailSetting(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    if (Build.VERSION.SDK_INT >= 9)
    {
      localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", paramActivity.getPackageName(), null));
    }
    for (;;)
    {
      paramActivity.startActivity(localIntent);
      return;
      if (Build.VERSION.SDK_INT <= 8)
      {
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
        localIntent.putExtra("com.android.settings.ApplicationPkgName", paramActivity.getPackageName());
      }
    }
  }
  
  private static Intent obtainShortcutIntent(Activity paramActivity, ApkgInfo paramApkgInfo)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setClassName(paramActivity, JumpActivity.class.getName());
    localIntent.putExtra("CONFIG_APPID", paramApkgInfo.appId);
    localIntent.putExtra("CONFIG_APPNAME", paramApkgInfo.apkgName);
    localIntent.putExtra("CONFIG_APPICON", paramApkgInfo.iconUrl);
    localIntent.putExtra("CONFIG_REPORTTYPE", paramApkgInfo.appConfig.config.getReportType());
    localIntent.putExtra("CONFIG_ENGINETYPE", paramApkgInfo.appConfig.config.getEngineType());
    localIntent.putExtra("MINI_CONFIG_SCENE", 1023);
    localIntent.putExtra("MINI_CONFIG_DEV_DESC", paramApkgInfo.appConfig.config.developerDesc);
    localIntent.putExtra("CONFIG_VER_TYPE", paramApkgInfo.appConfig.config.verType);
    return localIntent;
  }
  
  private static void onCreateShortcutFailed(Activity paramActivity)
  {
    AppBrandTask.runTaskOnUiThread(new ShortcutUtils.4(paramActivity));
  }
  
  public static void openPermissionActivity(Activity paramActivity)
  {
    Object localObject = paramActivity.getPackageName();
    Intent localIntent;
    if (isIntentAvailable(paramActivity, "miui.intent.action.APP_PERM_EDITOR"))
    {
      localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
      localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      localIntent.putExtra("extra_pkgname", (String)localObject);
    }
    for (;;)
    {
      try
      {
        paramActivity.getBaseContext().startActivity(localIntent);
        i = 1;
        bool1 = true;
      }
      catch (Exception localException3)
      {
        QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException3);
        i = 1;
        bool1 = false;
        continue;
      }
      int j = i;
      boolean bool2 = bool1;
      if (!bool1)
      {
        j = i;
        bool2 = bool1;
        if (isIntentAvailable(paramActivity, "com.meizu.safe.security.SHOW_APPSEC"))
        {
          localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
          localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
          localIntent.putExtra("packageName", (String)localObject);
        }
      }
      try
      {
        paramActivity.getBaseContext().startActivity(localIntent);
        j = 2;
        bool2 = true;
      }
      catch (Exception localException4)
      {
        QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException4);
        j = 2;
        bool2 = false;
        continue;
      }
      int i = j;
      boolean bool1 = bool2;
      if (!bool2)
      {
        i = j;
        bool1 = bool2;
        if (isIntentAvailable(paramActivity, "huawei.intent.action.NOTIFICATIONMANAGER"))
        {
          localIntent = new Intent();
          localIntent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
          localIntent.addFlags(268435456);
        }
      }
      try
      {
        paramActivity.getBaseContext().startActivity(localIntent);
        bool1 = true;
      }
      catch (Exception localException5)
      {
        QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException5);
        bool1 = false;
        continue;
        i = 3;
        continue;
      }
      if (!bool1)
      {
        localIntent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
        try
        {
          paramActivity.getBaseContext().startActivity(localIntent);
          i = 3;
          bool1 = true;
        }
        catch (Exception localException6)
        {
          QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException6);
          i = 3;
          bool1 = false;
          continue;
        }
        bool2 = bool1;
        if (!bool1) {
          localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        }
        try
        {
          localIntent.setData(Uri.fromParts("package", (String)localObject, null));
          paramActivity.getBaseContext().startActivity(localIntent);
          i = 4;
          bool2 = true;
        }
        catch (Exception localException1)
        {
          QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException1);
          i = 4;
          bool2 = false;
          continue;
          bool1 = bool2;
          continue;
        }
        if ((!bool2) && (isIntentAvailable(paramActivity, "android.settings.action.MANAGE_OVERLAY_PERMISSION")))
        {
          localObject = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
          try
          {
            paramActivity.getBaseContext().startActivity((Intent)localObject);
            i = 5;
            bool1 = true;
          }
          catch (Exception localException2)
          {
            QLog.e("Shortcut", 1, "openPermissionActivity e = " + localException2);
            i = 5;
            bool1 = false;
            continue;
          }
          if (!bool1)
          {
            localObject = new Intent(paramActivity, QQBrowserActivity.class);
            ((Intent)localObject).putExtra("hide_left_button", false);
            ((Intent)localObject).putExtra("show_right_close_button", false);
            ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
            VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, "https://kf.qq.com/touch/sappfaq/190605Vn2EBv190605zuiEbY.html?scene_id=kf172&platform=15", 524288L, (Intent)localObject, false, -1);
            i = 6;
          }
          QLog.w("Shortcut", 1, "请求权限, which[" + i + "], openSuccess[" + bool1 + "]");
          return;
        }
      }
      i = 0;
      bool1 = false;
    }
  }
  
  public static abstract interface AddShortcutCallback
  {
    public abstract void onAddResult(int paramInt, String paramString);
  }
  
  static class PermissionDialog
    extends aqju
  {
    private static final String CONFIG_SHORTCUT_DIALOG_HIDE = "mini_shortcut_dialog_hide";
    private static final String CONFIG_SHORTCUT_HELP_URL = "mini_shortcut_help_url";
    private static final String URL_SHORTCUT_HELP = "https://kf.qq.com/touch/sappfaq/190605Vn2EBv190605zuiEbY.html?scene_id=kf172&platform=15";
    private Activity mActivity;
    private CheckBox mCheckBox;
    private ViewGroup mCheckBoxLayout;
    private TextView mCheckText;
    
    public PermissionDialog(Activity paramActivity, int paramInt)
    {
      super(paramInt);
      this.mActivity = paramActivity;
      initUI();
    }
    
    public static boolean canShowDialog()
    {
      boolean bool = StorageUtil.getPreference().getBoolean("mini_shortcut_dialog_hide", false);
      QLog.i("Shortcut", 1, "load dialog hide config:" + bool);
      return !bool;
    }
    
    public static PermissionDialog createPermissionDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
    {
      paramActivity = new PermissionDialog(paramActivity, 2131756467);
      paramActivity.setTitle(paramString1);
      paramActivity.setNegativeButton(paramString2, paramOnClickListener2);
      paramActivity.setPositiveButton(paramString3, paramOnClickListener1);
      paramActivity.setCanceledOnTouchOutside(false);
      return paramActivity;
    }
    
    public void dismiss()
    {
      boolean bool = this.mCheckBox.isChecked();
      QLog.i("Shortcut", 1, "save dialog hide config:" + bool);
      StorageUtil.getPreference().edit().putBoolean("mini_shortcut_dialog_hide", bool).commit();
      super.dismiss();
    }
    
    public CharSequence getMessageContent()
    {
      String str1 = acfp.m(2131714440);
      String str2 = acfp.m(2131714444);
      SpannableString localSpannableString = new SpannableString(str1 + str2);
      localSpannableString.setSpan(new ShortcutUtils.PermissionDialog.2(this), str1.length(), str1.length() + str2.length(), 33);
      localSpannableString.setSpan(new ForegroundColorSpan(-15505507), str1.length(), str1.length() + str2.length(), 33);
      return localSpannableString;
    }
    
    public void initUI()
    {
      setContentView(2131559142);
      this.text.setMovementMethod(LinkMovementMethod.getInstance());
      this.text.setText(getMessageContent());
      this.mCheckBoxLayout = ((ViewGroup)findViewById(2131370174));
      this.mCheckBox = ((CheckBox)findViewById(2131380103));
      this.mCheckText = ((TextView)findViewById(2131381068));
      this.mCheckText.setOnClickListener(new ShortcutUtils.PermissionDialog.1(this));
    }
    
    public void showCheckbox(boolean paramBoolean)
    {
      ViewGroup localViewGroup = this.mCheckBoxLayout;
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localViewGroup.setVisibility(i);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils
 * JD-Core Version:    0.7.0.1
 */