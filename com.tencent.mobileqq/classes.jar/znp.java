import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.automator.step.GetGeneralSettings;

public class znp
  extends FriendListObserver
{
  private znp(GetGeneralSettings paramGetGeneralSettings) {}
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      GetGeneralSettings.a(this.a).a = 3;
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znp
 * JD-Core Version:    0.7.0.1
 */