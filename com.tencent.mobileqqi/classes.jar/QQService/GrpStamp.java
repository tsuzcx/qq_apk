package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class GrpStamp
  extends JceStruct
{
  public long GrpArchStamp = 0L;
  public long GrpDataStamp = 0L;
  public long GrpId = 0L;
  
  static
  {
    if (!GrpStamp.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GrpStamp()
  {
    setGrpId(this.GrpId);
    setGrpArchStamp(this.GrpArchStamp);
    setGrpDataStamp(this.GrpDataStamp);
  }
  
  public GrpStamp(long paramLong1, long paramLong2, long paramLong3)
  {
    setGrpId(paramLong1);
    setGrpArchStamp(paramLong2);
    setGrpDataStamp(paramLong3);
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
    paramStringBuilder.display(this.GrpId, "GrpId");
    paramStringBuilder.display(this.GrpArchStamp, "GrpArchStamp");
    paramStringBuilder.display(this.GrpDataStamp, "GrpDataStamp");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (GrpStamp)paramObject;
    return (JceUtil.equals(this.GrpId, paramObject.GrpId)) && (JceUtil.equals(this.GrpArchStamp, paramObject.GrpArchStamp)) && (JceUtil.equals(this.GrpDataStamp, paramObject.GrpDataStamp));
  }
  
  public long getGrpArchStamp()
  {
    return this.GrpArchStamp;
  }
  
  public long getGrpDataStamp()
  {
    return this.GrpDataStamp;
  }
  
  public long getGrpId()
  {
    return this.GrpId;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setGrpId(paramJceInputStream.read(this.GrpId, 0, true));
    setGrpArchStamp(paramJceInputStream.read(this.GrpArchStamp, 1, true));
    setGrpDataStamp(paramJceInputStream.read(this.GrpDataStamp, 2, true));
  }
  
  public void setGrpArchStamp(long paramLong)
  {
    this.GrpArchStamp = paramLong;
  }
  
  public void setGrpDataStamp(long paramLong)
  {
    this.GrpDataStamp = paramLong;
  }
  
  public void setGrpId(long paramLong)
  {
    this.GrpId = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.GrpId, 0);
    paramJceOutputStream.write(this.GrpArchStamp, 1);
    paramJceOutputStream.write(this.GrpDataStamp, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.GrpStamp
 * JD-Core Version:    0.7.0.1
 */