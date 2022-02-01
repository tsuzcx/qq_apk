import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

public class nru
  extends AnimatorListenerAdapter
{
  public nru(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyNinePicDeliverDynamicGridView.a(this.b, false);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.b);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.b, this.hz);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyNinePicDeliverDynamicGridView.a(this.b, true);
    ReadInJoyNinePicDeliverDynamicGridView.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nru
 * JD-Core Version:    0.7.0.1
 */