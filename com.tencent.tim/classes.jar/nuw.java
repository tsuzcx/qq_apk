import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;

public class nuw
  implements DialogInterface.OnCancelListener
{
  public nuw(BridgeModule paramBridgeModule, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if ((this.val$pageType == 4) || (this.val$pageType == 11)) {
      BridgeModule.access$100(this.this$0, this.Vw, this.val$vid, this.val$source, -1, -1, true, this.val$pageType, this.aor, this.XS, this.aos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nuw
 * JD-Core Version:    0.7.0.1
 */