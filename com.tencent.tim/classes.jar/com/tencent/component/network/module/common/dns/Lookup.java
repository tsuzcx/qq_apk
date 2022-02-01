package com.tencent.component.network.module.common.dns;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Lookup
{
  private String dnsServerAddress = "";
  
  public Lookup(String paramString)
    throws UnknownHostException
  {
    this.dnsServerAddress = paramString;
  }
  
  public InetAddress[] run(String paramString, long paramLong)
    throws IOException, SocketTimeoutException, WireParseException, UnknownHostException, Exception
  {
    InetAddress[] arrayOfInetAddress = null;
    RequestPacket localRequestPacket = new RequestPacket(paramString);
    Object localObject1 = localRequestPacket.getQueryData();
    if (localObject1 == null) {
      localObject1 = arrayOfInetAddress;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        Object localObject2 = new UdpClient();
        ((UdpClient)localObject2).setTimeout(paramLong);
        localObject2 = ((UdpClient)localObject2).sendrecv(this.dnsServerAddress, (byte[])localObject1);
        localObject1 = arrayOfInetAddress;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = new ResponsePacket(new DNSInput((byte[])localObject2), paramString);
        localObject1 = arrayOfInetAddress;
        if (((ResponsePacket)localObject2).getReqId() != localRequestPacket.getReqId()) {
          continue;
        }
        arrayOfInetAddress = ((ResponsePacket)localObject2).getByAddress();
        localObject1 = arrayOfInetAddress;
        if (arrayOfInetAddress == null) {
          continue;
        }
        localObject1 = arrayOfInetAddress;
        if (arrayOfInetAddress.length <= 0) {
          continue;
        }
        HostCacheManager.getInstance().addCache(paramString, arrayOfInetAddress, ((ResponsePacket)localObject2).getExpireTime());
        return arrayOfInetAddress;
      }
      catch (WireParseException paramString)
      {
        throw paramString;
      }
      catch (SocketTimeoutException paramString)
      {
        throw paramString;
      }
      catch (IOException paramString)
      {
        throw paramString;
      }
    }
  }
  
  public void setDnsAddress(String paramString)
  {
    this.dnsServerAddress = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.Lookup
 * JD-Core Version:    0.7.0.1
 */