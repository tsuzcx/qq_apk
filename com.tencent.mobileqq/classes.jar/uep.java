import android.animation.ObjectAnimator;
import android.view.View;

public class uep
{
  public static void a(View paramView, uev paramuev)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramView.getHeight(), 0.0F });
    paramView.addListener(paramuev);
    paramView.setDuration(200L);
    paramView.start();
  }
  
  public static void b(View paramView, uev paramuev)
  {
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, paramView.getHeight() });
    paramView.addListener(paramuev);
    paramView.setDuration(200L);
    paramView.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uep
 * JD-Core Version:    0.7.0.1
 */