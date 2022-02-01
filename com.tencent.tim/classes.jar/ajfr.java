import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment;
import com.tencent.qphone.base.util.QLog;

public class ajfr
  implements arkn
{
  public ajfr(MsgBackupPCTransportFragment paramMsgBackupPCTransportFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    int i = ajdt.a().Gi();
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "page is in pc Link page! click cancel! bizType = " + i + ", pcHandler = " + this.a.cnI);
      }
      this.a.dwZ();
      return;
      ajee.cnG = true;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "backup is going, page is in link page! click 收起按钮! sIsShouQiBtnClick= " + ajee.cnG + ", curSpeed = " + this.a.ach + ", hasFinishedCount = " + this.a.diq);
      }
      ajee.a().a().b(null);
      ajee.a().a(this.a.ach, this.a.diq, i, this.a.getActivity());
      if (this.a.diy != 1) {
        break;
      }
    } while (!this.a.cnI);
    ajgt.report("0X800A260");
    return;
    ajgt.report("0X800A284");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfr
 * JD-Core Version:    0.7.0.1
 */