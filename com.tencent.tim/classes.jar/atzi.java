import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class atzi
  implements atyz
{
  atzi(atzf paramatzf) {}
  
  public void iE()
  {
    FileManagerEntity localFileManagerEntity = this.a.c.b();
    audk localaudk = null;
    if (localFileManagerEntity != null) {
      localaudk = audk.a(localFileManagerEntity);
    }
    this.a.a(false, localaudk, this.a.getFileSize(), new atzj(this));
  }
  
  public void iF()
  {
    this.a.iA();
    int i = this.a.bG();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (i == 0)
    {
      localQQAppInterface.a().js(this.a.V());
      return;
    }
    localQQAppInterface.a().bZ(this.a.c.fR());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzi
 * JD-Core Version:    0.7.0.1
 */