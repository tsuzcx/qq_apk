import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;

class mtr
  implements Animation.AnimationListener
{
  mtr(mtg.h paramh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((mtg.a(this.a.this$0) == mtg.h.a(this.a)) && (mtg.a(this.a.this$0) != null)) {
      mtg.a(this.a.this$0).f(mtg.h.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if ((mtg.h.a(this.a).a != null) && (mtg.h.a(this.a).a.d != null))
    {
      boolean bool = mtg.h.a(this.a).a.d.adM;
      if (mtg.h.a(this.a).jW != null) {
        mtg.h.a(this.a).jW.setImageDrawable(mtg.a(this.a.this$0, this.a.m(bool)));
      }
    }
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtr
 * JD-Core Version:    0.7.0.1
 */