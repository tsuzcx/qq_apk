import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.ResultReceiver;
import com.tencent.av.utils.PopupDialogQQSide;

public class jkk
  implements DialogInterface.OnClickListener
{
  public jkk(PopupDialogQQSide paramPopupDialogQQSide, ResultReceiver paramResultReceiver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$resultReceiver != null) {
      this.val$resultReceiver.send(1, this.a.getArguments());
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkk
 * JD-Core Version:    0.7.0.1
 */