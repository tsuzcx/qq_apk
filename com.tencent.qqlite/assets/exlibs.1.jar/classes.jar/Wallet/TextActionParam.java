package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class TextActionParam
  extends JceStruct
  implements Cloneable
{
  public short nextInterval = 0;
  public short reversalPlayNum = 0;
  public short reversalRunTime = 0;
  public short reversalStopTime = 0;
  public short rollPlayNum = 0;
  public short rollRunTime = 0;
  public short rollStopTime = 0;
  public short startInterval = 0;
  
  static
  {
    if (!TextActionParam.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "Wallet.TextActionParam";
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
      paramObject = (TextActionParam)paramObject;
    } while ((!JceUtil.equals(this.rollRunTime, paramObject.rollRunTime)) || (!JceUtil.equals(this.rollStopTime, paramObject.rollStopTime)) || (!JceUtil.equals(this.rollPlayNum, paramObject.rollPlayNum)) || (!JceUtil.equals(this.reversalRunTime, paramObject.reversalRunTime)) || (!JceUtil.equals(this.reversalStopTime, paramObject.reversalStopTime)) || (!JceUtil.equals(this.reversalPlayNum, paramObject.reversalPlayNum)) || (!JceUtil.equals(this.nextInterval, paramObject.nextInterval)) || (!JceUtil.equals(this.startInterval, paramObject.startInterval)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.TextActionParam";
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
    this.rollRunTime = paramJceInputStream.read(this.rollRunTime, 0, false);
    this.rollStopTime = paramJceInputStream.read(this.rollStopTime, 1, false);
    this.rollPlayNum = paramJceInputStream.read(this.rollPlayNum, 2, false);
    this.reversalRunTime = paramJceInputStream.read(this.reversalRunTime, 3, false);
    this.reversalStopTime = paramJceInputStream.read(this.reversalStopTime, 4, false);
    this.reversalPlayNum = paramJceInputStream.read(this.reversalPlayNum, 5, false);
    this.nextInterval = paramJceInputStream.read(this.nextInterval, 6, false);
    this.startInterval = paramJceInputStream.read(this.startInterval, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rollRunTime, 0);
    paramJceOutputStream.write(this.rollStopTime, 1);
    paramJceOutputStream.write(this.rollPlayNum, 2);
    paramJceOutputStream.write(this.reversalRunTime, 3);
    paramJceOutputStream.write(this.reversalStopTime, 4);
    paramJceOutputStream.write(this.reversalPlayNum, 5);
    paramJceOutputStream.write(this.nextInterval, 6);
    paramJceOutputStream.write(this.startInterval, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.TextActionParam
 * JD-Core Version:    0.7.0.1
 */