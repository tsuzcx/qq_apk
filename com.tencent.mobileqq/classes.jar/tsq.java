import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class tsq
  implements AladdinConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("VideoSoftAdConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = pbt.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("VideoSoftAdConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (paramInt1 == 200)
      {
        if ((TextUtils.equals(str1, "ad_guide_area")) && (!TextUtils.isEmpty(str2))) {
          bkwm.a("sp_key_ad_soft_total_area", str2.trim());
        }
        if ((TextUtils.equals(str1, "ad_max_num")) && (!TextUtils.isEmpty(str2))) {
          bkwm.a("sp_key_ad_soft_ad_max", str2.trim());
        }
        if ((TextUtils.equals(str1, "kd_max_num")) && (!TextUtils.isEmpty(str2))) {
          bkwm.a("sp_key_ad_soft_kd_max", str2.trim());
        }
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    if (paramInt == 200)
    {
      bkwm.a("sp_key_ad_soft_total_area", "0");
      bkwm.a("sp_key_ad_soft_ad_max", "25");
      bkwm.a("sp_key_ad_soft_kd_max", "25");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsq
 * JD-Core Version:    0.7.0.1
 */