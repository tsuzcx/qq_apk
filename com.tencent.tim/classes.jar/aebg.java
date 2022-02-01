import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class aebg
{
  private AnimatorSet al;
  private View mContentView;
  private float mPivotX;
  private float mPivotY;
  
  public aebg(View paramView)
  {
    this.mContentView = paramView;
    this.al = new AnimatorSet();
  }
  
  private void cVG()
  {
    this.mContentView.setPivotX(this.mPivotX);
    this.mContentView.setPivotY(this.mPivotY);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mContentView, "scaleX", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mContentView, "scaleY", new float[] { 1.0F, 0.0F });
    if (this.al != null)
    {
      this.al.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      this.al.setDuration(500L);
    }
  }
  
  public void a(aeei paramaeei, boolean paramBoolean, int paramInt)
  {
    if (this.al != null)
    {
      Animator localAnimator = rtr.createCircularReveal(this.mContentView, (int)this.mPivotX + paramInt, (int)this.mPivotY, this.mContentView.getHeight() / 2, 1.0F);
      localAnimator.addListener(new aebh(this, paramaeei, paramBoolean));
      localAnimator.setDuration(300L);
      localAnimator.start();
    }
  }
  
  public void pm()
  {
    cVG();
  }
  
  public void setPivot(float paramFloat1, float paramFloat2)
  {
    this.mPivotX = paramFloat1;
    this.mPivotY = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebg
 * JD-Core Version:    0.7.0.1
 */