import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.widget.QQToast;

public class cns
  extends Handler
{
  public cns(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a, 2131364409, 0).a();
      return;
    case 2: 
      String str = this.a.getString(2131364410);
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.a, str + paramMessage, 0).a();
      return;
    }
    QQToast.a(this.a, 2131364411, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cns
 * JD-Core Version:    0.7.0.1
 */