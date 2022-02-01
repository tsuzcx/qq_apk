package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class WeekAdapter
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private AdapterView.OnItemClickListener mItemClickListener;
  private Calendar mNow;
  
  public WeekAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mNow = Calendar.getInstance();
  }
  
  public static Calendar getSpecificSundayFromOffset(int paramInt1, int paramInt2, int paramInt3)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.set(1, paramInt1);
    localGregorianCalendar.set(2, paramInt2);
    localGregorianCalendar.set(5, 1);
    localGregorianCalendar.add(5, 1 - localGregorianCalendar.get(7));
    localGregorianCalendar.add(3, paramInt3);
    return localGregorianCalendar;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.mInflater.inflate(2131558813, null);
      paramView = (WeekView)localView;
      paramView.setOnItemClickListener(this.mItemClickListener);
      if (paramInt != 0) {
        break label98;
      }
      localView.setBackgroundColor(-65536);
    }
    for (;;)
    {
      paramView.setTextViews(getSpecificSundayFromOffset(this.mNow.get(1), this.mNow.get(2), paramInt));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      WeekView localWeekView = (WeekView)paramView;
      localView = paramView;
      paramView = localWeekView;
      break;
      label98:
      localView.setBackgroundColor(-1);
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mItemClickListener = paramOnItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.WeekAdapter
 * JD-Core Version:    0.7.0.1
 */