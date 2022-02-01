import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class afdr
  extends Handler
{
  afdr(afdp paramafdp, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (afdp.c(this.this$0));
    QLog.e("VoiceInputHelper", 1, "checkPermission uncertain");
    this.this$0.onGetError(1830002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdr
 * JD-Core Version:    0.7.0.1
 */