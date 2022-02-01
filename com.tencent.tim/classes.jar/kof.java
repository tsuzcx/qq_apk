import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;

class kof
  implements ValueAnimator.AnimatorUpdateListener
{
  kof(kod paramkod, RelativeLayout.LayoutParams paramLayoutParams1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, RelativeLayout.LayoutParams paramLayoutParams2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    kod.a(this.a, this.m, f, this.Lm, this.Lo, this.aKy, this.aKz, this.aKA, this.iO);
    kod.a(this.a, this.n, f, kod.a(this.a));
    kod.a(this.a, kod.a(this.a), f, 0.2F, 1.7F, wja.dp2px(34.0F, kod.a(this.a).getResources()));
    kod.a(this.a, kod.b(this.a), f, 0.2F, 2.0F, wja.dp2px(34.0F, kod.a(this.a).getResources()));
    kod.a(this.a, kod.c(this.a), f, 0.2F, 2.0F, wja.dp2px(34.0F, kod.a(this.a).getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kof
 * JD-Core Version:    0.7.0.1
 */