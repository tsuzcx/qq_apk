package com.tencent.mobileqq.emoticonview;

import afnt;
import afnt.a;
import afnt.b;
import afpl;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ListAdapter;
import aqnm;
import auup;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wja;

public class HorizontalListViewEx
  extends HorizontalListView
{
  private static List<View> Aj = Collections.synchronizedList(new ArrayList());
  private RectF a;
  public int aYV;
  private int cSW;
  private int cSX = -1;
  private int cSY;
  private boolean cac;
  private boolean cad;
  private Paint mRectPaint;
  private int mScreenWidth;
  
  public HorizontalListViewEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public HorizontalListViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.cSW = wja.dp2px(51.0F, paramContext.getResources());
    paramAttributeSet = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramAttributeSet);
    this.mScreenWidth = paramAttributeSet.widthPixels;
    initPaint();
  }
  
  public static View bV()
  {
    if ((Aj != null) && (Aj.size() > 0)) {
      return (View)Aj.remove(0);
    }
    return null;
  }
  
  public static void dbq()
  {
    if (Aj != null) {
      Aj.clear();
    }
  }
  
  private void dbr()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getTag() != null)
      {
        afnt.b localb = (afnt.b)localView.getTag();
        localView.setSelected(false);
        localb.aU.setSelected(false);
      }
      i += 1;
    }
  }
  
  private void initPaint()
  {
    this.mRectPaint = new Paint();
    this.mRectPaint.setAntiAlias(true);
    this.mRectPaint.setStyle(Paint.Style.FILL);
    this.mRectPaint.setColor(getResources().getColor(2131166786));
    this.a = new RectF();
    this.cSY = aqnm.dip2px(2.0F);
  }
  
  protected void aXq()
  {
    if ((this.cSX != this.mCurrentlySelectedAdapterIndex) && (getChildCount() > 0))
    {
      View localView = getChild(this.cSX);
      if (localView != null) {
        this.aYV = localView.getLeft();
      }
      for (;;)
      {
        localView = getSelectedView();
        if (localView == null) {
          break;
        }
        dbr();
        int i = this.aYV;
        int j = localView.getLeft();
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i, j });
        localValueAnimator.setDuration(200L);
        this.cad = true;
        localValueAnimator.addUpdateListener(new afpl(this, localView, j));
        localValueAnimator.start();
        return;
        if (this.cSX < getFirstVisiblePosition()) {
          this.aYV = (-this.cSW);
        } else if (this.cSX > getLastVisiblePosition()) {
          this.aYV = (this.mScreenWidth - this.cSW);
        }
      }
    }
    this.cad = false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (getParent() != null))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("HorizontalListView", 4, "dispatch touchEvent down");
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int hr(int paramInt)
  {
    int i = this.mNextX + paramInt;
    if (i < 0) {
      return -1;
    }
    if (i > this.mMaxX) {
      return 1;
    }
    this.mScroller.startScroll(this.mNextX, 0, paramInt, 0, 20);
    setCurrentScrollState(4098);
    requestLayout();
    return 0;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1;
    if ((this.cac) && (this.cad))
    {
      localObject1 = getSelectedView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject1 = ((ViewGroup)localObject1).getChildAt(0);
        if (localObject1 != null) {
          break label50;
        }
      }
    }
    label50:
    int j;
    do
    {
      do
      {
        return;
        localObject1 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      } while (localObject1 == null);
      this.a.set(this.aYV, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, this.aYV + this.cSW, getMeasuredHeight() - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
      paramCanvas.drawRoundRect(this.a, this.cSY, this.cSY, this.mRectPaint);
      return;
      j = getChildCount();
    } while (getAdapter() == null);
    paramCanvas = (afnt)getAdapter();
    int i = 0;
    label149:
    Object localObject2;
    afnt.b localb;
    if (i < j)
    {
      localObject1 = getChildAt(i);
      localObject2 = paramCanvas.getItem(this.mLeftViewAdapterIndex + i);
      if (((View)localObject1).getTag() != null)
      {
        localb = (afnt.b)((View)localObject1).getTag();
        if (localObject1 != getSelectedView()) {
          break label240;
        }
        ((View)localObject1).setSelected(true);
        localb.aU.setSelected(true);
        if (localObject2 != null) {
          ((View)localObject1).setContentDescription(((afnt.a)localObject2).description);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label149;
      break;
      label240:
      ((View)localObject1).setSelected(false);
      localb.aU.setSelected(false);
      if (localObject2 != null) {
        ((View)localObject1).setContentDescription(((afnt.a)localObject2).description);
      }
    }
  }
  
  public void resetCurrentX(int paramInt)
  {
    this.mCurrentX = (this.cSW * paramInt);
  }
  
  public void setSelection(int paramInt)
  {
    int j = 0;
    super.setSelection(paramInt);
    if (this.mAdapter == null) {}
    label671:
    label703:
    for (;;)
    {
      return;
      if ((paramInt < this.mAdapter.getCount()) && (paramInt >= 0))
      {
        int k = getFirstVisiblePosition();
        int m = getLastVisiblePosition();
        int n;
        int i;
        if ((paramInt > m) && (m != -1))
        {
          n = (paramInt + 1) * this.cSW;
          j = n - this.mNextX - (this.mScreenWidth - this.cSW - this.cSW);
          i = j;
          if (DEBUG)
          {
            i = j;
            if (QLog.isDevelopLevel())
            {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond right screen, position:" + paramInt + ",lastPosition:" + m + ",tabPosition:" + n + ",mNextX:" + this.mNextX + ",deltaX:" + j + ",mScreenWidth" + this.mScreenWidth);
              i = j;
            }
          }
          if (i == 0) {
            break label671;
          }
          hr(i);
        }
        for (;;)
        {
          if (!this.cac) {
            break label703;
          }
          aXq();
          this.cSX = this.mCurrentlySelectedAdapterIndex;
          return;
          if ((paramInt < k) && (k != -1))
          {
            n = this.cSW * paramInt;
            j = n - this.mNextX;
            i = j;
            if (!DEBUG) {
              break;
            }
            i = j;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view beyond l eft screen, position:" + paramInt + ",firstPosition:" + k + ",tabPosition:" + n + ",mNextX:" + this.mNextX + ",deltaX:" + j + ",mScreenWidth" + this.mScreenWidth);
            i = j;
            break;
          }
          View localView;
          int[] arrayOfInt;
          if (paramInt == k)
          {
            localView = getChildAt(0);
            arrayOfInt = new int[2];
            localView.getLocationOnScreen(arrayOfInt);
            i = arrayOfInt[0] - getLeft();
            if ((DEBUG) && (QLog.isDevelopLevel())) {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half left screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.mNextX + ",deltaX:" + i);
            }
            break;
          }
          if (paramInt == m)
          {
            localView = getChildAt(getChildCount() - 1);
            arrayOfInt = new int[2];
            localView.getLocationOnScreen(arrayOfInt);
            j = arrayOfInt[0] + this.cSW - getRight();
            i = j;
            if (j < 0) {
              i = 0;
            }
            if ((DEBUG) && (QLog.isDevelopLevel())) {
              QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view on half right screen, position:" + paramInt + ",location:" + arrayOfInt[0] + ",mNextX:" + this.mNextX + ",deltaX:" + i);
            }
            break;
          }
          i = j;
          if (!DEBUG) {
            break;
          }
          i = j;
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.i(HorizontalListView.class.getSimpleName(), 4, "setSelectionEx: view inside screen, position:" + paramInt + ",mNextX:" + this.mNextX);
          i = j;
          break;
          if ((k == -1) && (m == -1)) {
            ViewCompat.postOnAnimation(this, new HorizontalListViewEx.1(this));
          } else {
            requestLayout();
          }
        }
      }
    }
  }
  
  public void setTabAnimateEnable(boolean paramBoolean)
  {
    this.cac = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.HorizontalListViewEx
 * JD-Core Version:    0.7.0.1
 */