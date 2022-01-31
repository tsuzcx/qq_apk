package android.support.v7.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

@VisibleForTesting
final class AppCompatDelegateImplV14$AutoNightModeManager
{
  private BroadcastReceiver mAutoTimeChangeReceiver;
  private IntentFilter mAutoTimeChangeReceiverFilter;
  private boolean mIsNight;
  private TwilightManager mTwilightManager;
  
  AppCompatDelegateImplV14$AutoNightModeManager(AppCompatDelegateImplV14 paramAppCompatDelegateImplV14, @NonNull TwilightManager paramTwilightManager)
  {
    this.mTwilightManager = paramTwilightManager;
    this.mIsNight = paramTwilightManager.isNight();
  }
  
  final void cleanup()
  {
    if (this.mAutoTimeChangeReceiver != null)
    {
      this.this$0.mContext.unregisterReceiver(this.mAutoTimeChangeReceiver);
      this.mAutoTimeChangeReceiver = null;
    }
  }
  
  final void dispatchTimeChanged()
  {
    boolean bool = this.mTwilightManager.isNight();
    if (bool != this.mIsNight)
    {
      this.mIsNight = bool;
      this.this$0.applyDayNight();
    }
  }
  
  final int getApplyableNightMode()
  {
    this.mIsNight = this.mTwilightManager.isNight();
    if (this.mIsNight) {
      return 2;
    }
    return 1;
  }
  
  final void setup()
  {
    cleanup();
    if (this.mAutoTimeChangeReceiver == null) {
      this.mAutoTimeChangeReceiver = new AppCompatDelegateImplV14.AutoNightModeManager.1(this);
    }
    if (this.mAutoTimeChangeReceiverFilter == null)
    {
      this.mAutoTimeChangeReceiverFilter = new IntentFilter();
      this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_SET");
      this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
      this.mAutoTimeChangeReceiverFilter.addAction("android.intent.action.TIME_TICK");
    }
    this.this$0.mContext.registerReceiver(this.mAutoTimeChangeReceiver, this.mAutoTimeChangeReceiverFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDelegateImplV14.AutoNightModeManager
 * JD-Core Version:    0.7.0.1
 */