import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

public class xwh
  extends Handler
{
  public xwh(QQStoryLoadingView paramQQStoryLoadingView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    Object localObject = paramMessage.obj;
    String str;
    if (paramMessage.what == 8) {
      str = "GONE";
    }
    for (;;)
    {
      wxe.a("QQStoryLoadingView", "%s => setVisibility => %s", localObject, str);
      this.a.setVisibility(paramMessage.what);
      return;
      if (paramMessage.what == 0) {
        str = "VISIBLE";
      } else {
        str = "INVISIBLE";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xwh
 * JD-Core Version:    0.7.0.1
 */