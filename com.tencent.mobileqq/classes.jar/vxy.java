import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqcircle.widgets.QCirclePushToastView;

public class vxy
  extends Handler
{
  private vxy(QCirclePushToastView paramQCirclePushToastView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.a();
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxy
 * JD-Core Version:    0.7.0.1
 */