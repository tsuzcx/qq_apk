import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class msx
{
  private ContentObserver brightnessObserver = new msy(this, new Handler());
  private boolean hasRegisterBrightnessObserver;
  private Activity mActivity;
  private boolean mHasSetCustomBrightness;
  
  public msx(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private void registerBrightObserver()
  {
    if (!this.hasRegisterBrightnessObserver)
    {
      this.hasRegisterBrightnessObserver = true;
      this.mActivity.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this.brightnessObserver);
    }
  }
  
  private void unregisterBrightObserver()
  {
    if (this.hasRegisterBrightnessObserver)
    {
      this.hasRegisterBrightnessObserver = false;
      this.mActivity.getContentResolver().unregisterContentObserver(this.brightnessObserver);
    }
  }
  
  public void doOnDestory()
  {
    unregisterBrightObserver();
  }
  
  public boolean isAutoBrightness()
  {
    ContentResolver localContentResolver = this.mActivity.getContentResolver();
    try
    {
      int i = Settings.System.getInt(localContentResolver, "screen_brightness_mode");
      return i == 1;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      localSettingNotFoundException.printStackTrace();
    }
    return false;
  }
  
  public int pJ()
  {
    ContentResolver localContentResolver = this.mActivity.getContentResolver();
    try
    {
      int i = Settings.System.getInt(localContentResolver, "screen_brightness");
      return i;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException) {}
    return 0;
  }
  
  public void recoveryScreenBrightness()
  {
    if (this.mHasSetCustomBrightness)
    {
      this.mHasSetCustomBrightness = false;
      WindowManager.LayoutParams localLayoutParams = this.mActivity.getWindow().getAttributes();
      localLayoutParams.screenBrightness = -1.0F;
      this.mActivity.getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void setScreenBrightness(float paramFloat)
  {
    registerBrightObserver();
    this.mHasSetCustomBrightness = true;
    WindowManager.LayoutParams localLayoutParams = this.mActivity.getWindow().getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    this.mActivity.getWindow().setAttributes(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msx
 * JD-Core Version:    0.7.0.1
 */