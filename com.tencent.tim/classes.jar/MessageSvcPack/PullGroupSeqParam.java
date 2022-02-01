package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class PullGroupSeqParam
  extends JceStruct
  implements Cloneable
{
  public long lGroupCode;
  public long lLastSeqId;
  
  static
  {
    if (!PullGroupSeqParam.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PullGroupSeqParam() {}
  
  public PullGroupSeqParam(long paramLong1, long paramLong2)
  {
    this.lGroupCode = paramLong1;
    this.lLastSeqId = paramLong2;
  }
  
  public String className()
  {
    return "MessageSvcPack.PullGroupSeqParam";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.lGroupCode, "lGroupCode");
    paramStringBuilder.display(this.lLastSeqId, "lLastSeqId");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.lGroupCode, true);
    paramStringBuilder.displaySimple(this.lLastSeqId, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (PullGroupSeqParam)paramObject;
    } while ((!JceUtil.equals(this.lGroupCode, paramObject.lGroupCode)) || (!JceUtil.equals(this.lLastSeqId, paramObject.lLastSeqId)));
    return true;
  }
  
  public String fullClassName()
  {
    return "MessageSvcPack.PullGroupSeqParam";
  }
  
  public long getLGroupCode()
  {
    return this.lGroupCode;
  }
  
  public long getLLastSeqId()
  {
    return this.lLastSeqId;
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
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 0, true);
    this.lLastSeqId = paramJceInputStream.read(this.lLastSeqId, 1, true);
  }
  
  public void setLGroupCode(long paramLong)
  {
    this.lGroupCode = paramLong;
  }
  
  public void setLLastSeqId(long paramLong)
  {
    this.lLastSeqId = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lGroupCode, 0);
    paramJceOutputStream.write(this.lLastSeqId, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MessageSvcPack.PullGroupSeqParam
 * JD-Core Version:    0.7.0.1
 */