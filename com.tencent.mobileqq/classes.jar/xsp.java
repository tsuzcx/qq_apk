import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.NewFlowEditVideoActivity;

public class xsp
  implements DialogInterface.OnClickListener
{
  public xsp(NewFlowEditVideoActivity paramNewFlowEditVideoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    NewFlowEditVideoActivity.b(this.a, true);
    NewFlowEditVideoActivity.b(this.a).setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xsp
 * JD-Core Version:    0.7.0.1
 */