import android.os.Handler;
import android.os.Looper;
import com.tencent.av.gaudio.AVObserver.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class inh
  implements Observer
{
  Handler mHandler = null;
  
  public void I(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    switch (i)
    {
    default: 
      int j = ((Integer)paramObject[1]).intValue();
      long l1 = ((Long)paramObject[2]).longValue();
      long l2 = ((Long)paramObject[3]).longValue();
      if (QLog.isDevelopLevel()) {
        QLog.w("GAudioObserver", 1, "OnUpdate, relationType[" + j + "], discussId[" + l1 + "], memberUin[" + l2 + "], msg[" + i + "]");
      }
      d(j, l1, l2);
      return;
    case 21: 
      d(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
      return;
    case 22: 
      e(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
      return;
    case 23: 
      f(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), ((Long)paramObject[3]).longValue());
      return;
    case 28: 
      i(((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3]);
      return;
    case 29: 
      aX((String)paramObject[2], (String)paramObject[3]);
      return;
    case 32: 
      i = ((Integer)paramObject[1]).intValue();
      a(((Long)paramObject[2]).longValue(), i, ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 33: 
      i = ((Integer)paramObject[1]).intValue();
      a(((Long)paramObject[2]).longValue(), i, ((Long)paramObject[3]).longValue(), (String)paramObject[4]);
      return;
    case 36: 
      t(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
      return;
    case 37: 
      u(((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
      return;
    case 408: 
      i(((Boolean)paramObject[1]).booleanValue(), (String)paramObject[2]);
      return;
    }
    jm((String)paramObject[1]);
  }
  
  protected void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {}
  
  protected void a(long paramLong1, int paramInt, long paramLong2, String paramString) {}
  
  protected void aX(String paramString1, String paramString2) {}
  
  protected void d(int paramInt, long paramLong1, long paramLong2) {}
  
  protected void e(int paramInt, long paramLong1, long paramLong2) {}
  
  protected void f(int paramInt, long paramLong1, long paramLong2) {}
  
  protected void i(int paramInt, String paramString1, String paramString2) {}
  
  protected void i(boolean paramBoolean, String paramString) {}
  
  protected void jm(String paramString) {}
  
  protected void t(int paramInt, long paramLong) {}
  
  protected void u(int paramInt, long paramLong) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.mHandler == null) {
        this.mHandler = new Handler(paramObservable);
      }
      this.mHandler.post(new AVObserver.1(this, paramObject));
      return;
    }
    I(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     inh
 * JD-Core Version:    0.7.0.1
 */