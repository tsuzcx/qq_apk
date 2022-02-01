import android.os.Handler;
import android.os.Looper;
import com.tencent.av.VideoProcessExitMonitor.1;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class ihl
{
  private static final Object ar = new Object();
  private boolean Ps;
  private boolean Pt;
  private boolean Pu;
  private boolean Pv;
  private boolean Pw;
  private boolean Px;
  private boolean Py;
  private int amd;
  private Runnable bh;
  private VideoAppInterface mApp;
  private Handler mHandler;
  
  public ihl(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.amd = 0;
    if (jgu.a().azn == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ps = bool;
      QLog.d("VideoProcessExitMonitor", 1, String.format("VideoProcessExitMonitor mExitProcessEnable=%s", new Object[] { Boolean.valueOf(this.Ps) }));
      return;
    }
  }
  
  private void ami()
  {
    synchronized (ar)
    {
      QLog.d("VideoProcessExitMonitor", 1, String.format("receiveMsfSetConnStatusTimeout mCurStatus=%s", new Object[] { Integer.valueOf(this.amd) }));
      if (this.amd == 1) {
        this.amd = 2;
      }
      kz(this.amd);
      return;
    }
  }
  
  private void bE(long paramLong)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("startMsfRespTimeoutCheck timeout=%s", new Object[] { Long.valueOf(paramLong) }));
    if (this.bh != null)
    {
      this.mHandler.removeCallbacks(this.bh);
      this.bh = null;
    }
    this.bh = new VideoProcessExitMonitor.1(this);
    this.mHandler.postDelayed(this.bh, paramLong);
  }
  
  private void exitProcess()
  {
    QLog.d("VideoProcessExitMonitor", 1, "exitProcess");
    long l = System.currentTimeMillis();
    QLog.flushLog(true);
    this.mApp.getApplication().otherProcessExit(true);
    QLog.d("VideoProcessExitMonitor", 1, String.format("exitProcess time cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    this.mApp.amP();
    try
    {
      Thread.sleep(300L);
      label66:
      System.exit(0);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label66;
    }
  }
  
  private void ky(int paramInt)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("sendSetMsfConnStatusReq status=%s", new Object[] { Integer.valueOf(paramInt) }));
    NewIntent localNewIntent = new NewIntent(this.mApp.getApplication(), iho.class);
    localNewIntent.putExtra("reqType", 10);
    localNewIntent.putExtra("status", paramInt);
    this.mApp.startServlet(localNewIntent);
  }
  
  private void kz(int paramInt)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("checkExitProcess status=%s", new Object[] { Integer.valueOf(paramInt) }));
    if (this.amd == 2) {
      exitProcess();
    }
  }
  
  public void alw()
  {
    if (!this.Ps) {
      return;
    }
    synchronized (ar)
    {
      QLog.d("VideoProcessExitMonitor", 1, String.format("processActive mCurStatus=%s", new Object[] { Integer.valueOf(this.amd) }));
      if (this.amd != 0)
      {
        ky(2);
        this.amd = 0;
      }
      return;
    }
  }
  
  public void hM(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setAcceptMultiIncomingCall acceptMultiIncomingCall=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.Pt = paramBoolean;
  }
  
  public void hN(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2MultiActive switch2MultiActive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.Pu = paramBoolean;
  }
  
  public void hO(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2MultiPassive switch2MultiPassive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.Pv = paramBoolean;
  }
  
  public void hP(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2DoubleMeeting switch2DoubleMeeting=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.Pw = paramBoolean;
  }
  
  public void hQ(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2OtherTerminal switch2OtherTerminal=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.Px = paramBoolean;
  }
  
  public void hR(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setAllTerminalOffline allTerminalOffline=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.Py = paramBoolean;
  }
  
  public void hT(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!this.Ps)) {
      return;
    }
    for (;;)
    {
      synchronized (ar)
      {
        QLog.d("VideoProcessExitMonitor", 1, String.format("processDeactive mCurStatus=%s", new Object[] { Integer.valueOf(this.amd) }));
        if (this.amd == 0)
        {
          ky(1);
          bE(2000L);
          this.amd = 1;
          kz(this.amd);
          return;
        }
      }
      int i = this.amd;
      if (i != 1) {}
    }
  }
  
  public void kx(int paramInt)
  {
    synchronized (ar)
    {
      QLog.d("VideoProcessExitMonitor", 1, String.format("receiveMsfSetConnStatusAck mCurStatus=%s status=%s", new Object[] { Integer.valueOf(this.amd), Integer.valueOf(paramInt) }));
      if (this.bh != null)
      {
        this.mHandler.removeCallbacks(this.bh);
        this.bh = null;
      }
      if ((paramInt == 1) && (this.amd == 1)) {
        this.amd = 2;
      }
      kz(this.amd);
      return;
    }
  }
  
  public boolean sE()
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("canExitProcess mAcceptMultiIncomingCall=%s mSwitch2MultiActive=%s mSwitch2MultiPassive=%s mSwitch2DoubleMeeting=%s mSwitch2OtherTerminal=%s mAllTerminalOffline=%s", new Object[] { Boolean.valueOf(this.Pt), Boolean.valueOf(this.Pu), Boolean.valueOf(this.Pv), Boolean.valueOf(this.Pw), Boolean.valueOf(this.Px), Boolean.valueOf(this.Py) }));
    return (!this.Pt) && (!this.Pu) && (!this.Pv) && (!this.Pw) && (!this.Px) && (!this.Py);
  }
  
  public boolean sF()
  {
    return this.Pw;
  }
  
  public boolean sG()
  {
    return this.Py;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihl
 * JD-Core Version:    0.7.0.1
 */