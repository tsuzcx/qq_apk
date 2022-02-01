import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class xpe
  implements Animation.AnimationListener
{
  xpe(xpc paramxpc, xpc.a parama, CharSequence paramCharSequence) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.mText.setText(this.L);
    this.b.mText.startAnimation(this.a.l);
    this.b.mContentLayout.requestLayout();
    this.b.bVR = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.b.mContentLayout.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.b.mContentLayout.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.b.bVR = 0;
    this.b.mText.startAnimation(this.a.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpe
 * JD-Core Version:    0.7.0.1
 */