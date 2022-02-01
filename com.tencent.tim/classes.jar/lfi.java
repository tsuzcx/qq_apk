import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

final class lfi
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return true;
          lfh.access$002(false);
          lfh.access$100().removeMessages(0);
        } while ((lfh.access$200() == null) || (lfh.access$200().size() <= 0));
        paramMessage = lfh.access$200().iterator();
        while (paramMessage.hasNext()) {
          ((lfh.a)paramMessage.next()).ns(true);
        }
        lfh.access$002(false);
        lfh.access$100().removeMessages(1);
      } while ((lfh.access$200() == null) || (lfh.access$200().size() <= 0));
      paramMessage = lfh.access$200().iterator();
      while (paramMessage.hasNext()) {
        ((lfh.a)paramMessage.next()).ns(false);
      }
    }
    lfh.access$002(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfi
 * JD-Core Version:    0.7.0.1
 */