import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.List;

public class upe
  implements ViewPager.OnPageChangeListener
{
  public upe(FolderRecommendTabFragment.FolderRecommendHeadItemView paramFolderRecommendHeadItemView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    bekc localbekc = (bekc)FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.a).a().get(paramInt);
    if (localbekc != null) {
      FolderRecommendTabFragment.a("227", "227", localbekc.a.iAdId + "", 101, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upe
 * JD-Core Version:    0.7.0.1
 */