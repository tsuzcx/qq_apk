import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.h;

public class ajje
  implements MultiAIOBaseViewPager.h
{
  private static float MAX_SCALE = 1.0F;
  public static float MIN_SCALE = 0.85F;
  private static float eN = 0.75F;
  private float mMinScale = 3.4028235E+38F;
  private float xn = 3.4028235E+38F;
  
  public void transformPage(@NonNull View paramView, float paramFloat)
  {
    paramView.getWidth();
    paramView.getHeight();
    Object localObject1 = (MultiAIOBaseViewPager)paramView.getParent();
    int i = ((MultiAIOBaseViewPager)localObject1).getMeasuredWidth() - ((MultiAIOBaseViewPager)localObject1).getPaddingLeft() - ((MultiAIOBaseViewPager)localObject1).getPaddingRight();
    float f1 = ((MultiAIOBaseViewPager)localObject1).getPaddingLeft() / i;
    float f2 = (((MultiAIOBaseViewPager)localObject1).getPaddingLeft() - i - ((MultiAIOBaseViewPager)localObject1).getPageMargin()) / i;
    int j = ((MultiAIOBaseViewPager)localObject1).getPaddingLeft();
    float f3 = (((MultiAIOBaseViewPager)localObject1).getPageMargin() + (j + i)) / i;
    if (paramFloat < f2)
    {
      paramFloat = this.mMinScale;
      f1 = this.xn;
    }
    for (;;)
    {
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
      Object localObject2 = paramView.getTag(2131372080);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = paramView.findViewById(2131372080);
        paramView.setTag(2131372080, localObject1);
      }
      paramView = (View)localObject1;
      paramView.setAlpha(1.0F - f1);
      paramView.setBackgroundColor(-16777216);
      return;
      if (paramFloat <= f3)
      {
        f1 = Math.abs(paramFloat - f1);
        paramFloat = (float)(MIN_SCALE + Math.cos(f1 * 1.570796326794897D) * (MAX_SCALE - MIN_SCALE));
        this.mMinScale = Math.min(paramFloat, this.mMinScale);
        f1 = (float)(eN + Math.cos(f1 * 1.570796326794897D) * (1.0F - eN));
        this.xn = Math.min(f1, this.xn);
      }
      else
      {
        paramFloat = this.mMinScale;
        f1 = this.xn;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajje
 * JD-Core Version:    0.7.0.1
 */