import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import java.util.ArrayList;

public final class ny
  extends Handler
{
  public ny(Looper paramLooper, SearchProtocol.SearchObserver paramSearchObserver)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.arg1 == 0)
    {
      this.a.a(paramMessage.arg1, (ArrayList)paramMessage.obj);
      return;
    }
    this.a.a(paramMessage.arg1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ny
 * JD-Core Version:    0.7.0.1
 */