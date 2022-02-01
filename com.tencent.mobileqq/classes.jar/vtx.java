import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class vtx
  extends Handler
{
  vtx(vtw paramvtw, Looper paramLooper)
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
      vtw.a(this.a);
      return;
    }
    vtw.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtx
 * JD-Core Version:    0.7.0.1
 */