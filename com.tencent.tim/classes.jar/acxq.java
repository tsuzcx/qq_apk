import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

public abstract class acxq
{
  public ProxyManager a;
  public QQAppInterface app;
  
  public acxq(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    this.app = paramQQAppInterface;
    this.a = paramProxyManager;
  }
  
  public abstract void destory();
  
  public abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxq
 * JD-Core Version:    0.7.0.1
 */