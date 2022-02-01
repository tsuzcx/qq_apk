import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment;

public class ajft
  implements DialogInterface.OnClickListener
{
  public ajft(MsgBackupPcBaseFragment paramMsgBackupPcBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ajgv.b("MsgBackup_MsgBackupPcBaseFragment", "showStopMigrateDialog mextra is not null! %b, isFromPcHandle = %b", new Object[] { Boolean.valueOf(TextUtils.isEmpty(this.a.mExtraData)), Boolean.valueOf(this.a.cnI) });
    ajee.a().a().exit();
    ajee.a().a().b(null);
    if (this.a.isStart) {
      if ((!this.a.cnI) && (this.a.diy == 1))
      {
        this.a.ca(this.a.getActivity());
        if (!this.a.cod)
        {
          if (this.a.diy != 1) {
            break label189;
          }
          if (this.a.cnI) {
            ajgt.cN("0X800A267", 2);
          }
        }
        label141:
        if (this.a.cod)
        {
          if (this.a.diy != 1) {
            break label309;
          }
          if (this.a.cnI) {
            ajgt.cN("0X800A267", 3);
          }
        }
      }
    }
    label189:
    while (this.a.diy != 2)
    {
      return;
      this.a.dxd();
      break;
      if (this.a.diy != 2) {
        break label141;
      }
      ajgt.cN("0X800A289", 1);
      break label141;
      if (this.a.cnI) {
        if (this.a.getActivity() != null)
        {
          this.a.getActivity().setResult(1001);
          this.a.getActivity().finish();
        }
      }
      for (;;)
      {
        if ((this.a.cod) || (this.a.diy != 1) || (!this.a.cnI)) {
          break label307;
        }
        ajgt.cN("0X800A267", 1);
        break;
        this.a.ca(this.a.getActivity());
      }
      break label141;
    }
    label307:
    label309:
    ajgt.cN("0X800A289", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajft
 * JD-Core Version:    0.7.0.1
 */