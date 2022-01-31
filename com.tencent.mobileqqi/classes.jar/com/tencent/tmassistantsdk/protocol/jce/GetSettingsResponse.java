package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class GetSettingsResponse
  extends JceStruct
  implements Cloneable
{
  private static ArrayList cache_settings;
  public int ret = 0;
  public ArrayList settings = null;
  
  static
  {
    if (!GetSettingsResponse.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GetSettingsResponse() {}
  
  public GetSettingsResponse(int paramInt, ArrayList paramArrayList)
  {
    this.ret = paramInt;
    this.settings = paramArrayList;
  }
  
  public final String className()
  {
    return "jce.GetSettingsResponse";
  }
  
  public final Object clone()
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
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.ret, "ret");
    paramStringBuilder.display(this.settings, "settings");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.ret, true);
    paramStringBuilder.displaySimple(this.settings, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (GetSettingsResponse)paramObject;
    } while ((!JceUtil.equals(this.ret, paramObject.ret)) || (!JceUtil.equals(this.settings, paramObject.settings)));
    return true;
  }
  
  public final String fullClassName()
  {
    return "com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse";
  }
  
  public final int getRet()
  {
    return this.ret;
  }
  
  public final ArrayList getSettings()
  {
    return this.settings;
  }
  
  public final int hashCode()
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
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    if (cache_settings == null)
    {
      cache_settings = new ArrayList();
      SettingsCfg localSettingsCfg = new SettingsCfg();
      cache_settings.add(localSettingsCfg);
    }
    this.settings = ((ArrayList)paramJceInputStream.read(cache_settings, 1, false));
  }
  
  public final void setRet(int paramInt)
  {
    this.ret = paramInt;
  }
  
  public final void setSettings(ArrayList paramArrayList)
  {
    this.settings = paramArrayList;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.settings != null) {
      paramJceOutputStream.write(this.settings, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse
 * JD-Core Version:    0.7.0.1
 */