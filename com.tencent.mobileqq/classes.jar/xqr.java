import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;

public class xqr
  implements DialogInterface.OnDismissListener
{
  public xqr(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QzDynamicVideoPreviewActivity.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xqr
 * JD-Core Version:    0.7.0.1
 */