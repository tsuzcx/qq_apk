import android.view.View;
import android.view.animation.AlphaAnimation;

public class arko
{
  public static void iH(View paramView)
  {
    if (paramView.isEnabled())
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.5F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setFillAfter(true);
      paramView.startAnimation(localAlphaAnimation);
    }
  }
  
  public static void iI(View paramView)
  {
    if (paramView.isEnabled())
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setFillAfter(true);
      paramView.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arko
 * JD-Core Version:    0.7.0.1
 */