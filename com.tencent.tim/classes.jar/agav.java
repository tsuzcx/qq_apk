import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;

public class agav
  implements Animation.AnimationListener
{
  public agav(Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Face2FaceFriendBubbleView.a(this.c).setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (Face2FaceFriendBubbleView.a(this.c) == 1)
    {
      Face2FaceFriendBubbleView.a(this.c).setVisibility(8);
      Face2FaceFriendBubbleView.a(this.c).setVisibility(8);
    }
    for (;;)
    {
      Face2FaceFriendBubbleView.a(this.c).setVisibility(4);
      return;
      if (Face2FaceFriendBubbleView.a(this.c) == 2)
      {
        Face2FaceFriendBubbleView.a(this.c).setImageResource(2130840376);
        Face2FaceFriendBubbleView.a(this.c).setVisibility(0);
        Face2FaceFriendBubbleView.a(this.c).setVisibility(8);
      }
      else if (Face2FaceFriendBubbleView.a(this.c) == 3)
      {
        Face2FaceFriendBubbleView.a(this.c).setImageResource(2130840377);
        Face2FaceFriendBubbleView.a(this.c).setVisibility(0);
        Face2FaceFriendBubbleView.a(this.c).setVisibility(8);
      }
      else if (Face2FaceFriendBubbleView.a(this.c) == 4)
      {
        Face2FaceFriendBubbleView.a(this.c).setImageResource(2130840378);
        Face2FaceFriendBubbleView.a(this.c).setVisibility(0);
        Face2FaceFriendBubbleView.a(this.c).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agav
 * JD-Core Version:    0.7.0.1
 */