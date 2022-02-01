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
  
  public aj()
  {
    f(this.cI);
    g(this.cJ);
    h(this.cK);
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
    if (cF) {
      return null;
    }
    throw new AssertionError();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (aj)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.cI, paramObject.cI))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.cJ, paramObject.cJ))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.cK, paramObject.cK)) {
          bool1 = true;
        }
      }
    }
    return bool1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.aj
 * JD-Core Version:    0.7.0.1
 */