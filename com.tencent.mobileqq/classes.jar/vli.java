import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleBaseAggregationFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vli
  implements Observer<vxq<List<FeedCloudMeta.StFeed>>>
{
  public vli(QCircleBaseAggregationFragment paramQCircleBaseAggregationFragment) {}
  
  public void a(@Nullable vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    if (paramvxq != null) {
      QLog.d(QCircleBaseAggregationFragment.a, 4, "initViewData:getFeedListRequestRsp_" + this.a.a() + ",state:" + paramvxq.a());
    }
    this.a.a(paramvxq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vli
 * JD-Core Version:    0.7.0.1
 */