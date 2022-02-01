package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ListAdapter;
import aqcx;
import auvk;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.b;
import rad;
import ram;
import rsn.a;

public class StoryHomeHorizontalListView
  extends HorizontalListView
{
  private a jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView$a;
  private b jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView$b;
  private boolean aGk;
  private boolean akU;
  private rsn.a b;
  protected int bnG;
  public int bpl = 5;
  private float iq;
  private float is;
  private boolean mHasMore;
  private boolean mIsLoadingMore;
  private HorizontalListView.b mOnItemScrollEventListener;
  protected int mScreenWidth;
  
  public StoryHomeHorizontalListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public StoryHomeHorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.bnG = aqcx.dip2px(paramContext, 147.0F);
    super.setOnItemScollEventListener(new rad(this));
    setOverScrollMode(1);
  }
  
  public void brV()
  {
    if (!this.mHasMore) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
      } while (this.mIsLoadingMore);
      i = getLastVisiblePosition();
      j = getAdapter().getCount();
      ram.b("HorizontalListView", "on item scroll last:%d, count:%d", Integer.valueOf(i), Integer.valueOf(j));
    } while ((j - i >= this.bpl) || (this.b == null) || (!this.b.R(false)));
    this.mIsLoadingMore = true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f3 = paramMotionEvent.getY();
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.friendStory", 2, "StoryHomeHorizontalListView dispatchTouchEvent:ACTION_DOWN. mIsPress=" + this.akU);
      }
      this.is = f1;
      this.iq = f3;
      getParent().requestDisallowInterceptTouchEvent(true);
      this.akU = true;
      this.aGk = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.friendStory", 2, "StoryHomeHorizontalListView dispatchTouchEvent:ACTION_MOVE. mIsPress=" + this.akU);
      }
      float f2 = this.is;
      f3 -= this.iq;
      if ((this.akU) && (Math.abs(f3) * 5.0F > Math.abs(f1 - f2) * 4.0F) && (Math.abs(f3) > aqcx.dip2px(getContext(), 5.0F))) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      if ((i == 3) || (i == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.friendStory", 2, "StoryHomeHorizontalListView dispatchTouchEvent:ACTION_CANCEL or UP. action=" + i + " mIsPress=" + this.akU);
        }
        this.akU = false;
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    auvk.traceBegin("StoryHorizontal.onLayout");
    int i = this.mCurrentX;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView$b != null) && (i != this.mCurrentX))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView$b.dh(i, this.mCurrentX);
      ram.b("Q.qqstory.friendStory", "onLayout() %d -> %d", Integer.valueOf(i), Integer.valueOf(this.mCurrentX));
    }
    auvk.traceEnd();
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if ((this.aGk) && (paramInt3 > 0) && (paramInt3 > aqcx.dip2px(getContext(), 50.0F)))
    {
      this.aGk = false;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView$a != null) && (this.akU)) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView$a.bqs();
      }
    }
    for (;;)
    {
      return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      if ((this.aGk) && (paramInt3 < 0) && (paramInt3 < -aqcx.dip2px(getContext(), 50.0F)))
      {
        this.aGk = false;
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView$a != null) && (this.akU)) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView$a.bqt();
        }
      }
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public void setDataCount(int paramInt)
  {
    if (paramInt >= this.mScreenWidth / this.bnG)
    {
      setOverScrollMode(0);
      return;
    }
    setOverScrollMode(1);
  }
  
  public void setLoadMoreComplete(boolean paramBoolean)
  {
    this.mHasMore = paramBoolean;
    this.mIsLoadingMore = false;
  }
  
  public void setOnItemScollEventListener(HorizontalListView.b paramb)
  {
    this.mOnItemScrollEventListener = paramb;
  }
  
  public void setOnLoadMoreListener(rsn.a parama)
  {
    this.b = parama;
  }
  
  public void setOnOverScrollRightListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView$a = parama;
  }
  
  public void setOnScrollChangeListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView$b = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void bqs();
    
    public abstract void bqt();
  }
  
  public static abstract interface b
  {
    public abstract void dh(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView
 * JD-Core Version:    0.7.0.1
 */