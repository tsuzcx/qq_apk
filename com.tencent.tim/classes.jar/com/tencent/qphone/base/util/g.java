package com.tencent.qphone.base.util;

import com.tencent.msf.service.protocol.push.a.a;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class g
{
  public static int a(int paramInt)
  {
    return (0xFF00 & paramInt) >> 8 | (paramInt & 0xFF) << 8;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      int i = 0;
      if (i < paramString.length())
      {
        String str = Integer.toHexString(paramString.charAt(i));
        if (str.length() % 2 == 0) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append("0").append(str);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static InetAddress a(long paramLong)
    throws UnknownHostException
  {
    int i = (byte)(int)(paramLong >> 24 & 0xFF);
    int j = (byte)(int)(paramLong >> 16 & 0xFF);
    int k = (byte)(int)(paramLong >> 8 & 0xFF);
    return InetAddress.getByAddress(new byte[] { (byte)(int)(paramLong & 0xFF), k, j, i });
  }
  
  public static InetAddress a(a parama)
    throws UnknownHostException
  {
    try
    {
      InetAddress localInetAddress = InetAddress.getByAddress(parama.d);
      return localInetAddress;
    }
    catch (UnknownHostException localUnknownHostException) {}
    return a(parama.a);
  }
  
  public static final long b(String paramString)
  {
    Matcher localMatcher = Pattern.compile("((\\d{1,3}\\.){3}\\d{1,3})").matcher(paramString);
    if (!localMatcher.find())
    {
      QLog.d("MSF.C.NetConnTag", 1, "ip not match:" + paramString);
      return -2L;
    }
    paramString = localMatcher.group(1).split("\\.");
    long l1 = Long.parseLong(paramString[3]);
    long l2 = Long.parseLong(paramString[2]);
    long l3 = Long.parseLong(paramString[1]);
    return Long.parseLong(paramString[0]) + ((l1 << 24) + (l2 << 16) + (l3 << 8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.g
 * JD-Core Version:    0.7.0.1
 */