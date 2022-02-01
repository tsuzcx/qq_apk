package cooperation.qqreader.host;

import android.content.Intent;
import android.os.Bundle;

public class ChannelIdHelper
{
  private static String cMc = "-1";
  
  public static String getChannelId()
  {
    return cMc;
  }
  
  public static void initChannelId(Intent paramIntent)
  {
    if (("-1".equals(cMc)) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("ChannelID");
      if (paramIntent != null) {
        cMc = paramIntent;
      }
    }
  }
  
  public static boolean isFromKandian()
  {
    return "100081".equals(cMc);
  }
  
  public static boolean isFromLeba()
  {
    return "100020".equals(cMc);
  }
  
  public static boolean isFromUnknown()
  {
    return "-1".equals(cMc);
  }
  
  public static void setChannelId(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.hasExtra("ChannelID")))
    {
      paramIntent = paramIntent.getStringExtra("ChannelID");
      if ((paramIntent != null) && (!"-1".equals(paramIntent))) {
        cMc = paramIntent;
      }
    }
  }
  
  public static void setChannelId(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("ChannelID");
      if ((paramBundle != null) && (!"-1".equals(paramBundle))) {
        cMc = paramBundle;
      }
    }
  }
  
  public static void setChannelId(String paramString)
  {
    cMc = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.ChannelIdHelper
 * JD-Core Version:    0.7.0.1
 */