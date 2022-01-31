import cooperation.qqfav.ipc.QfavRemoteProxyForQQ;
import cooperation.qqfav.ipc.QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper;
import java.util.concurrent.ConcurrentLinkedQueue;

class fni
  extends Thread
{
  fni(fnh paramfnh) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper localQfavRemoteProxyCallWrapper = (QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper)this.a.a.a.poll();
      if (localQfavRemoteProxyCallWrapper != null) {
        QfavRemoteProxyForQQ.a(this.a.a, localQfavRemoteProxyCallWrapper);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fni
 * JD-Core Version:    0.7.0.1
 */