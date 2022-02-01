package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class UploadFile
  extends JceStruct
  implements Cloneable
{
  public int pos = 0;
  public int size = 0;
  
  public UploadFile()
  {
    setPos(this.pos);
    setSize(this.size);
  }
  
  public UploadFile(int paramInt1, int paramInt2)
  {
    setPos(paramInt1);
    setSize(paramInt2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.UploadFile";
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
    paramObject = (UploadFile)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.pos, paramObject.pos))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.size, paramObject.size)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.UploadFile";
  }
  
  public int getPos()
  {
    return this.pos;
  }
  
  public int getSize()
  {
    return this.size;
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
    setPos(paramJceInputStream.read(this.pos, 0, true));
    setSize(paramJceInputStream.read(this.size, 1, true));
  }
  
  public void setPos(int paramInt)
  {
    this.pos = paramInt;
  }
  
  public void setSize(int paramInt)
  {
    this.size = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pos, 0);
    paramJceOutputStream.write(this.size, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.UploadFile
 * JD-Core Version:    0.7.0.1
 */