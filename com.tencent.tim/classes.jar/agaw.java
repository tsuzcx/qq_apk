import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;

public class agaw
  implements Animation.AnimationListener
{
  public agaw(Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((Face2FaceFriendBubbleView.a(this.c) == 2) || (Face2FaceFriendBubbleView.a(this.c) == 3) || (Face2FaceFriendBubbleView.a(this.c) == 4))
    {
      Face2FaceFriendBubbleView.a(this.c).startAnimation(Face2FaceFriendBubbleView.a(this.c));
      return;
    }
    Face2FaceFriendBubbleView.a(this.c).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agaw
 * JD-Core Version:    0.7.0.1
 */