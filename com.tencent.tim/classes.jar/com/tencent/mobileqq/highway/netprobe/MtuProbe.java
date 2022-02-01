package com.tencent.mobileqq.highway.netprobe;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MtuProbe
  extends ProbeItem
{
  private static final int MAX_MTU = 1472;
  private static final int MIN_MTU = 56;
  private static final int[] MTU_COMMON_VALUES = { 1390, 1400, 1492 };
  private static final int PACKAGE_RECEIVED_INDEX = 2;
  private static final Pattern PING_RESULT_PATTERN = Pattern.compile("---\\n(\\d+) packets transmitted, (\\d+)[\\s\\S]* received, (\\d+).*");
  public static final String PROBE_NAME = "Mtu_Probe";
  public static final int RESULT_BLOCKING_CONNECT = 1;
  public static final int RESULT_OK = 0;
  private String mPeerIp;
  
  private int findMaxMtu()
  {
    int i = 56;
    int j = 1472;
    int k = 0;
    String str;
    if (k < MTU_COMMON_VALUES.length)
    {
      int i1 = MTU_COMMON_VALUES[k] - 28;
      str = PingProbe.execPing(3, 10, i1, this.mPeerIp);
      if (str == null) {
        return -1;
      }
      int m;
      int n;
      if (!isSuccess(str))
      {
        m = j;
        n = i;
        if (i1 < j)
        {
          m = i1;
          n = i;
        }
      }
      for (;;)
      {
        k += 1;
        j = m;
        i = n;
        break;
        m = j;
        n = i;
        if (i1 >= i)
        {
          n = i1;
          m = j;
        }
      }
      if (isSuccess(str)) {
        i = k;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        k = (int)((i + j) / 2.0F + 0.5D);
        str = PingProbe.execPing(3, 10, k, this.mPeerIp);
        if (str != null) {
          break;
        }
        return -1;
        j = k - 1;
        continue;
      }
      return i + 28;
    }
  }
  
  public void doProbe()
  {
    this.mPeerIp = this.mRequest.getIp();
    if (isConnecting())
    {
      onFinish(0, Integer.valueOf(findMaxMtu()));
      return;
    }
    onFinish(1, null);
  }
  
  public String getProbeName()
  {
    return "Mtu_Probe";
  }
  
  public int getRecvPkgNum(String paramString)
  {
    if ((paramString == null) && (TextUtils.isEmpty(paramString))) {}
    do
    {
      return -1;
      paramString = PING_RESULT_PATTERN.matcher(paramString);
    } while ((paramString == null) || (!paramString.find()) || (paramString.groupCount() != 3));
    return Integer.valueOf(paramString.group(2)).intValue();
  }
  
  public boolean isConnecting()
  {
    return isSuccess(PingProbe.execPing(56, this.mPeerIp));
  }
  
  public boolean isSuccess(String paramString)
  {
    return getRecvPkgNum(paramString) > 0;
  }
  
  public void onFinish(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.mResult.appendResult("successful find the max mtu : " + (Integer)paramObject);
      this.mResult.success = true;
      return;
    }
    this.mResult.errDesc = ("the ip " + this.mPeerIp + " can't transmit package!");
    this.mResult.success = false;
    this.mResult.errCode = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.MtuProbe
 * JD-Core Version:    0.7.0.1
 */