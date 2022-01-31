import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.qphone.base.util.QLog;

public class xyq
  implements Runnable
{
  public xyq(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAddFrdsInnerFrame", 2, "read troop members from database before updating data from server");
    }
    TroopAddFrdsInnerFrame.a(this.a, this.a.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyq
 * JD-Core Version:    0.7.0.1
 */