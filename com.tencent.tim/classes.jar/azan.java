import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;

public class azan
  implements Handler.Callback
{
  private azan.a a;
  private int dGe;
  private int dGf;
  private int dGg;
  private Handler handler;
  public HandlerThread thread;
  
  public azan(int paramInt1, int paramInt2)
  {
    this.dGe = (1000 / paramInt1);
    this.dGf = ((int)(paramInt2 / 1000.0F * paramInt1) + 1);
    this.dGg = 0;
    this.thread = new HandlerThread("shortvideo_Timer");
    this.thread.start();
    this.handler = new Handler(this.thread.getLooper(), this);
  }
  
  private boolean q(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (azba.cHa)
    {
      paramMessage = RMVideoStateMgr.a();
      if (!paramMessage.byV) {
        break label179;
      }
      paramMessage.bL = (System.currentTimeMillis() - paramMessage.mStartTime);
      if (paramMessage.bL >= aniq.dGY) {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        bool2 = bool1;
        if (bool1)
        {
          QLog.d("TCTimer", 2, "handleLooperEvent startTime=" + paramMessage.mStartTime + " total=" + paramMessage.bL);
          bool2 = bool1;
        }
      }
    }
    for (;;)
    {
      if (bool2) {
        this.dGg = this.dGf;
      }
      int i = this.dGg;
      int j = this.dGe;
      if (this.a != null) {
        this.a.a(this.a, bool2, i * j, this.dGg);
      }
      this.dGg += 1;
      return true;
      label179:
      if (this.dGg >= this.dGf) {
        bool2 = true;
      }
    }
  }
  
  public int Jt()
  {
    return this.dGe;
  }
  
  public void UU(int paramInt)
  {
    this.dGg = paramInt;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (this.handler != null)
    {
      Message localMessage = this.handler.obtainMessage(1398036036);
      this.handler.sendMessageDelayed(localMessage, this.dGe);
    }
    return q(paramMessage);
  }
  
  public static abstract interface a
  {
    public abstract int a(a parama, boolean paramBoolean, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azan
 * JD-Core Version:    0.7.0.1
 */