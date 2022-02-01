package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.BeaconAdapter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CKeyBeaconReport
{
  private static String BeaconAppKey = "000000CYDQ3IT5FF";
  private static BeaconInterface mBeaconInterface;
  private static boolean mCloseReport = false;
  private String mChannel;
  private String mVersion;
  
  public CKeyBeaconReport(String paramString1, String paramString2, BeaconInterface paramBeaconInterface)
  {
    this.mVersion = paramString1;
    this.mChannel = paramString2;
    mBeaconInterface = paramBeaconInterface;
    if (BeaconAdapter.isBeaconEnable()) {
      BeaconAdapter.registerTunnel(BeaconAppKey, this.mVersion, this.mChannel);
    }
  }
  
  public static String getQIMEI()
  {
    String str = "";
    if (mBeaconInterface != null) {
      str = mBeaconInterface.getQIMEI();
    }
    return str;
  }
  
  public static Properties getRequiredReportValue()
  {
    if ((mBeaconInterface != null) && (mBeaconInterface.getRequiredReportValue() != null)) {
      return mBeaconInterface.getRequiredReportValue();
    }
    return new Properties();
  }
  
  private static Map<String, String> propertyToMap(Properties paramProperties)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    paramProperties = paramProperties.entrySet().iterator();
    while (paramProperties.hasNext())
    {
      Object localObject2 = (Map.Entry)paramProperties.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (localObject2 == null) {
        localConcurrentHashMap.put(localObject1.toString(), "");
      } else {
        localConcurrentHashMap.put(localObject1.toString(), localObject2.toString());
      }
    }
    return localConcurrentHashMap;
  }
  
  public static void setSwitchReport(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      mCloseReport = paramBoolean;
      return;
    }
  }
  
  public static void trackCustomKVEvent(Context paramContext, String paramString, Properties paramProperties)
  {
    if (mCloseReport) {}
    do
    {
      return;
      if (BeaconAdapter.isBeaconEnable()) {
        BeaconAdapter.onUserActionToTunnel(BeaconAppKey, paramString, true, -1L, -1L, propertyToMap(paramProperties), true, false);
      }
    } while (mBeaconInterface == null);
    mBeaconInterface.trackCustomKVEvent(paramString, propertyToMap(paramProperties));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyBeaconReport
 * JD-Core Version:    0.7.0.1
 */