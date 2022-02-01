import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

public class algw
  extends AnimatorListenerAdapter
{
  public algw(ProfileTagView paramProfileTagView, View paramView, PointF paramPointF) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.this$0;
    paramAnimator.dtt -= 1;
    paramAnimator = (RatioLayout.LayoutParams)this.hI.getLayoutParams();
    if (paramAnimator != null)
    {
      if (this.hI.getAnimation() != null) {
        this.hI.clearAnimation();
      }
      if ((paramAnimator.x != this.ac.x) || (paramAnimator.y != this.ac.y))
      {
        paramAnimator.x = this.ac.x;
        paramAnimator.y = this.ac.y;
        this.hI.setLayoutParams(paramAnimator);
        this.hI.setTranslationX(0.0F);
        this.hI.setTranslationY(0.0F);
        if ((this.hI instanceof VipTagView)) {
          ((VipTagView)this.hI).setShakingState(true);
        }
      }
      this.this$0.cwK = false;
      if (this.this$0.dtt == 0) {
        if (!this.this$0.atB())
        {
          paramAnimator = this.this$0.a.d.getLabelList();
          if (paramAnimator != null)
          {
            if ((this.this$0.x[(ProfileTagView.a().length - 1)] == null) || (paramAnimator.size() != 0)) {
              break label260;
            }
            this.this$0.Xu.setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      if (this.this$0.cwO)
      {
        this.this$0.l(this.this$0.a);
        this.this$0.cwO = false;
      }
      return;
      label260:
      this.this$0.Xu.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algw
 * JD-Core Version:    0.7.0.1
 */