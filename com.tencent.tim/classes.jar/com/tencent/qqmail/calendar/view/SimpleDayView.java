package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import com.tencent.qqmail.calendar.data.CalendarDayData;
import org.apache.commons.lang3.StringUtils;

public class SimpleDayView
  extends AbsDayView
{
  private CharSequence mMainString;
  private float mMainStringWidth;
  private Paint mYearPaint;
  private String mYearString;
  
  public SimpleDayView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SimpleDayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SimpleDayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void measureStringWidth()
  {
    int i = 0;
    Paint localPaint = new Paint();
    this.mMainStringWidth = 0.0F;
    if ((this.mMainString instanceof Spannable))
    {
      Spannable localSpannable = (Spannable)this.mMainString;
      AbsoluteSizeSpan[] arrayOfAbsoluteSizeSpan = (AbsoluteSizeSpan[])localSpannable.getSpans(0, localSpannable.length(), AbsoluteSizeSpan.class);
      while (i < arrayOfAbsoluteSizeSpan.length)
      {
        AbsoluteSizeSpan localAbsoluteSizeSpan = arrayOfAbsoluteSizeSpan[i];
        localPaint.setTextSize(localAbsoluteSizeSpan.getSize());
        int j = localSpannable.getSpanStart(localAbsoluteSizeSpan);
        int k = localSpannable.getSpanEnd(localAbsoluteSizeSpan);
        float f = this.mMainStringWidth;
        this.mMainStringWidth = (localPaint.measureText(localSpannable, j, k) + f);
        i += 1;
      }
    }
    localPaint.setTextSize(getResources().getDimension(2131299339));
    this.mMainStringWidth = localPaint.measureText(this.mMainString.toString());
  }
  
  protected void changeViewsToFocusStyle()
  {
    this.mDayPaint.setColor(DAY_FOCUS_COLOR);
    this.mYearPaint.setColor(DAY_FOCUS_COLOR);
  }
  
  protected void changeViewsToNormalStyle()
  {
    if (this.mIsToday)
    {
      this.mDayPaint.setColor(DAY_TODAY_NORMAL_COLOR);
      this.mYearPaint.setColor(DAY_TODAY_NORMAL_COLOR);
      return;
    }
    int i = this.mDayData.getDayOfWeek();
    if ((i == 6) || (i == 0))
    {
      this.mDayPaint.setColor(DAY_NORMAL_WEEKEND_COLOR);
      this.mYearPaint.setColor(DAY_NORMAL_WEEKEND_COLOR);
      return;
    }
    this.mDayPaint.setColor(DAY_NORMAL_WEEKDAY_COLOR);
    this.mYearPaint.setColor(DAY_NORMAL_WEEKDAY_COLOR);
  }
  
  protected void initPaint()
  {
    super.initPaint();
    this.mDayPaint.setTextSize(getResources().getDimension(2131299340));
    this.mDayPaint.setTextAlign(Paint.Align.LEFT);
    this.mYearPaint = new Paint();
    this.mYearPaint.setAntiAlias(true);
    this.mYearPaint.setColor(-16777216);
    this.mYearPaint.setStrokeWidth(3.0F);
    this.mYearPaint.setTextAlign(Paint.Align.CENTER);
    this.mYearPaint.setTextSize(getResources().getDimension(2131299342));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mVisibility != 0) || (this.mDayData == null)) {}
    do
    {
      return;
      if (this.mDayData.getDay() != 1) {
        break;
      }
    } while (!(this.mMainString instanceof Spannable));
    Object localObject2;
    int n;
    if (!StringUtils.isBlank(this.mYearString))
    {
      localObject1 = this.mDayPaint.getFontMetricsInt();
      localObject2 = this.mYearPaint.getFontMetricsInt();
      i = (this.mRect.height() - (((Paint.FontMetricsInt)localObject1).bottom - ((Paint.FontMetricsInt)localObject1).top) - (((Paint.FontMetricsInt)localObject2).bottom - ((Paint.FontMetricsInt)localObject2).top)) / 2;
      j = ((Paint.FontMetricsInt)localObject1).top;
      k = ((Paint.FontMetricsInt)localObject1).bottom;
      m = ((Paint.FontMetricsInt)localObject1).top;
      n = ((Paint.FontMetricsInt)localObject2).top;
      paramCanvas.drawText(this.mYearString, this.mRect.centerX(), k - m + i - n, this.mYearPaint);
      i -= j;
    }
    for (;;)
    {
      localObject1 = (Spannable)this.mMainString;
      localObject2 = (AbsoluteSizeSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), AbsoluteSizeSpan.class);
      k = (int)((this.mRect.width() - this.mMainStringWidth) / 2.0F);
      j = 0;
      while (j < localObject2.length)
      {
        Object localObject3 = localObject2[j];
        this.mDayPaint.setTextSize(localObject3.getSize());
        m = ((Spannable)localObject1).getSpanStart(localObject3);
        n = ((Spannable)localObject1).getSpanEnd(localObject3);
        paramCanvas.drawText((CharSequence)localObject1, ((Spannable)localObject1).getSpanStart(localObject3), ((Spannable)localObject1).getSpanEnd(localObject3), k, i, this.mDayPaint);
        k = (int)(k + this.mDayPaint.measureText((CharSequence)localObject1, m, n));
        j += 1;
      }
      localObject1 = this.mDayPaint.getFontMetricsInt();
      i = this.mRect.top + (this.mRect.height() - ((Paint.FontMetricsInt)localObject1).bottom + ((Paint.FontMetricsInt)localObject1).top) / 2 - ((Paint.FontMetricsInt)localObject1).top;
    }
    this.mDayPaint.setTextSize(localObject2[0].getSize());
    return;
    Object localObject1 = this.mDayPaint.getFontMetricsInt();
    int i = this.mRect.top;
    int j = (this.mRect.height() - ((Paint.FontMetricsInt)localObject1).bottom + ((Paint.FontMetricsInt)localObject1).top) / 2;
    int k = ((Paint.FontMetricsInt)localObject1).top;
    int m = (int)((this.mRect.width() - this.mMainStringWidth) / 2.0F);
    paramCanvas.drawText(this.mMainString.toString(), m, i + j - k, this.mDayPaint);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDayInfo(CalendarDayData paramCalendarDayData)
  {
    if (this.mDayData != paramCalendarDayData)
    {
      this.mDayData = paramCalendarDayData;
      this.mMainString = String.valueOf(this.mDayData.getDay());
      measureStringWidth();
    }
  }
  
  public void setMainText(CharSequence paramCharSequence)
  {
    this.mMainString = paramCharSequence;
    measureStringWidth();
  }
  
  public void setYearText(String paramString)
  {
    this.mYearString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.SimpleDayView
 * JD-Core Version:    0.7.0.1
 */