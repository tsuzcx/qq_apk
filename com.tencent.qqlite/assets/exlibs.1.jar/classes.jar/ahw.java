import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.widget.QQToast;

public class ahw
  extends Handler
{
  public ahw(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && ((this.a.s == 1) || (this.a.s == 2)))
    {
      this.a.a();
      QQToast.a(this.a, 2131364412, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ahw
 * JD-Core Version:    0.7.0.1
 */