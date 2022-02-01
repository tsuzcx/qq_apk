import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalPushFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class pal
  implements Observer<pel<List<FeedCloudMeta.StFeed>>>
{
  public pal(QCirclePersonalPushFragment paramQCirclePersonalPushFragment) {}
  
  public void b(@Nullable pel<List<FeedCloudMeta.StFeed>> parampel)
  {
    QLog.d(QCirclePersonalPushFragment.access$000(), 4, "initViewData:getFeedListRequestRsp");
    QCirclePersonalPushFragment.a(this.a, parampel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pal
 * JD-Core Version:    0.7.0.1
 */