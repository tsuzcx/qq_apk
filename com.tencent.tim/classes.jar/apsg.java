import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

class apsg
  extends Handler
{
  apsg(apsf paramapsf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object[] arrayOfObject = (Object[])paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (List)arrayOfObject[0];
      boolean bool = ((Boolean)arrayOfObject[1]).booleanValue();
      String str = (String)arrayOfObject[2];
      long l = ((Long)arrayOfObject[3]).longValue();
      this.c.b(paramMessage, bool, str, l);
      return;
    case 2: 
      paramMessage = (apbr)arrayOfObject[0];
      this.c.q(paramMessage);
      return;
    case 3: 
      paramMessage = (apbr)arrayOfObject[0];
      this.c.r(paramMessage);
      return;
    case 4: 
      paramMessage = (apbr)arrayOfObject[0];
      this.c.s(paramMessage);
      return;
    case 5: 
      int i = paramMessage.arg1;
      this.c.WZ(i);
      return;
    }
    paramMessage = (apbr)arrayOfObject[0];
    this.c.u(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsg
 * JD-Core Version:    0.7.0.1
 */