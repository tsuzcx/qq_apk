import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kyt
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("DefaultFeedsProteusBidConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = kye.i(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("DefaultFeedsProteusBidConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "default_feeds"))
      {
        awit.jD("default_feeds_proteus_offline_bid", str2);
        new npl().ot("default_feeds");
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("DefaultFeedsProteusBidConfigHandler", 1, "[onWipeConfig]");
    awit.jD("default_feeds_proteus_offline_bid", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kyt
 * JD-Core Version:    0.7.0.1
 */