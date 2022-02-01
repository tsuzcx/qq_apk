package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

public class GestureSelectGridView
  extends GridView
{
  int Ft = -1;
  int Fu = -1;
  final int Fw = 20000000;
  AtomicBoolean X = new AtomicBoolean(false);
  AtomicBoolean Y = new AtomicBoolean(false);
  AbsListView.e jdField_a_of_type_ComTencentWidgetAbsListView$e;
  b jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b;
  AtomicBoolean aa = new AtomicBoolean(true);
  boolean mIsScrolling = false;
  float mLastMotionX;
  float mLastMotionY;
  int mTouchSlop;
  boolean qe = true;
  
  public GestureSelectGridView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GestureSelectGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mTouchSlop = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 15);
    super.setOnScrollListener(new a());
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.aa.get()) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i;
    do
    {
      return bool1;
      i = paramMotionEvent.getAction();
      if (i != 2) {
        break;
      }
      bool1 = bool2;
    } while (this.X.get());
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i & 0xFF)
    {
    }
    do
    {
      for (;;)
      {
        bool1 = bool2;
        if (this.X.get()) {
          break;
        }
        return super.onInterceptTouchEvent(paramMotionEvent);
        float f3 = Math.abs(f1 - this.mLastMotionX);
        if ((f3 > Math.abs(f2 - this.mLastMotionY) * 1.73F) && (f3 > this.mTouchSlop))
        {
          this.X.set(true);
          this.mLastMotionX = f1;
          this.mLastMotionY = f2;
          continue;
          this.mLastMotionX = f1;
          this.mLastMotionY = f2;
          i = pointToPosition((int)f1, (int)f2);
          if (i != -1)
          {
            this.Fu = i;
            this.Ft = i;
          }
        }
      }
      bool1 = this.X.get();
      this.X.set(false);
      this.Ft = -1;
      this.Fu = -1;
      this.Y.set(false);
    } while (!bool1);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.aa.get()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i & 0xFF)
    {
    default: 
      if (this.X.get()) {
        return true;
      }
      break;
    case 2: 
      if (!this.X.get())
      {
        float f3 = Math.abs(f1 - this.mLastMotionX);
        if ((f3 > Math.abs(f2 - this.mLastMotionY) * 1.73F) && (f3 > this.mTouchSlop))
        {
          this.X.set(true);
          this.mLastMotionX = f1;
          this.mLastMotionY = f2;
        }
      }
      if ((this.X.get()) && (!this.mIsScrolling)) {
        if ((f2 < 0.0F) || (f2 > getHeight()))
        {
          this.mIsScrolling = true;
          if (f2 >= 0.0F) {
            break label334;
          }
          i = -20000000;
          this.qe = false;
        }
      }
      break;
    }
    for (;;)
    {
      label201:
      smoothScrollBy(i, 1000000);
      while (this.X.get())
      {
        if ((!this.Y.get()) && (this.Ft != -1))
        {
          if (this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b != null) {
            this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b.onSelectBegin(this.Ft);
          }
          this.Y.set(true);
        }
        i = pointToPosition((int)f1, (int)f2);
        if (i == -1) {
          break;
        }
        if (this.Y.get()) {
          break label401;
        }
        this.Fu = i;
        this.Ft = i;
        if (this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b != null) {
          this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b.onSelectBegin(this.Ft);
        }
        this.Y.set(true);
        break;
        label334:
        if (f2 <= getHeight()) {
          break label548;
        }
        i = 20000000;
        this.qe = true;
        break label201;
        if ((this.X.get()) && (this.mIsScrolling) && (f2 > 0.0F) && (f2 < getHeight()))
        {
          abordFling();
          this.mIsScrolling = false;
        }
      }
      label401:
      if (this.Fu == i) {
        break;
      }
      this.Fu = i;
      if ((this.mIsScrolling) || (this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b.onSelectChanged(this.Ft, this.Fu);
      break;
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      break;
      if (this.mIsScrolling)
      {
        abordFling();
        this.mIsScrolling = false;
      }
      boolean bool = this.X.get();
      this.Ft = -1;
      this.Fu = -1;
      this.X.set(false);
      this.Y.set(false);
      if ((bool) && (this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b != null)) {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b.onSelectEnd();
      }
      if (!bool) {
        break;
      }
      return true;
      return super.onTouchEvent(paramMotionEvent);
      label548:
      i = 0;
    }
  }
  
  public void setOnIndexChangedListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b = paramb;
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$e = parame;
  }
  
  public void setSelectMode(boolean paramBoolean)
  {
    this.aa.set(paramBoolean);
  }
  
  public void setTouchSlopRate(int paramInt)
  {
    this.mTouchSlop = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * paramInt);
  }
  
  class a
    implements AbsListView.e
  {
    a() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (GestureSelectGridView.this.mIsScrolling)
      {
        int i = paramInt1 + paramInt2;
        if ((!GestureSelectGridView.this.qe) || (Math.abs(i - GestureSelectGridView.this.Fu) < 3) || (Math.abs(i - GestureSelectGridView.this.Fu) > 5)) {
          break label161;
        }
        if (GestureSelectGridView.this.Fu + 3 <= paramInt3 - 1) {
          break label140;
        }
        GestureSelectGridView.this.Fu = (paramInt3 - 1);
        GestureSelectGridView.this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b.onSelectChanged(GestureSelectGridView.this.Ft, GestureSelectGridView.this.Fu);
      }
      label140:
      GestureSelectGridView localGestureSelectGridView;
      label161:
      while ((GestureSelectGridView.this.qe) || (Math.abs(paramInt1 - GestureSelectGridView.this.Fu) < 3) || (Math.abs(paramInt1 - GestureSelectGridView.this.Fu) > 5)) {
        for (;;)
        {
          if (GestureSelectGridView.this.jdField_a_of_type_ComTencentWidgetAbsListView$e != null) {
            GestureSelectGridView.this.jdField_a_of_type_ComTencentWidgetAbsListView$e.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
          }
          return;
          localGestureSelectGridView = GestureSelectGridView.this;
          localGestureSelectGridView.Fu += 3;
        }
      }
      if (GestureSelectGridView.this.Fu - 3 < 0) {}
      for (GestureSelectGridView.this.Fu = 0;; localGestureSelectGridView.Fu -= 3)
      {
        GestureSelectGridView.this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView$b.onSelectChanged(GestureSelectGridView.this.Ft, GestureSelectGridView.this.Fu);
        break;
        localGestureSelectGridView = GestureSelectGridView.this;
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if (GestureSelectGridView.this.jdField_a_of_type_ComTencentWidgetAbsListView$e != null) {
        GestureSelectGridView.this.jdField_a_of_type_ComTencentWidgetAbsListView$e.onScrollStateChanged(paramAbsListView, paramInt);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onSelectBegin(int paramInt);
    
    public abstract void onSelectChanged(int paramInt1, int paramInt2);
    
    public abstract void onSelectEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.GestureSelectGridView
 * JD-Core Version:    0.7.0.1
 */