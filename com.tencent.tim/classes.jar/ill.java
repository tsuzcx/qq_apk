import android.os.Handler;
import android.os.Looper;
import com.tencent.av.camera.CameraObserver.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class ill
  implements Observer
{
  Handler mHandler = null;
  
  private void I(Object paramObject)
  {
    long l = 0L;
    if (paramObject == null) {
      return;
    }
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    if (QLog.isDevelopLevel()) {
      QLog.w("CameraObserver", 1, "OnUpdate, msgType[" + i + "]");
    }
    boolean bool;
    switch (i)
    {
    default: 
      return;
    case 1: 
      if (paramObject.length > 1)
      {
        bool = ((Boolean)paramObject[1]).booleanValue();
        if (paramObject.length <= 2) {
          break label317;
        }
      }
      break;
    }
    label317:
    for (l = ((Long)paramObject[2]).longValue();; l = 0L)
    {
      r(l, bool);
      return;
      anU();
      return;
      bool = ((Boolean)paramObject[1]).booleanValue();
      i = ((Integer)paramObject[2]).intValue();
      if (paramObject.length > 3) {
        l = ((Long)paramObject[3]).longValue();
      }
      d(l, bool, i);
      return;
      if (paramObject.length > 1) {
        l = ((Long)paramObject[1]).longValue();
      }
      bZ(l);
      return;
      bool = ((Boolean)paramObject[1]).booleanValue();
      if (paramObject.length > 2) {
        l = ((Long)paramObject[2]).longValue();
      }
      s(l, bool);
      return;
      anV();
      return;
      ip(((Boolean)paramObject[1]).booleanValue());
      return;
      try
      {
        paramObject = (byte[])paramObject[1];
        C(paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          paramObject.printStackTrace();
          paramObject = null;
        }
      }
      iq(((Boolean)paramObject[1]).booleanValue());
      return;
    }
  }
  
  protected void C(byte[] paramArrayOfByte) {}
  
  @Deprecated
  protected void anU() {}
  
  protected void anV() {}
  
  protected void bZ(long paramLong) {}
  
  protected void d(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void ip(boolean paramBoolean) {}
  
  protected void iq(boolean paramBoolean) {}
  
  protected void r(long paramLong, boolean paramBoolean) {}
  
  protected void s(long paramLong, boolean paramBoolean) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.mHandler == null) {
        this.mHandler = new Handler(paramObservable);
      }
      this.mHandler.post(new CameraObserver.1(this, paramObject));
      return;
    }
    I(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ill
 * JD-Core Version:    0.7.0.1
 */