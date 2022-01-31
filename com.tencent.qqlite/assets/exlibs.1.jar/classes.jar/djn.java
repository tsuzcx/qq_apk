import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;

public final class djn
  implements DialogInterface.OnClickListener
{
  public djn(String paramString, long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new FileManagerReporter.fileAssistantReportData();
    paramDialogInterface.b = "file_local_qqbrowse_download";
    paramDialogInterface.c = this.jdField_a_of_type_JavaLangString;
    paramDialogInterface.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramDialogInterface);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("_filename_from_dlg", this.jdField_a_of_type_AndroidAppActivity.getString(2131363577));
    UniformDownloadMgr.a().a("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10386", paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     djn
 * JD-Core Version:    0.7.0.1
 */