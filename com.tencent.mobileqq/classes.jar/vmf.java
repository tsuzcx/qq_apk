import UserGrowth.stJumpInfo;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

class vmf
  implements vnn
{
  vmf(vme paramvme, WSVerticalPageFragment paramWSVerticalPageFragment, String paramString1, String paramString2, stJumpInfo paramstJumpInfo, int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    vmr.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), "biz_src_jc_gzh_weishi", paramString, 1, vau.a().a(), 0);
    vme.a(this.jdField_a_of_type_Vme, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000003, 1);
  }
  
  public void b(String paramString, int paramInt)
  {
    vme.a(this.jdField_a_of_type_Vme, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000004, 2);
    uyt.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), paramString);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = vau.a().a();
    localWSDownloadParams.mEventId = 12;
    localWSDownloadParams.mTestId = vkf.b();
    localWSDownloadParams.mScheme = paramString;
    paramString = vjx.a();
    paramString.pagetype = 5;
    paramString.optype = 115;
    paramString.upos = (this.jdField_a_of_type_Int + 1);
    localWSDownloadParams.mStReportItem = paramString;
    vbq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), localWSDownloadParams, false);
    vjx.a(6, this.jdField_a_of_type_UserGrowthStJumpInfo.id, 5);
    vme.a(this.jdField_a_of_type_Vme, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_UserGrowthStJumpInfo, 1000002, 0);
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmf
 * JD-Core Version:    0.7.0.1
 */