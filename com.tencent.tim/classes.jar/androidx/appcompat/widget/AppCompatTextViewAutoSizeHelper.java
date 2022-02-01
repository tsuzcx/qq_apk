package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import b.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class AppCompatTextViewAutoSizeHelper
{
  private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
  private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
  private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
  private static final String TAG = "ACTVAutoSizeHelper";
  private static final RectF TEMP_RECTF = new RectF();
  static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0F;
  private static final int VERY_WIDE = 1048576;
  private static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache = new ConcurrentHashMap();
  private float mAutoSizeMaxTextSizeInPx = -1.0F;
  private float mAutoSizeMinTextSizeInPx = -1.0F;
  private float mAutoSizeStepGranularityInPx = -1.0F;
  private int[] mAutoSizeTextSizesInPx = new int[0];
  private int mAutoSizeTextType = 0;
  private final Context mContext;
  private boolean mHasPresetAutoSizeValues = false;
  private boolean mNeedsAutoSizeText = false;
  private TextPaint mTempTextPaint;
  private final TextView mTextView;
  
  AppCompatTextViewAutoSizeHelper(TextView paramTextView)
  {
    this.mTextView = paramTextView;
    this.mContext = this.mTextView.getContext();
  }
  
  private static <T> T accessAndReturnWithDefault(@NonNull Object paramObject, @NonNull String paramString, @NonNull T paramT)
  {
    try
    {
      Field localField = getTextViewField(paramString);
      if (localField == null) {
        return paramT;
      }
      paramObject = localField.get(paramObject);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + paramString + " member", paramObject);
    }
    return paramT;
  }
  
  private int[] cleanupAutoSizePresetSizes(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    if (j == 0) {}
    ArrayList localArrayList;
    do
    {
      return paramArrayOfInt;
      Arrays.sort(paramArrayOfInt);
      localArrayList = new ArrayList();
      i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        if ((k > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(k)) < 0)) {
          localArrayList.add(Integer.valueOf(k));
        }
        i += 1;
      }
    } while (j == localArrayList.size());
    j = localArrayList.size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      paramArrayOfInt = arrayOfInt;
      if (i >= j) {
        break;
      }
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
  }
  
  private void clearAutoSizeConfiguration()
  {
    this.mAutoSizeTextType = 0;
    this.mAutoSizeMinTextSizeInPx = -1.0F;
    this.mAutoSizeMaxTextSizeInPx = -1.0F;
    this.mAutoSizeStepGranularityInPx = -1.0F;
    this.mAutoSizeTextSizesInPx = new int[0];
    this.mNeedsAutoSizeText = false;
  }
  
  @RequiresApi(23)
  private StaticLayout createStaticLayoutForMeasuring(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    StaticLayout.Builder localBuilder = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.mTempTextPaint, paramInt1);
    paramCharSequence = localBuilder.setAlignment(paramAlignment).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = 2147483647;
    }
    paramCharSequence.setMaxLines(paramInt1);
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 29) {
          continue;
        }
        paramCharSequence = this.mTextView.getTextDirectionHeuristic();
        localBuilder.setTextDirection(paramCharSequence);
      }
      catch (ClassCastException paramCharSequence)
      {
        Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        continue;
      }
      return localBuilder.build();
      paramCharSequence = (TextDirectionHeuristic)invokeAndReturnWithDefault(this.mTextView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    }
  }
  
  private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1 = ((Float)accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0F))).floatValue();
    float f2 = ((Float)accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0F))).floatValue();
    boolean bool = ((Boolean)accessAndReturnWithDefault(this.mTextView, "mIncludePad", Boolean.valueOf(true))).booleanValue();
    return new StaticLayout(paramCharSequence, this.mTempTextPaint, paramInt, paramAlignment, f1, f2, bool);
  }
  
  @RequiresApi(16)
  private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1 = this.mTextView.getLineSpacingMultiplier();
    float f2 = this.mTextView.getLineSpacingExtra();
    boolean bool = this.mTextView.getIncludeFontPadding();
    return new StaticLayout(paramCharSequence, this.mTempTextPaint, paramInt, paramAlignment, f1, f2, bool);
  }
  
  private int findLargestTextSizeWhichFits(RectF paramRectF)
  {
    int k = this.mAutoSizeTextSizesInPx.length;
    if (k == 0) {
      throw new IllegalStateException("No available text sizes to choose from.");
    }
    int j = 0;
    int i = 1;
    k -= 1;
    while (i <= k)
    {
      int m = (i + k) / 2;
      if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[m], paramRectF))
      {
        j = i;
        i = m + 1;
      }
      else
      {
        k = m - 1;
        j = k;
      }
    }
    return this.mAutoSizeTextSizesInPx[j];
  }
  
  @Nullable
  private static Field getTextViewField(@NonNull String paramString)
  {
    try
    {
      Field localField2 = (Field)sTextViewFieldByNameCache.get(paramString);
      Field localField1 = localField2;
      if (localField2 == null)
      {
        localField2 = TextView.class.getDeclaredField(paramString);
        localField1 = localField2;
        if (localField2 != null)
        {
          localField2.setAccessible(true);
          sTextViewFieldByNameCache.put(paramString, localField2);
          localField1 = localField2;
        }
      }
      return localField1;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + paramString + " member", localNoSuchFieldException);
    }
    return null;
  }
  
  @Nullable
  private static Method getTextViewMethod(@NonNull String paramString)
  {
    try
    {
      Method localMethod2 = (Method)sTextViewMethodByNameCache.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        localMethod2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localMethod1 = localMethod2;
        if (localMethod2 != null)
        {
          localMethod2.setAccessible(true);
          sTextViewMethodByNameCache.put(paramString, localMethod2);
          localMethod1 = localMethod2;
        }
      }
      return localMethod1;
    }
    catch (Exception localException)
    {
      Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + paramString + "() method", localException);
    }
    return null;
  }
  
  private static <T> T invokeAndReturnWithDefault(@NonNull Object paramObject, @NonNull String paramString, @NonNull T paramT)
  {
    i = 0;
    try
    {
      paramObject = getTextViewMethod(paramString).invoke(paramObject, new Object[0]);
      paramT = paramObject;
      if (paramObject != null) {}
    }
    catch (Exception paramObject)
    {
      do
      {
        i = 1;
        Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + paramString + "() method", paramObject);
      } while (0 == 0);
      return null;
    }
    finally
    {
      if ((0 != 0) || (i == 0)) {
        break label74;
      }
    }
    return paramT;
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.mTextView.getPaint().getTextSize())
    {
      this.mTextView.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT < 18) {
        break label124;
      }
    }
    label124:
    for (boolean bool = this.mTextView.isInLayout();; bool = false)
    {
      if (this.mTextView.getLayout() != null) {
        this.mNeedsAutoSizeText = false;
      }
      try
      {
        Method localMethod = getTextViewMethod("nullLayouts");
        if (localMethod != null) {
          localMethod.invoke(this.mTextView, new Object[0]);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", localException);
          continue;
          this.mTextView.forceLayout();
        }
      }
      if (!bool)
      {
        this.mTextView.requestLayout();
        this.mTextView.invalidate();
        return;
      }
    }
  }
  
  private boolean setupAutoSizeText()
  {
    int i = 0;
    if ((supportsAutoSizeText()) && (this.mAutoSizeTextType == 1)) {
      if ((!this.mHasPresetAutoSizeValues) || (this.mAutoSizeTextSizesInPx.length == 0))
      {
        int j = (int)Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx) + 1;
        int[] arrayOfInt = new int[j];
        while (i < j)
        {
          arrayOfInt[i] = Math.round(this.mAutoSizeMinTextSizeInPx + i * this.mAutoSizeStepGranularityInPx);
          i += 1;
        }
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
      }
    }
    for (this.mNeedsAutoSizeText = true;; this.mNeedsAutoSizeText = false) {
      return this.mNeedsAutoSizeText;
    }
  }
  
  private void setupAutoSizeUniformPresetSizes(TypedArray paramTypedArray)
  {
    int j = paramTypedArray.length();
    int[] arrayOfInt = new int[j];
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        arrayOfInt[i] = paramTypedArray.getDimensionPixelSize(i, -1);
        i += 1;
      }
      this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
      setupAutoSizeUniformPresetSizesConfiguration();
    }
  }
  
  private boolean setupAutoSizeUniformPresetSizesConfiguration()
  {
    int i = this.mAutoSizeTextSizesInPx.length;
    if (i > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mHasPresetAutoSizeValues = bool;
      if (this.mHasPresetAutoSizeValues)
      {
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = this.mAutoSizeTextSizesInPx[0];
        this.mAutoSizeMaxTextSizeInPx = this.mAutoSizeTextSizesInPx[(i - 1)];
        this.mAutoSizeStepGranularityInPx = -1.0F;
      }
      return this.mHasPresetAutoSizeValues;
    }
  }
  
  private boolean suggestedSizeFitsInSpace(int paramInt, RectF paramRectF)
  {
    Object localObject2 = this.mTextView.getText();
    Object localObject3 = this.mTextView.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.mTextView);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = localObject3;
      }
    }
    if (Build.VERSION.SDK_INT >= 16) {}
    for (int i = this.mTextView.getMaxLines();; i = -1)
    {
      initTempTextPaint(paramInt);
      localObject2 = createLayout(localObject1, (Layout.Alignment)invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(paramRectF.right), i);
      if ((i == -1) || ((((StaticLayout)localObject2).getLineCount() <= i) && (((StaticLayout)localObject2).getLineEnd(((StaticLayout)localObject2).getLineCount() - 1) == localObject1.length()))) {
        break;
      }
      return false;
    }
    return ((StaticLayout)localObject2).getHeight() <= paramRectF.bottom;
  }
  
  private boolean supportsAutoSizeText()
  {
    return !(this.mTextView instanceof AppCompatEditText);
  }
  
  private void validateAndSetAutoSizeTextTypeUniformConfiguration(float paramFloat1, float paramFloat2, float paramFloat3)
    throws IllegalArgumentException
  {
    if (paramFloat1 <= 0.0F) {
      throw new IllegalArgumentException("Minimum auto-size text size (" + paramFloat1 + "px) is less or equal to (0px)");
    }
    if (paramFloat2 <= paramFloat1) {
      throw new IllegalArgumentException("Maximum auto-size text size (" + paramFloat2 + "px) is less or equal to minimum auto-size text size (" + paramFloat1 + "px)");
    }
    if (paramFloat3 <= 0.0F) {
      throw new IllegalArgumentException("The auto-size step granularity (" + paramFloat3 + "px) is less or equal to (0px)");
    }
    this.mAutoSizeTextType = 1;
    this.mAutoSizeMinTextSizeInPx = paramFloat1;
    this.mAutoSizeMaxTextSizeInPx = paramFloat2;
    this.mAutoSizeStepGranularityInPx = paramFloat3;
    this.mHasPresetAutoSizeValues = false;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void autoSizeText()
  {
    if (!isAutoSizeEnabled()) {}
    do
    {
      return;
      if (!this.mNeedsAutoSizeText) {
        break;
      }
    } while ((this.mTextView.getMeasuredHeight() <= 0) || (this.mTextView.getMeasuredWidth() <= 0));
    boolean bool;
    if (Build.VERSION.SDK_INT >= 29) {
      bool = this.mTextView.isHorizontallyScrollable();
    }
    for (;;)
    {
      int i;
      int j;
      if (bool)
      {
        i = 1048576;
        j = this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom() - this.mTextView.getCompoundPaddingTop();
        if ((i <= 0) || (j <= 0)) {
          break;
        }
      }
      synchronized (TEMP_RECTF)
      {
        TEMP_RECTF.setEmpty();
        TEMP_RECTF.right = i;
        TEMP_RECTF.bottom = j;
        float f = findLargestTextSizeWhichFits(TEMP_RECTF);
        if (f != this.mTextView.getTextSize()) {
          setTextSizeInternal(0, f);
        }
        this.mNeedsAutoSizeText = true;
        return;
        bool = ((Boolean)invokeAndReturnWithDefault(this.mTextView, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue();
        continue;
        i = this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft() - this.mTextView.getTotalPaddingRight();
      }
    }
  }
  
  @VisibleForTesting
  StaticLayout createLayout(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return createStaticLayoutForMeasuring(paramCharSequence, paramAlignment, paramInt1, paramInt2);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return createStaticLayoutForMeasuringPre23(paramCharSequence, paramAlignment, paramInt1);
    }
    return createStaticLayoutForMeasuringPre16(paramCharSequence, paramAlignment, paramInt1);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  int getAutoSizeMaxTextSize()
  {
    return Math.round(this.mAutoSizeMaxTextSizeInPx);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  int getAutoSizeMinTextSize()
  {
    return Math.round(this.mAutoSizeMinTextSizeInPx);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  int getAutoSizeStepGranularity()
  {
    return Math.round(this.mAutoSizeStepGranularityInPx);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  int[] getAutoSizeTextAvailableSizes()
  {
    return this.mAutoSizeTextSizesInPx;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  int getAutoSizeTextType()
  {
    return this.mAutoSizeTextType;
  }
  
  @VisibleForTesting
  void initTempTextPaint(int paramInt)
  {
    if (this.mTempTextPaint == null) {
      this.mTempTextPaint = new TextPaint();
    }
    for (;;)
    {
      this.mTempTextPaint.set(this.mTextView.getPaint());
      this.mTempTextPaint.setTextSize(paramInt);
      return;
      this.mTempTextPaint.reset();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  boolean isAutoSizeEnabled()
  {
    return (supportsAutoSizeText()) && (this.mAutoSizeTextType != 0);
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, b.a.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(b.a.AppCompatTextView_autoSizeTextType)) {
      this.mAutoSizeTextType = paramAttributeSet.getInt(b.a.AppCompatTextView_autoSizeTextType, 0);
    }
    if (paramAttributeSet.hasValue(b.a.AppCompatTextView_autoSizeStepGranularity)) {}
    for (float f1 = paramAttributeSet.getDimension(b.a.AppCompatTextView_autoSizeStepGranularity, -1.0F);; f1 = -1.0F)
    {
      if (paramAttributeSet.hasValue(b.a.AppCompatTextView_autoSizeMinTextSize)) {}
      for (float f2 = paramAttributeSet.getDimension(b.a.AppCompatTextView_autoSizeMinTextSize, -1.0F);; f2 = -1.0F)
      {
        if (paramAttributeSet.hasValue(b.a.AppCompatTextView_autoSizeMaxTextSize)) {}
        for (float f3 = paramAttributeSet.getDimension(b.a.AppCompatTextView_autoSizeMaxTextSize, -1.0F);; f3 = -1.0F)
        {
          if (paramAttributeSet.hasValue(b.a.AppCompatTextView_autoSizePresetSizes))
          {
            paramInt = paramAttributeSet.getResourceId(b.a.AppCompatTextView_autoSizePresetSizes, 0);
            if (paramInt > 0)
            {
              TypedArray localTypedArray = paramAttributeSet.getResources().obtainTypedArray(paramInt);
              setupAutoSizeUniformPresetSizes(localTypedArray);
              localTypedArray.recycle();
            }
          }
          paramAttributeSet.recycle();
          if (supportsAutoSizeText())
          {
            if (this.mAutoSizeTextType == 1)
            {
              if (!this.mHasPresetAutoSizeValues)
              {
                paramAttributeSet = this.mContext.getResources().getDisplayMetrics();
                float f4 = f2;
                if (f2 == -1.0F) {
                  f4 = TypedValue.applyDimension(2, 12.0F, paramAttributeSet);
                }
                f2 = f3;
                if (f3 == -1.0F) {
                  f2 = TypedValue.applyDimension(2, 112.0F, paramAttributeSet);
                }
                f3 = f1;
                if (f1 == -1.0F) {
                  f3 = 1.0F;
                }
                validateAndSetAutoSizeTextTypeUniformConfiguration(f4, f2, f3);
              }
              setupAutoSizeText();
            }
            return;
          }
          this.mAutoSizeTextType = 0;
          return;
        }
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (supportsAutoSizeText())
    {
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (setupAutoSizeText()) {
        autoSizeText();
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    int i = 0;
    if (supportsAutoSizeText())
    {
      int j = paramArrayOfInt.length;
      if (j > 0)
      {
        int[] arrayOfInt2 = new int[j];
        int[] arrayOfInt1;
        if (paramInt == 0)
        {
          arrayOfInt1 = Arrays.copyOf(paramArrayOfInt, j);
          this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt1);
          if (!setupAutoSizeUniformPresetSizesConfiguration()) {
            throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(paramArrayOfInt));
          }
        }
        else
        {
          DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
          for (;;)
          {
            arrayOfInt1 = arrayOfInt2;
            if (i >= j) {
              break;
            }
            arrayOfInt2[i] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[i], localDisplayMetrics));
            i += 1;
          }
        }
      }
      else
      {
        this.mHasPresetAutoSizeValues = false;
      }
      if (setupAutoSizeText()) {
        autoSizeText();
      }
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (supportsAutoSizeText()) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Unknown auto-size text type: " + paramInt);
      case 0: 
        clearAutoSizeConfiguration();
      }
    }
    do
    {
      return;
      DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
      validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
    } while (!setupAutoSizeText());
    autoSizeText();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setTextSizeInternal(int paramInt, float paramFloat)
  {
    if (this.mContext == null) {}
    for (Resources localResources = Resources.getSystem();; localResources = this.mContext.getResources())
    {
      setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, localResources.getDisplayMetrics()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper
 * JD-Core Version:    0.7.0.1
 */