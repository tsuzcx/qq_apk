import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kzs
  extends SimpleConfigHandler
  implements AladdinConfigHandler
{
  public static String TAG = "ViolaPicSerPreloadHandler";
  public static String adT = "viola_service_instance";
  
  public static boolean Bo()
  {
    return ((Boolean)awit.f(adT, Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d(TAG, 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString);
    Map localMap = kye.i(paramString);
    Object localObject = localMap.keySet();
    for (;;)
    {
      try
      {
        localObject = ((Set)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          String str1 = (String)localMap.get(str2);
          if (!TextUtils.equals(str2, "viola_service_instance_open")) {
            continue;
          }
          str2 = adT;
          if (Integer.parseInt(str1) == 1)
          {
            bool = true;
            awit.H(str2, Boolean.valueOf(bool));
          }
        }
        else
        {
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e(TAG, 2, "[onReceiveConfig] id=" + paramInt1 + ", version=" + paramInt2 + ", content=" + paramString + " , error= " + localThrowable.getMessage());
      }
      boolean bool = false;
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    awit.H(adT, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzs
 * JD-Core Version:    0.7.0.1
 */