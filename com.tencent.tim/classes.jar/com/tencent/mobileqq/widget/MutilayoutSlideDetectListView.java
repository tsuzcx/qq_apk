package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class MutilayoutSlideDetectListView
  extends SlideDetectListView
{
  public MutilayoutSlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private View l(View paramView)
  {
    if ((paramView instanceof ShaderAnimLayout)) {
      return paramView;
    }
    if ((paramView instanceof RelativeLayout))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          View localView = l(paramView.getChildAt(i));
          if ((localView instanceof ShaderAnimLayout)) {
            return localView;
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector == null)
    {
      this.mGestureDetector = new GestureDetector(getContext(), this.a, new Handler(Looper.getMainLooper()));
      this.mGestureDetector.setIsLongpressEnabled(false);
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    label88:
    int i;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      for (;;)
      {
        if (this.dbD == true)
        {
          return false;
          this.mDownY = ((int)paramMotionEvent.getY());
          this.dbD = false;
          i = kC(this.mDownY);
          if ((this.JF != null) && (T(i) == this.JF))
          {
            if (paramMotionEvent.getX() < this.JF.getWidth() - this.eik) {
              continue;
            }
            if ((this.eil <= 0) || (this.JF.getHeight() <= 0)) {
              break label372;
            }
            View localView1 = l(this.JF);
            if (localView1 != null)
            {
              View localView2 = (View)localView1.getParent();
              i = v(localView1);
              i = localView2.getHeight() / 2 + i;
              int j = this.eil / 2;
              int k = this.eil / 2;
              if ((this.mDownY <= j + i) && (this.mDownY >= i - k)) {
                break label372;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SlideDetectListView", 2, "accurate in delete:ycenter:" + i + ",motionheight:" + this.JF.getHeight() + "deleareaHeight:" + this.eil);
              }
              i = 0;
            }
          }
        }
      }
    }
    while (i != 0)
    {
      this.dbD = true;
      return false;
      i = 0;
      continue;
      if (this.aQV != true) {
        break;
      }
      return true;
      this.dbA = false;
      break;
      if ((this.mDownY == 0) || (this.aQV == true)) {
        return true;
      }
      if (this.dbA) {
        break label88;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      label372:
      i = 1;
    }
  }
  
  public int v(View paramView)
  {
    paramView = (View)paramView.getParent();
    int i = paramView.getTop();
    while (paramView != this.JF)
    {
      paramView = (View)paramView.getParent();
      i += paramView.getTop();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MutilayoutSlideDetectListView
 * JD-Core Version:    0.7.0.1
 */