import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;

public class ajga
  implements DialogInterface.OnClickListener
{
  public ajga(MsgBackupTransportFragment paramMsgBackupTransportFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = ajgp.b().getRole();
    if (1 == paramInt)
    {
      this.a.dxk();
      if (this.a.isStart) {
        ajgt.cN("0X800A253", 3);
      }
    }
    while (2 != paramInt)
    {
      return;
      ajgt.cN("0X800A253", 1);
      return;
    }
    if (this.a.cnU) {
      ajgt.cN("0X800A244", 2);
    }
    for (;;)
    {
      this.a.dxk();
      return;
      ajgt.cN("0X800A244", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajga
 * JD-Core Version:    0.7.0.1
 */