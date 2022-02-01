import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleFeedPicPositionEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

public class vzz
  implements ViewPager.OnPageChangeListener
{
  public vzz(QCircleFeedItemPicPresenter paramQCircleFeedItemPicPresenter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QCircleFeedItemPicPresenter.a(this.a, paramInt);
    Object localObject;
    if ((this.a.a() != null) && (this.a.a() != null))
    {
      localObject = new QCircleFeedPicPositionEvent(this.a.a().id.get(), paramInt);
      ((QCircleFeedPicPositionEvent)localObject).mHashCode = this.a.a().getContext().hashCode();
      zwp.a().a((SimpleBaseEvent)localObject);
    }
    QCircleFeedItemPicPresenter.b(this.a, paramInt);
    if (QCircleFeedItemPicPresenter.a(this.a) != null)
    {
      localObject = QCircleFeedItemPicPresenter.a(this.a);
      if (paramInt != 0) {
        break label112;
      }
    }
    label112:
    for (boolean bool = true;; bool = false)
    {
      ((QCircleBaseFragment)localObject).b(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzz
 * JD-Core Version:    0.7.0.1
 */