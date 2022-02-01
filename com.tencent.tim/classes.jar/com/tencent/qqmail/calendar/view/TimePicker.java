package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.androidqqmail.R.styleable;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TimePicker
  extends FrameLayout
{
  private static final boolean DEFAULT_ENABLED_STATE = true;
  private static final int DEFAULT_MINUTES_SPAN = 1;
  private static final int HOURS_IN_HALF_DAY = 12;
  private static final OnTimeChangedListener NO_OP_CHANGE_LISTENER = new TimePicker.1();
  private final Button mAmPmButton;
  private final NumberPicker mAmPmSpinner;
  private final EditText mAmPmSpinnerInput;
  private final String[] mAmPmStrings;
  private Locale mCurrentLocale;
  private final TextView mDivider;
  private final NumberPicker mHourSpinner;
  private final EditText mHourSpinnerInput;
  private boolean mIs24HourView = true;
  private boolean mIsAm;
  private boolean mIsEnabled = true;
  private int mMinuteSpan;
  private final NumberPicker mMinuteSpinner;
  private final EditText mMinuteSpinnerInput;
  private OnTimeChangedListener mOnTimeChangedListener;
  private Calendar mTempCalendar;
  
  public TimePicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TimePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131035444);
  }
  
  public TimePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setCurrentLocale(Locale.getDefault());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TimePicker, paramInt, 0);
    int i = paramAttributeSet.getResourceId(R.styleable.TimePicker_defaultlayout, 2131563213);
    this.mMinuteSpan = paramAttributeSet.getInt(R.styleable.TimePicker_minutesspan, 1);
    if (60 % this.mMinuteSpan != 0) {
      throw new IllegalArgumentException("mMinuteSpan is error");
    }
    String[] arrayOfString = new String[60 / this.mMinuteSpan];
    paramInt = 0;
    while (paramInt < arrayOfString.length)
    {
      arrayOfString[paramInt] = NumberPicker.getTwoDigitFormatter().format(this.mMinuteSpan * paramInt);
      paramInt += 1;
    }
    paramAttributeSet.recycle();
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(i, this, true);
    this.mHourSpinner = ((NumberPicker)findViewById(2131368669));
    this.mHourSpinner.setWrapSelectorWheel(true);
    this.mHourSpinner.setOnValueChangedListener(new TimePicker.2(this));
    this.mHourSpinnerInput = ((EditText)this.mHourSpinner.findViewById(2131372563));
    this.mHourSpinnerInput.setImeOptions(5);
    this.mHourSpinnerInput.setFocusable(false);
    this.mDivider = ((TextView)findViewById(2131365990));
    if (this.mDivider != null) {
      this.mDivider.setText(2131721100);
    }
    this.mMinuteSpinner = ((NumberPicker)findViewById(2131371857));
    this.mMinuteSpinner.setMinValue(0);
    this.mMinuteSpinner.setMaxValue(60 / this.mMinuteSpan - 1);
    this.mMinuteSpinner.setOnLongPressUpdateInterval(100L);
    this.mMinuteSpinner.setDisplayedValues(arrayOfString);
    this.mMinuteSpinner.setWrapSelectorWheel(true);
    this.mMinuteSpinner.setOnValueChangedListener(new TimePicker.3(this));
    this.mMinuteSpinnerInput = ((EditText)this.mMinuteSpinner.findViewById(2131372563));
    this.mMinuteSpinnerInput.setImeOptions(5);
    this.mMinuteSpinnerInput.setFocusable(false);
    this.mAmPmStrings = new DateFormatSymbols().getAmPmStrings();
    paramContext = findViewById(2131362697);
    if ((paramContext instanceof Button))
    {
      this.mAmPmSpinner = null;
      this.mAmPmSpinnerInput = null;
      this.mAmPmButton = ((Button)paramContext);
      this.mAmPmButton.setOnClickListener(new TimePicker.4(this));
    }
    for (;;)
    {
      updateHourControl();
      updateAmPmControl();
      setOnTimeChangedListener(NO_OP_CHANGE_LISTENER);
      setCurrentHour(Integer.valueOf(this.mTempCalendar.get(11)));
      setCurrentMinute(Integer.valueOf(this.mTempCalendar.get(12)));
      if (!isEnabled()) {
        setEnabled(false);
      }
      setContentDescriptions();
      if ((Build.VERSION.SDK_INT >= 16) && (getImportantForAccessibility() == 0)) {
        setImportantForAccessibility(1);
      }
      return;
      this.mAmPmButton = null;
      this.mAmPmSpinner = ((NumberPicker)paramContext);
      this.mAmPmSpinner.setMinValue(0);
      this.mAmPmSpinner.setMaxValue(1);
      this.mAmPmSpinner.setDisplayedValues(this.mAmPmStrings);
      this.mAmPmSpinner.setOnValueChangedListener(new TimePicker.5(this));
      this.mAmPmSpinnerInput = ((EditText)this.mAmPmSpinner.findViewById(2131372563));
      this.mAmPmSpinnerInput.setImeOptions(6);
    }
  }
  
  private void onTimeChanged()
  {
    sendAccessibilityEvent(4);
    if (this.mOnTimeChangedListener != null) {
      this.mOnTimeChangedListener.onTimeChanged(this, getCurrentHour().intValue(), getCurrentMinute().intValue());
    }
  }
  
  private void onTimeChangedAfterScroll()
  {
    sendAccessibilityEvent(4);
    if (this.mOnTimeChangedListener != null) {
      this.mOnTimeChangedListener.onTimeChangedAfterScroll(this, getCurrentHour().intValue(), getCurrentMinute().intValue());
    }
  }
  
  private void setContentDescriptions() {}
  
  private void setCurrentLocale(Locale paramLocale)
  {
    if (paramLocale.equals(this.mCurrentLocale)) {
      return;
    }
    this.mCurrentLocale = paramLocale;
    this.mTempCalendar = Calendar.getInstance(paramLocale);
  }
  
  private void trySetContentDescription(View paramView, int paramInt1, int paramInt2)
  {
    paramView = paramView.findViewById(paramInt1);
    if (paramView != null) {
      paramView.setContentDescription(getContext().getString(paramInt2));
    }
  }
  
  private void updateAmPmControl()
  {
    if (is24HourView()) {
      if (this.mAmPmSpinner != null) {
        this.mAmPmSpinner.setVisibility(8);
      }
    }
    for (;;)
    {
      sendAccessibilityEvent(4);
      return;
      this.mAmPmButton.setVisibility(8);
      continue;
      if (this.mIsAm) {}
      for (int i = 0;; i = 1)
      {
        if (this.mAmPmSpinner == null) {
          break label81;
        }
        this.mAmPmSpinner.setValue(i);
        this.mAmPmSpinner.setVisibility(0);
        break;
      }
      label81:
      this.mAmPmButton.setText(this.mAmPmStrings[i]);
      this.mAmPmButton.setVisibility(0);
    }
  }
  
  private void updateHourControl()
  {
    if (is24HourView())
    {
      this.mHourSpinner.setMinValue(0);
      this.mHourSpinner.setMaxValue(23);
      this.mHourSpinner.setFormatter(NumberPicker.getTwoDigitFormatter());
      return;
    }
    this.mHourSpinner.setMinValue(1);
    this.mHourSpinner.setMaxValue(12);
    this.mHourSpinner.setFormatter(null);
  }
  
  private void updateInputState()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      if (!localInputMethodManager.isActive(this.mHourSpinnerInput)) {
        break label47;
      }
      this.mHourSpinnerInput.clearFocus();
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
    label47:
    do
    {
      return;
      if (localInputMethodManager.isActive(this.mMinuteSpinnerInput))
      {
        this.mMinuteSpinnerInput.clearFocus();
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
    } while (!localInputMethodManager.isActive(this.mAmPmSpinnerInput));
    this.mAmPmSpinnerInput.clearFocus();
    localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    return true;
  }
  
  public int getBaseline()
  {
    return this.mHourSpinner.getBaseline();
  }
  
  public Integer getCurrentHour()
  {
    int i = this.mHourSpinner.getValue();
    if (is24HourView()) {
      return Integer.valueOf(i);
    }
    if (this.mIsAm) {
      return Integer.valueOf(i % 12);
    }
    return Integer.valueOf(i % 12 + 12);
  }
  
  public Integer getCurrentMinute()
  {
    return Integer.valueOf(this.mMinuteSpinner.getValue() * this.mMinuteSpan);
  }
  
  public boolean is24HourView()
  {
    return this.mIs24HourView;
  }
  
  public boolean isEnabled()
  {
    return this.mIsEnabled;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    setCurrentLocale(paramConfiguration.locale);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(TimePicker.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(TimePicker.class.getName());
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (this.mIs24HourView) {}
    for (int i = 129;; i = 65)
    {
      this.mTempCalendar.set(11, getCurrentHour().intValue());
      this.mTempCalendar.set(12, getCurrentMinute().intValue());
      String str = DateUtils.formatDateTime(getContext(), this.mTempCalendar.getTimeInMillis(), i);
      paramAccessibilityEvent.getText().add(str);
      return;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentHour(Integer.valueOf(paramParcelable.getHour()));
    setCurrentMinute(Integer.valueOf(paramParcelable.getMinute()));
  }
  
  protected Parcelable onSaveInstanceState()
  {
    return new SavedState(super.onSaveInstanceState(), getCurrentHour().intValue(), getCurrentMinute().intValue(), null);
  }
  
  public void setCurrentHour(Integer paramInteger)
  {
    if ((paramInteger == null) || (paramInteger == getCurrentHour())) {
      return;
    }
    Integer localInteger = paramInteger;
    if (!is24HourView())
    {
      if (paramInteger.intValue() < 12) {
        break label78;
      }
      this.mIsAm = false;
      localInteger = paramInteger;
      if (paramInteger.intValue() > 12) {
        localInteger = Integer.valueOf(paramInteger.intValue() - 12);
      }
    }
    for (;;)
    {
      updateAmPmControl();
      this.mHourSpinner.setValue(localInteger.intValue());
      onTimeChanged();
      return;
      label78:
      this.mIsAm = true;
      localInteger = paramInteger;
      if (paramInteger.intValue() == 0) {
        localInteger = Integer.valueOf(12);
      }
    }
  }
  
  public void setCurrentMinute(Integer paramInteger)
  {
    if (paramInteger == getCurrentMinute()) {
      return;
    }
    this.mMinuteSpinner.setValue(paramInteger.intValue() / this.mMinuteSpan);
    onTimeChanged();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.mIsEnabled == paramBoolean) {
      return;
    }
    super.setEnabled(paramBoolean);
    this.mMinuteSpinner.setEnabled(paramBoolean);
    if (this.mDivider != null) {
      this.mDivider.setEnabled(paramBoolean);
    }
    this.mHourSpinner.setEnabled(paramBoolean);
    if (this.mAmPmSpinner != null) {
      this.mAmPmSpinner.setEnabled(paramBoolean);
    }
    for (;;)
    {
      this.mIsEnabled = paramBoolean;
      return;
      this.mAmPmButton.setEnabled(paramBoolean);
    }
  }
  
  public void setExpectHour(Integer paramInteger)
  {
    if ((paramInteger == null) || (paramInteger == getCurrentHour())) {
      return;
    }
    Integer localInteger = paramInteger;
    if (!is24HourView())
    {
      if (paramInteger.intValue() < 12) {
        break label74;
      }
      this.mIsAm = false;
      localInteger = paramInteger;
      if (paramInteger.intValue() > 12) {
        localInteger = Integer.valueOf(paramInteger.intValue() - 12);
      }
    }
    for (;;)
    {
      updateAmPmControl();
      this.mHourSpinner.setExpectValueAfterScroller(localInteger.intValue());
      return;
      label74:
      this.mIsAm = true;
      localInteger = paramInteger;
      if (paramInteger.intValue() == 0) {
        localInteger = Integer.valueOf(12);
      }
    }
  }
  
  public void setExpectMinute(Integer paramInteger)
  {
    if (paramInteger == getCurrentMinute()) {
      return;
    }
    this.mMinuteSpinner.setExpectValueAfterScroller(paramInteger.intValue() / this.mMinuteSpan);
  }
  
  public void setIs24HourView(Boolean paramBoolean)
  {
    if (this.mIs24HourView == paramBoolean.booleanValue()) {
      return;
    }
    this.mIs24HourView = paramBoolean.booleanValue();
    int i = getCurrentHour().intValue();
    updateHourControl();
    setCurrentHour(Integer.valueOf(i));
    updateAmPmControl();
  }
  
  public void setNumuteSpan(int paramInt)
  {
    this.mMinuteSpan = paramInt;
    if (60 % this.mMinuteSpan != 0) {
      throw new IllegalArgumentException("mMinuteSpan is error");
    }
    String[] arrayOfString = new String[60 / this.mMinuteSpan];
    paramInt = 0;
    while (paramInt < arrayOfString.length)
    {
      arrayOfString[paramInt] = NumberPicker.getTwoDigitFormatter().format(this.mMinuteSpan * paramInt);
      paramInt += 1;
    }
    this.mMinuteSpinner.setMaxValue(60 / this.mMinuteSpan - 1);
    this.mMinuteSpinner.setDisplayedValues(arrayOfString);
  }
  
  public void setOnTimeChangedListener(OnTimeChangedListener paramOnTimeChangedListener)
  {
    this.mOnTimeChangedListener = paramOnTimeChangedListener;
  }
  
  public static abstract interface OnTimeChangedListener
  {
    public abstract void onTimeChanged(TimePicker paramTimePicker, int paramInt1, int paramInt2);
    
    public abstract void onTimeChangedAfterScroll(TimePicker paramTimePicker, int paramInt1, int paramInt2);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new TimePicker.SavedState.1();
    private final int mHour;
    private final int mMinute;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.mHour = paramParcel.readInt();
      this.mMinute = paramParcel.readInt();
    }
    
    private SavedState(Parcelable paramParcelable, int paramInt1, int paramInt2)
    {
      super();
      this.mHour = paramInt1;
      this.mMinute = paramInt2;
    }
    
    public int getHour()
    {
      return this.mHour;
    }
    
    public int getMinute()
    {
      return this.mMinute;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.mHour);
      paramParcel.writeInt(this.mMinute);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.TimePicker
 * JD-Core Version:    0.7.0.1
 */