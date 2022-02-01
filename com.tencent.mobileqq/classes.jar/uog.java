import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

final class uog
  implements upz
{
  uog(WSVerticalPageFragment paramWSVerticalPageFragment, String paramString1, String paramString2, stJumpInfo paramstJumpInfo, int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    upg.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), "biz_src_jc_gzh_weishi", paramString, 1, ugb.a().a(), 0);
    uof.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000003);
  }
  
  public void b(String paramString, int paramInt)
  {
    uof.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000004);
    uee.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), paramString);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    stGlobalConfig localstGlobalConfig = ugb.a().a();
    if (localstGlobalConfig != null) {}
    for (paramInt = localstGlobalConfig.link_strategy_type;; paramInt = 0)
    {
      localWSDownloadParams.mLinkStrategyType = paramInt;
      localWSDownloadParams.mEventId = 12;
      localWSDownloadParams.mTestId = umw.b();
      localWSDownloadParams.mScheme = paramString;
      paramString = umq.a();
      paramString.pagetype = 5;
      paramString.optype = 115;
      paramString.upos = (this.jdField_a_of_type_Int + 1);
      localWSDownloadParams.mStReportItem = paramString;
      ugx.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), localWSDownloadParams, false);
      umq.a(6, this.jdField_a_of_type_UserGrowthStJumpInfo.id, 5);
      uof.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000002);
      return;
    }
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uog
 * JD-Core Version:    0.7.0.1
 */