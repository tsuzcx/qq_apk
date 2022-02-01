import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.List;

public class ubh
  implements ViewPager.OnPageChangeListener
{
  public ubh(FolderRecommendTabFragment.FolderRecommendHeadItemView paramFolderRecommendHeadItemView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    bdda localbdda = (bdda)FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.a).a().get(paramInt);
    if (localbdda != null) {
      FolderRecommendTabFragment.a("227", "227", localbdda.a.iAdId + "", 101, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ubh
 * JD-Core Version:    0.7.0.1
 */