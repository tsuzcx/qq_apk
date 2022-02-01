import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ahga
  implements EIPCResultCallback
{
  ahga(ahfz paramahfz) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (!paramEIPCResult.isSuccess())
    {
      QLog.d("QFlutter.launcher", 1, "install IPC fail");
      ahfu.unregister();
      ahfz.a(this.this$0, 1, true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahga
 * JD-Core Version:    0.7.0.1
 */