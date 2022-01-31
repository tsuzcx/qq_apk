import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.FileUtils;

public class eig
  extends TransProcessorHandler
{
  public eig(ForwardImageProcessor paramForwardImageProcessor) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((i == 2002) || ((ForwardImageProcessor.a(this.a).equals(localFileMsg.m)) && (localFileMsg.e == 1) && (i != 2002)))
    {
      if ((localFileMsg.o == null) || (!localFileMsg.o.equals(ForwardImageProcessor.b(this.a)))) {
        return;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      ForwardImageProcessor.a(this.a);
      continue;
      if (FileUtils.b(ForwardImageProcessor.c(this.a)))
      {
        ForwardImageProcessor.a(this.a).a().b(this);
        ForwardImageProcessor.b(this.a);
      }
      else
      {
        ForwardImageProcessor.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eig
 * JD-Core Version:    0.7.0.1
 */