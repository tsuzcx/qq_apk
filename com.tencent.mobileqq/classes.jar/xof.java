import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class xof
  implements DialogInterface.OnClickListener
{
  public xof(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    EditLocalVideoActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xof
 * JD-Core Version:    0.7.0.1
 */