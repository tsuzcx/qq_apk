package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.tencent.qqmail.calendar.data.CalendarDayData;

public class ScheduleDayView
  extends AbsDayView
{
  public ScheduleDayView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScheduleDayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScheduleDayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void changeViewsToFocusStyle()
  {
    this.mDayPaint.setColor(DAY_FOCUS_COLOR);
    if (this.mDayData.hasSchedule())
    {
      setScheduleMark(DrawBitmapUtil.drawCircle(this.mContext, MARK_FOCUS_COLOR, DrawBitmapUtil.CIRCLE_DIAMETER_SMALL, Paint.Style.FILL));
      return;
    }
    setScheduleMark(null);
  }
  
  protected void changeViewsToNormalStyle()
  {
    if (this.mIsToday) {
      this.mDayPaint.setColor(DAY_TODAY_NORMAL_COLOR);
    }
    while (this.mDayData.hasSchedule()) {
      if (this.mIsToday)
      {
        setScheduleMark(DrawBitmapUtil.drawCircle(this.mContext, MARK_TODAY_COLOR, DrawBitmapUtil.CIRCLE_DIAMETER_SMALL, Paint.Style.FILL));
        return;
        int i = this.mDayData.getDayOfWeek() + 1;
        if ((i == 7) || (i == 1)) {
          this.mDayPaint.setColor(DAY_NORMAL_WEEKEND_COLOR);
        } else {
          this.mDayPaint.setColor(DAY_NORMAL_WEEKDAY_COLOR);
        }
      }
      else
      {
        setScheduleMark(DrawBitmapUtil.drawCircle(this.mContext, MARK_NORMAL_COLOR, DrawBitmapUtil.CIRCLE_DIAMETER_SMALL, Paint.Style.FILL));
        return;
      }
    }
    setScheduleMark(null);
  }
  
  protected void initPaint()
  {
    super.initPaint();
    this.mDayPaint.setTextSize(getResources().getDimension(2131297693));
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.mVisibility != 0) || (this.mDayData == null)) {}
    Paint.FontMetricsInt localFontMetricsInt;
    int i;
    do
    {
      return;
      j = this.mDayData.getDay();
      localFontMetricsInt = this.mDayPaint.getFontMetricsInt();
      i = this.mRect.top + (this.mRect.height() - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top;
      paramCanvas.drawText(String.valueOf(j), this.mRect.centerX(), i, this.mDayPaint);
    } while (this.mScheduleMark == null);
    int j = (this.mRect.width() - this.mScheduleMark.getIntrinsicWidth()) / 2;
    int k = localFontMetricsInt.bottom;
    int m = this.mMarkPaddingTop;
    paramCanvas.drawBitmap(this.mScheduleMark.getBitmap(), j, k + i + m, null);
  }
  
  public void setDayInfo(CalendarDayData paramCalendarDayData)
  {
    if (this.mDayData != paramCalendarDayData) {
      this.mDayData = paramCalendarDayData;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.ScheduleDayView
 * JD-Core Version:    0.7.0.1
 */