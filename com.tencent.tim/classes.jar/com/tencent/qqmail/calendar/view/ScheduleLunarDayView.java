package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.qqmail.calendar.data.CalendarDayData;
import com.tencent.qqmail.calendar.data.QMHolidayCalendar;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class ScheduleLunarDayView
  extends AbsDayView
{
  private static final int GAP = QMUIKit.dpToPx(-3);
  private static final int PADDING_TOP_OFFSET = QMUIKit.dpToPx(-2);
  private Paint mHolidayPaint;
  private boolean mIsLunarFirstDayOfMonth;
  private Paint mLunarPaint;
  
  public ScheduleLunarDayView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScheduleLunarDayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScheduleLunarDayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void changeViewsToFocusStyle()
  {
    this.mDayPaint.setColor(DAY_FOCUS_COLOR);
    this.mLunarPaint.setColor(DAY_FOCUS_COLOR);
    Drawable localDrawable = null;
    if (this.mDayData.hasSchedule())
    {
      int i = MARK_FOCUS_COLOR;
      localDrawable = DrawBitmapUtil.drawCircle(this.mContext, i, DrawBitmapUtil.CIRCLE_DIAMETER_SMALL, Paint.Style.FILL);
    }
    setScheduleMark(localDrawable);
  }
  
  protected void changeViewsToNormalStyle()
  {
    Drawable localDrawable;
    if (this.mIsToday)
    {
      this.mDayPaint.setColor(DAY_TODAY_NORMAL_COLOR);
      this.mLunarPaint.setColor(DAY_TODAY_NORMAL_COLOR);
      localDrawable = null;
      if (this.mDayData.hasSchedule()) {
        if (!this.mIsToday) {
          break label155;
        }
      }
    }
    label153:
    label155:
    for (int i = MARK_TODAY_COLOR;; i = MARK_NORMAL_COLOR)
    {
      localDrawable = DrawBitmapUtil.drawCircle(this.mContext, i, DrawBitmapUtil.CIRCLE_DIAMETER_SMALL, Paint.Style.FILL);
      setScheduleMark(localDrawable);
      return;
      i = this.mDayData.getDayOfWeek() + 1;
      if ((i == 7) || (i == 1))
      {
        this.mDayPaint.setColor(DAY_NORMAL_WEEKEND_COLOR);
        this.mLunarPaint.setColor(DAY_NORMAL_WEEKEND_COLOR);
      }
      for (;;)
      {
        if (!this.mIsLunarFirstDayOfMonth) {
          break label153;
        }
        this.mLunarPaint.setColor(DAY_TODAY_NORMAL_COLOR);
        break;
        this.mDayPaint.setColor(DAY_NORMAL_WEEKDAY_COLOR);
        this.mLunarPaint.setColor(DAY_NORMAL_WEEKDAY_COLOR);
      }
      break;
    }
  }
  
  protected void initPaint()
  {
    super.initPaint();
    this.mDayPaint.setTextSize(getResources().getDimension(2131297693));
    this.mLunarPaint = new Paint();
    this.mLunarPaint.setAntiAlias(true);
    this.mLunarPaint.setColor(-16777216);
    this.mLunarPaint.setStrokeWidth(3.0F);
    this.mLunarPaint.setTextAlign(Paint.Align.CENTER);
    this.mLunarPaint.setTextSize(getResources().getDimension(2131297694));
    this.mHolidayPaint = new Paint();
    this.mHolidayPaint.setAntiAlias(true);
    this.mHolidayPaint.setStrokeWidth(3.0F);
    this.mHolidayPaint.setTextAlign(Paint.Align.CENTER);
    this.mHolidayPaint.setTextSize(getResources().getDimension(2131297694));
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.mVisibility != 0) || (this.mDayData == null)) {}
    do
    {
      return;
      j = this.mDayData.getDay();
      localObject = this.mDayData.getLunar();
      Paint.FontMetricsInt localFontMetricsInt1 = this.mDayPaint.getFontMetricsInt();
      Paint.FontMetricsInt localFontMetricsInt2 = this.mLunarPaint.getFontMetricsInt();
      k = (this.mRect.height() - (localFontMetricsInt1.bottom - localFontMetricsInt1.top) - (localFontMetricsInt2.bottom - localFontMetricsInt2.top) - GAP) / 2 + PADDING_TOP_OFFSET;
      m = localFontMetricsInt1.top;
      i = localFontMetricsInt1.bottom - localFontMetricsInt1.top + k - localFontMetricsInt2.top + GAP;
      paramCanvas.drawText(String.valueOf(j), this.mRect.centerX(), k - m, this.mDayPaint);
      paramCanvas.drawText((String)localObject, this.mRect.centerX(), i, this.mLunarPaint);
      if (this.mScheduleMark != null)
      {
        j = (this.mRect.width() - this.mScheduleMark.getIntrinsicWidth()) / 2;
        k = localFontMetricsInt2.bottom;
        m = this.mMarkPaddingTop;
        paramCanvas.drawBitmap(this.mScheduleMark.getBitmap(), j, k + i + m, null);
      }
    } while (this.mDayData.getHolidayCalendar() == null);
    Object localObject = this.mHolidayPaint.getFontMetricsInt();
    int i = this.mRect.width();
    int j = (((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2;
    int k = GAP;
    int m = ((Paint.FontMetricsInt)localObject).bottom;
    int n = ((Paint.FontMetricsInt)localObject).top;
    if (this.mDayData.getHolidayCalendar().isHoliday()) {
      this.mHolidayPaint.setColor(HOLIDAY_RED_COLOR);
    }
    for (;;)
    {
      paramCanvas.drawText(this.mDayData.getHolidayCalendar().getHolidayTag(), i - j + k, m - n, this.mHolidayPaint);
      return;
      this.mHolidayPaint.setColor(DAY_NORMAL_WEEKEND_COLOR);
    }
  }
  
  public void setDayInfo(CalendarDayData paramCalendarDayData)
  {
    if (this.mDayData != paramCalendarDayData)
    {
      this.mDayData = paramCalendarDayData;
      this.mIsLunarFirstDayOfMonth = paramCalendarDayData.isLunarFirstDayOfMonth();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.ScheduleLunarDayView
 * JD-Core Version:    0.7.0.1
 */