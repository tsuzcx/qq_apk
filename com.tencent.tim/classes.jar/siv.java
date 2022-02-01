import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;

class siv
  implements DialogInterface.OnDismissListener
{
  siv(siu paramsiu) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    rwv.a().a(new SharePanelShowStateEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     siv
 * JD-Core Version:    0.7.0.1
 */