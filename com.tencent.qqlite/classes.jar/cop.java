import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.app.TroopObserver;

public class cop
  extends TroopObserver
{
  public cop(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  protected void b(boolean paramBoolean)
  {
    new Thread(new coq(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cop
 * JD-Core Version:    0.7.0.1
 */