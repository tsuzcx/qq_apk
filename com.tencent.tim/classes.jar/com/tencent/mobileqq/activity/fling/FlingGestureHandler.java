package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class FlingGestureHandler
  extends FlingHandler
  implements TopGestureLayout.OnGestureListener
{
  private View mInnerView;
  public TopGestureLayout mTopLayout;
  
  public FlingGestureHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private ViewGroup a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    paramActivity = localViewGroup;
    if (localView != null)
    {
      paramActivity = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        paramActivity = (ViewGroup)localView;
      }
    }
    return paramActivity;
  }
  
  protected boolean Vj()
  {
    return (this.mTopLayout != null) && (this.mTopLayout.getParent() != null) && (this.mInnerView != null) && (this.mInnerView.getParent() == this.mTopLayout);
  }
  
  protected void coC()
  {
    if (!MI()) {}
    ViewGroup localViewGroup;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (Activity)this.eD.get();
        } while (localObject == null);
        localViewGroup = a((Activity)localObject);
        if (this.mTopLayout != null) {
          break;
        }
        this.mInnerView = localViewGroup.getChildAt(0);
      } while (this.mInnerView == null);
      View localView = this.mInnerView;
      this.mTopLayout = new TopGestureLayout((Context)localObject);
      Object localObject = this.mTopLayout;
      ((TopGestureLayout)localObject).setOnFlingGesture(this);
      localViewGroup.addView((View)localObject);
      ((ViewGroup)localView.getParent()).removeView(localView);
      ((TopGestureLayout)localObject).addView(localView);
      return;
    } while (Vj());
    if ((this.mTopLayout != null) && (this.mTopLayout.getParent() != null)) {
      ((ViewGroup)this.mTopLayout.getParent()).removeView(this.mTopLayout);
    }
    localViewGroup.addView(this.mTopLayout);
    if ((this.mInnerView != null) && (this.mInnerView.getParent() != null)) {
      ((ViewGroup)this.mInnerView.getParent()).removeView(this.mInnerView);
    }
    try
    {
      this.mTopLayout.addView(this.mInnerView);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FlingGestureHandler", 1, localException, new Object[0]);
    }
  }
  
  protected void coD()
  {
    Object localObject = (Activity)this.eD.get();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = a((Activity)localObject);
      } while ((!Vj()) || (!this.mTopLayout.getParent().equals(localObject)));
      ((ViewGroup)localObject).removeView(this.mTopLayout);
    } while (!this.mInnerView.getParent().equals(this.mTopLayout));
    this.mTopLayout.removeView(this.mInnerView);
    ((ViewGroup)localObject).addView(this.mInnerView);
  }
  
  public void flingLToR()
  {
    Activity localActivity = (Activity)this.eD.get();
    if (localActivity != null) {
      localActivity.onBackPressed();
    }
  }
  
  public void flingRToL() {}
  
  public void setTopLayout(TopGestureLayout paramTopGestureLayout)
  {
    if ((!MI()) && (paramTopGestureLayout == null)) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.eD.get();
    } while (localActivity == null);
    if (Vj())
    {
      coD();
      this.mInnerView = a(localActivity).getChildAt(0);
      this.mTopLayout = paramTopGestureLayout;
      paramTopGestureLayout.setOnFlingGesture(this);
      coC();
      return;
    }
    this.mInnerView = a(localActivity).getChildAt(0);
    this.mTopLayout = paramTopGestureLayout;
    paramTopGestureLayout.setOnFlingGesture(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingGestureHandler
 * JD-Core Version:    0.7.0.1
 */