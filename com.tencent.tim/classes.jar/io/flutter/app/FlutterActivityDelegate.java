package io.flutter.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.util.Preconditions;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterRunArguments;
import io.flutter.view.FlutterView;
import io.flutter.view.FlutterView.Provider;
import java.util.ArrayList;

public final class FlutterActivityDelegate
  implements FlutterActivityEvents, PluginRegistry, FlutterView.Provider
{
  private static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.app.android.SplashScreenUntilFirstFrame";
  private static final String TAG = "FlutterActivityDelegate";
  private static final WindowManager.LayoutParams matchParent = new WindowManager.LayoutParams(-1, -1);
  private final Activity activity;
  private FlutterView flutterView;
  private View launchView;
  private final ViewFactory viewFactory;
  
  public FlutterActivityDelegate(Activity paramActivity, ViewFactory paramViewFactory)
  {
    this.activity = ((Activity)Preconditions.checkNotNull(paramActivity));
    this.viewFactory = ((ViewFactory)Preconditions.checkNotNull(paramViewFactory));
  }
  
  private void addLaunchView()
  {
    if (this.launchView == null) {
      return;
    }
    this.activity.addContentView(this.launchView, matchParent);
    this.flutterView.addFirstFrameListener(new FlutterActivityDelegate.1(this));
    this.activity.setTheme(16973833);
  }
  
  private View createLaunchView()
  {
    if (!showSplashScreenUntilFirstFrame().booleanValue()) {}
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = getLaunchScreenDrawableFromActivityTheme();
    } while (localDrawable == null);
    View localView = new View(this.activity);
    localView.setLayoutParams(matchParent);
    localView.setBackground(localDrawable);
    return localView;
  }
  
  private static String[] getArgsFromIntent(Intent paramIntent)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.getBooleanExtra("trace-startup", false)) {
      localArrayList.add("--trace-startup");
    }
    if (paramIntent.getBooleanExtra("start-paused", false)) {
      localArrayList.add("--start-paused");
    }
    if (paramIntent.getBooleanExtra("disable-service-auth-codes", false)) {
      localArrayList.add("--disable-service-auth-codes");
    }
    if (paramIntent.getBooleanExtra("use-test-fonts", false)) {
      localArrayList.add("--use-test-fonts");
    }
    if (paramIntent.getBooleanExtra("enable-dart-profiling", false)) {
      localArrayList.add("--enable-dart-profiling");
    }
    if (paramIntent.getBooleanExtra("enable-software-rendering", false)) {
      localArrayList.add("--enable-software-rendering");
    }
    if (paramIntent.getBooleanExtra("skia-deterministic-rendering", false)) {
      localArrayList.add("--skia-deterministic-rendering");
    }
    if (paramIntent.getBooleanExtra("trace-skia", false)) {
      localArrayList.add("--trace-skia");
    }
    if (paramIntent.getBooleanExtra("trace-systrace", false)) {
      localArrayList.add("--trace-systrace");
    }
    if (paramIntent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
      localArrayList.add("--dump-skp-on-shader-compilation");
    }
    if (paramIntent.getBooleanExtra("verbose-logging", false)) {
      localArrayList.add("--verbose-logging");
    }
    int i = paramIntent.getIntExtra("observatory-port", 0);
    StringBuilder localStringBuilder;
    if (i > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--observatory-port=");
      localStringBuilder.append(Integer.toString(i));
      localArrayList.add(localStringBuilder.toString());
    }
    if (paramIntent.getBooleanExtra("disable-service-auth-codes", false)) {
      localArrayList.add("--disable-service-auth-codes");
    }
    if (paramIntent.hasExtra("dart-flags"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--dart-flags=");
      localStringBuilder.append(paramIntent.getStringExtra("dart-flags"));
      localArrayList.add(localStringBuilder.toString());
    }
    if (!localArrayList.isEmpty()) {
      return (String[])localArrayList.toArray(new String[localArrayList.size()]);
    }
    return null;
  }
  
  private Drawable getLaunchScreenDrawableFromActivityTheme()
  {
    Object localObject = new TypedValue();
    if (!this.activity.getTheme().resolveAttribute(16842836, (TypedValue)localObject, true)) {}
    while (((TypedValue)localObject).resourceId == 0) {
      return null;
    }
    try
    {
      localObject = this.activity.getResources().getDrawable(((TypedValue)localObject).resourceId);
      return localObject;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.e("FlutterActivityDelegate", "Referenced launch screen windowBackground resource does not exist");
    }
    return null;
  }
  
  private boolean isDebuggable()
  {
    return (this.activity.getApplicationInfo().flags & 0x2) != 0;
  }
  
  private boolean loadIntent(Intent paramIntent)
  {
    if ("android.intent.action.RUN".equals(paramIntent.getAction()))
    {
      String str2 = paramIntent.getStringExtra("route");
      String str1 = paramIntent.getDataString();
      paramIntent = str1;
      if (str1 == null) {
        paramIntent = FlutterMain.findAppBundlePath();
      }
      if (str2 != null) {
        this.flutterView.setInitialRoute(str2);
      }
      runBundle(paramIntent);
      return true;
    }
    return false;
  }
  
  private void runBundle(String paramString)
  {
    if (!this.flutterView.getFlutterNativeView().isApplicationRunning())
    {
      FlutterRunArguments localFlutterRunArguments = new FlutterRunArguments();
      localFlutterRunArguments.bundlePath = paramString;
      localFlutterRunArguments.entrypoint = "main";
      this.flutterView.runFromBundle(localFlutterRunArguments);
    }
  }
  
  private Boolean showSplashScreenUntilFirstFrame()
  {
    boolean bool2 = false;
    try
    {
      Bundle localBundle = this.activity.getPackageManager().getActivityInfo(this.activity.getComponentName(), 129).metaData;
      boolean bool1 = bool2;
      if (localBundle != null)
      {
        boolean bool3 = localBundle.getBoolean("io.flutter.app.android.SplashScreenUntilFirstFrame");
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return Boolean.valueOf(bool1);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return Boolean.valueOf(false);
  }
  
  public FlutterView getFlutterView()
  {
    return this.flutterView;
  }
  
  public boolean hasPlugin(String paramString)
  {
    return this.flutterView.getPluginRegistry().hasPlugin(paramString);
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return this.flutterView.getPluginRegistry().onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPressed()
  {
    if (this.flutterView != null)
    {
      this.flutterView.popRoute();
      return true;
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = this.activity.getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(1073741824);
      paramBundle.getDecorView().setSystemUiVisibility(1280);
    }
    paramBundle = getArgsFromIntent(this.activity.getIntent());
    FlutterMain.ensureInitializationComplete(this.activity.getApplicationContext(), paramBundle);
    this.flutterView = this.viewFactory.createFlutterView(this.activity);
    if (this.flutterView == null)
    {
      paramBundle = this.viewFactory.createFlutterNativeView();
      this.flutterView = new FlutterView(this.activity, null, paramBundle);
      this.flutterView.setLayoutParams(matchParent);
      this.activity.setContentView(this.flutterView);
      this.launchView = createLaunchView();
      if (this.launchView != null) {
        addLaunchView();
      }
    }
    if (loadIntent(this.activity.getIntent())) {}
    do
    {
      return;
      paramBundle = FlutterMain.findAppBundlePath();
    } while (paramBundle == null);
    runBundle(paramBundle);
  }
  
  public void onDestroy()
  {
    Object localObject = (Application)this.activity.getApplicationContext();
    if ((localObject instanceof FlutterApplication))
    {
      localObject = (FlutterApplication)localObject;
      if (this.activity.equals(((FlutterApplication)localObject).getCurrentActivity())) {
        ((FlutterApplication)localObject).setCurrentActivity(null);
      }
    }
    if (this.flutterView != null)
    {
      if ((this.flutterView.getPluginRegistry().onViewDestroy(this.flutterView.getFlutterNativeView())) || (this.viewFactory.retainFlutterNativeView())) {
        this.flutterView.detach();
      }
    }
    else {
      return;
    }
    this.flutterView.destroy();
  }
  
  public void onLowMemory()
  {
    this.flutterView.onMemoryPressure();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if ((!isDebuggable()) || (!loadIntent(paramIntent))) {
      this.flutterView.getPluginRegistry().onNewIntent(paramIntent);
    }
  }
  
  public void onPause()
  {
    Object localObject = (Application)this.activity.getApplicationContext();
    if ((localObject instanceof FlutterApplication))
    {
      localObject = (FlutterApplication)localObject;
      if (this.activity.equals(((FlutterApplication)localObject).getCurrentActivity())) {
        ((FlutterApplication)localObject).setCurrentActivity(null);
      }
    }
    if (this.flutterView != null) {
      this.flutterView.onPause();
    }
  }
  
  public void onPostResume()
  {
    if (this.flutterView != null) {
      this.flutterView.onPostResume();
    }
  }
  
  public boolean onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    return this.flutterView.getPluginRegistry().onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    Application localApplication = (Application)this.activity.getApplicationContext();
    if ((localApplication instanceof FlutterApplication)) {
      ((FlutterApplication)localApplication).setCurrentActivity(this.activity);
    }
  }
  
  public void onStart()
  {
    if (this.flutterView != null) {
      this.flutterView.onStart();
    }
  }
  
  public void onStop()
  {
    this.flutterView.onStop();
  }
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt == 10) {
      this.flutterView.onMemoryPressure();
    }
  }
  
  public void onUserLeaveHint()
  {
    this.flutterView.getPluginRegistry().onUserLeaveHint();
  }
  
  public PluginRegistry.Registrar registrarFor(String paramString)
  {
    return this.flutterView.getPluginRegistry().registrarFor(paramString);
  }
  
  public <T> T valuePublishedByPlugin(String paramString)
  {
    return this.flutterView.getPluginRegistry().valuePublishedByPlugin(paramString);
  }
  
  public static abstract interface ViewFactory
  {
    public abstract FlutterNativeView createFlutterNativeView();
    
    public abstract FlutterView createFlutterView(Context paramContext);
    
    public abstract boolean retainFlutterNativeView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.app.FlutterActivityDelegate
 * JD-Core Version:    0.7.0.1
 */