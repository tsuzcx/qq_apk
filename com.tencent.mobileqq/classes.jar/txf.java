import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalPushFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class txf
  implements Observer<ubz<List<FeedCloudMeta.StFeed>>>
{
  public txf(QCirclePersonalPushFragment paramQCirclePersonalPushFragment) {}
  
  public void a(@Nullable ubz<List<FeedCloudMeta.StFeed>> paramubz)
  {
    QLog.d(QCirclePersonalPushFragment.a(), 4, "initViewData:getFeedListRequestRsp");
    QCirclePersonalPushFragment.a(this.a, paramubz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txf
 * JD-Core Version:    0.7.0.1
 */