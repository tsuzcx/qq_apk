import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.e;

class g
  implements ValueAnimator.AnimatorUpdateListener
{
  g(f paramf) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= this.a.M[0])
    {
      this.a.a.cancel();
      this.a.frameIndex = 0;
      this.a.mFont.mShouldDisplayAnimation = false;
      f.a(this.a).invalidate();
      if (f.a(this.a).mAnimationListener != null) {
        f.a(this.a).mAnimationListener.a(f.a(this.a).mMessage, this.a.mFont.mFontId);
      }
    }
    while (i <= this.a.frameIndex) {
      return;
    }
    this.a.frameIndex = i;
    f.a(this.a).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     g
 * JD-Core Version:    0.7.0.1
 */