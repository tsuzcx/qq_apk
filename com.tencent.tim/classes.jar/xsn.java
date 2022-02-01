import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class xsn
  implements EIPCResultCallback
{
  xsn(xsk paramxsk) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      xsk.r(this.this$0).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xsn
 * JD-Core Version:    0.7.0.1
 */