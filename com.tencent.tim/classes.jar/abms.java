import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class abms
  implements EIPCResultCallback
{
  abms(abmm paramabmm) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow onDressChanged send!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abms
 * JD-Core Version:    0.7.0.1
 */