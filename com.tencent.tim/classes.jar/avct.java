import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class avct
  implements EIPCResultCallback
{
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.isSuccess()) {
      avcs.ZH(paramEIPCResult.data.getString("config_json"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avct
 * JD-Core Version:    0.7.0.1
 */