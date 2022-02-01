package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;

public abstract class FlingHandler
{
  WeakReference<Activity> eD;
  
  public FlingHandler(Activity paramActivity)
  {
    this.eD = new WeakReference(paramActivity);
  }
  
  protected boolean MI()
  {
    return yd() != 0;
  }
  
  protected abstract boolean Vj();
  
  protected abstract void coC();
  
  protected abstract void coD();
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onStart()
  {
    coC();
  }
  
  public void onStop()
  {
    coD();
  }
  
  protected int yd()
  {
    Activity localActivity = (Activity)this.eD.get();
    if (localActivity != null) {
      return localActivity.getIntent().getIntExtra("fling_code_key", 0);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingHandler
 * JD-Core Version:    0.7.0.1
 */