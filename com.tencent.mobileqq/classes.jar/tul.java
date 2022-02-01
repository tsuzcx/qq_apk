import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.network.SubscribeGetFollowFeedsRequest;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class tul
  implements aaav<CertifiedAccountRead.StGetFollowFeedsRsp>
{
  public tul(FolderFollowTabFragment paramFolderFollowTabFragment, SubscribeGetFollowFeedsRequest paramSubscribeGetFollowFeedsRequest, aagu paramaagu) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowFeedsRsp paramStGetFollowFeedsRsp)
  {
    boolean bool1 = true;
    boolean bool2 = VSNetworkHelper.a(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowFeedsRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QQToast.a(FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment), 1, paramString, 0).a();
      }
      if (!bool2)
      {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkSubscribeGetFollowFeedsRequest);
        if ((this.jdField_a_of_type_Aagu.getItemCount() == 0) && (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment) != null)) {
          FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a(true);
        }
      }
      return;
    }
    this.jdField_a_of_type_Aagu.getLoadInfo().d(paramStGetFollowFeedsRsp.livePageInfo.get());
    if ((FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment) != null) && (!bool2) && (paramStGetFollowFeedsRsp.messStatus.get() != null))
    {
      FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a(paramStGetFollowFeedsRsp.messStatus.noticeCount.get());
      FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).setJumpWebMessageListUrl(paramStGetFollowFeedsRsp.messStatus.jumpURL.get());
    }
    if ((!bool2) && (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment)))
    {
      if (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment)) {
        FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment, false);
      }
      paramString = paramStGetFollowFeedsRsp.careLive.get();
      if ((paramString == null) || (paramString.size() <= 0)) {
        break label312;
      }
      if (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment) != null) {
        FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a(false);
      }
      aagu localaagu = this.jdField_a_of_type_Aagu;
      COMM.StCommonExt localStCommonExt = paramStGetFollowFeedsRsp.extInfo;
      if (paramStGetFollowFeedsRsp.isFinish.get() != 1) {
        break label306;
      }
      localaagu.a(paramString, localStCommonExt, bool1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aagu.notifyLoadingComplete(paramBoolean);
      return;
      label306:
      bool1 = false;
      break;
      label312:
      this.jdField_a_of_type_Aagu.clearData();
      if (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment) != null) {
        FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a(true);
      }
      if (!bool2) {
        VSBaseRequest.reMoveCache(this.jdField_a_of_type_ComTencentBizSubscribeNetworkSubscribeGetFollowFeedsRequest);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tul
 * JD-Core Version:    0.7.0.1
 */