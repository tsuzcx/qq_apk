import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class nux
  implements DialogInterface.OnDismissListener
{
  public nux(BridgeModule paramBridgeModule, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("type", -1);
      paramDialogInterface.put("action", "close");
      if (!TextUtils.isEmpty(this.val$callback)) {
        this.this$0.invokeCallJS(this.val$callback, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      QLog.e(BridgeModule.TAG, 2, QLog.getStackTraceString(paramDialogInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nux
 * JD-Core Version:    0.7.0.1
 */