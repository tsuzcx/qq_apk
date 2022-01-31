package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RocketConf
  extends JceStruct
  implements Cloneable
{
  public String bestwording = "";
  public String freewording = "";
  public String imageurl = "";
  public int orbit = 0;
  public String pullwording = "";
  
  static
  {
    if (!RocketConf.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RocketConf() {}
  
  public RocketConf(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.orbit = paramInt;
    this.imageurl = paramString1;
    this.pullwording = paramString2;
    this.freewording = paramString3;
    this.bestwording = paramString4;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.RocketConf";
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
      paramObject = (RocketConf)paramObject;
    } while ((!JceUtil.equals(this.orbit, paramObject.orbit)) || (!JceUtil.equals(this.imageurl, paramObject.imageurl)) || (!JceUtil.equals(this.pullwording, paramObject.pullwording)) || (!JceUtil.equals(this.freewording, paramObject.freewording)) || (!JceUtil.equals(this.bestwording, paramObject.bestwording)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.RocketConf";
  }
  
  public String getBestwording()
  {
    return this.bestwording;
  }
  
  public String getFreewording()
  {
    return this.freewording;
  }
  
  public String getImageurl()
  {
    return this.imageurl;
  }
  
  public int getOrbit()
  {
    return this.orbit;
  }
  
  public String getPullwording()
  {
    return this.pullwording;
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
    this.orbit = paramJceInputStream.read(this.orbit, 0, true);
    this.imageurl = paramJceInputStream.readString(1, true);
    this.pullwording = paramJceInputStream.readString(2, true);
    this.freewording = paramJceInputStream.readString(3, true);
    this.bestwording = paramJceInputStream.readString(4, true);
  }
  
  public void setBestwording(String paramString)
  {
    this.bestwording = paramString;
  }
  
  public void setFreewording(String paramString)
  {
    this.freewording = paramString;
  }
  
  public void setImageurl(String paramString)
  {
    this.imageurl = paramString;
  }
  
  public void setOrbit(int paramInt)
  {
    this.orbit = paramInt;
  }
  
  public void setPullwording(String paramString)
  {
    this.pullwording = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.orbit, 0);
    paramJceOutputStream.write(this.imageurl, 1);
    paramJceOutputStream.write(this.pullwording, 2);
    paramJceOutputStream.write(this.freewording, 3);
    paramJceOutputStream.write(this.bestwording, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.RocketConf
 * JD-Core Version:    0.7.0.1
 */