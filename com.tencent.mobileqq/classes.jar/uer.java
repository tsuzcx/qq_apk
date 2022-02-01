import android.animation.ObjectAnimator;
import android.view.View;

public class uer
{
  public static void a(View paramView, uex paramuex)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramView.getHeight(), 0.0F });
    paramView.addListener(paramuex);
    paramView.setDuration(200L);
    paramView.start();
  }
  
  public static void b(View paramView, uex paramuex)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, paramView.getHeight() });
    paramView.addListener(paramuex);
    paramView.setDuration(200L);
    paramView.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uer
 * JD-Core Version:    0.7.0.1
 */