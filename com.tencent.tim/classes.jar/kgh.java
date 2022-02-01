import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kgh
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    paramString = kye.i(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("ReadInJoyDropFrameAladdinCfgHandler", 1, new Object[] { "key = ", str1, ", value = ", str2 });
      if (TextUtils.equals("readinjoy_drop_frame_monitor", str1)) {
        awit.H("sp_key_readinjoy_feeds_drop_frame_switch", Boolean.valueOf(TextUtils.equals("1", str2)));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("ReadInJoyDropFrameAladdinCfgHandler", 1, new Object[] { "onWipeConfig, id = ", Integer.valueOf(paramInt) });
    awit.H("sp_key_readinjoy_feeds_drop_frame_switch", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgh
 * JD-Core Version:    0.7.0.1
 */