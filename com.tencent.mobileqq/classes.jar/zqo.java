import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.device.file.DeviceFileHandler;

public class zqo
  extends Handler
{
  public zqo(DeviceFileHandler paramDeviceFileHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.notifyUI(103, true, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zqo
 * JD-Core Version:    0.7.0.1
 */