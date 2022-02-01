import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class uub
  implements DialogInterface.OnClickListener
{
  public uub(DialogActivity paramDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.this$0.app.a();
    paramDialogInterface.dWs();
    paramDialogInterface.dWr();
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uub
 * JD-Core Version:    0.7.0.1
 */