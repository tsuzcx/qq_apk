import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class cuy
  implements Runnable
{
  public cuy(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QQToast.a(QQAppInterface.c(this.a).getApplicationContext(), 2131364178, 3000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cuy
 * JD-Core Version:    0.7.0.1
 */