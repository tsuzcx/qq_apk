import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Arrays;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class twd
  implements Observer<trt>
{
  public twd(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void a(@Nullable trt paramtrt)
  {
    if ((QCircleFolderFollowTabFragment.a(this.a) != null) && (this.a.a != null) && (this.a.a.a != null))
    {
      if (paramtrt != null)
      {
        paramtrt.a(tqr.a(this.a.a.a.urlInfo.get(), "NoticeListUrl"));
        boolean bool = paramtrt.a();
        if (bool) {
          tyj.a("", 18, 1L);
        }
        QCircleFolderFollowTabFragment.a(this.a).a(bool);
        QCircleFolderFollowTabFragment.a(this.a).a(new ArrayList(Arrays.asList(new trt[] { paramtrt })));
      }
    }
    else {
      return;
    }
    QCircleFolderFollowTabFragment.a(this.a).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twd
 * JD-Core Version:    0.7.0.1
 */