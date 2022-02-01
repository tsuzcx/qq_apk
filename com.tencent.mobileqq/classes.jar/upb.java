import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.tianshu.TianShuGetAdvCallback;
import java.util.List;

public class upb
  implements TianShuGetAdvCallback
{
  public upb(FolderRecommendTabFragment paramFolderRecommendTabFragment) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    List localList = null;
    if (paramBoolean) {
      localList = bekc.a(paramBoolean, paramGetAdsRsp, 476);
    }
    if (FolderRecommendTabFragment.a(this.a) != null) {
      FolderRecommendTabFragment.a(this.a).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upb
 * JD-Core Version:    0.7.0.1
 */