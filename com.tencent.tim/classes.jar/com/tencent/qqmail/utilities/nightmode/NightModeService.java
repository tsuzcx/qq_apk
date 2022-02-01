package com.tencent.qqmail.utilities.nightmode;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Nullable;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.NightView;

public class NightModeService
  extends Service
{
  private static final int HIDE_DELAY = 800;
  private static final int SHOW_DELAY = 1200;
  public static final String TAG = "NightModeService";
  private int colorTemp;
  private int darkness = 20;
  private boolean isDestroyCommand;
  private boolean justShowOneSecond;
  private NightColor nightColor;
  private int opacity = 100;
  private int orientation;
  private NightView view;
  
  private WindowManager getWindowManager()
  {
    return (WindowManager)getSystemService("window");
  }
  
  private void switchNightMode(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator;
    if (paramBoolean)
    {
      localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 100 });
      if (!paramBoolean) {
        break label129;
      }
      localValueAnimator.setDuration(1200L);
    }
    for (;;)
    {
      QMLog.log(4, "NightModeService", "switchNightMode showOrHide = " + paramBoolean + " getDuration = " + localValueAnimator.getDuration());
      localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      localValueAnimator.start();
      localValueAnimator.addUpdateListener(new NightModeService.1(this));
      localValueAnimator.addListener(new NightModeService.2(this, paramBoolean));
      return;
      localValueAnimator = ValueAnimator.ofInt(new int[] { 100, 0 });
      break;
      label129:
      localValueAnimator.setDuration(800L);
    }
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation != this.orientation)
    {
      this.orientation = paramConfiguration.orientation;
      paramConfiguration = getWindowManager();
      if (this.view.isAttached()) {
        this.view.detach(paramConfiguration).attach(paramConfiguration);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.view = new NightView(this);
    this.orientation = getResources().getConfiguration().orientation;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QMLog.log(4, "NightModeService", "onDestroy");
    switchNightMode(false);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent = SafeIntent.createSafeIntet(paramIntent);
    if (paramIntent != null)
    {
      this.colorTemp = paramIntent.getIntExtra("KEY_COLOR_TEMP", 4550);
      this.justShowOneSecond = paramIntent.getBooleanExtra("JUST_SHOW_A_SECOND", false);
      this.isDestroyCommand = paramIntent.getBooleanExtra("DESTROY", false);
      if (!this.isDestroyCommand) {
        break label57;
      }
      stopSelf();
    }
    label57:
    do
    {
      return 2;
      this.nightColor = new NightColor();
      this.nightColor.setDarkness(this.darkness).setColorTemp(this.colorTemp);
      this.view.setColor(this.opacity, this.nightColor.getRed(), this.nightColor.getGreen(), this.nightColor.getBlue());
      if (this.justShowOneSecond)
      {
        this.view.setColor(this.opacity, this.nightColor.getRed(), this.nightColor.getGreen(), this.nightColor.getBlue());
        this.view.attach(getWindowManager());
        return 2;
      }
    } while (this.view.isAttached());
    this.view.setColor(0, this.nightColor.getRed(), this.nightColor.getGreen(), this.nightColor.getBlue());
    this.view.attach(getWindowManager());
    switchNightMode(true);
    return 2;
  }
  
  public class DefaultKeyValue
  {
    public static final int DEFAULT_COLOR_TEMP = 4550;
    public static final int DEFAULT_COLOR_TEMP_FACTOR = 65;
    public static final int DEFAULT_DARKNESS = 20;
    public static final int DEFAULT_OPACITY = 100;
    
    public DefaultKeyValue() {}
  }
  
  public class Key
  {
    public static final String COLOR_TEMP = "KEY_COLOR_TEMP";
    public static final String DESTROY = "DESTROY";
    public static final String JUST_SHOW_A_SECOND = "JUST_SHOW_A_SECOND";
    
    public Key() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.nightmode.NightModeService
 * JD-Core Version:    0.7.0.1
 */