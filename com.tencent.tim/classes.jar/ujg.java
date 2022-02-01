import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

public class ujg
  implements DialogInterface.OnClickListener
{
  public ujg(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.this$0.C != null) && (this.this$0.C.isShowing())) {
      this.this$0.C.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ujg
 * JD-Core Version:    0.7.0.1
 */