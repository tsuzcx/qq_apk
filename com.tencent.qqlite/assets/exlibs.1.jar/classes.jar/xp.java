import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardObserver;

public class xp
  extends CardObserver
{
  public xp(AddRequestActivity paramAddRequestActivity) {}
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!AddRequestActivity.a(this.a).equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.a(2130837989, this.a.getString(2131363020));
      return;
    }
    this.a.a(2130837979, this.a.getString(2131363019));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xp
 * JD-Core Version:    0.7.0.1
 */