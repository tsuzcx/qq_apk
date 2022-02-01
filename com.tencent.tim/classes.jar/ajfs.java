import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment;

public class ajfs
  implements DialogInterface.OnClickListener
{
  public ajfs(MsgBackupPcBaseFragment paramMsgBackupPcBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ajgv.b("MsgBackup_MsgBackupPcBaseFragment", "showDisConnDialog mextra is not null! %b, isFromPcHandle = %b", new Object[] { Boolean.valueOf(TextUtils.isEmpty(this.a.mExtraData)), Boolean.valueOf(this.a.cnI) });
    ajee.a().a().exit();
    ajee.a().onDestroy();
    if (this.a.isStart) {
      if ((!this.a.cnI) && (this.a.diy == 1)) {
        this.a.ca(this.a.getActivity());
      }
    }
    do
    {
      return;
      this.a.dxd();
      return;
      if (!this.a.cnI) {
        break;
      }
    } while (this.a.getActivity() == null);
    this.a.getActivity().setResult(1001);
    this.a.getActivity().finish();
    return;
    this.a.ca(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfs
 * JD-Core Version:    0.7.0.1
 */