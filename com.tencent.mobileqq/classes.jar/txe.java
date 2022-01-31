import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDynamicFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class txe
  implements Observer<ubz<List<FeedCloudMeta.StFeed>>>
{
  public txe(QCirclePersonalDynamicFragment paramQCirclePersonalDynamicFragment) {}
  
  public void a(@Nullable ubz<List<FeedCloudMeta.StFeed>> paramubz)
  {
    QLog.d(QCirclePersonalDynamicFragment.a(), 4, "initViewData:getFeedListRequestRsp");
    QCirclePersonalDynamicFragment.a(this.a, paramubz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txe
 * JD-Core Version:    0.7.0.1
 */