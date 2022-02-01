import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Arrays;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class vma
  implements Observer<uzl>
{
  public vma(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void a(@Nullable uzl paramuzl)
  {
    if ((QCircleFolderFollowTabFragment.a(this.a) != null) && (QCircleFolderFollowTabFragment.a(this.a) != null) && (QCircleFolderFollowTabFragment.b(this.a).a != null))
    {
      if (paramuzl == null) {
        break label119;
      }
      paramuzl.a(uxn.a(QCircleFolderFollowTabFragment.c(this.a).a.urlInfo.get(), "NoticeListUrl"));
      boolean bool = paramuzl.a();
      QCircleFolderFollowTabFragment.a(this.a).a(bool);
      if (bool)
      {
        vrf.a("", 18, 1);
        QCircleFolderFollowTabFragment.a(this.a).setDatas(new ArrayList(Arrays.asList(new uzl[] { paramuzl })));
      }
    }
    return;
    label119:
    QCircleFolderFollowTabFragment.a(this.a).a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vma
 * JD-Core Version:    0.7.0.1
 */