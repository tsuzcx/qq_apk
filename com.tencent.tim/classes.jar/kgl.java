import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

public class kgl
  extends auqs.a
{
  public kgl(ReadInJoyNaviController.1 param1, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new TranslateAnimation(0.0F, 0.0F, this.a.this$0.aIH, 0.0F);
    paramAnimation.setDuration(30L);
    paramAnimation.setAnimationListener(new kgm(this));
    this.jA.startAnimation(paramAnimation);
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    kgk.a(this.a.this$0).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgl
 * JD-Core Version:    0.7.0.1
 */