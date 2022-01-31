package oicq.wlogin_sdk.tools;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;

class d$a
  extends Handler
{
  public d$a(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2: 
      paramMessage = paramMessage.getData();
      if (paramMessage != null)
      {
        paramMessage = paramMessage.getString("msg");
        if (paramMessage != null) {
          d.b.add(paramMessage);
        }
      }
      d.a.sendEmptyMessageDelayed(1, 5000L);
      return;
    }
    d.a();
    d.a.removeMessages(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.d.a
 * JD-Core Version:    0.7.0.1
 */