package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ClassifyFeature
  extends JceStruct
  implements Cloneable
{
  public long featMd5 = 0L;
  public String featValue = "";
  public int state = 0;
  public float weight = 0.0F;
  
  static
  {
    if (!ClassifyFeature.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ClassifyFeature() {}
  
  public ClassifyFeature(long paramLong, float paramFloat, String paramString, int paramInt)
  {
    this.featMd5 = paramLong;
    this.weight = paramFloat;
    this.featValue = paramString;
    this.state = paramInt;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ClassifyFeature";
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
      paramObject = (ClassifyFeature)paramObject;
    } while ((!JceUtil.equals(this.featMd5, paramObject.featMd5)) || (!JceUtil.equals(this.weight, paramObject.weight)) || (!JceUtil.equals(this.featValue, paramObject.featValue)) || (!JceUtil.equals(this.state, paramObject.state)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.ClassifyFeature";
  }
  
  public long getFeatMd5()
  {
    return this.featMd5;
  }
  
  public String getFeatValue()
  {
    return this.featValue;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public float getWeight()
  {
    return this.weight;
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
    this.featMd5 = paramJceInputStream.read(this.featMd5, 0, true);
    this.weight = paramJceInputStream.read(this.weight, 1, true);
    this.featValue = paramJceInputStream.readString(2, true);
    this.state = paramJceInputStream.read(this.state, 3, false);
  }
  
  public void setFeatMd5(long paramLong)
  {
    this.featMd5 = paramLong;
  }
  
  public void setFeatValue(String paramString)
  {
    this.featValue = paramString;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public void setWeight(float paramFloat)
  {
    this.weight = paramFloat;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.featMd5, 0);
    paramJceOutputStream.write(this.weight, 1);
    paramJceOutputStream.write(this.featValue, 2);
    paramJceOutputStream.write(this.state, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ClassifyFeature
 * JD-Core Version:    0.7.0.1
 */