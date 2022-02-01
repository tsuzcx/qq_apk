package com.tencent.qapmsdk.socket.model;

import android.text.TextUtils;
import com.tencent.qapmsdk.dns.model.DnsInfo;
import java.util.concurrent.ConcurrentHashMap;

public class SocketTracer
{
  private static final ConcurrentHashMap<String, SocketInfo> SOCKET_MAP = new ConcurrentHashMap();
  
  public static void addSocketInfoToMap(String paramString, SocketInfo paramSocketInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramSocketInfo != null))
    {
      paramSocketInfo.dnsTime = DnsInfo.getDnsElapse(paramSocketInfo.host);
      if (SOCKET_MAP.get(paramString) == null) {
        SOCKET_MAP.put(paramString, paramSocketInfo);
      }
    }
  }
  
  public static SocketInfo getSocketInfoFromMap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (SOCKET_MAP.get(paramString) == null) {
      return (SocketInfo)SOCKET_MAP.get(paramString + "/");
    }
    return (SocketInfo)SOCKET_MAP.get(paramString);
  }
  
  public static void removeSocketInfoFromMap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((SocketInfo)SOCKET_MAP.get(paramString) == null) {
      return;
    }
    SOCKET_MAP.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.model.SocketTracer
 * JD-Core Version:    0.7.0.1
 */