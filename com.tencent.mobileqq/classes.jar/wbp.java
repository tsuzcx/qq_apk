import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankIndicator;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import java.util.List;
import mqq.util.WeakReference;
import qqcircle.QQCircleDitto.StItemContainer;

public class wbp
  implements ViewPager.OnPageChangeListener
{
  private WeakReference<QCirclePushRankTopView> a;
  
  public wbp(QCirclePushRankTopView paramQCirclePushRankTopView)
  {
    this.a = new WeakReference(paramQCirclePushRankTopView);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.a != null)
    {
      QCirclePushRankTopView localQCirclePushRankTopView = (QCirclePushRankTopView)this.a.get();
      if (localQCirclePushRankTopView != null)
      {
        paramInt %= QCirclePushRankTopView.a(localQCirclePushRankTopView).a().size();
        if (QCirclePushRankTopView.a(localQCirclePushRankTopView) != null) {
          QCirclePushRankTopView.a(localQCirclePushRankTopView).a(paramInt);
        }
        QCirclePushRankTopView.a(localQCirclePushRankTopView, paramInt);
        QCirclePushRankTopView.a(localQCirclePushRankTopView, (QQCircleDitto.StItemContainer)QCirclePushRankTopView.a(localQCirclePushRankTopView).get(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbp
 * JD-Core Version:    0.7.0.1
 */