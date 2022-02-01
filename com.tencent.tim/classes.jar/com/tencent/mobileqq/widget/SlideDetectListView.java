package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import argf;
import arjb;
import arjc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class SlideDetectListView
  extends XListView
  implements argf
{
  float BX = 0.0F;
  private ArrayList<Integer> Dp = new ArrayList();
  public View JF;
  protected GestureDetector.SimpleOnGestureListener a;
  private a a;
  public boolean aQV = false;
  public boolean dbA = false;
  public boolean dbB = true;
  public boolean dbC;
  protected boolean dbD;
  public int eij;
  protected int eik;
  protected int eil = -1;
  public int eim;
  public int mDownY = 0;
  protected GestureDetector mGestureDetector;
  public int mScrollState = 0;
  private AbsListView.e t;
  private AbsListView.e u;
  
  public SlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener = new arjb(this);
    super.setOnScrollListener(new arjc(this));
    this.eim = (ViewConfiguration.getTouchSlop() + 2);
  }
  
  public View T(int paramInt)
  {
    if (paramInt != -1) {
      try
      {
        View localView = getChildAt(paramInt - getFirstVisiblePosition());
        return localView;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.Dp.add(Integer.valueOf(paramView.hashCode()));
    super.addFooterView(paramView, paramObject, paramBoolean);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.Dp.add(Integer.valueOf(paramView.hashCode()));
    super.addHeaderView(paramView, paramObject, paramBoolean);
  }
  
  public void eiZ()
  {
    this.mDownY = 0;
    this.aQV = false;
    this.JF = null;
    this.dbD = false;
  }
  
  public void eja()
  {
    if (this.aQV == true)
    {
      if (this.JF != null)
      {
        this.JF.setPressed(false);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$a.b(this, this.JF, this.eij - getHeaderViewsCount());
        }
      }
      this.aQV = false;
      this.JF = null;
    }
  }
  
  public void ejb()
  {
    if (this.JF != null)
    {
      View localView = this.JF.findViewById(2131378161);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    eja();
  }
  
  public int kC(int paramInt)
  {
    int k = -1;
    int m = getChildCount();
    int i = k;
    View localView;
    if (m > 0)
    {
      if (!isStackFromBottom()) {
        j = 0;
      }
    }
    else {
      for (;;)
      {
        i = k;
        if (j < m)
        {
          localView = getChildAt(j);
          if (paramInt > localView.getBottom()) {
            break label94;
          }
          if (!this.Dp.contains(Integer.valueOf(localView.hashCode()))) {
            break label74;
          }
          i = k;
        }
        label74:
        do
        {
          return i;
          paramInt = getFirstVisiblePosition() + j;
          i = paramInt;
        } while (!isOverscrollHeadVisiable());
        return paramInt - 1;
        label94:
        j += 1;
      }
    }
    int j = m - 1;
    for (;;)
    {
      i = k;
      if (j < 0) {
        break;
      }
      localView = getChildAt(j);
      if (paramInt >= localView.getTop())
      {
        i = k;
        if (this.Dp.contains(Integer.valueOf(localView.hashCode()))) {
          break;
        }
        paramInt = getFirstVisiblePosition() + j;
        i = paramInt;
        if (!isOverscrollHeadVisiable()) {
          break;
        }
        return paramInt - 1;
      }
      j -= 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector == null)
    {
      this.mGestureDetector = new GestureDetector(getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$SimpleOnGestureListener, new Handler(Looper.getMainLooper()));
      this.mGestureDetector.setIsLongpressEnabled(false);
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        if (this.dbD == true)
        {
          label96:
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
              break label352;
            }
            i = this.JF.getTop() + this.JF.getHeight() / 2;
            int j = this.eil / 2;
            int k = this.eil / 2;
            if ((this.mDownY <= j + i) && (this.mDownY >= i - k)) {
              break label352;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SlideDetectListView", 2, "accurate in delete:ycenter:" + i + ",motionheight:" + this.JF.getHeight() + "deleareaHeight:" + this.eil);
            }
          }
        }
      }
    }
    label352:
    for (int i = 0; i != 0; i = 1)
    {
      this.dbD = true;
      return false;
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
        break label96;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.mDownY == 0) || (this.aQV == true))
    {
      setPressed(false);
      if (this.JF != null) {
        this.JF.setPressed(false);
      }
      return true;
      this.BX = paramMotionEvent.getY();
      if (this.aQV == true)
      {
        if (this.JF != null)
        {
          this.JF.setPressed(false);
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$a != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$a.b(this, this.JF, this.eij - getHeaderViewsCount());
          }
        }
        this.aQV = false;
        this.JF = null;
        return false;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean removeFooterView(View paramView)
  {
    this.Dp.remove(Integer.valueOf(paramView.hashCode()));
    return super.removeFooterView(paramView);
  }
  
  public boolean removeHeaderView(View paramView)
  {
    this.Dp.remove(Integer.valueOf(paramView.hashCode()));
    return super.removeHeaderView(paramView);
  }
  
  public void setCanSlide(boolean paramBoolean)
  {
    this.dbB = paramBoolean;
  }
  
  public void setCheckStateWhenSlide(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.dbC = paramBoolean;
      return;
    }
  }
  
  public void setDeleteAreaDim(int paramInt1, int paramInt2)
  {
    this.eik = paramInt1;
    this.eil = paramInt2;
  }
  
  public void setDeleteAreaWidth(int paramInt)
  {
    this.eik = paramInt;
  }
  
  public void setMotionView(View paramView, int paramInt)
  {
    this.JF = paramView;
    this.eij = (getHeaderViewsCount() + paramInt);
    if (this.JF != null) {
      this.aQV = true;
    }
  }
  
  public void setOnScrollGroupFloatingListener(AbsListView.e parame)
  {
    this.u = parame;
  }
  
  public void setOnScrollListener(AbsListView.e parame) {}
  
  public void setOnScrollToTopListener(AbsListView.e parame)
  {
    this.t = parame;
  }
  
  public void setOnSlideListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt);
    
    public abstract void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDetectListView
 * JD-Core Version:    0.7.0.1
 */