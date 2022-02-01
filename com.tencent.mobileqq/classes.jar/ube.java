import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import java.util.List;

public class ube
  implements blbv
{
  public ube(FolderRecommendTabFragment paramFolderRecommendTabFragment) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    List localList = null;
    if (paramBoolean) {
      localList = bdda.a(paramBoolean, paramGetAdsRsp, 476);
    }
    if (FolderRecommendTabFragment.a(this.a) != null) {
      FolderRecommendTabFragment.a(this.a).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ube
 * JD-Core Version:    0.7.0.1
 */