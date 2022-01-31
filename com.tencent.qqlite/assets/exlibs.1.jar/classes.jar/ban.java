import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class ban
  extends CardObserver
{
  public ban(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
  }
  
  protected void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.a().equals(paramString)) {
      return;
    }
    PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean2);
  }
  
  protected void onSetAllowSeeLoginDays(boolean paramBoolean) {}
  
  protected void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.a().equals(paramString)) {}
    do
    {
      return;
      if (!paramBoolean1) {
        this.a.a(2131364023, 1);
      }
    } while (!paramBoolean2);
    PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ban
 * JD-Core Version:    0.7.0.1
 */