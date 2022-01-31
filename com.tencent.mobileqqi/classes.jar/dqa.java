import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;

class dqa
  implements Runnable
{
  dqa(dpz paramdpz) {}
  
  public void run()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.a.a.b.a(19);
    if (localTroopHandler != null) {
      localTroopHandler.k(this.a.a.a.troopuin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqa
 * JD-Core Version:    0.7.0.1
 */