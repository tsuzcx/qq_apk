import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;

public class txu
  implements Runnable
{
  public txu(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void run()
  {
    ((TroopHandler)this.a.app.a(20)).a(this.a.b, this.a.i, this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     txu
 * JD-Core Version:    0.7.0.1
 */