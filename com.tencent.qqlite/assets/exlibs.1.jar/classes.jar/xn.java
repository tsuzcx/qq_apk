import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardObserver;

public class xn
  extends CardObserver
{
  public xn(AddRequestActivity paramAddRequestActivity) {}
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!AddRequestActivity.a(this.a).equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.a(2130837985, this.a.getString(2131363024));
      return;
    }
    this.a.a(2130837975, this.a.getString(2131363023));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xn
 * JD-Core Version:    0.7.0.1
 */