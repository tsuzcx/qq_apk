import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;

public class etq
  extends Handler
{
  public etq(VoipDialInterface paramVoipDialInterface) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    VoipDialInterface.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     etq
 * JD-Core Version:    0.7.0.1
 */