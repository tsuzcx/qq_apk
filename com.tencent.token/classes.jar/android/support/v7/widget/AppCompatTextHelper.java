package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.ResourcesCompat.FontCallback;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v7.appcompat.R.styleable;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

@RequiresApi(9)
class AppCompatTextHelper
{
  private static final int MONOSPACE = 3;
  private static final int SANS = 1;
  private static final int SERIF = 2;
  private boolean mAsyncFontPending;
  @NonNull
  private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
  private TintInfo mDrawableBottomTint;
  private TintInfo mDrawableLeftTint;
  private TintInfo mDrawableRightTint;
  private TintInfo mDrawableTopTint;
  private Typeface mFontTypeface;
  private int mStyle = 0;
  final TextView mView;
  
  AppCompatTextHelper(TextView paramTextView)
  {
    this.mView = paramTextView;
    this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(this.mView);
  }
  
  static AppCompatTextHelper create(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new AppCompatTextHelperV17(paramTextView);
    }
    return new AppCompatTextHelper(paramTextView);
  }
  
  protected static TintInfo createTintInfo(Context paramContext, AppCompatDrawableManager paramAppCompatDrawableManager, int paramInt)
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
  
  private void onAsyncTypefaceReceived(WeakReference<TextView> paramWeakReference, Typeface paramTypeface)
  {
    if (this.mAsyncFontPending)
    {
      this.mFontTypeface = paramTypeface;
      paramWeakReference = (TextView)paramWeakReference.get();
      if (paramWeakReference != null) {
        paramWeakReference.setTypeface(paramTypeface, this.mStyle);
      }
    }
  }
  
  private void setTextSizeInternal(int paramInt, float paramFloat)
  {
    this.mAutoSizeTextHelper.setTextSizeInternal(paramInt, paramFloat);
  }
  
  private void updateTypefaceAndStyle(Context paramContext, TintTypedArray paramTintTypedArray)
  {
    boolean bool = true;
    this.mStyle = paramTintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
    if ((paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_fontFamily)) || (paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)))
    {
      this.mFontTypeface = null;
      if (paramTintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily))
      {
        i = R.styleable.TextAppearance_fontFamily;
        if (!paramContext.isRestricted()) {
          paramContext = new ResourcesCompat.FontCallback()
          {
            public void onFontRetrievalFailed(int paramAnonymousInt) {}
            
            public void onFontRetrieved(@NonNull Typeface paramAnonymousTypeface)
            {
              AppCompatTextHelper.this.onAsyncTypefaceReceived(this.val$textViewWeak, paramAnonymousTypeface);
            }
          };
        }
      }
    }
    try
    {
      this.mFontTypeface = paramTintTypedArray.getFont(i, this.mStyle, paramContext);
      if (this.mFontTypeface != null) {
        break label148;
      }
      this.mAsyncFontPending = bool;
    }
    catch (UnsupportedOperationException paramContext)
    {
      break label111;
    }
    catch (Resources.NotFoundException paramContext)
    {
      label111:
      break label111;
    }
    if (this.mFontTypeface == null)
    {
      paramContext = paramTintTypedArray.getString(i);
      if (paramContext != null) {
        this.mFontTypeface = Typeface.create(paramContext, this.mStyle);
      }
    }
    label148:
    while (!paramTintTypedArray.hasValue(R.styleable.TextAppearance_android_typeface)) {
      for (;;)
      {
        return;
        int i = R.styleable.TextAppearance_android_fontFamily;
        continue;
        bool = false;
      }
    }
    this.mAsyncFontPending = false;
    switch (paramTintTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1))
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
  }
  
  final void applyCompoundDrawableTint(Drawable paramDrawable, TintInfo paramTintInfo)
  {
    if ((paramDrawable != null) && (paramTintInfo != null)) {
      AppCompatDrawableManager.tintDrawable(paramDrawable, paramTintInfo, this.mView.getDrawableState());
    }
  }
  
  void applyCompoundDrawablesTints()
  {
    if ((this.mDrawableLeftTint != null) || (this.mDrawableTopTint != null) || (this.mDrawableRightTint != null) || (this.mDrawableBottomTint != null))
    {
      Drawable[] arrayOfDrawable = this.mView.getCompoundDrawables();
      applyCompoundDrawableTint(arrayOfDrawable[0], this.mDrawableLeftTint);
      applyCompoundDrawableTint(arrayOfDrawable[1], this.mDrawableTopTint);
      applyCompoundDrawableTint(arrayOfDrawable[2], this.mDrawableRightTint);
      applyCompoundDrawableTint(arrayOfDrawable[3], this.mDrawableBottomTint);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
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
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  boolean isAutoSizeEnabled()
  {
    return this.mAutoSizeTextHelper.isAutoSizeEnabled();
  }
  
  @SuppressLint({"NewApi"})
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Context localContext = this.mView.getContext();
    Object localObject1 = AppCompatDrawableManager.get();
    Object localObject2 = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.AppCompatTextHelper, paramInt, 0);
    int i = ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    if (((TintTypedArray)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
      this.mDrawableLeftTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject1, ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((TintTypedArray)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableTop)) {
      this.mDrawableTopTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject1, ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((TintTypedArray)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableRight)) {
      this.mDrawableRightTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject1, ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((TintTypedArray)localObject2).hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
      this.mDrawableBottomTint = createTintInfo(localContext, (AppCompatDrawableManager)localObject1, ((TintTypedArray)localObject2).getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
    }
    ((TintTypedArray)localObject2).recycle();
    boolean bool3 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
    Object localObject6;
    boolean bool1;
    label266:
    label287:
    Object localObject5;
    if (i != -1)
    {
      localObject6 = TintTypedArray.obtainStyledAttributes(localContext, i, R.styleable.TextAppearance);
      if ((!bool3) && (((TintTypedArray)localObject6).hasValue(R.styleable.TextAppearance_textAllCaps)))
      {
        bool1 = ((TintTypedArray)localObject6).getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        i = 1;
        updateTypefaceAndStyle(localContext, (TintTypedArray)localObject6);
        if (Build.VERSION.SDK_INT < 23) {
          if (((TintTypedArray)localObject6).hasValue(R.styleable.TextAppearance_android_textColor))
          {
            localObject1 = ((TintTypedArray)localObject6).getColorStateList(R.styleable.TextAppearance_android_textColor);
            if (((TintTypedArray)localObject6).hasValue(R.styleable.TextAppearance_android_textColorHint))
            {
              localObject3 = ((TintTypedArray)localObject6).getColorStateList(R.styleable.TextAppearance_android_textColorHint);
              localObject2 = localObject1;
              localObject5 = localObject3;
              if (((TintTypedArray)localObject6).hasValue(R.styleable.TextAppearance_android_textColorLink))
              {
                localObject4 = ((TintTypedArray)localObject6).getColorStateList(R.styleable.TextAppearance_android_textColorLink);
                localObject5 = localObject3;
                localObject2 = localObject1;
              }
              label324:
              ((TintTypedArray)localObject6).recycle();
              localObject1 = localObject5;
              localObject3 = localObject4;
            }
          }
        }
      }
    }
    for (;;)
    {
      TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(localContext, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
      int j = i;
      boolean bool2 = bool1;
      if (!bool3)
      {
        j = i;
        bool2 = bool1;
        if (localTintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps))
        {
          bool2 = localTintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
          j = 1;
        }
      }
      localObject5 = localObject2;
      localObject6 = localObject3;
      localObject4 = localObject1;
      if (Build.VERSION.SDK_INT < 23)
      {
        if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)) {
          localObject2 = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
        }
        if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorHint)) {
          localObject1 = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorHint);
        }
        localObject5 = localObject2;
        localObject6 = localObject3;
        localObject4 = localObject1;
        if (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColorLink))
        {
          localObject6 = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColorLink);
          localObject4 = localObject1;
          localObject5 = localObject2;
        }
      }
      updateTypefaceAndStyle(localContext, localTintTypedArray);
      localTintTypedArray.recycle();
      if (localObject5 != null) {
        this.mView.setTextColor(localObject5);
      }
      if (localObject4 != null) {
        this.mView.setHintTextColor((ColorStateList)localObject4);
      }
      if (localObject6 != null) {
        this.mView.setLinkTextColor((ColorStateList)localObject6);
      }
      if ((!bool3) && (j != 0)) {
        setAllCaps(bool2);
      }
      if (this.mFontTypeface != null) {
        this.mView.setTypeface(this.mFontTypeface, this.mStyle);
      }
      this.mAutoSizeTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
      if ((AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (this.mAutoSizeTextHelper.getAutoSizeTextType() != 0))
      {
        paramAttributeSet = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
        if (paramAttributeSet.length > 0)
        {
          if (this.mView.getAutoSizeStepGranularity() == -1.0F) {
            break label673;
          }
          this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        }
      }
      return;
      label673:
      this.mView.setAutoSizeTextTypeUniformWithPresetSizes(paramAttributeSet, 0);
      return;
      localObject3 = null;
      break label287;
      localObject1 = null;
      break label266;
      localObject5 = null;
      localObject2 = null;
      break label324;
      i = 0;
      bool1 = false;
      break;
      localObject1 = null;
      localObject2 = null;
      i = 0;
      bool1 = false;
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
      autoSizeText();
    }
  }
  
  void onSetTextAppearance(Context paramContext, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramInt, R.styleable.TextAppearance);
    if (localTintTypedArray.hasValue(R.styleable.TextAppearance_textAllCaps)) {
      setAllCaps(localTintTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localTintTypedArray.hasValue(R.styleable.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localTintTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        this.mView.setTextColor(localColorStateList);
      }
    }
    updateTypefaceAndStyle(paramContext, localTintTypedArray);
    localTintTypedArray.recycle();
    if (this.mFontTypeface != null) {
      this.mView.setTypeface(this.mFontTypeface, this.mStyle);
    }
  }
  
  void setAllCaps(boolean paramBoolean)
  {
    this.mView.setAllCaps(paramBoolean);
  }
  
  void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] paramArrayOfInt, int paramInt)
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
  }
  
  void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(paramInt);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void setTextSize(int paramInt, float paramFloat)
  {
    if ((!AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) && (!isAutoSizeEnabled())) {
      setTextSizeInternal(paramInt, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextHelper
 * JD-Core Version:    0.7.0.1
 */