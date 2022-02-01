import com.tencent.ad.tangram.ipc.AdIPCManager.Callback;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;

class tfj
  implements EIPCResultCallback
{
  tfj(tfi paramtfi, WeakReference paramWeakReference, AdIPCManager.Params paramParams) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    AdIPCManager.Result localResult = new AdIPCManager.Result();
    boolean bool;
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      bool = true;
      localResult.success = bool;
      if (paramEIPCResult == null) {
        break label83;
      }
    }
    label83:
    for (paramEIPCResult = paramEIPCResult.data;; paramEIPCResult = null)
    {
      localResult.bundle = paramEIPCResult;
      if ((this.al != null) && (this.al.get() != null)) {
        ((AdIPCManager.Callback)this.al.get()).onCallback(this.jdField_a_of_type_ComTencentAdTangramIpcAdIPCManager$Params, localResult);
      }
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tfj
 * JD-Core Version:    0.7.0.1
 */