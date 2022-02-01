import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class tfl
  implements EIPCResultCallback
{
  tfl(tfi.a parama, AdIPCManager.Params paramParams, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str2 = null;
    String str1;
    if (this.a != null)
    {
      str1 = this.a.getAction();
      if (this.a != null) {
        str2 = this.a.getToProcessName();
      }
      if (paramEIPCResult == null) {
        break label91;
      }
    }
    label91:
    for (boolean bool = paramEIPCResult.isSuccess();; bool = false)
    {
      tkw.i("GdtIPCAdapter", String.format("ClientToServerIPCAsyncModule.onCallback action:%s to:%s success:%b", new Object[] { str1, str2, Boolean.valueOf(bool) }));
      this.b.callbackResult(this.val$callbackId, paramEIPCResult);
      return;
      str1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfl
 * JD-Core Version:    0.7.0.1
 */