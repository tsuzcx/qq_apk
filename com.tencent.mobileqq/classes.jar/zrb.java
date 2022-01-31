import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.step.GetTbsSwitchInfo;
import com.tencent.smtt.sdk.QbSdk;

public class zrb
  implements Runnable
{
  public zrb(GetTbsSwitchInfo paramGetTbsSwitchInfo) {}
  
  public void run()
  {
    QbSdk.isX5DisabledSync(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zrb
 * JD-Core Version:    0.7.0.1
 */