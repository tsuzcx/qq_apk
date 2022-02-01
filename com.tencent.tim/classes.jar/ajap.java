import android.os.Bundle;
import com.tencent.mobileqq.mediafocus.MediaFocusController;
import com.tencent.mobileqq.mediafocus.MediaFocusController.1;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Stack;

public class ajap
  implements EIPCResultCallback
{
  public ajap(MediaFocusController.1 param1, long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool1;
    boolean bool2;
    long l;
    if (paramEIPCResult.data != null)
    {
      bool1 = paramEIPCResult.data.getBoolean("isProcessRunning");
      bool2 = paramEIPCResult.data.getBoolean("isItemExist");
      l = System.currentTimeMillis() - this.val$startTime;
      if ((!bool1) || (!bool2)) {
        break label75;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MediaFocusController", 2, new Object[] { "notifyFocusChanged not the same process but existed, cost:", Long.valueOf(l) });
      }
    }
    return;
    label75:
    MediaFocusController.a(this.a.this$0).pop();
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusController", 2, new Object[] { "notifyFocusChanged isProcessRun:", Boolean.valueOf(bool1), " ,isItmeExist:", Boolean.valueOf(bool2), " ,stack:", Integer.valueOf(MediaFocusController.a(this.a.this$0).size()), " ,cost:", Long.valueOf(l) });
    }
    MediaFocusController.a(this.a.this$0, this.a.dhH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajap
 * JD-Core Version:    0.7.0.1
 */