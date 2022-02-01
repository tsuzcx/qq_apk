package com.tencent.qqmail.view.listscroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class ContactScrollListView
  extends ListView
{
  public static final byte LOGO_DISPLAY_POS = 35;
  public static final byte SCROLL_POS_DURATION = 30;
  public static final int SCROLL_POS_TIME = 210;
  private ScrollDialHandler mCurContactLinearLayout;
  private int mCurScrollPosition;
  private View mCurScrollView = null;
  private MyGestureDetector mGestureDetector = new MyGestureDetector(new ScrollGestureListener1(null));
  private boolean mIsNeedScrollDial = false;
  private boolean mIsScrolling = false;
  private ScrollDialHandler mLastContactLinearLayout;
  private float mLastY;
  private int mScrollIndex;
  private int mScrollLinearLayoutViewIndex = 3;
  private int mScrollParentIndex = -1;
  private ScrollListViewStateListener mViewStateListener = null;
  
  public ContactScrollListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Adapter getListAdapter()
  {
    if (getAdapter().getClass().equals(HeaderViewListAdapter.class)) {
      return ((HeaderViewListAdapter)getAdapter()).getWrappedAdapter();
    }
    return getAdapter();
  }
  
  private IScrollListViewHandler getScrollViewHandler(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    Object localObject = localView;
    if (this.mScrollParentIndex != -1)
    {
      localObject = localView;
      if ((localView instanceof ViewGroup)) {
        localObject = ((ViewGroup)localView).getChildAt(this.mScrollParentIndex);
      }
    }
    if ((localObject instanceof ViewGroup))
    {
      localObject = ((ViewGroup)localObject).getChildAt(this.mScrollLinearLayoutViewIndex);
      if ((localObject == null) || (!(localObject instanceof IScrollListViewHandler))) {}
    }
    for (localObject = (IScrollListViewHandler)localObject;; localObject = null) {
      return localObject;
    }
  }
  
  private void invokeStateChange(MotionEvent paramMotionEvent)
  {
    if ((this.mViewStateListener == null) || (paramMotionEvent.getAction() != 2)) {
      return;
    }
    float f = paramMotionEvent.getY() - this.mLastY;
    int j = 1;
    int i = j;
    if (f < 2.0F)
    {
      i = j;
      if (f > -2.0F) {
        i = 0;
      }
    }
    this.mViewStateListener.onScrollListViewStateChange(i);
    this.mLastY = paramMotionEvent.getY();
  }
  
  private boolean isNeedScroll(MotionEvent paramMotionEvent)
  {
    if (!this.mIsNeedScrollDial) {
      return false;
    }
    int i = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    paramMotionEvent = getListAdapter();
    if ((paramMotionEvent instanceof IScrollListViewAdapter)) {}
    for (boolean bool = ((IScrollListViewAdapter)paramMotionEvent).shouldScroll(i);; bool = false) {
      return bool;
    }
  }
  
  private ScrollDialHandler pointToChild(int paramInt1, int paramInt2)
  {
    IScrollListViewHandler localIScrollListViewHandler = getScrollViewHandler(pointToPosition(paramInt1, paramInt2));
    if (localIScrollListViewHandler != null) {
      return localIScrollListViewHandler.getScrollLayoutHandler();
    }
    return null;
  }
  
  private ScrollDialHandler pointToChild(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return null;
    }
    return pointToChild((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  private void reSetScroll(MotionEvent paramMotionEvent)
  {
    if (this.mCurContactLinearLayout != null) {
      this.mCurContactLinearLayout.doTouchUp(paramMotionEvent);
    }
    reset();
  }
  
  private void reset()
  {
    this.mLastContactLinearLayout = this.mCurContactLinearLayout;
    this.mCurContactLinearLayout = null;
    this.mCurScrollPosition = -1;
    this.mScrollIndex = 0;
    this.mCurScrollView = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isNeedScroll(paramMotionEvent))
    {
      reSetScroll(paramMotionEvent);
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.mIsScrolling) {
      return true;
    }
    invokeStateChange(paramMotionEvent);
    boolean bool1 = this.mGestureDetector.onTouchEvent(paramMotionEvent);
    if (bool1) {
      paramMotionEvent.setAction(3);
    }
    for (;;)
    {
      try
      {
        boolean bool2 = super.dispatchTouchEvent(paramMotionEvent);
        return bool1 | bool2;
      }
      catch (Exception paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      if (paramMotionEvent.getAction() == 1) {
        reSetScroll(paramMotionEvent);
      }
    }
    return bool1;
  }
  
  public void enableScrollDial(boolean paramBoolean)
  {
    this.mIsNeedScrollDial = paramBoolean;
  }
  
  public void enableScrollDial(boolean paramBoolean, int paramInt)
  {
    this.mIsNeedScrollDial = paramBoolean;
    this.mScrollLinearLayoutViewIndex = paramInt;
  }
  
  public void enableScrollDial(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mIsNeedScrollDial = paramBoolean;
    this.mScrollLinearLayoutViewIndex = paramInt1;
    this.mScrollParentIndex = paramInt2;
  }
  
  public boolean isEnableScroll()
  {
    return this.mIsNeedScrollDial;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = getChildAt(this.mCurScrollPosition);
    if ((this.mCurContactLinearLayout != null) && ((paramBoolean) || (this.mCurScrollView != localView)) && ((localView instanceof LinearLayout)))
    {
      Object localObject = ((LinearLayout)localView).getChildAt(this.mScrollLinearLayoutViewIndex);
      if ((localObject != null) && ((localObject instanceof IScrollListViewHandler)))
      {
        paramInt1 = this.mCurContactLinearLayout.getTotalScrollX();
        this.mCurContactLinearLayout.resetAll();
        this.mCurContactLinearLayout = ((IScrollListViewHandler)localObject).getScrollLayoutHandler();
        this.mCurContactLinearLayout.doTounchDown(null);
        ((IScrollListViewHandler)localObject).startScroll();
        localObject = getAdapter();
        if ((localObject instanceof IScrollListViewAdapter)) {
          ((IScrollListViewAdapter)localObject).initScrollDialHandler(this.mCurScrollPosition, this.mCurContactLinearLayout);
        }
        this.mCurContactLinearLayout.scrollDis(paramInt1);
        this.mCurScrollView = localView;
      }
    }
  }
  
  protected void setChildrenDrawingCacheEnabled(boolean paramBoolean)
  {
    super.setChildrenDrawingCacheEnabled(false);
  }
  
  protected void setChildrenDrawnWithCacheEnabled(boolean paramBoolean)
  {
    super.setChildrenDrawnWithCacheEnabled(false);
  }
  
  public void setScrollListViewStateListener(ScrollListViewStateListener paramScrollListViewStateListener)
  {
    this.mViewStateListener = paramScrollListViewStateListener;
  }
  
  public static abstract interface IScrollListViewAdapter
  {
    public abstract void initScrollDialHandler(int paramInt, ScrollDialHandler paramScrollDialHandler);
    
    public abstract boolean shouldScroll(int paramInt);
  }
  
  public static abstract interface IScrollListViewHandler
  {
    public abstract ScrollDialHandler getScrollLayoutHandler();
    
    public abstract void startScroll();
  }
  
  class ScrollGestureListener1
    implements GestureDetector.OnGestureListener
  {
    private ScrollGestureListener1() {}
    
    private boolean isNotNeedHorizontalScroll()
    {
      return ContactScrollListView.this.mScrollIndex > 4;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      int i = ContactScrollListView.this.pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      ContactScrollListView.IScrollListViewHandler localIScrollListViewHandler = ContactScrollListView.this.getScrollViewHandler(i);
      if (localIScrollListViewHandler != null)
      {
        Adapter localAdapter = ContactScrollListView.this.getListAdapter();
        ScrollDialHandler localScrollDialHandler = localIScrollListViewHandler.getScrollLayoutHandler();
        localScrollDialHandler.doTounchDown(paramMotionEvent);
        localIScrollListViewHandler.startScroll();
        if ((localAdapter instanceof ContactScrollListView.IScrollListViewAdapter)) {
          ((ContactScrollListView.IScrollListViewAdapter)localAdapter).initScrollDialHandler(i, localScrollDialHandler);
        }
      }
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      boolean bool1 = false;
      boolean bool2 = false;
      if (isNotNeedHorizontalScroll()) {}
      do
      {
        return bool2;
        if (ContactScrollListView.this.mCurContactLinearLayout != null) {
          bool1 = ContactScrollListView.this.mCurContactLinearLayout.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
        bool2 = bool1;
      } while (!bool1);
      ContactScrollListView.this.reset();
      return bool1;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent) {}
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (((ContactScrollListView.this.mCurContactLinearLayout == null) && (Math.abs(4.0F * paramFloat2) > Math.abs(paramFloat1))) || (isNotNeedHorizontalScroll())) {
        ContactScrollListView.access$308(ContactScrollListView.this);
      }
      ScrollDialHandler localScrollDialHandler;
      do
      {
        do
        {
          return false;
          if (ContactScrollListView.this.mLastContactLinearLayout == null) {
            break;
          }
        } while (!ContactScrollListView.this.mLastContactLinearLayout.isCanReScroll());
        ContactScrollListView.access$502(ContactScrollListView.this, null);
        if (ContactScrollListView.this.mCurContactLinearLayout != null)
        {
          ContactScrollListView.this.mCurContactLinearLayout.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2, ContactScrollListView.this.mCurScrollPosition);
          return true;
        }
        localScrollDialHandler = ContactScrollListView.this.pointToChild(paramMotionEvent1);
      } while ((localScrollDialHandler == null) || (!localScrollDialHandler.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2)));
      ContactScrollListView.access$402(ContactScrollListView.this, localScrollDialHandler);
      ContactScrollListView.access$602(ContactScrollListView.this, ContactScrollListView.this.pointToPosition((int)paramMotionEvent1.getX(), (int)paramMotionEvent1.getY()));
      ContactScrollListView.access$802(ContactScrollListView.this, ContactScrollListView.this.getChildAt(ContactScrollListView.this.mCurScrollPosition));
      ContactScrollListView.this.mCurContactLinearLayout.setPosition(ContactScrollListView.this.mCurScrollPosition);
      ContactScrollListView.this.mCurContactLinearLayout.setContactProgressVisibility(0);
      return true;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent) {}
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  public static abstract interface ScrollListHeaderStateListener
  {
    public static final int STATE_DOWN = 0;
    public static final int STATE_UP = 1;
    
    public abstract void onScrollListHeaderStateChange(int paramInt);
  }
  
  public static abstract interface ScrollListViewStateListener
  {
    public static final int STATE_CHANGE = 1;
    public static final int STATE_NO_CHANGE = 0;
    
    public abstract void onScrollListViewStateChange(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.listscroller.ContactScrollListView
 * JD-Core Version:    0.7.0.1
 */