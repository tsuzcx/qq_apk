package cooperation.qqreader.host;

import avpq;
import com.tencent.common.config.AppSetting;

public class ReaderAppSetting
{
  public static String buildNum()
  {
    return "3058";
  }
  
  public static boolean enableTalkBack()
  {
    return AppSetting.enableTalkBack;
  }
  
  public static String getQUA()
  {
    return avpq.getQUA3();
  }
  
  public static boolean isDebugVersion()
  {
    return false;
  }
  
  public static String subVersion()
  {
    return "3.4.4";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderAppSetting
 * JD-Core Version:    0.7.0.1
 */