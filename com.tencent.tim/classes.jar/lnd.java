import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class lnd
  implements Animation.AnimationListener
{
  lnd(lnb paramlnb, View paramView, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.kC != null)
    {
      if (this.RT) {
        lnb.a(this.a, this.kC, this.val$activity, this.d, false);
      }
    }
    else {
      return;
    }
    this.kC.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnd
 * JD-Core Version:    0.7.0.1
 */