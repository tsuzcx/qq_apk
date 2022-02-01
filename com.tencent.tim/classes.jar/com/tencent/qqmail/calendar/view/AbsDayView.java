package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qqmail.calendar.data.CalendarDayData;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public abstract class AbsDayView
  extends View
{
  protected static int DAY_FOCUS_COLOR;
  protected static int DAY_NORMAL_WEEKDAY_COLOR;
  protected static int DAY_NORMAL_WEEKEND_COLOR;
  protected static int DAY_TODAY_NORMAL_COLOR;
  protected static int HOLIDAY_RED_COLOR;
  protected static int MARK_FOCUS_COLOR;
  protected static int MARK_NORMAL_COLOR;
  protected static int MARK_TODAY_COLOR;
  protected Context mContext;
  protected CalendarDayData mDayData;
  protected Paint mDayPaint;
  protected boolean mIsSelected;
  protected boolean mIsToday;
  protected int mMarkPaddingTop;
  protected TransitionDrawable mNormalBg;
  protected Rect mRect;
  protected BitmapDrawable mScheduleMark;
  protected int mVisibility;
  
  public AbsDayView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initPaint();
    setMinimumHeight(QMUIKit.dpToPx(50));
    setBackgroundResource(2130851521);
    this.mNormalBg = ((TransitionDrawable)getBackground());
    this.mIsToday = false;
    paramContext = getContext().getResources();
    if (DAY_NORMAL_WEEKEND_COLOR == 0) {
      DAY_NORMAL_WEEKEND_COLOR = paramContext.getColor(2131165509);
    }
    if (DAY_NORMAL_WEEKDAY_COLOR == 0) {
      DAY_NORMAL_WEEKDAY_COLOR = paramContext.getColor(2131165508);
    }
    if (DAY_TODAY_NORMAL_COLOR == 0) {
      DAY_TODAY_NORMAL_COLOR = paramContext.getColor(2131165507);
    }
    if (DAY_FOCUS_COLOR == 0) {
      DAY_FOCUS_COLOR = paramContext.getColor(2131165506);
    }
    if (MARK_FOCUS_COLOR == 0) {
      MARK_FOCUS_COLOR = paramContext.getColor(2131165500);
    }
    if (MARK_NORMAL_COLOR == 0) {
      MARK_NORMAL_COLOR = paramContext.getColor(2131165499);
    }
    if (MARK_TODAY_COLOR == 0) {
      MARK_TODAY_COLOR = paramContext.getColor(2131165498);
    }
    if (HOLIDAY_RED_COLOR == 0) {
      HOLIDAY_RED_COLOR = paramContext.getColor(2131165512);
    }
  }
  
  public AbsDayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbsDayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void changeToFocusStyle(boolean paramBoolean)
  {
    if (!this.mIsSelected)
    {
      this.mIsSelected = true;
      if (!paramBoolean) {
        break label82;
      }
      this.mNormalBg.startTransition(100);
    }
    for (;;)
    {
      changeViewsToFocusStyle();
      String str1 = (String)getContentDescription();
      if (str1 != null)
      {
        String str2 = getContext().getString(2131720855);
        if (str1.indexOf(str2) < 0) {
          setContentDescription(str1 + str2);
        }
      }
      return;
      label82:
      this.mNormalBg.startTransition(0);
    }
  }
  
  public void changeToNormalStyle()
  {
    if (this.mIsSelected)
    {
      this.mIsSelected = false;
      this.mNormalBg.resetTransition();
    }
    if (getContentVisiblity() != 8) {
      changeViewsToNormalStyle();
    }
    String str = (String)getContentDescription();
    if (str != null) {
      setContentDescription(str.replace(getContext().getString(2131720855), ""));
    }
  }
  
  protected abstract void changeViewsToFocusStyle();
  
  protected abstract void changeViewsToNormalStyle();
  
  public int getContentVisiblity()
  {
    return this.mVisibility;
  }
  
  public CalendarDayData getDayInfo()
  {
    return this.mDayData;
  }
  
  public boolean hasSelected()
  {
    return this.mIsSelected;
  }
  
  protected void initPaint()
  {
    this.mDayPaint = new Paint();
    this.mDayPaint.setAntiAlias(true);
    this.mDayPaint.setColor(-16777216);
    this.mDayPaint.setStrokeWidth(3.0F);
    this.mDayPaint.setTextAlign(Paint.Align.CENTER);
  }
  
  public boolean isToday()
  {
    return this.mIsToday;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      if (this.mRect == null) {
        this.mRect = new Rect(0, 0, getWidth(), getHeight());
      }
    }
    else {
      return;
    }
    this.mRect.set(0, 0, getWidth(), getHeight());
  }
  
  public void setContentVisibility(int paramInt)
  {
    if (this.mVisibility != paramInt) {
      this.mVisibility = paramInt;
    }
  }
  
  public void setDayColor(int paramInt)
  {
    this.mDayPaint.setColor(paramInt);
  }
  
  public abstract void setDayInfo(CalendarDayData paramCalendarDayData);
  
  public void setDayTextSize(int paramInt)
  {
    this.mDayPaint.setTextSize(paramInt);
  }
  
  public void setIsToday(boolean paramBoolean)
  {
    if (this.mIsToday != paramBoolean)
    {
      this.mIsToday = paramBoolean;
      if (!paramBoolean) {
        break label49;
      }
    }
    label49:
    for (int i = this.mContext.getResources().getColor(2131165504);; i = this.mContext.getResources().getColor(2131165497))
    {
      this.mNormalBg.setDrawableByLayerId(2131364163, new ColorDrawable(i));
      return;
    }
  }
  
  public void setMarkPaddingTop(int paramInt)
  {
    this.mMarkPaddingTop = paramInt;
  }
  
  public void setScheduleMark(Drawable paramDrawable)
  {
    if (this.mScheduleMark != paramDrawable) {
      this.mScheduleMark = ((BitmapDrawable)paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.AbsDayView
 * JD-Core Version:    0.7.0.1
 */