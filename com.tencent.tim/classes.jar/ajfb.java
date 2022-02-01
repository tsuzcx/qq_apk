import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment;

public class ajfb
  implements DialogInterface.OnClickListener
{
  public ajfb(MsgBackupBaseFragment paramMsgBackupBaseFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.this$0.diy == 2) {
      MsgBackupCompleteFragment.p(this.this$0.getActivity(), this.this$0.mTotalCount, this.this$0.diq);
    }
    while (this.this$0.diy != 3) {
      return;
    }
    MsgBackupCompleteFragment.v(this.this$0.getActivity(), this.this$0.mTotalCount, this.this$0.diq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajfb
 * JD-Core Version:    0.7.0.1
 */