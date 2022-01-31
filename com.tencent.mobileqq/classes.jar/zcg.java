import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class zcg
  implements Runnable
{
  public zcg(HotChatShare paramHotChatShare) {}
  
  public void run()
  {
    if ((this.a.a == null) || (!this.a.a.isShowing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "30s has gone, goto share....");
    }
    this.a.c();
    HotChatShare.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcg
 * JD-Core Version:    0.7.0.1
 */