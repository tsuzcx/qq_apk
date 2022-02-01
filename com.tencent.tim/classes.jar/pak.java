import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDynamicFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class pak
  implements Observer<pel<List<FeedCloudMeta.StFeed>>>
{
  public pak(QCirclePersonalDynamicFragment paramQCirclePersonalDynamicFragment) {}
  
  public void b(@Nullable pel<List<FeedCloudMeta.StFeed>> parampel)
  {
    QLog.d(QCirclePersonalDynamicFragment.access$000(), 4, "initViewData:getFeedListRequestRsp");
    QCirclePersonalDynamicFragment.a(this.a, parampel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pak
 * JD-Core Version:    0.7.0.1
 */