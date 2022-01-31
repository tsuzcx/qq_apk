import android.os.Handler;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qphone.base.util.QLog;

public class drt
  implements Runnable
{
  public drt(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void run()
  {
    if ((this.a.h == 1) || (this.a.h == 2)) {}
    for (Object[] arrayOfObject = this.a.a(TroopMemberListActivity.a(this.a));; arrayOfObject = this.a.b(TroopMemberListActivity.a(this.a)))
    {
      this.a.a.sendMessage(this.a.a.obtainMessage(1, arrayOfObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivity", 2, "read troop members from database before updating data from server");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     drt
 * JD-Core Version:    0.7.0.1
 */