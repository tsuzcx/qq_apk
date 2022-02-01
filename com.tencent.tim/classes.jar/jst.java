import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class jst
  extends Handler
{
  jst(jss paramjss, Looper paramLooper)
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
    this.b.aby = true;
    jss.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jst
 * JD-Core Version:    0.7.0.1
 */