import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;

class zlw
  implements DialogInterface.OnDismissListener
{
  zlw(zlv paramzlv) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    SimpleEventBus.getInstance().dispatchEvent(new SharePanelShowStateEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlw
 * JD-Core Version:    0.7.0.1
 */