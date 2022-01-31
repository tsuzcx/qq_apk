import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;

class wvb
  implements DialogInterface.OnDismissListener
{
  wvb(wva paramwva) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    wpw.a().a(new SharePanelShowStateEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wvb
 * JD-Core Version:    0.7.0.1
 */