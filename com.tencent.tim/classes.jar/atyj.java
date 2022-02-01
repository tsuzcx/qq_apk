import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;

public class atyj
  extends atyn
{
  private FileManagerEntity c;
  private WeiYunFileInfo d;
  private final QQAppInterface mApp;
  
  public atyj(QQAppInterface paramQQAppInterface, WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.mApp = paramQQAppInterface;
    this.d = paramWeiYunFileInfo;
  }
  
  private void E(FileManagerEntity paramFileManagerEntity)
  {
    this.c = paramFileManagerEntity;
  }
  
  public int DW()
  {
    return 0;
  }
  
  public void Ji(String paramString)
  {
    Jj(paramString);
  }
  
  public void Jj(String paramString)
  {
    if (this.c != null)
    {
      this.c.strThumbPath = paramString;
      return;
    }
    this.d.bIz = paramString;
  }
  
  public String aB()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.c != null)
    {
      localObject1 = localObject2;
      if (this.c.nFileType == 5)
      {
        localObject1 = localObject2;
        if (aueh.fileExistsAndNotEmpty(this.c.getFilePath())) {
          localObject1 = this.c.getFilePath();
        }
      }
    }
    return localObject1;
  }
  
  public String ay()
  {
    return null;
  }
  
  public FileManagerEntity b()
  {
    if (this.c != null) {
      return this.c;
    }
    Object localObject2 = this.mApp.a().f(this.d.bIk);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.mApp.a().c(this.d.bIk);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = audx.b(this.d);
    }
    if (localObject2 != null) {
      E((FileManagerEntity)localObject2);
    }
    return this.c;
  }
  
  public WeiYunFileInfo b()
  {
    return this.d;
  }
  
  public int bF()
  {
    if (this.c != null) {
      return this.c.status;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("WeiyunFileViewerAdapter", 4, "getFileStatus: has not status");
    }
    return -1;
  }
  
  public long fR()
  {
    if (this.c != null) {
      return this.c.nSessionId;
    }
    return -1L;
  }
  
  public long ga()
  {
    return anaz.gQ() * 1000L;
  }
  
  public int getCloudType()
  {
    int i;
    if (this.c != null) {
      i = this.c.getCloudType();
    }
    for (;;)
    {
      int j = i;
      if (2 == i)
      {
        j = i;
        if (aueh.fileExistsAndNotEmpty(getFilePath())) {
          j = 3;
        }
      }
      return j;
      FileManagerEntity localFileManagerEntity2 = this.mApp.a().f(this.d.bIk);
      FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
      if (localFileManagerEntity2 == null) {
        localFileManagerEntity1 = this.mApp.a().c(this.d.bIk);
      }
      if (localFileManagerEntity1 != null)
      {
        E(localFileManagerEntity1);
        i = localFileManagerEntity1.getCloudType();
      }
      else
      {
        i = 2;
      }
    }
  }
  
  public String getFileId()
  {
    return this.d.bIk;
  }
  
  public String getFileName()
  {
    return this.d.strFileName;
  }
  
  public String getFilePath()
  {
    String str = null;
    if (this.c != null) {
      str = this.c.getFilePath();
    }
    FileManagerEntity localFileManagerEntity1;
    do
    {
      return str;
      FileManagerEntity localFileManagerEntity2 = this.mApp.a().f(this.d.bIk);
      localFileManagerEntity1 = localFileManagerEntity2;
      if (localFileManagerEntity2 == null) {
        localFileManagerEntity1 = this.mApp.a().c(this.d.bIk);
      }
    } while (localFileManagerEntity1 == null);
    E(localFileManagerEntity1);
    return this.c.getFilePath();
  }
  
  public long getFileSize()
  {
    return this.d.nFileSize;
  }
  
  public int getFileType()
  {
    return audx.fM(this.d.strFileName);
  }
  
  public int getOpType()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("WeiyunFileViewerAdapter", 4, "getOpType: has not opType");
    }
    return -1;
  }
  
  public String getUuid()
  {
    return null;
  }
  
  public String vG()
  {
    if (this.c != null)
    {
      if (aueh.fileExistsAndNotEmpty(this.c.getFilePath())) {
        return this.c.getFilePath();
      }
      return this.c.strThumbPath;
    }
    FileManagerEntity localFileManagerEntity2 = this.mApp.a().f(this.d.bIk);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null) {
      localFileManagerEntity1 = this.mApp.a().c(this.d.bIk);
    }
    if (localFileManagerEntity1 != null)
    {
      E(localFileManagerEntity1);
      if (aueh.fileExistsAndNotEmpty(localFileManagerEntity1.getFilePath())) {
        return localFileManagerEntity1.getFilePath();
      }
      return localFileManagerEntity1.strThumbPath;
    }
    return this.d.bIz;
  }
  
  public String vH()
  {
    return aueh.g(getFileSize());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atyj
 * JD-Core Version:    0.7.0.1
 */