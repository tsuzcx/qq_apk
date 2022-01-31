import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;

public class wmd
  implements Runnable
{
  public wmd(ContactsTroopAdapter paramContactsTroopAdapter) {}
  
  public void run()
  {
    ((TroopManager)this.a.a.getManager(51)).a();
    this.a.a.runOnUiThread(new wme(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmd
 * JD-Core Version:    0.7.0.1
 */