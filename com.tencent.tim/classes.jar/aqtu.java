import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class aqtu
  extends Handler
{
  public aqtu(PathTraceManager paramPathTraceManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      try
      {
        paramMessage = (JSONObject)paramMessage.obj;
        String str = paramMessage.getString("callback");
        if (this.this$0.iy != null)
        {
          aqtl localaqtl = (aqtl)this.this$0.iy.get();
          if (localaqtl != null)
          {
            localaqtl.callJs(str, new String[] { paramMessage.toString() });
            return;
          }
        }
      }
      catch (Exception paramMessage) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtu
 * JD-Core Version:    0.7.0.1
 */