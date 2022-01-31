import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;

class yjr
  implements DialogInterface.OnDismissListener
{
  yjr(yjq paramyjq) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    yej.a().a(new SharePanelShowStateEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yjr
 * JD-Core Version:    0.7.0.1
 */