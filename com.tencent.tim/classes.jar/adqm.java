import android.os.HandlerThread;
import com.tencent.ark.ArkEnvironmentManager.ThreadCreater;
import com.tencent.mobileqq.app.ThreadManager;

public final class adqm
  implements ArkEnvironmentManager.ThreadCreater
{
  public HandlerThread createHanderThread(String paramString)
  {
    return ThreadManager.newFreeHandlerThread(paramString, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqm
 * JD-Core Version:    0.7.0.1
 */