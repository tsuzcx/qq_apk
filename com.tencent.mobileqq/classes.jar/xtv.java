import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class xtv
  implements DialogInterface.OnClickListener
{
  public xtv(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QzDynamicVideoPreviewActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtv
 * JD-Core Version:    0.7.0.1
 */