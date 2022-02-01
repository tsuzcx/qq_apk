package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class DrawableCompat
{
  private static final String TAG = "DrawableCompat";
  private static Method sGetLayoutDirectionMethod;
  private static boolean sGetLayoutDirectionMethodFetched;
  private static Method sSetLayoutDirectionMethod;
  private static boolean sSetLayoutDirectionMethodFetched;
  
  public static void applyTheme(@NonNull Drawable paramDrawable, @NonNull Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.applyTheme(paramTheme);
    }
  }
  
  public static boolean canApplyTheme(@NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramDrawable.canApplyTheme();
    }
    return false;
  }
  
  public static void clearColorFilter(@NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramDrawable.clearColorFilter();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.clearColorFilter();
      if ((paramDrawable instanceof InsetDrawable))
      {
        clearColorFilter(((InsetDrawable)paramDrawable).getDrawable());
        return;
      }
      if ((paramDrawable instanceof WrappedDrawable))
      {
        clearColorFilter(((WrappedDrawable)paramDrawable).getWrappedDrawable());
        return;
      }
      if ((paramDrawable instanceof DrawableContainer))
      {
        paramDrawable = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
        if (paramDrawable != null)
        {
          int i = 0;
          int j = paramDrawable.getChildCount();
          while (i < j)
          {
            Drawable localDrawable = paramDrawable.getChild(i);
            if (localDrawable != null) {
              clearColorFilter(localDrawable);
            }
            i += 1;
          }
        }
      }
    }
    else
    {
      paramDrawable.clearColorFilter();
    }
  }
  
  public static int getAlpha(@NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramDrawable.getAlpha();
    }
    return 0;
  }
  
  public static ColorFilter getColorFilter(@NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramDrawable.getColorFilter();
    }
    return null;
  }
  
  public static int getLayoutDirection(@NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.getLayoutDirection();
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (!sGetLayoutDirectionMethodFetched)
      {
        try
        {
          sGetLayoutDirectionMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
          sGetLayoutDirectionMethod.setAccessible(true);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", localNoSuchMethodException);
        }
        sGetLayoutDirectionMethodFetched = true;
      }
      Method localMethod = sGetLayoutDirectionMethod;
      if (localMethod != null) {
        try
        {
          int i = ((Integer)localMethod.invoke(paramDrawable, new Object[0])).intValue();
          return i;
        }
        catch (Exception paramDrawable)
        {
          Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", paramDrawable);
          sGetLayoutDirectionMethod = null;
        }
      }
      return 0;
    }
    return 0;
  }
  
  public static void inflate(@NonNull Drawable paramDrawable, @NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public static boolean isAutoMirrored(@NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramDrawable.isAutoMirrored();
    }
    return false;
  }
  
  @Deprecated
  public static void jumpToCurrentState(@NonNull Drawable paramDrawable)
  {
    paramDrawable.jumpToCurrentState();
  }
  
  public static void setAutoMirrored(@NonNull Drawable paramDrawable, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramDrawable.setAutoMirrored(paramBoolean);
    }
  }
  
  public static void setHotspot(@NonNull Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  public static void setHotspotBounds(@NonNull Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static boolean setLayoutDirection(@NonNull Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable.setLayoutDirection(paramInt);
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (!sSetLayoutDirectionMethodFetched)
      {
        try
        {
          sSetLayoutDirectionMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[] { Integer.TYPE });
          sSetLayoutDirectionMethod.setAccessible(true);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", localNoSuchMethodException);
        }
        sSetLayoutDirectionMethodFetched = true;
      }
      Method localMethod = sSetLayoutDirectionMethod;
      if (localMethod != null) {
        try
        {
          localMethod.invoke(paramDrawable, new Object[] { Integer.valueOf(paramInt) });
          return true;
        }
        catch (Exception paramDrawable)
        {
          Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", paramDrawable);
          sSetLayoutDirectionMethod = null;
        }
      }
      return false;
    }
    return false;
  }
  
  public static void setTint(@NonNull Drawable paramDrawable, @ColorInt int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTint(paramInt);
      return;
    }
    if ((paramDrawable instanceof TintAwareDrawable)) {
      ((TintAwareDrawable)paramDrawable).setTint(paramInt);
    }
  }
  
  public static void setTintList(@NonNull Drawable paramDrawable, @Nullable ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTintList(paramColorStateList);
      return;
    }
    if ((paramDrawable instanceof TintAwareDrawable)) {
      ((TintAwareDrawable)paramDrawable).setTintList(paramColorStateList);
    }
  }
  
  public static void setTintMode(@NonNull Drawable paramDrawable, @NonNull PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.setTintMode(paramMode);
      return;
    }
    if ((paramDrawable instanceof TintAwareDrawable)) {
      ((TintAwareDrawable)paramDrawable).setTintMode(paramMode);
    }
  }
  
  public static <T extends Drawable> T unwrap(@NonNull Drawable paramDrawable)
  {
    if ((paramDrawable instanceof WrappedDrawable)) {
      return ((WrappedDrawable)paramDrawable).getWrappedDrawable();
    }
    return paramDrawable;
  }
  
  public static Drawable wrap(@NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramDrawable;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (!(paramDrawable instanceof TintAwareDrawable)) {
        return new WrappedDrawableApi21(paramDrawable);
      }
      return paramDrawable;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (!(paramDrawable instanceof TintAwareDrawable)) {
        return new WrappedDrawableApi19(paramDrawable);
      }
      return paramDrawable;
    }
    if (!(paramDrawable instanceof TintAwareDrawable)) {
      return new WrappedDrawableApi14(paramDrawable);
    }
    return paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat
 * JD-Core Version:    0.7.0.1
 */