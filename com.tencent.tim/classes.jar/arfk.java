import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.mobileqq.widget.DraggableGridView.c;

public class arfk
  implements Animation.AnimationListener
{
  public arfk(DraggableGridView paramDraggableGridView, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DraggableGridView.a(this.c).jO(this.efG, this.val$itemIndex);
    DraggableGridView.a(this.c).notifyDataSetChanged();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfk
 * JD-Core Version:    0.7.0.1
 */