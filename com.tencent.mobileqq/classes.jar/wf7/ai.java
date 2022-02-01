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
  
  public ai()
  {
    d(this.cG);
    e(this.cH);
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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ai)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.cG, paramObject.cG))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.cH, paramObject.cH)) {
        bool1 = true;
      }
    }
    return bool1;
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