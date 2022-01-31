import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.widget.QQToast;

public class cnm
  extends Handler
{
  public cnm(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a, 2131364427, 0).a();
      return;
    case 2: 
      String str = this.a.getString(2131364428);
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.a, str + paramMessage, 0).a();
      return;
    }
    QQToast.a(this.a, 2131364429, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cnm
 * JD-Core Version:    0.7.0.1
 */