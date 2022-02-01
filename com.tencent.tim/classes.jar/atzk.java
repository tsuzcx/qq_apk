import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class atzk
  implements atzb
{
  atzk(atzf paramatzf) {}
  
  public void djp()
  {
    FileManagerEntity localFileManagerEntity = this.a.c.b();
    audk localaudk = null;
    if (localFileManagerEntity != null) {
      localaudk = audk.a(localFileManagerEntity);
    }
    this.a.a(true, localaudk, this.a.getFileSize(), new atzl(this));
  }
  
  public void djq()
  {
    this.a.iA();
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().bZ(this.a.V());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzk
 * JD-Core Version:    0.7.0.1
 */