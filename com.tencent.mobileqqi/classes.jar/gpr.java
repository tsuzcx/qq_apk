import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class gpr
  extends SubAccountBindObserver
{
  public gpr(SubAccountProtocManager paramSubAccountProtocManager) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((!SubAccountProtocManager.a(this.a)) && (SubAccountProtocManager.a(this.a) != null)) {
      SubAccountProtocManager.a(this.a).postDelayed(SubAccountProtocManager.a(this.a), 100L);
    }
    synchronized (SubAccountProtocManager.c())
    {
      SubAccountProtocManager.c(this.a, false);
      SubAccountProtocManager.d(this.a, true);
      if ((paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.b)) {
        SubAccountProtocManager.a(this.a).e(false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountProtocManager", 2, "onGetBindSubAccount:");
      }
      return;
    }
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData arg2)
  {
    synchronized ()
    {
      SubAccountProtocManager.a(this.a, false);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData arg2)
  {
    synchronized ()
    {
      SubAccountProtocManager.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gpr
 * JD-Core Version:    0.7.0.1
 */