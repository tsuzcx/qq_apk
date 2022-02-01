import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

final class ufh
  implements EIPCResultCallback
{
  ufh(tiv paramtiv, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int j = 0;
    int i = j;
    if (paramEIPCResult != null)
    {
      i = j;
      if (paramEIPCResult.data != null) {
        i = paramEIPCResult.data.getInt("action_get_app_type");
      }
    }
    QLog.e("PublicAccountH5AbilityPlugin", 1, "getAppType is " + i);
    if (this.jdField_a_of_type_Tiv != null) {}
    try
    {
      this.jdField_a_of_type_Tiv.a(this.jdField_a_of_type_JavaLangString, new JSONObject().putOpt("app_type", Integer.valueOf(i)).toString());
      return;
    }
    catch (JSONException paramEIPCResult)
    {
      QLog.e("PublicAccountH5AbilityPlugin", 1, paramEIPCResult.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufh
 * JD-Core Version:    0.7.0.1
 */