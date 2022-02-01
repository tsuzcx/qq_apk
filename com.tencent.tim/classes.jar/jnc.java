import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.widget.QQMapView;

public class jnc
  implements Animation.AnimationListener
{
  public jnc(PoiMapActivity paramPoiMapActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, int paramInt, TranslateAnimation paramTranslateAnimation2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.this$0.mRootView.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)PoiMapActivity.a(this.this$0).getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = PoiMapActivity.a(this.this$0).getLayoutParams();
    if (paramAnimation == this.q)
    {
      this.n.show();
      localLayoutParams.height = (this.this$0.mRootView.getHeight() + this.dS);
      this.this$0.P(this.dS / 2, true);
    }
    for (;;)
    {
      localLayoutParams1.height = -1;
      localLayoutParams2.height = -1;
      PoiMapActivity.b(this.this$0).setLayoutParams(localLayoutParams2);
      PoiMapActivity.b(this.this$0).setLayoutParams(localLayoutParams1);
      this.this$0.mRootView.setLayoutParams(localLayoutParams);
      PoiMapActivity.c(this.this$0).setEnabled(true);
      if ((this.this$0.aaH) && (paramAnimation == this.c)) {
        this.this$0.ays();
      }
      return;
      if (paramAnimation == this.c)
      {
        localLayoutParams.height = (this.this$0.mRootView.getHeight() - this.dS);
        this.this$0.P(-this.dS / 2, true);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jnc
 * JD-Core Version:    0.7.0.1
 */