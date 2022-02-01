import android.os.Bundle;
import eipc.EIPCResult;

class abmn
  implements kqh.a
{
  abmn(abmm paramabmm, int paramInt) {}
  
  public void N(int paramInt)
  {
    abmm.sIsDownLoadingSo = false;
    if (paramInt == 1)
    {
      EIPCResult localEIPCResult = EIPCResult.createResult(0, new Bundle());
      this.this$0.callbackResult(this.val$callbackId, localEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmn
 * JD-Core Version:    0.7.0.1
 */