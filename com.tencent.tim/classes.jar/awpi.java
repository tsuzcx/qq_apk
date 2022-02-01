import com.tencent.common.app.BaseApplicationImpl;
import com.weiyun.sdk.Global.HostInterface;
import mqq.app.AppRuntime;

final class awpi
  implements Global.HostInterface
{
  public String getAppName()
  {
    return "mobileqq";
  }
  
  public long getUin()
  {
    return Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()).longValue();
  }
  
  public String getVersionCode()
  {
    return aonc.getVersionCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpi
 * JD-Core Version:    0.7.0.1
 */