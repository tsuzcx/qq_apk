package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

public class WeekView
  extends LinearLayout
  implements View.OnClickListener
{
  private AdapterView.OnItemClickListener mItemClicklClickListener;
  
  public WeekView(Context paramContext)
  {
    super(paramContext);
    initViews();
  }
  
  public WeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViews();
  }
  
  private void initViews() {}
  
  public Calendar getWeekFirstDay()
  {
    return (Calendar)getChildAt(0).getTag();
  }
  
  public Calendar getWeekLastDay()
  {
    return (Calendar)getChildAt(getChildCount() - 1).getTag();
  }
  
  public void onClick(View paramView)
  {
    this.mItemClicklClickListener.onItemClick(null, paramView, 0, 0L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClicklClickListener = paramOnItemClickListener;
  }
  
  public void setTextViews(Calendar paramCalendar)
  {
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      TextView localTextView = (TextView)getChildAt(i);
      localTextView.setText(String.valueOf(paramCalendar.get(2) + 1 + "月" + paramCalendar.get(5)));
      Calendar localCalendar = (Calendar)paramCalendar.clone();
      localTextView.setTag(localCalendar);
      localTextView.setOnClickListener(this);
      if ((CalendarListView.sSelectedDay.get(1) == localCalendar.get(1)) && (CalendarListView.sSelectedDay.get(2) == localCalendar.get(2)) && (CalendarListView.sSelectedDay.get(5) == localCalendar.get(5))) {
        localTextView.setBackgroundColor(getResources().getColor(2131165503));
      }
      for (;;)
      {
        paramCalendar.add(5, 1);
        i += 1;
        if (i < j) {
          break;
        }
        return;
        localTextView.setBackgroundResource(2130851521);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.WeekView
 * JD-Core Version:    0.7.0.1
 */