import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class ffj
  implements Runnable
{
  public ffj(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QQToast.a(QQAppInterface.c(this.a).getApplicationContext(), 2131562935, 3000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffj
 * JD-Core Version:    0.7.0.1
 */