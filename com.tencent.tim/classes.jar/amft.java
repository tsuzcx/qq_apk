import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class amft
  implements DialogInterface.OnClickListener
{
  public amft(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SignTextEditFragment.a(this.a, "");
    paramDialogInterface.dismiss();
    this.a.mSubHandler.obtainMessage(6, null).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amft
 * JD-Core Version:    0.7.0.1
 */