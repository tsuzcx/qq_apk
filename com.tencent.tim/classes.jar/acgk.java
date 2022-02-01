import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.HotchatSCHelper.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class acgk
  implements acgl.b, Handler.Callback
{
  acgk.a a;
  public acgl a;
  public boolean bHP;
  public boolean bHQ;
  public String bor;
  public QQAppInterface mApp;
  public Handler mHandler;
  
  public acgk(QQAppInterface paramQQAppInterface, acgk.a parama, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Acgl = ((acgl)paramQQAppInterface.getManager(123));
    this.jdField_a_of_type_Acgk$a = parama;
    this.bor = paramString;
    this.mHandler = new auru(Looper.getMainLooper(), this);
    if (QLog.isDevelopLevel()) {
      ajrk.f("HotchatSCMng", "HotchatSCHelper", new Object[] { paramString, this.jdField_a_of_type_Acgk$a });
    }
  }
  
  public static long dV()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      ajrk.m("HotchatSCMng", new Object[] { "getCurTime", Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(Math.abs(l2 - l1)) });
    }
    return l1;
  }
  
  public void destroy()
  {
    stopCheck();
    this.jdField_a_of_type_Acgk$a = null;
    if (acgl.DEBUG) {
      ajrk.f("HotchatSCMng", "destroy", new Object[0]);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.bHP) {
      return true;
    }
    long l2;
    if (paramMessage.what == 0)
    {
      l2 = dV();
      paramMessage = this.jdField_a_of_type_Acgl.a(this.bor, 0, l2);
      if (acgl.DEBUG) {
        ajrk.f("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "cur", paramMessage });
      }
      if (this.jdField_a_of_type_Acgk$a != null) {
        if (paramMessage != null)
        {
          paramMessage.hasShow = this.jdField_a_of_type_Acgk$a.a(paramMessage);
          label87:
          if (paramMessage == null) {
            break label277;
          }
        }
      }
    }
    label277:
    for (long l1 = paramMessage.endtime - l2;; l1 = 0L)
    {
      if (l1 > 0L)
      {
        this.mHandler.sendEmptyMessageDelayed(0, l1 + 100L);
        return true;
        this.jdField_a_of_type_Acgk$a.a(null);
        break label87;
        if (!acgl.DEBUG) {
          break label87;
        }
        ajrk.f("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "listener is null" });
        break label87;
      }
      paramMessage = this.jdField_a_of_type_Acgl.a(this.bor, 2, l2);
      if (acgl.DEBUG) {
        ajrk.f("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "next", paramMessage });
      }
      if (paramMessage != null)
      {
        l1 = Math.max(60000L, paramMessage.stime - l2);
        this.mHandler.sendEmptyMessageDelayed(0, l1);
        return true;
      }
      this.bHP = false;
      if (!acgl.DEBUG) {
        break;
      }
      ajrk.f("HotchatSCMng", "MSG_GET_NOTE_TOSHOW", new Object[] { "stop check" });
      return true;
      if (paramMessage.what != 2) {
        break;
      }
      hy(100L);
      return true;
    }
  }
  
  public void hx(long paramLong)
  {
    if (acgl.DEBUG) {
      ajrk.f("HotchatSCMng", "startCheckDelay", new Object[] { Boolean.valueOf(this.bHP), Long.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_Acgl.bHR) });
    }
    this.mHandler.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void hy(long paramLong)
  {
    if (acgl.DEBUG) {
      ajrk.f("HotchatSCMng", "startCheck", new Object[] { Boolean.valueOf(this.bHP), Long.valueOf(paramLong), Boolean.valueOf(this.jdField_a_of_type_Acgl.bHR) });
    }
    this.mHandler.removeMessages(2);
    if (this.bHP) {
      return;
    }
    this.bHP = true;
    if (this.jdField_a_of_type_Acgl.bHR)
    {
      this.mHandler.removeMessages(0);
      this.mHandler.sendEmptyMessageDelayed(0, paramLong);
    }
    for (;;)
    {
      this.jdField_a_of_type_Acgl.a(this);
      return;
      ThreadManager.post(new HotchatSCHelper.1(this, paramLong, System.currentTimeMillis()), 8, null, true);
    }
  }
  
  public void stopCheck()
  {
    this.bHP = false;
    this.mHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Acgl.b(this);
    if (acgl.DEBUG) {
      ajrk.f("HotchatSCMng", "stopCheck", new Object[0]);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(acgl.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgk
 * JD-Core Version:    0.7.0.1
 */