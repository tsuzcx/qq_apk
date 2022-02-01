import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankIndicator;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;

public class vxu
  implements ViewPager.OnPageChangeListener
{
  public vxu(QCirclePushRankTopView paramQCirclePushRankTopView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    paramInt %= QCirclePushRankTopView.a(this.a).a().size();
    if (QCirclePushRankTopView.a(this.a) != null) {
      QCirclePushRankTopView.a(this.a).a(paramInt);
    }
    QCirclePushRankTopView.a(this.a, paramInt);
    QQCircleDitto.StItemContainer localStItemContainer = (QQCircleDitto.StItemContainer)QCirclePushRankTopView.a(this.a).get(paramInt);
    QCirclePushRankTopView.a(this.a, localStItemContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxu
 * JD-Core Version:    0.7.0.1
 */