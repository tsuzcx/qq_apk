import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class dhd
  extends Handler
{
  public dhd(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    int j = paramMessage.arg1;
    boolean bool;
    if ((j & 0x1) == 0)
    {
      bool = true;
      this.a.a(bool);
      if ((j & 0x2) != 0) {
        break label76;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label81;
      }
      QQBrowserActivity.a(this.a).setVisibility(0);
      return;
      bool = false;
      break;
      label76:
      i = 0;
    }
    label81:
    QQBrowserActivity.b(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhd
 * JD-Core Version:    0.7.0.1
 */