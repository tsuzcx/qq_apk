import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.qphone.base.util.QLog;

public class ldk
  implements Animation.AnimationListener
{
  public ldk(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.m(this.this$0.articleInfo);
    QLog.d(ReadInJoyAtlasCommentFragment.access$000(), 1, "fragment show info");
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    QLog.d(ReadInJoyAtlasCommentFragment.access$000(), 1, "fragment Repeat animation");
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.d(ReadInJoyAtlasCommentFragment.access$000(), 1, "fragment start animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldk
 * JD-Core Version:    0.7.0.1
 */