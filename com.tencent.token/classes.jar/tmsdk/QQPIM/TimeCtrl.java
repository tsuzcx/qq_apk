package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class TimeCtrl
  extends JceStruct
  implements Cloneable
{
  public boolean bEngross = true;
  public int exectime = 0;
  public int time = 0;
  public int validEndTime = 0;
  
  static
  {
    if (!TimeCtrl.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public TimeCtrl()
  {
    setTime(this.time);
    setBEngross(this.bEngross);
    setValidEndTime(this.validEndTime);
    setExectime(this.exectime);
  }
  
  public TimeCtrl(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    setTime(paramInt1);
    setBEngross(paramBoolean);
    setValidEndTime(paramInt2);
    setExectime(paramInt3);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.TimeCtrl";
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
      paramObject = (TimeCtrl)paramObject;
    } while ((!JceUtil.equals(this.time, paramObject.time)) || (!JceUtil.equals(this.bEngross, paramObject.bEngross)) || (!JceUtil.equals(this.validEndTime, paramObject.validEndTime)) || (!JceUtil.equals(this.exectime, paramObject.exectime)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.TimeCtrl";
  }
  
  public boolean getBEngross()
  {
    return this.bEngross;
  }
  
  public int getExectime()
  {
    return this.exectime;
  }
  
  public int getTime()
  {
    return this.time;
  }
  
  public int getValidEndTime()
  {
    return this.validEndTime;
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
    setTime(paramJceInputStream.read(this.time, 0, true));
    setBEngross(paramJceInputStream.read(this.bEngross, 1, true));
    setValidEndTime(paramJceInputStream.read(this.validEndTime, 2, false));
    setExectime(paramJceInputStream.read(this.exectime, 3, false));
  }
  
  public void setBEngross(boolean paramBoolean)
  {
    this.bEngross = paramBoolean;
  }
  
  public void setExectime(int paramInt)
  {
    this.exectime = paramInt;
  }
  
  public void setTime(int paramInt)
  {
    this.time = paramInt;
  }
  
  public void setValidEndTime(int paramInt)
  {
    this.validEndTime = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.time, 0);
    paramJceOutputStream.write(this.bEngross, 1);
    paramJceOutputStream.write(this.validEndTime, 2);
    paramJceOutputStream.write(this.exectime, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.TimeCtrl
 * JD-Core Version:    0.7.0.1
 */