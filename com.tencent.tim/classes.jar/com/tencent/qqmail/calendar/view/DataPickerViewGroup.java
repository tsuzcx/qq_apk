package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.calendar.data.CalendarDayData;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import java.util.Calendar;

public class DataPickerViewGroup
  extends ViewGroup
  implements View.OnClickListener, CalendarScrollView.DateActionListener, CalendarScrollView.TimeLineViewListener, PopupFrame.IPopupContent, TimePicker.OnTimeChangedListener
{
  public static final int DATE = 0;
  public static final int TIME = 1;
  private MonthAdapter adapter;
  private boolean isDateChanged = false;
  private boolean isDateTabSwitched = false;
  private boolean isTimeTabSwitchedBack = false;
  private OffsetAnimationListener mAnimationListener;
  private LinearLayout mCalendarView;
  private int mContentLength;
  private Context mContext;
  private Button mDateButton;
  private CalendarScrollView mDatePicker;
  private DatePickerListener mDatePickerListener;
  private Button mDoneButton;
  private int mOffsetTop;
  private Calendar mOrignalTime;
  private PopupFrame mPopupFrame;
  private int mState = 0;
  private boolean mTabChanged;
  private LinearLayout mTabView;
  private Button mTimeButton;
  private TimePicker mTimePicker;
  private LinearLayout mWeekdayTitleView;
  private LinearLayout titleView;
  
  public DataPickerViewGroup(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public DataPickerViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    getLayoutParams();
    setLayoutParams(new FrameLayout.LayoutParams(paramContext, paramAttributeSet));
  }
  
  public DataPickerViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    getLayoutParams();
    setLayoutParams(new FrameLayout.LayoutParams(paramContext, paramAttributeSet));
  }
  
  private void doTranslateAnimation(View paramView, int paramInt)
  {
    Object localObject = paramView.getAnimation();
    if ((localObject instanceof TranslateValueAnimation))
    {
      localObject = (TranslateValueAnimation)localObject;
      ((TranslateValueAnimation)localObject).reStartValueAnimation(0.0F, ((TranslateValueAnimation)localObject).getToDeltaY() + paramInt);
    }
    for (;;)
    {
      ((TranslateValueAnimation)localObject).setFillAfter(true);
      ((TranslateValueAnimation)localObject).setDuration(250L);
      ((TranslateValueAnimation)localObject).setAnimationListener(this.mAnimationListener);
      paramView.startAnimation((Animation)localObject);
      return;
      localObject = new TranslateValueAnimation(0.0F, 0.0F, 0.0F, paramInt, 250L);
    }
  }
  
  private String getCalendarString(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append("年").append(paramInt2).append("月").append(paramInt3).append("日");
    return localStringBuilder.toString();
  }
  
  private TextView getSingleWeekdayTitle(int paramInt)
  {
    TextView localTextView = new TextView(this.mContext);
    if (QMCalendarUtil.isWeekendDay(paramInt)) {
      localTextView.setTextColor(getResources().getColor(2131165509));
    }
    for (;;)
    {
      localTextView.setTextSize(11.0F);
      localTextView.setText(QMCalendarUtil.getWeekStringForShort(paramInt));
      localTextView.setGravity(17);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      localLayoutParams.weight = 1.0F;
      localTextView.setLayoutParams(localLayoutParams);
      return localTextView;
      localTextView.setTextColor(getResources().getColor(2131165508));
    }
  }
  
  private void paddingWeekdayTitleView()
  {
    int j = QMCalendarManager.getInstance().getDefaultStartDayOfWeek() - 1;
    int i = 0;
    while (i < 7)
    {
      this.mWeekdayTitleView.addView(getSingleWeekdayTitle(j % 7 + 1));
      j += 1;
      i += 1;
    }
  }
  
  private void resetDataCollectionState()
  {
    this.isDateTabSwitched = false;
    this.isTimeTabSwitchedBack = false;
    this.isDateChanged = false;
  }
  
  public void changeTabSelected(int paramInt)
  {
    if (this.mState == paramInt) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      requestLayout();
      this.mState = paramInt;
      this.mTabChanged = true;
      return;
      this.mDateButton.setSelected(true);
      this.mTimeButton.setSelected(false);
      this.mCalendarView.setVisibility(0);
      this.mTimePicker.setVisibility(8);
      this.mCalendarView.requestLayout();
      continue;
      this.mTimeButton.setSelected(true);
      this.mDateButton.setSelected(false);
      this.mCalendarView.setVisibility(8);
      this.mTimePicker.setVisibility(0);
      this.mTimePicker.requestLayout();
    }
  }
  
  public void getHitRect(Rect paramRect)
  {
    super.getHitRect(paramRect);
    paramRect.set(paramRect.left, paramRect.top + this.mOffsetTop, paramRect.right, paramRect.bottom);
  }
  
  public String getLogEvent()
  {
    if (this.isDateChanged)
    {
      if (this.isTimeTabSwitchedBack) {
        return "Event_Calendar_Create_Select_Date_Then_Time";
      }
      return "Event_Calendar_Create_Date_With_Select";
    }
    if (this.isDateTabSwitched) {
      return "Event_Calendar_Create_Date_Without_Select";
    }
    return "Event_Calendar_Create_Only_Change_Time";
  }
  
  public void notifyAnimation(int paramInt)
  {
    if (this.mAnimationListener == null) {
      this.mAnimationListener = new OffsetAnimationListener(null);
    }
    paramInt = -paramInt;
    this.mOffsetTop += paramInt;
    OffsetAnimationListener localOffsetAnimationListener = this.mAnimationListener;
    OffsetAnimationListener.access$102(localOffsetAnimationListener, localOffsetAnimationListener.mOffsetY + paramInt);
    OffsetAnimationListener.access$202(this.mAnimationListener, true);
    if (this.titleView.getVisibility() == 0) {
      doTranslateAnimation(this.titleView, paramInt);
    }
    doTranslateAnimation(this.mTabView, paramInt);
    doTranslateAnimation(this.mCalendarView, paramInt);
  }
  
  public void notifyAnimation(int paramInt, float paramFloat) {}
  
  public void onBackPressed()
  {
    if (this.mDatePickerListener != null) {
      this.mDatePickerListener.onPickCancel(this.mOrignalTime);
    }
  }
  
  public void onChangeMonth(int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    int i = paramView.getId();
    if (i == 2131365590)
    {
      this.isDateTabSwitched = true;
      if (this.mState == 1) {
        changeTabSelected(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.mDatePicker.snapToSelectDay();
      continue;
      if (i == 2131379676)
      {
        if (this.isDateTabSwitched) {
          this.isTimeTabSwitchedBack = true;
        }
        changeTabSelected(1);
      }
      else if (i == 2131366030)
      {
        Calendar localCalendar = this.mDatePicker.getSelectedDay();
        localCalendar.set(localCalendar.get(1), localCalendar.get(2), localCalendar.get(5), this.mTimePicker.getCurrentHour().intValue(), this.mTimePicker.getCurrentMinute().intValue(), 0);
        if (this.mDatePickerListener != null) {
          bool = this.mDatePickerListener.onPickConfirm(localCalendar);
        }
        if (bool) {
          this.mPopupFrame.dismiss();
        }
      }
    }
  }
  
  public void onDayViewDoubleClick(int paramInt1, int paramInt2, CalendarDayData paramCalendarDayData, View paramView) {}
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.titleView = ((LinearLayout)findViewById(2131379670));
    this.mTabView = ((LinearLayout)findViewById(2131364170));
    this.mDateButton = ((Button)this.mTabView.findViewById(2131365590));
    this.mDateButton.setOnClickListener(this);
    Button localButton = this.mDateButton;
    if (this.mState == 0)
    {
      bool = true;
      localButton.setSelected(bool);
      this.mTimeButton = ((Button)this.mTabView.findViewById(2131379676));
      this.mTimeButton.setOnClickListener(this);
      localButton = this.mTimeButton;
      if (this.mState != 1) {
        break label344;
      }
    }
    label344:
    for (boolean bool = true;; bool = false)
    {
      localButton.setSelected(bool);
      this.mDoneButton = ((Button)this.mTabView.findViewById(2131366030));
      this.mDoneButton.setOnClickListener(this);
      this.mCalendarView = ((LinearLayout)findViewById(2131364174));
      this.mDatePicker = ((CalendarScrollView)this.mCalendarView.findViewById(2131365608));
      this.mWeekdayTitleView = ((LinearLayout)this.mCalendarView.findViewById(2131382191));
      paddingWeekdayTitleView();
      this.mTimePicker = ((TimePicker)findViewById(2131379689));
      this.mTimePicker.setIs24HourView(Boolean.valueOf(true));
      this.mTimePicker.setOnTimeChangedListener(this);
      int i = this.mTimePicker.getCurrentHour().intValue();
      int j = this.mTimePicker.getCurrentMinute().intValue();
      this.mTimeButton.setText(QMCalendarUtil.getTimeString(i, j));
      this.adapter = new MonthAdapter(this.mContext);
      this.adapter.setOnItemClickListener(this.mDatePicker);
      this.adapter.setIsGetScheduleDate(false);
      this.mDatePicker.setAdapter(this.adapter);
      this.mDatePicker.setDateActionListener(this);
      this.mDatePicker.setTimeLineViewListener(this);
      this.mDatePicker.setSeletedDayChangeAuto(false);
      return;
      bool = false;
      break;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 0;
    long l1 = System.currentTimeMillis();
    if ((paramBoolean) || (this.mTabChanged) || (this.mDatePicker.isForceRelayout()))
    {
      this.mOffsetTop = (this.mDatePicker.getMeasuredHeight() - this.mDatePicker.getCurrentMonthHeight());
      if (this.mCalendarView.getVisibility() == 0)
      {
        paramInt1 = (getWidth() - 6) / 7;
        paramInt1 = getWidth() - paramInt1 * 7 - 6;
        this.mDatePicker.setGridPaddingLeft(paramInt1 / 2);
        this.mDatePicker.setGridPaddingRight(paramInt1 / 2);
        this.mCalendarView.layout(0, this.mTabView.getMeasuredHeight() + this.titleView.getMeasuredHeight(), paramInt3, this.mTabView.getMeasuredHeight() + this.titleView.getMeasuredHeight() + this.mCalendarView.getMeasuredHeight());
        this.mCalendarView.offsetTopAndBottom(this.mOffsetTop);
        this.mTabView.layout(0, this.mOffsetTop + this.titleView.getMeasuredHeight(), paramInt3, this.mTabView.getMeasuredHeight() + this.mOffsetTop + this.titleView.getMeasuredHeight());
        this.titleView.layout(0, this.mOffsetTop, paramInt3, this.titleView.getMeasuredHeight() + this.mOffsetTop);
        this.mTabChanged = false;
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      Log.i("wuziyi", "View group onLayout:" + (l2 - l1));
      return;
      if (this.mTimePicker.getVisibility() != 0) {
        break;
      }
      this.mTimePicker.layout(0, this.mTabView.getMeasuredHeight() + this.titleView.getMeasuredHeight(), paramInt3, this.mTabView.getMeasuredHeight() + this.titleView.getMeasuredHeight() + this.mCalendarView.getMeasuredHeight() - this.mOffsetTop);
      this.mTimePicker.offsetTopAndBottom(this.mOffsetTop);
      break;
      paramInt2 = getChildCount();
      while (paramInt1 < paramInt2)
      {
        View localView = getChildAt(paramInt1);
        if ((localView.getVisibility() != 8) && (localView.isLayoutRequested())) {
          localView.layout(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onLongClickDate(CalendarDayData paramCalendarDayData, View paramView) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    measureChild(this.mCalendarView, paramInt1, paramInt2);
    this.mContentLength = this.mCalendarView.getMeasuredHeight();
    measureChild(this.mTabView, paramInt1, paramInt2);
    int k = this.mTabView.getMeasuredHeight();
    int m = this.mContentLength;
    measureChild(this.titleView, paramInt1, paramInt2);
    paramInt2 = this.titleView.getMeasuredHeight();
    this.mOffsetTop = (this.mDatePicker.getMeasuredHeight() - this.mDatePicker.getCurrentMonthHeight());
    measureChild(this.mTimePicker, paramInt1, View.MeasureSpec.makeMeasureSpec(this.mContentLength - this.mOffsetTop, j));
    setMeasuredDimension(i, k + m + paramInt2);
  }
  
  public void onPopupFrameDismiss(boolean paramBoolean, Animation.AnimationListener paramAnimationListener)
  {
    if (paramBoolean)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, getHeight());
      localTranslateAnimation.setDuration(200L);
      startAnimation(localTranslateAnimation);
      localTranslateAnimation.setAnimationListener(paramAnimationListener);
      return;
    }
    paramAnimationListener.onAnimationEnd(null);
  }
  
  public void onPopupFrameShow(boolean paramBoolean, Animation.AnimationListener paramAnimationListener)
  {
    if (paramBoolean)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, getHeight(), 0.0F);
      localTranslateAnimation.setDuration(200L);
      startAnimation(localTranslateAnimation);
      localTranslateAnimation.setAnimationListener(paramAnimationListener);
    }
    for (;;)
    {
      resetDataCollectionState();
      return;
      paramAnimationListener.onAnimationEnd(null);
    }
  }
  
  public void onSelectDate(int paramInt1, int paramInt2, CalendarDayData paramCalendarDayData, View paramView)
  {
    this.mDateButton.setText(getCalendarString(paramInt1, paramInt2, paramCalendarDayData.getDay()));
    if (this.mDatePickerListener != null)
    {
      paramView = this.mDatePicker.getSelectedDay();
      paramView.set(paramInt1, paramInt2 - 1, paramCalendarDayData.getDay(), this.mTimePicker.getCurrentHour().intValue(), this.mTimePicker.getCurrentMinute().intValue());
      this.mDatePickerListener.onSelectDate(paramInt1, paramInt2, paramCalendarDayData.getDay(), paramView);
    }
    this.isDateChanged = true;
  }
  
  public void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    this.mTimeButton.setText(QMCalendarUtil.getTimeString(paramInt1, paramInt2));
    if (this.mDatePickerListener != null)
    {
      paramTimePicker = this.mDatePicker.getSelectedDay();
      paramTimePicker.set(paramTimePicker.get(1), paramTimePicker.get(2), paramTimePicker.get(5), this.mTimePicker.getCurrentHour().intValue(), this.mTimePicker.getCurrentMinute().intValue());
      this.mDatePickerListener.onTimeChanged(paramInt1, paramInt2, paramTimePicker);
    }
  }
  
  public void onTimeChangedAfterScroll(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    this.mTimeButton.setText(QMCalendarUtil.getTimeString(paramInt1, paramInt2));
    if (this.mDatePickerListener != null)
    {
      paramTimePicker = this.mDatePicker.getSelectedDay();
      paramTimePicker.set(paramTimePicker.get(1), paramTimePicker.get(2), paramTimePicker.get(5), this.mTimePicker.getCurrentHour().intValue(), this.mTimePicker.getCurrentMinute().intValue());
      this.mDatePickerListener.onTimeChangedAfterScroll(paramInt1, paramInt2, paramTimePicker);
    }
  }
  
  public void onTouchContentOutRect()
  {
    if (this.mDatePickerListener != null) {
      this.mDatePickerListener.onPickCancel(this.mOrignalTime);
    }
  }
  
  public void setDataEnable(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mDateButton.getVisibility() != 0)) {
      this.mDateButton.setVisibility(0);
    }
    for (;;)
    {
      changeTabSelected(1);
      return;
      if ((!paramBoolean) && (this.mDateButton.getVisibility() == 0)) {
        this.mDateButton.setVisibility(8);
      }
    }
  }
  
  public void setDatePickerListener(DatePickerListener paramDatePickerListener)
  {
    this.mDatePickerListener = paramDatePickerListener;
  }
  
  public void setExpectTime(int paramInt1, int paramInt2)
  {
    this.mTimePicker.setExpectHour(Integer.valueOf(paramInt1));
    this.mTimePicker.setExpectMinute(Integer.valueOf(paramInt2));
  }
  
  public void setPopupFrame(PopupFrame paramPopupFrame)
  {
    this.mPopupFrame = paramPopupFrame;
  }
  
  public void setStartPageMonth(Calendar paramCalendar)
  {
    this.mOrignalTime = ((Calendar)paramCalendar.clone());
    this.mDatePicker.setSelectedDay(paramCalendar);
    this.mDateButton.setText(getCalendarString(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5)));
    int i = QMCalendarUtil.getDiffMonths(paramCalendar, Calendar.getInstance());
    this.mDatePicker.forceRelayout(i);
  }
  
  public void setTime(int paramInt1, int paramInt2)
  {
    this.mTimePicker.setCurrentHour(Integer.valueOf(paramInt1));
    this.mTimePicker.setCurrentMinute(Integer.valueOf(paramInt2));
  }
  
  public void setTimeEnable(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mTimeButton.getVisibility() != 0)) {
      this.mTimeButton.setVisibility(0);
    }
    for (;;)
    {
      changeTabSelected(0);
      return;
      if ((!paramBoolean) && (this.mTimeButton.getVisibility() == 0)) {
        this.mTimeButton.setVisibility(8);
      }
    }
  }
  
  public void setTitle(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((TextView)this.titleView.findViewById(2131379769)).setText(paramString);
    this.titleView.setVisibility(0);
    invalidate();
  }
  
  public void snapToDay(Calendar paramCalendar)
  {
    Calendar localCalendar = this.mDatePicker.getSelectedDay();
    localCalendar.set(1, paramCalendar.get(1));
    localCalendar.set(2, paramCalendar.get(2));
    localCalendar.set(5, paramCalendar.get(5));
    setStartPageMonth(localCalendar);
    this.mDatePicker.snapToSelectDay(paramCalendar);
  }
  
  public void snapToTime(Calendar paramCalendar)
  {
    Calendar localCalendar = this.mDatePicker.getSelectedDay();
    localCalendar.set(11, paramCalendar.get(11));
    localCalendar.set(12, paramCalendar.get(12));
    if (this.mState == 0)
    {
      setTime(localCalendar.get(11), localCalendar.get(12));
      return;
    }
    setExpectTime(localCalendar.get(11), localCalendar.get(12));
  }
  
  public static abstract interface DatePickerListener
  {
    public abstract void onPickCancel(Calendar paramCalendar);
    
    public abstract boolean onPickConfirm(Calendar paramCalendar);
    
    public abstract void onSelectDate(int paramInt1, int paramInt2, int paramInt3, Calendar paramCalendar);
    
    public abstract void onTimeChanged(int paramInt1, int paramInt2, Calendar paramCalendar);
    
    public abstract void onTimeChangedAfterScroll(int paramInt1, int paramInt2, Calendar paramCalendar);
  }
  
  class OffsetAnimationListener
    implements Animation.AnimationListener
  {
    private boolean isAnimating;
    private int mOffsetY;
    
    private OffsetAnimationListener() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (this.isAnimating)
      {
        this.isAnimating = false;
        DataPickerViewGroup.this.mTabView.clearAnimation();
        DataPickerViewGroup.this.mTabView.offsetTopAndBottom(this.mOffsetY);
        if (DataPickerViewGroup.this.titleView.getVisibility() == 0)
        {
          DataPickerViewGroup.this.titleView.clearAnimation();
          DataPickerViewGroup.this.titleView.offsetTopAndBottom(this.mOffsetY);
        }
        DataPickerViewGroup.this.mCalendarView.clearAnimation();
        DataPickerViewGroup.this.mCalendarView.offsetTopAndBottom(this.mOffsetY);
        this.mOffsetY = 0;
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.DataPickerViewGroup
 * JD-Core Version:    0.7.0.1
 */