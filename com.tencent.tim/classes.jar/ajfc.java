import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment;

public class ajfc
  implements DialogInterface.OnClickListener
{
  public ajfc(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.getActivity() != null)
    {
      this.this$0.getActivity().setResult(1001);
      this.this$0.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfc
 * JD-Core Version:    0.7.0.1
 */