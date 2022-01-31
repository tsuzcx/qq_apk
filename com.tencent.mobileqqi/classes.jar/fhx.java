import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.MQPIntChkHandler;

public class fhx
  implements DialogInterface.OnDismissListener
{
  public fhx(MQPIntChkHandler paramMQPIntChkHandler) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MQPIntChkHandler.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fhx
 * JD-Core Version:    0.7.0.1
 */