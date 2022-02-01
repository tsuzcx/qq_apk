import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceDecodeTask.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public final class aqdd
  extends MqqHandler
{
  public aqdd(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    label4:
    FaceDecodeTask.a locala;
    label143:
    label150:
    do
    {
      do
      {
        int i;
        do
        {
          break label4;
          do
          {
            return;
          } while (paramMessage.what != FaceDecodeTask.dYu);
          if (FaceDecodeTask.tQ.size() <= 0) {
            break label150;
          }
          i = 0;
          if (i >= FaceDecodeTask.tQ.size()) {
            break label143;
          }
          paramMessage = (FaceDecodeTask)FaceDecodeTask.tQ.get(i);
          if ((paramMessage == null) || (paramMessage.a == null) || (paramMessage.in == null) || (paramMessage.in.get() == null)) {
            break;
          }
          locala = (FaceDecodeTask.a)paramMessage.in.get();
        } while (locala == null);
        if (paramMessage.cTE)
        {
          paramMessage.a.bA = 2;
          locala.a(FaceDecodeTask.a(paramMessage), paramMessage.a);
        }
        for (;;)
        {
          i += 1;
          break;
          locala.a(paramMessage.a, paramMessage.bitmap);
        }
        FaceDecodeTask.tQ.clear();
        return;
        paramMessage = (FaceDecodeTask)paramMessage.obj;
      } while ((paramMessage == null) || (paramMessage.a == null) || (paramMessage.in == null) || (paramMessage.in.get() == null));
      locala = (FaceDecodeTask.a)paramMessage.in.get();
    } while (locala == null);
    if (paramMessage.cTE)
    {
      paramMessage.a.bA = 2;
      locala.a(FaceDecodeTask.a(paramMessage), paramMessage.a);
      return;
    }
    locala.a(paramMessage.a, paramMessage.bitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdd
 * JD-Core Version:    0.7.0.1
 */