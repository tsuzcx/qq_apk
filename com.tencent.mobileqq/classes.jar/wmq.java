import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class wmq
  extends ConfigObserver
{
  public wmq(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    MainAssistObserver.a(this.a, paramUpgradeDetailWrapper);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmq
 * JD-Core Version:    0.7.0.1
 */