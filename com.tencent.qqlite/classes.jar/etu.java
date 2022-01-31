import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceDecodeTask.DecodeCompletionListener;

public final class etu
  extends Handler
{
  public etu(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      do
      {
        return;
      } while (paramMessage.what != FaceDecodeTask.a());
      paramMessage = (FaceDecodeTask)paramMessage.obj;
    } while ((paramMessage == null) || (FaceDecodeTask.a(paramMessage) == null) || (FaceDecodeTask.a(paramMessage) == null));
    if (FaceDecodeTask.a(paramMessage))
    {
      FaceDecodeTask.a(paramMessage).b = 2;
      FaceDecodeTask.a(paramMessage).a(FaceDecodeTask.a(paramMessage), FaceDecodeTask.a(paramMessage));
      return;
    }
    FaceDecodeTask.a(paramMessage).a(FaceDecodeTask.a(paramMessage), FaceDecodeTask.a(paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     etu
 * JD-Core Version:    0.7.0.1
 */