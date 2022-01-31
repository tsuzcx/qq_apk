import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class twq
  implements Observer<ubz<List<FeedCloudMeta.StFeed>>>
{
  public twq(QCircleBaseTabFragment paramQCircleBaseTabFragment) {}
  
  public void a(@Nullable ubz<List<FeedCloudMeta.StFeed>> paramubz)
  {
    if (paramubz != null) {
      QLog.d(QCircleBaseTabFragment.b, 4, "initViewData:getFeedListRequestRsp_" + this.a.b() + ",state:" + paramubz.a());
    }
    this.a.a(paramubz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twq
 * JD-Core Version:    0.7.0.1
 */