import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;

class bnl
  implements Runnable
{
  bnl(bnk parambnk) {}
  
  public void run()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.a.a.app.a(17);
    if (localTroopHandler != null) {
      localTroopHandler.k(this.a.a.a.troopuin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bnl
 * JD-Core Version:    0.7.0.1
 */