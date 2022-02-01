import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;

public class nva
  implements DialogInterface.OnDismissListener
{
  public nva(BridgeModule paramBridgeModule) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!BridgeModule.access$400(this.this$0)) {}
    BridgeModule.access$402(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nva
 * JD-Core Version:    0.7.0.1
 */