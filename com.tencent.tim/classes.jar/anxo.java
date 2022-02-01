import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager.2;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class anxo
  implements Manager
{
  private static byte[] fC = new byte[0];
  private static byte[] fD = new byte[0];
  private static byte[] lock = new byte[0];
  private QQAppInterface app;
  private boolean cKu;
  private boolean cKv;
  private boolean cKw;
  private boolean cKx;
  private acmf e = new anxp(this);
  private Runnable hE = new SubAccountProtocManager.2(this);
  
  public anxo(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.cKu = false;
    this.cKv = false;
    this.cKw = false;
    this.cKx = false;
    paramQQAppInterface.addObserver(this.e);
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountProtocManager", 2, "SubAccountProtocManager: manager init");
    }
  }
  
  public void Rw(String paramString)
  {
    if (this.app == null) {
      return;
    }
    synchronized (fC)
    {
      if (this.cKv) {
        return;
      }
    }
    this.cKv = true;
    ((acmd)this.app.getBusinessHandler(17)).ER(paramString);
  }
  
  public void aV(String paramString1, String paramString2, String paramString3)
  {
    if (this.app == null) {
      return;
    }
    synchronized (lock)
    {
      if (this.cKu) {
        return;
      }
    }
    this.cKu = true;
    ((acmd)this.app.getBusinessHandler(17)).at(paramString1, paramString2, paramString3);
  }
  
  public boolean azi()
  {
    synchronized (fD)
    {
      boolean bool = this.cKx;
      return bool;
    }
  }
  
  public void dTI()
  {
    if (this.app == null) {
      return;
    }
    synchronized (fD)
    {
      if (this.cKw) {
        return;
      }
    }
    this.cKw = true;
    ((acmd)this.app.getBusinessHandler(17)).cMB();
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.e);
    if (ThreadManager.getSubThreadHandler() != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.hE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxo
 * JD-Core Version:    0.7.0.1
 */