import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Arrays;

public class twi
  implements Observer<tzm<FeedCloudRead.StGetMainPageRsp>>
{
  public twi(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public void a(@Nullable tzm<FeedCloudRead.StGetMainPageRsp> paramtzm)
  {
    if (paramtzm != null) {
      try
      {
        if ((paramtzm.a() == 2) || (paramtzm.a() == 3))
        {
          if (this.a.a != null)
          {
            this.a.a.a(new ArrayList(Arrays.asList(new FeedCloudRead.StGetMainPageRsp[] { (FeedCloudRead.StGetMainPageRsp)paramtzm.a() })));
            this.a.a.d(true);
            return;
          }
          QLog.e(QCirclePersonalDetailFragment.c, 1, "mPersonalDetailHeaderAdapter is null");
          return;
        }
      }
      catch (Exception paramtzm)
      {
        QLog.e(QCirclePersonalDetailFragment.c, 1, "getShareInfo error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twi
 * JD-Core Version:    0.7.0.1
 */