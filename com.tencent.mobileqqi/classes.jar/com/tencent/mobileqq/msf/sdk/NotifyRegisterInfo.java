package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class NotifyRegisterInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_notifyIds;
  static Map cache_notifyProperties;
  public ArrayList notifyIds = null;
  public Map notifyProperties = null;
  public String uin = "";
  
  static
  {
    if (!NotifyRegisterInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public NotifyRegisterInfo()
  {
    setUin(this.uin);
    setNotifyIds(this.notifyIds);
    setNotifyProperties(this.notifyProperties);
  }
  
  public NotifyRegisterInfo(String paramString, ArrayList paramArrayList, Map paramMap)
  {
    setUin(paramString);
    setNotifyIds(paramArrayList);
    setNotifyProperties(paramMap);
  }
  
  public String className()
  {
    return "clientPushInfo.NotifyRegisterInfo";
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
    paramStringBuilder.display(this.uin, "uin");
    paramStringBuilder.display(this.notifyIds, "notifyIds");
    paramStringBuilder.display(this.notifyProperties, "notifyProperties");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (NotifyRegisterInfo)paramObject;
    } while ((!JceUtil.equals(this.uin, paramObject.uin)) || (!JceUtil.equals(this.notifyIds, paramObject.notifyIds)) || (!JceUtil.equals(this.notifyProperties, paramObject.notifyProperties)));
    return true;
  }
  
  public String fullClassName()
  {
    return "clientPushInfo.NotifyRegisterInfo";
  }
  
  public ArrayList getNotifyIds()
  {
    return this.notifyIds;
  }
  
  public Map getNotifyProperties()
  {
    return this.notifyProperties;
  }
  
  public String getUin()
  {
    return this.uin;
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
    setUin(paramJceInputStream.readString(1, true));
    if (cache_notifyIds == null)
    {
      cache_notifyIds = new ArrayList();
      cache_notifyIds.add(Long.valueOf(0L));
    }
    setNotifyIds((ArrayList)paramJceInputStream.read(cache_notifyIds, 2, true));
    if (cache_notifyProperties == null)
    {
      cache_notifyProperties = new HashMap();
      cache_notifyProperties.put(Long.valueOf(0L), "");
    }
    setNotifyProperties((Map)paramJceInputStream.read(cache_notifyProperties, 3, true));
  }
  
  public void setNotifyIds(ArrayList paramArrayList)
  {
    this.notifyIds = paramArrayList;
  }
  
  public void setNotifyProperties(Map paramMap)
  {
    this.notifyProperties = paramMap;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.notifyIds, 2);
    paramJceOutputStream.write(this.notifyProperties, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.NotifyRegisterInfo
 * JD-Core Version:    0.7.0.1
 */