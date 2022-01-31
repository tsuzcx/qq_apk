import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;
import qqcircle.QQCircleFeedBase.StFollowPageData;

public class twv
  implements Observer<QQCircleFeedBase.StFollowPageData>
{
  public twv(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void a(@Nullable QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    QCircleFolderFollowTabFragment.a(this.a).a(paramStFollowPageData);
    if (QCircleFolderFollowTabFragment.a(this.a) != null) {
      QCircleFolderFollowTabFragment.a(this.a).a(paramStFollowPageData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twv
 * JD-Core Version:    0.7.0.1
 */