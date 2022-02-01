import android.app.Activity;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class amek
  implements EIPCResultCallback
{
  amek(amea paramamea) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (-102 == paramEIPCResult.code) {
      this.this$0.mContext.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amek
 * JD-Core Version:    0.7.0.1
 */