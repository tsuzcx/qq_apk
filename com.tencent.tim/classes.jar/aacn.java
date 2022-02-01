import android.os.ResultReceiver;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aacn
  implements EIPCResultCallback
{
  aacn(aacm paramaacm, ResultReceiver paramResultReceiver) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      this.i.send(0, paramEIPCResult.data);
      return;
    }
    this.i.send(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aacn
 * JD-Core Version:    0.7.0.1
 */