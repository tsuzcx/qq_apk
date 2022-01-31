import android.os.Binder;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.tencent.widget.TraceUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class cws
  extends HandlerThread
{
  public cws(String paramString)
  {
    super(paramString);
  }
  
  protected void onLooperPrepared()
  {
    for (;;)
    {
      Message localMessage;
      try
      {
        Method localMethod = MessageQueue.class.getDeclaredMethod("next", new Class[0]);
        localMethod.setAccessible(true);
        MessageQueue localMessageQueue = Looper.myQueue();
        Binder.clearCallingIdentity();
        Binder.clearCallingIdentity();
        localMessage = (Message)localMethod.invoke(localMessageQueue, new Object[0]);
        if (localMessage == null) {
          return;
        }
        if (localMessage.getCallback() != null)
        {
          TraceUtils.a(localMessage.getCallback().getClass().getName() + "." + "run");
          localMessage.getCallback().run();
          TraceUtils.a();
          Binder.clearCallingIdentity();
          localMessage.recycle();
          continue;
        }
        localHandler = localMessage.getTarget();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Handler localHandler;
      Object localObject = Handler.class.getDeclaredField("mCallback");
      ((Field)localObject).setAccessible(true);
      localObject = (Handler.Callback)((Field)localObject).get(localHandler);
      if (localObject != null)
      {
        TraceUtils.a(localObject.getClass().getName() + "." + "dispatchMsg");
        ((Handler.Callback)localObject).handleMessage(localMessage);
        TraceUtils.a();
      }
      else
      {
        TraceUtils.a(localHandler + "." + "dispatchMsg");
        localHandler.handleMessage(localMessage);
        TraceUtils.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cws
 * JD-Core Version:    0.7.0.1
 */