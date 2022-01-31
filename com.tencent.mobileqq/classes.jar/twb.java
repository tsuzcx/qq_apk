import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class twb
  implements Observer<tzm<List<FeedCloudMeta.StFeed>>>
{
  public twb(QCircleBaseTabFragment paramQCircleBaseTabFragment) {}
  
  public void a(@Nullable tzm<List<FeedCloudMeta.StFeed>> paramtzm)
  {
    QLog.d(QCircleBaseTabFragment.c, 4, "initViewData:getFeedListRequestRsp" + this.a.a());
    this.a.a(paramtzm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twb
 * JD-Core Version:    0.7.0.1
 */