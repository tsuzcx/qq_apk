import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;

class tya
  implements uaw
{
  tya(txz paramtxz) {}
  
  public void a()
  {
    if (txz.a(this.a) != null) {
      txz.a(this.a).a(0, 100);
    }
    if (txz.a(this.a) != null) {
      txz.a(this.a).animate().alpha(0.0F).setDuration(100L);
    }
    txz.a(this.a, 1, 0, 100);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    int i;
    if (this.a.a() != null)
    {
      tra.a(this.a.a(), 0);
      this.a.a().finish();
      if (Math.abs(paramFloat1) > Math.abs(paramFloat2)) {
        break label71;
      }
      if (paramFloat2 <= 0.0F) {
        break label65;
      }
      i = 2130772329;
    }
    for (;;)
    {
      this.a.a().overridePendingTransition(0, i);
      return;
      label65:
      i = 2130772333;
      continue;
      label71:
      if (paramFloat1 > 0.0F) {
        i = 2130772311;
      } else {
        i = 2130772312;
      }
    }
  }
  
  public void b()
  {
    if (txz.a(this.a) != null) {
      txz.a(this.a).a(1, 100);
    }
    if (txz.a(this.a) != null) {
      txz.a(this.a).animate().alpha(1.0F).setDuration(100L);
    }
    txz.a(this.a, 0, 1, 100);
    if (txz.a(this.a) != null) {
      txz.a(this.a).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tya
 * JD-Core Version:    0.7.0.1
 */