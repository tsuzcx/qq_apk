package com.tencent.mobileqq.activity.richmedia;

import aaqk;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;

public abstract class FlowActivity
  extends PeakActivity
{
  protected boolean bwM = true;
  protected int cik;
  protected ViewGroup dN;
  
  protected abstract void K(ViewGroup paramViewGroup);
  
  protected aaqk a()
  {
    return null;
  }
  
  public View bJ()
  {
    return this.dN;
  }
  
  public void finish()
  {
    super.finish();
    if (this.bwM)
    {
      overridePendingTransition(0, 2130772013);
      return;
    }
    overridePendingTransition(0, 0);
  }
  
  protected void initData(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.cik = paramBundle.getInt("flow_camera_height", (int)getResources().getDimension(2131297331));
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(256);
    getWindow().addFlags(512);
    paramBundle = getIntent().getExtras();
    if (paramBundle == null) {
      this.cik = ((int)getResources().getDimension(2131297331));
    }
    initData(paramBundle);
    setContentView(2131558488);
    this.dN = ((ViewGroup)$(2131367346));
    if (this.dN != null) {
      K(this.dN);
    }
    paramBundle = a();
    if (paramBundle != null) {
      paramBundle.L((ViewGroup)$(2131367326));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      return super.onTouchEvent(paramMotionEvent);
    }
    View localView = bJ();
    if (localView == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = localView.getTop();
    if (paramMotionEvent.getY() < i) {
      onBackPressed();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowActivity
 * JD-Core Version:    0.7.0.1
 */