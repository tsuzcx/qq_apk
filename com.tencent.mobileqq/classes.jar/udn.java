import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresent;

public class udn
  implements ViewPager.OnPageChangeListener
{
  public udn(QCircleFeedItemPicPresent paramQCircleFeedItemPicPresent) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QCircleFeedItemPicPresent.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     udn
 * JD-Core Version:    0.7.0.1
 */