package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.watcher.ScheduleLoadWatcher;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ScheduleListView
  extends ListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private CalendarScrollView.CalenderListener mCalenderListener;
  private boolean mFullFillContent;
  private final int mItemHeight = getResources().getDimensionPixelSize(2131299344);
  private int mLastChildBottom;
  private boolean mLockTouch = false;
  private Rect mTemp;
  
  public ScheduleListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScheduleListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScheduleListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Drawable localDrawable = getDivider();
    int j = paramCanvas.getHeight();
    int i = paramCanvas.getWidth();
    if (this.mTemp == null) {
      this.mTemp = new Rect();
    }
    Rect localRect = this.mTemp;
    int k = getDividerHeight();
    localRect.left = getPaddingLeft();
    localRect.right = (i - getPaddingRight());
    localRect.top = 0;
    localRect.bottom = k;
    localDrawable.setBounds(localRect);
    localDrawable.draw(paramCanvas);
    if (!this.mFullFillContent)
    {
      i = this.mLastChildBottom + k;
      while (i < j)
      {
        localRect.top = (i + this.mItemHeight);
        localRect.bottom = (localRect.top + k);
        i = localRect.bottom;
        localDrawable.setBounds(localRect);
        localDrawable.draw(paramCanvas);
      }
    }
  }
  
  protected void layoutChildren()
  {
    super.layoutChildren();
    View localView = getChildAt(getChildCount() - 1);
    if (localView != null)
    {
      int i = localView.getBottom();
      if (i < getHeight() - getPaddingBottom() - getPaddingTop())
      {
        this.mLastChildBottom = i;
        this.mFullFillContent = false;
        return;
      }
      this.mFullFillContent = true;
      return;
    }
    this.mLastChildBottom = 0;
    this.mFullFillContent = false;
  }
  
  public void notifyDataSetChanged()
  {
    ((ScheduleListAdapter)getAdapter()).notifyDataSetChanged();
  }
  
  protected void onFinishInflate()
  {
    setOnItemClickListener(this);
    setOnItemLongClickListener(this);
    super.onFinishInflate();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.mCalenderListener != null)
    {
      ScheduleListAdapter.ViewHolder localViewHolder = (ScheduleListAdapter.ViewHolder)paramView.getTag();
      if (localViewHolder != null) {
        this.mCalenderListener.onScheduleItemClick(localViewHolder.getSchedule());
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ScheduleListAdapter.ViewHolder)paramView.getTag();
    return (this.mCalenderListener != null) && (paramAdapterView != null) && (this.mCalenderListener.onScheduleItemLongClick(paramAdapterView.getSchedule()));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (((ScheduleListAdapter)getAdapter()).isNoData())
    {
      this.mLockTouch = true;
      return;
    }
    this.mLockTouch = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLockTouch) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCalenderListener(CalendarScrollView.CalenderListener paramCalenderListener)
  {
    this.mCalenderListener = paramCalenderListener;
  }
  
  public void setNoSchedule()
  {
    ((ScheduleListAdapter)getAdapter()).clearData();
    this.mLockTouch = true;
  }
  
  public void updateSchedule(int paramInt1, int paramInt2, int paramInt3)
  {
    ScheduleListAdapter localScheduleListAdapter = (ScheduleListAdapter)getAdapter();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    localScheduleListAdapter.update(localGregorianCalendar);
  }
  
  public void updateScheduleAsyn(int paramInt1, int paramInt2, int paramInt3, ScheduleLoadWatcher paramScheduleLoadWatcher)
  {
    ScheduleListAdapter localScheduleListAdapter = (ScheduleListAdapter)getAdapter();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    localScheduleListAdapter.updateAsyn(localGregorianCalendar, paramScheduleLoadWatcher);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.ScheduleListView
 * JD-Core Version:    0.7.0.1
 */