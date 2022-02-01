import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class aujg
  extends MqqHandler
{
  aujg(aujf paramaujf) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((aujf.b(this.this$0) != null) && ("0".equals(aujf.c(this.this$0).getCurrentAccountUin()))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MePresenter", 2, "handler refresh leba config");
    }
    this.this$0.bQx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aujg
 * JD-Core Version:    0.7.0.1
 */