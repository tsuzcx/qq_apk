import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper.4.1.1;
import java.util.ArrayList;

public class myv
  implements Animation.AnimationListener
{
  myv(myu parammyu, ArrayList paramArrayList) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    myq.a(this.a.a).post(new VideoShareHelper.4.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myv
 * JD-Core Version:    0.7.0.1
 */