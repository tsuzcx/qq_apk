import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

class hnc
  implements DialogInterface.OnClickListener
{
  hnc(hna paramhna) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      paramDialogInterface = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.a);
      String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.i);
      String str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.e);
      String str3 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.h);
      String str4 = this.a.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.k);
      boolean bool = this.a.jdField_a_of_type_AndroidOsBundle.getBoolean(DownloadConstants.x, true);
      paramDialogInterface = new DownloadInfo(paramDialogInterface, str1.trim(), str2, str4, str3, null, this.a.jdField_a_of_type_Int, bool);
      this.a.jdField_a_of_type_ComTencentOpenDownloadnewDownloadManager.a(10, paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hnc
 * JD-Core Version:    0.7.0.1
 */