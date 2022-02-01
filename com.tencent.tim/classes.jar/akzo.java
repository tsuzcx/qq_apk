import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.StrokeTextView;

public class akzo
  extends auqs.a
{
  public akzo(FormalView paramFormalView, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.dEu();
    this.this$0.cvu = true;
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.val$view.setVisibility(0);
    if (FormalView.a(this.this$0) != null) {
      FormalView.a(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzo
 * JD-Core Version:    0.7.0.1
 */