package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.CalendarDayData;
import com.tencent.qqmail.calendar.data.QMCalendar;
import com.tencent.qqmail.utilities.TextUtil;
import java.util.ArrayList;
import java.util.Calendar;

public class SimpleDaysGridAdapter
  extends DaysGridAdapter
{
  public SimpleDaysGridAdapter(Context paramContext, QMCalendar paramQMCalendar)
  {
    super(paramContext, paramQMCalendar);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = new SimpleDayView(this.mContext);
    }
    for (;;)
    {
      SimpleDayView localSimpleDayView = (SimpleDayView)paramView;
      Object localObject = this.mData.getDays();
      int i = (((CalendarDayData)((ArrayList)localObject).get(0)).getDayOfWeek() + 8 - this.mFirstDayOfWeek) % 7;
      if ((paramInt < i) || (paramInt - i >= ((ArrayList)localObject).size()))
      {
        localSimpleDayView.setContentVisibility(8);
        localSimpleDayView.setIsToday(false);
        localSimpleDayView.changeToNormalStyle();
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localSimpleDayView;
        localSimpleDayView.setContentVisibility(0);
        localObject = (CalendarDayData)((ArrayList)localObject).get(paramInt - i);
        localSimpleDayView.setDayInfo((CalendarDayData)localObject);
        if (sToday == null) {
          sToday = Calendar.getInstance();
        }
        if ((sToday.get(1) == this.mData.getYear()) && (sToday.get(2) == this.mData.getMonth() - 1) && (sToday.get(5) == ((CalendarDayData)localObject).getDay()))
        {
          localSimpleDayView.setIsToday(true);
          label205:
          if ((this.mSelectedDay.get(1) != this.mData.getYear()) || (this.mSelectedDay.get(2) != this.mData.getMonth() - 1) || (this.mSelectedDay.get(5) != ((CalendarDayData)localObject).getDay())) {
            break label385;
          }
          localSimpleDayView.changeToFocusStyle(false);
          this.mSelectedView = localSimpleDayView;
        }
        for (;;)
        {
          if (((CalendarDayData)localObject).getDay() != 1) {
            break label391;
          }
          localSimpleDayView.setMainText(TextUtil.makeCalendarMonthFirstDayTextStyle(String.valueOf(this.mData.getMonth()), (int)this.mContext.getResources().getDimension(2131299340), "月", (int)this.mContext.getResources().getDimension(2131299341)));
          if (sToday.get(1) == this.mData.getYear()) {
            break label393;
          }
          localSimpleDayView.setYearText(this.mData.getYear() + "年");
          break;
          localSimpleDayView.setIsToday(false);
          break label205;
          label385:
          localSimpleDayView.changeToNormalStyle();
        }
        label391:
        continue;
        label393:
        localSimpleDayView.setYearText("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.SimpleDaysGridAdapter
 * JD-Core Version:    0.7.0.1
 */