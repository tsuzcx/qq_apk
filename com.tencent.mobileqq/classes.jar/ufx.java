import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.7;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ufx
  implements rxm
{
  public ufx(PublicAccountH5AbilityPlugin.7 param7, bhht parambhht, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    int i;
    if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
    {
      this.jdField_a_of_type_Bhht.dismiss();
      i = paramBundle.getInt("VALUE_CAMERA_CAPTURE_SO_DOWNLOAD_STATUS");
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage VideoFeedsIPCClient.callback downloadResult=" + i);
      }
    }
    switch (i)
    {
    default: 
      return;
    case 3: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131717741, 0).a();
      return;
    case 1: 
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin$7.this$0.jdField_a_of_type_Rxk.a("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage() isSoReady:" + bool);
      }
      ufd.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin$7.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.f, this.g, this.h);
      return;
    }
    bfur.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin$7.this$0.jdField_a_of_type_AndroidAppActivity, 230).setMessage(amtj.a(2131707896)).setNegativeButton(2131690620, new bfvf()).setPositiveButton(2131694201, new ufy(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufx
 * JD-Core Version:    0.7.0.1
 */