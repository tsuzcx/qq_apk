import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class olk
  implements Handler.Callback
{
  olk(olj paramolj) {}
  
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
          olj.a(this.this$0, false);
          olj.a(this.this$0).removeMessages(0);
        } while (olj.a(this.this$0) == null);
        olj.a(this.this$0).ns(true);
        return true;
        olj.a(this.this$0, false);
        olj.a(this.this$0).removeMessages(1);
      } while (olj.a(this.this$0) == null);
      olj.a(this.this$0).ns(false);
      return true;
    }
    olj.a(this.this$0, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     olk
 * JD-Core Version:    0.7.0.1
 */