import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class adou
  implements EIPCResultCallback
{
  adou(adot paramadot, adot.f paramf) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    if (paramEIPCResult.code != 0) {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.async, method=" + this.a.getMethod() + " result=" + paramEIPCResult);
    }
    adot.f localf = this.a;
    if (paramEIPCResult.code == 0) {}
    for (;;)
    {
      localf.I(bool, paramEIPCResult.data);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adou
 * JD-Core Version:    0.7.0.1
 */