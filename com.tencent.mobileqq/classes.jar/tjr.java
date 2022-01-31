import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.contacts.base.CardConfigManager;

public class tjr
  implements Runnable
{
  public tjr(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void run()
  {
    CardConfigManager localCardConfigManager = new CardConfigManager(this.a.app);
    PermisionPrivacyActivity.a(this.a, localCardConfigManager.a());
    this.a.runOnUiThread(new tjs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tjr
 * JD-Core Version:    0.7.0.1
 */