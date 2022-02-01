import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;
import qqcircle.QQCircleFeedBase.StFollowPageData;

public class voe
  implements Observer<QQCircleFeedBase.StFollowPageData>
{
  public voe(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void a(@Nullable QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    QCircleFolderFollowTabFragment.a(this.a).a(paramStFollowPageData);
    if (QCircleFolderFollowTabFragment.a(this.a) != null) {
      QCircleFolderFollowTabFragment.a(this.a).a(paramStFollowPageData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voe
 * JD-Core Version:    0.7.0.1
 */