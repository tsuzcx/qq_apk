package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.calendar.util.QMLunarCalendarUtils;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import java.util.Calendar;

public class ScheduleTimeReadView
  extends LinearLayout
{
  private TextView mEndFirstLineTextView;
  private TextView mEndLunarTextView;
  private TextView mEndSecondLineTextView;
  private boolean mIsLunar;
  private boolean mIsSingleDay;
  private TextView mStartFirstLineTextView;
  private TextView mStartLunarTextView;
  private TextView mStartSecondLineTextView;
  
  public ScheduleTimeReadView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public ScheduleTimeReadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getAttrs(paramContext, paramAttributeSet);
    initUI();
  }
  
  private void getAttrs(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.scheduleTimeView);
    this.mIsSingleDay = paramContext.getBoolean(R.styleable.scheduleTimeView_issingleday, true);
    paramContext.recycle();
  }
  
  private void initUI()
  {
    setOrientation(1);
    removeAllViews();
    if (this.mIsSingleDay) {
      LayoutInflater.from(getContext()).inflate(2131563001, this, true);
    }
    for (;;)
    {
      this.mStartFirstLineTextView = ((TextView)findViewById(2131379671));
      this.mStartSecondLineTextView = ((TextView)findViewById(2131379673));
      this.mEndFirstLineTextView = ((TextView)findViewById(2131379667));
      this.mEndSecondLineTextView = ((TextView)findViewById(2131379669));
      this.mStartLunarTextView = ((TextView)findViewById(2131379672));
      this.mEndLunarTextView = ((TextView)findViewById(2131379668));
      return;
      LayoutInflater.from(getContext()).inflate(2131563000, this, true);
    }
  }
  
  private void setTextViewWithDate(TextView paramTextView, boolean paramBoolean, Calendar paramCalendar)
  {
    if (paramBoolean)
    {
      paramTextView.setText(QMCalendarUtil.getDayString(paramCalendar));
      paramTextView.setTextSize(16.0F);
      return;
    }
    paramTextView.setText(QMCalendarUtil.getMonthDayString(paramCalendar));
    paramTextView.setTextSize(16.0F);
  }
  
  private void setTextViewWithDateAndWeek(TextView paramTextView, boolean paramBoolean, Calendar paramCalendar)
  {
    if (paramBoolean)
    {
      paramTextView.setText(QMCalendarUtil.getDayString(paramCalendar) + " " + QMCalendarUtil.getWeekString(paramCalendar));
      paramTextView.setTextSize(13.0F);
      return;
    }
    paramTextView.setText(QMCalendarUtil.getMonthDayString(paramCalendar) + " " + QMCalendarUtil.getWeekString(paramCalendar));
    paramTextView.setTextSize(16.0F);
  }
  
  private void setTextViewWithDayOfWeek(TextView paramTextView, Calendar paramCalendar)
  {
    paramTextView.setText(QMCalendarUtil.getWeekString(paramCalendar));
    paramTextView.setTextSize(16.0F);
  }
  
  private void setTextViewWithTime(TextView paramTextView, long paramLong)
  {
    paramTextView.setText(DateExtension.getIcsHMFormat(paramLong));
    paramTextView.setTextSize(20.0F);
  }
  
  public void setTime(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong1);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong2);
    Calendar localCalendar2 = Calendar.getInstance();
    if ((((Calendar)localObject).get(1) != localCalendar2.get(1)) || (localCalendar1.get(1) != localCalendar2.get(1))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((paramBoolean1) && (paramLong1 != paramLong2)) {
        localCalendar1.add(13, -1);
      }
      boolean bool2;
      int i;
      if ((((Calendar)localObject).get(1) == localCalendar1.get(1)) && (((Calendar)localObject).get(2) == localCalendar1.get(2)) && (((Calendar)localObject).get(5) == localCalendar1.get(5)))
      {
        bool2 = true;
        if ((((Calendar)localObject).get(11) != localCalendar1.get(11)) || (((Calendar)localObject).get(12) != localCalendar1.get(12))) {
          break label250;
        }
        i = 1;
        label164:
        this.mIsSingleDay = bool2;
        this.mIsLunar = paramBoolean2;
        initUI();
        if (!paramBoolean1) {
          break label303;
        }
        if (!bool2) {
          break label256;
        }
        setTextViewWithDateAndWeek(this.mStartFirstLineTextView, bool1, (Calendar)localObject);
        this.mStartSecondLineTextView.setText(2131691112);
        this.mStartSecondLineTextView.setTextSize(16.0F);
        this.mEndFirstLineTextView.setVisibility(8);
        this.mEndSecondLineTextView.setVisibility(8);
      }
      for (;;)
      {
        if (paramBoolean2) {
          break label374;
        }
        return;
        bool2 = false;
        break;
        label250:
        i = 0;
        break label164;
        label256:
        setTextViewWithDate(this.mStartFirstLineTextView, bool1, (Calendar)localObject);
        setTextViewWithDayOfWeek(this.mStartSecondLineTextView, (Calendar)localObject);
        setTextViewWithDate(this.mEndFirstLineTextView, bool1, localCalendar1);
        setTextViewWithDayOfWeek(this.mEndSecondLineTextView, localCalendar1);
        continue;
        label303:
        setTextViewWithDateAndWeek(this.mStartFirstLineTextView, bool1, (Calendar)localObject);
        setTextViewWithTime(this.mStartSecondLineTextView, paramLong1);
        if (i != 0)
        {
          this.mEndFirstLineTextView.setVisibility(8);
          this.mEndSecondLineTextView.setVisibility(8);
        }
        else
        {
          setTextViewWithDateAndWeek(this.mEndFirstLineTextView, bool1, localCalendar1);
          setTextViewWithTime(this.mEndSecondLineTextView, paramLong2);
        }
      }
      label374:
      if (paramBoolean1)
      {
        if (bool2)
        {
          this.mStartLunarTextView.setVisibility(0);
          this.mStartLunarTextView.setText("农历 " + QMLunarCalendarUtils.getLunarDate(paramLong1, bool1));
          localObject = this.mStartLunarTextView;
          if (bool1) {}
          for (f = 13.0F;; f = 16.0F)
          {
            ((TextView)localObject).setTextSize(f);
            this.mEndLunarTextView.setVisibility(8);
            return;
          }
        }
        this.mStartLunarTextView.setVisibility(0);
        this.mStartLunarTextView.setText(QMLunarCalendarUtils.getLunarDate(paramLong1, bool1));
        this.mStartLunarTextView.setTextSize(16.0F);
        this.mEndLunarTextView.setVisibility(0);
        this.mEndLunarTextView.setText(QMLunarCalendarUtils.getLunarDate(paramLong2, bool1));
        this.mEndLunarTextView.setTextSize(16.0F);
        return;
      }
      if (bool2)
      {
        this.mStartLunarTextView.setVisibility(0);
        this.mStartLunarTextView.setText("农历 " + QMLunarCalendarUtils.getLunarDate(paramLong1, bool1));
        localObject = this.mStartLunarTextView;
        if (bool1)
        {
          f = 13.0F;
          ((TextView)localObject).setTextSize(f);
          this.mEndLunarTextView.setVisibility(8);
          this.mEndLunarTextView.setText(QMLunarCalendarUtils.getLunarDate(paramLong2, bool1));
          localObject = this.mEndLunarTextView;
          if (!bool1) {
            break label641;
          }
        }
        label641:
        for (f = 13.0F;; f = 16.0F)
        {
          ((TextView)localObject).setTextSize(f);
          return;
          f = 16.0F;
          break;
        }
      }
      this.mStartLunarTextView.setVisibility(0);
      this.mStartLunarTextView.setText(QMLunarCalendarUtils.getLunarDate(paramLong1, bool1));
      localObject = this.mStartLunarTextView;
      if (bool1)
      {
        f = 13.0F;
        ((TextView)localObject).setTextSize(f);
        this.mEndLunarTextView.setVisibility(0);
        this.mEndLunarTextView.setText(QMLunarCalendarUtils.getLunarDate(paramLong2, bool1));
        localObject = this.mEndLunarTextView;
        if (!bool1) {
          break label742;
        }
      }
      label742:
      for (float f = 13.0F;; f = 16.0F)
      {
        ((TextView)localObject).setTextSize(f);
        return;
        f = 16.0F;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.ScheduleTimeReadView
 * JD-Core Version:    0.7.0.1
 */