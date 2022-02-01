import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

@TargetApi(14)
public class zar
{
  public static float a(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return 0.0F;
    }
    return paramView.getX();
  }
  
  public static void a(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setAlpha(paramFloat);
  }
  
  public static float b(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return 0.0F;
    }
    return paramView.getY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zar
 * JD-Core Version:    0.7.0.1
 */