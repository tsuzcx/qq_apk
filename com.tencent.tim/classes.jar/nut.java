import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class nut
  implements DialogInterface.OnCancelListener
{
  nut(nuq paramnuq, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", nuq.a(this.this$0));
      paramDialogInterface.put("type", 1);
      if (nuq.a(this.this$0) != null) {
        ((BridgeModule)nuq.a(this.this$0).get()).invokeCallJS(this.val$callback, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nut
 * JD-Core Version:    0.7.0.1
 */