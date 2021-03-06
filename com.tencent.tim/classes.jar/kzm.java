import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kzm
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("VideoColumnHandler", 1, "[onReceiveConfig] " + paramString);
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        paramString = kye.i(paramString);
        Iterator localIterator = paramString.keySet().iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          str2 = (String)paramString.get(str1);
          if (TextUtils.isEmpty(str2)) {
            break label209;
          }
          QLog.d("VideoColumnHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
          if (TextUtils.equals(str1, "video_channel_feeds_type")) {
            awit.acv(Integer.parseInt(str2));
          }
        }
        else
        {
          return true;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoColumnHandler", 2, "error in parse video_feeds_Type config: " + paramString.getMessage());
        }
      }
      if (TextUtils.equals(str1, "multi_video_feeds_type"))
      {
        awit.acw(Integer.parseInt(str2));
        continue;
        label209:
        QLog.d("VideoColumnHandler", 2, "key: " + str1 + " of value is null");
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    awit.acv(1);
    awit.acw(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzm
 * JD-Core Version:    0.7.0.1
 */