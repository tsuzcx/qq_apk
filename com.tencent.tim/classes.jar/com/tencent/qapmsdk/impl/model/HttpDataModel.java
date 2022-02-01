package com.tencent.qapmsdk.impl.model;

import com.tencent.qapmsdk.dns.model.DnsInfo;
import com.tencent.qapmsdk.impl.api.data.TransactionData;
import com.tencent.qapmsdk.impl.report.TrafficMonitorReport;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import com.tencent.qapmsdk.socket.model.SocketTracer;
import java.net.InetAddress;
import java.net.URL;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpDataModel
{
  private static final int ERROR_CODE = 400;
  
  public static void collectData(TransactionData paramTransactionData)
  {
    SocketInfo localSocketInfo = getSocketInfo(paramTransactionData);
    if (localSocketInfo != null)
    {
      localSocketInfo.url = paramTransactionData.getUrl();
      localSocketInfo.duringTime = paramTransactionData.getTime();
      localSocketInfo.startTimeStamp = paramTransactionData.getStartTimeStamp();
      if (localSocketInfo.statusCode == 0) {
        localSocketInfo.statusCode = paramTransactionData.getStatusCode();
      }
      SocketTracer.removeSocketInfoFromMap(paramTransactionData.getUrl());
      TrafficMonitorReport.getInstance().addHttpToQueue(localSocketInfo);
      TrafficMonitorReport.getInstance().doReport();
    }
  }
  
  public static void collectData(TransactionData paramTransactionData, Exception paramException)
  {
    SocketInfo localSocketInfo = getSocketInfo(paramTransactionData);
    if (localSocketInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(paramTransactionData.getUrl());
      if (paramTransactionData.getAllGetRequestParams() == null)
      {
        paramException = "";
        localSocketInfo.url = paramException;
        localSocketInfo.duringTime = paramTransactionData.getTime();
        localSocketInfo.startTimeStamp = paramTransactionData.getStartTimeStamp();
        localSocketInfo.statusCode = paramTransactionData.getStatusCode();
        localSocketInfo.errorCode = paramTransactionData.getErrorCode();
        SocketTracer.removeSocketInfoFromMap(paramTransactionData.getUrl());
      }
    }
    for (paramTransactionData = localSocketInfo;; paramTransactionData = generateSocketInfo(paramTransactionData))
    {
      TrafficMonitorReport.getInstance().addHttpToQueue(paramTransactionData);
      TrafficMonitorReport.getInstance().doReport();
      return;
      paramException = "?" + paramTransactionData.getAllGetRequestParams();
      break;
    }
  }
  
  public static void collectData(TransactionData paramTransactionData, String paramString)
  {
    paramString = getSocketInfo(paramTransactionData);
    if (paramString != null)
    {
      paramString.url = paramTransactionData.getUrl();
      paramString.duringTime = paramTransactionData.getTime();
      paramString.startTimeStamp = paramTransactionData.getStartTimeStamp();
      if ((paramString.statusCode == 0) || (paramTransactionData.getErrorCode() > 400))
      {
        paramString.statusCode = paramTransactionData.getStatusCode();
        paramString.errorCode = paramTransactionData.getErrorCode();
      }
      SocketTracer.removeSocketInfoFromMap(paramTransactionData.getUrl());
    }
    for (paramTransactionData = paramString;; paramTransactionData = generateSocketInfo(paramTransactionData))
    {
      TrafficMonitorReport.getInstance().addHttpToQueue(paramTransactionData);
      TrafficMonitorReport.getInstance().doReport();
      return;
    }
  }
  
  public static void collectData(TransactionData paramTransactionData, TreeMap paramTreeMap, String paramString)
  {
    paramTreeMap = getSocketInfo(paramTransactionData);
    if (paramTreeMap != null)
    {
      paramTreeMap.url = paramTransactionData.getUrl();
      paramTreeMap.duringTime = paramTransactionData.getTime();
      paramTreeMap.startTimeStamp = paramTransactionData.getStartTimeStamp();
      if ((paramTreeMap.statusCode == 0) || (paramTransactionData.getErrorCode() > 400))
      {
        paramTreeMap.statusCode = paramTransactionData.getStatusCode();
        paramTreeMap.errorCode = paramTransactionData.getErrorCode();
      }
      SocketTracer.removeSocketInfoFromMap(paramTransactionData.getUrl());
    }
    for (paramTransactionData = paramTreeMap;; paramTransactionData = generateSocketInfo(paramTransactionData))
    {
      TrafficMonitorReport.getInstance().addHttpToQueue(paramTransactionData);
      TrafficMonitorReport.getInstance().doReport();
      return;
    }
  }
  
  private static SocketInfo generateSocketInfo(TransactionData paramTransactionData)
  {
    SocketInfo localSocketInfo = new SocketInfo();
    Object localObject = paramTransactionData.getUrl();
    localSocketInfo.url = ((String)localObject);
    localSocketInfo.duringTime = paramTransactionData.getTime();
    localSocketInfo.startTimeStamp = paramTransactionData.getStartTimeStamp();
    localSocketInfo.contentType = paramTransactionData.getContentType();
    localSocketInfo.statusCode = paramTransactionData.getStatusCode();
    localSocketInfo.errorCode = paramTransactionData.getErrorCode();
    try
    {
      paramTransactionData = new URL((String)localObject);
      if (hostIsIp(paramTransactionData))
      {
        localSocketInfo.ip = paramTransactionData.getHost();
        return localSocketInfo;
      }
      localObject = InetAddress.getAllByName(paramTransactionData.getHost());
      localSocketInfo.dnsTime = DnsInfo.getDnsElapse(paramTransactionData.getHost());
      if (localObject.length > 0)
      {
        localSocketInfo.ip = localObject[0].getHostAddress();
        return localSocketInfo;
      }
    }
    catch (Exception paramTransactionData) {}
    return localSocketInfo;
  }
  
  private static SocketInfo getSocketInfo(TransactionData paramTransactionData)
  {
    for (;;)
    {
      try
      {
        localObject = paramTransactionData.getUrl();
        URL localURL = new URL((String)localObject);
        int i = localURL.getPort();
        if (i != -1)
        {
          localObject = Pattern.compile(":" + i).split((CharSequence)localObject);
          if (localObject.length <= 1) {
            break label244;
          }
          localObject = localObject[0] + localObject[1];
          localObject = new StringBuilder().append((String)localObject);
          if (paramTransactionData.getAllGetRequestParams() == null)
          {
            paramTransactionData = "";
            paramTransactionData = paramTransactionData;
            SocketInfo localSocketInfo = SocketTracer.getSocketInfoFromMap(paramTransactionData);
            localObject = localSocketInfo;
            if (localSocketInfo == null)
            {
              localObject = localSocketInfo;
              if (hostIsIp(localURL))
              {
                localObject = localURL.getHost();
                return SocketTracer.getSocketInfoFromMap(paramTransactionData.replace((CharSequence)localObject, DnsInfo.getHostFromIp((String)localObject)));
              }
            }
          }
          else
          {
            paramTransactionData = "?" + paramTransactionData.getAllGetRequestParams();
            continue;
          }
        }
        else
        {
          localObject = new StringBuilder().append((String)localObject);
          if (paramTransactionData.getAllGetRequestParams() == null)
          {
            paramTransactionData = "";
            paramTransactionData = paramTransactionData;
            continue;
          }
          paramTransactionData = "?" + paramTransactionData.getAllGetRequestParams();
          continue;
        }
        return localObject;
      }
      catch (Exception paramTransactionData)
      {
        localObject = null;
      }
      label244:
      Object localObject = localObject[0];
    }
  }
  
  private static boolean hostIsIp(URL paramURL)
  {
    paramURL = paramURL.getHost();
    return Pattern.compile("^(2[0-5]{2}|[0-1]?\\d{1,2})(\\.(2[0-5]{2}|[0-1]?\\d{1,2})){3}$").matcher(paramURL).find();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.model.HttpDataModel
 * JD-Core Version:    0.7.0.1
 */