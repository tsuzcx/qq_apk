import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import java.util.Queue;

public class cwl
  extends Handler
{
  public cwl(StartAppCheckHandler paramStartAppCheckHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    paramMessage = (cwo)paramMessage.obj;
    this.a.a.remove(paramMessage);
    paramMessage.jdField_a_of_type_AndroidContentContext.startActivity(paramMessage.jdField_a_of_type_AndroidContentIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cwl
 * JD-Core Version:    0.7.0.1
 */