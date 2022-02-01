package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.scroller.NumberPickerScroller;
import java.text.DecimalFormatSymbols;
import java.util.Formatter;
import java.util.Locale;

public class NumberPicker
  extends LinearLayout
{
  private static final int DEFAULT_LAYOUT_RESOURCE_ID = 0;
  private static final long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300L;
  private static final char[] DIGIT_CHARACTERS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 1632, 1633, 1634, 1635, 1636, 1637, 1638, 1639, 1640, 1641, 1776, 1777, 1778, 1779, 1780, 1781, 1782, 1783, 1784, 1785 };
  private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
  private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 8;
  private static final int SIZE_UNSPECIFIED = -1;
  private static final int SNAP_SCROLL_DURATION = 300;
  private static final float TOP_AND_BOTTOM_FADING_EDGE_STRENGTH = 0.9F;
  private static final int UNSCALED_DEFAULT_SELECTION_DIVIDERS_DISTANCE = 48;
  private static final int UNSCALED_DEFAULT_SELECTION_DIVIDER_HEIGHT = 2;
  private static final TwoDigitFormatter sTwoDigitFormatter = new TwoDigitFormatter();
  private int expectNumberAfterScroll = -1;
  private final NumberPickerScroller mAdjustScroller;
  private boolean mAutoFitHeight;
  private BeginSoftInputOnLongPressCommand mBeginSoftInputOnLongPressCommand;
  private int mBottomSelectionDividerBottom;
  private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
  private final boolean mComputeMaxWidth;
  private int mCurrentScrollOffset;
  private final ImageButton mDecrementButton;
  private boolean mDecrementVirtualButtonPressed;
  private String[] mDisplayedValues;
  private final NumberPickerScroller mFlingScroller;
  private Formatter mFormatter;
  private final boolean mHasSelectorWheel;
  private final ImageButton mIncrementButton;
  private boolean mIncrementVirtualButtonPressed;
  private boolean mIngonreMoveEvents;
  private int mInitialScrollOffset = -2147483648;
  private final EditText mInputText;
  private long mLastDownEventTime;
  private float mLastDownEventY;
  private float mLastDownOrMoveEventY;
  private int mLastHandledDownDpadKeyCode = -1;
  private int mLastHoveredChildVirtualViewId;
  private long mLongPressUpdateInterval = 300L;
  private final int mMaxHeight;
  private int mMaxValue;
  private int mMaxWidth;
  private int mMaximumFlingVelocity;
  private final int mMinHeight;
  private int mMinValue;
  private final int mMinWidth;
  private int mMinimumFlingVelocity;
  private OnScrollListener mOnScrollListener;
  private OnValueChangeListener mOnValueChangeListener;
  private final PressedStateHelper mPressedStateHelper;
  private int mPreviousScrollerY;
  private int mScrollState = 0;
  private final Drawable mSelectionDivider;
  private final int mSelectionDividerHeight;
  private final int mSelectionDividersDistance;
  private int mSelectorElementHeight;
  private final SparseArray<String> mSelectorIndexToStringCache = new SparseArray();
  private int[] mSelectorIndices = new int[0];
  private int mSelectorMiddleItemIndex;
  private int mSelectorTextGapHeight;
  private int mSelectorWheelItemCount;
  private final Paint mSelectorWheelPaint;
  private SetSelectionCommand mSetSelectionCommand;
  private boolean mShowSoftInputOnTap;
  private final int mSolidColor;
  private final int mTextSize;
  private int mTopSelectionDividerTop;
  private int mTouchSlop;
  private int mValue;
  private VelocityTracker mVelocityTracker;
  private final Drawable mVirtualButtonPressedDrawable;
  private boolean mWrapSelectorWheel;
  
  public NumberPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034941);
  }
  
  public NumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.NumberPicker, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(R.styleable.NumberPicker_internalLayout, 0);
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mHasSelectorWheel = bool;
      this.mSolidColor = paramAttributeSet.getColor(R.styleable.NumberPicker_solidColor, 0);
      this.mSelectionDivider = paramAttributeSet.getDrawable(R.styleable.NumberPicker_selectionDivider);
      int i = (int)TypedValue.applyDimension(1, 2.0F, getResources().getDisplayMetrics());
      this.mSelectionDividerHeight = paramAttributeSet.getDimensionPixelSize(R.styleable.NumberPicker_selectionDividerHeight, i);
      i = (int)TypedValue.applyDimension(1, 48.0F, getResources().getDisplayMetrics());
      this.mSelectionDividersDistance = paramAttributeSet.getDimensionPixelSize(R.styleable.NumberPicker_selectionDividersDistance, i);
      this.mMinHeight = paramAttributeSet.getDimensionPixelSize(R.styleable.NumberPicker_internalMinHeight, -1);
      this.mMaxHeight = paramAttributeSet.getDimensionPixelSize(R.styleable.NumberPicker_internalMaxHeight, -1);
      if ((this.mMinHeight == -1) || (this.mMaxHeight == -1) || (this.mMinHeight <= this.mMaxHeight)) {
        break;
      }
      throw new IllegalArgumentException("minHeight > maxHeight");
    }
    this.mMinWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.NumberPicker_internalMinWidth, -1);
    this.mMaxWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.NumberPicker_internalMaxWidth, -1);
    if ((this.mMinWidth != -1) && (this.mMaxWidth != -1) && (this.mMinWidth > this.mMaxWidth)) {
      throw new IllegalArgumentException("minWidth > maxWidth");
    }
    if (this.mMaxWidth == -1)
    {
      bool = true;
      this.mComputeMaxWidth = bool;
      this.mVirtualButtonPressedDrawable = paramAttributeSet.getDrawable(R.styleable.NumberPicker_virtualButtonPressedDrawable);
      this.mAutoFitHeight = paramAttributeSet.getBoolean(R.styleable.NumberPicker_selectionAutoFit, false);
      paramAttributeSet.recycle();
      this.mPressedStateHelper = new PressedStateHelper();
      if (this.mHasSelectorWheel) {
        break label713;
      }
      bool = true;
      label362:
      setWillNotDraw(bool);
      ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
      paramAttributeSet = new NumberPicker.1(this);
      NumberPicker.2 local2 = new NumberPicker.2(this);
      if (this.mHasSelectorWheel) {
        break label719;
      }
      this.mIncrementButton = ((ImageButton)findViewById(2131372562));
      this.mIncrementButton.setOnClickListener(paramAttributeSet);
      this.mIncrementButton.setOnLongClickListener(local2);
      label445:
      if (this.mHasSelectorWheel) {
        break label727;
      }
      this.mDecrementButton = ((ImageButton)findViewById(2131372561));
      this.mDecrementButton.setOnClickListener(paramAttributeSet);
      this.mDecrementButton.setOnLongClickListener(local2);
    }
    for (;;)
    {
      this.mInputText = ((EditText)findViewById(2131372563));
      this.mInputText.setOnFocusChangeListener(new NumberPicker.3(this));
      this.mInputText.setFilters(new InputFilter[] { new InputTextFilter() });
      this.mInputText.setRawInputType(2);
      this.mInputText.setImeOptions(6);
      paramContext = ViewConfiguration.get(paramContext);
      this.mTouchSlop = paramContext.getScaledTouchSlop();
      this.mMinimumFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
      this.mMaximumFlingVelocity = (paramContext.getScaledMaximumFlingVelocity() / 8);
      this.mTextSize = ((int)this.mInputText.getTextSize());
      paramContext = new Paint();
      paramContext.setAntiAlias(true);
      paramContext.setTextAlign(Paint.Align.CENTER);
      paramContext.setTextSize(this.mTextSize);
      paramContext.setTypeface(this.mInputText.getTypeface());
      paramContext.setColor(this.mInputText.getTextColors().getColorForState(ENABLED_STATE_SET, -1));
      this.mSelectorWheelPaint = paramContext;
      this.mFlingScroller = new NumberPickerScroller(getContext(), null, true);
      this.mAdjustScroller = new NumberPickerScroller(getContext(), new DecelerateInterpolator(2.5F));
      updateInputTextView();
      return;
      bool = false;
      break;
      label713:
      bool = false;
      break label362;
      label719:
      this.mIncrementButton = null;
      break label445;
      label727:
      this.mDecrementButton = null;
    }
  }
  
  private void changeValueByOne(boolean paramBoolean)
  {
    if (this.mHasSelectorWheel)
    {
      this.mInputText.setVisibility(4);
      if (!moveToFinalScrollerPosition(this.mFlingScroller)) {
        moveToFinalScrollerPosition(this.mAdjustScroller);
      }
      this.mPreviousScrollerY = 0;
      if (paramBoolean) {
        this.mFlingScroller.startScroll(0, 0, 0, -this.mSelectorElementHeight, 300);
      }
      for (;;)
      {
        invalidate();
        return;
        this.mFlingScroller.startScroll(0, 0, 0, this.mSelectorElementHeight, 300);
      }
    }
    if (paramBoolean) {
      setValueInternal(this.mValue + 1, true);
    }
    for (;;)
    {
      notifyTimeChangeAfterScroll();
      return;
      setValueInternal(this.mValue - 1, true);
    }
  }
  
  private void decrementSelectorIndices(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length - 1;
    while (i > 0)
    {
      paramArrayOfInt[i] = paramArrayOfInt[(i - 1)];
      i -= 1;
    }
    int j = paramArrayOfInt[1] - 1;
    i = j;
    if (this.mWrapSelectorWheel)
    {
      i = j;
      if (j < this.mMinValue) {
        i = this.mMaxValue;
      }
    }
    paramArrayOfInt[0] = i;
    ensureCachedScrollSelectorValue(i);
  }
  
  private void ensureCachedScrollSelectorValue(int paramInt)
  {
    SparseArray localSparseArray = this.mSelectorIndexToStringCache;
    if ((String)localSparseArray.get(paramInt) != null) {
      return;
    }
    String str;
    if ((paramInt < this.mMinValue) || (paramInt > this.mMaxValue)) {
      str = "";
    }
    for (;;)
    {
      localSparseArray.put(paramInt, str);
      return;
      if (this.mDisplayedValues != null)
      {
        int i = this.mMinValue;
        str = this.mDisplayedValues[(paramInt - i)];
      }
      else
      {
        str = formatNumber(paramInt);
      }
    }
  }
  
  private boolean ensureScrollWheelAdjusted()
  {
    boolean bool = false;
    int j = this.mInitialScrollOffset - this.mCurrentScrollOffset;
    if (j != 0)
    {
      this.mPreviousScrollerY = 0;
      i = j;
      if (Math.abs(j) > this.mSelectorElementHeight / 2) {
        if (j <= 0) {
          break label72;
        }
      }
    }
    label72:
    for (int i = -this.mSelectorElementHeight;; i = this.mSelectorElementHeight)
    {
      i = j + i;
      this.mAdjustScroller.startScroll(0, 0, 0, i, 800);
      invalidate();
      bool = true;
      return bool;
    }
  }
  
  private void fling(int paramInt)
  {
    this.mPreviousScrollerY = 0;
    if (paramInt > 0) {
      this.mFlingScroller.fling(0, 0, 0, paramInt, 0, 0, 0, 2147483647);
    }
    for (;;)
    {
      invalidate();
      return;
      this.mFlingScroller.fling(0, 2147483647, 0, paramInt, 0, 0, 0, 2147483647);
    }
  }
  
  private String formatNumber(int paramInt)
  {
    if (this.mFormatter != null) {
      return this.mFormatter.format(paramInt);
    }
    return formatNumberWithLocale(paramInt);
  }
  
  private static String formatNumberWithLocale(int paramInt)
  {
    return String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private int getSelectedPos(String paramString)
  {
    if (this.mDisplayedValues == null) {}
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        break label68;
      }
      paramString = paramString;
    }
    i = 0;
    while (i < this.mDisplayedValues.length)
    {
      paramString = paramString.toLowerCase();
      if (this.mDisplayedValues[i].toLowerCase().startsWith(paramString)) {
        return i + this.mMinValue;
      }
      i += 1;
    }
    label68:
    return this.mMinValue;
  }
  
  public static final Formatter getTwoDigitFormatter()
  {
    return sTwoDigitFormatter;
  }
  
  private int getWrappedSelectorIndex(int paramInt)
  {
    int i;
    if (paramInt > this.mMaxValue) {
      i = this.mMinValue + (paramInt - this.mMaxValue) % (this.mMaxValue - this.mMinValue) - 1;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt >= this.mMinValue);
    return this.mMaxValue - (this.mMinValue - paramInt) % (this.mMaxValue - this.mMinValue) + 1;
  }
  
  private void hideSoftInput()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if ((localInputMethodManager != null) && (localInputMethodManager.isActive(this.mInputText)))
    {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      if (this.mHasSelectorWheel) {
        this.mInputText.setVisibility(4);
      }
    }
  }
  
  private void incrementSelectorIndices(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length - 1)
    {
      paramArrayOfInt[i] = paramArrayOfInt[(i + 1)];
      i += 1;
    }
    int j = paramArrayOfInt[(paramArrayOfInt.length - 2)] + 1;
    i = j;
    if (this.mWrapSelectorWheel)
    {
      i = j;
      if (j > this.mMaxValue) {
        i = this.mMinValue;
      }
    }
    paramArrayOfInt[(paramArrayOfInt.length - 1)] = i;
    ensureCachedScrollSelectorValue(i);
  }
  
  private void initializeFadingEdges()
  {
    setVerticalFadingEdgeEnabled(true);
    setFadingEdgeLength((getBottom() - getTop() - this.mTextSize) / 2);
  }
  
  private void initializeSelectorWheel()
  {
    initializeSelectorWheelIndices();
    int[] arrayOfInt = this.mSelectorIndices;
    int i = arrayOfInt.length;
    int j = this.mTextSize;
    this.mSelectorTextGapHeight = ((int)((getBottom() - getTop() - i * j) / arrayOfInt.length + 0.5F));
    this.mSelectorElementHeight = (this.mTextSize + this.mSelectorTextGapHeight);
    this.mInitialScrollOffset = (this.mInputText.getBaseline() + this.mInputText.getTop() - this.mSelectorElementHeight * this.mSelectorMiddleItemIndex);
    this.mCurrentScrollOffset = this.mInitialScrollOffset;
    updateInputTextView();
  }
  
  private void initializeSelectorWheelIndices()
  {
    this.mSelectorIndexToStringCache.clear();
    int[] arrayOfInt = this.mSelectorIndices;
    int m = getValue();
    int i = 0;
    while (i < this.mSelectorIndices.length)
    {
      int k = i - this.mSelectorMiddleItemIndex + m;
      int j = k;
      if (this.mWrapSelectorWheel) {
        j = getWrappedSelectorIndex(k);
      }
      arrayOfInt[i] = j;
      ensureCachedScrollSelectorValue(arrayOfInt[i]);
      i += 1;
    }
  }
  
  private int makeMeasureSpec(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -1) {
      return paramInt1;
    }
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt1);
    switch (j)
    {
    case 1073741824: 
    default: 
      throw new IllegalArgumentException("Unknown measure mode: " + j);
    case -2147483648: 
      return View.MeasureSpec.makeMeasureSpec(Math.min(i, paramInt2), 1073741824);
    }
    return View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
  }
  
  private boolean moveToFinalScrollerPosition(NumberPickerScroller paramNumberPickerScroller)
  {
    paramNumberPickerScroller.forceFinished(true);
    int k = paramNumberPickerScroller.getFinalY() - paramNumberPickerScroller.getCurrY();
    int i = this.mCurrentScrollOffset;
    int j = this.mSelectorElementHeight;
    j = this.mInitialScrollOffset - (i + k) % j;
    if (j != 0)
    {
      i = j;
      if (Math.abs(j) > this.mSelectorElementHeight / 2) {
        if (j <= 0) {
          break label79;
        }
      }
      label79:
      for (i = j - this.mSelectorElementHeight;; i = j + this.mSelectorElementHeight)
      {
        scrollBy(0, i + k);
        return true;
      }
    }
    return false;
  }
  
  private void notifyChange(int paramInt1, int paramInt2)
  {
    if (this.mOnValueChangeListener != null) {
      this.mOnValueChangeListener.onValueChange(this, paramInt1, this.mValue);
    }
  }
  
  private void notifyTimeChangeAfterScroll()
  {
    if (this.mOnValueChangeListener != null) {
      this.mOnValueChangeListener.onValueChangeAfterScroll(this, this.mValue);
    }
  }
  
  private void onScrollStateChange(int paramInt)
  {
    if (this.mScrollState == paramInt) {}
    do
    {
      return;
      this.mScrollState = paramInt;
    } while (this.mOnScrollListener == null);
    this.mOnScrollListener.onScrollStateChange(this, paramInt);
  }
  
  private void onScrollerFinished(NumberPickerScroller paramNumberPickerScroller)
  {
    if (paramNumberPickerScroller == this.mFlingScroller)
    {
      if (!ensureScrollWheelAdjusted())
      {
        updateInputTextView();
        notifyTimeChangeAfterScroll();
      }
      onScrollStateChange(0);
      return;
    }
    if (this.mScrollState != 1) {
      updateInputTextView();
    }
    notifyTimeChangeAfterScroll();
  }
  
  private void postBeginSoftInputOnLongPressCommand()
  {
    if (this.mBeginSoftInputOnLongPressCommand == null) {
      this.mBeginSoftInputOnLongPressCommand = new BeginSoftInputOnLongPressCommand();
    }
    for (;;)
    {
      postDelayed(this.mBeginSoftInputOnLongPressCommand, ViewConfiguration.getLongPressTimeout());
      return;
      removeCallbacks(this.mBeginSoftInputOnLongPressCommand);
    }
  }
  
  private void postChangeCurrentByOneFromLongPress(boolean paramBoolean, long paramLong)
  {
    if (this.mChangeCurrentByOneFromLongPressCommand == null) {
      this.mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
    }
    for (;;)
    {
      this.mChangeCurrentByOneFromLongPressCommand.setStep(paramBoolean);
      postDelayed(this.mChangeCurrentByOneFromLongPressCommand, paramLong);
      return;
      removeCallbacks(this.mChangeCurrentByOneFromLongPressCommand);
    }
  }
  
  private void postSetSelectionCommand(int paramInt1, int paramInt2)
  {
    if (this.mSetSelectionCommand == null) {
      this.mSetSelectionCommand = new SetSelectionCommand();
    }
    for (;;)
    {
      SetSelectionCommand.access$602(this.mSetSelectionCommand, paramInt1);
      SetSelectionCommand.access$702(this.mSetSelectionCommand, paramInt2);
      post(this.mSetSelectionCommand);
      return;
      removeCallbacks(this.mSetSelectionCommand);
    }
  }
  
  private void removeAllCallbacks()
  {
    if (this.mChangeCurrentByOneFromLongPressCommand != null) {
      removeCallbacks(this.mChangeCurrentByOneFromLongPressCommand);
    }
    if (this.mSetSelectionCommand != null) {
      removeCallbacks(this.mSetSelectionCommand);
    }
    if (this.mBeginSoftInputOnLongPressCommand != null) {
      removeCallbacks(this.mBeginSoftInputOnLongPressCommand);
    }
    this.mPressedStateHelper.cancel();
  }
  
  private void removeBeginSoftInputCommand()
  {
    if (this.mBeginSoftInputOnLongPressCommand != null) {
      removeCallbacks(this.mBeginSoftInputOnLongPressCommand);
    }
  }
  
  private void removeChangeCurrentByOneFromLongPress()
  {
    if (this.mChangeCurrentByOneFromLongPressCommand != null) {
      removeCallbacks(this.mChangeCurrentByOneFromLongPressCommand);
    }
  }
  
  public static int resolveSizeAndState1(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (j)
    {
    default: 
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      return paramInt2 | paramInt3;
      paramInt2 = paramInt1;
      if (i < paramInt1)
      {
        paramInt2 = i;
        continue;
        paramInt2 = i;
      }
    }
  }
  
  private int resolveSizeAndStateRespectingMinSize(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    if (paramInt1 != -1) {
      i = resolveSizeAndState1(Math.max(paramInt1, paramInt2), paramInt3, 0);
    }
    return i;
  }
  
  private void setValueInternal(int paramInt, boolean paramBoolean)
  {
    if (this.mValue == paramInt) {
      return;
    }
    if (this.mWrapSelectorWheel) {}
    for (paramInt = getWrappedSelectorIndex(paramInt);; paramInt = Math.min(Math.max(paramInt, this.mMinValue), this.mMaxValue))
    {
      int i = this.mValue;
      this.mValue = paramInt;
      updateInputTextView();
      if (paramBoolean) {
        notifyChange(i, paramInt);
      }
      initializeSelectorWheelIndices();
      invalidate();
      return;
    }
  }
  
  private void showSoftInput()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager != null)
    {
      if (this.mHasSelectorWheel) {
        this.mInputText.setVisibility(0);
      }
      this.mInputText.requestFocus();
      localInputMethodManager.showSoftInput(this.mInputText, 0);
    }
  }
  
  private void tryComputeMaxWidth()
  {
    int j = 0;
    if (!this.mComputeMaxWidth) {
      return;
    }
    float f1;
    int i;
    if (this.mDisplayedValues == null)
    {
      f1 = 0.0F;
      i = 0;
      label22:
      if (i <= 9)
      {
        float f2 = this.mSelectorWheelPaint.measureText(formatNumberWithLocale(i));
        if (f2 <= f1) {
          break label205;
        }
        f1 = f2;
      }
    }
    label205:
    for (;;)
    {
      i += 1;
      break label22;
      i = this.mMaxValue;
      while (i > 0)
      {
        j += 1;
        i /= 10;
      }
      int k = (int)(j * f1);
      i = k + (this.mInputText.getPaddingLeft() + this.mInputText.getPaddingRight());
      if (this.mMaxWidth == i) {
        break;
      }
      if (i > this.mMinWidth) {}
      for (this.mMaxWidth = i;; this.mMaxWidth = this.mMinWidth)
      {
        invalidate();
        return;
        int m = this.mDisplayedValues.length;
        j = 0;
        for (i = 0;; i = k)
        {
          k = i;
          if (j >= m) {
            break;
          }
          f1 = this.mSelectorWheelPaint.measureText(this.mDisplayedValues[j]);
          k = i;
          if (f1 > i) {
            k = (int)f1;
          }
          j += 1;
        }
      }
    }
  }
  
  private boolean updateInputTextView()
  {
    if (this.mDisplayedValues == null) {}
    for (String str = formatNumber(this.mValue); (!TextUtils.isEmpty(str)) && (!str.equals(this.mInputText.getText().toString())); str = this.mDisplayedValues[(this.mValue - this.mMinValue)])
    {
      this.mInputText.setText(str);
      return true;
    }
    return false;
  }
  
  private void validateInputTextView(View paramView)
  {
    paramView = String.valueOf(((TextView)paramView).getText());
    if (TextUtils.isEmpty(paramView))
    {
      updateInputTextView();
      return;
    }
    setValueInternal(getSelectedPos(paramView.toString()), true);
  }
  
  public void computeScroll()
  {
    NumberPickerScroller localNumberPickerScroller2 = this.mFlingScroller;
    NumberPickerScroller localNumberPickerScroller1 = localNumberPickerScroller2;
    if (localNumberPickerScroller2.isFinished())
    {
      localNumberPickerScroller2 = this.mAdjustScroller;
      localNumberPickerScroller1 = localNumberPickerScroller2;
      if (localNumberPickerScroller2.isFinished()) {
        return;
      }
    }
    localNumberPickerScroller1.computeScrollOffset();
    int i = localNumberPickerScroller1.getCurrY();
    if (this.mPreviousScrollerY == 0) {
      this.mPreviousScrollerY = localNumberPickerScroller1.getStartY();
    }
    scrollBy(0, i - this.mPreviousScrollerY);
    this.mPreviousScrollerY = i;
    if (localNumberPickerScroller1.isFinished())
    {
      onScrollerFinished(localNumberPickerScroller1);
      return;
    }
    invalidate();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    int i = paramKeyEvent.getKeyCode();
    switch (i)
    {
    }
    label127:
    do
    {
      bool = super.dispatchKeyEvent(paramKeyEvent);
      do
      {
        return bool;
        removeAllCallbacks();
        break;
        if (!this.mHasSelectorWheel) {
          break;
        }
        switch (paramKeyEvent.getAction())
        {
        default: 
          break;
        case 0: 
          if ((!this.mWrapSelectorWheel) && (i != 20)) {
            break label166;
          }
          if (getValue() >= getMaxValue()) {
            break;
          }
          requestFocus();
          this.mLastHandledDownDpadKeyCode = i;
          removeAllCallbacks();
        }
      } while (!this.mFlingScroller.isFinished());
      if (i == 20) {}
      for (bool = true;; bool = false)
      {
        changeValueByOne(bool);
        return true;
        if (getValue() <= getMinValue()) {
          break;
        }
        break label127;
      }
    } while (this.mLastHandledDownDpadKeyCode != i);
    label166:
    this.mLastHandledDownDpadKeyCode = -1;
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      removeAllCallbacks();
    }
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.dispatchTrackballEvent(paramMotionEvent);
      removeAllCallbacks();
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    return 0.9F;
  }
  
  public String[] getDisplayedValues()
  {
    return this.mDisplayedValues;
  }
  
  public int getMaxValue()
  {
    return this.mMaxValue;
  }
  
  public int getMinValue()
  {
    return this.mMinValue;
  }
  
  public int getSolidColor()
  {
    return this.mSolidColor;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    return 0.9F;
  }
  
  public int getValue()
  {
    return this.mValue;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.mWrapSelectorWheel;
  }
  
  protected void onDetachedFromWindow()
  {
    removeAllCallbacks();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.mHasSelectorWheel) {
      super.onDraw(paramCanvas);
    }
    do
    {
      return;
      float f2 = (getRight() - getLeft()) / 2;
      float f1 = this.mCurrentScrollOffset;
      if ((this.mVirtualButtonPressedDrawable != null) && (this.mScrollState == 0))
      {
        if (this.mDecrementVirtualButtonPressed)
        {
          this.mVirtualButtonPressedDrawable.setState(PRESSED_ENABLED_STATE_SET);
          this.mVirtualButtonPressedDrawable.setBounds(0, 0, getRight(), this.mTopSelectionDividerTop);
          this.mVirtualButtonPressedDrawable.draw(paramCanvas);
        }
        if (this.mIncrementVirtualButtonPressed)
        {
          this.mVirtualButtonPressedDrawable.setState(PRESSED_ENABLED_STATE_SET);
          this.mVirtualButtonPressedDrawable.setBounds(0, this.mBottomSelectionDividerBottom, getRight(), getBottom());
          this.mVirtualButtonPressedDrawable.draw(paramCanvas);
        }
      }
      int[] arrayOfInt = this.mSelectorIndices;
      i = 0;
      while (i < arrayOfInt.length)
      {
        j = arrayOfInt[i];
        String str = (String)this.mSelectorIndexToStringCache.get(j);
        if ((i != this.mSelectorMiddleItemIndex) || (this.mInputText.getVisibility() != 0)) {
          paramCanvas.drawText(str, f2, f1, this.mSelectorWheelPaint);
        }
        f1 += this.mSelectorElementHeight;
        i += 1;
      }
    } while (this.mSelectionDivider == null);
    int i = this.mTopSelectionDividerTop;
    int j = this.mSelectionDividerHeight;
    this.mSelectionDivider.setBounds(0, i, getRight(), j + i);
    this.mSelectionDivider.draw(paramCanvas);
    i = this.mBottomSelectionDividerBottom;
    j = this.mSelectionDividerHeight;
    this.mSelectionDivider.setBounds(0, i - j, getRight(), i);
    this.mSelectionDivider.draw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.mHasSelectorWheel) || (!isEnabled())) {
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return false;
    }
    removeAllCallbacks();
    this.mInputText.setVisibility(4);
    float f = paramMotionEvent.getY();
    this.mLastDownEventY = f;
    this.mLastDownOrMoveEventY = f;
    this.mLastDownEventTime = paramMotionEvent.getEventTime();
    this.mIngonreMoveEvents = false;
    this.mShowSoftInputOnTap = false;
    if (this.mLastDownEventY < this.mTopSelectionDividerTop) {
      if (this.mScrollState == 0) {
        this.mPressedStateHelper.buttonPressDelayed(2);
      }
    }
    for (;;)
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      if (this.mFlingScroller.isFinished()) {
        break;
      }
      this.mFlingScroller.forceFinished(true);
      this.mAdjustScroller.forceFinished(true);
      onScrollStateChange(0);
      return true;
      if ((this.mLastDownEventY > this.mBottomSelectionDividerBottom) && (this.mScrollState == 0)) {
        this.mPressedStateHelper.buttonPressDelayed(1);
      }
    }
    if (!this.mAdjustScroller.isFinished())
    {
      this.mFlingScroller.forceFinished(true);
      this.mAdjustScroller.forceFinished(true);
      return true;
    }
    if (this.mLastDownEventY < this.mTopSelectionDividerTop)
    {
      hideSoftInput();
      postChangeCurrentByOneFromLongPress(false, ViewConfiguration.getLongPressTimeout());
      return true;
    }
    if (this.mLastDownEventY > this.mBottomSelectionDividerBottom)
    {
      hideSoftInput();
      postChangeCurrentByOneFromLongPress(true, ViewConfiguration.getLongPressTimeout());
      return true;
    }
    this.mShowSoftInputOnTap = true;
    postBeginSoftInputOnLongPressCommand();
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mHasSelectorWheel) {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    do
    {
      return;
      paramInt4 = getMeasuredWidth();
      paramInt3 = getMeasuredHeight();
      paramInt1 = this.mInputText.getMeasuredWidth();
      paramInt2 = this.mInputText.getMeasuredHeight();
      paramInt4 = (paramInt4 - paramInt1) / 2;
      paramInt3 = (paramInt3 - paramInt2) / 2;
      this.mInputText.layout(paramInt4, paramInt3, paramInt1 + paramInt4, paramInt2 + paramInt3);
    } while (!paramBoolean);
    paramInt2 = getHeight() / this.mSelectionDividersDistance;
    paramInt1 = paramInt2;
    if (paramInt2 % 2 == 0)
    {
      paramInt1 = paramInt2;
      if (paramInt2 != 0) {
        paramInt1 = paramInt2 - 1;
      }
    }
    if (this.mSelectorWheelItemCount != paramInt1)
    {
      this.mSelectorWheelItemCount = paramInt1;
      this.mSelectorIndices = new int[this.mSelectorWheelItemCount];
      this.mSelectorMiddleItemIndex = (this.mSelectorWheelItemCount / 2);
    }
    initializeSelectorWheel();
    initializeFadingEdges();
    this.mTopSelectionDividerTop = ((getHeight() - this.mSelectionDividersDistance) / 2 - this.mSelectionDividerHeight);
    this.mBottomSelectionDividerBottom = (this.mTopSelectionDividerTop + this.mSelectionDividerHeight * 2 + this.mSelectionDividersDistance);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.mHasSelectorWheel)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int j;
    if (this.mAutoFitHeight) {
      j = makeMeasureSpec(paramInt1, this.mMaxWidth);
    }
    for (int i = makeMeasureSpec(paramInt2, View.MeasureSpec.getSize(paramInt2));; i = makeMeasureSpec(paramInt2, this.mMaxHeight))
    {
      super.onMeasure(j, i);
      setMeasuredDimension(resolveSizeAndStateRespectingMinSize(this.mMinWidth, getMeasuredWidth(), paramInt1), resolveSizeAndStateRespectingMinSize(this.mMinHeight, getMeasuredHeight(), paramInt2));
      return;
      j = makeMeasureSpec(paramInt1, this.mMaxWidth);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!isEnabled()) || (!this.mHasSelectorWheel)) {
      bool = false;
    }
    do
    {
      return bool;
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      this.mVelocityTracker.addMovement(paramMotionEvent);
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      default: 
        return true;
      case 1: 
        removeBeginSoftInputCommand();
        removeChangeCurrentByOneFromLongPress();
        this.mPressedStateHelper.cancel();
        VelocityTracker localVelocityTracker = this.mVelocityTracker;
        localVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
        i = (int)localVelocityTracker.getYVelocity();
        if (Math.abs(i) <= this.mMinimumFlingVelocity) {
          break label226;
        }
        fling(i);
        onScrollStateChange(2);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        return true;
      }
    } while (this.mIngonreMoveEvents);
    float f = paramMotionEvent.getY();
    if (this.mScrollState != 1) {
      if ((int)Math.abs(f - this.mLastDownEventY) > this.mTouchSlop)
      {
        removeAllCallbacks();
        onScrollStateChange(1);
      }
    }
    for (;;)
    {
      this.mLastDownOrMoveEventY = f;
      return true;
      scrollBy(0, (int)(f - this.mLastDownOrMoveEventY));
      invalidate();
    }
    label226:
    int i = (int)paramMotionEvent.getY();
    int j = (int)Math.abs(i - this.mLastDownEventY);
    paramMotionEvent.getEventTime();
    long l = this.mLastDownEventTime;
    l = ViewConfiguration.getTapTimeout();
    if (j <= this.mTouchSlop) {
      if (this.mShowSoftInputOnTap)
      {
        this.mShowSoftInputOnTap = false;
        showSoftInput();
      }
    }
    for (;;)
    {
      onScrollStateChange(0);
      break;
      i = i / this.mSelectorElementHeight - this.mSelectorMiddleItemIndex;
      if (i > 0)
      {
        changeValueByOne(true);
        this.mPressedStateHelper.buttonTapped(1);
      }
      else if (i < 0)
      {
        changeValueByOne(false);
        this.mPressedStateHelper.buttonTapped(2);
        continue;
        ensureScrollWheelAdjusted();
      }
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.mSelectorIndices;
    if ((!this.mWrapSelectorWheel) && (paramInt2 > 0) && (arrayOfInt[this.mSelectorMiddleItemIndex] <= this.mMinValue)) {
      this.mCurrentScrollOffset = this.mInitialScrollOffset;
    }
    for (;;)
    {
      return;
      if ((!this.mWrapSelectorWheel) && (paramInt2 < 0) && (arrayOfInt[this.mSelectorMiddleItemIndex] >= this.mMaxValue))
      {
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        return;
      }
      for (this.mCurrentScrollOffset += paramInt2; this.mCurrentScrollOffset - this.mInitialScrollOffset > this.mSelectorTextGapHeight; this.mCurrentScrollOffset = this.mInitialScrollOffset)
      {
        label81:
        this.mCurrentScrollOffset -= this.mSelectorElementHeight;
        decrementSelectorIndices(arrayOfInt);
        setValueInternal(arrayOfInt[this.mSelectorMiddleItemIndex], true);
        if ((this.mWrapSelectorWheel) || (arrayOfInt[this.mSelectorMiddleItemIndex] > this.mMinValue)) {
          break label81;
        }
      }
      while (this.mCurrentScrollOffset - this.mInitialScrollOffset < -this.mSelectorTextGapHeight)
      {
        this.mCurrentScrollOffset += this.mSelectorElementHeight;
        incrementSelectorIndices(arrayOfInt);
        setValueInternal(arrayOfInt[this.mSelectorMiddleItemIndex], true);
        if ((!this.mWrapSelectorWheel) && (arrayOfInt[this.mSelectorMiddleItemIndex] >= this.mMaxValue)) {
          this.mCurrentScrollOffset = this.mInitialScrollOffset;
        }
      }
    }
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    if (this.mDisplayedValues == paramArrayOfString) {
      return;
    }
    this.mDisplayedValues = paramArrayOfString;
    if (this.mDisplayedValues != null) {
      this.mInputText.setRawInputType(524289);
    }
    for (;;)
    {
      updateInputTextView();
      initializeSelectorWheelIndices();
      tryComputeMaxWidth();
      return;
      this.mInputText.setRawInputType(2);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (!this.mHasSelectorWheel) {
      this.mIncrementButton.setEnabled(paramBoolean);
    }
    if (!this.mHasSelectorWheel) {
      this.mDecrementButton.setEnabled(paramBoolean);
    }
    this.mInputText.setEnabled(paramBoolean);
  }
  
  public void setExpectValueAfterScroller(int paramInt)
  {
    if (this.mValue == paramInt) {
      return;
    }
    int j = this.mInitialScrollOffset - this.mCurrentScrollOffset;
    this.mAdjustScroller.forceFinished(true);
    this.mFlingScroller.forceFinished(true);
    int i;
    if (j != 0)
    {
      this.mPreviousScrollerY = 0;
      if (Math.abs(j) > this.mSelectorElementHeight / 2) {
        if (j > 0)
        {
          i = -this.mSelectorElementHeight;
          i += j;
        }
      }
    }
    for (;;)
    {
      this.mPreviousScrollerY = 0;
      j = this.mValue;
      int k = this.mSelectorElementHeight;
      this.mAdjustScroller.startScroll(0, 0, 0, i + (j - paramInt) * k, 300);
      invalidate();
      return;
      i = this.mSelectorElementHeight;
      break;
      i = j;
    }
  }
  
  public void setFormatter(Formatter paramFormatter)
  {
    if (paramFormatter == this.mFormatter) {
      return;
    }
    this.mFormatter = paramFormatter;
    initializeSelectorWheelIndices();
    updateInputTextView();
  }
  
  public void setMaxValue(int paramInt)
  {
    if (this.mMaxValue == paramInt) {
      return;
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("maxValue must be >= 0");
    }
    this.mMaxValue = paramInt;
    if (this.mMaxValue < this.mValue) {
      this.mValue = this.mMaxValue;
    }
    initializeSelectorWheelIndices();
    updateInputTextView();
    tryComputeMaxWidth();
    invalidate();
  }
  
  public void setMinValue(int paramInt)
  {
    if (this.mMinValue == paramInt) {
      return;
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("minValue must be >= 0");
    }
    this.mMinValue = paramInt;
    if (this.mMinValue > this.mValue) {
      this.mValue = this.mMinValue;
    }
    initializeSelectorWheelIndices();
    updateInputTextView();
    tryComputeMaxWidth();
    invalidate();
  }
  
  public void setOnLongPressUpdateInterval(long paramLong)
  {
    this.mLongPressUpdateInterval = paramLong;
  }
  
  public void setOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
  }
  
  public void setOnValueChangedListener(OnValueChangeListener paramOnValueChangeListener)
  {
    this.mOnValueChangeListener = paramOnValueChangeListener;
  }
  
  public void setValue(int paramInt)
  {
    setValueInternal(paramInt, false);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    this.mWrapSelectorWheel = paramBoolean;
  }
  
  class BeginSoftInputOnLongPressCommand
    implements Runnable
  {
    BeginSoftInputOnLongPressCommand() {}
    
    public void run()
    {
      NumberPicker.this.showSoftInput();
      NumberPicker.access$1902(NumberPicker.this, true);
    }
  }
  
  class ChangeCurrentByOneFromLongPressCommand
    implements Runnable
  {
    private boolean mIncrement;
    
    ChangeCurrentByOneFromLongPressCommand() {}
    
    private void setStep(boolean paramBoolean)
    {
      this.mIncrement = paramBoolean;
    }
    
    public void run()
    {
      NumberPicker.this.changeValueByOne(this.mIncrement);
      NumberPicker.this.postDelayed(this, NumberPicker.this.mLongPressUpdateInterval);
    }
  }
  
  public static class CustomEditText
    extends EditText
  {
    public CustomEditText(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public void onEditorAction(int paramInt)
    {
      super.onEditorAction(paramInt);
      if (paramInt == 6) {
        clearFocus();
      }
    }
  }
  
  public static abstract interface Formatter
  {
    public abstract String format(int paramInt);
  }
  
  class InputTextFilter
    extends NumberKeyListener
  {
    InputTextFilter() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      CharSequence localCharSequence;
      if (NumberPicker.this.mDisplayedValues == null)
      {
        localCharSequence = super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
        localObject = localCharSequence;
        if (localCharSequence == null) {
          localObject = paramCharSequence.subSequence(paramInt1, paramInt2);
        }
        paramCharSequence = String.valueOf(paramSpanned.subSequence(0, paramInt3)) + localObject + paramSpanned.subSequence(paramInt4, paramSpanned.length());
        if ("".equals(paramCharSequence)) {
          localObject = paramCharSequence;
        }
        while (NumberPicker.this.getSelectedPos(paramCharSequence) <= NumberPicker.this.mMaxValue) {
          return localObject;
        }
        return "";
      }
      paramCharSequence = String.valueOf(paramCharSequence.subSequence(paramInt1, paramInt2));
      if (TextUtils.isEmpty(paramCharSequence)) {
        return "";
      }
      paramCharSequence = String.valueOf(paramSpanned.subSequence(0, paramInt3)) + paramCharSequence + paramSpanned.subSequence(paramInt4, paramSpanned.length());
      paramSpanned = String.valueOf(paramCharSequence).toLowerCase();
      Object localObject = NumberPicker.this.mDisplayedValues;
      paramInt2 = localObject.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localCharSequence = localObject[paramInt1];
        if (localCharSequence.toLowerCase().startsWith(paramSpanned))
        {
          NumberPicker.this.postSetSelectionCommand(paramCharSequence.length(), localCharSequence.length());
          return localCharSequence.subSequence(paramInt3, localCharSequence.length());
        }
        paramInt1 += 1;
      }
      return "";
    }
    
    protected char[] getAcceptedChars()
    {
      return NumberPicker.DIGIT_CHARACTERS;
    }
    
    public int getInputType()
    {
      return 1;
    }
  }
  
  public static abstract interface OnScrollListener
  {
    public static final int SCROLL_STATE_FLING = 2;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_TOUCH_SCROLL = 1;
    
    public abstract void onScrollStateChange(NumberPicker paramNumberPicker, int paramInt);
  }
  
  public static abstract interface OnValueChangeListener
  {
    public abstract void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2);
    
    public abstract void onValueChangeAfterScroll(NumberPicker paramNumberPicker, int paramInt);
  }
  
  class PressedStateHelper
    implements Runnable
  {
    public static final int BUTTON_DECREMENT = 2;
    public static final int BUTTON_INCREMENT = 1;
    private final int MODE_PRESS = 1;
    private final int MODE_TAPPED = 2;
    private int mManagedButton;
    private int mMode;
    
    PressedStateHelper() {}
    
    public void buttonPressDelayed(int paramInt)
    {
      cancel();
      this.mMode = 1;
      this.mManagedButton = paramInt;
      NumberPicker.this.postDelayed(this, ViewConfiguration.getTapTimeout());
    }
    
    public void buttonTapped(int paramInt)
    {
      cancel();
      this.mMode = 2;
      this.mManagedButton = paramInt;
      NumberPicker.this.post(this);
    }
    
    public void cancel()
    {
      this.mMode = 0;
      this.mManagedButton = 0;
      NumberPicker.this.removeCallbacks(this);
      if (NumberPicker.this.mIncrementVirtualButtonPressed)
      {
        NumberPicker.access$1302(NumberPicker.this, false);
        NumberPicker.this.invalidate(0, NumberPicker.this.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
      }
      NumberPicker.access$1502(NumberPicker.this, false);
      if (NumberPicker.this.mDecrementVirtualButtonPressed) {
        NumberPicker.this.invalidate(0, 0, NumberPicker.this.getRight(), NumberPicker.this.mTopSelectionDividerTop);
      }
    }
    
    public void run()
    {
      switch (this.mMode)
      {
      default: 
        return;
      case 1: 
        switch (this.mManagedButton)
        {
        default: 
          return;
        case 1: 
          NumberPicker.access$1302(NumberPicker.this, true);
          NumberPicker.this.invalidate(0, NumberPicker.this.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
          return;
        }
        NumberPicker.access$1502(NumberPicker.this, true);
        NumberPicker.this.invalidate(0, 0, NumberPicker.this.getRight(), NumberPicker.this.mTopSelectionDividerTop);
        return;
      }
      switch (this.mManagedButton)
      {
      default: 
        return;
      case 1: 
        if (!NumberPicker.this.mIncrementVirtualButtonPressed) {
          NumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
        }
        NumberPicker.access$1302(NumberPicker.this, NumberPicker.this.mIncrementVirtualButtonPressed ^ true);
        NumberPicker.this.invalidate(0, NumberPicker.this.mBottomSelectionDividerBottom, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
        return;
      }
      if (!NumberPicker.this.mDecrementVirtualButtonPressed) {
        NumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
      }
      NumberPicker.access$1502(NumberPicker.this, NumberPicker.this.mDecrementVirtualButtonPressed ^ true);
      NumberPicker.this.invalidate(0, 0, NumberPicker.this.getRight(), NumberPicker.this.mTopSelectionDividerTop);
    }
  }
  
  class SetSelectionCommand
    implements Runnable
  {
    private int mSelectionEnd;
    private int mSelectionStart;
    
    SetSelectionCommand() {}
    
    public void run()
    {
      NumberPicker.this.mInputText.setSelection(this.mSelectionStart, this.mSelectionEnd);
    }
  }
  
  static class TwoDigitFormatter
    implements NumberPicker.Formatter
  {
    final Object[] mArgs = new Object[1];
    final StringBuilder mBuilder = new StringBuilder();
    Formatter mFmt;
    char mZeroDigit;
    
    TwoDigitFormatter()
    {
      init(Locale.getDefault());
    }
    
    private Formatter createFormatter(Locale paramLocale)
    {
      return new Formatter(this.mBuilder, paramLocale);
    }
    
    private static char getZeroDigit(Locale paramLocale)
    {
      return new DecimalFormatSymbols(paramLocale).getZeroDigit();
    }
    
    private void init(Locale paramLocale)
    {
      this.mFmt = createFormatter(paramLocale);
      this.mZeroDigit = getZeroDigit(paramLocale);
    }
    
    public String format(int paramInt)
    {
      Locale localLocale = Locale.getDefault();
      if (this.mZeroDigit != getZeroDigit(localLocale)) {
        init(localLocale);
      }
      this.mArgs[0] = Integer.valueOf(paramInt);
      this.mBuilder.delete(0, this.mBuilder.length());
      this.mFmt.format("%02d", this.mArgs);
      return this.mFmt.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.NumberPicker
 * JD-Core Version:    0.7.0.1
 */