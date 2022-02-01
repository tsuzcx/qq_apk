import android.text.TextUtils;
import com.tencent.mobileqq.vip.KCWraperV2.1;
import dualsim.common.IPhoneInfoBridge;

public class aqvi
  implements IPhoneInfoBridge
{
  public aqvi(KCWraperV2.1 param1) {}
  
  public boolean isAllow(String paramString)
  {
    return !TextUtils.isEmpty(pU(paramString));
  }
  
  public String pU(String paramString)
  {
    if ("imei".equals(paramString)) {
      return auri.getIMEI("a4bd32");
    }
    if ("imsi".equals(paramString)) {
      return auri.ru("a4bd32");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvi
 * JD-Core Version:    0.7.0.1
 */