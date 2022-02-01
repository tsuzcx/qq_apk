import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.g;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;

public class ajix
  implements MultiAIOBaseViewPager.g
{
  public ajix(MultiAIOViewPager paramMultiAIOViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (MultiAIOViewPager.a(this.b) != null) {
      MultiAIOViewPager.a(this.b).zD(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajix
 * JD-Core Version:    0.7.0.1
 */