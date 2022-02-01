import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class tmw
  implements DialogInterface.OnCancelListener
{
  tmw(tmt paramtmt, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("index", tmt.a(this.jdField_a_of_type_Tmt));
      paramDialogInterface.put("type", 1);
      if (tmt.a(this.jdField_a_of_type_Tmt) != null) {
        ((BridgeModule)tmt.a(this.jdField_a_of_type_Tmt).get()).invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      }
      return;
    }
    catch (JSONException paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tmw
 * JD-Core Version:    0.7.0.1
 */