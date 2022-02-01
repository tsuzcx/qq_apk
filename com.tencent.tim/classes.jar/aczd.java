import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import java.util.Map;

final class aczd
  extends SosoInterface.a
{
  aczd(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, aczc.b paramb)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      synchronized (aczc.access$000())
      {
        if (aczc.access$100().containsKey(this))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SOSO.LBS.LbsManagerService", 0, "onConsecutiveFailure reverseListenerMap contains. business id: " + this.tag + " fail count: " + paramInt2);
          }
          if (paramInt2 > 5)
          {
            localb = (aczc.b)aczc.access$100().remove(this);
            aczc.access$000().remove(localb);
            if (paramInt2 > 5) {
              SosoInterface.c(this);
            }
            return;
          }
          aczc.b localb = (aczc.b)aczc.access$100().get(this);
          if (paramInt2 == 5) {
            bool = true;
          }
          localb.onConsecutiveFailure(paramInt1, paramInt2, bool);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "onConsecutiveFailure reverseListenerMap not contains. business id: " + this.tag + " fail count: " + paramInt2);
      }
    }
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    for (;;)
    {
      synchronized ()
      {
        if (aczc.access$100().containsKey(this))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SOSO.LBS.LbsManagerService", 0, "onLocationFinish reverseListenerMap contains. business id: " + this.tag);
          }
          if (this.goonListener)
          {
            localb = (aczc.b)aczc.access$100().get(this);
            localb.onLocationFinish(paramInt, aczc.b(paramSosoLbsInfo, this.e.businessId));
            return;
          }
          aczc.b localb = (aczc.b)aczc.access$100().remove(this);
          aczc.access$000().remove(localb);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "onLocationFinish reverseListenerMap not contains. business id: " + this.tag + " this is: " + this);
      }
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    synchronized ()
    {
      if (aczc.access$100().containsKey(this)) {
        ((aczc.b)aczc.access$100().get(this)).onStatusUpdate(paramString1, paramInt, paramString2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczd
 * JD-Core Version:    0.7.0.1
 */