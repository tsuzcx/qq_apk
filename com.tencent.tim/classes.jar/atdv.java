import android.os.Handler;
import android.os.Message;

class atdv
  extends Handler
{
  atdv(atdt paramatdt) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdv
 * JD-Core Version:    0.7.0.1
 */