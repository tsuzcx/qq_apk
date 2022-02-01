package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;

final class AppCompatDrawableManager$1
  implements ResourceManagerInternal.ResourceManagerHooks
{
  private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = { 2130837560, 2130837520, 2130837559 };
  private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = { 2130837585, 2130837587, 2130837522, 2130837578, 2130837579, 2130837581, 2130837583, 2130837580, 2130837582, 2130837584 };
  private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = { 2130837588, 2130837586, 2130837505 };
  private final int[] TINT_CHECKABLE_BUTTON_LIST = { 2130837508, 2130837514, 2130837509, 2130837515 };
  private final int[] TINT_COLOR_CONTROL_NORMAL = { 2130837529, 2130837570, 2130837536, 2130837531, 2130837532, 2130837535, 2130837534 };
  private final int[] TINT_COLOR_CONTROL_STATE_LIST = { 2130837576, 2130837589 };
  
  private boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private ColorStateList createBorderlessButtonColorStateList(@NonNull Context paramContext)
  {
    return createButtonColorStateList(paramContext, 0);
  }
  
  private ColorStateList createButtonColorStateList(@NonNull Context paramContext, @ColorInt int paramInt)
  {
    int k = ThemeUtils.getThemeAttrColor(paramContext, 2131034379);
    int i = ThemeUtils.getDisabledThemeAttrColor(paramContext, 2131034377);
    paramContext = ThemeUtils.DISABLED_STATE_SET;
    int[] arrayOfInt1 = ThemeUtils.PRESSED_STATE_SET;
    int j = ColorUtils.compositeColors(k, paramInt);
    int[] arrayOfInt2 = ThemeUtils.FOCUSED_STATE_SET;
    k = ColorUtils.compositeColors(k, paramInt);
    return new ColorStateList(new int[][] { paramContext, arrayOfInt1, arrayOfInt2, ThemeUtils.EMPTY_STATE_SET }, new int[] { i, j, k, paramInt });
  }
  
  private ColorStateList createColoredButtonColorStateList(@NonNull Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, 2131034375));
  }
  
  private ColorStateList createDefaultButtonColorStateList(@NonNull Context paramContext)
  {
    return createButtonColorStateList(paramContext, ThemeUtils.getThemeAttrColor(paramContext, 2131034377));
  }
  
  private ColorStateList createSwitchThumbColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList localColorStateList = ThemeUtils.getThemeAttrColorStateList(paramContext, 2131034391);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, 2131034378);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    for (;;)
    {
      return new ColorStateList(arrayOfInt, arrayOfInt1);
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, 2131034391);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, 2131034378);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, 2131034391);
    }
  }
  
  private void setPorterDuffColorFilter(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = AppCompatDrawableManager.access$000();
    }
    localDrawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(paramInt, paramDrawable));
  }
  
  public Drawable createDrawableFor(@NonNull ResourceManagerInternal paramResourceManagerInternal, @NonNull Context paramContext, int paramInt)
  {
    if (paramInt == 2130837521) {
      return new LayerDrawable(new Drawable[] { paramResourceManagerInternal.getDrawable(paramContext, 2130837520), paramResourceManagerInternal.getDrawable(paramContext, 2130837522) });
    }
    return null;
  }
  
  public ColorStateList getTintListForDrawableRes(@NonNull Context paramContext, int paramInt)
  {
    if (paramInt == 2130837525) {
      return AppCompatResources.getColorStateList(paramContext, 2131165219);
    }
    if (paramInt == 2130837575) {
      return AppCompatResources.getColorStateList(paramContext, 2131165222);
    }
    if (paramInt == 2130837574) {
      return createSwitchThumbColorStateList(paramContext);
    }
    if (paramInt == 2130837513) {
      return createDefaultButtonColorStateList(paramContext);
    }
    if (paramInt == 2130837507) {
      return createBorderlessButtonColorStateList(paramContext);
    }
    if (paramInt == 2130837512) {
      return createColoredButtonColorStateList(paramContext);
    }
    if ((paramInt == 2130837572) || (paramInt == 2130837573)) {
      return AppCompatResources.getColorStateList(paramContext, 2131165221);
    }
    if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, paramInt)) {
      return ThemeUtils.getThemeAttrColorStateList(paramContext, 2131034380);
    }
    if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, paramInt)) {
      return AppCompatResources.getColorStateList(paramContext, 2131165218);
    }
    if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, paramInt)) {
      return AppCompatResources.getColorStateList(paramContext, 2131165217);
    }
    if (paramInt == 2130837569) {
      return AppCompatResources.getColorStateList(paramContext, 2131165220);
    }
    return null;
  }
  
  public PorterDuff.Mode getTintModeForDrawableRes(int paramInt)
  {
    PorterDuff.Mode localMode = null;
    if (paramInt == 2130837574) {
      localMode = PorterDuff.Mode.MULTIPLY;
    }
    return localMode;
  }
  
  public boolean tintDrawable(@NonNull Context paramContext, int paramInt, @NonNull Drawable paramDrawable)
  {
    if (paramInt == 2130837571)
    {
      paramDrawable = (LayerDrawable)paramDrawable;
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(paramContext, 2131034380), AppCompatDrawableManager.access$000());
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, 2131034380), AppCompatDrawableManager.access$000());
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, 2131034378), AppCompatDrawableManager.access$000());
      return true;
    }
    if ((paramInt == 2130837562) || (paramInt == 2130837561) || (paramInt == 2130837563))
    {
      paramDrawable = (LayerDrawable)paramDrawable;
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(paramContext, 2131034380), AppCompatDrawableManager.access$000());
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(paramContext, 2131034378), AppCompatDrawableManager.access$000());
      setPorterDuffColorFilter(paramDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(paramContext, 2131034378), AppCompatDrawableManager.access$000());
      return true;
    }
    return false;
  }
  
  public boolean tintDrawableUsingColorFilter(@NonNull Context paramContext, int paramInt, @NonNull Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = AppCompatDrawableManager.access$000();
    int i;
    int j;
    if (arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt))
    {
      i = 2131034380;
      j = 1;
      paramInt = -1;
    }
    for (;;)
    {
      if (j != 0)
      {
        Drawable localDrawable = paramDrawable;
        if (DrawableUtils.canSafelyMutateDrawable(paramDrawable)) {
          localDrawable = paramDrawable.mutate();
        }
        localDrawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(paramContext, i), localMode));
        if (paramInt != -1) {
          localDrawable.setAlpha(paramInt);
        }
        return true;
        if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt))
        {
          i = 2131034378;
          j = 1;
          paramInt = -1;
          continue;
        }
        if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt))
        {
          localMode = PorterDuff.Mode.MULTIPLY;
          j = 1;
          i = 16842801;
          paramInt = -1;
          continue;
        }
        if (paramInt == 2130837548)
        {
          i = 16842800;
          paramInt = Math.round(40.799999F);
          j = 1;
          continue;
        }
        if (paramInt == 2130837524)
        {
          i = 16842801;
          j = 1;
          paramInt = -1;
        }
      }
      else
      {
        return false;
      }
      paramInt = -1;
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatDrawableManager.1
 * JD-Core Version:    0.7.0.1
 */