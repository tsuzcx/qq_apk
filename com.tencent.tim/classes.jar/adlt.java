import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class adlt
  implements Animatable
{
  private boolean bPz;
  private int cII;
  private int cIJ;
  private Animator.AnimatorListener d;
  private ValueAnimator.AnimatorUpdateListener f;
  private final int[] kz;
  private ValueAnimator mAnimator;
  private ImageView mImageView;
  
  public adlt(int paramInt1, int[] paramArrayOfInt, ImageView paramImageView, int paramInt2)
  {
    this.kz = paramArrayOfInt;
    this.mImageView = paramImageView;
    if (paramArrayOfInt.length <= 0) {
      throw new RuntimeException(" FrameAnimDrawable RES_IDS can not empty !!!");
    }
    this.mImageView.setImageResource(paramArrayOfInt[paramInt2]);
    this.cII = paramInt2;
    this.cIJ = paramInt2;
    cTn();
  }
  
  public adlt(int[] paramArrayOfInt, ImageView paramImageView, int paramInt)
  {
    this(0, paramArrayOfInt, paramImageView, paramInt);
  }
  
  private void b(Animator.AnimatorListener paramAnimatorListener)
  {
    this.mAnimator.addUpdateListener(this.f);
    if (paramAnimatorListener != null) {
      this.mAnimator.addListener(paramAnimatorListener);
    }
    this.mAnimator.start();
  }
  
  private void cTn()
  {
    this.mAnimator = ValueAnimator.ofInt(new int[] { this.kz.length - 1 });
    this.mAnimator.setInterpolator(new LinearInterpolator());
    this.mAnimator.setDuration(400L);
    this.f = new adlu(this);
    this.d = new adlv(this);
  }
  
  public void Lm(int paramInt)
  {
    this.cII = paramInt;
    if (this.bPz) {
      paramInt %= this.kz.length;
    }
    for (;;)
    {
      this.mImageView.setImageResource(this.kz[paramInt]);
      return;
      paramInt = this.kz.length - paramInt % this.kz.length - 1;
    }
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.mAnimator.isStarted()) {
      return;
    }
    b(paramAnimatorListener);
  }
  
  public void b(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    stop();
    this.bPz = paramBoolean;
    if (paramBoolean) {}
    for (this.cIJ = (this.kz.length - 1);; this.cIJ = 0)
    {
      a(paramAnimatorListener);
      return;
    }
  }
  
  public boolean isRunning()
  {
    return this.mAnimator.isRunning();
  }
  
  public void start()
  {
    b(null);
  }
  
  public void stop()
  {
    if ((this.mAnimator != null) && (this.mAnimator.isStarted())) {
      this.mAnimator.end();
    }
    if (this.mAnimator != null)
    {
      this.mAnimator.removeAllUpdateListeners();
      this.mAnimator.removeAllListeners();
    }
    this.cII = this.cIJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adlt
 * JD-Core Version:    0.7.0.1
 */