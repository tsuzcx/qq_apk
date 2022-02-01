package com.tencent.qqmini.minigame.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class GameActivityStatusWatcher
{
  static final String TAG = "GameActivityStatusWatcher";
  private Context mContext;
  private IntentFilter mFilter;
  private OnWatcherActionListener mListener;
  private InnerRecevier mRecevier;
  
  public GameActivityStatusWatcher(Context paramContext)
  {
    this.mContext = paramContext;
    this.mFilter = new IntentFilter();
    this.mFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.mFilter.addAction("action.qq.miniapp.show.monitorview");
    this.mFilter.addAction("android.intent.action.SCREEN_OFF");
  }
  
  public void setOnHomePressedListener(OnWatcherActionListener paramOnWatcherActionListener)
  {
    this.mListener = paramOnWatcherActionListener;
    this.mRecevier = new InnerRecevier();
  }
  
  public void startWatch()
  {
    if (this.mRecevier != null) {
      this.mContext.registerReceiver(this.mRecevier, this.mFilter);
    }
  }
  
  public void stopWatch()
  {
    if (this.mRecevier != null) {
      this.mContext.unregisterReceiver(this.mRecevier);
    }
  }
  
  class InnerRecevier
    extends BroadcastReceiver
  {
    final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
    final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    final String SYSTEM_DIALOG_REASON_KEY = "reason";
    final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
    
    InnerRecevier() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {}
      for (;;)
      {
        return;
        paramContext = paramIntent.getAction();
        if ("action.qq.miniapp.show.monitorview".equals(paramContext))
        {
          boolean bool = paramIntent.getBooleanExtra("show", true);
          GameActivityStatusWatcher.this.mListener.onShowMonitorView(bool);
        }
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext))
        {
          paramIntent = paramIntent.getStringExtra("reason");
          if ((paramIntent != null) && (GameActivityStatusWatcher.this.mListener != null))
          {
            if (!paramIntent.equals("homekey")) {
              break label113;
            }
            GameActivityStatusWatcher.this.mListener.onHomePressed();
          }
        }
        while ("android.intent.action.SCREEN_OFF".equals(paramContext))
        {
          GameActivityStatusWatcher.this.mListener.onScreenOff();
          return;
          label113:
          if (paramIntent.equals("recentapps")) {
            GameActivityStatusWatcher.this.mListener.onRecentTaskPressed();
          }
        }
      }
    }
  }
  
  public static abstract interface OnWatcherActionListener
  {
    public abstract void onHomePressed();
    
    public abstract void onRecentTaskPressed();
    
    public abstract void onScreenOff();
    
    public abstract void onShowMonitorView(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher
 * JD-Core Version:    0.7.0.1
 */