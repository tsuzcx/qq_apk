import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;

public class bry
  implements DialogInterface.OnClickListener
{
  public bry(QRCardActivity paramQRCardActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_JavaLangString.toLowerCase();
    if (paramDialogInterface.startsWith("www.")) {
      paramDialogInterface = "http://" + this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity, QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramDialogInterface);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("injectrecommend", false);
      this.jdField_a_of_type_ComTencentBizQrcodeActivityQRCardActivity.startActivity(localIntent);
      return;
      if (paramDialogInterface.startsWith("https:")) {
        paramDialogInterface = "https" + this.jdField_a_of_type_JavaLangString.substring(5);
      } else if (paramDialogInterface.startsWith("http:")) {
        paramDialogInterface = "http" + this.jdField_a_of_type_JavaLangString.substring(4);
      } else {
        paramDialogInterface = "http://" + this.jdField_a_of_type_JavaLangString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bry
 * JD-Core Version:    0.7.0.1
 */