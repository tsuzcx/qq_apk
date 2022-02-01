import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;

public class zod
  implements DialogInterface.OnCancelListener
{
  public zod(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    MiniMsgTabFragment.a(this.this$0, -1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zod
 * JD-Core Version:    0.7.0.1
 */