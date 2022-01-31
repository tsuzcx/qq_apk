import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.CardObserver;

public class bbi
  extends CardObserver
{
  public bbi(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.a.equals(paramString)) {
      return;
    }
    this.a.h();
    if (paramBoolean)
    {
      this.a.a(2131363020, 2);
      return;
    }
    this.a.a(2131363019, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bbi
 * JD-Core Version:    0.7.0.1
 */