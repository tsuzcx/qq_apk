import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;

class ygl
  extends Handler
{
  ygl(ygk paramygk, Looper paramLooper)
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
 * Qualified Name:     ygl
 * JD-Core Version:    0.7.0.1
 */