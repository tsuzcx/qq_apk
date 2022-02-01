import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.lebasearch.SearchProtocol.a;
import java.util.List;

public final class jsj
  extends Handler
{
  public jsj(Looper paramLooper, SearchProtocol.a parama)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.arg1 == 0)
    {
      this.a.i(paramMessage.arg1, (List)paramMessage.obj);
      return;
    }
    this.a.i(paramMessage.arg1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsj
 * JD-Core Version:    0.7.0.1
 */