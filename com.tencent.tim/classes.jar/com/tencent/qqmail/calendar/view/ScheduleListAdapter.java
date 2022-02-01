package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.data.ScheduleListCursor;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.calendar.watcher.ScheduleLoadWatcher;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.commons.lang3.StringUtils;

public class ScheduleListAdapter
  extends BaseAdapter
{
  private static int NULL_SCHEDULE = 0;
  private static int SPECIFIC_SCHEDULE = 2;
  private static int TODAY_NONE_SCHEDULE = 1;
  private static String sAllDayText;
  private Context mContext;
  private ScheduleListCursor mCursor;
  private LayoutInflater mInflater;
  private boolean mIsNoData = true;
  private int viewTypeCount = 3;
  
  public ScheduleListAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mCursor = new ScheduleListCursor(Calendar.getInstance());
    if (sAllDayText == null) {
      sAllDayText = paramContext.getString(2131691112);
    }
  }
  
  public void clearData()
  {
    if (!this.mIsNoData)
    {
      this.mCursor.close();
      this.mIsNoData = true;
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    int i = this.mCursor.getCount();
    if (i <= 0)
    {
      this.mIsNoData = true;
      return 2;
    }
    this.mIsNoData = false;
    return i;
  }
  
  public QMSchedule getItem(int paramInt)
  {
    return this.mCursor.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.mIsNoData)
    {
      if (paramInt == 1) {
        return TODAY_NONE_SCHEDULE;
      }
      return NULL_SCHEDULE;
    }
    return SPECIFIC_SCHEDULE;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    Object localObject1;
    if (this.mIsNoData)
    {
      localObject2 = this.mInflater.inflate(2131558810, paramViewGroup, false);
      if (getItemViewType(paramInt) == NULL_SCHEDULE) {
        ((View)localObject2).findViewById(2131364164).setVisibility(4);
      }
      ((View)localObject2).setTag(null);
      paramView = (View)localObject2;
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    label171:
    QMSchedule localQMSchedule;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.mInflater.inflate(2131558808, paramViewGroup, false);
      localObject2 = new ViewHolder();
      ViewHolder.access$002((ViewHolder)localObject2, (TextView)paramView.findViewById(2131364167));
      ViewHolder.access$102((ViewHolder)localObject2, (TextView)paramView.findViewById(2131364166));
      ViewHolder.access$202((ViewHolder)localObject2, (TextView)paramView.findViewById(2131364165));
      ViewHolder.access$302((ViewHolder)localObject2, (ImageView)paramView.findViewById(2131368747));
      paramView.setTag(localObject2);
      localQMSchedule = getItem(paramInt);
      if (!localQMSchedule.isAllDay()) {
        break label345;
      }
      localObject1 = sAllDayText;
      label191:
      ((ViewHolder)localObject2).mTimeText.setVisibility(0);
      ((ViewHolder)localObject2).mTimeText.setText((CharSequence)localObject1);
      localObject1 = DrawBitmapUtil.drawCircle(this.mContext, localQMSchedule.getColor(), DrawBitmapUtil.CIRCLE_DIAMETER_NORMAL, Paint.Style.STROKE);
      ((ViewHolder)localObject2).mTimeText.setCompoundDrawables(null, null, (Drawable)localObject1, null);
      if (localQMSchedule.getCategory() != 3) {
        break label460;
      }
      ((ViewHolder)localObject2).mShareIcon.setVisibility(0);
      label261:
      ((ViewHolder)localObject2).mSubjectText.setVisibility(0);
      ((ViewHolder)localObject2).mSubjectText.setText(localQMSchedule.getSubject());
      if (StringUtils.isBlank(localQMSchedule.getLocation())) {
        break label473;
      }
      ((ViewHolder)localObject2).mLocationText.setVisibility(0);
      ((ViewHolder)localObject2).mLocationText.setText(localQMSchedule.getLocation());
    }
    for (;;)
    {
      ViewHolder.access$402((ViewHolder)localObject2, localQMSchedule);
      localObject1 = paramView;
      localObject2 = paramView;
      break;
      localObject2 = (ViewHolder)paramView.getTag();
      break label171;
      label345:
      GregorianCalendar localGregorianCalendar = new GregorianCalendar();
      localGregorianCalendar.setTimeInMillis(localQMSchedule.getStartTime());
      String str = QMCalendarUtil.getTimeString(localGregorianCalendar);
      localObject1 = str;
      if (localGregorianCalendar.get(11) + localGregorianCalendar.get(12) + localGregorianCalendar.get(13) != 0) {
        break label191;
      }
      localGregorianCalendar.setTimeInMillis(localQMSchedule.getEndTime());
      localObject1 = str;
      if (QMCalendarUtil.getDiffDays(localQMSchedule.getEventStartTime(), localQMSchedule.getEventEndTime()) == 0) {
        break label191;
      }
      localObject1 = QMCalendarUtil.getTimeString(localGregorianCalendar) + "\n结束";
      break label191;
      label460:
      ((ViewHolder)localObject2).mShareIcon.setVisibility(8);
      break label261;
      label473:
      ((ViewHolder)localObject2).mLocationText.setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return this.viewTypeCount;
  }
  
  public boolean isNoData()
  {
    return this.mIsNoData;
  }
  
  public void update(Calendar paramCalendar)
  {
    this.mCursor.update(paramCalendar);
    notifyDataSetChanged();
  }
  
  public void updateAsyn(Calendar paramCalendar, ScheduleLoadWatcher paramScheduleLoadWatcher)
  {
    this.mCursor.updateAsync(paramCalendar, paramScheduleLoadWatcher);
  }
  
  public class ViewHolder
  {
    private QMSchedule mInfo;
    private TextView mLocationText;
    private ImageView mShareIcon;
    private TextView mSubjectText;
    private TextView mTimeText;
    
    public ViewHolder() {}
    
    public QMSchedule getSchedule()
    {
      return this.mInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.ScheduleListAdapter
 * JD-Core Version:    0.7.0.1
 */