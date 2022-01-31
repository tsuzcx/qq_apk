package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SUI
  extends JceStruct
  implements Cloneable
{
  static ArrayList eR;
  static PluginInfo eS;
  public String desc = "";
  public int id = 0;
  public ArrayList ivalues = null;
  public String paramvalues = "";
  public PluginInfo pluginInfo = null;
  public int time = 0;
  
  static
  {
    if (!SUI.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SUI()
  {
    setId(this.id);
    setTime(this.time);
    setDesc(this.desc);
    setIvalues(this.ivalues);
    setParamvalues(this.paramvalues);
    setPluginInfo(this.pluginInfo);
  }
  
  public SUI(int paramInt1, int paramInt2, String paramString1, ArrayList paramArrayList, String paramString2, PluginInfo paramPluginInfo)
  {
    setId(paramInt1);
    setTime(paramInt2);
    setDesc(paramString1);
    setIvalues(paramArrayList);
    setParamvalues(paramString2);
    setPluginInfo(paramPluginInfo);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.SUI";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.id, "id");
    paramStringBuilder.display(this.time, "time");
    paramStringBuilder.display(this.desc, "desc");
    paramStringBuilder.display(this.ivalues, "ivalues");
    paramStringBuilder.display(this.paramvalues, "paramvalues");
    paramStringBuilder.display(this.pluginInfo, "pluginInfo");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (SUI)paramObject;
    } while ((!JceUtil.equals(this.id, paramObject.id)) || (!JceUtil.equals(this.time, paramObject.time)) || (!JceUtil.equals(this.desc, paramObject.desc)) || (!JceUtil.equals(this.ivalues, paramObject.ivalues)) || (!JceUtil.equals(this.paramvalues, paramObject.paramvalues)) || (!JceUtil.equals(this.pluginInfo, paramObject.pluginInfo)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.SUI";
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public ArrayList getIvalues()
  {
    return this.ivalues;
  }
  
  public String getParamvalues()
  {
    return this.paramvalues;
  }
  
  public PluginInfo getPluginInfo()
  {
    return this.pluginInfo;
  }
  
  public int getTime()
  {
    return this.time;
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
    setTime(paramJceInputStream.read(this.time, 1, true));
    setDesc(paramJceInputStream.readString(2, true));
    if (eR == null)
    {
      eR = new ArrayList();
      eR.add(Integer.valueOf(0));
    }
    setIvalues((ArrayList)paramJceInputStream.read(eR, 3, false));
    setParamvalues(paramJceInputStream.readString(4, false));
    if (eS == null) {
      eS = new PluginInfo();
    }
    setPluginInfo((PluginInfo)paramJceInputStream.read(eS, 5, false));
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setIvalues(ArrayList paramArrayList)
  {
    this.ivalues = paramArrayList;
  }
  
  public void setParamvalues(String paramString)
  {
    this.paramvalues = paramString;
  }
  
  public void setPluginInfo(PluginInfo paramPluginInfo)
  {
    this.pluginInfo = paramPluginInfo;
  }
  
  public void setTime(int paramInt)
  {
    this.time = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.time, 1);
    paramJceOutputStream.write(this.desc, 2);
    if (this.ivalues != null) {
      paramJceOutputStream.write(this.ivalues, 3);
    }
    if (this.paramvalues != null) {
      paramJceOutputStream.write(this.paramvalues, 4);
    }
    if (this.pluginInfo != null) {
      paramJceOutputStream.write(this.pluginInfo, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SUI
 * JD-Core Version:    0.7.0.1
 */