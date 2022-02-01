package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.PrecomputedTextCompat.Params;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView
  extends TextView
  implements TintableBackgroundView, AutoSizeableTextView, TintableCompoundDrawablesView
{
  private final AppCompatBackgroundHelper mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
  @Nullable
  private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
  private final AppCompatTextClassifierHelper mTextClassifierHelper;
  private final AppCompatTextHelper mTextHelper;
  
  public AppCompatTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.mBackgroundTintHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper = new AppCompatTextHelper(this);
    this.mTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
    this.mTextHelper.applyCompoundDrawablesTints();
    this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
  }
  
  private void consumeTextFutureAndSetBlocking()
  {
    if (this.mPrecomputedTextFuture != null) {}
    try
    {
      Future localFuture = this.mPrecomputedTextFuture;
      this.mPrecomputedTextFuture = null;
      TextViewCompat.setPrecomputedText(this, (PrecomputedTextCompat)localFuture.get());
      return;
    }
    catch (InterruptedException localInterruptedException) {}catch (ExecutionException localExecutionException) {}
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.applySupportBackgroundTint();
    }
    if (this.mTextHelper != null) {
      this.mTextHelper.applyCompoundDrawablesTints();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int getAutoSizeMaxTextSize()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      return super.getAutoSizeMaxTextSize();
    }
    if (this.mTextHelper != null) {
      return this.mTextHelper.getAutoSizeMaxTextSize();
    }
    return -1;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int getAutoSizeMinTextSize()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      return super.getAutoSizeMinTextSize();
    }
    if (this.mTextHelper != null) {
      return this.mTextHelper.getAutoSizeMinTextSize();
    }
    return -1;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int getAutoSizeStepGranularity()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      return super.getAutoSizeStepGranularity();
    }
    if (this.mTextHelper != null) {
      return this.mTextHelper.getAutoSizeStepGranularity();
    }
    return -1;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      return super.getAutoSizeTextAvailableSizes();
    }
    if (this.mTextHelper != null) {
      return this.mTextHelper.getAutoSizeTextAvailableSizes();
    }
    return new int[0];
  }
  
  @SuppressLint({"WrongConstant"})
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public int getAutoSizeTextType()
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
      return 0;
    }
    if (this.mTextHelper != null) {
      return this.mTextHelper.getAutoSizeTextType();
    }
    return 0;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    return TextViewCompat.getFirstBaselineToTopHeight(this);
  }
  
  public int getLastBaselineToBottomHeight()
  {
    return TextViewCompat.getLastBaselineToBottomHeight(this);
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public ColorStateList getSupportBackgroundTintList()
  {
    if (this.mBackgroundTintHelper != null) {
      return this.mBackgroundTintHelper.getSupportBackgroundTintList();
    }
    return null;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (this.mBackgroundTintHelper != null) {
      return this.mBackgroundTintHelper.getSupportBackgroundTintMode();
    }
    return null;
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public ColorStateList getSupportCompoundDrawablesTintList()
  {
    return this.mTextHelper.getCompoundDrawableTintList();
  }
  
  @Nullable
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PorterDuff.Mode getSupportCompoundDrawablesTintMode()
  {
    return this.mTextHelper.getCompoundDrawableTintMode();
  }
  
  public CharSequence getText()
  {
    consumeTextFutureAndSetBlocking();
    return super.getText();
  }
  
  @NonNull
  @RequiresApi(api=26)
  public TextClassifier getTextClassifier()
  {
    if ((Build.VERSION.SDK_INT >= 28) || (this.mTextClassifierHelper == null)) {
      return super.getTextClassifier();
    }
    return this.mTextClassifierHelper.getTextClassifier();
  }
  
  @NonNull
  public PrecomputedTextCompat.Params getTextMetricsParamsCompat()
  {
    return TextViewCompat.getTextMetricsParams(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mTextHelper != null) {
      this.mTextHelper.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    consumeTextFutureAndSetBlocking();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.mTextHelper != null) && (!PLATFORM_SUPPORTS_AUTOSIZE) && (this.mTextHelper.isAutoSizeEnabled())) {
      this.mTextHelper.autoSizeText();
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    while (this.mTextHelper == null) {
      return;
    }
    this.mTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    while (this.mTextHelper == null) {
      return;
    }
    this.mTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    while (this.mTextHelper == null) {
      return;
    }
    this.mTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.onSetBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.onSetBackgroundResource(paramInt);
    }
  }
  
  public void setCompoundDrawables(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    if (this.mTextHelper != null) {
      this.mTextHelper.onSetCompoundDrawables();
    }
  }
  
  @RequiresApi(17)
  public void setCompoundDrawablesRelative(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    if (this.mTextHelper != null) {
      this.mTextHelper.onSetCompoundDrawables();
    }
  }
  
  @RequiresApi(17)
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable4 = null;
    Context localContext = getContext();
    Drawable localDrawable1;
    Drawable localDrawable2;
    if (paramInt1 != 0)
    {
      localDrawable1 = AppCompatResources.getDrawable(localContext, paramInt1);
      if (paramInt2 == 0) {
        break label92;
      }
      localDrawable2 = AppCompatResources.getDrawable(localContext, paramInt2);
      label33:
      if (paramInt3 == 0) {
        break label98;
      }
    }
    label92:
    label98:
    for (Drawable localDrawable3 = AppCompatResources.getDrawable(localContext, paramInt3);; localDrawable3 = null)
    {
      if (paramInt4 != 0) {
        localDrawable4 = AppCompatResources.getDrawable(localContext, paramInt4);
      }
      setCompoundDrawablesRelativeWithIntrinsicBounds(localDrawable1, localDrawable2, localDrawable3, localDrawable4);
      if (this.mTextHelper != null) {
        this.mTextHelper.onSetCompoundDrawables();
      }
      return;
      localDrawable1 = null;
      break;
      localDrawable2 = null;
      break label33;
    }
  }
  
  @RequiresApi(17)
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    if (this.mTextHelper != null) {
      this.mTextHelper.onSetCompoundDrawables();
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable4 = null;
    Context localContext = getContext();
    Drawable localDrawable1;
    Drawable localDrawable2;
    if (paramInt1 != 0)
    {
      localDrawable1 = AppCompatResources.getDrawable(localContext, paramInt1);
      if (paramInt2 == 0) {
        break label92;
      }
      localDrawable2 = AppCompatResources.getDrawable(localContext, paramInt2);
      label33:
      if (paramInt3 == 0) {
        break label98;
      }
    }
    label92:
    label98:
    for (Drawable localDrawable3 = AppCompatResources.getDrawable(localContext, paramInt3);; localDrawable3 = null)
    {
      if (paramInt4 != 0) {
        localDrawable4 = AppCompatResources.getDrawable(localContext, paramInt4);
      }
      setCompoundDrawablesWithIntrinsicBounds(localDrawable1, localDrawable2, localDrawable3, localDrawable4);
      if (this.mTextHelper != null) {
        this.mTextHelper.onSetCompoundDrawables();
      }
      return;
      localDrawable1 = null;
      break;
      localDrawable2 = null;
      break label33;
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    if (this.mTextHelper != null) {
      this.mTextHelper.onSetCompoundDrawables();
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, paramCallback));
  }
  
  public void setFirstBaselineToTopHeight(@IntRange(from=0L) @Px int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    TextViewCompat.setFirstBaselineToTopHeight(this, paramInt);
  }
  
  public void setLastBaselineToBottomHeight(@IntRange(from=0L) @Px int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setLastBaselineToBottomHeight(paramInt);
      return;
    }
    TextViewCompat.setLastBaselineToBottomHeight(this, paramInt);
  }
  
  public void setLineHeight(@IntRange(from=0L) @Px int paramInt)
  {
    TextViewCompat.setLineHeight(this, paramInt);
  }
  
  public void setPrecomputedText(@NonNull PrecomputedTextCompat paramPrecomputedTextCompat)
  {
    TextViewCompat.setPrecomputedText(this, paramPrecomputedTextCompat);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportBackgroundTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.mBackgroundTintHelper != null) {
      this.mBackgroundTintHelper.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.mTextHelper.setCompoundDrawableTintList(paramColorStateList);
    this.mTextHelper.applyCompoundDrawablesTints();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.mTextHelper.setCompoundDrawableTintMode(paramMode);
    this.mTextHelper.applyCompoundDrawablesTints();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.mTextHelper != null) {
      this.mTextHelper.onSetTextAppearance(paramContext, paramInt);
    }
  }
  
  @RequiresApi(api=26)
  public void setTextClassifier(@Nullable TextClassifier paramTextClassifier)
  {
    if ((Build.VERSION.SDK_INT >= 28) || (this.mTextClassifierHelper == null))
    {
      super.setTextClassifier(paramTextClassifier);
      return;
    }
    this.mTextClassifierHelper.setTextClassifier(paramTextClassifier);
  }
  
  public void setTextFuture(@Nullable Future<PrecomputedTextCompat> paramFuture)
  {
    this.mPrecomputedTextFuture = paramFuture;
    if (paramFuture != null) {
      requestLayout();
    }
  }
  
  public void setTextMetricsParamsCompat(@NonNull PrecomputedTextCompat.Params paramParams)
  {
    TextViewCompat.setTextMetricsParams(this, paramParams);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (PLATFORM_SUPPORTS_AUTOSIZE) {
      super.setTextSize(paramInt, paramFloat);
    }
    while (this.mTextHelper == null) {
      return;
    }
    this.mTextHelper.setTextSize(paramInt, paramFloat);
  }
  
  public void setTypeface(@Nullable Typeface paramTypeface, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramTypeface != null)
    {
      localObject1 = localObject2;
      if (paramInt > 0) {
        localObject1 = TypefaceCompat.create(getContext(), paramTypeface, paramInt);
      }
    }
    if (localObject1 != null) {
      paramTypeface = (Typeface)localObject1;
    }
    super.setTypeface(paramTypeface, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */