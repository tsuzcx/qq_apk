import android.os.Handler.Callback;
import android.os.Message;

class ahkj
  implements Handler.Callback
{
  ahkj(ahki paramahki) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.this$0.e != null) && (this.this$0.e.isShowing()) && (this.this$0.a != null)) {
      this.this$0.a.doD();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkj
 * JD-Core Version:    0.7.0.1
 */