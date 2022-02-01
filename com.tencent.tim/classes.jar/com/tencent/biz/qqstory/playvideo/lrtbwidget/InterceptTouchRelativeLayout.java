package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import java.util.List;
import qix;
import ram;

public class InterceptTouchRelativeLayout
  extends RelativeLayout
{
  IgnoreTouchXViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager;
  a jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInterceptTouchRelativeLayout$a;
  private qix jdField_a_of_type_Qix;
  boolean aDB = false;
  boolean aDC = false;
  private qix b;
  private int bmv;
  
  public InterceptTouchRelativeLayout(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public InterceptTouchRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InterceptTouchRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInterceptTouchRelativeLayout$a = new a(paramContext, "Fake_Pager");
    this.jdField_a_of_type_Qix = new qix(new ThreeDTransformer(true, true));
    this.b = new qix(new VerticalTransformer());
  }
  
  public static MotionEvent a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    paramMotionEvent.setLocation(paramMotionEvent.getY() / paramFloat2 * paramFloat1, paramMotionEvent.getX() / paramFloat1 * paramFloat2);
    return paramMotionEvent;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    int j = getWidth();
    int k = getHeight();
    int i;
    int m;
    try
    {
      i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInterceptTouchRelativeLayout$a.b(paramMotionEvent);
      m = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.getScrollState();
      if (m != 0) {}
      switch (this.bmv)
      {
      default: 
        localObject = (StoryPlayerGroupAdapter)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.getAdapter();
        if (localObject != null) {
          break label184;
        }
        bool1 = super.dispatchTouchEvent(paramMotionEvent);
        return bool1;
      }
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      return false;
    }
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setSource(0);
    a(paramMotionEvent, j, k);
    boolean bool1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.E(paramMotionEvent);
    paramMotionEvent.recycle();
    ram.b("Q.qqstory.playernew.InterceptTouch", "delivering directly DELIVERING_AS_VERTICAL, scrollState = %d, handled = %s", Integer.valueOf(m), Boolean.valueOf(bool1));
    return true;
    ram.b("Q.qqstory.playernew.InterceptTouch", "delivering directly DELIVERING_AS_HORIZONTAL, scrollState = %d, handled = %s", Integer.valueOf(m), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.E(paramMotionEvent)));
    return true;
    label184:
    Object localObject = ((StoryPlayerGroupAdapter)localObject).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.getCurrentItem());
    this.aDB = false;
    this.aDC = false;
    if (localObject != null)
    {
      if (((StoryPlayerGroupHolder)localObject).bmz == ((StoryPlayerGroupHolder)localObject).nR.size() - 1)
      {
        bool1 = true;
        label236:
        this.aDB = bool1;
        if (((StoryPlayerGroupHolder)localObject).bmz != 0) {
          break label521;
        }
        bool1 = true;
        label253:
        this.aDC = bool1;
      }
    }
    else
    {
      Log.v("Q.qqstory.playernew.InterceptTouch", "moveDirection = " + i);
      if (((i != 2) && (i != 4)) || ((this.bmv != 0) && (this.bmv != 2) && (this.bmv != 4))) {
        break label546;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.getCurrentItem();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.getAdapter().getCount();
      if ((i != 2) && (i != 4)) {
        break label534;
      }
      if (this.bmv == 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.setPageTransformer(true, this.b);
        localObject = MotionEvent.obtain(a.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInterceptTouchRelativeLayout$a));
        ((MotionEvent)localObject).setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
        ((MotionEvent)localObject).setSource(0);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.E(a((MotionEvent)localObject, j, k));
        ((MotionEvent)localObject).recycle();
      }
      if (i != 2) {
        break label527;
      }
      localObject = "UP";
      label428:
      ram.b("Q.qqstory.playernew.InterceptTouch", "Move direction = %s, Event = %s", localObject, paramMotionEvent);
      this.bmv = i;
      localObject = MotionEvent.obtain(paramMotionEvent);
      ((MotionEvent)localObject).setSource(0);
      bool1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.E(a((MotionEvent)localObject, j, k));
      ((MotionEvent)localObject).recycle();
    }
    for (;;)
    {
      ram.b("Q.qqstory.playernew.InterceptTouch", "delivering = %d, handled = %s", Integer.valueOf(this.bmv), Boolean.valueOf(bool1));
      bool1 = bool2;
      if (this.bmv != 0) {
        break;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
      bool1 = false;
      break label236;
      label521:
      bool1 = false;
      break label253;
      label527:
      localObject = "DOWN";
      break label428;
      label534:
      this.bmv = 0;
      bool1 = bool3;
      continue;
      label546:
      if (((i == 1) || (i == 3)) && ((this.aDB) || (this.aDC)) && ((this.bmv == 0) || (this.bmv == 1) || (this.bmv == 3)))
      {
        j = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.getCurrentItem();
        k = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.getAdapter().getCount();
        if (((i == 1) && (j < k - 1) && (this.aDB)) || ((i == 3) && (j > 0) && (this.aDC)))
        {
          if (this.bmv == 0)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.setPageTransformer(true, this.jdField_a_of_type_Qix);
            localObject = MotionEvent.obtain(a.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetInterceptTouchRelativeLayout$a));
            ((MotionEvent)localObject).setLocation(paramMotionEvent.getX(), paramMotionEvent.getY());
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.E((MotionEvent)localObject);
            ((MotionEvent)localObject).recycle();
          }
          if (i == 1) {}
          for (localObject = "Left";; localObject = "Right")
          {
            ram.b("Q.qqstory.playernew.InterceptTouch", "Move direction = %s, Event = %s", localObject, paramMotionEvent);
            this.bmv = i;
            bool1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager.E(paramMotionEvent);
            break;
          }
        }
        this.bmv = 0;
        bool1 = bool3;
      }
      else
      {
        this.bmv = 0;
        bool1 = bool3;
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int i = 0;
    for (;;)
    {
      if (i < getChildCount())
      {
        View localView = getChildAt(i);
        if ((localView instanceof IgnoreTouchXViewPager)) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager = ((IgnoreTouchXViewPager)localView);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetIgnoreTouchXViewPager != null) {
          break;
        }
        throw new IllegalStateException("should add XViewPager as a child view");
      }
      i += 1;
    }
  }
  
  public static class a
  {
    private String TAG;
    private int bmw = 0;
    private MotionEvent f;
    private int mActivePointerId = -1;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsUnableToDrag;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mTouchSlop;
    
    public a(Context paramContext, String paramString)
    {
      this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
      this.TAG = paramString;
    }
    
    public int b(MotionEvent paramMotionEvent)
    {
      int i = 3;
      int j = paramMotionEvent.getAction() & 0xFF;
      if ((j == 3) || (j == 1))
      {
        Log.v(this.TAG, "Intercept done!");
        i = this.bmw;
        this.bmw = 0;
        this.mIsUnableToDrag = false;
        this.mActivePointerId = -1;
        return i;
      }
      if (j != 0)
      {
        if (this.bmw != 0)
        {
          Log.v(this.TAG, "Intercept returning true! " + this.bmw);
          return this.bmw;
        }
        if (this.mIsUnableToDrag)
        {
          Log.v(this.TAG, "Intercept returning false!");
          return 0;
        }
      }
      switch (j)
      {
      }
      for (;;)
      {
        return this.bmw;
        j = this.mActivePointerId;
        if (j != -1)
        {
          j = MotionEventCompat.findPointerIndex(paramMotionEvent, j);
          float f1 = MotionEventCompat.getX(paramMotionEvent, j);
          float f3 = f1 - this.mLastMotionX;
          float f4 = Math.abs(f3);
          float f2 = MotionEventCompat.getY(paramMotionEvent, j);
          float f5 = f2 - this.mLastMotionY;
          float f6 = Math.abs(f5);
          Log.v(this.TAG, "Moved x to " + f1 + "," + f2 + " diff=" + f4 + "," + f6 + ", mTouchSlop=" + this.mTouchSlop);
          if ((f4 > this.mTouchSlop) && (f4 > f6))
          {
            Log.v(this.TAG, "Starting drag horizontal !");
            if (f3 > 0.0F)
            {
              label325:
              this.bmw = i;
              if (f3 <= 0.0F) {
                break label368;
              }
            }
            label368:
            for (f1 = this.mInitialMotionX + this.mTouchSlop;; f1 = this.mInitialMotionX - this.mTouchSlop)
            {
              this.mLastMotionX = f1;
              this.mLastMotionY = f2;
              break;
              i = 1;
              break label325;
            }
          }
          if ((f6 > this.mTouchSlop) && (f6 > f4))
          {
            Log.v(this.TAG, "Starting drag vertical !");
            if (f5 > 0.0F)
            {
              i = 4;
              label421:
              this.bmw = i;
              this.mLastMotionX = f1;
              if (f5 <= 0.0F) {
                break label464;
              }
            }
            label464:
            for (f1 = this.mInitialMotionY + this.mTouchSlop;; f1 = this.mInitialMotionY - this.mTouchSlop)
            {
              this.mLastMotionY = f1;
              break;
              i = 2;
              break label421;
            }
            f1 = paramMotionEvent.getX();
            this.mInitialMotionX = f1;
            this.mLastMotionX = f1;
            f1 = paramMotionEvent.getY();
            this.mInitialMotionY = f1;
            this.mLastMotionY = f1;
            this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
            this.mIsUnableToDrag = false;
            this.bmw = 0;
            if (this.f != null) {
              this.f.recycle();
            }
            this.f = MotionEvent.obtain(paramMotionEvent);
            Log.v(this.TAG, "Down at " + this.mLastMotionX + "," + this.mLastMotionY + " mIsBeingDragged=" + this.bmw + "mIsUnableToDrag=" + this.mIsUnableToDrag);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.InterceptTouchRelativeLayout
 * JD-Core Version:    0.7.0.1
 */