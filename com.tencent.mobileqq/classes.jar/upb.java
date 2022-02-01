import UserGrowth.eConfigBit;
import UserGrowth.stUserConfigReq;
import UserGrowth.stUserConfigRsp;
import android.support.annotation.NonNull;

public class upb
  extends ukl<stUserConfigRsp>
{
  public upb(@NonNull eConfigBit parameConfigBit)
  {
    super("UserConfig", 10005);
    stUserConfigReq localstUserConfigReq = new stUserConfigReq();
    localstUserConfigReq.config_set = parameConfigBit.value();
    this.a = localstUserConfigReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upb
 * JD-Core Version:    0.7.0.1
 */