package com.pay.googlewaletsdk.tool;

import org.apache.http.conn.util.InetAddressUtils;

public class PayUtil
{
  public static String convertStreamToString(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramString);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static String[] cutCoinType(String paramString)
  {
    int j = paramString.length();
    String[] arrayOfString = new String[2];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return arrayOfString;
      }
      int k = paramString.charAt(i);
      if ((k >= 48) && (k <= 57))
      {
        arrayOfString[0] = paramString.substring(0, i);
        arrayOfString[1] = paramString.substring(i);
        return arrayOfString;
      }
      i += 1;
    }
  }
  
  public static boolean isIPAddress(String paramString)
  {
    return (paramString != null) && ((InetAddressUtils.isIPv4Address(paramString)) || (InetAddressUtils.isIPv6Address(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewaletsdk.tool.PayUtil
 * JD-Core Version:    0.7.0.1
 */