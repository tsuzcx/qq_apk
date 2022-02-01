import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class tyr
  implements EIPCResultCallback
{
  tyr(tom paramtom, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str2 = "";
    String str1 = str2;
    if (paramEIPCResult != null)
    {
      str1 = str2;
      if (paramEIPCResult.data != null) {
        str1 = paramEIPCResult.data.getString("action_get_user_info");
      }
    }
    QLog.e("PublicAccountH5AbilityPlugin", 1, "getUserInfoIpc is " + str1);
    if (this.jdField_a_of_type_Tom != null) {
      this.jdField_a_of_type_Tom.a(this.jdField_a_of_type_JavaLangString, str1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyr
 * JD-Core Version:    0.7.0.1
 */