import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class anqc
  implements EIPCResultCallback
{
  anqc(anqb paramanqb) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitor", 2, new Object[] { "eipcResult=", Integer.valueOf(paramEIPCResult.code), paramEIPCResult.data });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     anqc
 * JD-Core Version:    0.7.0.1
 */