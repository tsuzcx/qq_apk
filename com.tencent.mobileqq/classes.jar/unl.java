import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

final class unl
  implements DialogInterface.OnClickListener
{
  unl(Activity paramActivity, String paramString, WSDownloadParams paramWSDownloadParams, int paramInt1, int paramInt2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (yqu.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      uyc.a(this.jdField_a_of_type_AndroidAppActivity, "biz_src_jc_gzh_weishi", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mScene, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mLinkStrategyType, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mEventId);
      uvi.a(114, this.jdField_a_of_type_Int, this.b, null);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      uvr.b(112, 1, 0);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mStReportItem == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mStReportItem = uvi.a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mStReportItem.downloadscene = unq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mScene, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mLinkStrategyType, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mEventId);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mStReportItem.comment_loctaion = this.b;
      unq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unl
 * JD-Core Version:    0.7.0.1
 */