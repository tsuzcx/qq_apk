package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class aj
  extends JceStruct
  implements Cloneable
{
  public int cI = 0;
  public int cJ = 0;
  public int cK = 0;
  
  static
  {
    if (!aj.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      cF = bool;
      return;
    }
  }
  
  public aj()
  {
    f(this.cI);
    g(this.cJ);
    h(this.cK);
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
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (aj)paramObject;
    } while ((!JceUtil.equals(this.cI, paramObject.cI)) || (!JceUtil.equals(this.cJ, paramObject.cJ)) || (!JceUtil.equals(this.cK, paramObject.cK)));
    return true;
  }
  
  public void f(int paramInt)
  {
    this.cI = paramInt;
  }
  
  public void g(int paramInt)
  {
    this.cJ = paramInt;
  }
  
  public void h(int paramInt)
  {
    this.cK = paramInt;
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
    f(paramJceInputStream.read(this.cI, 1, true));
    g(paramJceInputStream.read(this.cJ, 2, true));
    h(paramJceInputStream.read(this.cK, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cI, 1);
    paramJceOutputStream.write(this.cJ, 2);
    paramJceOutputStream.write(this.cK, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.aj
 * JD-Core Version:    0.7.0.1
 */