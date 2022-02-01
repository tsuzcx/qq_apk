import UserGrowth.stJumpInfo;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

class uxq
  implements uyv
{
  uxq(uxp paramuxp, WSVerticalPageFragment paramWSVerticalPageFragment, String paramString1, String paramString2, stJumpInfo paramstJumpInfo, int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    uyc.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), "biz_src_jc_gzh_weishi", paramString, 1, umu.a().a(), 0);
    uxp.a(this.jdField_a_of_type_Uxp, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000003, 1);
  }
  
  public void b(String paramString, int paramInt)
  {
    uxp.a(this.jdField_a_of_type_Uxp, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000004, 2);
    ukw.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), paramString);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = umu.a().a();
    localWSDownloadParams.mEventId = 12;
    localWSDownloadParams.mTestId = uvr.b();
    localWSDownloadParams.mScheme = paramString;
    paramString = uvi.a();
    paramString.pagetype = 5;
    paramString.optype = 115;
    paramString.upos = (this.jdField_a_of_type_Int + 1);
    localWSDownloadParams.mStReportItem = paramString;
    unq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), localWSDownloadParams, false);
    uvi.a(6, this.jdField_a_of_type_UserGrowthStJumpInfo.id, 5);
    uxp.a(this.jdField_a_of_type_Uxp, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000002, 0);
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxq
 * JD-Core Version:    0.7.0.1
 */