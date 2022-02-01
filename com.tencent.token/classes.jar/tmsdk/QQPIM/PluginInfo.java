package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class PluginInfo
  extends JceStruct
  implements Cloneable
{
  public int hostId = 0;
  public int pluginId = 0;
  public int pluginVersion = 0;
  
  public PluginInfo()
  {
    setHostId(this.hostId);
    setPluginId(this.pluginId);
    setPluginVersion(this.pluginVersion);
  }
  
  public PluginInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    setHostId(paramInt1);
    setPluginId(paramInt2);
    setPluginVersion(paramInt3);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.PluginInfo";
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
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.hostId, "hostId");
    paramStringBuilder.display(this.pluginId, "pluginId");
    paramStringBuilder.display(this.pluginVersion, "pluginVersion");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (PluginInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.hostId, paramObject.hostId))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.pluginId, paramObject.pluginId))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.pluginVersion, paramObject.pluginVersion)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.com.com.qq.QQPIM.PluginInfo";
  }
  
  public int getHostId()
  {
    return this.hostId;
  }
  
  public int getPluginId()
  {
    return this.pluginId;
  }
  
  public int getPluginVersion()
  {
    return this.pluginVersion;
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
    setHostId(paramJceInputStream.read(this.hostId, 0, false));
    setPluginId(paramJceInputStream.read(this.pluginId, 1, false));
    setPluginVersion(paramJceInputStream.read(this.pluginVersion, 2, false));
  }
  
  public void setHostId(int paramInt)
  {
    this.hostId = paramInt;
  }
  
  public void setPluginId(int paramInt)
  {
    this.pluginId = paramInt;
  }
  
  public void setPluginVersion(int paramInt)
  {
    this.pluginVersion = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hostId, 0);
    paramJceOutputStream.write(this.pluginId, 1);
    paramJceOutputStream.write(this.pluginVersion, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.PluginInfo
 * JD-Core Version:    0.7.0.1
 */