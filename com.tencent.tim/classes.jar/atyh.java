import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;

public class atyh
  extends atyn
{
  private FileInfo e;
  
  public atyh(FileInfo paramFileInfo)
  {
    this.e = paramFileInfo;
  }
  
  public int DW()
  {
    return 0;
  }
  
  public void Ji(String paramString) {}
  
  public String aB()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.e.getType() == 5)
    {
      localObject1 = localObject2;
      if (aueh.fileExistsAndNotEmpty(this.e.getPath())) {
        localObject1 = this.e.getPath();
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
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getEntity should not be called on LocalFileViewAdapter");
    }
    return null;
  }
  
  public WeiYunFileInfo b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getWeiyunInfo should not be called on LocalFileViewAdapter");
    }
    return null;
  }
  
  public int bF()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getFileStatus: has not status");
    }
    return -1;
  }
  
  public long fR()
  {
    return -1L;
  }
  
  public long ga()
  {
    return anaz.gQ() * 1000L;
  }
  
  public int getCloudType()
  {
    return 3;
  }
  
  public String getFileId()
  {
    return null;
  }
  
  public String getFileName()
  {
    return this.e.getName();
  }
  
  public String getFilePath()
  {
    return this.e.getPath();
  }
  
  public long getFileSize()
  {
    return this.e.getSize();
  }
  
  public int getFileType()
  {
    if (this.e.getType() == 5) {
      return 5;
    }
    return audx.fM(this.e.getName());
  }
  
  public int getOpType()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("LocalFileViewerAdapter", 4, "getOpType: has not opType");
    }
    return -1;
  }
  
  public String getUuid()
  {
    return null;
  }
  
  public String vG()
  {
    return this.e.getPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atyh
 * JD-Core Version:    0.7.0.1
 */