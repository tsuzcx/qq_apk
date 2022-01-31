package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class HotWordReqInfo
  extends JceStruct
  implements Cloneable
{
  public int index = 0;
  public int num = 0;
  public int version = 0;
  
  static
  {
    if (!HotWordReqInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public HotWordReqInfo()
  {
    setVersion(this.version);
    setIndex(this.index);
    setNum(this.num);
  }
  
  public HotWordReqInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    setVersion(paramInt1);
    setIndex(paramInt2);
    setNum(paramInt3);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.HotWordReqInfo";
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
      paramObject = (HotWordReqInfo)paramObject;
    } while ((!JceUtil.equals(this.version, paramObject.version)) || (!JceUtil.equals(this.index, paramObject.index)) || (!JceUtil.equals(this.num, paramObject.num)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.HotWordReqInfo";
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int getNum()
  {
    return this.num;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setVersion(paramJceInputStream.read(this.version, 0, true));
    setIndex(paramJceInputStream.read(this.index, 1, true));
    setNum(paramJceInputStream.read(this.num, 2, true));
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setNum(int paramInt)
  {
    this.num = paramInt;
  }
  
  public void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.version, 0);
    paramJceOutputStream.write(this.index, 1);
    paramJceOutputStream.write(this.num, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.HotWordReqInfo
 * JD-Core Version:    0.7.0.1
 */