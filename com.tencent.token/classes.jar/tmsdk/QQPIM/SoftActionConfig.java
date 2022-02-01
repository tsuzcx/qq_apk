package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SoftActionConfig
  extends JceStruct
  implements Cloneable
{
  static FeatureKey dB;
  public int actionLevel = 0;
  public FeatureKey featureKey = null;
  
  public SoftActionConfig()
  {
    setFeatureKey(this.featureKey);
    setActionLevel(this.actionLevel);
  }
  
  public SoftActionConfig(FeatureKey paramFeatureKey, int paramInt)
  {
    setFeatureKey(paramFeatureKey);
    setActionLevel(paramInt);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.SoftActionConfig";
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
    paramObject = (SoftActionConfig)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.featureKey, paramObject.featureKey))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.actionLevel, paramObject.actionLevel)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.SoftActionConfig";
  }
  
  public int getActionLevel()
  {
    return this.actionLevel;
  }
  
  public FeatureKey getFeatureKey()
  {
    return this.featureKey;
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
    if (dB == null) {
      dB = new FeatureKey();
    }
    setFeatureKey((FeatureKey)paramJceInputStream.read(dB, 0, true));
    setActionLevel(paramJceInputStream.read(this.actionLevel, 1, false));
  }
  
  public void setActionLevel(int paramInt)
  {
    this.actionLevel = paramInt;
  }
  
  public void setFeatureKey(FeatureKey paramFeatureKey)
  {
    this.featureKey = paramFeatureKey;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.featureKey, 0);
    paramJceOutputStream.write(this.actionLevel, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SoftActionConfig
 * JD-Core Version:    0.7.0.1
 */