import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.emoticonview.EmoticonGuideBubbleView;
import com.tencent.qphone.base.util.QLog;

public class afmg
  implements Animation.AnimationListener
{
  public afmg(EmoticonGuideBubbleView paramEmoticonGuideBubbleView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonGuideBubbleView", 2, "removeFastImage fadeoutanimation ended");
    }
    this.b.removeAllViews();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmg
 * JD-Core Version:    0.7.0.1
 */