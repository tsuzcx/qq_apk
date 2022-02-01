package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import qhr;
import rar;

public class CommentFloatDialogTopGestureLayout
  extends LinearLayout
  implements View.OnTouchListener
{
  private StoryPlayerCommentListView jdField_b_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView;
  private qhr jdField_b_of_type_Qhr;
  float lastX;
  float lastY;
  private Scroller mScroller;
  private View og;
  
  public CommentFloatDialogTopGestureLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CommentFloatDialogTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CommentFloatDialogTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean Az()
  {
    boolean bool = false;
    if ((this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView == null) || (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.getChildCount() == 0) || (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView.getChildAt(0).getTop() == 0)) {
      bool = true;
    }
    return bool;
  }
  
  private void aHb()
  {
    if (this.og == null) {
      return;
    }
    int i = Math.abs(this.og.getScrollY());
    if (i > 200)
    {
      if (this.mScroller != null) {
        this.mScroller.setFinalY(0);
      }
      Object localObject = this.og;
      ThreadManager.getUIHandler().postDelayed(new CommentFloatDialogTopGestureLayout.1(this, (View)localObject), 32L);
      this.jdField_b_of_type_Qhr.close(i);
      if (this.jdField_b_of_type_Qhr.JD())
      {
        localObject = "2";
        if (!this.jdField_b_of_type_Qhr.JE()) {
          break label127;
        }
      }
      label127:
      for (String str = "2";; str = "1")
      {
        rar.a("play_video", "close_reply", 0, 2, new String[] { localObject, str });
        return;
        localObject = "1";
        break;
      }
    }
    smoothScrollTo(0, 0, 200);
  }
  
  private void init()
  {
    setOnTouchListener(this);
  }
  
  private void smoothScrollTo(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mScroller == null) {
      this.mScroller = new Scroller(getContext());
    }
    if (this.og == null) {
      return;
    }
    int i = this.og.getScrollX();
    int j = this.og.getScrollY();
    this.mScroller.startScroll(i, j, paramInt1 - i, paramInt2 - j, paramInt3);
    invalidate();
  }
  
  public void a(qhr paramqhr, StoryPlayerCommentListView paramStoryPlayerCommentListView, View paramView)
  {
    this.jdField_b_of_type_Qhr = paramqhr;
    this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoFloatdialogStoryPlayerCommentListView = paramStoryPlayerCommentListView;
    this.og = paramView;
  }
  
  public void computeScroll()
  {
    if (this.mScroller == null) {
      this.mScroller = new Scroller(getContext());
    }
    if (this.og == null) {}
    while (!this.mScroller.computeScrollOffset()) {
      return;
    }
    this.og.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
    postInvalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.lastY != 0.0F) {}
    for (float f = paramMotionEvent.getRawY() - this.lastY;; f = 0.0F)
    {
      this.lastX = paramMotionEvent.getRawX();
      this.lastY = paramMotionEvent.getRawY();
      if ((!Az()) || (f <= 0.0F) || (paramMotionEvent.getAction() == 0)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f = 0.0F;
    if (this.og == null) {
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
    int i = (int)(this.og.getScrollY() - f);
    if (i <= 0) {
      smoothScrollTo(0, i, 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialogTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */