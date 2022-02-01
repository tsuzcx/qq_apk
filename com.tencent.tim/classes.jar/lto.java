import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.SideBarView;

public class lto
  implements ValueAnimator.AnimatorUpdateListener
{
  public lto(ProteusRecycleView paramProteusRecycleView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setPadding(0, 0, (int)ProteusRecycleView.a(this.a).t(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lto
 * JD-Core Version:    0.7.0.1
 */