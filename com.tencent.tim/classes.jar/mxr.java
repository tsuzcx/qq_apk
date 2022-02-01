import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

class mxr
  extends AnimatorListenerAdapter
{
  mxr(mxm parammxm) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (mxm.a(this.c).by != null) {
      mxm.a(this.c).by.setTag(2131362727, null);
    }
    if (mxm.a(this.c) != null) {
      mxm.a(this.c).b(mxm.a(this.c));
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (mxm.a(this.c) != null)
    {
      paramAnimator = mxm.a(this.c).ir();
      mxm.a(this.c, mxm.a(this.c).D, paramAnimator, mxm.a(this.c), 18, -1);
    }
    if (mxm.a(this.c).by != null) {
      mxm.a(this.c).by.setTag(2131362727, null);
    }
    if (mxm.a(this.c) != null) {
      mxm.a(this.c).c(mxm.a(this.c));
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (mxm.a(this.c) != null) {
      mxm.a(this.c).a(mxm.a(this.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxr
 * JD-Core Version:    0.7.0.1
 */