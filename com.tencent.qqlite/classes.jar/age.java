import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.app.CardObserver;

public class age
  extends CardObserver
{
  private age(Contacts paramContacts) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.a)) {
      this.a.a(1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     age
 * JD-Core Version:    0.7.0.1
 */