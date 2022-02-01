import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.Manager;

public class acda
  implements Manager
{
  private aqdn a;
  private QQAppInterface app;
  public Object lock = new Object();
  
  public acda(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public aqdn a()
  {
    if (this.a == null) {}
    synchronized (this.lock)
    {
      if (this.a == null) {
        this.a = new aqdn(this.app);
      }
      return this.a;
    }
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acda
 * JD-Core Version:    0.7.0.1
 */