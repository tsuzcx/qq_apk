import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kzi
  implements AladdinConfigHandler
{
  public static boolean Bn()
  {
    return ((Boolean)awit.f("use_new_report_channel_for_1160", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("RIJNewReportChannelConfigHandler", 2, "[onReceiveConfig] " + paramString);
    paramString = kye.i(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("RIJNewReportChannelConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "enable_1160_use_new_report_service")) {
        awit.H("use_new_report_channel_for_1160", Boolean.valueOf(TextUtils.equals(str2, "1")));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    awit.H("use_new_report_channel_for_1160", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzi
 * JD-Core Version:    0.7.0.1
 */