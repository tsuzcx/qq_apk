package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.os.BuildCompat;
import android.view.ActionMode.Callback;
import android.widget.TextView;

public final class TextViewCompat
{
  public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
  public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
  static final TextViewCompat.TextViewCompatBaseImpl IMPL = new TextViewCompat.TextViewCompatBaseImpl();
  
  static
  {
    if (BuildCompat.isAtLeastOMR1())
    {
      IMPL = new TextViewCompat.TextViewCompatApi27Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      IMPL = new TextViewCompat.TextViewCompatApi26Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      IMPL = new TextViewCompat.TextViewCompatApi23Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new TextViewCompat.TextViewCompatApi18Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      IMPL = new TextViewCompat.TextViewCompatApi17Impl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new TextViewCompat.TextViewCompatApi16Impl();
      return;
    }
  }
  
  public static int getAutoSizeMaxTextSize(@NonNull TextView paramTextView)
  {
    return IMPL.getAutoSizeMaxTextSize(paramTextView);
  }
  
  public static int getAutoSizeMinTextSize(@NonNull TextView paramTextView)
  {
    return IMPL.getAutoSizeMinTextSize(paramTextView);
  }
  
  public static int getAutoSizeStepGranularity(@NonNull TextView paramTextView)
  {
    return IMPL.getAutoSizeStepGranularity(paramTextView);
  }
  
  @NonNull
  public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView paramTextView)
  {
    return IMPL.getAutoSizeTextAvailableSizes(paramTextView);
  }
  
  public static int getAutoSizeTextType(@NonNull TextView paramTextView)
  {
    return IMPL.getAutoSizeTextType(paramTextView);
  }
  
  @NonNull
  public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView paramTextView)
  {
    return IMPL.getCompoundDrawablesRelative(paramTextView);
  }
  
  public static int getMaxLines(@NonNull TextView paramTextView)
  {
    return IMPL.getMaxLines(paramTextView);
  }
  
  public static int getMinLines(@NonNull TextView paramTextView)
  {
    return IMPL.getMinLines(paramTextView);
  }
  
  public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setAutoSizeTextTypeUniformWithConfiguration(paramTextView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView paramTextView, @NonNull int[] paramArrayOfInt, int paramInt)
  {
    IMPL.setAutoSizeTextTypeUniformWithPresetSizes(paramTextView, paramArrayOfInt, paramInt);
  }
  
  public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView paramTextView, int paramInt)
  {
    IMPL.setAutoSizeTextTypeWithDefaults(paramTextView, paramInt);
  }
  
  public static void setCompoundDrawablesRelative(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    IMPL.setCompoundDrawablesRelative(paramTextView, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4)
  {
    IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(paramTextView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView paramTextView, @Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(paramTextView, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public static void setCustomSelectionActionModeCallback(@NonNull TextView paramTextView, @NonNull ActionMode.Callback paramCallback)
  {
    IMPL.setCustomSelectionActionModeCallback(paramTextView, paramCallback);
  }
  
  public static void setTextAppearance(@NonNull TextView paramTextView, @StyleRes int paramInt)
  {
    IMPL.setTextAppearance(paramTextView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.TextViewCompat
 * JD-Core Version:    0.7.0.1
 */