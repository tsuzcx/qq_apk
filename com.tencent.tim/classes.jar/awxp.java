import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class awxp
  implements Animation.AnimationListener
{
  awxp(awxg paramawxg, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    awxg.a(this.this$0, false);
    awxg.b(this.this$0).setVisibility(8);
    awxg.a(this.this$0).setVisibility(8);
    if ((this.dtw) && (!awxg.a(this.this$0).get())) {
      awxg.a(this.this$0, this.eDM, this.bvB);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    awxg.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awxp
 * JD-Core Version:    0.7.0.1
 */