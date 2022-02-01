package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ShortcutConf
  extends JceStruct
  implements Cloneable
{
  public int height = 0;
  public int threshold = 0;
  
  public ShortcutConf() {}
  
  public ShortcutConf(int paramInt1, int paramInt2)
  {
    this.height = paramInt1;
    this.threshold = paramInt2;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ShortcutConf";
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
    paramObject = (ShortcutConf)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.height, paramObject.height))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.threshold, paramObject.threshold)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ShortcutConf";
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getThreshold()
  {
    return this.threshold;
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
    this.height = paramJceInputStream.read(this.height, 0, true);
    this.threshold = paramJceInputStream.read(this.threshold, 1, true);
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setThreshold(int paramInt)
  {
    this.threshold = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.height, 0);
    paramJceOutputStream.write(this.threshold, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ShortcutConf
 * JD-Core Version:    0.7.0.1
 */