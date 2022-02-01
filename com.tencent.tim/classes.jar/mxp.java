import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;

class mxp
  extends AnimatorListenerAdapter
{
  mxp(mxm parammxm, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (mxm.a(this.c) != null) {
      mxm.a(this.c).b(mxm.a(this.c));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.apV)
    {
      if (this.apW) {
        break label124;
      }
      mxm.a(this.c).bA.setVisibility(8);
      paramAnimator = new GradientDrawable();
      paramAnimator.setCornerRadius(wja.dp2px(8.0F, mxm.a(this.c).getResources()));
      paramAnimator.setColor(Color.parseColor("#E6FFFFFF"));
      mxm.a(this.c).bz.setBackgroundDrawable(paramAnimator);
      mxm.a(this.c, false, false);
    }
    for (;;)
    {
      if (mxm.a(this.c) != null) {
        mxm.a(this.c).c(mxm.a(this.c));
      }
      return;
      label124:
      mxm.a(this.c).bz.setVisibility(8);
      mxm.a(this.c).F.setVisibility(0);
      mxm.a(this.c, false, true);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    mtg.l locall;
    if (mxm.a(this.c) != null)
    {
      paramAnimator = this.c;
      locall = mxm.a(this.c);
      if (this.apW) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      mxm.a(paramAnimator, locall, bool);
      if (mxm.a(this.c) != null) {
        mxm.a(this.c).a(mxm.a(this.c));
      }
      if (this.apW)
      {
        paramAnimator = "";
        if (mxm.a(this.c) != null) {
          paramAnimator = mxm.a(this.c).ir();
        }
        if (this.c.getStyle() == 0) {
          mxm.a(this.c, mxm.a(this.c).F, paramAnimator, wja.dp2px(5.2F, mxm.a(this.c).getResources()), 75, 1);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxp
 * JD-Core Version:    0.7.0.1
 */