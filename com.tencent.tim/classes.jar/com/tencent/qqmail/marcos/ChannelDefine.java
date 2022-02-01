package com.tencent.qqmail.marcos;

import android.os.SystemClock;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.channel.ChannelManager;

public class ChannelDefine
{
  private static final String TAG = "ChannelDefine";
  private static int channelid = -1;
  
  public static int getChannelId()
  {
    if (channelid == -1) {}
    try
    {
      if (channelid == -1)
      {
        long l = SystemClock.elapsedRealtime();
        channelid = ChannelManager.getChannel(QMApplicationContext.sharedInstance());
        QMLog.log(4, "ChannelDefine", "get channel: " + channelid + ", elapsed: " + (SystemClock.elapsedRealtime() - l) + "ms");
        if (channelid == -2147483648) {
          channelid = -3;
        }
      }
      return channelid;
    }
    finally {}
  }
  
  public static final int getWeTestAutoLoginType()
  {
    return 0;
  }
  
  public static boolean isGooglePlay()
  {
    return getChannelId() == 1;
  }
  
  public static boolean isQQandWeixin()
  {
    int i = getChannelId();
    return (i == 73) || (i == 51) || (i == 65);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.marcos.ChannelDefine
 * JD-Core Version:    0.7.0.1
 */