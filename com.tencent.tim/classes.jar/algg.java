import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.profile.view.PhotoViewForShopping;
import com.tencent.mobileqq.profile.view.VipScaledViewPager;

public class algg
  implements ViewPager.OnPageChangeListener
{
  boolean cwu = false;
  boolean isDragging = false;
  
  public algg(PhotoViewForShopping paramPhotoViewForShopping) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      this.this$0.b.startScroll();
      this.cwu = true;
    }
    if (paramInt == 2) {
      this.isDragging = true;
    }
    if (paramInt == 0)
    {
      if (this.isDragging)
      {
        this.isDragging = false;
        this.this$0.b.stopScroll();
      }
      if (this.cwu)
      {
        this.this$0.b.stopScroll();
        this.cwu = false;
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algg
 * JD-Core Version:    0.7.0.1
 */