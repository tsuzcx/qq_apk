import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

class mxo
  implements ValueAnimator.AnimatorUpdateListener
{
  mxo(mxm parammxm, LinearLayout.LayoutParams paramLayoutParams, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.bottomMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (!this.apV)
    {
      if (!this.apW) {
        break label63;
      }
      mxm.a(this.c).bA.setVisibility(0);
    }
    for (;;)
    {
      mxm.a(this.c).by.setLayoutParams(this.a);
      return;
      label63:
      mxm.a(this.c).bz.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxo
 * JD-Core Version:    0.7.0.1
 */