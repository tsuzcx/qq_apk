import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class aaw
  implements Runnable
{
  public aaw(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ((FriendsManagerImp)this.a.a.getManager(8)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aaw
 * JD-Core Version:    0.7.0.1
 */