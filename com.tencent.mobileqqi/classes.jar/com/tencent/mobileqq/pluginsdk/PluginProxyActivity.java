package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarImplJB;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Toast;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"NewApi"})
public abstract class PluginProxyActivity
  extends ActionBarActivity
{
  public static final String ACTION_PLUGIN_DIR_INFO_LOG = "com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG";
  public static final String ACTION_PLUGIN_STARTUP_FAILED = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED";
  private static final String INNER_BUNDLE = "pluginsdk_inner_bundle";
  private static final String INNER_INTENT_EXTRAS = "pluginsdk_inner_intent_extras";
  public static final String READER_ID = "qqreaderplugin.apk";
  private static final String TAG = "PluginProxyActivity";
  public static boolean mAppForground;
  public static boolean mGestureLockEnable = false;
  private static String mUin;
  private static Field sMMapField = null;
  private static Method sUnparcelMethod;
  private boolean mCanLock = true;
  private Class<?> mClassLaunchActivity = null;
  protected String mCreateErrorInfo = null;
  private FlingHandler mFlingHandler;
  protected boolean mIsShowQQBackgroundIcon = true;
  private String mLaunchActivity = null;
  private IPluginActivity mPluginActivity = null;
  private String mPluginApkFilePath = null;
  private boolean mPluginGestureLock = false;
  private String mPluginID = null;
  private String mPluginName = null;
  private BroadcastReceiver mScreenOffReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((PluginProxyActivity.mGestureLockEnable) && (PluginProxyActivity.this.mStopFlag == 0) && (PluginProxyActivity.this.getGestureLock(PluginProxyActivity.this, PluginProxyActivity.mUin))) {
        PluginProxyActivity.this.startUnlockActivity();
      }
    }
  };
  protected int mStopFlag = 0;
  private String mUinString = null;
  private int mUseQqResources;
  private boolean mUseSkinEngine = false;
  
  static
  {
    mAppForground = true;
    mUin = "";
    sUnparcelMethod = null;
  }
  
  private void forceShowOverflowMenu()
  {
    try
    {
      ViewConfiguration localViewConfiguration = ViewConfiguration.get(this);
      Field localField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
      if (localField != null)
      {
        localField.setAccessible(true);
        localField.setBoolean(localViewConfiguration, false);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean getAppForground(Context paramContext)
  {
    boolean bool = true;
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getAppForground", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof Boolean)) {
        bool = ((Boolean)paramContext).booleanValue();
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  private String getCurrentUinForPlugin(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getUinForPlugin", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof String))
      {
        paramContext = (String)paramContext;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private boolean getEnableGestureLock(Context paramContext)
  {
    boolean bool = false;
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("enableGestureLock", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof Boolean)) {
        bool = ((Boolean)paramContext).booleanValue();
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private boolean handleStartPluginFailed(Throwable paramThrowable)
  {
    if (((paramThrowable instanceof FileNotFoundException)) || ((paramThrowable.getMessage() != null) && (paramThrowable.getMessage().contains("permission"))))
    {
      QLog.d("PluginDebug", 1, "" + this.mPluginApkFilePath);
      paramThrowable = getApplicationInfo();
      boolean bool1;
      if (paramThrowable != null)
      {
        if ((paramThrowable.flags & 0x1) <= 0) {
          break label152;
        }
        bool1 = true;
        if ((paramThrowable.flags & 0x80) <= 0) {
          break label157;
        }
      }
      label152:
      label157:
      for (boolean bool2 = true;; bool2 = false)
      {
        QLog.d("PluginDebug", 1, "UID: " + paramThrowable.uid + ", IsSystemApp: " + bool1 + ", IsUpdateSystemApp: " + bool2);
        sendBroadcast(new Intent("com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG"));
        showNeedUninstanllAndInstallDialog();
        return true;
        bool1 = false;
        break;
      }
    }
    if ((paramThrowable instanceof Resources.NotFoundException))
    {
      showNeedUninstanllAndInstallDialog();
      return true;
    }
    if (((paramThrowable instanceof ClassNotFoundException)) || ((paramThrowable instanceof PluginUtils.GetPackageInfoFailException)))
    {
      QLog.d("PluginDebug", 1, "" + this.mPluginApkFilePath);
      PluginRecoverReceiver.broadcast(this, this.mPluginID);
      return false;
    }
    return shouldHandleStartPluginFailed(this.mCreateErrorInfo);
  }
  
  private void initActionBar()
  {
    try
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar != null)
      {
        localActionBar.setHomeButtonEnabled(true);
        localActionBar.setDisplayHomeAsUpEnabled(true);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @SuppressLint({"NewApi"})
  private void initPlugin()
    throws Exception
  {
    boolean bool1 = true;
    Object localObject2 = (PackageInfo)PluginStatic.sPackageInfoMap.get(this.mPluginApkFilePath);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start getPackageInfo");
      }
      localObject1 = ApkFileParser.getPackageInfo(this, this.mPluginApkFilePath, 1);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin end getPackageInfo");
      }
      if (localObject1 == null) {
        throw new PluginUtils.GetPackageInfoFailException("Get Package Info Failed!");
      }
      PluginStatic.sPackageInfoMap.put(this.mPluginApkFilePath, localObject1);
    }
    if ((this.mLaunchActivity == null) || (this.mLaunchActivity.length() == 0))
    {
      if ((((PackageInfo)localObject1).activities == null) || (((PackageInfo)localObject1).activities.length == 0)) {
        throw new PluginUtils.PluginActivityNotFoundException();
      }
      this.mLaunchActivity = localObject1.activities[0].name;
    }
    localObject2 = PluginStatic.getOrCreateClassLoaderByPath(this, this.mPluginID, this.mPluginApkFilePath);
    getIntent().setExtrasClassLoader((ClassLoader)localObject2);
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
    }
    this.mClassLaunchActivity = ((ClassLoader)localObject2).loadClass(this.mLaunchActivity);
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
    }
    this.mPluginActivity = ((IPluginActivity)this.mClassLaunchActivity.newInstance());
    IPluginActivity localIPluginActivity = this.mPluginActivity;
    String str1 = this.mPluginID;
    String str2 = this.mPluginApkFilePath;
    boolean bool2 = this.mUseSkinEngine;
    if (this.mUseQqResources == 1) {}
    for (;;)
    {
      localIPluginActivity.IInit(str1, str2, this, (ClassLoader)localObject2, (PackageInfo)localObject1, bool2, bool1);
      localObject1 = new Intent(getIntent());
      localObject2 = ((Intent)localObject1).getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        ((Intent)localObject1).removeExtra("pluginsdk_inner_intent_extras");
      }
      this.mPluginActivity.ISetIntent((Intent)localObject1);
      return;
      bool1 = false;
    }
  }
  
  private boolean isAppOnForeground()
  {
    boolean bool = false;
    try
    {
      Object localObject = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      localObject = ((Class)localObject).getMethod("isAppOnForeground", new Class[] { Context.class }).invoke(localObject, new Object[] { this });
      if ((localObject instanceof Boolean)) {
        bool = ((Boolean)localObject).booleanValue();
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  private boolean isStartQQ3rdApp(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT")));
        paramIntent = paramIntent.getComponent();
        if (paramIntent == null) {
          break;
        }
        str = paramIntent.getPackageName();
      } while ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone")));
      paramIntent = paramIntent.getClassName();
    } while ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")));
    return false;
  }
  
  public static void openActivityForResult(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchActivity", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramActivity.startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  private void sendLaunchCompletedBroadcast()
  {
    Intent localIntent = new Intent("action_launch_completed");
    localIntent.putExtra("plugin_apk", this.mPluginID);
    sendBroadcast(localIntent);
  }
  
  private void setAppForground(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext.getMethod("setAppForground", new Class[] { Context.class, Boolean.TYPE }).invoke(paramContext, new Object[] { this, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void setClassLoaderToEveryBundle(Bundle paramBundle, ClassLoader paramClassLoader)
    throws Exception
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      paramBundle.setClassLoader(paramClassLoader);
      Object localObject;
      if ((sUnparcelMethod == null) || (sMMapField == null))
      {
        localObject = paramBundle.getClass();
        sUnparcelMethod = ((Class)localObject).getDeclaredMethod("unparcel", new Class[0]);
        sUnparcelMethod.setAccessible(true);
        sMMapField = ((Class)localObject).getDeclaredField("mMap");
        sMMapField.setAccessible(true);
      }
      sUnparcelMethod.invoke(paramBundle, new Object[0]);
      paramBundle = (Map)sMMapField.get(paramBundle);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.values().iterator();
        while (paramBundle.hasNext())
        {
          localObject = paramBundle.next();
          if ((localObject instanceof Bundle)) {
            setClassLoaderToEveryBundle((Bundle)localObject, paramClassLoader);
          }
        }
      }
    }
  }
  
  private void setCurrentUinForPlugin(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext.getMethod("setUinForPlugin", new Class[] { Context.class, String.class }).invoke(paramContext, new Object[] { this, paramString });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void showLaunchPluginFail()
  {
    if (this.mCreateErrorInfo != null)
    {
      if ((this.mCreateErrorInfo.contains("空间")) || (this.mCreateErrorInfo.contains("Space"))) {
        Toast.makeText(this, "系统可用内存不足，" + this.mPluginName + "启动失败!", 0).show();
      }
    }
    else {
      return;
    }
    Toast.makeText(this, this.mPluginName + "启动失败!", 0).show();
  }
  
  private void startPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, getProxyActivity(paramString));
    localIntent.putExtra("pluginsdk_pluginName", this.mPluginName);
    localIntent.putExtra("pluginsdk_pluginLocation", this.mPluginID);
    localIntent.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
    localIntent.putExtra("pluginsdk_launchActivity", paramString);
    localIntent.putExtra("useSkinEngine", this.mUseSkinEngine);
    if ((this.mUseQqResources == 1) || (this.mUseQqResources == -1)) {
      localIntent.putExtra("userQqResources", this.mUseQqResources);
    }
    if (paramIntent != null)
    {
      localIntent.addFlags(paramIntent.getFlags());
      localIntent.putExtra("pluginsdk_inner_intent_extras", new Bundle(paramIntent.getExtras()));
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void uploadStartupFailure(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("clsUploader");
    localObject = ((Intent)localObject).getStringExtra("pluginsdk_selfuin");
    if (str != null)
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
      localIntent.putExtra("pluginsdk_selfuin", (String)localObject);
      localIntent.putExtra("pluginsdk_pluginName", paramString1);
      localIntent.putExtra("pluginsdk_pluginLocation", paramString2);
      localIntent.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
      localIntent.putExtra("pluginsdk_launchActivity", paramString3);
      localIntent.putExtra("pluginsdk_extraInfo", paramString4);
      localIntent.putExtra("clsUploader", str);
      sendBroadcast(localIntent);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IDispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean getGestureLock(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getJumpLock", new Class[] { Context.class, String.class }).invoke(paramContext, new Object[] { this, mUin });
      if ((paramContext instanceof Boolean)) {
        bool = ((Boolean)paramContext).booleanValue();
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  @Deprecated
  public String getPluginID()
  {
    return null;
  }
  
  protected Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return getClass();
  }
  
  protected boolean isWrapContent()
  {
    boolean bool = true;
    if (this.mPluginActivity != null) {
      bool = this.mPluginActivity.IIsWrapContent();
    }
    DebugHelper.debug("PluginProxyActivity.isWrapContent: " + bool + ", from = " + this.mPluginActivity);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.mPluginActivity != null) {}
    try
    {
      ClassLoader localClassLoader = PluginStatic.getClassLoader(this.mPluginID);
      if ((localClassLoader != null) && (paramIntent != null)) {
        paramIntent.setExtrasClassLoader(localClassLoader);
      }
      this.mPluginActivity.IOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
    this.mCanLock = false;
  }
  
  public void onBackPressed()
  {
    boolean bool = false;
    if (this.mPluginActivity != null) {
      bool = this.mPluginActivity.IOnBackPressed();
    }
    if (!bool) {}
    try
    {
      super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate");
    }
    IPluginProxyComponent.registerAccountReceiverIfNeccessary();
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate.registerAccountReceiverIfNeccessary");
    }
    Object localObject1 = null;
    Object localObject2;
    if (paramBundle != null)
    {
      localObject2 = paramBundle;
      localObject1 = ((Bundle)localObject2).getBundle("pluginsdk_inner_bundle");
    }
    while (!PluginStatic.isValidPluginIntent((Bundle)localObject2))
    {
      super.onCreate(paramBundle);
      finish();
      return;
      localObject2 = getIntent().getExtras();
    }
    this.mPluginName = ((Bundle)localObject2).getString("pluginsdk_pluginName");
    this.mPluginID = ((Bundle)localObject2).getString("pluginsdk_pluginLocation");
    this.mLaunchActivity = ((Bundle)localObject2).getString("pluginsdk_launchActivity");
    this.mUseSkinEngine = ((Bundle)localObject2).getBoolean("useSkinEngine", false);
    this.mUseQqResources = ((Bundle)localObject2).getInt("userQqResources", 0);
    this.mPluginApkFilePath = ((Bundle)localObject2).getString("pluginsdk_pluginpath");
    PluginRecoverReceiver.addCarePluginId(this.mPluginID);
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate.fetchParams");
    }
    if (TextUtils.isEmpty(this.mPluginApkFilePath)) {}
    try
    {
      this.mPluginApkFilePath = PluginUtils.getInstallPath(this, this.mPluginID).getCanonicalPath();
      this.mUinString = ((Bundle)localObject2).getString("pluginsdk_selfuin");
      if (!TextUtils.isEmpty(this.mUinString))
      {
        mUin = this.mUinString;
        setCurrentUinForPlugin(this, this.mUinString);
        this.mPluginGestureLock = ((Bundle)localObject2).getBoolean("param_plugin_gesturelock", false);
        if ((this.mPluginGestureLock) || (getEnableGestureLock(this))) {
          mGestureLockEnable = true;
        }
        if (DebugHelper.sDebug) {
          DebugHelper.log("PluginProxyActivity onCreate start registerReceiver");
        }
        localObject2 = new IntentFilter();
        ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
      }
    }
    catch (Exception localException2)
    {
      try
      {
        for (;;)
        {
          registerReceiver(this.mScreenOffReceiver, (IntentFilter)localObject2);
          localObject2 = null;
          j = 0;
          i = 0;
          if (DebugHelper.sDebug) {
            DebugHelper.log("PluginDebug", "PluginProxyActivity.onCreate Params:" + this.mPluginID + ", " + this.mLaunchActivity);
          }
          if ((this.mPluginID != null) && (this.mPluginID.length() != 0)) {
            break;
          }
          localObject1 = new IllegalArgumentException("Param mPluingLocation missing!");
          j = i;
          if (j == 0) {
            super.onCreate(paramBundle);
          }
          if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity onCreate start sendLaunchCompletedBroadcast");
          }
          sendLaunchCompletedBroadcast();
          if (localObject1 == null) {
            break label736;
          }
          this.mCreateErrorInfo = PluginUtils.getExceptionInfo((Throwable)localObject1);
          uploadStartupFailure(this.mPluginName, this.mPluginID, this.mLaunchActivity, this.mCreateErrorInfo);
          if (DebugHelper.sDebug) {
            DebugHelper.log("PluginProxyActivity.onCreate startPlugin:" + this.mPluginName + ", " + this.mCreateErrorInfo);
          }
          if (!handleStartPluginFailed((Throwable)localObject1))
          {
            showLaunchPluginFail();
            finish();
          }
          initActionBar();
          forceShowOverflowMenu();
          return;
          localException2 = localException2;
        }
        mUin = getCurrentUinForPlugin(this);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          int j;
          int i;
          if (DebugHelper.sDebug)
          {
            DebugHelper.log("PluginDebug", "register exception.", localException1);
            continue;
            i = j;
            try
            {
              if (DebugHelper.sDebug)
              {
                i = j;
                DebugHelper.log("PluginProxyActivity onCreate start initPlugin");
              }
              i = j;
              initPlugin();
              i = j;
              if (DebugHelper.sDebug)
              {
                i = j;
                DebugHelper.log("PluginProxyActivity onCreate end initPlugin");
              }
              i = j;
              this.mPluginActivity.IOnSetTheme();
              i = j;
              super.onCreate(paramBundle);
              int m = 1;
              int k = 1;
              i = m;
              if (DebugHelper.sDebug)
              {
                i = m;
                DebugHelper.log("PluginProxyActivity onCreate start IOnCreate");
              }
              if (localObject1 != null)
              {
                i = m;
                ((Bundle)localObject1).setClassLoader(PluginStatic.getClassLoader(this.mPluginID));
              }
              i = m;
              this.mPluginActivity.IOnCreate((Bundle)localObject1);
              j = k;
              localObject1 = localException1;
              i = m;
              if (!DebugHelper.sDebug) {
                continue;
              }
              i = m;
              DebugHelper.log("PluginProxyActivity onCreate end IOnCreate");
              j = k;
              localObject1 = localException1;
            }
            catch (Throwable localThrowable)
            {
              this.mPluginActivity = null;
              localThrowable.printStackTrace();
              localObject1 = localThrowable;
              PluginRuntime.handleCrash(localThrowable, this.mPluginID, this);
              j = i;
            }
            continue;
            label736:
            if (DebugHelper.sDebug) {
              DebugHelper.log("PluginProxyActivity.onCreate Success");
            }
            paramBundle = getIntent().getExtras();
            if (paramBundle != null)
            {
              i = paramBundle.getInt("fling_action_key");
              if (DebugHelper.sDebug) {
                DebugHelper.log("PluginProxyActivity.onCreate FLING_ACTION_KEY: " + i + ", from: " + paramBundle);
              }
              if ((i != 0) && (isWrapContent())) {
                if (1 == i) {
                  this.mFlingHandler = new FlingTrackerHandler(this);
                } else {
                  this.mFlingHandler = new FlingGestureHandler(this);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnCreateOptionsMenu(paramMenu);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mPluginActivity != null) {}
    try
    {
      this.mPluginActivity.IOnDestroy();
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity onDestroy");
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          unregisterReceiver(this.mScreenOffReceiver);
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    bool2 = true;
    if (paramInt == 82) {}
    try
    {
      ActionBar localActionBar = getSupportActionBar();
      if (localActionBar == null) {
        return true;
      }
      Object localObject = null;
      if ((localActionBar instanceof ActionBarImplJB)) {
        localObject = localActionBar.getClass().getSuperclass().getDeclaredField("mActionBar");
      }
      for (;;)
      {
        if (localObject != null)
        {
          ((Field)localObject).setAccessible(true);
          localObject = ((Field)localObject).get(localActionBar);
          if (localObject == null) {
            break;
          }
        }
        boolean bool1 = false;
        if (this.mPluginActivity != null) {
          bool1 = this.mPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
        }
        bool2 = bool1;
        if (bool1) {
          break;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
        if (localActionBar.getClass().getName().equals("android.support.v7.app.ActionBarImplICS")) {
          localObject = localActionBar.getClass().getDeclaredField("mActionBar");
        }
      }
      return bool2;
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Object localObject = PluginStatic.getClassLoader(this.mPluginID);
    if (localObject != null) {
      paramIntent.setExtrasClassLoader((ClassLoader)localObject);
    }
    if ((this.mPluginActivity != null) && (paramIntent.getBooleanExtra("cleartop", false)))
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setExtrasClassLoader((ClassLoader)localObject);
      localObject = paramIntent.getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject != null)
      {
        paramIntent.putExtras((Bundle)localObject);
        paramIntent.removeExtra("pluginsdk_inner_intent_extras");
      }
      this.mPluginActivity.IOnNewIntent(paramIntent);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnOptionsItemSelected(paramMenuItem);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnPause();
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.onPause");
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnPrepareOptionsMenu(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    ClassLoader localClassLoader = PluginStatic.getClassLoader(this.mPluginID);
    if (localClassLoader != null) {}
    try
    {
      setClassLoaderToEveryBundle(paramBundle, localClassLoader);
      label17:
      super.onRestoreInstanceState(paramBundle);
      if (this.mPluginActivity != null)
      {
        Bundle localBundle = paramBundle.getBundle("pluginsdk_inner_bundle");
        paramBundle = localBundle;
        if (localBundle == null) {
          paramBundle = new Bundle();
        }
        paramBundle.setClassLoader(localClassLoader);
        this.mPluginActivity.IOnRestoreInstanceState(paramBundle);
      }
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnResume();
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.onResume");
    }
    if (mGestureLockEnable)
    {
      mAppForground = getAppForground(this);
      if ((!mAppForground) && (!TextUtils.isEmpty(mUin)) && (getGestureLock(this, mUin)) && (this.mCanLock)) {
        startUnlockActivity();
      }
      if (!mAppForground)
      {
        mAppForground = true;
        setAppForground(this, mAppForground);
      }
      this.mStopFlag = 0;
      this.mCanLock = true;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.mPluginActivity != null)
    {
      Bundle localBundle2 = paramBundle.getBundle("pluginsdk_inner_bundle");
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null)
      {
        localBundle1 = new Bundle();
        paramBundle.putBundle("pluginsdk_inner_bundle", localBundle1);
      }
      this.mPluginActivity.IOnSaveInstanceState(localBundle1);
    }
    paramBundle.putString("pluginsdk_pluginName", this.mPluginName);
    paramBundle.putString("pluginsdk_pluginLocation", this.mPluginID);
    paramBundle.putString("pluginsdk_pluginpath", this.mPluginApkFilePath);
    paramBundle.putString("pluginsdk_launchActivity", this.mLaunchActivity);
    paramBundle.putBoolean("useSkinEngine", this.mUseSkinEngine);
    paramBundle.putInt("userQqResources", this.mUseQqResources);
    paramBundle.putString("pluginsdk_selfuin", this.mUinString);
    paramBundle.putBoolean("param_plugin_gesturelock", this.mPluginGestureLock);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStart();
    }
    if (this.mIsShowQQBackgroundIcon)
    {
      Intent localIntent = new Intent("tencent.notify.foreground");
      localIntent.putExtra("selfuin", "");
      sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    }
    if ((isWrapContent()) && (this.mFlingHandler != null)) {
      this.mFlingHandler.onStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStop();
    }
    mAppForground = isAppOnForeground();
    if (mGestureLockEnable)
    {
      if (!mAppForground) {
        setAppForground(this, mAppForground);
      }
      this.mStopFlag = 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mPluginActivity != null) {
      return this.mPluginActivity.IOnTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onUserInteraction()
  {
    if (this.mPluginActivity != null)
    {
      this.mPluginActivity.IOnUserInteraction();
      return;
    }
    super.onUserInteraction();
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    if (this.mIsShowQQBackgroundIcon)
    {
      Intent localIntent = new Intent("tencent.notify.background");
      localIntent.putExtra("selfuin", "");
      localIntent.putExtra("classname", getClass().getName());
      sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnWindowFocusChanged(paramBoolean);
    }
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    return false;
  }
  
  protected void showNeedUninstanllAndInstallDialog()
  {
    Object localObject = new AlertDialog.Builder(this);
    ((AlertDialog.Builder)localObject).setTitle("温馨提示");
    ((AlertDialog.Builder)localObject).setMessage("启动" + this.mPluginName + "失败，请卸载重装~");
    ((AlertDialog.Builder)localObject).setPositiveButton("我知道了", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        PluginProxyActivity.this.finish();
      }
    });
    localObject = ((AlertDialog.Builder)localObject).create();
    try
    {
      ((Dialog)localObject).show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (paramIntent.getBooleanExtra("pluginsdk_IsPluginActivity", false))
    {
      String str = null;
      ComponentName localComponentName = paramIntent.getComponent();
      if (localComponentName != null) {
        str = localComponentName.getClassName();
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", false);
      if ((str != null) && (str.length() > 0)) {
        startPluginActivityForResult(this, str, paramIntent, paramInt);
      }
    }
    for (;;)
    {
      this.mStopFlag = 2;
      return;
      startActivityForResult(paramIntent, paramInt, 2);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.mStopFlag = 2;
    if (isStartQQ3rdApp(paramIntent)) {
      this.mCanLock = false;
    }
    if (!isMoveTaskToBack(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    switch (paramInt2)
    {
    default: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 0: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 1: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    }
    startActivityForResultWithGesture(paramIntent, paramInt1);
  }
  
  public void startActivityForResultWithGesture(Intent paramIntent, int paramInt)
  {
    startActivityForResultWithGesture(paramIntent, paramInt, hashCode());
  }
  
  public void startActivityForResultWithGesture(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", paramInt2);
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  public void startActivityForResultWithSnap(Intent paramIntent, int paramInt)
  {
    startActivityForResultWithSnap(paramIntent, paramInt, hashCode());
  }
  
  public void startActivityForResultWithSnap(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.startActivityForResultWithSnap:" + paramInt2);
    }
    String str = ScreenCapture.getSnapPath(this, paramInt2);
    if (str != null)
    {
      ScreenCapture.captureViewToFile(str, getWindow().getDecorView());
      paramIntent.putExtra("fling_action_key", 1);
      paramIntent.putExtra("fling_code_key", paramInt2);
    }
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  protected void startUnlockActivity()
  {
    try
    {
      startActivity(new Intent(this, Class.forName("com.tencent.mobileqq.activity.GesturePWDUnlockActivity")));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */