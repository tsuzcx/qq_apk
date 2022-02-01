package androidx.core.view;

import android.os.Build.VERSION;
import android.view.ScaleGestureDetector;

public final class ScaleGestureDetectorCompat
{
  public static boolean isQuickScaleEnabled(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramScaleGestureDetector.isQuickScaleEnabled();
    }
    return false;
  }
  
  @Deprecated
  public static boolean isQuickScaleEnabled(Object paramObject)
  {
    return isQuickScaleEnabled((ScaleGestureDetector)paramObject);
  }
  
  public static void setQuickScaleEnabled(ScaleGestureDetector paramScaleGestureDetector, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramScaleGestureDetector.setQuickScaleEnabled(paramBoolean);
    }
  }
  
  @Deprecated
  public static void setQuickScaleEnabled(Object paramObject, boolean paramBoolean)
  {
    setQuickScaleEnabled((ScaleGestureDetector)paramObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.view.ScaleGestureDetectorCompat
 * JD-Core Version:    0.7.0.1
 */