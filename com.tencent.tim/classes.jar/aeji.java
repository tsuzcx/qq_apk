import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.BootOptimizeConfigureBean.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aeji
{
  public static boolean bUw;
  public long Wh;
  public boolean bUt = true;
  public boolean bUu;
  public boolean bUv;
  
  public static aeji a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aeji localaeji = new aeji();
        paramString = new JSONObject(paramString);
        localaeji.bUt = paramString.optBoolean("useParcelForBoot", true);
        localaeji.Wh = paramString.optLong("delayPluginManageTimeInMills", 0L);
        localaeji.bUu = paramString.optBoolean("enableKernelServiceInVivo", false);
        localaeji.bUv = paramString.optBoolean("disableSimpleBreakStrategy", false);
        bUw = paramString.optBoolean("removeMqqIdleTimeoutMsg", false);
        ThreadManager.getSubThreadHandler().postDelayed(new BootOptimizeConfigureBean.1(), 60000L);
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localaeji.toString());
        return localaeji;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("BootOptimizeConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    return "BootOptimizeConfigureBean{useParcelForBoot=" + this.bUt + ", delayPluginManageTimeInMills=" + this.Wh + ", enableKernelServiceInVivo=" + this.bUu + ", disableSimpleBreakStrategy=" + this.bUv + ", sRemoveMqqIdleTimeoutMsg=" + bUw + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeji
 * JD-Core Version:    0.7.0.1
 */