import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class myk
  implements Handler.Callback
{
  myk(myj parammyj) {}
  
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
          myj.a(this.this$0, false);
          myj.a(this.this$0).removeMessages(0);
        } while (myj.a(this.this$0) == null);
        myj.a(this.this$0).ns(true);
        return true;
        myj.a(this.this$0, false);
        myj.a(this.this$0).removeMessages(1);
      } while (myj.a(this.this$0) == null);
      myj.a(this.this$0).ns(false);
      return true;
    }
    myj.a(this.this$0, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myk
 * JD-Core Version:    0.7.0.1
 */