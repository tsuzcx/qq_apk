package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stDirInfo
  extends JceStruct
  implements Cloneable
{
  public String name = "";
  
  public stDirInfo() {}
  
  public stDirInfo(String paramString)
  {
    this.name = paramString;
  }
  
  public String className()
  {
    return "MConfigUpdate.stDirInfo";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).display(this.name, "name");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (stDirInfo)paramObject;
    return JceUtil.equals(this.name, paramObject.name);
  }
  
  public String fullClassName()
  {
    return "MConfigUpdate.stDirInfo";
  }
  
  public String getName()
  {
    return this.name;
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
    this.name = paramJceInputStream.readString(0, true);
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.name, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.stDirInfo
 * JD-Core Version:    0.7.0.1
 */