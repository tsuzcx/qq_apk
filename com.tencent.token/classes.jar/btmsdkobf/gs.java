package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class gs
  extends Handler
{
  gs(da paramda, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    da.a locala;
    do
    {
      return;
      paramMessage = (Object[])paramMessage.obj;
      locala = (da.a)paramMessage[0];
    } while (locala.kK == null);
    locala.kK.onFinish(((Integer)paramMessage[1]).intValue(), locala.kF, ((Integer)paramMessage[2]).intValue(), ((Integer)paramMessage[3]).intValue(), locala.kI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.gs
 * JD-Core Version:    0.7.0.1
 */