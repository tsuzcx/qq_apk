import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class txf
  implements DialogInterface.OnClickListener
{
  txf(JSONObject paramJSONObject, BridgeModule paramBridgeModule, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("button", 1);
      paramDialogInterface.put("buttonText", this.jdField_a_of_type_OrgJsonJSONObject.optString("okBtnText", ""));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, paramDialogInterface);
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BridgeModuleHelper", 2, "showDialog error" + paramDialogInterface.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     txf
 * JD-Core Version:    0.7.0.1
 */