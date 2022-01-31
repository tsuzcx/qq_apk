import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardObserver;

public class buq
  extends CardObserver
{
  public buq(AddRequestActivity paramAddRequestActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!AddRequestActivity.a(this.a).equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      this.a.a(2130837960, this.a.getString(2131562776));
      return;
    }
    this.a.a(2130837949, this.a.getString(2131562773));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     buq
 * JD-Core Version:    0.7.0.1
 */