import android.view.View;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.qphone.base.util.QLog;

public class ajfz
  implements arkn
{
  public ajfz(MsgBackupTransportFragment paramMsgBackupTransportFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      MsgBackupTransportFragment.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "transfer is going, page is in link page! click cancel btn! sIsShouQiBtnClick= " + ajee.cnG + ", isStart = " + this.a.isStart);
      }
      if (MsgBackupTransportFragment.a(this.a) == 2)
      {
        if (!this.a.cnU) {
          break label129;
        }
        ajgt.cN("0X800A243", 2);
      }
      while (this.a.isStart)
      {
        this.a.dwZ();
        return;
        label129:
        ajgt.cN("0X800A243", 1);
      }
      if (MsgBackupTransportFragment.a(this.a) == 1)
      {
        this.a.onBackEvent();
        return;
      }
      this.a.ca(this.a.getActivity());
      return;
    }
    ajee.cnG = true;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "transfer is going, page is in link page! click 收起按钮! sIsShouQiBtnClick= " + ajee.cnG + ", curSpeed = " + this.a.ach + ", hasFinishedCount = " + this.a.diq);
    }
    ajee.a().a(this.a.ach, this.a.diq, 3, this.a.getActivity());
    ajgt.report("0X800A249");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfz
 * JD-Core Version:    0.7.0.1
 */