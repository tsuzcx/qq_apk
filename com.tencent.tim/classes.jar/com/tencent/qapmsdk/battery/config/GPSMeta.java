package com.tencent.qapmsdk.battery.config;

import com.tencent.qapmsdk.common.logger.Logger;

public class GPSMeta
  extends BaseMeta
{
  public static final String TAG = "QAPM.GPSMeta";
  public long longTime = 18000000L;
  public int maxCallTimeInLongTime = 10;
  public int maxCallTimeInShortTime = 3;
  public long shortTime = 900000L;
  
  public GPSMeta parse(String paramString)
  {
    try
    {
      Object localObject = (String[][])null;
      paramString = paramString.split(";");
      localObject = new String[paramString.length][];
      int i = 0;
      while (i < paramString.length)
      {
        localObject[i] = paramString[i].split(",");
        i += 1;
      }
      if ((localObject.length >= 1) && (localObject[0].length >= 2))
      {
        this.maxCallTimeInShortTime = Integer.valueOf(localObject[0][0]).intValue();
        this.shortTime = (Integer.valueOf(localObject[0][1]).intValue() * 60 * 1000L);
      }
      if ((localObject.length >= 2) && (localObject[1].length >= 2))
      {
        this.maxCallTimeInLongTime = Integer.valueOf(localObject[1][0]).intValue();
        this.longTime = (Integer.valueOf(localObject[1][1]).intValue() * 60 * 1000L);
      }
      return this;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM.GPSMeta", paramString);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.config.GPSMeta
 * JD-Core Version:    0.7.0.1
 */