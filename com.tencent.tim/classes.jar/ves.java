import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.KeepAliveGuideActivity;

public class ves
  implements DialogInterface.OnClickListener
{
  public ves(KeepAliveGuideActivity paramKeepAliveGuideActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ves
 * JD-Core Version:    0.7.0.1
 */