import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class auba
  implements atza
{
  auba(auau paramauau) {}
  
  public void a(atzy.a parama)
  {
    parama = ((atzc)parama).b();
    if (parama == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      if ((TextUtils.isEmpty(parama.getFileName())) || (audx.fM(parama.getFileName()) != 0) || (!TextUtils.isEmpty(parama.getFilePath()))) {
        break label161;
      }
      localFileManagerEntity = parama.b();
      if (localFileManagerEntity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel", 2, "mEntity = null");
    return;
    Object localObject = apsv.a(this.this$0.mAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.strTroopFileID, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
    if (((apcy)localObject).ThumbnailFile_Large == null)
    {
      localObject = TroopFileTransferManager.a(this.this$0.mAppInterface, localFileManagerEntity.TroopUin);
      if (localFileManagerEntity.strTroopFileID == null) {
        ((TroopFileTransferManager)localObject).e(localFileManagerEntity.strTroopFilePath, parama.getFileName(), localFileManagerEntity.busId, 640);
      }
    }
    for (;;)
    {
      label161:
      this.this$0.a(parama, 4);
      return;
      ((TroopFileTransferManager)localObject).a(UUID.fromString(localFileManagerEntity.strTroopFileID), 640);
      continue;
      if (this.this$0.a != null) {
        this.this$0.a.fP(((apcy)localObject).FilePath, ((apcy)localObject).ThumbnailFile_Large);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auba
 * JD-Core Version:    0.7.0.1
 */