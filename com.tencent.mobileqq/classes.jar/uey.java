import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankIndicator;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;

public class uey
  implements ViewPager.OnPageChangeListener
{
  public uey(QCirclePushRankTopView paramQCirclePushRankTopView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QCirclePushRankTopView.a(this.a) != null) {
      QCirclePushRankTopView.a(this.a).a(paramInt);
    }
    QCirclePushRankTopView.a(this.a, paramInt);
    QQCircleDitto.StItemContainer localStItemContainer = (QQCircleDitto.StItemContainer)QCirclePushRankTopView.a(this.a).get(paramInt);
    QCirclePushRankTopView.a(this.a, localStItemContainer);
    if (this.a.a != null) {
      this.a.a.setText(localStItemContainer.subTitle.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uey
 * JD-Core Version:    0.7.0.1
 */