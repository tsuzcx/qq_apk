import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class agrp
  extends agrw
{
  protected long aaa;
  private FileManagerEntity c;
  protected boolean ceX;
  protected boolean ceY;
  private final QQAppInterface mApp;
  
  public agrp(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.mApp = paramQQAppInterface;
    this.c = paramFileManagerEntity;
    if ((1 == getCloudType()) || (2 == getCloudType())) {
      this.ceX = ahav.b(this.mApp.getApplication().getBaseContext(), paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize);
    }
    this.aaa = 3145728L;
    if (3 == getCloudType())
    {
      bool1 = bool2;
      if (ahav.b(this)) {}
    }
    else
    {
      if ((6 != getCloudType()) || (bF() != 1) || (!aqhq.fileExistsAndNotEmpty(getFilePath()))) {
        break label119;
      }
    }
    label119:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.ceY = bool1;
      return;
    }
  }
  
  public int DW()
  {
    return this.c.peerType;
  }
  
  public void Ji(String paramString)
  {
    this.c.strLargeThumPath = paramString;
  }
  
  public String aB()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.c.nFileType == 5)
    {
      localObject1 = localObject2;
      if (ahbj.fileExistsAndNotEmpty(this.c.getFilePath())) {
        localObject1 = this.c.getFilePath();
      }
    }
    return localObject1;
  }
  
  public String ay()
  {
    return this.c.peerUin;
  }
  
  public FileManagerEntity b()
  {
    return this.c;
  }
  
  public WeiYunFileInfo b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("EntityFileViewerAdapter", 4, "getWeiyunInfo should not be called on EntityFileViewAdapter");
    }
    return null;
  }
  
  public int bF()
  {
    if ((this.c.isZipInnerFile) && (ahbj.fileExistsAndNotEmpty(this.c.getFilePath()))) {
      this.c.status = 1;
    }
    return this.c.status;
  }
  
  public long fR()
  {
    return this.c.nSessionId;
  }
  
  public long ga()
  {
    return this.c.srvTime;
  }
  
  public int getCloudType()
  {
    int j = this.c.getCloudType();
    int i;
    if (2 != j)
    {
      i = j;
      if (5 != j) {}
    }
    else
    {
      i = j;
      if (ahbj.fileExistsAndNotEmpty(getFilePath())) {
        i = 3;
      }
    }
    return i;
  }
  
  public String getFileId()
  {
    return this.c.WeiYunFileId;
  }
  
  public String getFileName()
  {
    return this.c.fileName;
  }
  
  public String getFilePath()
  {
    return this.c.getFilePath();
  }
  
  public long getFileSize()
  {
    return this.c.fileSize;
  }
  
  public int getFileType()
  {
    return this.c.nFileType;
  }
  
  public int getOpType()
  {
    return this.c.nOpType;
  }
  
  public String getUuid()
  {
    return this.c.Uuid;
  }
  
  public String vF()
  {
    if (ahbj.fileExistsAndNotEmpty(this.c.getFilePath())) {
      return this.c.getFilePath();
    }
    return this.c.strLargeThumPath;
  }
  
  public String vG()
  {
    if (ahbj.fileExistsAndNotEmpty(this.c.getFilePath())) {
      return this.c.getFilePath();
    }
    return this.c.strThumbPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrp
 * JD-Core Version:    0.7.0.1
 */