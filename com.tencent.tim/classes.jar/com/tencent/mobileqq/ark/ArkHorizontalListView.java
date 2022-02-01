package com.tencent.mobileqq.ark;

import adqr;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import auup;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

public class ArkHorizontalListView
  extends HorizontalListView
{
  private int cJu;
  private int cJv = 3;
  private WeakReference<a> gw;
  private boolean mIsSend;
  private float vj = 0.08F;
  
  public ArkHorizontalListView(Context paramContext)
  {
    super(paramContext);
    paramContext = paramContext.getResources();
    int i = BaseChatItemLayout.bOc;
    int j = MessageForArkApp.dp2px(40.0F);
    this.cJu = (paramContext.getDimensionPixelSize(2131296407) + (i * 2 + j));
    setStayDisplayOffsetZero(true);
    cTU();
  }
  
  public ArkHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources();
    int i = BaseChatItemLayout.bOc;
    int j = MessageForArkApp.dp2px(40.0F);
    this.cJu = (paramContext.getDimensionPixelSize(2131296407) + (i * 2 + j));
    setStayDisplayOffsetZero(true);
    cTU();
  }
  
  private void cTU() {}
  
  public boolean afx()
  {
    return this.mIsSend;
  }
  
  public boolean checkScrollToChild()
  {
    if (!this.mStayDisplayOffsetZero) {
      return false;
    }
    Object localObject = null;
    int j = adqr.cJg;
    int i = 0;
    View localView;
    if (i <= getChildCount())
    {
      localView = getChildAt(i);
      if ((localView == null) || (!(localView instanceof LinearLayout))) {}
    }
    label646:
    label656:
    for (i = localView.getRight() - localView.getLeft();; i = 0)
    {
      int k;
      label78:
      int m;
      label172:
      int n;
      if (this.mIsSend)
      {
        k = adqr.cJg - this.cJu - i / 2;
        QLog.d("ArkHorizontalListView", 2, new Object[] { "---start find card mNextX=", Integer.valueOf(this.mNextX), ",scrollStartX=", Integer.valueOf(this.mScroller.getStartX()), ",sRealDisplayWith=", Integer.valueOf(adqr.cJg), ",priovtX=", Integer.valueOf(k), ",mIsSend=", Boolean.valueOf(this.mIsSend) });
        i = 0;
        m = 0;
        if (i > getChildCount()) {
          break label378;
        }
        localView = getChildAt(i);
        if ((localView == null) || (!(localView instanceof LinearLayout))) {
          break label686;
        }
        int i1 = (localView.getLeft() + localView.getRight()) / 2;
        int i2 = i1 - k;
        n = Math.abs(i2);
        if (QLog.isColorLevel()) {
          QLog.d("ArkHorizontalListView", 2, new Object[] { "view index=", Integer.valueOf(i), " view pos(", Integer.valueOf(localView.getLeft()), ",", Integer.valueOf(localView.getRight()), "),viewCenter=", Integer.valueOf(i1), ",curDistance=", Integer.valueOf(n), ",delta=", Integer.valueOf(i2) });
        }
        if (n > j) {
          break label686;
        }
        m = i;
        localObject = localView;
        j = n;
      }
      label418:
      label680:
      label686:
      for (;;)
      {
        i += 1;
        break label172;
        i += 1;
        break;
        k = this.cJu;
        k = i / 2 + k;
        break label78;
        label378:
        if (localObject != null)
        {
          n = this.mNextX;
          if (this.mIsSend)
          {
            k = localObject.getRight();
            if (!this.mIsSend) {
              break label611;
            }
            if (k <= adqr.cJg) {
              break label606;
            }
            i = 1;
            if (!this.mIsSend) {
              break label634;
            }
            if (i == 0) {
              break label625;
            }
            j = k - adqr.cJg;
            if (!this.mIsSend) {
              break label656;
            }
            if (i == 0) {
              break label646;
            }
            i = -(j + this.cJu);
            i = n - i;
            if (QLog.isColorLevel()) {
              QLog.d("ArkHorizontalListView", 2, new Object[] { "---end find card mNextX=", Integer.valueOf(this.mNextX), ", newNextX=", Integer.valueOf(i), ", mIsSend=", Boolean.valueOf(this.mIsSend), ",targetIndex=", Integer.valueOf(m) });
            }
            if (!this.mScroller.springBack(this.mNextX + getScrollX(), 0, i, i, 0, 0, 1000)) {
              break label680;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ArkHorizontalListView", 2, "checkScrollToChild springBack return true");
            }
            invalidate();
          }
        }
        label435:
        label454:
        for (boolean bool = true;; bool = false)
        {
          post(new ArkHorizontalListView.1(this));
          return bool;
          k = localObject.getLeft();
          break;
          label606:
          i = 0;
          break label418;
          label611:
          if (k < 0)
          {
            i = 1;
            break label418;
          }
          i = 0;
          break label418;
          label625:
          j = adqr.cJg - k;
          break label435;
          label634:
          j = k;
          if (i == 0) {
            break label435;
          }
          j = -k;
          break label435;
          i = j - this.cJu;
          break label454;
          if (i != 0)
          {
            i = j + this.cJu;
            break label454;
          }
          i = this.cJu - j;
          break label454;
        }
      }
    }
  }
  
  public int getFlingVelocity(int paramInt)
  {
    return paramInt / this.cJv;
  }
  
  public float getScrollerFriction()
  {
    return this.vj;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return bool;
      for (paramMotionEvent = getParent(); !(paramMotionEvent instanceof ListView); paramMotionEvent = paramMotionEvent.getParent()) {}
      paramMotionEvent = paramMotionEvent.getParent();
    } while (paramMotionEvent == null);
    paramMotionEvent.requestDisallowInterceptTouchEvent(true);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.gw != null) && (this.gw.get() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkHorizontalListView", 2, "onTouchEvent updateHeadBorder action=" + (paramMotionEvent.getAction() & 0xFF));
      }
      ((a)this.gw.get()).a(this);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.mIsSend = paramBoolean;
  }
  
  public void setRefreshCallback(a parama)
  {
    this.gw = new WeakReference(parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(ArkHorizontalListView paramArkHorizontalListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkHorizontalListView
 * JD-Core Version:    0.7.0.1
 */