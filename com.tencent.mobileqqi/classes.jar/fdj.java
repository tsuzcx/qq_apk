import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.MQPIntChkHandler;

public class fdj
  implements DialogInterface.OnDismissListener
{
  public fdj(MQPIntChkHandler paramMQPIntChkHandler) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MQPIntChkHandler.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdj
 * JD-Core Version:    0.7.0.1
 */