package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class uploadPacketInfoResp
  extends JceStruct
{
  public int is_succ = 0;
  
  static
  {
    if (!uploadPacketInfoResp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public uploadPacketInfoResp()
  {
    setIs_succ(this.is_succ);
  }
  
  public uploadPacketInfoResp(int paramInt)
  {
    setIs_succ(paramInt);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.uploadPacketInfoResp";
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
    paramObject = (uploadPacketInfoResp)paramObject;
    return JceUtil.equals(this.is_succ, paramObject.is_succ);
  }
  
  public int getIs_succ()
  {
    return this.is_succ;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setIs_succ(paramJceInputStream.read(this.is_succ, 0, true));
  }
  
  public void setIs_succ(int paramInt)
  {
    this.is_succ = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.is_succ, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.uploadPacketInfoResp
 * JD-Core Version:    0.7.0.1
 */