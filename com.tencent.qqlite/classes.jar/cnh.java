import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.app.TroopObserver;

public class cnh
  extends TroopObserver
{
  public cnh(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  protected void b(boolean paramBoolean)
  {
    new Thread(new cni(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cnh
 * JD-Core Version:    0.7.0.1
 */