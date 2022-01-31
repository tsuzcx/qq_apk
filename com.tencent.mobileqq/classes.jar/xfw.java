import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class xfw
  implements EIPCResultCallback
{
  public xfw(PreloadManagerProxy paramPreloadManagerProxy, ResultReceiver paramResultReceiver) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramEIPCResult.data);
      return;
    }
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfw
 * JD-Core Version:    0.7.0.1
 */