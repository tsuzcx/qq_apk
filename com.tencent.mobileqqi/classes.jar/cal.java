import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardObserver;

public class cal
  extends CardObserver
{
  public cal(AddRequestActivity paramAddRequestActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!AddRequestActivity.a(this.a).equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.a(2130837958, this.a.getString(2131562776));
      return;
    }
    this.a.a(2130837947, this.a.getString(2131562773));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cal
 * JD-Core Version:    0.7.0.1
 */