import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import mqq.app.AppActivity;

class yao
  implements DialogInterface.OnClickListener
{
  yao(yam paramyam, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_JavaLangString.toLowerCase();
    if (paramDialogInterface.startsWith("www.")) {
      paramDialogInterface = "http://" + this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Yam.jdField_a_of_type_MqqAppAppActivity, QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramDialogInterface);
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("fromQrcode", true);
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_sacan_qr");
      this.jdField_a_of_type_Yam.jdField_a_of_type_MqqAppAppActivity.startActivity(localIntent);
      if (this.jdField_a_of_type_Yam.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.e) {
        this.jdField_a_of_type_Yam.jdField_a_of_type_MqqAppAppActivity.finish();
      }
      if (this.jdField_a_of_type_Yam.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.b) {
        this.jdField_a_of_type_Yam.jdField_a_of_type_MqqAppAppActivity.finish();
      }
      return;
      if (paramDialogInterface.startsWith("https:")) {
        paramDialogInterface = "https" + this.jdField_a_of_type_JavaLangString.substring(5);
      } else if (paramDialogInterface.startsWith("http:")) {
        paramDialogInterface = "http" + this.jdField_a_of_type_JavaLangString.substring(4);
      } else {
        paramDialogInterface = this.jdField_a_of_type_JavaLangString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yao
 * JD-Core Version:    0.7.0.1
 */