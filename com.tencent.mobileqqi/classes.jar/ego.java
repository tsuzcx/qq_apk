import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;

public class ego
  implements Runnable
{
  public ego(TroopActivity paramTroopActivity) {}
  
  public void run()
  {
    if (TroopActivity.a(this.a) != null) {
      TroopActivity.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ego
 * JD-Core Version:    0.7.0.1
 */