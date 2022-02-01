import android.os.SystemClock;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager.a;
import com.tencent.qphone.base.util.QLog;

public class apuv
  implements UsingTimeReportManager.a
{
  private UsingTimeReportManager a;
  private boolean cSs;
  public String mDepartment;
  private long mEndTime;
  private boolean mIsInit;
  public String mOpName;
  public String mOpType;
  private long mStartTime;
  
  public apuv(String paramString1, String paramString2, String paramString3)
  {
    this.mDepartment = paramString1;
    this.mOpType = paramString2;
    this.mOpName = paramString3;
  }
  
  private void ebV()
  {
    if (!this.mIsInit) {}
    while (!this.cSs) {
      return;
    }
    this.mEndTime = SystemClock.uptimeMillis();
    long l = this.mEndTime - this.mStartTime;
    if (QLog.isColorLevel()) {
      QLog.i("BaseUsingTimeReport", 2, "stop,usingTime=" + l);
    }
    if ((l > 0L) && (this.mIsInit)) {
      kj(l);
    }
    this.cSs = false;
  }
  
  private void init()
  {
    this.a = a();
    if ((this.a != null) && (!this.mIsInit))
    {
      this.a.a(this);
      this.mIsInit = true;
    }
  }
  
  private void unInit()
  {
    if ((this.a != null) && (this.mIsInit))
    {
      this.a.b(this);
      this.mIsInit = false;
    }
  }
  
  public UsingTimeReportManager a()
  {
    return null;
  }
  
  public void ebW()
  {
    ebV();
  }
  
  public void ebX()
  {
    start();
  }
  
  public void ebY()
  {
    stop();
  }
  
  public void kj(long paramLong) {}
  
  public void start()
  {
    init();
    if (!this.mIsInit) {}
    do
    {
      do
      {
        return;
      } while (this.cSs);
      this.mStartTime = SystemClock.uptimeMillis();
      this.cSs = true;
    } while (!QLog.isColorLevel());
    QLog.i("BaseUsingTimeReport", 2, "start(), mStartTime=" + this.mStartTime);
  }
  
  public void stop()
  {
    ebV();
    unInit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apuv
 * JD-Core Version:    0.7.0.1
 */