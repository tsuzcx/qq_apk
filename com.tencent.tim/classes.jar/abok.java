import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class abok
  implements EIPCResultCallback
{
  abok(long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("respData");
    abmt.a().callbackFromRequest(this.Od, 0, "cs.on_get_open_key.local", paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abok
 * JD-Core Version:    0.7.0.1
 */