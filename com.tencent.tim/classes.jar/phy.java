import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter;

public class phy
  implements ViewPager.OnPageChangeListener
{
  public phy(QCircleFeedItemPicPresenter paramQCircleFeedItemPicPresenter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QCircleFeedItemPicPresenter.a(this.b, paramInt);
    QCircleFeedItemPicPresenter.b(this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phy
 * JD-Core Version:    0.7.0.1
 */