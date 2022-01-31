import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.util.FetchInfoListManager;
import java.util.LinkedList;

public class het
  extends Handler
{
  public het(FetchInfoListManager paramFetchInfoListManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      FetchInfoListManager.a(this.a);
    }
    while ((paramMessage.what != 2) || (FetchInfoListManager.a(this.a) == null)) {
      return;
    }
    FetchInfoListManager.a(this.a).remove(paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     het
 * JD-Core Version:    0.7.0.1
 */