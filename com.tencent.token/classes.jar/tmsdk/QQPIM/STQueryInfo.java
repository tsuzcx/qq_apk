package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class STQueryInfo
  extends JceStruct
  implements Cloneable
{
  public int nQuerytype = 0;
  public String strCode = "";
  public String strPort = "";
  
  static
  {
    if (!STQueryInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public STQueryInfo()
  {
    setNQuerytype(this.nQuerytype);
    setStrPort(this.strPort);
    setStrCode(this.strCode);
  }
  
  public STQueryInfo(int paramInt, String paramString1, String paramString2)
  {
    setNQuerytype(paramInt);
    setStrPort(paramString1);
    setStrCode(paramString2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.STQueryInfo";
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
      paramObject = (STQueryInfo)paramObject;
    } while ((!JceUtil.equals(this.nQuerytype, paramObject.nQuerytype)) || (!JceUtil.equals(this.strPort, paramObject.strPort)) || (!JceUtil.equals(this.strCode, paramObject.strCode)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.STQueryInfo";
  }
  
  public int getNQuerytype()
  {
    return this.nQuerytype;
  }
  
  public String getStrCode()
  {
    return this.strCode;
  }
  
  public String getStrPort()
  {
    return this.strPort;
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
    setNQuerytype(paramJceInputStream.read(this.nQuerytype, 0, true));
    setStrPort(paramJceInputStream.readString(1, true));
    setStrCode(paramJceInputStream.readString(2, true));
  }
  
  public void setNQuerytype(int paramInt)
  {
    this.nQuerytype = paramInt;
  }
  
  public void setStrCode(String paramString)
  {
    this.strCode = paramString;
  }
  
  public void setStrPort(String paramString)
  {
    this.strPort = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nQuerytype, 0);
    paramJceOutputStream.write(this.strPort, 1);
    paramJceOutputStream.write(this.strCode, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.STQueryInfo
 * JD-Core Version:    0.7.0.1
 */