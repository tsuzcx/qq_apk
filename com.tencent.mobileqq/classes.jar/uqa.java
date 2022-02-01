import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

final class uqa
  implements upr
{
  uqa(Activity paramActivity, String paramString1, WSDownloadParams paramWSDownloadParams, String paramString2, int paramInt) {}
  
  public void a()
  {
    uqh.a(this.jdField_a_of_type_AndroidAppActivity, "biz_src_jc_gzh_weishi", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mScene, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mLinkStrategyType, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mEventId);
  }
  
  public void b()
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_exposure", "dynamics_" + this.b + this.jdField_a_of_type_Int, 0);
  }
  
  public void c()
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", "dynamics_" + this.b + this.jdField_a_of_type_Int, 1000001);
    uqh.a(this.jdField_a_of_type_AndroidAppActivity, "biz_src_jc_gzh_weishi", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mScene, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mLinkStrategyType, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mEventId);
  }
  
  public void d()
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", "dynamics_" + this.b + this.jdField_a_of_type_Int, 1000005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqa
 * JD-Core Version:    0.7.0.1
 */