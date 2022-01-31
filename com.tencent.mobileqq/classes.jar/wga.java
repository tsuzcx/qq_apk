import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;

class wga
  implements DialogInterface.OnDismissListener
{
  wga(wfz paramwfz) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    wcj.a().a(new SharePanelShowStateEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wga
 * JD-Core Version:    0.7.0.1
 */