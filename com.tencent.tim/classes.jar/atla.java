import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.wps.WPSFilePreviewActivity;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.util.BinderWarpper;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import mqq.app.MobileQQ;
import tencent.cloud.history_file_extension.history_file_extension.FileExtension;
import tencent.cloud.history_file_extension.history_file_extension.WPSFileExtension;

public class atla
  extends atkw
{
  public boolean a(CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WPSRecentInfo", 1, "create. fileName[" + paramCloudHistoryInfo.fileName + "] filePath[" + paramCloudHistoryInfo.localPath + "]");
    }
    if ((aueh.fileExistsAndNotEmpty(paramCloudHistoryInfo.localPath)) && (paramObject == null)) {
      try
      {
        this.fQ = audx.a(new FileInfo(paramCloudHistoryInfo.localPath));
        return true;
      }
      catch (FileNotFoundException paramCloudHistoryInfo)
      {
        paramCloudHistoryInfo.printStackTrace();
        return true;
      }
    }
    this.fQ = paramObject;
    return true;
  }
  
  public void fZ(Context paramContext)
  {
    super.fZ(paramContext);
  }
  
  public int getFileType()
  {
    if (TextUtils.isEmpty(this.cGT)) {
      return audx.fM(this.fileName);
    }
    return super.getFileType();
  }
  
  public void n(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((this.jdField_a_of_type_TencentCloudHistory_file_extensionHistory_file_extension$FileExtension != null) && (this.jdField_a_of_type_TencentCloudHistory_file_extensionHistory_file_extension$FileExtension.wps_file_extension.has()))
    {
      localObject = paramQQAppInterface.a().c(new String(this.jdField_a_of_type_ComTencentCloudfileCloudHistoryInfo.fileSha), this.jdField_a_of_type_ComTencentCloudfileCloudHistoryInfo.fileName);
      if ((localObject != null) && (aqhq.fileExistsAndNotEmpty(((FileManagerEntity)localObject).getFilePath())))
      {
        paramQQAppInterface = new ForwardFileInfo();
        paramQQAppInterface.p(((FileManagerEntity)localObject).nSessionId);
        paramQQAppInterface.Oj(3);
        paramQQAppInterface.setType(10000);
        paramQQAppInterface.setLocalPath(((FileManagerEntity)localObject).getFilePath());
        paramQQAppInterface.setFileName(this.fileName);
        paramQQAppInterface.setFileSize(this.fileSize);
        localObject = new Intent(paramContext, FileBrowserActivity.class);
        ((Intent)localObject).putExtra("qfile_browser_entrance_type", 1);
        ((Intent)localObject).setFlags(268435456);
        ((Intent)localObject).putExtra("fileinfo", paramQQAppInterface);
        T(paramContext, (Intent)localObject);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          Object localObject;
          return;
          paramContext = this.jdField_a_of_type_TencentCloudHistory_file_extensionHistory_file_extension$FileExtension.wps_file_extension.str_preview_url.get();
          if (this.jdField_a_of_type_ComTencentCloudfileCloudHistoryInfo.fileSha != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("WPSRecentInfo<QFileCloud>", 1, "handleOpenFile : wps recent history sha is null. url[" + paramContext + "]");
        return;
        if (this.jdField_a_of_type_ComTencentCloudfileCloudHistoryInfo.fileIdBytes != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("WPSRecentInfo<QFileCloud>", 1, "handleOpenFile : wps recent history fileId is null. url[" + paramContext + "]");
      return;
      WPSFilePreviewActivity.a(new BinderWarpper(new atwj(paramQQAppInterface.getCurrentUin()).asBinder()), paramQQAppInterface.getApplication().getApplicationContext(), new String(this.jdField_a_of_type_ComTencentCloudfileCloudHistoryInfo.fileSha, Charset.forName("UTF-8")), this.jdField_a_of_type_ComTencentCloudfileCloudHistoryInfo.fileName, new String(this.jdField_a_of_type_ComTencentCloudfileCloudHistoryInfo.fileIdBytes, Charset.forName("UTF-8")), this.jdField_a_of_type_ComTencentCloudfileCloudHistoryInfo.fileSize, paramContext);
      return;
    }
    QLog.i("WPSRecentInfo", 1, "handleWPSFileClick. can not find the wps preview url");
  }
  
  public String uZ()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atla
 * JD-Core Version:    0.7.0.1
 */