import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

final class atqx
  implements ahal.a
{
  atqx(String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, agsa paramagsa) {}
  
  public void aD()
  {
    Object localObject = audx.kW(this.val$fileName);
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FileViewerFacade", 2, "file maybe resoved ,recreateFilePath[" + this.val$fileName + "]");
    }
    aqhq.rename(this.bGT, (String)localObject);
    this.b.fileName = audx.getFileName((String)localObject);
    this.b.setFilePath((String)localObject);
    this.b.nFileType = audx.fM(this.b.getFilePath());
    this.val$app.a().u(this.b);
    FileManagerEntity localFileManagerEntity = this.val$app.a().a(this.bGT);
    if (localFileManagerEntity != null)
    {
      localFileManagerEntity.setFilePath((String)localObject);
      localFileManagerEntity.fileName = this.b.fileName;
      this.val$app.a().u(localFileManagerEntity);
      localObject = TroopFileTransferManager.a(this.val$app, localFileManagerEntity.TroopUin);
      if (localObject != null) {
        ((TroopFileTransferManager)localObject).renameFile(localFileManagerEntity.strTroopFileID, this.b.fileName);
      }
    }
    audx.a(this.val$activity, this.b.getFilePath(), null);
    if (this.a != null) {
      this.a.ir();
    }
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqx
 * JD-Core Version:    0.7.0.1
 */