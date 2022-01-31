import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;

class yde
  extends Handler
{
  yde(ydd paramydd, Looper paramLooper)
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
    VipSpecialCareHandler.a(this.a.a, "-->request timeout");
    VipSpecialCareHandler.a(this.a.a, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yde
 * JD-Core Version:    0.7.0.1
 */