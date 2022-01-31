import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDynamicFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class twn
  implements Observer<tzm<List<FeedCloudMeta.StFeed>>>
{
  public twn(QCirclePersonalDynamicFragment paramQCirclePersonalDynamicFragment) {}
  
  public void a(@Nullable tzm<List<FeedCloudMeta.StFeed>> paramtzm)
  {
    QLog.d(QCirclePersonalDynamicFragment.a(), 4, "initViewData:getFeedListRequestRsp");
    QCirclePersonalDynamicFragment.a(this.a, paramtzm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twn
 * JD-Core Version:    0.7.0.1
 */