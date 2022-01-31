import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class zvo
  implements Runnable
{
  public zvo(ProxyManager paramProxyManager) {}
  
  public void run()
  {
    ProxyManager.a(this.a, System.currentTimeMillis());
    while (!this.a.jdField_a_of_type_Boolean) {
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        try
        {
          this.a.c();
          this.a.jdField_a_of_type_JavaLangObject.wait(ProxyManager.a());
          ThreadRegulator.a().b();
          if (((!ProxyManager.a(this.a).isEmpty()) || (ProxyManager.a(this.a).a().size() > 0)) && (ProxyManager.a(this.a)))
          {
            this.a.d();
            ProxyManager.a(this.a).c();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.MsgProxy", 2, "writeRunable Exception:", localException);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zvo
 * JD-Core Version:    0.7.0.1
 */