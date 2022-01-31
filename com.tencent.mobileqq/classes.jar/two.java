import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalPushFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class two
  implements Observer<tzm<List<FeedCloudMeta.StFeed>>>
{
  public two(QCirclePersonalPushFragment paramQCirclePersonalPushFragment) {}
  
  public void a(@Nullable tzm<List<FeedCloudMeta.StFeed>> paramtzm)
  {
    QLog.d(QCirclePersonalPushFragment.a(), 4, "initViewData:getFeedListRequestRsp");
    QCirclePersonalPushFragment.a(this.a, paramtzm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     two
 * JD-Core Version:    0.7.0.1
 */