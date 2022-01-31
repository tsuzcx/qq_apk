package com.qzone.common.dns;

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
      return null;
    }
    try
    {
      Object localObject2 = new UdpClient();
      ((UdpClient)localObject2).setTimeout(paramLong);
      localObject2 = ((UdpClient)localObject2).sendrecv(this.dnsServerAddress, (byte[])localObject1);
      localObject1 = arrayOfInetAddress;
      if (localObject2 != null)
      {
        localObject2 = new ResponsePacket(new DNSInput((byte[])localObject2), paramString);
        localObject1 = arrayOfInetAddress;
        if (((ResponsePacket)localObject2).getReqId() == localRequestPacket.getReqId())
        {
          arrayOfInetAddress = ((ResponsePacket)localObject2).getByAddress();
          localObject1 = arrayOfInetAddress;
          if (arrayOfInetAddress != null)
          {
            localObject1 = arrayOfInetAddress;
            if (arrayOfInetAddress.length > 0)
            {
              HostCacheManager.getInstance().addCache(paramString, arrayOfInetAddress, ((ResponsePacket)localObject2).getExpireTime());
              localObject1 = arrayOfInetAddress;
            }
          }
        }
      }
      return localObject1;
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
  
  public void setDnsAddress(String paramString)
  {
    this.dnsServerAddress = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.dns.Lookup
 * JD-Core Version:    0.7.0.1
 */