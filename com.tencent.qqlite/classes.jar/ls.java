import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.OfflineSecurity;

public final class ls
  implements Runnable
{
  public ls(String paramString1, String paramString2) {}
  
  public void run()
  {
    boolean bool = OfflineSecurity.a(this.a, this.b);
    Message localMessage = OfflineSecurity.a.obtainMessage();
    localMessage.obj = Boolean.valueOf(bool);
    OfflineSecurity.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ls
 * JD-Core Version:    0.7.0.1
 */