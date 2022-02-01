import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResReloader.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class afkw
  implements Handler.Callback
{
  private afkw.a a;
  private final Lock i = new ReentrantLock();
  private Handler mHandler = new Handler(Looper.getMainLooper(), this);
  protected ArrayList<Integer> wj;
  
  public afkw(afkw.a parama)
  {
    this.a = parama;
  }
  
  public void MB(int paramInt)
  {
    this.i.lock();
    try
    {
      if (this.wj == null)
      {
        this.wj = new ArrayList();
        dac();
      }
      if (!this.wj.contains(Integer.valueOf(paramInt)))
      {
        this.wj.add(0, Integer.valueOf(paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("QQSysAndEmojiResReloader", 2, new Object[] { "addReloadDrawable idx:", Integer.valueOf(paramInt), " ,size:", Integer.valueOf(this.wj.size()) });
        }
      }
      return;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  public void dab()
  {
    this.mHandler.sendEmptyMessage(10001);
  }
  
  protected void dac()
  {
    ThreadManager.getSubThreadHandler().post(new QQSysAndEmojiResReloader.1(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((this.wj == null) || (this.wj.size() <= 0));
    this.i.lock();
    for (;;)
    {
      try
      {
        if (this.wj.size() <= 0) {
          break label162;
        }
        j = ((Integer)this.wj.remove(0)).intValue();
        this.i.unlock();
        if (j <= -1) {
          break;
        }
        if (this.a != null) {
          this.a.Mz(j);
        }
        if (this.wj.size() > 0)
        {
          this.mHandler.sendEmptyMessageDelayed(10001, 300L);
          return false;
        }
      }
      finally
      {
        this.i.unlock();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQSysAndEmojiResReloader", 2, "finish reloading");
      return false;
      label162:
      int j = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Mz(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkw
 * JD-Core Version:    0.7.0.1
 */