package cooperation.qlink;

import java.io.Serializable;

public class QLAndQQStructDef$FileInfo
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  public float fProgress;
  public String fileMd5;
  public String fileName;
  public String filePath;
  public long fileSessionId;
  public long fileSize;
  public int fileTimeout;
  public String thumPath;
  public String thumbMd5;
  public String thumbUrl;
  public String url;
  
  public FileInfo clone()
  {
    try
    {
      FileInfo localFileInfo = (FileInfo)super.clone();
      return localFileInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QLAndQQStructDef.FileInfo
 * JD-Core Version:    0.7.0.1
 */