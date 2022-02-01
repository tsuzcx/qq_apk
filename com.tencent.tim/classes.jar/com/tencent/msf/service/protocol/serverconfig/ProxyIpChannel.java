package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ProxyIpChannel
  extends JceStruct
{
  static ArrayList cache_vProxy_iplists;
  public int iReconnect = 0;
  public ArrayList vProxy_iplists = null;
  
  public ProxyIpChannel() {}
  
  public ProxyIpChannel(ArrayList paramArrayList, int paramInt)
  {
    this.vProxy_iplists = paramArrayList;
    this.iReconnect = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vProxy_iplists == null)
    {
      cache_vProxy_iplists = new ArrayList();
      ProxyIpList localProxyIpList = new ProxyIpList();
      cache_vProxy_iplists.add(localProxyIpList);
    }
    this.vProxy_iplists = ((ArrayList)paramJceInputStream.read(cache_vProxy_iplists, 0, true));
    this.iReconnect = paramJceInputStream.read(this.iReconnect, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vProxy_iplists, 0);
    paramJceOutputStream.write(this.iReconnect, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.ProxyIpChannel
 * JD-Core Version:    0.7.0.1
 */