import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Arrays;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class twu
  implements Observer<try>
{
  public twu(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void a(@Nullable try paramtry)
  {
    if ((QCircleFolderFollowTabFragment.a(this.a) != null) && (this.a.a != null) && (this.a.a.a != null))
    {
      if (paramtry != null)
      {
        paramtry.a(tqr.a(this.a.a.a.urlInfo.get(), "NoticeListUrl"));
        boolean bool = paramtry.a();
        if (bool) {
          tzv.a("", 18, 1L);
        }
        QCircleFolderFollowTabFragment.a(this.a).a(bool);
        QCircleFolderFollowTabFragment.a(this.a).setDatas(new ArrayList(Arrays.asList(new try[] { paramtry })));
      }
    }
    else {
      return;
    }
    QCircleFolderFollowTabFragment.a(this.a).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     twu
 * JD-Core Version:    0.7.0.1
 */