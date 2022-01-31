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
  
  static
  {
    if (!UploadFile.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
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
      paramObject = (UploadFile)paramObject;
    } while ((!JceUtil.equals(this.pos, paramObject.pos)) || (!JceUtil.equals(this.size, paramObject.size)));
    return true;
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
    }
    catch (Exception localException) {}
    return 0;
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