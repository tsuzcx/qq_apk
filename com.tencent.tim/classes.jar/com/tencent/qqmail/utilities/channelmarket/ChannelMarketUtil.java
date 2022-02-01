package com.tencent.qqmail.utilities.channelmarket;

import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ChannelMarketUtil
{
  private static final String TAG = "ChannelMarketUtil";
  private static ArrayList<ChannelMarket> channelMarkets = new ArrayList();
  
  static
  {
    channelMarkets.add(new ChannelMarket(11, "com.tencent.android.qqdownloader"));
    channelMarkets.add(new ChannelMarket(12, "com.xiaomi.market"));
    channelMarkets.add(new ChannelMarket(7, "com.baidu.appsearch"));
    channelMarkets.add(new ChannelMarket(10, "com.qihoo.appstore"));
    channelMarkets.add(new ChannelMarket(24, "com.huawei.appmarket"));
    channelMarkets.add(new ChannelMarket(19, "com.sogou.androidtool"));
    channelMarkets.add(new ChannelMarket(6, "com.wandoujia.phoenix2"));
    channelMarkets.add(new ChannelMarket(1, "com.android.vending"));
  }
  
  public static String getMarketByChannelId(int paramInt)
  {
    if (channelMarkets.size() > 0)
    {
      Object localObject = channelMarkets.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ChannelMarket localChannelMarket = (ChannelMarket)((Iterator)localObject).next();
        if (localChannelMarket.getChannelId() == paramInt)
        {
          localObject = localChannelMarket.getMarket();
          if (DeviceUtil.isAppInstalled((String)localObject))
          {
            QMLog.log(4, "ChannelMarketUtil", "get the install market by channelId:" + paramInt + "market:" + (String)localObject);
            return localObject;
          }
        }
      }
    }
    return "";
  }
  
  public static String getTopPriorityMarket()
  {
    if (channelMarkets.size() > 0)
    {
      Iterator localIterator = channelMarkets.iterator();
      while (localIterator.hasNext())
      {
        String str = ((ChannelMarket)localIterator.next()).getMarket();
        if (DeviceUtil.isAppInstalled(str))
        {
          QMLog.log(4, "ChannelMarketUtil", "get the install top priority market:" + str);
          return str;
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.channelmarket.ChannelMarketUtil
 * JD-Core Version:    0.7.0.1
 */