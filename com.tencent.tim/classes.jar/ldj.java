import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;

public class ldj
  implements Animation.AnimationListener
{
  public ldj(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.getView().setVisibility(8);
    this.this$0.getActivity().setResult(-1);
    this.this$0.getActivity().finish();
    this.this$0.getActivity().overridePendingTransition(0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldj
 * JD-Core Version:    0.7.0.1
 */