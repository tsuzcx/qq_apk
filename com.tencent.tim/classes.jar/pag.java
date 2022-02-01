import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.ArrayList;
import java.util.Arrays;

public class pag
  implements Observer<pel<FeedCloudRead.StGetMainPageRsp>>
{
  public pag(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment) {}
  
  public void b(@Nullable pel<FeedCloudRead.StGetMainPageRsp> parampel)
  {
    if (parampel != null) {
      QLog.d("QCirclePersonalDetailFragment", 1, "Observe StGetMainPageRsp state:" + parampel.getState());
    }
    try
    {
      QLog.d("QCirclePersonalDetailFragment", 1, "personDetail uiStateData is" + parampel.getState());
      if ((parampel != null) && ((parampel.getState() == 2) || (parampel.getState() == 3)))
      {
        if (this.a.a != null)
        {
          QLog.e("QCirclePersonalDetailFragment", 1, "personDetail mPersonalDetailHeaderAdapter is not null");
          this.a.a.setDatas(new ArrayList(Arrays.asList(new FeedCloudRead.StGetMainPageRsp[] { (FeedCloudRead.StGetMainPageRsp)parampel.getData() })));
          this.a.a.notifyLoadingComplete(true);
          return;
        }
        QLog.e("QCirclePersonalDetailFragment", 1, "personDetail mPersonalDetailHeaderAdapter is null");
        return;
      }
    }
    catch (Exception parampel)
    {
      parampel.printStackTrace();
      QLog.e("QCirclePersonalDetailFragment", 1, "personDetail setData error" + parampel.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pag
 * JD-Core Version:    0.7.0.1
 */