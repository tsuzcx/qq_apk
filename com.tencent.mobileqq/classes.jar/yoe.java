import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;

class yoe
  implements DialogInterface.OnDismissListener
{
  yoe(yod paramyod) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    yiw.a().a(new SharePanelShowStateEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yoe
 * JD-Core Version:    0.7.0.1
 */