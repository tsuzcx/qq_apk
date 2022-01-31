import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity;
import com.tencent.mobileqq.widget.QQToast;

public class awf
  extends Handler
{
  public awf(NearPeopleFilterActivity paramNearPeopleFilterActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      this.a.e();
      QQToast.a(this.a, 2131364412, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     awf
 * JD-Core Version:    0.7.0.1
 */