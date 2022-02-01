import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class urn
  extends Handler
{
  private url a;
  
  urn(Looper paramLooper, url paramurl)
  {
    super(paramLooper);
    this.a = paramurl;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      url.a(this.a);
      return;
    }
    url.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urn
 * JD-Core Version:    0.7.0.1
 */