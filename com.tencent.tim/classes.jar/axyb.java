import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Field;

public class axyb
  extends Scroller
{
  private int mScrollDuration = 750;
  
  public axyb(Context paramContext)
  {
    super(paramContext);
  }
  
  public axyb(Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public void c(ViewPager paramViewPager)
  {
    try
    {
      Field localField = ViewPager.class.getDeclaredField("mScroller");
      localField.setAccessible(true);
      localField.set(paramViewPager, this);
      return;
    }
    catch (Exception paramViewPager)
    {
      paramViewPager.printStackTrace();
    }
  }
  
  public void setScrollDuration(int paramInt)
  {
    this.mScrollDuration = paramInt;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mScrollDuration);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mScrollDuration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axyb
 * JD-Core Version:    0.7.0.1
 */