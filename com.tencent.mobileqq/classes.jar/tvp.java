import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class tvp
  implements DialogInterface.OnCancelListener
{
  tvp(tvm paramtvm, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", tvm.a(this.jdField_a_of_type_Tvm));
      paramDialogInterface.put("type", 1);
      if (tvm.a(this.jdField_a_of_type_Tvm) != null) {
        ((BridgeModule)tvm.a(this.jdField_a_of_type_Tvm).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tvp
 * JD-Core Version:    0.7.0.1
 */