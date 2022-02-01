import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.qphone.base.util.QLog;

public class zrx
  extends Handler
{
  public zrx(PhotoCropActivity paramPhotoCropActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.b.bPq();
      this.b.handler.sendMessageDelayed(Message.obtain(this.b.handler, 1003), 10000L);
      return;
    } while (this.b.isFinishing());
    if (QLog.isColorLevel()) {
      QLog.d("PhotoCropActivity", 2, "LOADING_TIMEOUT");
    }
    PhotoCropActivity.a(this.b, 2131717357);
    this.b.bPr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zrx
 * JD-Core Version:    0.7.0.1
 */