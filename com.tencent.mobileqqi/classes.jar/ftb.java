import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public final class ftb
  implements DialogInterface.OnClickListener
{
  public ftb(String paramString, long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new FileManagerReporter.fileAssistantReportData();
    paramDialogInterface.jdField_a_of_type_JavaLangString = "file_local_qqmusic_download";
    paramDialogInterface.b = this.jdField_a_of_type_JavaLangString;
    paramDialogInterface.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramDialogInterface);
    long l = 0L;
    for (;;)
    {
      try
      {
        paramDialogInterface = new URL("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435");
      }
      catch (MalformedURLException paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
        continue;
      }
      try
      {
        paramInt = paramDialogInterface.openConnection().getContentLength();
        l = paramInt;
      }
      catch (IOException paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
      }
    }
    paramDialogInterface = new Bundle();
    paramDialogInterface.putLong("_filesize_from_dlg", l);
    paramDialogInterface.putString("_filename_from_dlg", this.jdField_a_of_type_AndroidAppActivity.getString(2131562688));
    UniformDownloadMgr.a().a("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435", paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ftb
 * JD-Core Version:    0.7.0.1
 */