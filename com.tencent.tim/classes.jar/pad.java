import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;
import qqcircle.QQCircleFeedBase.StFollowPageData;

public class pad
  implements Observer<QQCircleFeedBase.StFollowPageData>
{
  public pad(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void e(@Nullable QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    QCircleFolderFollowTabFragment.a(this.a).d(paramStFollowPageData);
    if (QCircleFolderFollowTabFragment.a(this.a) != null) {
      QCircleFolderFollowTabFragment.a(this.a).a(paramStFollowPageData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pad
 * JD-Core Version:    0.7.0.1
 */