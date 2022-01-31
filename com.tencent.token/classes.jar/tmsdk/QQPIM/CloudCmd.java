package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class CloudCmd
  extends JceStruct
  implements Cloneable
{
  static byte[] dQ;
  public int cmdid = 0;
  public byte[] param = null;
  public int seqid = 0;
  
  static
  {
    if (!CloudCmd.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public CloudCmd()
  {
    setCmdid(this.cmdid);
    setParam(this.param);
    setSeqid(this.seqid);
  }
  
  public CloudCmd(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    setCmdid(paramInt1);
    setParam(paramArrayOfByte);
    setSeqid(paramInt2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.CloudCmd";
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
      paramObject = (CloudCmd)paramObject;
    } while ((!JceUtil.equals(this.cmdid, paramObject.cmdid)) || (!JceUtil.equals(this.param, paramObject.param)) || (!JceUtil.equals(this.seqid, paramObject.seqid)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.CloudCmd";
  }
  
  public int getCmdid()
  {
    return this.cmdid;
  }
  
  public byte[] getParam()
  {
    return this.param;
  }
  
  public int getSeqid()
  {
    return this.seqid;
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
    setCmdid(paramJceInputStream.read(this.cmdid, 0, true));
    if (dQ == null)
    {
      dQ = (byte[])new byte[1];
      ((byte[])dQ)[0] = 0;
    }
    setParam((byte[])paramJceInputStream.read(dQ, 1, true));
    setSeqid(paramJceInputStream.read(this.seqid, 2, true));
  }
  
  public void setCmdid(int paramInt)
  {
    this.cmdid = paramInt;
  }
  
  public void setParam(byte[] paramArrayOfByte)
  {
    this.param = paramArrayOfByte;
  }
  
  public void setSeqid(int paramInt)
  {
    this.seqid = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmdid, 0);
    paramJceOutputStream.write(this.param, 1);
    paramJceOutputStream.write(this.seqid, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CloudCmd
 * JD-Core Version:    0.7.0.1
 */