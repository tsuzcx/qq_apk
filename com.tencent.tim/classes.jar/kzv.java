import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kzv
  implements AladdinConfigHandler
{
  public static boolean Bp()
  {
    return ((Integer)awit.f("wormhole_open", Integer.valueOf(0))).intValue() == 1;
  }
  
  private static void qb(int paramInt)
  {
    QLog.d("WormholeConfigHandler", 0, "update wormhole value: " + paramInt);
    awit.H("wormhole_open", Integer.valueOf(paramInt));
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("WormholeConfigHandler", 0, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    try
    {
      paramString = kye.i(paramString);
      Iterator localIterator = paramString.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramString.get(str1);
        if (TextUtils.equals(str1, "open")) {
          qb(Integer.parseInt(str2));
        }
      }
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.d("WormholeConfigHandler", 0, "parse wormhole error: " + paramString.getMessage());
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    qb(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzv
 * JD-Core Version:    0.7.0.1
 */