import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class achu
  extends accg
{
  private static final Object lock = new Object();
  private adjn b;
  
  public achu(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void dP(Context paramContext)
  {
    synchronized (lock)
    {
      if (this.b == null)
      {
        this.b = adjn.a();
        this.b.h(paramContext, hashCode(), "MiniCodePeakHandler");
      }
      return;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("MiniCodePeakHandler", 2, "onDestroy");
    }
    synchronized (lock)
    {
      if (this.b != null)
      {
        this.b.ak(hashCode(), "MiniCodePeakHandler");
        this.b = null;
      }
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     achu
 * JD-Core Version:    0.7.0.1
 */