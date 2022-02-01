import android.app.Activity;
import android.content.Context;
import android.view.View.OnClickListener;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;

public class atkq
  extends atkw
{
  public ForwardFileInfo a()
  {
    if (this.fQ != null) {
      return atyv.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), (FileManagerEntity)this.fQ);
    }
    return super.a();
  }
  
  public boolean a(CloudHistoryInfo paramCloudHistoryInfo, Object paramObject)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.i("C2CRecentInfo", 1, "create. fileName[" + paramCloudHistoryInfo.fileName + "] filePath[" + paramCloudHistoryInfo.localPath + "]");
    }
    boolean bool3 = aueh.fileExistsAndNotEmpty(paramCloudHistoryInfo.localPath);
    this.fQ = paramObject;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (paramObject == null) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void fZ(Context paramContext)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.fQ;
    if (localFileManagerEntity != null)
    {
      atxh.a(null, localFileManagerEntity, (Activity)paramContext, null).onClick(null);
      return;
    }
    super.fZ(paramContext);
  }
  
  public int getFileType()
  {
    if (this.fQ != null) {
      return ((FileManagerEntity)this.fQ).nFileType;
    }
    return super.getFileType();
  }
  
  public void n(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (this.fQ != null)
    {
      paramQQAppInterface = audk.a((FileManagerEntity)this.fQ);
      paramQQAppInterface.Oy(1);
      paramQQAppInterface.cB((Activity)paramContext);
      return;
    }
    super.n(paramQQAppInterface, paramContext);
  }
  
  public String uZ()
  {
    if (this.fQ != null) {
      return athu.j((FileManagerEntity)this.fQ);
    }
    return super.uZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atkq
 * JD-Core Version:    0.7.0.1
 */