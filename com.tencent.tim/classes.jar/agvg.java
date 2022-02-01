import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class agvg
  implements agsu
{
  agvg(aguu paramaguu) {}
  
  public void a(aguk.a parama)
  {
    parama = ((agsx)parama).b();
    if (parama == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity;
    Object localObject;
    if ((ahav.getFileType(parama.getFileName()) == 0) && (!TextUtils.isEmpty(parama.getFileName())) && (TextUtils.isEmpty(parama.getFilePath())))
    {
      localFileManagerEntity = parama.b();
      if (localFileManagerEntity == null)
      {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : can not get the troop file entity, return.");
        return;
      }
      localObject = apsv.a(this.this$0.mAppInterface, localFileManagerEntity.TroopUin, localFileManagerEntity.strTroopFileID, localFileManagerEntity.strTroopFilePath, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, localFileManagerEntity.busId);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb : troopUin[" + localFileManagerEntity.TroopUin + "] troopFileId[" + localFileManagerEntity.strTroopFileID + "] troopFilePath[" + localFileManagerEntity.strTroopFilePath + "]");
      }
      if (!TextUtils.isEmpty(((apcy)localObject).ThumbnailFile_Large)) {
        break label263;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can not find local thumb file, download.");
      }
      localObject = TroopFileTransferManager.a(this.this$0.mAppInterface, localFileManagerEntity.TroopUin);
      if (localFileManagerEntity.strTroopFileID != null) {
        break label245;
      }
      ((TroopFileTransferManager)localObject).e(localFileManagerEntity.strTroopFilePath, parama.getFileName(), localFileManagerEntity.busId, 640);
    }
    for (;;)
    {
      this.this$0.a(parama, 4);
      return;
      label245:
      ((TroopFileTransferManager)localObject).a(UUID.fromString(localFileManagerEntity.strTroopFileID), 640);
      continue;
      label263:
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "downloadThumb :  can find local thumb file, refresh the picture browser.");
      }
      if (this.this$0.a != null) {
        this.this$0.a.fP(((apcy)localObject).FilePath, ((apcy)localObject).ThumbnailFile_Large);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvg
 * JD-Core Version:    0.7.0.1
 */