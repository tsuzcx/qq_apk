package com.tencent.tpns.baseapi.base;

import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.Util;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;

public class DNSResolver
  implements Runnable
{
  public static byte DNS_REASON = 0;
  private static String a = "DNSResolver";
  private String b;
  private String c;
  
  private DNSResolver(String paramString)
  {
    this.b = paramString;
  }
  
  private static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.equals(""));
  }
  
  private static String b(String paramString)
  {
    if (a(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        long l1 = System.nanoTime();
        InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(paramString);
        long l2 = System.nanoTime();
        if ((arrayOfInetAddress != null) && (arrayOfInetAddress.length > 0))
        {
          paramString = arrayOfInetAddress[0];
          DNS_REASON = 2;
          TBaseLogger.dd(a, "getAllByName: " + Arrays.toString(arrayOfInetAddress) + " in " + (l2 - l1) / 1000000L + "ms");
          if (paramString == null) {
            break;
          }
          TBaseLogger.d(a, "addr:" + paramString.getHostAddress());
          if ((paramString instanceof Inet4Address)) {
            return paramString.getHostAddress();
          }
          if (!(paramString instanceof Inet6Address)) {
            break;
          }
          paramString = "[" + paramString.getHostAddress() + "]";
          return paramString;
        }
      }
      catch (Throwable paramString)
      {
        Logger.e(a, "NSLookup error: ", paramString);
        DNS_REASON = 2;
        return null;
      }
      paramString = null;
    }
  }
  
  public static String hostToIp(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject3 = a;
    StringBuilder localStringBuilder = new StringBuilder().append("Get MqttServer address: ").append(paramString1).append(", portList:");
    Object localObject1;
    if (paramString2 == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      Logger.i((String)localObject3, (String)localObject1);
      localObject1 = new ArrayList();
      if (!Util.isNullOrEmptyString(paramString2)) {
        try
        {
          paramString2 = new JSONArray(paramString2);
          int i = 0;
          while (i < paramString2.length())
          {
            ((List)localObject1).add(paramString2.getString(i));
            i += 1;
            continue;
            localObject1 = paramString2;
          }
        }
        catch (JSONException paramString2)
        {
          Logger.e(a, "Get MqttServer parse mqttPortList error ", paramString2);
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = (String)((List)localObject1).get(new Random().nextInt(((List)localObject1).size()));
      Logger.i(a, "Get MqttServer random port: " + (String)localObject1);
      if (!paramString1.startsWith("tcp://")) {}
    }
    else
    {
      try
      {
        paramString2 = paramString1.substring("tcp://".length()).split(":");
        if (paramString2.length <= 1) {
          break label318;
        }
        paramString2 = paramString2[0];
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          Logger.e(a, "Get MqttServer parse tcp ip error ", paramString2);
          paramString2 = null;
        }
      }
      Logger.i(a, "Get MqttServer address no need to parse, ip: ");
      if (!Util.isNullOrEmptyString(paramString2)) {
        break label389;
      }
      TBaseLogger.ee(a, "Get MqttServer ip is null");
    }
    label389:
    for (paramString2 = localObject2;; paramString2 = "tcp://" + paramString2 + ":" + (String)localObject1) {
      for (;;)
      {
        TBaseLogger.i(a, "DNS " + paramString1 + " -> " + paramString2);
        label318:
        do
        {
          return paramString2;
          localObject1 = "1883";
          Logger.i(a, "Get MqttServer use default port: " + "1883");
          break;
          paramString2 = paramString1;
        } while (paramString1.startsWith("ssl://"));
        paramString2 = new DNSResolver(paramString1);
        try
        {
          localObject3 = new Thread(paramString2);
          ((Thread)localObject3).start();
          ((Thread)localObject3).join(4000L);
          paramString2 = paramString2.get();
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Logger.e(a, "t.join", localThrowable);
          }
        }
      }
    }
  }
  
  public String get()
  {
    try
    {
      String str = this.c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    try
    {
      set(b(this.b));
      return;
    }
    catch (Throwable localThrowable)
    {
      TBaseLogger.ww(a, "unexpected for dns resolver:" + localThrowable.getMessage());
    }
  }
  
  public void set(String paramString)
  {
    try
    {
      this.c = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.DNSResolver
 * JD-Core Version:    0.7.0.1
 */