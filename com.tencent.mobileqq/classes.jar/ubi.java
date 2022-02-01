import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.util.ArrayList;
import java.util.List;

public class ubi
  extends zaj
{
  public FolderRecommendTabFragment.FolderRecommendHeadItemView a;
  
  public ubi(FolderRecommendTabFragment paramFolderRecommendTabFragment, Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, yzp paramyzp)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView = new FolderRecommendTabFragment.FolderRecommendHeadItemView(paramViewGroup.getContext());
    if (FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment) != null) {
      FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment).a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView;
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(List<bdda> paramList)
  {
    FolderRecommendTabFragment.FolderRecommendHeadItemView.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView).a(paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      FolderRecommendTabFragment.a("227", "227", ((bdda)paramList.get(0)).a.iAdId + "", 101, 1);
      this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$FolderRecommendHeadItemView.a(false);
  }
  
  public void a(yzu paramyzu)
  {
    paramyzu = new ArrayList();
    blbu localblbu = new blbu();
    localblbu.a = 476;
    localblbu.b = 6;
    paramyzu.add(localblbu);
    blbw.a().a(paramyzu, FolderRecommendTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ubi
 * JD-Core Version:    0.7.0.1
 */