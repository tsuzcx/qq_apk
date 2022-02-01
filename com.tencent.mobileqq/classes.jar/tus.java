import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.ArrayList;
import java.util.List;

public class tus
  extends aacq
{
  public FolderRecommendTabFragment.FolderRecommendHeadItemView a;
  
  public tus(FolderRecommendTabFragment paramFolderRecommendTabFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, aabp paramaabp)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = new FolderRecommendTabFragment.FolderRecommendHeadItemView(paramViewGroup.getContext());
    if (FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment) != null) {
      FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment).a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  }
  
  public void a(List<beke> paramList)
  {
    FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView).a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      FolderRecommendTabFragment.a("227", "227", ((beke)paramList.get(0)).a.iAdId + "", 101, 1);
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(false);
  }
  
  public void loadData(aabu paramaabu)
  {
    paramaabu = new ArrayList();
    bnwo localbnwo = new bnwo();
    localbnwo.a = 476;
    localbnwo.b = 6;
    paramaabu.add(localbnwo);
    bnwq.a().a(paramaabu, FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment));
  }
  
  public void onInitBlock(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tus
 * JD-Core Version:    0.7.0.1
 */