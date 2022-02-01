package com.tencent.youtu.sdkkitframework.common;

import android.util.Base64;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CommonUtils
{
  public static final int MAX_TIMEOUT_MS = 20000;
  public static final int MIN_TIMEOUT_MS = 0;
  private static final String TAG = "CommonUtils";
  private static ConcurrentHashMap<String, BenchMarkTime> benchMarkMaps = new ConcurrentHashMap();
  
  public static void benchMarkBegin(String paramString)
  {
    if (!benchMarkMaps.containsKey(paramString)) {
      benchMarkMaps.put(paramString, new BenchMarkTime());
    }
    ((BenchMarkTime)benchMarkMaps.get(paramString)).begin();
  }
  
  public static long benchMarkEnd(String paramString)
  {
    if (!benchMarkMaps.containsKey(paramString)) {
      return 0L;
    }
    BenchMarkTime localBenchMarkTime = (BenchMarkTime)benchMarkMaps.get(paramString);
    localBenchMarkTime.end();
    YtLogger.d("CommonUtils", "benchMarkEnd -- " + paramString + " : " + localBenchMarkTime.cur);
    return localBenchMarkTime.cur;
  }
  
  public static String getBenchMarkTime(String paramString)
  {
    if (!benchMarkMaps.containsKey(paramString)) {
      return "";
    }
    return "[" + paramString + "]" + ((BenchMarkTime)benchMarkMaps.get(paramString)).getTime();
  }
  
  private static byte[] getSignature(String paramString1, String paramString2)
    throws Exception
  {
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(new SecretKeySpec(paramString2.getBytes(), localMac.getAlgorithm()));
    return localMac.doFinal(paramString1.getBytes());
  }
  
  public static String getYoutuOpenAppSign(String paramString1, String paramString2, String paramString3, String paramString4)
    throws Exception
  {
    long l = System.currentTimeMillis() / 1000L;
    int i = Math.abs(new Random().nextInt());
    paramString1 = "a=" + paramString1 + "&k=" + paramString2 + "&e=" + (2592000L + l) + "&t=" + l + "&r=" + i + "&u=" + paramString4 + "&f=";
    paramString2 = getSignature(paramString1, paramString3);
    paramString3 = new byte[paramString2.length + paramString1.getBytes().length];
    System.arraycopy(paramString2, 0, paramString3, 0, paramString2.length);
    System.arraycopy(paramString1.getBytes(), 0, paramString3, paramString2.length, paramString1.getBytes().length);
    return new String(Base64.encode(paramString3, 2));
  }
  
  static class BenchMarkTime
  {
    long avg = 0L;
    long begin;
    long cur = 0L;
    long max = -9223372036854775808L;
    long min = 9223372036854775807L;
    long tick = 0L;
    long total = 0L;
    
    private void update(long paramLong)
    {
      this.tick += 1L;
      this.min = Math.min(paramLong, this.min);
      this.max = Math.max(paramLong, this.max);
      this.total += paramLong;
      this.avg = (this.total / this.tick);
    }
    
    public void begin()
    {
      this.begin = System.currentTimeMillis();
    }
    
    public void end()
    {
      this.cur = (System.currentTimeMillis() - this.begin);
      update(this.cur);
    }
    
    public String getTime()
    {
      return "avg: " + this.avg + "ms min: " + this.min + "ms max: " + this.max + "ms cur: " + this.cur + "ms";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.CommonUtils
 * JD-Core Version:    0.7.0.1
 */