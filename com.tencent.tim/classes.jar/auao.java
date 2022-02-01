import com.tencent.cloudfile.CloudFile;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class auao
  implements atyz
{
  auao(auaj paramauaj) {}
  
  public void iE()
  {
    FileManagerEntity localFileManagerEntity = this.this$0.c.b();
    audk localaudk = null;
    if (localFileManagerEntity != null) {
      localaudk = audk.a(localFileManagerEntity);
    }
    this.this$0.a(false, localaudk, this.this$0.getFileSize(), new auap(this));
  }
  
  public void iF()
  {
    FileManagerEntity localFileManagerEntity = this.this$0.c.b();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (auaj.a(this.this$0) != null)
    {
      this.this$0.iA();
      if (this.this$0.bG() == 0)
      {
        localQQAppInterface.a().js(auaj.a(this.this$0).nSessionId);
        return;
      }
      localQQAppInterface.a().bZ(auaj.a(this.this$0).nSessionId);
      localFileManagerEntity.status = 3;
      return;
    }
    CloudFile localCloudFile = localFileManagerEntity.cloudFile;
    if (localCloudFile != null) {
      atgi.a().stopDownloadFile(localCloudFile.pLogicDirKey, localCloudFile.cloudId, 3);
    }
    localQQAppInterface.a().bZ(localFileManagerEntity.nSessionId);
    localFileManagerEntity.status = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auao
 * JD-Core Version:    0.7.0.1
 */