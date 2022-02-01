package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public final class SUI
  extends JceStruct
  implements Cloneable
{
  static ArrayList<Integer> eR;
  static PluginInfo eS;
  public String desc = "";
  public int id = 0;
  public ArrayList<Integer> ivalues = null;
  public String paramvalues = "";
  public PluginInfo pluginInfo = null;
  public int time = 0;
  
  public SUI()
  {
    setId(this.id);
    setTime(this.time);
    setDesc(this.desc);
    setIvalues(this.ivalues);
    setParamvalues(this.paramvalues);
    setPluginInfo(this.pluginInfo);
  }
  
  public SUI(int paramInt1, int paramInt2, String paramString1, ArrayList<Integer> paramArrayList, String paramString2, PluginInfo paramPluginInfo)
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
    paramStringBuilder.display(this.id, "id");
    paramStringBuilder.display(this.time, "time");
    paramStringBuilder.display(this.desc, "desc");
    paramStringBuilder.display(this.ivalues, "ivalues");
    paramStringBuilder.display(this.paramvalues, "paramvalues");
    paramStringBuilder.display(this.pluginInfo, "pluginInfo");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SUI)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.id, paramObject.id))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.time, paramObject.time))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.desc, paramObject.desc))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.ivalues, paramObject.ivalues))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.paramvalues, paramObject.paramvalues))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.pluginInfo, paramObject.pluginInfo)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
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
  
  public ArrayList<Integer> getIvalues()
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
  
  public void setIvalues(ArrayList<Integer> paramArrayList)
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
    Object localObject = this.ivalues;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.paramvalues;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.pluginInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SUI
 * JD-Core Version:    0.7.0.1
 */