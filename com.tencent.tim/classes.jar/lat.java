import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.Utils.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class lat
{
  public static boolean Bs()
  {
    Object localObject = Aladdin.getConfig(144);
    if (localObject != null)
    {
      localObject = ((AladdinConfig)localObject).getString("dc_switch", "0");
      QLog.d("DynamicChannelUtils", 1, new Object[] { "dcSwitch = ", localObject });
    }
    for (boolean bool = TextUtils.equals((CharSequence)localObject, "1");; bool = false)
    {
      QLog.d("DynamicChannelUtils", 1, new Object[] { "isDynamicChannelSwitchOn = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public static void prepare()
  {
    if (Bs())
    {
      QLog.d("DynamicChannelUtils", 1, "dynamicChannelSwitch is on, prepare it.");
      ThreadManager.getSubThreadHandler().postDelayed(new Utils.1(), 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lat
 * JD-Core Version:    0.7.0.1
 */