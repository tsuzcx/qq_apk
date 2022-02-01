package com.tencent.biz.pubaccount.readinjoy.comment;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.app.ThreadManager;
import ksy;
import mqq.os.MqqHandler;

public class ReadInJoyCommentTopGestureLayout
  extends RelativeLayout
  implements View.OnTouchListener
{
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout$a;
  private int aLK;
  final int aLL = 5;
  private boolean ahE = true;
  private boolean ahF;
  private boolean ahG;
  float lastX;
  float lastY;
  private Context mContext;
  private View mRootView;
  Scroller mScroller;
  
  public ReadInJoyCommentTopGestureLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyCommentTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyCommentTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnTouchListener(this);
    this.mContext = paramContext;
  }
  
  private boolean Ay()
  {
    return (this.ahG) && (this.ahE);
  }
  
  private boolean Az()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.ahF) {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount() != 0))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition() == 0)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop() != 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void aHb()
  {
    if (this.mRootView == null) {
      return;
    }
    if (Ay())
    {
      aHc();
      return;
    }
    int j = Math.abs(this.mRootView.getScrollY());
    if (j > 200)
    {
      if (this.mScroller != null) {
        this.mScroller.setFinalY(0);
      }
      Object localObject = this.mRootView;
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentTopGestureLayout.1(this, (View)localObject), 32L);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout$a;
      if (this.ahE) {}
      for (int i = 1;; i = 2)
      {
        ((a)localObject).cw(i, j);
        return;
      }
    }
    smoothScrollTo(0, 0, 200);
  }
  
  private void aHc()
  {
    int i = 1;
    Object localObject = this.mRootView;
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    if (this.aLK - localLayoutParams.height > 200)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout$a;
      if (this.ahE) {}
      for (;;)
      {
        ((a)localObject).cw(i, -1);
        return;
        i = 2;
      }
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { localLayoutParams.height, this.aLK });
    localValueAnimator.addUpdateListener(new ksy(this, localLayoutParams, (View)localObject));
    localValueAnimator.setDuration(120L);
    localValueAnimator.start();
  }
  
  private void pL(int paramInt)
  {
    if (this.mRootView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.mRootView.getLayoutParams();
    localLayoutParams.height -= paramInt;
    if (localLayoutParams.height > this.aLK) {
      localLayoutParams.height = this.aLK;
    }
    this.mRootView.setLayoutParams(localLayoutParams);
  }
  
  private void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mScroller == null) {
      this.mScroller = new Scroller(this.mContext);
    }
    if (this.mRootView == null) {
      return;
    }
    int i = this.mRootView.getScrollX();
    int j = this.mRootView.getScrollY();
    this.mScroller.startScroll(i, j, paramInt1 - i, paramInt2 - j, paramInt3);
    invalidate();
  }
  
  public void computeScroll()
  {
    if (this.mScroller == null) {
      this.mScroller = new Scroller(this.mContext);
    }
    if (this.mRootView == null) {}
    while (!this.mScroller.computeScrollOffset()) {
      return;
    }
    this.mRootView.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
    postInvalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f = 0.0F;
    if ((this.mRootView == null) || (!Ay())) {
      return false;
    }
    if (this.lastY != 0.0F) {
      f = paramMotionEvent.getRawY() - this.lastY;
    }
    this.lastX = paramMotionEvent.getRawX();
    this.lastY = paramMotionEvent.getRawY();
    if (Ay()) {
      this.aLK = this.mRootView.getHeight();
    }
    return (Az()) && (f > 5.0F) && (paramMotionEvent.getAction() != 0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f = 0.0F;
    if ((this.mRootView == null) || (!Ay())) {
      return false;
    }
    if (this.lastY != 0.0F) {
      f = paramMotionEvent.getRawY() - this.lastY;
    }
    this.lastX = paramMotionEvent.getRawX();
    this.lastY = paramMotionEvent.getRawY();
    switch (paramMotionEvent.getAction())
    {
    default: 
      aHb();
      return true;
    }
    if (Ay()) {
      pL((int)f);
    }
    for (;;)
    {
      return true;
      int i = (int)(this.mRootView.getScrollY() - f);
      if (i <= 0) {
        smoothScrollTo(0, i, 0);
      }
    }
  }
  
  public void setCommentListView(ReadInJoyCommentListView paramReadInJoyCommentListView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
  }
  
  public void setFirstLevelCommentContainer(a parama, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout$a = parama;
    this.ahG = paramBoolean;
  }
  
  public void setIsAllowedToInterceptTouchEvent(boolean paramBoolean)
  {
    this.ahF = paramBoolean;
  }
  
  public void setRootView(View paramView, boolean paramBoolean)
  {
    this.mRootView = paramView;
    this.ahE = paramBoolean;
    if (paramBoolean)
    {
      setIsAllowedToInterceptTouchEvent(this.ahG);
      return;
    }
    setIsAllowedToInterceptTouchEvent(true);
  }
  
  public static abstract interface a
  {
    public abstract void cw(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */