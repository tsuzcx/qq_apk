import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

public class nri
  extends AnimatorListenerAdapter
{
  public nri(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.a(this.b, false);
    ReadInJoyDynamicGridView.a(this.b);
    ReadInJoyDynamicGridView.a(this.b, this.hz);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.a(this.b, true);
    ReadInJoyDynamicGridView.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nri
 * JD-Core Version:    0.7.0.1
 */