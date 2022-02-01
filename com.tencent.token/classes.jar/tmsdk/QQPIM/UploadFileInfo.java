package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class UploadFileInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList<UploadFile> fg;
  public String id = "";
  public ArrayList<UploadFile> vecUploadFile = null;
  
  public UploadFileInfo()
  {
    setId(this.id);
    setVecUploadFile(this.vecUploadFile);
  }
  
  public UploadFileInfo(String paramString, ArrayList<UploadFile> paramArrayList)
  {
    setId(paramString);
    setVecUploadFile(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.UploadFileInfo";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (UploadFileInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.id, paramObject.id))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.vecUploadFile, paramObject.vecUploadFile)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.UploadFileInfo";
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public ArrayList<UploadFile> getVecUploadFile()
  {
    return this.vecUploadFile;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
      label10:
      return 0;
    }
    catch (Exception localException)
    {
      break label10;
    }
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setId(paramJceInputStream.readString(0, true));
    if (fg == null)
    {
      fg = new ArrayList();
      UploadFile localUploadFile = new UploadFile();
      fg.add(localUploadFile);
    }
    setVecUploadFile((ArrayList)paramJceInputStream.read(fg, 1, true));
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setVecUploadFile(ArrayList<UploadFile> paramArrayList)
  {
    this.vecUploadFile = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.vecUploadFile, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.UploadFileInfo
 * JD-Core Version:    0.7.0.1
 */