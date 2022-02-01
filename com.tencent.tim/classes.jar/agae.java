import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;

class agae
  implements Animation.AnimationListener
{
  agae(agad paramagad) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.this$0.root.removeView(this.a.CE);
    this.a.this$0.getWindow().setBackgroundDrawable(null);
    Face2FaceAddFriendActivity.a(this.a.this$0);
    this.a.this$0.ccl = true;
    if (agas.Ya >= agas.Yb)
    {
      this.a.this$0.ar(agas.Ya, agas.Yb);
      return;
    }
    this.a.this$0.ar(agas.Ya, 0L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agae
 * JD-Core Version:    0.7.0.1
 */