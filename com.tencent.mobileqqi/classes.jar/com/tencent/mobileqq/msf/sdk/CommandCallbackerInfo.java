package com.tencent.mobileqq.msf.sdk;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class CommandCallbackerInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_cmds;
  public ArrayList cmds = null;
  public String uin = "";
  
  static
  {
    if (!CommandCallbackerInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public CommandCallbackerInfo()
  {
    setUin(this.uin);
    setCmds(this.cmds);
  }
  
  public CommandCallbackerInfo(String paramString, ArrayList paramArrayList)
  {
    setUin(paramString);
    setCmds(paramArrayList);
  }
  
  public String className()
  {
    return "clientPushInfo.CommandCallbackerInfo";
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
    paramStringBuilder.display(this.cmds, "cmds");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (CommandCallbackerInfo)paramObject;
    } while ((!JceUtil.equals(this.uin, paramObject.uin)) || (!JceUtil.equals(this.cmds, paramObject.cmds)));
    return true;
  }
  
  public String fullClassName()
  {
    return "clientPushInfo.CommandCallbackerInfo";
  }
  
  public ArrayList getCmds()
  {
    return this.cmds;
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
    if (cache_cmds == null)
    {
      cache_cmds = new ArrayList();
      cache_cmds.add("");
    }
    setCmds((ArrayList)paramJceInputStream.read(cache_cmds, 2, true));
  }
  
  public void setCmds(ArrayList paramArrayList)
  {
    this.cmds = paramArrayList;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 1);
    paramJceOutputStream.write(this.cmds, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo
 * JD-Core Version:    0.7.0.1
 */