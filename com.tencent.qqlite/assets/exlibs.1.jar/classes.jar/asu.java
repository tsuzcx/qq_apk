import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class asu
  extends Handler
{
  public asu(Leba paramLeba) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.a != null) && ("0".equals(this.a.a.a()))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1134006: 
      this.a.j();
      return;
    case 11340002: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "handler refresh leba config");
      }
      this.a.m();
      return;
    }
    Leba.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     asu
 * JD-Core Version:    0.7.0.1
 */