import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;

public class uab
{
  public static GradientDrawable a(View paramView, float paramFloat, @ColorInt int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(paramFloat);
    localGradientDrawable.setColor(paramInt);
    if (paramView != null) {
      a(paramView, localGradientDrawable);
    }
    return localGradientDrawable;
  }
  
  public static GradientDrawable a(View paramView, float paramFloat, @ColorInt int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    if (paramFloat > 0.0F) {
      localGradientDrawable.setCornerRadius(paramFloat);
    }
    localGradientDrawable.setStroke(paramInt2, paramInt1);
    if (paramView != null) {
      a(paramView, localGradientDrawable);
    }
    return localGradientDrawable;
  }
  
  public static StateListDrawable a(View paramView, @NonNull Drawable paramDrawable1, @NonNull Drawable paramDrawable2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842910 }, paramDrawable1);
    localStateListDrawable.addState(new int[0], paramDrawable2);
    if (paramView != null) {
      a(paramView, localStateListDrawable);
    }
    return localStateListDrawable;
  }
  
  public static void a(@NonNull View paramView, @NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramDrawable);
      return;
    }
    paramView.setBackground(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uab
 * JD-Core Version:    0.7.0.1
 */