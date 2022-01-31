import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class tyq
  extends Handler
{
  tyq(typ paramtyp, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4097: 
      typ.a(this.a);
      return;
    }
    typ.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyq
 * JD-Core Version:    0.7.0.1
 */