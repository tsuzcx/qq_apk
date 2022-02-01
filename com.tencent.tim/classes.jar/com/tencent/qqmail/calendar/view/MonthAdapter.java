package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.QMCalendar;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class MonthAdapter
  extends BaseAdapter
{
  private Context mContext;
  private ArrayList<DaysGridAdapter> mDayAdapters;
  private Calendar mFirstPageMonth;
  private boolean mIsGetScheduleDate = true;
  private AdapterView.OnItemLongClickListener mLongClickListener;
  private AdapterView.OnItemClickListener mOnItemClickListener;
  private Calendar mSelecedDay;
  
  public MonthAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mFirstPageMonth = Calendar.getInstance();
    this.mSelecedDay = this.mFirstPageMonth;
    this.mDayAdapters = new ArrayList();
  }
  
  public int getCalendarPosition(Calendar paramCalendar)
  {
    return (paramCalendar.get(1) - this.mFirstPageMonth.get(1)) * 12 + paramCalendar.get(2) - this.mFirstPageMonth.get(2);
  }
  
  public int getCount()
  {
    throw new UnsupportedOperationException();
  }
  
  public Object getItem(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getSelectPosition()
  {
    return (this.mSelecedDay.get(1) - this.mFirstPageMonth.get(1)) * 12 + this.mSelecedDay.get(2) - this.mFirstPageMonth.get(2);
  }
  
  public Calendar getSelectedDay()
  {
    return (Calendar)this.mSelecedDay.clone();
  }
  
  public int getTodayPosition()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = this.mFirstPageMonth.get(1);
    return localCalendar.get(2) + (i - j) * 12 - this.mFirstPageMonth.get(2);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (Calendar)this.mFirstPageMonth.clone();
    ((Calendar)localObject).add(2, paramInt);
    ((Calendar)localObject).set(5, 1);
    int i = ((Calendar)localObject).get(2);
    int j = ((Calendar)localObject).get(1);
    if (paramView == null)
    {
      paramView = QMCalendarManager.getInstance().getMonthlyCalendarData((Calendar)localObject, (Calendar)localObject, this.mIsGetScheduleDate);
      localObject = new DaysGridView(this.mContext);
      if (this.mIsGetScheduleDate)
      {
        paramView = new DaysGridAdapter(this.mContext, (QMCalendar)paramView.get(0));
        this.mDayAdapters.add(paramView);
        ((DaysGridView)localObject).setAdapter(paramView);
        ((DaysGridView)localObject).setNumColumns(7);
        ((DaysGridView)localObject).setHorizontalSpacing(1);
        ((DaysGridView)localObject).setVerticalSpacing(1);
        ((DaysGridView)localObject).setSelector(17170445);
        ((DaysGridView)localObject).setOnItemClickListener(this.mOnItemClickListener);
        ((DaysGridView)localObject).setOnItemLongClickListener(this.mLongClickListener);
        ((DaysGridView)localObject).setVerticalScrollBarEnabled(false);
        ((DaysGridView)localObject).setBackgroundColor(this.mContext.getResources().getColor(2131165501));
      }
    }
    for (;;)
    {
      paramView.setSelectedDay(this.mSelecedDay);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      paramView = new SimpleDaysGridAdapter(this.mContext, (QMCalendar)paramView.get(0));
      break;
      DaysGridAdapter localDaysGridAdapter = (DaysGridAdapter)((DaysGridView)paramView).getAdapter();
      if ((localDaysGridAdapter.isDirtyData()) || (localDaysGridAdapter.getYear() != j) || (localDaysGridAdapter.getMonth() != i + 1)) {
        localDaysGridAdapter.updateMonth((QMCalendar)QMCalendarManager.getInstance().getMonthlyCalendarData((Calendar)localObject, (Calendar)localObject, this.mIsGetScheduleDate).get(0));
      }
      localObject = paramView;
      paramView = localDaysGridAdapter;
    }
  }
  
  public void release()
  {
    Iterator localIterator = this.mDayAdapters.iterator();
    while (localIterator.hasNext()) {
      ((DaysGridAdapter)localIterator.next()).release();
    }
  }
  
  public void setDirty()
  {
    Iterator localIterator = this.mDayAdapters.iterator();
    while (localIterator.hasNext()) {
      ((DaysGridAdapter)localIterator.next()).setDirty();
    }
  }
  
  public void setIsGetScheduleDate(boolean paramBoolean)
  {
    this.mIsGetScheduleDate = paramBoolean;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.mLongClickListener = paramOnItemLongClickListener;
  }
  
  public void setSelectedDay(Calendar paramCalendar)
  {
    this.mSelecedDay = paramCalendar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.MonthAdapter
 * JD-Core Version:    0.7.0.1
 */