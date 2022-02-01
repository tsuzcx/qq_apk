import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Arrays;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class pac
  implements Observer<ovy>
{
  public pac(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void a(@Nullable ovy paramovy)
  {
    if ((QCircleFolderFollowTabFragment.a(this.a) != null) && (this.a.a != null) && (this.a.a.a != null))
    {
      if (paramovy != null)
      {
        paramovy.qp(ouw.c(this.a.a.a.urlInfo.get(), "NoticeListUrl"));
        boolean bool = paramovy.HD();
        if (bool) {
          pco.h("", 18, 1L);
        }
        QCircleFolderFollowTabFragment.a(this.a).ur(bool);
        QCircleFolderFollowTabFragment.a(this.a).setDatas(new ArrayList(Arrays.asList(new ovy[] { paramovy })));
      }
    }
    else {
      return;
    }
    QCircleFolderFollowTabFragment.a(this.a).ur(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pac
 * JD-Core Version:    0.7.0.1
 */