import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.app.face.FaceDownloader.a;
import com.tencent.mobileqq.app.face.FaceDownloader.c;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class acpo
  extends MqqHandler
{
  public acpo(FaceDownloader paramFaceDownloader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    while (paramMessage.what != 100) {
      return;
    }
    int i = 0;
    label16:
    if (i < this.this$0.tQ.size())
    {
      paramMessage = (FaceDownloader.c)this.this$0.tQ.get(i);
      if (paramMessage != null) {
        break label56;
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label56:
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "handle download finish task.faceInfo=" + paramMessage.a + ",bitmap=" + paramMessage.bitmap);
      }
      if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.bitmap != null) && (this.this$0.O.size() > 0))
      {
        int j = 0;
        while (j < this.this$0.O.size())
        {
          ((FaceDownloader.a)this.this$0.O.get(j)).a(true, paramMessage.a, paramMessage.bitmap);
          j += 1;
        }
      }
      this.this$0.tQ.remove(i);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acpo
 * JD-Core Version:    0.7.0.1
 */