import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.app.TroopObserver;

public class erw
  extends TroopObserver
{
  public erw(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  protected void a(boolean paramBoolean)
  {
    new Thread(new erx(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     erw
 * JD-Core Version:    0.7.0.1
 */