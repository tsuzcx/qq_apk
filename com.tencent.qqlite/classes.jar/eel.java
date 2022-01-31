import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.startup.step.NameProcess;

public class eel
  extends Handler
{
  public eel(NameProcess paramNameProcess) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    com.tencent.common.app.BaseApplicationImpl.a = paramMessage.arg1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eel
 * JD-Core Version:    0.7.0.1
 */