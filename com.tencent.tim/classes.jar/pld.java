import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

class pld
  implements Animation.AnimationListener
{
  pld(plc paramplc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.mCenterLayout.setVisibility(8);
    this.a.eY.setVisibility(8);
    this.a.kD.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pld
 * JD-Core Version:    0.7.0.1
 */