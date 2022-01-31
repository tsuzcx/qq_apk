import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.qphone.base.util.QLog;

public class ewk
  implements Runnable
{
  public ewk(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListInnerFrame", 2, "read troop members from database before updating data from server");
    }
    Object localObject = TroopMemberListInnerFrame.a(this.a, this.a.b);
    localObject = this.a.a.obtainMessage(1, localObject);
    this.a.a.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewk
 * JD-Core Version:    0.7.0.1
 */