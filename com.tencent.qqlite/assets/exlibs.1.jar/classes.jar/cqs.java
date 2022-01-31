import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.adapter.WebFacePreloadBaseAdapter;

public class cqs
  extends Handler
{
  public cqs(WebFacePreloadBaseAdapter paramWebFacePreloadBaseAdapter) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cqs
 * JD-Core Version:    0.7.0.1
 */