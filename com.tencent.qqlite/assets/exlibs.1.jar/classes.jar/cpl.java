import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.adapter.WebFacePreloadBaseAdapter;

public class cpl
  extends Handler
{
  public cpl(WebFacePreloadBaseAdapter paramWebFacePreloadBaseAdapter) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cpl
 * JD-Core Version:    0.7.0.1
 */