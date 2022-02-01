import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.soload.config.SoLoadConfProcessor.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class anmi
  extends aehv<anmh>
{
  private final List<anmi.a> mListeners = new LinkedList();
  
  private void Vh(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[notifyListeners]:" + this.mListeners.size());
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
    try
    {
      synchronized (this.mListeners)
      {
        if (this.mListeners.size() <= 0) {
          break label162;
        }
        Iterator localIterator = this.mListeners.iterator();
        while (localIterator.hasNext())
        {
          anmi.a locala = (anmi.a)localIterator.next();
          try
          {
            locala.Vg(paramInt);
          }
          catch (Throwable localThrowable2) {}
          if (QLog.isColorLevel()) {
            QLog.e("SoLoadWidget.SoLoadConfProcessor", 1, localThrowable2, new Object[0]);
          }
        }
      }
      this.mListeners.clear();
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SoLoadWidget.SoLoadConfProcessor", 1, localThrowable1, new Object[0]);
      }
      return;
    }
    label162:
  }
  
  public static void a(int[] paramArrayOfInt, FromServiceMsg paramFromServiceMsg)
  {
    int m = paramArrayOfInt.length;
    int i = 0;
    if (i < m)
    {
      Object localObject;
      boolean bool;
      if (paramArrayOfInt[i] == 526) {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("[notifyNetFailed] isSucc=");
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
            break label148;
          }
          bool = true;
          label55:
          localObject = ((StringBuilder)localObject).append(bool).append(", resultCode=");
          if (paramFromServiceMsg == null) {
            break label154;
          }
        }
      }
      label148:
      label154:
      for (int j = paramFromServiceMsg.getResultCode();; j = -1)
      {
        QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, j);
        localObject = aeif.a().a(526);
        if (localObject != null)
        {
          int k = -2;
          j = k;
          if (paramFromServiceMsg != null)
          {
            j = k;
            if (paramFromServiceMsg.getResultCode() == 1002) {
              j = -1;
            }
          }
          ((aehv)localObject).onReqFailed(j);
        }
        i += 1;
        break;
        bool = false;
        break label55;
      }
    }
  }
  
  @NonNull
  public anmh a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new anmh();
  }
  
  @Nullable
  public anmh a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onParsed]");
    }
    anmh localanmh = new anmh();
    localanmh.a = paramArrayOfaeic;
    return localanmh;
  }
  
  public void a(anmh paramanmh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onUpdate] newConf:" + paramanmh);
    }
    anmf.a().update(paramanmh);
    Vh(0);
  }
  
  public void a(anmi.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[getConfig]");
    }
    synchronized (this.mListeners)
    {
      if (this.mListeners.size() > 0)
      {
        this.mListeners.add(parama);
        return;
      }
      this.mListeners.add(parama);
      aeif.a().hJ(526, 0);
      aeif.a().n(new int[] { 526 });
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new SoLoadConfProcessor.1(this), this, SystemClock.uptimeMillis() + 35000L);
      return;
    }
  }
  
  public Class<anmh> clazz()
  {
    return anmh.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
    Vh(paramInt);
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoLoadConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + aeif.a().o(526));
    }
    Vh(0);
  }
  
  public int onSend(int paramInt)
  {
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 526;
  }
  
  public static abstract interface a
  {
    public abstract void Vg(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anmi
 * JD-Core Version:    0.7.0.1
 */