import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;

public class elr
  implements Runnable
{
  public elr(TroopActivity paramTroopActivity) {}
  
  public void run()
  {
    if (TroopActivity.a(this.a) != null) {
      TroopActivity.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     elr
 * JD-Core Version:    0.7.0.1
 */