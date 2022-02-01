package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import b.a;
import java.lang.ref.WeakReference;
import java.util.Locale;

class AppCompatTextHelper
{
  private static final int MONOSPACE = 3;
  private static final int SANS = 1;
  private static final int SERIF = 2;
  private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
  private boolean mAsyncFontPending;
  @NonNull
  private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
  private TintInfo mDrawableBottomTint;
  private TintInfo mDrawableEndTint;
  private TintInfo mDrawableLeftTint;
  private TintInfo mDrawableRightTint;
  private TintInfo mDrawableStartTint;
  private TintInfo mDrawableTint;
  private TintInfo mDrawableTopTint;
  private Typeface mFontTypeface;
  private int mFontWeight = -1;
  private int mStyle = 0;
  private final TextView mView;
  
  AppCompatTextHelper(TextView paramTextView)
  {
    this.mView = paramTextView;
    this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
  }
  
  private void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo)
  {
    if ((paramDrawable != null) && (paramTintInfo != null)) {
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, this.mView.getDrawableState());
    }
  }
  
  private static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt)
  {
    paramContext = paramAppCompatDrawableManager.getTintList(paramContext, paramInt);
    if (paramContext != null)
    {
      paramAppCompatDrawableManager = new TintInfo();
      paramAppCompatDrawableManager.mHasTintList = true;
      paramAppCompatDrawableManager.mTintList = paramContext;
      return paramAppCompatDrawableManager;
    }
    return null;
  }
  
  private void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4, Drawable paramDrawable5, Drawable paramDrawable6)
  {
    if ((Build.VERSION.SDK_INT >= 17) && ((paramDrawable5 != null) || (paramDrawable6 != null)))
    {
      paramDrawable3 = this.mView.getCompoundDrawablesRelative();
      paramDrawable1 = this.mView;
      if (paramDrawable5 != null)
      {
        if (paramDrawable2 == null) {
          break label70;
        }
        if (paramDrawable6 == null) {
          break label77;
        }
        if (paramDrawable4 == null) {
          break label85;
        }
        paramDrawable1.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable5, paramDrawable2, paramDrawable6, paramDrawable4);
      }
    }
    label70:
    label77:
    label85:
    while ((paramDrawable1 == null) && (paramDrawable2 == null) && (paramDrawable3 == null) && (paramDrawable4 == null)) {
      for (;;)
      {
        return;
        paramDrawable5 = paramDrawable3[0];
        continue;
        paramDrawable2 = paramDrawable3[1];
        continue;
        paramDrawable6 = paramDrawable3[2];
        continue;
        paramDrawable4 = paramDrawable3[3];
      }
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramDrawable5 = this.mView.getCompoundDrawablesRelative();
      if ((paramDrawable5[0] != null) || (paramDrawable5[2] != null))
      {
        paramDrawable1 = this.mView;
        paramDrawable3 = paramDrawable5[0];
        if (paramDrawable2 != null)
        {
          paramDrawable6 = paramDrawable5[2];
          if (paramDrawable4 == null) {
            break label185;
          }
        }
        for (;;)
        {
          paramDrawable1.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable3, paramDrawable2, paramDrawable6, paramDrawable4);
          return;
          paramDrawable2 = paramDrawable5[1];
          break;
          label185:
          paramDrawable4 = paramDrawable5[3];
        }
      }
    }
    paramDrawable6 = this.mView.getCompoundDrawables();
    paramDrawable5 = this.mView;
    if (paramDrawable1 != null)
    {
      if (paramDrawable2 == null) {
        break label245;
      }
      label217:
      if (paramDrawable3 == null) {
        break label253;
      }
      label221:
      if (paramDrawable4 == null) {
        break label261;
      }
    }
    for (;;)
    {
      paramDrawable5.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
      return;
      paramDrawable1 = paramDrawable6[0];
      break;
      label245:
      paramDrawable2 = paramDrawable6[1];
      break label217;
      label253:
      paramDrawable3 = paramDrawable6[2];
      break label221;
      label261:
      paramDrawable4 = paramDrawable6[3];
    }
  }
  
  private void setCompoundTints()
  {
    this.mDrawableLeftTint = this.mDrawableTint;
    this.mDrawableTopTint = this.mDrawableTint;
    this.mDrawableRightTint = this.mDrawableTint;
    this.mDrawableBottomTint = this.mDrawableTint;
    this.mDrawableStartTint = this.mDrawableTint;
    this.mDrawableEndTint = this.mDrawableTint;
  }
  
  private void setTextSizeInternal(int paramInt, float paramFloat)
  {
    this.mAutoSizeTextHelper.setTextSizeInternal(paramInt, paramFloat);
  }
  
  private void updateTypefaceAndStyle(Context paramContext, TintTypedArray paramTintTypedArray)
  {
    this.mStyle = paramTintTypedArray.getInt(b.a.TextAppearance_android_textStyle, this.mStyle);
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.mFontWeight = paramTintTypedArray.getInt(b.a.TextAppearance_android_textFontWeight, -1);
      if (this.mFontWeight != -1) {
        this.mStyle = (this.mStyle & 0x2 | 0x0);
      }
    }
    if ((paramTintTypedArray.hasValue(b.a.TextAppearance_android_fontFamily)) || (paramTintTypedArray.hasValue(b.a.TextAppearance_fontFamily)))
    {
      this.mFontTypeface = null;
      int i;
      int j;
      if (paramTintTypedArray.hasValue(b.a.TextAppearance_fontFamily))
      {
        i = b.a.TextAppearance_fontFamily;
        j = this.mFontWeight;
        int k = this.mStyle;
        if (!paramContext.isRestricted()) {
          paramContext = new ApplyTextViewCallback(this, j, k);
        }
      }
      for (;;)
      {
        try
        {
          paramContext = paramTintTypedArray.getFont(i, this.mStyle, paramContext);
          if (paramContext != null)
          {
            if ((Build.VERSION.SDK_INT < 28) || (this.mFontWeight == -1)) {
              continue;
            }
            paramContext = Typeface.create(paramContext, 0);
            j = this.mFontWeight;
            if ((this.mStyle & 0x2) == 0) {
              continue;
            }
            bool = true;
            this.mFontTypeface = Typeface.create(paramContext, j, bool);
          }
          if (this.mFontTypeface != null) {
            continue;
          }
          bool = true;
        }
        catch (UnsupportedOperationException paramContext)
        {
          continue;
          boolean bool = false;
          continue;
          bool = false;
          continue;
          this.mFontTypeface = Typeface.create(paramContext, this.mStyle);
          return;
          if (!paramTintTypedArray.hasValue(b.a.TextAppearance_android_typeface)) {
            continue;
          }
          this.mAsyncFontPending = false;
          switch (paramTintTypedArray.getInt(b.a.TextAppearance_android_typeface, 1))
          {
          default: 
            return;
          case 1: 
            this.mFontTypeface = Typeface.SANS_SERIF;
            return;
          case 2: 
            this.mFontTypeface = Typeface.SERIF;
            return;
          }
          this.mFontTypeface = Typeface.MONOSPACE;
          return;
        }
        catch (Resources.NotFoundException paramContext)
        {
          continue;
        }
        this.mAsyncFontPending = bool;
        if (this.mFontTypeface == null)
        {
          paramContext = paramTintTypedArray.getString(i);
          if (paramContext != null)
          {
            if ((Build.VERSION.SDK_INT < 28) || (this.mFontWeight == -1)) {
              continue;
            }
            paramContext = Typeface.create(paramContext, 0);
            i = this.mFontWeight;
            if ((this.mStyle & 0x2) == 0) {
              continue;
            }
            bool = true;
            this.mFontTypeface = Typeface.create(paramContext, i, bool);
          }
        }
        return;
        i = b.a.TextAppearance_android_fontFamily;
        break;
        bool = false;
        continue;
        this.mFontTypeface = paramContext;
      }
    }
  }
  
  void applyCompoundDrawablesTints()
  {
    Drawable[] arrayOfDrawable;
    if ((this.mDrawableLeftTint != null) || (this.mDrawableTopTint != null) || (this.mDrawableRightTint != null) || (this.mDrawableBottomTint != null))
    {
      arrayOfDrawable = this.mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], this.mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], this.mDrawableBottomTint);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.mDrawableStartTint != null) || (this.mDrawableEndTint != null)))
    {
      arrayOfDrawable = this.mView.getCompoundDrawablesRelative();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableStartTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableEndTint);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void autoSizeText()
  {
    this.mAutoSizeTextHelper.autoSizeText();
  }
  
  int getAutoSizeMaxTextSize()
  {
    return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
  }
  
  int getAutoSizeMinTextSize()
  {
    return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
  }
  
  int getAutoSizeStepGranularity()
  {
    return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
  }
  
  int[] getAutoSizeTextAvailableSizes()
  {
    return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
  }
  
  int getAutoSizeTextType()
  {
    return this.mAutoSizeTextHelper.getAutoSizeTextType();
  }
  
  @Nullable
  ColorStateList getCompoundDrawableTintList()
  {
    if (this.mDrawableTint != null) {
      return this.mDrawableTint.mTintList;
    }
    return null;
  }
  
  @Nullable
  PorterDuff.Mode getCompoundDrawableTintMode()
  {
    if (this.mDrawableTint != null) {
      return this.mDrawableTint.mTintMode;
    }
    return null;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  boolean isAutoSizeEnabled()
  {
    return this.mAutoSizeTextHelper.isAutoSizeEnabled();
  }
  
  @SuppressLint({"NewApi"})
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.mView.getContext();
    AppCompatDrawableManager localAppCompatDrawableManager = AppCompatDrawableManager.get();
    Object localObject1 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, b.a.AppCompatTextHelper, paramInt, 0);
    int k = ((TintTypedArray)localObject1).getResourceId(b.a.AppCompatTextHelper_android_textAppearance, -1);
    if (((TintTypedArray)localObject1).hasValue(b.a.AppCompatTextHelper_android_drawableLeft)) {
      this.mDrawableLeftTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(b.a.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((TintTypedArray)localObject1).hasValue(b.a.AppCompatTextHelper_android_drawableTop)) {
      this.mDrawableTopTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(b.a.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((TintTypedArray)localObject1).hasValue(b.a.AppCompatTextHelper_android_drawableRight)) {
      this.mDrawableRightTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(b.a.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((TintTypedArray)localObject1).hasValue(b.a.AppCompatTextHelper_android_drawableBottom)) {
      this.mDrawableBottomTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(b.a.AppCompatTextHelper_android_drawableBottom, 0));
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (((TintTypedArray)localObject1).hasValue(b.a.AppCompatTextHelper_android_drawableStart)) {
        this.mDrawableStartTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(b.a.AppCompatTextHelper_android_drawableStart, 0));
      }
      if (((TintTypedArray)localObject1).hasValue(b.a.AppCompatTextHelper_android_drawableEnd)) {
        this.mDrawableEndTint = createTintInfo(localContext, localAppCompatDrawableManager, ((TintTypedArray)localObject1).getResourceId(b.a.AppCompatTextHelper_android_drawableEnd, 0));
      }
    }
    ((TintTypedArray)localObject1).recycle();
    boolean bool3 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
    boolean bool1 = false;
    boolean bool2 = false;
    int i = 0;
    int j = 0;
    localObject1 = null;
    Object localObject2 = null;
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject6 = null;
    Object localObject5 = null;
    if (k != -1)
    {
      localObject8 = TintTypedArray.obtainStyledAttributes(localContext, k, b.a.TextAppearance);
      i = j;
      bool1 = bool2;
      if (!bool3)
      {
        i = j;
        bool1 = bool2;
        if (((TintTypedArray)localObject8).hasValue(b.a.TextAppearance_textAllCaps))
        {
          i = 1;
          bool1 = ((TintTypedArray)localObject8).getBoolean(b.a.TextAppearance_textAllCaps, false);
        }
      }
      updateTypefaceAndStyle(localContext, (TintTypedArray)localObject8);
      if (Build.VERSION.SDK_INT < 23)
      {
        if (((TintTypedArray)localObject8).hasValue(b.a.TextAppearance_android_textColor)) {
          localObject1 = ((TintTypedArray)localObject8).getColorStateList(b.a.TextAppearance_android_textColor);
        }
        localObject6 = localObject7;
        if (((TintTypedArray)localObject8).hasValue(b.a.TextAppearance_android_textColorHint)) {
          localObject6 = ((TintTypedArray)localObject8).getColorStateList(b.a.TextAppearance_android_textColorHint);
        }
        if (((TintTypedArray)localObject8).hasValue(b.a.TextAppearance_android_textColorLink))
        {
          localObject4 = ((TintTypedArray)localObject8).getColorStateList(b.a.TextAppearance_android_textColorLink);
          localObject2 = localObject1;
          localObject1 = localObject4;
          if (((TintTypedArray)localObject8).hasValue(b.a.TextAppearance_textLocale)) {
            localObject5 = ((TintTypedArray)localObject8).getString(b.a.TextAppearance_textLocale);
          }
          localObject4 = localObject3;
          if (Build.VERSION.SDK_INT >= 26)
          {
            localObject4 = localObject3;
            if (((TintTypedArray)localObject8).hasValue(b.a.TextAppearance_fontVariationSettings)) {
              localObject4 = ((TintTypedArray)localObject8).getString(b.a.TextAppearance_fontVariationSettings);
            }
          }
          ((TintTypedArray)localObject8).recycle();
          localObject3 = localObject2;
          localObject2 = localObject6;
        }
      }
    }
    for (;;)
    {
      TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, b.a.TextAppearance, paramInt, 0);
      j = i;
      bool2 = bool1;
      if (!bool3)
      {
        j = i;
        bool2 = bool1;
        if (localTintTypedArray.hasValue(b.a.TextAppearance_textAllCaps))
        {
          j = 1;
          bool2 = localTintTypedArray.getBoolean(b.a.TextAppearance_textAllCaps, false);
        }
      }
      localObject8 = localObject1;
      localObject6 = localObject2;
      localObject7 = localObject3;
      if (Build.VERSION.SDK_INT < 23)
      {
        if (localTintTypedArray.hasValue(b.a.TextAppearance_android_textColor)) {
          localObject3 = localTintTypedArray.getColorStateList(b.a.TextAppearance_android_textColor);
        }
        if (localTintTypedArray.hasValue(b.a.TextAppearance_android_textColorHint)) {
          localObject2 = localTintTypedArray.getColorStateList(b.a.TextAppearance_android_textColorHint);
        }
        localObject8 = localObject1;
        localObject6 = localObject2;
        localObject7 = localObject3;
        if (localTintTypedArray.hasValue(b.a.TextAppearance_android_textColorLink))
        {
          localObject8 = localTintTypedArray.getColorStateList(b.a.TextAppearance_android_textColorLink);
          localObject7 = localObject3;
          localObject6 = localObject2;
        }
      }
      if (localTintTypedArray.hasValue(b.a.TextAppearance_textLocale)) {
        localObject5 = localTintTypedArray.getString(b.a.TextAppearance_textLocale);
      }
      localObject1 = localObject4;
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject1 = localObject4;
        if (localTintTypedArray.hasValue(b.a.TextAppearance_fontVariationSettings)) {
          localObject1 = localTintTypedArray.getString(b.a.TextAppearance_fontVariationSettings);
        }
      }
      if ((Build.VERSION.SDK_INT >= 28) && (localTintTypedArray.hasValue(b.a.TextAppearance_android_textSize)) && (localTintTypedArray.getDimensionPixelSize(b.a.TextAppearance_android_textSize, -1) == 0)) {
        this.mView.setTextSize(0, 0.0F);
      }
      updateTypefaceAndStyle(localContext, localTintTypedArray);
      localTintTypedArray.recycle();
      if (localObject7 != null) {
        this.mView.setTextColor(localObject7);
      }
      if (localObject6 != null) {
        this.mView.setHintTextColor((ColorStateList)localObject6);
      }
      if (localObject8 != null) {
        this.mView.setLinkTextColor((ColorStateList)localObject8);
      }
      if ((!bool3) && (j != 0)) {
        setAllCaps(bool2);
      }
      if (this.mFontTypeface != null)
      {
        if (this.mFontWeight == -1) {
          this.mView.setTypeface(this.mFontTypeface, this.mStyle);
        }
      }
      else
      {
        if (localObject1 != null) {
          this.mView.setFontVariationSettings((String)localObject1);
        }
        if (localObject5 != null)
        {
          if (Build.VERSION.SDK_INT < 24) {
            break label1335;
          }
          this.mView.setTextLocales(LocaleList.forLanguageTags((String)localObject5));
        }
        label906:
        this.mAutoSizeTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
        if ((AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (this.mAutoSizeTextHelper.getAutoSizeTextType() != 0))
        {
          localObject1 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
          if (localObject1.length > 0)
          {
            if (this.mView.getAutoSizeStepGranularity() == -1.0F) {
              break label1373;
            }
            this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
          }
        }
      }
      for (;;)
      {
        localObject6 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, b.a.AppCompatTextView);
        paramAttributeSet = null;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject5 = null;
        paramInt = ((TintTypedArray)localObject6).getResourceId(b.a.AppCompatTextView_drawableLeftCompat, -1);
        if (paramInt != -1) {
          paramAttributeSet = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
        }
        paramInt = ((TintTypedArray)localObject6).getResourceId(b.a.AppCompatTextView_drawableTopCompat, -1);
        if (paramInt != -1) {
          localObject1 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
        }
        paramInt = ((TintTypedArray)localObject6).getResourceId(b.a.AppCompatTextView_drawableRightCompat, -1);
        if (paramInt != -1) {
          localObject2 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
        }
        paramInt = ((TintTypedArray)localObject6).getResourceId(b.a.AppCompatTextView_drawableBottomCompat, -1);
        if (paramInt != -1) {
          localObject3 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
        }
        paramInt = ((TintTypedArray)localObject6).getResourceId(b.a.AppCompatTextView_drawableStartCompat, -1);
        if (paramInt != -1) {
          localObject4 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
        }
        paramInt = ((TintTypedArray)localObject6).getResourceId(b.a.AppCompatTextView_drawableEndCompat, -1);
        if (paramInt != -1) {
          localObject5 = localAppCompatDrawableManager.getDrawable(localContext, paramInt);
        }
        setCompoundDrawables(paramAttributeSet, (Drawable)localObject1, (Drawable)localObject2, (Drawable)localObject3, (Drawable)localObject4, (Drawable)localObject5);
        if (((TintTypedArray)localObject6).hasValue(b.a.AppCompatTextView_drawableTint))
        {
          paramAttributeSet = ((TintTypedArray)localObject6).getColorStateList(b.a.AppCompatTextView_drawableTint);
          TextViewCompat.setCompoundDrawableTintList(this.mView, paramAttributeSet);
        }
        if (((TintTypedArray)localObject6).hasValue(b.a.AppCompatTextView_drawableTintMode))
        {
          paramAttributeSet = DrawableUtils.parseTintMode(((TintTypedArray)localObject6).getInt(b.a.AppCompatTextView_drawableTintMode, -1), null);
          TextViewCompat.setCompoundDrawableTintMode(this.mView, paramAttributeSet);
        }
        paramInt = ((TintTypedArray)localObject6).getDimensionPixelSize(b.a.AppCompatTextView_firstBaselineToTopHeight, -1);
        i = ((TintTypedArray)localObject6).getDimensionPixelSize(b.a.AppCompatTextView_lastBaselineToBottomHeight, -1);
        j = ((TintTypedArray)localObject6).getDimensionPixelSize(b.a.AppCompatTextView_lineHeight, -1);
        ((TintTypedArray)localObject6).recycle();
        if (paramInt != -1) {
          TextViewCompat.setFirstBaselineToTopHeight(this.mView, paramInt);
        }
        if (i != -1) {
          TextViewCompat.setLastBaselineToBottomHeight(this.mView, i);
        }
        if (j != -1) {
          TextViewCompat.setLineHeight(this.mView, j);
        }
        return;
        this.mView.setTypeface(this.mFontTypeface);
        break;
        label1335:
        if (Build.VERSION.SDK_INT < 21) {
          break label906;
        }
        localObject1 = ((String)localObject5).substring(0, ((String)localObject5).indexOf(','));
        this.mView.setTextLocale(Locale.forLanguageTag((String)localObject1));
        break label906;
        label1373:
        this.mView.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
      }
      localObject2 = localObject1;
      localObject1 = null;
      break;
      localObject4 = null;
      localObject1 = null;
      localObject6 = localObject2;
      localObject2 = localObject4;
      break;
      localObject3 = null;
      localObject1 = null;
      localObject2 = localObject8;
      localObject5 = localObject6;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
      autoSizeText();
    }
  }
  
  void onSetCompoundDrawables()
  {
    applyCompoundDrawablesTints();
  }
  
  void onSetTextAppearance(Context paramContext, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, b.a.TextAppearance);
    if (localTintTypedArray.hasValue(b.a.TextAppearance_textAllCaps)) {
      setAllCaps(localTintTypedArray.getBoolean(b.a.TextAppearance_textAllCaps, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localTintTypedArray.hasValue(b.a.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localTintTypedArray.getColorStateList(b.a.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        this.mView.setTextColor(localColorStateList);
      }
    }
    if ((localTintTypedArray.hasValue(b.a.TextAppearance_android_textSize)) && (localTintTypedArray.getDimensionPixelSize(b.a.TextAppearance_android_textSize, -1) == 0)) {
      this.mView.setTextSize(0, 0.0F);
    }
    updateTypefaceAndStyle(paramContext, localTintTypedArray);
    if ((Build.VERSION.SDK_INT >= 26) && (localTintTypedArray.hasValue(b.a.TextAppearance_fontVariationSettings)))
    {
      paramContext = localTintTypedArray.getString(b.a.TextAppearance_fontVariationSettings);
      if (paramContext != null) {
        this.mView.setFontVariationSettings(paramContext);
      }
    }
    localTintTypedArray.recycle();
    if (this.mFontTypeface != null) {
      this.mView.setTypeface(this.mFontTypeface, this.mStyle);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void runOnUiThread(@NonNull Runnable paramRunnable)
  {
    this.mView.post(paramRunnable);
  }
  
  void setAllCaps(boolean paramBoolean)
  {
    this.mView.setAllCaps(paramBoolean);
  }
  
  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  void setCompoundDrawableTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mDrawableTint == null) {
      this.mDrawableTint = new TintInfo();
    }
    this.mDrawableTint.mTintList = paramColorStateList;
    TintInfo localTintInfo = this.mDrawableTint;
    if (paramColorStateList != null) {}
    for (boolean bool = true;; bool = false)
    {
      localTintInfo.mHasTintList = bool;
      setCompoundTints();
      return;
    }
  }
  
  void setCompoundDrawableTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.mDrawableTint == null) {
      this.mDrawableTint = new TintInfo();
    }
    this.mDrawableTint.mTintMode = paramMode;
    TintInfo localTintInfo = this.mDrawableTint;
    if (paramMode != null) {}
    for (boolean bool = true;; bool = false)
    {
      localTintInfo.mHasTintMode = bool;
      setCompoundTints();
      return;
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  void setTextSize(int paramInt, float paramFloat)
  {
    if ((!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (!isAutoSizeEnabled())) {
      setTextSizeInternal(paramInt, paramFloat);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public void setTypefaceByCallback(@NonNull Typeface paramTypeface)
  {
    if (this.mAsyncFontPending)
    {
      this.mView.setTypeface(paramTypeface);
      this.mFontTypeface = paramTypeface;
    }
  }
  
  static class ApplyTextViewCallback
    extends ResourcesCompat.FontCallback
  {
    private final int mFontWeight;
    private final WeakReference<AppCompatTextHelper> mParent;
    private final int mStyle;
    
    ApplyTextViewCallback(@NonNull AppCompatTextHelper paramAppCompatTextHelper, int paramInt1, int paramInt2)
    {
      this.mParent = new WeakReference(paramAppCompatTextHelper);
      this.mFontWeight = paramInt1;
      this.mStyle = paramInt2;
    }
    
    public void onFontRetrievalFailed(int paramInt) {}
    
    public void onFontRetrieved(@NonNull Typeface paramTypeface)
    {
      AppCompatTextHelper localAppCompatTextHelper = (AppCompatTextHelper)this.mParent.get();
      if (localAppCompatTextHelper == null) {
        return;
      }
      Typeface localTypeface = paramTypeface;
      int i;
      if (Build.VERSION.SDK_INT >= 28)
      {
        localTypeface = paramTypeface;
        if (this.mFontWeight != -1)
        {
          i = this.mFontWeight;
          if ((this.mStyle & 0x2) == 0) {
            break label84;
          }
        }
      }
      label84:
      for (boolean bool = true;; bool = false)
      {
        localTypeface = Typeface.create(paramTypeface, i, bool);
        localAppCompatTextHelper.runOnUiThread(new TypefaceApplyCallback(this.mParent, localTypeface));
        return;
      }
    }
    
    class TypefaceApplyCallback
      implements Runnable
    {
      private final WeakReference<AppCompatTextHelper> mParent;
      private final Typeface mTypeface;
      
      TypefaceApplyCallback(@NonNull Typeface paramTypeface)
      {
        this.mParent = paramTypeface;
        Object localObject;
        this.mTypeface = localObject;
      }
      
      public void run()
      {
        AppCompatTextHelper localAppCompatTextHelper = (AppCompatTextHelper)this.mParent.get();
        if (localAppCompatTextHelper == null) {
          return;
        }
        localAppCompatTextHelper.setTypefaceByCallback(this.mTypeface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextHelper
 * JD-Core Version:    0.7.0.1
 */