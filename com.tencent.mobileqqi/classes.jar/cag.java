import android.app.Dialog;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public final class cag
  implements Runnable
{
  public cag(Dialog paramDialog) {}
  
  public void run()
  {
    if (this.a.isShowing())
    {
      TextView localTextView = (TextView)this.a.findViewById(2131231132);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.9F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setAnimationListener(new cah(this));
      localTextView.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cag
 * JD-Core Version:    0.7.0.1
 */