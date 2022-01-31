import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryCollector;

public class bxw
  extends Handler
{
  public bxw(AIOGalleryCollector paramAIOGalleryCollector, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      bxx.a((bxx)paramMessage.obj);
      return;
    case 1: 
      bxx.b((bxx)paramMessage.obj);
      return;
    case 2: 
      bxx.c((bxx)paramMessage.obj);
      return;
    }
    AIOGalleryCollector.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bxw
 * JD-Core Version:    0.7.0.1
 */