import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.mobileqq.ocr.view.ScanOcrView;
import com.tencent.mobileqq.ocr.view.ScanOcrView.a;

public class akot
  implements ValueAnimator.AnimatorUpdateListener
{
  public akot(ScanOcrView paramScanOcrView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int j = (int)(this.b.a.dos * f);
    int i = (int)(f * this.b.a.dot);
    int m = j - this.b.a.dos;
    int k = i - this.b.a.dot;
    j = (int)(paramValueAnimator.getAnimatedFraction() * 255.0F);
    i = j;
    if (j > 255) {
      i = 255;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    i = this.b.a.ck.left;
    int n = m / 2;
    int i1 = this.b.a.ck.top;
    int i2 = k / 2;
    int i3 = this.b.a.ck.right;
    m /= 2;
    int i4 = this.b.a.ck.bottom;
    k /= 2;
    this.b.a.dow = j;
    this.b.a.cl.set(i - n, i1 - i2, m + i3, k + i4);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akot
 * JD-Core Version:    0.7.0.1
 */