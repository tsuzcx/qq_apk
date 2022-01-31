package com.tencent.mobileqq.highway.config;

import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.OpenUpConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf;
import com.tencent.mobileqq.highway.utils.EndPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class HwConfig
  implements Serializable, Cloneable
{
  public static final int NET_TYPE_2G = 2;
  public static final int NET_TYPE_3G = 3;
  public static final int NET_TYPE_4G = 4;
  public static final int NET_TYPE_DEFAULT = 0;
  public static final int NET_TYPE_WIFI = 1;
  private static final long serialVersionUID = 2113693234079222598L;
  public subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf dtConf = null;
  public subcmd0x501.SubCmd0x501Rspbody.IpLearnConf ipConf = null;
  public ArrayList<EndPoint> ipList;
  public ArrayList<HwNetSegConf> netSegConfList;
  public subcmd0x501.SubCmd0x501Rspbody.OpenUpConf openUpConf = null;
  public ArrayList<HwNetSegConf> shortVideoSegConfList;
  public subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf videoConf = null;
  
  public HwConfig clone()
    throws CloneNotSupportedException
  {
    HwConfig localHwConfig = (HwConfig)super.clone();
    localHwConfig.ipList = new ArrayList();
    Iterator localIterator = this.ipList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (EndPoint)localIterator.next();
      localHwConfig.ipList.add(((EndPoint)localObject).clone());
    }
    localHwConfig.netSegConfList = new ArrayList();
    localIterator = this.netSegConfList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (HwNetSegConf)localIterator.next();
      localHwConfig.netSegConfList.add(((HwNetSegConf)localObject).clone());
    }
    localHwConfig.shortVideoSegConfList = new ArrayList();
    localIterator = this.shortVideoSegConfList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (HwNetSegConf)localIterator.next();
      localHwConfig.shortVideoSegConfList.add(((HwNetSegConf)localObject).clone());
    }
    return localHwConfig;
  }
  
  public String ipList2String()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IP= ");
    Iterator localIterator = this.ipList.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (EndPoint)localIterator.next();
      localStringBuilder.append(((EndPoint)localObject).toString() + "  ");
    }
    localStringBuilder.append("   Segment Info= ");
    localIterator = this.netSegConfList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (HwNetSegConf)localIterator.next();
      localStringBuilder.append(" NetType= " + ((HwNetSegConf)localObject).netType);
      localStringBuilder.append(" SegSize= " + ((HwNetSegConf)localObject).segSize);
      localStringBuilder.append(" SegNum= " + ((HwNetSegConf)localObject).segNum);
      localStringBuilder.append(" CommNUm= " + ((HwNetSegConf)localObject).curConnNum);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.HwConfig
 * JD-Core Version:    0.7.0.1
 */