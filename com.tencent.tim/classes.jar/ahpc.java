import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.TroopRobotFragment;
import com.tencent.mobileqq.fragment.TroopRobotFragment.1.1;
import com.tencent.qphone.base.util.QLog;

public class ahpc
  extends acnd
{
  public ahpc(TroopRobotFragment paramTroopRobotFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, aptu paramaptu)
  {
    String str = String.valueOf(paramLong);
    if ((str != null) && (str.equals(TroopRobotFragment.a(this.this$0))))
    {
      if ((paramBoolean) && (paramaptu != null) && (this.this$0.getActivity() != null))
      {
        QLog.d("TroopRobotFragment", 2, "onGetAllRobots");
        this.this$0.getActivity().runOnUiThread(new TroopRobotFragment.1.1(this, paramaptu));
        return;
      }
      QLog.e("TroopRobotFragment", 2, "onGetAllRobots err " + paramInt + " :" + paramLong);
      TroopRobotFragment.a(this.this$0, paramLong);
      return;
    }
    QLog.i("TroopRobotFragment", 2, "onGetAllRobots  net troopuin" + paramLong + " cur " + TroopRobotFragment.a(this.this$0));
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((str != null) && (str.equals(TroopRobotFragment.a(this.this$0))))
    {
      TroopRobotFragment.a(this.this$0, paramLong1);
      return;
    }
    QLog.i("TroopRobotFragment", 2, "onAddRobot  net troopuin" + paramLong1 + " cur " + TroopRobotFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahpc
 * JD-Core Version:    0.7.0.1
 */