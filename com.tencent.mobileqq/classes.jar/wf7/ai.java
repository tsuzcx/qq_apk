package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ai
  extends JceStruct
  implements Cloneable
{
  public int cG = 0;
  public int cH = 0;
  
  static
  {
    if (!ai.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      cF = bool;
      return;
    }
  }
  
  public ai()
  {
    d(this.cG);
    e(this.cH);
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
      while (cF) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void d(int paramInt)
  {
    this.cG = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.cH = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ai)paramObject;
    } while ((!JceUtil.equals(this.cG, paramObject.cG)) || (!JceUtil.equals(this.cH, paramObject.cH)));
    return true;
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
    d(paramJceInputStream.read(this.cG, 0, true));
    e(paramJceInputStream.read(this.cH, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cG, 0);
    paramJceOutputStream.write(this.cH, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ai
 * JD-Core Version:    0.7.0.1
 */