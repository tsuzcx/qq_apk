package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class gu
  extends Handler
{
  gu(da paramda, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    da.a(this.a, (da.a)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gu
 * JD-Core Version:    0.7.0.1
 */