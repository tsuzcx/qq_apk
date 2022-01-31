import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;

class feq
  implements DialogInterface.OnClickListener
{
  feq(fep paramfep) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_AndroidOsBundle.putBoolean(DownloadConstants.q, false);
    DownloadApi.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_AndroidOsBundle, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentApkupdateLogicDataApkUpdateDetail, this.a.b);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     feq
 * JD-Core Version:    0.7.0.1
 */