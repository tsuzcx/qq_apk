import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.qphone.base.util.QLog;

public class ajps
  extends Handler
{
  public ajps(NearbyFakeActivity paramNearbyFakeActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyFakeActivity", 2, "procPreload time out");
      }
      NearbyFakeActivity.a(this.a, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajps
 * JD-Core Version:    0.7.0.1
 */