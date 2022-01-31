import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.CardObserver;

public class dai
  extends CardObserver
{
  public dai(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.a.equals(paramString)) {
      return;
    }
    this.a.h();
    if (paramBoolean)
    {
      this.a.a(2131562776, 2);
      return;
    }
    this.a.a(2131562773, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dai
 * JD-Core Version:    0.7.0.1
 */