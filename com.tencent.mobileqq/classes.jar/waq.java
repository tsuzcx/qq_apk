import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView;

public class waq
  extends Handler
{
  private waq(QCircleGuideBubbleView paramQCircleGuideBubbleView)
  {
    super(Looper.getMainLooper());
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
 * Qualified Name:     waq
 * JD-Core Version:    0.7.0.1
 */