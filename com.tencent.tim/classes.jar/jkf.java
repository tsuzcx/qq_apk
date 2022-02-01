import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import com.tencent.av.utils.PhoneStatusMonitor.1;
import com.tencent.av.utils.PhoneStatusMonitor.2;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusReceiver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class jkf
{
  public jkf.a a;
  jkf.b a;
  Runnable cm = new PhoneStatusMonitor.2(this);
  public Context mContext;
  public Handler mHandler = null;
  public boolean mIsCalling = false;
  public PhoneStateListener mPhoneStateListener;
  
  public jkf(Context paramContext, jkf.a parama)
  {
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Begin");
    }
    this.mContext = paramContext;
    this.jdField_a_of_type_Jkf$a = parama;
    try
    {
      this.mPhoneStateListener = new jkf.c();
      this.jdField_a_of_type_Jkf$b = new jkf.b();
    }
    catch (Exception parama)
    {
      try
      {
        do
        {
          ThreadManager.post(new PhoneStatusMonitor.1(this, paramContext), 5, null, false);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Step1,time=" + (SystemClock.elapsedRealtime() - l));
          }
          parama = new IntentFilter();
          parama.addAction("android.intent.action.PHONE_STATE");
          parama.addAction("android.intent.action.PHONE_STATE2");
          parama.addAction("android.intent.action.PHONE_STATE_2");
          parama.addAction("android.intent.action.PHONE_STATE_EXT");
          parama.addAction("android.intent.action.NEW_OUTGOING_CALL");
          paramContext.registerReceiver(this.jdField_a_of_type_Jkf$b, parama);
          QLog.d("PhoneStatusMonitor", 1, "mPhoneStatusReceiver.registerReceiver()");
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor End,time=" + (SystemClock.elapsedRealtime() - l));
          }
          this.mHandler = new Handler(Looper.getMainLooper());
          return;
          parama = parama;
        } while (!QLog.isColorLevel());
        QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e1 = " + parama);
      }
      catch (InternalError parama)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e = " + parama);
          }
        }
      }
      catch (IncompatibleClassChangeError parama)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e2 = " + parama);
          }
        }
      }
    }
  }
  
  public void aoq()
  {
    release();
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      release();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public boolean isCalling()
  {
    return this.mIsCalling;
  }
  
  public void release()
  {
    if ((this.mContext == null) || (this.mPhoneStateListener == null)) {
      return;
    }
    jkg.listen(this.mContext, this.mPhoneStateListener, 0);
    QLog.d("PhoneStatusMonitor", 1, "mPhoneStatusReceiver.unregisterReceiver()");
    this.mContext.unregisterReceiver(this.jdField_a_of_type_Jkf$b);
    this.jdField_a_of_type_Jkf$a = null;
    this.jdField_a_of_type_Jkf$b = null;
    this.mPhoneStateListener = null;
    this.mContext = null;
    this.mHandler = null;
  }
  
  public static abstract interface a
  {
    public abstract void onCallStateChanged(boolean paramBoolean);
  }
  
  public class b
    extends BroadcastReceiver
  {
    b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext.equals("android.intent.action.NEW_OUTGOING_CALL"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusMonitor", 2, "onReceive NEW_OUTGOING_CALL");
        }
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 2, String.format("PhoneStatusReceiver, isCallingRunnable begin,  action[%s]", new Object[] { paramContext }));
      }
      ThreadManager.post(new PhoneStatusMonitor.PhoneStatusReceiver.1(this, paramContext), 5, null, false);
    }
  }
  
  class c
    extends PhoneStateListener
  {
    c() {}
    
    public void onCallStateChanged(int paramInt, String paramString)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        super.onCallStateChanged(paramInt, paramString);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged CALL_STATE_IDLE  mIsCalling:  " + jkf.this.mIsCalling);
        }
        if (jkf.this.mIsCalling)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged isCallingRunnable mIsCalling: " + jkf.this.mIsCalling);
          }
          ThreadManager.post(jkf.this.cm, 8, null, false);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "onCallStateChanged CALL_STATE_RINGING or CALL_STATE_OFFHOOK");
          }
          if (!jkf.this.mIsCalling)
          {
            jkf.this.mIsCalling = true;
            if (jkf.this.a != null) {
              jkf.this.a.onCallStateChanged(true);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     jkf
 * JD-Core Version:    0.7.0.1
 */