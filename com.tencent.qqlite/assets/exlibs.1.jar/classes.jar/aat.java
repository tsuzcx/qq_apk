import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

public class aat
  implements DialogInterface.OnClickListener
{
  public aat(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.b != null) && (this.a.b.isShowing())) {
      this.a.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aat
 * JD-Core Version:    0.7.0.1
 */