import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;

class aipg
  implements ValueAnimator.AnimatorUpdateListener
{
  aipg(aipd paramaipd, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!this.this$0.clg)
    {
      paramValueAnimator.cancel();
      this.this$0.as = null;
      return;
    }
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.deC + (this.deD - this.deC) * f1 + 0.5F);
    int j = (int)(this.deE + (this.deF - this.deE) * f1 + 0.5F);
    int k = (int)(this.deG + (this.deH - this.deG) * f1 + 0.5F);
    float f2 = this.deI;
    int m = (int)(f1 * (this.deJ - this.deI) + f2 + 0.5F);
    this.this$0.b.iv(i, j);
    this.this$0.a.iv(k, m);
    this.this$0.b.dtk();
    this.this$0.a.dtk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aipg
 * JD-Core Version:    0.7.0.1
 */