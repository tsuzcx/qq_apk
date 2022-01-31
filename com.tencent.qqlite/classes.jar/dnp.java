import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;

public class dnp
  extends Handler
{
  public dnp(FileManagerNotifyCenter paramFileManagerNotifyCenter, Looper paramLooper)
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
    this.a.a.a().b();
    this.a.a.a().b(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dnp
 * JD-Core Version:    0.7.0.1
 */