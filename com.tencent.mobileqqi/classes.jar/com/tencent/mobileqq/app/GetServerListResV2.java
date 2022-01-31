package com.tencent.mobileqq.app;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class GetServerListResV2
  extends JceStruct
{
  static ArrayList cache_v2G3GList;
  static ArrayList cache_vWifiList;
  public int iResult = 0;
  public int iTime = 0;
  public ArrayList v2G3GList = null;
  public ArrayList vWifiList = null;
  
  static
  {
    if (!GetServerListResV2.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GetServerListResV2()
  {
    setIResult(this.iResult);
    setV2G3GList(this.v2G3GList);
    setVWifiList(this.vWifiList);
    setITime(this.iTime);
  }
  
  public GetServerListResV2(int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt2)
  {
    setIResult(paramInt1);
    setV2G3GList(paramArrayList1);
    setVWifiList(paramArrayList2);
    setITime(paramInt2);
  }
  
  public String className()
  {
    return "KQQConfig.GetServerListResV2";
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
    paramStringBuilder.display(this.iResult, "iResult");
    paramStringBuilder.display(this.v2G3GList, "v2G3GList");
    paramStringBuilder.display(this.vWifiList, "vWifiList");
    paramStringBuilder.display(this.iTime, "iTime");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (GetServerListResV2)paramObject;
    return (JceUtil.equals(this.iResult, paramObject.iResult)) && (JceUtil.equals(this.v2G3GList, paramObject.v2G3GList)) && (JceUtil.equals(this.vWifiList, paramObject.vWifiList)) && (JceUtil.equals(this.iTime, paramObject.iTime));
  }
  
  public int getIResult()
  {
    return this.iResult;
  }
  
  public int getITime()
  {
    return this.iTime;
  }
  
  public ArrayList getV2G3GList()
  {
    return this.v2G3GList;
  }
  
  public ArrayList getVWifiList()
  {
    return this.vWifiList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setIResult(paramJceInputStream.read(this.iResult, 1, true));
    ServerListInfo localServerListInfo;
    if (cache_v2G3GList == null)
    {
      cache_v2G3GList = new ArrayList();
      localServerListInfo = new ServerListInfo();
      cache_v2G3GList.add(localServerListInfo);
    }
    setV2G3GList((ArrayList)paramJceInputStream.read(cache_v2G3GList, 2, true));
    if (cache_vWifiList == null)
    {
      cache_vWifiList = new ArrayList();
      localServerListInfo = new ServerListInfo();
      cache_vWifiList.add(localServerListInfo);
    }
    setVWifiList((ArrayList)paramJceInputStream.read(cache_vWifiList, 3, true));
    setITime(paramJceInputStream.read(this.iTime, 4, true));
  }
  
  public void setIResult(int paramInt)
  {
    this.iResult = paramInt;
  }
  
  public void setITime(int paramInt)
  {
    this.iTime = paramInt;
  }
  
  public void setV2G3GList(ArrayList paramArrayList)
  {
    this.v2G3GList = paramArrayList;
  }
  
  public void setVWifiList(ArrayList paramArrayList)
  {
    this.vWifiList = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResult, 1);
    paramJceOutputStream.write(this.v2G3GList, 2);
    paramJceOutputStream.write(this.vWifiList, 3);
    paramJceOutputStream.write(this.iTime, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GetServerListResV2
 * JD-Core Version:    0.7.0.1
 */