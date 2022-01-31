package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class VirusFeature
  extends JceStruct
  implements Cloneable
{
  public String content = "";
  public short id = 0;
  
  static
  {
    if (!VirusFeature.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public VirusFeature()
  {
    setId(this.id);
    setContent(this.content);
  }
  
  public VirusFeature(short paramShort, String paramString)
  {
    setId(paramShort);
    setContent(paramString);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.VirusFeature";
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
      paramObject = (VirusFeature)paramObject;
    } while ((!JceUtil.equals(this.id, paramObject.id)) || (!JceUtil.equals(this.content, paramObject.content)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.VirusFeature";
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public short getId()
  {
    return this.id;
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
    setId(paramJceInputStream.read(this.id, 0, true));
    setContent(paramJceInputStream.readString(1, true));
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setId(short paramShort)
  {
    this.id = paramShort;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.content, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.VirusFeature
 * JD-Core Version:    0.7.0.1
 */