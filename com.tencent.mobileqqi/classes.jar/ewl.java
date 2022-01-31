import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.app.TroopObserver;

public class ewl
  extends TroopObserver
{
  public ewl(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  protected void a(boolean paramBoolean)
  {
    new Thread(new ewm(this)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewl
 * JD-Core Version:    0.7.0.1
 */