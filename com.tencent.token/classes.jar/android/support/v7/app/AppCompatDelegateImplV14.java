package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

@RequiresApi(14)
class AppCompatDelegateImplV14
  extends AppCompatDelegateImplV9
{
  private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
  private boolean mApplyDayNightCalled;
  private AppCompatDelegateImplV14.AutoNightModeManager mAutoNightModeManager;
  private boolean mHandleNativeActionModes = true;
  private int mLocalNightMode = -100;
  
  AppCompatDelegateImplV14(Context paramContext, Window paramWindow, AppCompatCallback paramAppCompatCallback)
  {
    super(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  private void ensureAutoNightModeManager()
  {
    if (this.mAutoNightModeManager == null) {
      this.mAutoNightModeManager = new AppCompatDelegateImplV14.AutoNightModeManager(this, TwilightManager.getInstance(this.mContext));
    }
  }
  
  private int getNightMode()
  {
    if (this.mLocalNightMode != -100) {
      return this.mLocalNightMode;
    }
    return getDefaultNightMode();
  }
  
  private boolean shouldRecreateOnNightModeChange()
  {
    if ((this.mApplyDayNightCalled) && ((this.mContext instanceof Activity)))
    {
      PackageManager localPackageManager = this.mContext.getPackageManager();
      try
      {
        int i = localPackageManager.getActivityInfo(new ComponentName(this.mContext, this.mContext.getClass()), 0).configChanges;
        return (i & 0x200) == 0;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
        return true;
      }
    }
    return false;
  }
  
  private boolean updateForNightMode(int paramInt)
  {
    Resources localResources = this.mContext.getResources();
    Configuration localConfiguration = localResources.getConfiguration();
    int i = localConfiguration.uiMode;
    if (paramInt == 2)
    {
      paramInt = 32;
      if ((i & 0x30) == paramInt) {
        break label117;
      }
      if (!shouldRecreateOnNightModeChange()) {
        break label61;
      }
      ((Activity)this.mContext).recreate();
    }
    for (;;)
    {
      return true;
      paramInt = 16;
      break;
      label61:
      localConfiguration = new Configuration(localConfiguration);
      DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
      localConfiguration.uiMode = (paramInt | localConfiguration.uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
      if (Build.VERSION.SDK_INT < 26) {
        ResourcesFlusher.flush(localResources);
      }
    }
    label117:
    return false;
  }
  
  public boolean applyDayNight()
  {
    boolean bool = false;
    int i = getNightMode();
    int j = mapNightMode(i);
    if (j != -1) {
      bool = updateForNightMode(j);
    }
    if (i == 0)
    {
      ensureAutoNightModeManager();
      this.mAutoNightModeManager.setup();
    }
    this.mApplyDayNightCalled = true;
    return bool;
  }
  
  View callActivityOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  @VisibleForTesting
  final AppCompatDelegateImplV14.AutoNightModeManager getAutoNightModeManager()
  {
    ensureAutoNightModeManager();
    return this.mAutoNightModeManager;
  }
  
  public boolean hasWindowFeature(int paramInt)
  {
    return (super.hasWindowFeature(paramInt)) || (this.mWindow.hasFeature(paramInt));
  }
  
  public boolean isHandleNativeActionModesEnabled()
  {
    return this.mHandleNativeActionModes;
  }
  
  int mapNightMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      ensureAutoNightModeManager();
      return this.mAutoNightModeManager.getApplyableNightMode();
    }
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (this.mLocalNightMode == -100)) {
      this.mLocalNightMode = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mAutoNightModeManager != null) {
      this.mAutoNightModeManager.cleanup();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.mLocalNightMode != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.mLocalNightMode);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    applyDayNight();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.mAutoNightModeManager != null) {
      this.mAutoNightModeManager.cleanup();
    }
  }
  
  public void setHandleNativeActionModesEnabled(boolean paramBoolean)
  {
    this.mHandleNativeActionModes = paramBoolean;
  }
  
  public void setLocalNightMode(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      Log.i("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
      do
      {
        return;
      } while (this.mLocalNightMode == paramInt);
      this.mLocalNightMode = paramInt;
    } while (!this.mApplyDayNightCalled);
    applyDayNight();
  }
  
  Window.Callback wrapWindowCallback(Window.Callback paramCallback)
  {
    return new AppCompatDelegateImplV14.AppCompatWindowCallbackV14(this, paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV14
 * JD-Core Version:    0.7.0.1
 */