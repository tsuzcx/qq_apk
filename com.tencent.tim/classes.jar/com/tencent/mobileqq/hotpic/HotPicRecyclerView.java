package com.tencent.mobileqq.hotpic;

import ahzl;
import aiad;
import aiad.a;
import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class HotPicRecyclerView
  extends FooterRecyclerView
  implements aiad.a
{
  public a a;
  b a;
  public aiad b = new aiad(200, this);
  boolean cjp = false;
  boolean cjq = false;
  public int[] lD = new int[3];
  public int mLastState = 0;
  
  public HotPicRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HotPicRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnScrollListener(new ahzl(this));
  }
  
  public static void KS(String paramString)
  {
    String str = "LogAutoScrollInfo ";
    if (paramString != null) {
      str = "LogAutoScrollInfo " + paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotPicRecyclerView", 2, str);
    }
  }
  
  public int Fu()
  {
    float f2 = 0.0F;
    Object localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions((int[])localObject);
    int i = localObject[0];
    if (i >= 0) {
      return i;
    }
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstVisibleItemPositions((int[])localObject);
    int j = localObject[0];
    localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastVisibleItemPositions((int[])localObject);
    i = localObject[0];
    if (j == i) {
      return j;
    }
    localObject = findViewHolderForPosition(j);
    RecyclerView.ViewHolder localViewHolder = findViewHolderForPosition(i);
    if (localObject != null) {}
    for (float f1 = ((RecyclerView.ViewHolder)localObject).itemView.getBottom() / ((RecyclerView.ViewHolder)localObject).itemView.getHeight();; f1 = 0.0F)
    {
      if (localViewHolder != null) {
        f2 = (getHeight() - localViewHolder.itemView.getTop()) / localViewHolder.itemView.getHeight();
      }
      if (f1 < f2) {
        break;
      }
      return j;
    }
  }
  
  public void Ib(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$a != null) && (HotPicPageView.cjn)) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$a.cZu();
    }
    this.b.KQ(false);
  }
  
  void dru()
  {
    Object localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastVisibleItemPositions((int[])localObject);
    int i = localObject[0];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastCompletelyVisibleItemPositions((int[])localObject);
    int j = localObject[0];
    localObject = " nEndIndex = " + i;
    localObject = (String)localObject + " nCompletelyEndIndex = " + j;
    int[] arrayOfInt = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstVisibleItemPositions(arrayOfInt);
    i = arrayOfInt[0];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
    j = arrayOfInt[0];
    localObject = (String)localObject + " nStartIndex = " + i;
    localObject = (String)localObject + " nCompletelyStartIndex = " + j;
    if (QLog.isColorLevel()) {
      QLog.i("HotPicRecyclerView", 2, (String)localObject);
    }
  }
  
  public void drv()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$b.onScrollEnd();
    }
    this.cjq = false;
  }
  
  public void drw()
  {
    if (this.cjq) {}
    do
    {
      return;
      this.cjq = true;
    } while (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$b == null);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$b.onScrollStart();
  }
  
  public void ir(int paramInt1, int paramInt2)
  {
    KS("ScrollItem Start nScollFromIndex is " + paramInt1 + " nScrollToIndex is " + paramInt2);
    dru();
    Object localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastCompletelyVisibleItemPositions((int[])localObject);
    int i = localObject[0];
    int[] arrayOfInt = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
    int j = arrayOfInt[0];
    if ((i == -1) && (j == -1)) {
      paramInt1 = 0;
    }
    for (;;)
    {
      localObject = findViewHolderForPosition(paramInt2);
      if (localObject != null)
      {
        paramInt2 = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
        KS("StartY = " + paramInt1);
        KS("EndY = " + paramInt2);
        paramInt2 -= paramInt1;
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = paramInt2 + 1;
        }
        smoothScrollBy(0, paramInt1);
        return;
        if ((paramInt1 < j) || ((paramInt1 > i) && (i >= 0)))
        {
          if (paramInt2 < j)
          {
            smoothScrollToPosition(paramInt2);
            return;
          }
          if ((paramInt2 > i) && (i >= 0))
          {
            ((StaggeredGridLayoutManager)getLayoutManager()).findLastVisibleItemPositions((int[])localObject);
            paramInt1 = localObject[0];
            if (paramInt2 == paramInt1)
            {
              localObject = findViewHolderForPosition(paramInt1);
              if (localObject != null)
              {
                paramInt2 = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
                paramInt1 = paramInt2;
                if (paramInt2 == 0) {
                  paramInt1 = paramInt2 + 1;
                }
                smoothScrollBy(0, paramInt1);
                return;
              }
              smoothScrollToPosition(paramInt2);
              return;
            }
            if (paramInt2 == paramInt1 + 1)
            {
              localObject = findViewHolderForPosition(paramInt1);
              if (localObject != null)
              {
                paramInt2 = ((RecyclerView.ViewHolder)localObject).itemView.getBottom();
                paramInt1 = paramInt2;
                if (paramInt2 == 0) {
                  paramInt1 = paramInt2 + 1;
                }
                smoothScrollBy(0, paramInt1);
                return;
              }
              smoothScrollToPosition(paramInt2);
              return;
            }
            smoothScrollToPosition(paramInt2);
            return;
          }
          localObject = findViewHolderForPosition(paramInt2);
          if (localObject != null)
          {
            paramInt2 = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
            paramInt1 = paramInt2;
            if (paramInt2 == 0) {
              paramInt1 = paramInt2 + 1;
            }
            smoothScrollBy(0, paramInt1);
            return;
          }
          smoothScrollToPosition(paramInt2);
          return;
        }
        localObject = findViewHolderForPosition(paramInt1);
        if (localObject != null) {
          paramInt1 = ((RecyclerView.ViewHolder)localObject).itemView.getTop();
        }
      }
      else
      {
        smoothScrollToPosition(paramInt2);
        return;
      }
      paramInt1 = 0;
    }
  }
  
  public boolean ke(int paramInt)
  {
    KS("CheckItemIsNeedToScroll Start nCheckIndex is " + paramInt);
    dru();
    Object localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findLastCompletelyVisibleItemPositions((int[])localObject);
    int i = localObject[0];
    localObject = new int[1];
    ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions((int[])localObject);
    int j = localObject[0];
    if ((i == -1) && (j == -1))
    {
      localObject = findViewHolderForPosition(paramInt);
      if (localObject == null) {
        return false;
      }
      if (((RecyclerView.ViewHolder)localObject).itemView == null) {
        break label145;
      }
    }
    label145:
    for (paramInt = ((RecyclerView.ViewHolder)localObject).itemView.getTop();; paramInt = 0)
    {
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      if ((paramInt >= j) && ((paramInt <= i) || (i < 0))) {
        break;
      }
      return true;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    HotPicPageView.cjn = true;
    if (paramMotionEvent.getAction() == 1)
    {
      ((StaggeredGridLayoutManager)getLayoutManager()).findFirstCompletelyVisibleItemPositions(this.lD);
      if ((this.lD[0] == 0) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$a.cZv();
      }
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  public void setScrollStatusChengedListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView$b = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void cZu();
    
    public abstract void cZv();
  }
  
  public static abstract interface b
  {
    public abstract void onScrollEnd();
    
    public abstract void onScrollStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicRecyclerView
 * JD-Core Version:    0.7.0.1
 */