package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;

public class FloatActionListView
  extends XListView
{
  private static final String jdField_a_of_type_JavaLangString = "FloatActionListView";
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  
  public FloatActionListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new Rect();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    ListAdapter localListAdapter = super.a();
    if ((localListAdapter != null) && ((localListAdapter instanceof HeaderViewListAdapter))) {
      ((HeaderViewListAdapter)localListAdapter).getWrappedAdapter();
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FloatActionListView
 * JD-Core Version:    0.7.0.1
 */