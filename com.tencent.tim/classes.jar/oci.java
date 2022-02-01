import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class oci
  implements EIPCResultCallback
{
  oci(obw paramobw, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data != null)
    {
      paramEIPCResult = paramEIPCResult.data.getString("action_update_biu_and_comment_request_string");
      this.this$0.callJs(this.val$callback, new String[] { paramEIPCResult });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oci
 * JD-Core Version:    0.7.0.1
 */