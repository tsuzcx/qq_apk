import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;

public class ifx
  extends Animation
{
  private int akQ;
  private int akR;
  private int akS;
  private int akT;
  private RelativeLayout.LayoutParams d;
  private View hK;
  
  public ifx(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    setDuration(paramInt1);
    this.hK = paramView;
    this.d = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
    this.akR = paramView.getMeasuredHeight();
    this.akQ = paramView.getMeasuredWidth();
    this.akT = (this.akR + paramInt3);
    this.akS = (this.akQ + paramInt2);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      this.d.height = (this.akR + (int)((this.akT - this.akR) * paramFloat));
      this.d.width = (this.akQ + (int)((this.akS - this.akQ) * paramFloat));
      this.hK.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifx
 * JD-Core Version:    0.7.0.1
 */