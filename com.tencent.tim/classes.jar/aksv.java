import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;

public class aksv
  implements DialogInterface.OnClickListener
{
  public aksv(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.this$0.getActivity().isFinishing()) {
      this.this$0.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksv
 * JD-Core Version:    0.7.0.1
 */