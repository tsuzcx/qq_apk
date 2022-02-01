package com.tencent.mobileqq.activity.recent;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.AbsListView.LayoutParams;

public class BannerFrameLayout
  extends FrameLayout
{
  private BaseActivity a;
  private boolean bvA = true;
  
  public BannerFrameLayout(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
    this.a = paramBaseActivity;
    initLayout();
  }
  
  public void initLayout()
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(2131296485)));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.bvA) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setAnimEnd(boolean paramBoolean)
  {
    this.bvA = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.BannerFrameLayout
 * JD-Core Version:    0.7.0.1
 */