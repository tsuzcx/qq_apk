import UserGrowth.eConfigBit;
import UserGrowth.stUserConfigReq;
import UserGrowth.stUserConfigRsp;
import android.support.annotation.NonNull;

public class ooc
  extends okw<stUserConfigRsp>
{
  public ooc(@NonNull eConfigBit parameConfigBit)
  {
    super("UserConfig");
    stUserConfigReq localstUserConfigReq = new stUserConfigReq();
    localstUserConfigReq.config_set = parameConfigBit.value();
    this.req = localstUserConfigReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ooc
 * JD-Core Version:    0.7.0.1
 */