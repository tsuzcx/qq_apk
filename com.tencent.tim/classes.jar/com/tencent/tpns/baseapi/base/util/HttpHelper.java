package com.tencent.tpns.baseapi.base.util;

import android.util.Base64;
import com.tencent.tpns.baseapi.core.b.b;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HttpHelper
{
  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(new SecretKeySpec(paramString.getBytes("UTF-8"), "HmacSHA256"));
      paramArrayOfByte = Base64.encodeToString(b.a(localMac.doFinal(paramArrayOfByte)).getBytes(), 2);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public static byte[] byteMerger(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return paramArrayOfByte2;
    }
    if (paramArrayOfByte2 == null) {
      return paramArrayOfByte1;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public static Map<String, String> getSignAuthHeader(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    try
    {
      if ((Util.isNullOrEmptyString(paramString2)) || (Util.isNullOrEmptyString(paramString1)))
      {
        Logger.d("HttpHelper", "accessId or accessKey was null");
        return null;
      }
      HashMap localHashMap = new HashMap();
      String str = String.valueOf(System.currentTimeMillis() / 1000L);
      localHashMap.put("Sign", a(byteMerger((str + paramString1).getBytes("UTF-8"), paramArrayOfByte), paramString2));
      localHashMap.put("TimeStamp", str);
      localHashMap.put("AccessId", "" + paramString1);
      return localHashMap;
    }
    catch (Throwable paramString1) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.HttpHelper
 * JD-Core Version:    0.7.0.1
 */