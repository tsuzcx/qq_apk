import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class ozy
  implements Observer<pel<List<FeedCloudMeta.StFeed>>>
{
  public ozy(QCircleBaseTabFragment paramQCircleBaseTabFragment) {}
  
  public void b(@Nullable pel<List<FeedCloudMeta.StFeed>> parampel)
  {
    if (parampel != null) {
      QLog.d(QCircleBaseTabFragment.TAG, 4, "initViewData:getFeedListRequestRsp_" + this.this$0.lY() + ",state:" + parampel.getState());
    }
    this.this$0.h(parampel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozy
 * JD-Core Version:    0.7.0.1
 */