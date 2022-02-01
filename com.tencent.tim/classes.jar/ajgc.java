import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;

public class ajgc
  implements DialogInterface.OnClickListener
{
  public ajgc(MsgBackupTransportFragment paramMsgBackupTransportFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ajee.a().a().exit();
    ajee.a().onDestroy();
    if (this.a.isStart)
    {
      this.a.dwM();
      return;
    }
    this.a.ca(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgc
 * JD-Core Version:    0.7.0.1
 */