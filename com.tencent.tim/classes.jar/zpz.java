import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;

public class zpz
  implements DialogInterface.OnClickListener
{
  public zpz(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.report("dc00898", "0X8009F15", 0);
    paramDialogInterface.dismiss();
    BindNumberActivity.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpz
 * JD-Core Version:    0.7.0.1
 */