import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

final class ooh
  implements opn.a
{
  ooh(WSVerticalPageFragment paramWSVerticalPageFragment, String paramString1, String paramString2, stJumpInfo paramstJumpInfo, int paramInt) {}
  
  public void aU(String paramString, int paramInt)
  {
    opb.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), "biz_src_jc_gzh_weishi", paramString, 1, ohy.a().rp(), 0);
    oog.b(this.val$from, this.apX, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000003);
  }
  
  public void aV(String paramString, int paramInt)
  {
    oog.b(this.val$from, this.apX, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000004);
    ogj.aM(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), paramString);
  }
  
  public void aW(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    stGlobalConfig localstGlobalConfig = ohy.a().a();
    if (localstGlobalConfig != null) {}
    for (paramInt = localstGlobalConfig.link_strategy_type;; paramInt = 0)
    {
      localWSDownloadParams.mLinkStrategyType = paramInt;
      localWSDownloadParams.mEventId = 12;
      localWSDownloadParams.mTestId = ong.lD();
      localWSDownloadParams.mScheme = paramString;
      paramString = ond.getInitialReportItem();
      paramString.pagetype = 5;
      paramString.optype = 115;
      paramString.upos = (this.bfw + 1);
      localWSDownloadParams.mStReportItem = paramString;
      oir.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), localWSDownloadParams, false);
      ond.reportBlockPage(6, this.jdField_a_of_type_UserGrowthStJumpInfo.id, 5);
      oog.b(this.val$from, this.apX, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000002);
      return;
    }
  }
  
  public void aX(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ooh
 * JD-Core Version:    0.7.0.1
 */