package com.tencent.qqmail.calendar.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.CalendarDayData;
import com.tencent.qqmail.scroller.RowScroller;
import com.tencent.qqmail.scroller.RowScrollerListener;
import java.util.Calendar;

public class CalendarListView
  extends ScrollableGridView<RowScroller>
  implements RowScrollerListener
{
  public static Calendar sSelectedDay = ;
  private CalendarScrollView.DateActionListener mListener;
  private View mSelectedDay;
  
  public CalendarListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CalendarListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int getWeeksFromCurrentPages(Calendar paramCalendar, boolean paramBoolean1, boolean paramBoolean2)
  {
    Calendar localCalendar1 = (Calendar)paramCalendar.clone();
    Calendar localCalendar2 = (Calendar)paramCalendar.clone();
    localCalendar2.set(5, 1);
    int i = paramCalendar.get(2);
    int j = paramCalendar.get(5);
    paramCalendar.add(5, 6);
    if ((j == 1) || (i != paramCalendar.get(2))) {
      if (paramBoolean1) {
        if (i == paramCalendar.get(2)) {
          localCalendar2.add(2, 1);
        }
      }
    }
    long l;
    for (;;)
    {
      l = (localCalendar2.getTimeInMillis() - localCalendar1.getTimeInMillis()) / 86400000L;
      if (!paramBoolean1) {
        break;
      }
      return (int)(l / 7.0D);
      localCalendar2.add(2, 2);
      continue;
      if (i == paramCalendar.get(2))
      {
        localCalendar2.add(2, -1);
        continue;
        if (paramBoolean2)
        {
          if (paramBoolean1) {
            localCalendar2.add(2, 2);
          } else {
            localCalendar2.add(2, -1);
          }
        }
        else if (paramBoolean1) {
          localCalendar2.add(2, 1);
        }
      }
    }
    return (int)Math.floor(l / 7.0D);
  }
  
  @SuppressLint({"WrongCall"})
  protected void dispatchDraw(Canvas paramCanvas)
  {
    ((RowScroller)this.mScroller).onDraw(paramCanvas);
    paramCanvas.save();
    int i = getWidth();
    int j = Math.max(this.mMinHeight, getHeight());
    int k;
    if (isVerticalScroll())
    {
      k = getScrollY();
      paramCanvas.clipRect(0, k, i, j + k);
    }
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
      k = getScrollX();
      paramCanvas.clipRect(k, 0, i + k, j);
    }
  }
  
  public int getNextMonthRow()
  {
    return getWeeksFromCurrentPages((Calendar)((WeekView)getChildAt(0)).getWeekFirstDay().clone(), true, false) + getFirstItemPosition();
  }
  
  public int getPreviousMonthRow()
  {
    return getWeeksFromCurrentPages((Calendar)((WeekView)getChildAt(0)).getWeekFirstDay().clone(), false, false) + getFirstItemPosition();
  }
  
  protected void initScroller(Context paramContext)
  {
    this.mScroller = new RowScroller(paramContext, this);
  }
  
  protected void onChildAdd(View paramView) {}
  
  public void onFirstRowChanged(int paramInt1, int paramInt2) {}
  
  protected void onInitLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.mSelectedDay != paramView)
    {
      this.mSelectedDay.setBackgroundResource(2130851521);
      this.mSelectedDay = paramView;
      this.mSelectedDay.setBackgroundColor(getResources().getColor(2131165503));
      Calendar localCalendar = (Calendar)paramView.getTag();
      sSelectedDay = localCalendar;
      CalendarDayData localCalendarDayData = new CalendarDayData(localCalendar.get(5), 0, null, null, false);
      this.mListener.onSelectDate(localCalendar.get(1), localCalendar.get(2), localCalendarDayData, paramView);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      this.mRect.set(0, 0, getWidth(), getHeight());
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDateActionListener(CalendarScrollView.DateActionListener paramDateActionListener)
  {
    this.mListener = paramDateActionListener;
  }
  
  protected void setupScroller()
  {
    ((RowScroller)this.mScroller).setContentUnitSize(getChildAt(0).getHeight());
    super.setupScroller();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.CalendarListView
 * JD-Core Version:    0.7.0.1
 */