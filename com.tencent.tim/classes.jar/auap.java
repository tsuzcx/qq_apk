import com.tencent.cloudfile.CloudFile;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class auap
  implements ahal.a
{
  auap(auao paramauao) {}
  
  public void aD()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    FileManagerEntity localFileManagerEntity = this.a.this$0.c.b();
    Object localObject2 = localFileManagerEntity.cloudFile;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = athu.a(localFileManagerEntity);
      localFileManagerEntity.cloudFile = ((CloudFile)localObject1);
    }
    localObject2 = (atgc)localQQAppInterface.getManager(373);
    if (!localFileManagerEntity.fromCloudFile)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TIMCloudFileModel", 2, "start download cloud file: recent, from aio.");
      }
      if (auaj.a(this.a.this$0, localFileManagerEntity)) {
        atgi.a().a(athu.a(localQQAppInterface, localFileManagerEntity), new auaq(this, localFileManagerEntity));
      }
    }
    for (;;)
    {
      if (this.a.this$0.a != null) {
        this.a.this$0.a.djE();
      }
      return;
      auaj.a(this.a.this$0, localQQAppInterface, localFileManagerEntity);
      continue;
      if (Arrays.equals(localFileManagerEntity.pDirKey, ((atgc)localObject2).aF()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TIMCloudFileModel", 2, "start download cloud file: recent, from folder.");
        }
        localObject2 = this.a.this$0.mAppInterface.a().a(((CloudFile)localObject1).cloudId);
        atgc localatgc = (atgc)localQQAppInterface.getManager(373);
        if ((localObject2 == null) || (auaj.a(this.a.this$0, (FileManagerEntity)localObject2)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TIMCloudFileModel", 2, "aio recent file expired or entity null");
          }
          localFileManagerEntity.nOpType = -1;
          localatgc.y(localFileManagerEntity);
          atgi.a().startDownloadFile(((CloudFile)localObject1).pLogicDirKey, ((CloudFile)localObject1).cloudId, acbn.bmg + localFileManagerEntity.fileName);
        }
        else
        {
          localatgc.y((FileManagerEntity)localObject2);
          auaj.a(this.a.this$0, localQQAppInterface, (FileManagerEntity)localObject2);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("TIMCloudFileModel", 2, "start download cloud file: normal.");
        }
        atgi.a().startDownloadFile(((CloudFile)localObject1).pLogicDirKey, ((CloudFile)localObject1).cloudId, acbn.bmg + localFileManagerEntity.fileName);
      }
    }
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auap
 * JD-Core Version:    0.7.0.1
 */