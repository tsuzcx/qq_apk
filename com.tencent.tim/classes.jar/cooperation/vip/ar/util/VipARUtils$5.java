package cooperation.vip.ar.util;

import android.text.TextUtils;
import anol;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Properties;

public final class VipARUtils$5
  implements Runnable
{
  public VipARUtils$5(String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VipARUtils", 2, "reportMta matId = " + this.CF + " mtaKey = " + this.CD + " mtaValue = " + this.CE);
    }
    try
    {
      if ((this.CE != null) && (!TextUtils.isEmpty(this.CE)))
      {
        Properties localProperties = new Properties();
        localProperties.put(this.CD, this.CE);
        anol.a(BaseApplicationImpl.getContext()).reportTimeKVEvent(this.CF, localProperties, this.AW);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.ar.util.VipARUtils.5
 * JD-Core Version:    0.7.0.1
 */