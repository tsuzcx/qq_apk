import android.content.Context;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;

public class atkv
  extends atkw
{
  public boolean a(CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRecentInfo", 1, "create. fileName[" + paramCloudHistoryInfo.fileName + "] filePath[" + paramCloudHistoryInfo.localPath + "]");
    }
    if (aueh.fileExistsAndNotEmpty(paramCloudHistoryInfo.localPath)) {
      try
      {
        this.fQ = audx.a(new FileInfo(paramCloudHistoryInfo.localPath));
        return true;
      }
      catch (FileNotFoundException paramCloudHistoryInfo)
      {
        paramCloudHistoryInfo.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public void fZ(Context paramContext)
  {
    super.fZ(paramContext);
  }
  
  public int getFileType()
  {
    return audx.fM(this.cGT);
  }
  
  public void n(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.n(paramQQAppInterface, paramContext);
  }
  
  public String uZ()
  {
    return this.cGT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atkv
 * JD-Core Version:    0.7.0.1
 */