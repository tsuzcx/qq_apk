import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;

class yji
  implements Animation.AnimationListener
{
  yji(yjh paramyjh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      if ((this.this$0.av != null) && (this.this$0.cV != null) && (paramAnimation == this.this$0.au))
      {
        paramAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130772331);
        paramAnimation.setInterpolator(new LinearInterpolator());
        this.this$0.uj = ((ImageView)this.this$0.cV.findViewById(2131367349));
        this.this$0.uk = ((ImageView)this.this$0.cV.findViewById(2131367350));
        this.this$0.cV.clearAnimation();
        this.this$0.cV.startAnimation(this.this$0.av);
        this.this$0.uj.startAnimation(paramAnimation);
        this.this$0.uk.startAnimation(paramAnimation);
        return;
      }
      if ((paramAnimation == this.this$0.aw) && (this.this$0.jdField_if != null) && (this.this$0.cV != null) && (this.this$0.jdField_if.indexOfChild(this.this$0.cV) != -1))
      {
        this.this$0.jdField_if.removeView(this.this$0.cV);
        return;
      }
    }
    catch (Throwable paramAnimation) {}
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yji
 * JD-Core Version:    0.7.0.1
 */