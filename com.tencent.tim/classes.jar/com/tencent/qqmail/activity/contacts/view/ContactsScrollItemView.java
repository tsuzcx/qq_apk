package com.tencent.qqmail.activity.contacts.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class ContactsScrollItemView
  extends LinearLayout
{
  private int mChildrenLength = 0;
  private Context mContext;
  private Scroller mScroller;
  private int mWidth = 0;
  
  public ContactsScrollItemView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ContactsScrollItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mScroller = new Scroller(paramContext);
    setOrientation(0);
  }
  
  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), 0);
      invalidate();
    }
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.measureChildWithMargins(paramView, paramInt1, 0, paramInt3, paramInt4);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = getMeasuredWidth();
    this.mChildrenLength = 0;
    paramInt1 = i;
    while (paramInt1 < getChildCount())
    {
      this.mChildrenLength += getChildAt(paramInt1).getMeasuredWidth();
      paramInt1 += 1;
    }
  }
  
  public void scrollToEnd()
  {
    int i = this.mChildrenLength - this.mWidth;
    if (i > 0)
    {
      this.mScroller.startScroll(getScrollX(), 0, i - getScrollX(), 0);
      invalidate();
    }
  }
  
  public void scrollToStart()
  {
    this.mScroller.startScroll(getScrollX(), 0, -getScrollX(), 0);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactsScrollItemView
 * JD-Core Version:    0.7.0.1
 */