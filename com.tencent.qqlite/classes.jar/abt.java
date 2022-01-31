import android.app.Dialog;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public final class abt
  implements Runnable
{
  public abt(Dialog paramDialog) {}
  
  public void run()
  {
    if (this.a.isShowing())
    {
      TextView localTextView = (TextView)this.a.findViewById(2131296580);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.9F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setAnimationListener(new abu(this));
      localTextView.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     abt
 * JD-Core Version:    0.7.0.1
 */