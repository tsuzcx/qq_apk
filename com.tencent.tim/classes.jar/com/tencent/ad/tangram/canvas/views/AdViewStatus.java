package com.tencent.ad.tangram.canvas.views;

import android.support.annotation.Keep;
import android.view.View;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

@Keep
public class AdViewStatus
{
  public static final int CREATED = 0;
  public static final int DESTROYED = 3;
  public static final int PAUSED = 2;
  public static final int RESUMED = 1;
  private WeakReference<Listener> listener;
  private float percentageResume = 0.0F;
  private int statusForActivity;
  private WeakReference<View> view;
  private boolean visible;
  
  public AdViewStatus(WeakReference<View> paramWeakReference, WeakReference<Listener> paramWeakReference1)
  {
    this(paramWeakReference, paramWeakReference1, 0.0F);
  }
  
  public AdViewStatus(WeakReference<View> paramWeakReference, WeakReference<Listener> paramWeakReference1, float paramFloat)
  {
    this.view = paramWeakReference;
    this.listener = paramWeakReference1;
    this.percentageResume = paramFloat;
    this.statusForActivity = 0;
    this.visible = false;
  }
  
  private void notifyStatusChanged(boolean paramBoolean)
  {
    if ((this.listener.get() == null) || (paramBoolean == this.visible)) {
      return;
    }
    if (this.visible)
    {
      ((Listener)this.listener.get()).onViewResume();
      return;
    }
    ((Listener)this.listener.get()).onViewPause();
  }
  
  public void onActivityDestroy()
  {
    this.statusForActivity = 3;
    onLocationChanged();
  }
  
  public void onActivityPaused()
  {
    this.statusForActivity = 2;
    onLocationChanged();
  }
  
  public void onActivityResumed()
  {
    this.statusForActivity = 1;
    if (this.view.get() == null) {
      return;
    }
    ((View)this.view.get()).postDelayed(new AdViewStatus.1(this), 500L);
  }
  
  public void onLocationChanged()
  {
    boolean bool2 = this.visible;
    if (this.statusForActivity == 0) {
      this.visible = false;
    }
    for (;;)
    {
      notifyStatusChanged(bool2);
      return;
      if (this.statusForActivity == 3)
      {
        this.visible = false;
      }
      else if (this.statusForActivity == 1)
      {
        if (this.view.get() != null)
        {
          if (AdUIUtils.getPercentageOfGlobalVisibleRect((View)this.view.get()) > this.percentageResume) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            this.visible = bool1;
            break;
          }
        }
        this.visible = false;
      }
      else if (this.statusForActivity == 2)
      {
        this.visible = false;
      }
    }
  }
  
  @Keep
  public static abstract interface Listener
  {
    public abstract void onViewPause();
    
    public abstract void onViewResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.AdViewStatus
 * JD-Core Version:    0.7.0.1
 */