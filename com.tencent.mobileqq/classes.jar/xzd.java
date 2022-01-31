import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.qphone.base.util.QLog;

public class xzd
  implements Runnable
{
  public xzd(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "read troop members from database before updating data from server");
    }
    TroopMemberListInnerFrame.a(this.a, this.a.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzd
 * JD-Core Version:    0.7.0.1
 */