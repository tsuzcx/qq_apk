import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Arrays;

public class twz
  implements Observer<ubz<FeedCloudRead.StGetMainPageRsp>>
{
  public twz(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public void a(@Nullable ubz<FeedCloudRead.StGetMainPageRsp> paramubz)
  {
    if (paramubz != null) {
      QLog.d("QCirclePersonalDetailFragment", 1, "Observe StGetMainPageRsp state:" + paramubz.a());
    }
    try
    {
      QLog.d("QCirclePersonalDetailFragment", 1, "personDetail uiStateData is" + paramubz.a());
      if ((paramubz != null) && ((paramubz.a() == 2) || (paramubz.a() == 3)))
      {
        if (this.a.a != null)
        {
          QLog.e("QCirclePersonalDetailFragment", 1, "personDetail mPersonalDetailHeaderAdapter is not null");
          this.a.a.setDatas(new ArrayList(Arrays.asList(new FeedCloudRead.StGetMainPageRsp[] { (FeedCloudRead.StGetMainPageRsp)paramubz.a() })));
          this.a.a.notifyLoadingComplete(true);
          return;
        }
        QLog.e("QCirclePersonalDetailFragment", 1, "personDetail mPersonalDetailHeaderAdapter is null");
        return;
      }
    }
    catch (Exception paramubz)
    {
      paramubz.printStackTrace();
      QLog.e("QCirclePersonalDetailFragment", 1, "personDetail setData error" + paramubz.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twz
 * JD-Core Version:    0.7.0.1
 */