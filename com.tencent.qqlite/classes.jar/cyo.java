import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.automator.step.GetGeneralSettings;

public class cyo
  extends FriendListObserver
{
  private cyo(GetGeneralSettings paramGetGeneralSettings) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      GetGeneralSettings.a(this.a).d = 3;
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cyo
 * JD-Core Version:    0.7.0.1
 */