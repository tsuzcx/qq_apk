package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;

public class GameVideoPlayerManager
{
  private static final String TAG = "GameVideoPlayerManager";
  private static volatile GameVideoPlayerManager instance;
  private WeakReference<Activity> activityRef;
  private WeakReference<ViewGroup> parentRef;
  
  public static GameVideoPlayerManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new GameVideoPlayerManager();
      }
      return instance;
    }
    finally {}
  }
  
  public void addPlayerView(ViewGroup paramViewGroup)
  {
    if (this.parentRef != null) {}
    for (ViewGroup localViewGroup = (ViewGroup)this.parentRef.get(); localViewGroup == null; localViewGroup = null)
    {
      QMLog.e("GameVideoPlayerManager", "addPlayerView error: parent == null");
      return;
    }
    localViewGroup.addView(paramViewGroup);
  }
  
  public void init(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.activityRef = new WeakReference(paramActivity);
    this.parentRef = new WeakReference(paramViewGroup);
  }
  
  public void removeView(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)this.parentRef.get();
    if (localViewGroup == null)
    {
      QMLog.e("GameVideoPlayerManager", "removePlayerView error: parent == null");
      return;
    }
    localViewGroup.removeView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameVideoPlayerManager
 * JD-Core Version:    0.7.0.1
 */