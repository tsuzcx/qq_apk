import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Queue;

class acma
  extends Handler
{
  acma(acly paramacly, Looper paramLooper)
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
    paramMessage = (acly.b)paramMessage.obj;
    this.this$0.E.remove(paramMessage);
    paramMessage.S.startActivity(paramMessage.intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acma
 * JD-Core Version:    0.7.0.1
 */