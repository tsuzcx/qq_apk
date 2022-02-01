import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.tianshu.TianShuAdPosItemData;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;

public class upf
  extends zpo
{
  public FolderRecommendTabFragment.FolderRecommendHeadItemView a;
  
  public upf(FolderRecommendTabFragment paramFolderRecommendTabFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, zou paramzou)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = new FolderRecommendTabFragment.FolderRecommendHeadItemView(paramViewGroup.getContext());
    if (FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment) != null) {
      FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment).a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(List<bekc> paramList)
  {
    FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView).a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      FolderRecommendTabFragment.a("227", "227", ((bekc)paramList.get(0)).a.iAdId + "", 101, 1);
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(false);
  }
  
  public void a(zoz paramzoz)
  {
    paramzoz = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.mPosId = 476;
    localTianShuAdPosItemData.mNeedCnt = 6;
    paramzoz.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(paramzoz, FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upf
 * JD-Core Version:    0.7.0.1
 */