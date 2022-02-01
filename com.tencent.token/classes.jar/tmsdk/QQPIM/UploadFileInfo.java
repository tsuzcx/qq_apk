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
  
  static
  {
    if (!UploadFileInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
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
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (UploadFileInfo)paramObject;
    } while ((!JceUtil.equals(this.id, paramObject.id)) || (!JceUtil.equals(this.vecUploadFile, paramObject.vecUploadFile)));
    return true;
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
    }
    catch (Exception localException) {}
    return 0;
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