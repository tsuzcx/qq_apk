package com.tencent.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.recent.RecentAdapter;

public class SwipListView
  extends XListView
  implements Handler.Callback
{
  private static final byte jdField_a_of_type_Byte = 0;
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "SwipListView";
  private static final byte jdField_b_of_type_Byte = 1;
  private static final int jdField_b_of_type_Int = 1;
  private static final byte jdField_c_of_type_Byte = 2;
  private static final int jdField_c_of_type_Int = 2;
  private static final int d = 300;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private View jdField_c_of_type_AndroidViewView;
  private int e;
  private int f;
  private int g;
  private int h;
  private final int i;
  
  public SwipListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public SwipListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new SwipListView.SmoothInterpolator());
    this.i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.e = -1;
    this.g = -1;
    this.f = -1;
    this.h = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    paramInt2 = this.g;
    paramInt1 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
      paramView.scrollTo(paramInt3, 0);
      return;
      if (paramInt1 < 0) {
        paramInt3 = 0;
      } else {
        paramInt3 = paramInt1;
      }
    }
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int j = 300;
    if (paramInt1 > 0) {
      j = (int)(Math.abs(paramInt2) / paramInt1 * 300.0F) + 50;
    }
    return j;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.c = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    switch (paramMessage.what)
    {
    }
    do
    {
      return bool;
      bool = true;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a();
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    int j = (int)(paramMotionEvent.getX() + 0.5F);
    int k = (int)(paramMotionEvent.getY() + 0.5F);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      super.onTouchEvent(paramMotionEvent);
      return false;
      this.g = j;
      this.h = k;
      continue;
      this.e = -1;
      this.g = -1;
      this.f = -1;
      this.h = -1;
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter instanceof RecentAdapter))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = ((RecentAdapter)paramListAdapter);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.SwipListView
 * JD-Core Version:    0.7.0.1
 */