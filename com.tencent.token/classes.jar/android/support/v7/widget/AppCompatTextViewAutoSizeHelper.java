package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v7.appcompat.R.styleable;
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
  
  private int[] cleanupAutoSizePresetSizes(int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt.length;
    if (k == 0) {
      return paramArrayOfInt;
    }
    Arrays.sort(paramArrayOfInt);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      int m = paramArrayOfInt[i];
      if ((m > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(m)) < 0)) {
        localArrayList.add(Integer.valueOf(m));
      }
      i += 1;
    }
    if (k == localArrayList.size()) {
      return paramArrayOfInt;
    }
    k = localArrayList.size();
    paramArrayOfInt = new int[k];
    i = j;
    while (i < k)
    {
      paramArrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    return paramArrayOfInt;
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
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)invokeAndReturnWithDefault(this.mTextView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.mTempTextPaint, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = 2147483647;
    }
    return paramCharSequence.setMaxLines(paramInt1).setTextDirection(localTextDirectionHeuristic).build();
  }
  
  private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1;
    float f2;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 16)
    {
      f1 = this.mTextView.getLineSpacingMultiplier();
      f2 = this.mTextView.getLineSpacingExtra();
      bool = this.mTextView.getIncludeFontPadding();
    }
    else
    {
      f1 = ((Float)invokeAndReturnWithDefault(this.mTextView, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)invokeAndReturnWithDefault(this.mTextView, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
      bool = ((Boolean)invokeAndReturnWithDefault(this.mTextView, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue();
    }
    return new StaticLayout(paramCharSequence, this.mTempTextPaint, paramInt, paramAlignment, f1, f2, bool);
  }
  
  private int findLargestTextSizeWhichFits(RectF paramRectF)
  {
    int i = this.mAutoSizeTextSizesInPx.length;
    if (i != 0)
    {
      int k = i - 1;
      i = 1;
      int j = 0;
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
          j = m - 1;
          k = j;
        }
      }
      return this.mAutoSizeTextSizesInPx[j];
    }
    throw new IllegalStateException("No available text sizes to choose from.");
  }
  
  @Nullable
  private Method getTextViewMethod(@NonNull String paramString)
  {
    try
    {
      localObject2 = (Method)sTextViewMethodByNameCache.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((Method)localObject2).setAccessible(true);
          sTextViewMethodByNameCache.put(paramString, localObject2);
          localObject1 = localObject2;
        }
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Failed to retrieve TextView#");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("() method");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)localObject2).toString(), localException);
    }
    return null;
  }
  
  /* Error */
  private <T> T invokeAndReturnWithDefault(@NonNull Object paramObject, @NonNull String paramString, @NonNull T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 296	android/support/v7/widget/AppCompatTextViewAutoSizeHelper:getTextViewMethod	(Ljava/lang/String;)Ljava/lang/reflect/Method;
    //   5: aload_1
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokevirtual 300	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_1
    //   15: areturn
    //   16: astore_1
    //   17: goto +52 -> 69
    //   20: astore_1
    //   21: new 274	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: ldc_w 302
    //   35: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 4
    //   41: aload_2
    //   42: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 4
    //   48: ldc_w 283
    //   51: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: ldc 15
    //   57: aload 4
    //   59: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: aload_1
    //   63: invokestatic 293	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   66: pop
    //   67: aload_3
    //   68: areturn
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	AppCompatTextViewAutoSizeHelper
    //   0	71	1	paramObject	Object
    //   0	71	2	paramString	String
    //   0	71	3	paramT	T
    //   28	30	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	14	16	finally
    //   21	67	16	finally
    //   0	14	20	java/lang/Exception
  }
  
  private void setRawTextSize(float paramFloat)
  {
    if (paramFloat != this.mTextView.getPaint().getTextSize())
    {
      this.mTextView.getPaint().setTextSize(paramFloat);
      boolean bool;
      if (Build.VERSION.SDK_INT >= 18) {
        bool = this.mTextView.isInLayout();
      } else {
        bool = false;
      }
      if (this.mTextView.getLayout() != null)
      {
        this.mNeedsAutoSizeText = false;
        try
        {
          Method localMethod = getTextViewMethod("nullLayouts");
          if (localMethod != null) {
            localMethod.invoke(this.mTextView, new Object[0]);
          }
        }
        catch (Exception localException)
        {
          Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", localException);
        }
        if (!bool) {
          this.mTextView.requestLayout();
        } else {
          this.mTextView.forceLayout();
        }
        this.mTextView.invalidate();
      }
    }
  }
  
  private boolean setupAutoSizeText()
  {
    boolean bool = supportsAutoSizeText();
    int j = 0;
    if ((bool) && (this.mAutoSizeTextType == 1))
    {
      if ((!this.mHasPresetAutoSizeValues) || (this.mAutoSizeTextSizesInPx.length == 0))
      {
        float f = Math.round(this.mAutoSizeMinTextSizeInPx);
        int i = 1;
        while (Math.round(this.mAutoSizeStepGranularityInPx + f) <= Math.round(this.mAutoSizeMaxTextSizeInPx))
        {
          i += 1;
          f += this.mAutoSizeStepGranularityInPx;
        }
        int[] arrayOfInt = new int[i];
        f = this.mAutoSizeMinTextSizeInPx;
        while (j < i)
        {
          arrayOfInt[j] = Math.round(f);
          f += this.mAutoSizeStepGranularityInPx;
          j += 1;
        }
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(arrayOfInt);
      }
      this.mNeedsAutoSizeText = true;
    }
    else
    {
      this.mNeedsAutoSizeText = false;
    }
    return this.mNeedsAutoSizeText;
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
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.mHasPresetAutoSizeValues = bool;
    if (this.mHasPresetAutoSizeValues)
    {
      this.mAutoSizeTextType = 1;
      int[] arrayOfInt = this.mAutoSizeTextSizesInPx;
      this.mAutoSizeMinTextSizeInPx = arrayOfInt[0];
      this.mAutoSizeMaxTextSizeInPx = arrayOfInt[(i - 1)];
      this.mAutoSizeStepGranularityInPx = -1.0F;
    }
    return this.mHasPresetAutoSizeValues;
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
    int i;
    if (Build.VERSION.SDK_INT >= 16) {
      i = this.mTextView.getMaxLines();
    } else {
      i = -1;
    }
    localObject2 = this.mTempTextPaint;
    if (localObject2 == null) {
      this.mTempTextPaint = new TextPaint();
    } else {
      ((TextPaint)localObject2).reset();
    }
    this.mTempTextPaint.set(this.mTextView.getPaint());
    this.mTempTextPaint.setTextSize(paramInt);
    localObject2 = (Layout.Alignment)invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject2 = createStaticLayoutForMeasuring(localObject1, (Layout.Alignment)localObject2, Math.round(paramRectF.right), i);
    } else {
      localObject2 = createStaticLayoutForMeasuringPre23(localObject1, (Layout.Alignment)localObject2, Math.round(paramRectF.right));
    }
    if ((i != -1) && ((((StaticLayout)localObject2).getLineCount() > i) || (((StaticLayout)localObject2).getLineEnd(((StaticLayout)localObject2).getLineCount() - 1) != localObject1.length()))) {
      return false;
    }
    return ((StaticLayout)localObject2).getHeight() <= paramRectF.bottom;
  }
  
  private boolean supportsAutoSizeText()
  {
    return !(this.mTextView instanceof AppCompatEditText);
  }
  
  private void validateAndSetAutoSizeTextTypeUniformConfiguration(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > 0.0F)
    {
      if (paramFloat2 > paramFloat1)
      {
        if (paramFloat3 > 0.0F)
        {
          this.mAutoSizeTextType = 1;
          this.mAutoSizeMinTextSizeInPx = paramFloat1;
          this.mAutoSizeMaxTextSizeInPx = paramFloat2;
          this.mAutoSizeStepGranularityInPx = paramFloat3;
          this.mHasPresetAutoSizeValues = false;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("The auto-size step granularity (");
        localStringBuilder.append(paramFloat3);
        localStringBuilder.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Maximum auto-size text size (");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("px) is less or equal to minimum auto-size ");
      localStringBuilder.append("text size (");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append("px)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Minimum auto-size text size (");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append("px) is less or equal to (0px)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void autoSizeText()
  {
    if (!isAutoSizeEnabled()) {
      return;
    }
    if (this.mNeedsAutoSizeText)
    {
      if (this.mTextView.getMeasuredHeight() > 0)
      {
        if (this.mTextView.getMeasuredWidth() <= 0) {
          return;
        }
        int i;
        if (((Boolean)invokeAndReturnWithDefault(this.mTextView, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {
          i = 1048576;
        } else {
          i = this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft() - this.mTextView.getTotalPaddingRight();
        }
        int j = this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom() - this.mTextView.getCompoundPaddingTop();
        if (i > 0)
        {
          if (j <= 0) {
            return;
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
          }
        }
        return;
      }
      return;
    }
    this.mNeedsAutoSizeText = true;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  int getAutoSizeMaxTextSize()
  {
    return Math.round(this.mAutoSizeMaxTextSizeInPx);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  int getAutoSizeMinTextSize()
  {
    return Math.round(this.mAutoSizeMinTextSizeInPx);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  int getAutoSizeStepGranularity()
  {
    return Math.round(this.mAutoSizeStepGranularityInPx);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  int[] getAutoSizeTextAvailableSizes()
  {
    return this.mAutoSizeTextSizesInPx;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  int getAutoSizeTextType()
  {
    return this.mAutoSizeTextType;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  boolean isAutoSizeEnabled()
  {
    return (supportsAutoSizeText()) && (this.mAutoSizeTextType != 0);
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
      this.mAutoSizeTextType = paramAttributeSet.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
    }
    float f1;
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity)) {
      f1 = paramAttributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0F);
    } else {
      f1 = -1.0F;
    }
    float f2;
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize)) {
      f2 = paramAttributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0F);
    } else {
      f2 = -1.0F;
    }
    float f3;
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize)) {
      f3 = paramAttributeSet.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0F);
    } else {
      f3 = -1.0F;
    }
    if (paramAttributeSet.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes))
    {
      paramInt = paramAttributeSet.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0);
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
    }
    else {
      this.mAutoSizeTextType = 0;
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfInt, int paramInt)
  {
    if (supportsAutoSizeText())
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      if (j > 0)
      {
        int[] arrayOfInt = new int[j];
        Object localObject;
        if (paramInt == 0)
        {
          localObject = Arrays.copyOf(paramArrayOfInt, j);
        }
        else
        {
          DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
          for (;;)
          {
            localObject = arrayOfInt;
            if (i >= j) {
              break;
            }
            arrayOfInt[i] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[i], localDisplayMetrics));
            i += 1;
          }
        }
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes((int[])localObject);
        if (!setupAutoSizeUniformPresetSizesConfiguration())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("None of the preset sizes is valid: ");
          ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfInt));
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
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
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (supportsAutoSizeText())
    {
      Object localObject;
      switch (paramInt)
      {
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unknown auto-size text type: ");
        ((StringBuilder)localObject).append(paramInt);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      case 1: 
        localObject = this.mContext.getResources().getDisplayMetrics();
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0F, (DisplayMetrics)localObject), TypedValue.applyDimension(2, 112.0F, (DisplayMetrics)localObject), 1.0F);
        if (setupAutoSizeText())
        {
          autoSizeText();
          return;
        }
        break;
      case 0: 
        clearAutoSizeConfiguration();
      }
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void setTextSizeInternal(int paramInt, float paramFloat)
  {
    Object localObject = this.mContext;
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    setRawTextSize(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextViewAutoSizeHelper
 * JD-Core Version:    0.7.0.1
 */