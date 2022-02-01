import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.mobileqq.ocr.view.ScanOcrView;
import com.tencent.mobileqq.ocr.view.ScanOcrView.a;

public class akow
  implements ValueAnimator.AnimatorUpdateListener
{
  public akow(ScanOcrView paramScanOcrView, ScanOcrView.a parama) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int j = (int)(this.d.dos * f);
    int i = (int)(f * this.d.dot);
    int m = j - this.d.dos;
    int k = i - this.d.dot;
    j = (int)(paramValueAnimator.getAnimatedFraction() * 255.0F);
    i = j;
    if (j > 255) {
      i = 255;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    i = this.d.ck.left;
    int n = m / 2;
    int i1 = this.d.ck.top;
    int i2 = k / 2;
    int i3 = this.d.ck.right;
    m /= 2;
    int i4 = this.d.ck.bottom;
    k /= 2;
    this.d.dow = j;
    this.d.cl.set(i - n, i1 - i2, m + i3, k + i4);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akow
 * JD-Core Version:    0.7.0.1
 */