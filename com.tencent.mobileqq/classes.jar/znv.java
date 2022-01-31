import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.step.GetTbsSwitchInfo;
import com.tencent.smtt.sdk.QbSdk;

public class znv
  implements Runnable
{
  public znv(GetTbsSwitchInfo paramGetTbsSwitchInfo) {}
  
  public void run()
  {
    QbSdk.isX5DisabledSync(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znv
 * JD-Core Version:    0.7.0.1
 */