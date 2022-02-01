import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class uoy
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFollowFeedsRsp>
{
  public uoy(FolderFollowTabFragment paramFolderFollowTabFragment, zsx paramzsx) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowFeedsRsp paramStGetFollowFeedsRsp)
  {
    boolean bool1 = true;
    boolean bool2 = VSNetworkHelper.isProtocolCache(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowFeedsRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QQToast.a(FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment), 1, paramString, 0).a();
      }
      if (!bool2)
      {
        VSBaseRequest.reMoveCache(paramVSBaseRequest);
        if ((this.jdField_a_of_type_Zsx.getItemCount() == 0) && (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment) != null)) {
          FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a(true);
        }
      }
      return;
    }
    this.jdField_a_of_type_Zsx.a().b(paramStGetFollowFeedsRsp.livePageInfo.get());
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
        break label307;
      }
      if (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment) != null) {
        FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a(false);
      }
      paramVSBaseRequest = this.jdField_a_of_type_Zsx;
      COMM.StCommonExt localStCommonExt = paramStGetFollowFeedsRsp.extInfo;
      if (paramStGetFollowFeedsRsp.isFinish.get() != 1) {
        break label301;
      }
      paramVSBaseRequest.a(paramString, localStCommonExt, bool1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Zsx.a(paramBoolean);
      return;
      label301:
      bool1 = false;
      break;
      label307:
      this.jdField_a_of_type_Zsx.e();
      if (FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment) != null) {
        FolderFollowTabFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderFollowTabFragment).a(true);
      }
      if (!bool2) {
        VSBaseRequest.reMoveCache(paramVSBaseRequest);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoy
 * JD-Core Version:    0.7.0.1
 */