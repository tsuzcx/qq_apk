package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class CloudCmdRes
  extends JceStruct
  implements Cloneable
{
  public int res = 0;
  public int seqid = 0;
  
  public CloudCmdRes()
  {
    setSeqid(this.seqid);
    setRes(this.res);
  }
  
  public CloudCmdRes(int paramInt1, int paramInt2)
  {
    setSeqid(paramInt1);
    setRes(paramInt2);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.CloudCmdRes";
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
    paramObject = (CloudCmdRes)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.seqid, paramObject.seqid))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.res, paramObject.res)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.CloudCmdRes";
  }
  
  public int getRes()
  {
    return this.res;
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
    setSeqid(paramJceInputStream.read(this.seqid, 1, true));
    setRes(paramJceInputStream.read(this.res, 2, true));
  }
  
  public void setRes(int paramInt)
  {
    this.res = paramInt;
  }
  
  public void setSeqid(int paramInt)
  {
    this.seqid = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.seqid, 1);
    paramJceOutputStream.write(this.res, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CloudCmdRes
 * JD-Core Version:    0.7.0.1
 */