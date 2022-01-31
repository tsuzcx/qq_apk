import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class evf
  extends TroopObserver
{
  public evf(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    if (paramInt == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member fail");
      }
      this.a.a.sendEmptyMessage(1);
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (paramInt == 8)
    {
      if (paramByte != 0) {
        break label95;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member success");
      }
      this.a.a.sendEmptyMessage(0);
      if (!SelectMemberActivity.a(this.a))
      {
        paramInt = this.a.a();
        this.a.a(paramInt + 1);
        ReportController.b(this.a.b, "CliOper", "", "", "Grp", "Send_invite", 0, 0, "", "", "", "");
      }
    }
    return;
    label95:
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add troop member fail, troopUin: " + paramString + " result: " + paramByte);
    }
    paramString = null;
    if (paramByte == 7) {
      paramString = this.a.getString(2131561460);
    }
    this.a.a.obtainMessage(1, paramString).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evf
 * JD-Core Version:    0.7.0.1
 */