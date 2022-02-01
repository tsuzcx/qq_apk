import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.34.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class neb
  implements Animation.AnimationListener
{
  neb(ndi paramndi, BaseArticleInfo paramBaseArticleInfo, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      ThreadManager.getUIHandler().post(new ReadInJoyBaseAdapter.34.1(this));
      return;
    }
    catch (Exception paramAnimation)
    {
      paramAnimation.printStackTrace();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     neb
 * JD-Core Version:    0.7.0.1
 */