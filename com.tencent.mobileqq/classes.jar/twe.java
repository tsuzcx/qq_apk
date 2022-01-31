import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;
import qqcircle.QQCircleFeedBase.StFollowPageData;

public class twe
  implements Observer<QQCircleFeedBase.StFollowPageData>
{
  public twe(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void a(@Nullable QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    QCircleFolderFollowTabFragment.a(this.a).a(paramStFollowPageData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twe
 * JD-Core Version:    0.7.0.1
 */