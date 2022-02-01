import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class utr
  implements EIPCResultCallback
{
  utr(uta paramuta, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data != null)
    {
      paramEIPCResult = paramEIPCResult.data.getString("action_update_biu_and_comment_request_string");
      this.jdField_a_of_type_Uta.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramEIPCResult });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utr
 * JD-Core Version:    0.7.0.1
 */