import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.widget.XEditTextEx;

public class dhr
  extends Handler
{
  public dhr(QQLSActivity paramQQLSActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (QQLSActivity.b(this.a));
      if (hasMessages(0)) {
        removeMessages(0);
      }
      QQLSActivity.c(this.a);
      if (QQLSActivity.a(this.a) != null) {
        ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(QQLSActivity.a(this.a).getWindowToken(), 0);
      }
      Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131563331), 0).show();
      return;
    case 1: 
      this.a.b();
      this.a.finish();
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dhr
 * JD-Core Version:    0.7.0.1
 */