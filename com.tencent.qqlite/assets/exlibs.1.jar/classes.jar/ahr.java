import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class ahr
  implements Runnable
{
  public ahr(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.app.getManager(43)).b(this.a.app.a());
    this.a.app.runOnUiThread(new ahs(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ahr
 * JD-Core Version:    0.7.0.1
 */