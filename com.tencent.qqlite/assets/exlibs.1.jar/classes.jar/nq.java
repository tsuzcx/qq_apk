import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;

public final class nq
  extends Handler
{
  public nq(Looper paramLooper, SearchProtocol.SearchObserver paramSearchObserver)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.arg1 == 0)
    {
      this.a.a(paramMessage.arg1, (SearchProtocol.WordItem)paramMessage.obj);
      return;
    }
    this.a.a(paramMessage.arg1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     nq
 * JD-Core Version:    0.7.0.1
 */