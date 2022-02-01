import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class tid
  implements DialogInterface.OnCancelListener
{
  tid(tia paramtia, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", tia.a(this.jdField_a_of_type_Tia));
      paramDialogInterface.put("type", 1);
      if (tia.a(this.jdField_a_of_type_Tia) != null) {
        ((BridgeModule)tia.a(this.jdField_a_of_type_Tia).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tid
 * JD-Core Version:    0.7.0.1
 */