import android.app.Activity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAnimationUtils.3;
import com.tencent.qphone.base.util.QLog;

public class nms
  implements Animation.AnimationListener
{
  public nms(FastWebAnimationUtils.3 param3) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QLog.d("FastWebAnimationUtils", 1, "setAnimation onAnimationEnd");
    paramAnimation = (AlphaAnimation)AnimationUtils.loadAnimation(this.a.val$activity.getApplicationContext(), 2130772255);
    this.a.ty.setVisibility(8);
    this.a.kO.setVisibility(0);
    this.a.kO.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    QLog.d("FastWebAnimationUtils", 1, "setAnimation onAnimationRepeat");
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.d("FastWebAnimationUtils", 1, "setAnimation onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nms
 * JD-Core Version:    0.7.0.1
 */