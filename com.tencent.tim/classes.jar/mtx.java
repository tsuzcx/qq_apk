import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class mtx
  implements Animation.AnimationListener
{
  mtx(mtw parammtw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (mtw.a(this.b) != null) {
      mtw.a(this.b).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtx
 * JD-Core Version:    0.7.0.1
 */