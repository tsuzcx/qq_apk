import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.MobileQQService;
import mqq.manager.Manager;

public class zhg
  implements Runnable
{
  public zhg(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.c();
    }
    int i = 0;
    while (i < QQAppInterface.a(this.a).length)
    {
      Manager localManager = QQAppInterface.a(this.a)[i];
      if (localManager != null) {
        localManager.onDestroy();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhg
 * JD-Core Version:    0.7.0.1
 */