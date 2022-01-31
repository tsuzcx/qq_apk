import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;

public class fqj
  extends Handler
{
  public fqj(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      this.a.a(((Boolean)((java.lang.Object[])(java.lang.Object[])paramMessage.obj)[0]).booleanValue(), (String[])((java.lang.Object[])(java.lang.Object[])paramMessage.obj)[1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fqj
 * JD-Core Version:    0.7.0.1
 */