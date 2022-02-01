import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

@TargetApi(14)
public class rfr
{
  public static float getX(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return 0.0F;
    }
    return paramView.getX();
  }
  
  public static float getY(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return 0.0F;
    }
    return paramView.getY();
  }
  
  public static void setAlpha(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setAlpha(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfr
 * JD-Core Version:    0.7.0.1
 */