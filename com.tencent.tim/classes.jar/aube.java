import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aube
  implements atyz
{
  aube(auau paramauau) {}
  
  public void iE()
  {
    FileManagerEntity localFileManagerEntity = this.this$0.c.b();
    apcy localapcy = apsv.a(this.this$0.mAppInterface, localFileManagerEntity);
    if ((TextUtils.isEmpty(auau.a(this.this$0))) && (localapcy.Id != null)) {
      auau.a(this.this$0, localapcy.Id.toString());
    }
    apca localapca = new apca(localFileManagerEntity.TroopUin, this.this$0.mAppInterface, this.this$0.mContext);
    if ((localapcy.Status == 10) || (localapcy.Status == 9)) {
      if (localapcy.Id != null)
      {
        localapca.b(localapcy.Id);
        localFileManagerEntity.status = 2;
      }
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("TroopFileModel", 2, "TroopFileModel doStartDownload : resumeDownload error, infoId is null");
      return;
      if (localapcy.Status == 7)
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localapca.P(localFileManagerEntity);
        }
        for (;;)
        {
          localFileManagerEntity.status = 2;
          return;
          localapca.i(localFileManagerEntity.strTroopFilePath, localapcy.FileName, localapcy.ProgressTotal, localapcy.BusId);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
  }
  
  public void iF()
  {
    Object localObject = this.this$0.c.b();
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.this$0.mAppInterface, ((FileManagerEntity)localObject).TroopUin);
    localObject = apsv.a(this.this$0.mAppInterface, (FileManagerEntity)localObject);
    if (!TextUtils.isEmpty(auau.a(this.this$0)))
    {
      localTroopFileTransferManager.d(UUID.fromString(auau.a(this.this$0)));
      auau.a(this.this$0, (apcy)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aube
 * JD-Core Version:    0.7.0.1
 */