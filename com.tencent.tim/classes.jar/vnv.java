import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.QQIdentiferActivity;

public class vnv
  implements DialogInterface.OnClickListener
{
  public vnv(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnv
 * JD-Core Version:    0.7.0.1
 */