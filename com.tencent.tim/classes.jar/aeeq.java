import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aeeq
  implements EIPCResultCallback
{
  aeeq(aeep paramaeep) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.d("DanmuDataIPCClient", 1, new Object[] { "get barrage list, IPC success, msgSeq:", Long.valueOf(paramEIPCResult.data.getLong("key_barrage_msg_seq")) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeeq
 * JD-Core Version:    0.7.0.1
 */