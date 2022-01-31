import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qphone.base.util.QLog;

public class fcz
  implements Runnable
{
  public fcz(BindGroupActivity paramBindGroupActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onGetOpenId timeout.");
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.c = true;
    this.a.b.hide();
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fcz
 * JD-Core Version:    0.7.0.1
 */