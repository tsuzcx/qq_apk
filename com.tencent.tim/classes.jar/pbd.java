import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout.a;

class pbd
  implements QCircleTransitionLayout.a
{
  pbd(pbc parampbc) {}
  
  public void C(float paramFloat1, float paramFloat2)
  {
    int i;
    if (this.this$0.getActivity() != null)
    {
      ovd.k(this.this$0.getActivity(), 0);
      this.this$0.getActivity().finish();
      if (Math.abs(paramFloat1) > Math.abs(paramFloat2)) {
        break label71;
      }
      if (paramFloat2 <= 0.0F) {
        break label65;
      }
      i = 2130772414;
    }
    for (;;)
    {
      this.this$0.getActivity().overridePendingTransition(0, i);
      return;
      label65:
      i = 2130772425;
      continue;
      label71:
      if (paramFloat1 > 0.0F) {
        i = 2130772385;
      } else {
        i = 2130772386;
      }
    }
  }
  
  public void bjm()
  {
    if (pbc.a(this.this$0) != null) {
      pbc.a(this.this$0).dI(0, 100);
    }
    if (pbc.a(this.this$0) != null) {
      pbc.a(this.this$0).animate().alpha(0.0F).setDuration(100L);
    }
    pbc.a(this.this$0, 1, 0, 100);
  }
  
  public void bjn()
  {
    if (pbc.a(this.this$0) != null) {
      pbc.a(this.this$0).dI(1, 100);
    }
    if (pbc.a(this.this$0) != null) {
      pbc.a(this.this$0).animate().alpha(1.0F).setDuration(100L);
    }
    pbc.a(this.this$0, 0, 1, 100);
    if (pbc.a(this.this$0) != null) {
      pbc.a(this.this$0).rr(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbd
 * JD-Core Version:    0.7.0.1
 */