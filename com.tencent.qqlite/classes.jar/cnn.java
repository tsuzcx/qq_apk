import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.app.TroopObserver;

public class cnn
  extends TroopObserver
{
  public cnn(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  protected void b(boolean paramBoolean)
  {
    new Thread(new cno(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cnn
 * JD-Core Version:    0.7.0.1
 */