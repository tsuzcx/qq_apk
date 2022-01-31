import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;

public class cet
  implements Runnable
{
  public cet(TroopActivity paramTroopActivity) {}
  
  public void run()
  {
    if (TroopActivity.a(this.a) != null) {
      TroopActivity.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cet
 * JD-Core Version:    0.7.0.1
 */