package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.CalendarDayData;
import com.tencent.qqmail.calendar.data.QMCalendar;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import java.util.ArrayList;
import java.util.Calendar;
import org.apache.commons.lang3.StringUtils;

public class DaysGridAdapter
  extends BaseAdapter
{
  protected static Calendar sToday = ;
  protected Context mContext;
  protected QMCalendar mData;
  private boolean mDirtyData;
  protected int mFirstDayOfWeek;
  protected Calendar mSelectedDay = sToday;
  protected AbsDayView mSelectedView;
  private boolean mShowLunar;
  
  public DaysGridAdapter(Context paramContext, QMCalendar paramQMCalendar)
  {
    this.mData = paramQMCalendar;
    this.mContext = paramContext;
    this.mFirstDayOfWeek = QMCalendarManager.getInstance().getDefaultStartDayOfWeek();
    if (!StringUtils.isBlank(((CalendarDayData)this.mData.getDays().get(0)).getLunar())) {}
    for (boolean bool = true;; bool = false)
    {
      this.mShowLunar = bool;
      return;
    }
  }
  
  public int getCount()
  {
    return this.mData.getWeeks() * 7;
  }
  
  public CalendarDayData getItem(int paramInt)
  {
    ArrayList localArrayList = this.mData.getDays();
    int i = (((CalendarDayData)localArrayList.get(0)).getDayOfWeek() + 8 - this.mFirstDayOfWeek) % 7;
    if (paramInt < i) {
      return null;
    }
    if (paramInt - i >= localArrayList.size()) {
      return null;
    }
    return (CalendarDayData)localArrayList.get(paramInt - i);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getMonth()
  {
    return this.mData.getMonth();
  }
  
  public AbsDayView getSelectView()
  {
    return this.mSelectedView;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      if (this.mShowLunar) {
        paramView = new ScheduleLunarDayView(this.mContext);
      }
    }
    for (;;)
    {
      AbsDayView localAbsDayView = (AbsDayView)paramView;
      Object localObject1 = this.mData.getDays();
      int i = (((CalendarDayData)((ArrayList)localObject1).get(0)).getDayOfWeek() + 8 - this.mFirstDayOfWeek) % 7;
      if ((paramInt < i) || (paramInt - i >= ((ArrayList)localObject1).size()))
      {
        localAbsDayView.setContentVisibility(8);
        localAbsDayView.changeToNormalStyle();
        localAbsDayView.setIsToday(false);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localAbsDayView;
        paramView = new ScheduleDayView(this.mContext);
      }
      else
      {
        localAbsDayView.setContentVisibility(0);
        Object localObject2 = (CalendarDayData)((ArrayList)localObject1).get(paramInt - i);
        localAbsDayView.setDayInfo((CalendarDayData)localObject2);
        if (sToday == null) {
          sToday = Calendar.getInstance();
        }
        if ((sToday.get(1) == this.mData.getYear()) && (sToday.get(2) == this.mData.getMonth() - 1) && (sToday.get(5) == ((CalendarDayData)localObject2).getDay()))
        {
          localAbsDayView.setIsToday(true);
          label227:
          if ((this.mSelectedDay.get(1) != this.mData.getYear()) || (this.mSelectedDay.get(2) != this.mData.getMonth() - 1) || (this.mSelectedDay.get(5) != ((CalendarDayData)localObject2).getDay())) {
            break label384;
          }
          localAbsDayView.changeToFocusStyle(false);
          this.mSelectedView = localAbsDayView;
          label293:
          localObject1 = new StringBuilder();
          if (!localAbsDayView.isToday()) {
            break label392;
          }
          ((StringBuilder)localObject1).append("今天,");
        }
        for (;;)
        {
          localObject2 = ((CalendarDayData)localObject2).getLunar();
          if (localObject2 != null) {
            ((StringBuilder)localObject1).append((String)localObject2);
          }
          if (this.mSelectedView == localAbsDayView) {
            ((StringBuilder)localObject1).append(this.mContext.getString(2131720855));
          }
          localAbsDayView.setContentDescription(((StringBuilder)localObject1).toString());
          break;
          localAbsDayView.setIsToday(false);
          break label227;
          label384:
          localAbsDayView.changeToNormalStyle();
          break label293;
          label392:
          ((StringBuilder)localObject1).append(((CalendarDayData)localObject2).getDay()).append("号,");
        }
      }
    }
  }
  
  public int getYear()
  {
    return this.mData.getYear();
  }
  
  public boolean isDirtyData()
  {
    return this.mDirtyData;
  }
  
  public boolean isEnabled(int paramInt)
  {
    ArrayList localArrayList = this.mData.getDays();
    int i = (((CalendarDayData)localArrayList.get(0)).getDayOfWeek() + 8 - this.mFirstDayOfWeek) % 7;
    if (paramInt < i) {
      return false;
    }
    return paramInt - i < localArrayList.size();
  }
  
  public void release()
  {
    sToday = null;
  }
  
  public void setDirty()
  {
    this.mDirtyData = true;
  }
  
  public void setSelectedDay(Calendar paramCalendar)
  {
    this.mSelectedDay = paramCalendar;
  }
  
  public void updateMonth(QMCalendar paramQMCalendar)
  {
    if ((this.mDirtyData) || (this.mData.getYear() != paramQMCalendar.getYear()) || (this.mData.getMonth() != paramQMCalendar.getMonth()))
    {
      this.mData = paramQMCalendar;
      notifyDataSetChanged();
      this.mDirtyData = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.DaysGridAdapter
 * JD-Core Version:    0.7.0.1
 */