import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class acyc
  extends Handler
{
  public static long RA;
  public static int cAy = -1000;
  private long RB;
  private long RC;
  private acxu b;
  private long mStartTime;
  
  public acyc(Looper paramLooper, QQAppInterface paramQQAppInterface, acxu paramacxu)
  {
    super(paramLooper);
    this.b = paramacxu;
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    ThreadRegulator.a().checkInNextBusiness();
    super.dispatchMessage(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    cAy = Process.myTid();
    RA = SystemClock.currentThreadTimeMillis();
    long l2 = System.currentTimeMillis();
    long l3 = SystemClock.currentThreadTimeMillis();
    Object localObject1 = (acxy)paramMessage.obj;
    label266:
    boolean bool;
    do
    {
      for (;;)
      {
        try
        {
          int i = paramMessage.what;
          switch (i)
          {
          default: 
            this.RC += SystemClock.currentThreadTimeMillis() - l3;
            this.RB += System.currentTimeMillis() - l2;
            if (System.currentTimeMillis() - this.mStartTime > 300000L)
            {
              paramMessage = new StringBuilder(100);
              paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
              paramMessage.append("cpu:").append(this.RC).append(" - wall:").append(this.RB).append(" ");
              localObject1 = (acxz)this.b.a(1);
              if (localObject1 != null) {
                paramMessage.append(((acxz)localObject1).rX());
              }
              localObject1 = (acyd)this.b.a(2);
              if (localObject1 != null) {
                paramMessage.append(((acyd)localObject1).rX()).append("\n");
              }
              QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
              this.RC = 0L;
              this.RB = 0L;
              this.mStartTime = System.currentTimeMillis();
            }
            return;
          }
        }
        finally
        {
          l1 = this.RC;
          this.RC = (SystemClock.currentThreadTimeMillis() - l3 + l1);
          l1 = this.RB;
          this.RB = (System.currentTimeMillis() - l2 + l1);
          if (System.currentTimeMillis() - this.mStartTime <= 300000L) {
            continue;
          }
          localObject1 = new StringBuilder(100);
          ((StringBuilder)localObject1).append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
          ((StringBuilder)localObject1).append("cpu:").append(this.RC).append(" - wall:").append(this.RB).append(" ");
          Object localObject2 = (acxz)this.b.a(1);
          if (localObject2 == null) {
            continue;
          }
          ((StringBuilder)localObject1).append(((acxz)localObject2).rX());
          localObject2 = (acyd)this.b.a(2);
          if (localObject2 == null) {
            continue;
          }
          ((StringBuilder)localObject1).append(((acyd)localObject2).rX()).append("\n");
          QLog.d("Q.fts.BgCpu.Total", 1, ((StringBuilder)localObject1).toString());
          this.RC = 0L;
          this.RB = 0L;
          this.mStartTime = System.currentTimeMillis();
        }
        if (((acxy)localObject1).acX()) {
          sendMessageDelayed(obtainMessage(2, localObject1), 30000L);
        } else if (QLog.isColorLevel()) {
          QLog.w("Q.fts.sync_worker", 2, "readSyncedCursor is false!!");
        }
      }
      removeMessages(2, localObject1);
      if (((acxy)localObject1).isSaveDBAtOnce()) {
        ((acxy)localObject1).cOS();
      }
      bool = this.b.isDestroyed;
      if (!bool) {
        break;
      }
      this.RC += SystemClock.currentThreadTimeMillis() - l3;
      this.RB += System.currentTimeMillis() - l2;
    } while (System.currentTimeMillis() - this.mStartTime <= 300000L);
    paramMessage = new StringBuilder(100);
    paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
    paramMessage.append("cpu:").append(this.RC).append(" - wall:").append(this.RB).append(" ");
    localObject1 = (acxz)this.b.a(1);
    if (localObject1 != null) {
      paramMessage.append(((acxz)localObject1).rX());
    }
    localObject1 = (acyd)this.b.a(2);
    if (localObject1 != null) {
      paramMessage.append(((acyd)localObject1).rX()).append("\n");
    }
    QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
    this.RC = 0L;
    this.RB = 0L;
    this.mStartTime = System.currentTimeMillis();
    return;
    paramMessage = obtainMessage(2, localObject1);
    if (((acxy)localObject1).acZ()) {}
    for (long l1 = 15000L;; l1 = 30000L)
    {
      sendMessageDelayed(paramMessage, l1);
      break;
      removeMessages(3, localObject1);
      ((acxy)localObject1).cOS();
      bool = this.b.isDestroyed;
      if (!bool) {
        break;
      }
      this.RC += SystemClock.currentThreadTimeMillis() - l3;
      this.RB += System.currentTimeMillis() - l2;
      if (System.currentTimeMillis() - this.mStartTime <= 300000L) {
        break label266;
      }
      paramMessage = new StringBuilder(100);
      paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
      paramMessage.append("cpu:").append(this.RC).append(" - wall:").append(this.RB).append(" ");
      localObject1 = (acxz)this.b.a(1);
      if (localObject1 != null) {
        paramMessage.append(((acxz)localObject1).rX());
      }
      localObject1 = (acyd)this.b.a(2);
      if (localObject1 != null) {
        paramMessage.append(((acyd)localObject1).rX()).append("\n");
      }
      QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
      this.RC = 0L;
      this.RB = 0L;
      this.mStartTime = System.currentTimeMillis();
      return;
    }
  }
  
  public void stopSync()
  {
    removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyc
 * JD-Core Version:    0.7.0.1
 */