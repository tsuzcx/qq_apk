import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;

public class tpd
  extends AnimatorListenerAdapter
{
  public tpd(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.b(this.a, false);
    ReadInJoyDynamicGridView.a(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.b(this.a, true);
    ReadInJoyDynamicGridView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tpd
 * JD-Core Version:    0.7.0.1
 */