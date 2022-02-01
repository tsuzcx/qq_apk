import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class agki
  extends MqqHandler
{
  agki(agkh paramagkh, Looper paramLooper)
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
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerNotifyCenter<FileAssistant>", 1, "recv Netchang event!");
    }
    this.this$0.app.a().Jh(true);
    this.this$0.app.a().Oa(-1);
    agkw.releaseAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agki
 * JD-Core Version:    0.7.0.1
 */