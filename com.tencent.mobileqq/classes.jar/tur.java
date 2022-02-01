import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.List;

public class tur
  implements ViewPager.OnPageChangeListener
{
  public tur(FolderRecommendTabFragment.FolderRecommendHeadItemView paramFolderRecommendHeadItemView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    beke localbeke = (beke)FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.a).a().get(paramInt);
    if (localbeke != null) {
      FolderRecommendTabFragment.a("227", "227", localbeke.a.iAdId + "", 101, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tur
 * JD-Core Version:    0.7.0.1
 */