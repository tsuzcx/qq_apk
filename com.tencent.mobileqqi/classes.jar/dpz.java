import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;

class dpz
  implements Runnable
{
  dpz(dpy paramdpy) {}
  
  public void run()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.a.a.b.a(19);
    if (localTroopHandler != null) {
      localTroopHandler.k(this.a.a.a.troopuin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpz
 * JD-Core Version:    0.7.0.1
 */