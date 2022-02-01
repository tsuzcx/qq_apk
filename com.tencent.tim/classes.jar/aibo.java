import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.inputstatus.InputStatusPushManager.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.Manager;

public class aibo
  implements Manager
{
  private static final String TAG = aibo.class.getSimpleName();
  private WeakReference<BaseChatPie> dq;
  private Runnable gH = new InputStatusPushManager.1(this);
  private QQAppInterface mApp;
  private Handler mHandler;
  
  public aibo(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private aibl a()
  {
    if (this.dq.get() != null) {
      return (aibl)((BaseChatPie)this.dq.get()).a(16);
    }
    return null;
  }
  
  private boolean ahh()
  {
    try
    {
      aibj.a locala = (aibj.a)aeif.a().o(445);
      if (locala != null)
      {
        boolean bool = locala.cjJ;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
    return false;
  }
  
  private boolean aoK()
  {
    try
    {
      aibj.a locala = (aibj.a)aeif.a().o(445);
      if (locala != null)
      {
        boolean bool = locala.cjK;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, localException, new Object[0]);
    }
    return true;
  }
  
  private boolean aoO()
  {
    if ((this.dq != null) && ((this.dq.get() instanceof ybb))) {
      return aoK();
    }
    return ahh();
  }
  
  private Handler getHandler()
  {
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    return this.mHandler;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "receive fromUin =" + paramLong1 + "，toUin，timeStamp =" + paramLong3 + "，interval =" + paramInt1 + "，showTime =" + paramInt2 + "，eventType = " + paramInt3 + "，statusText =" + paramString);
    }
    String str1;
    boolean bool;
    if ((this.dq != null) && (this.dq.get() != null) && (aoO()))
    {
      getHandler().removeCallbacks(this.gH);
      if (a() != null)
      {
        a().interval = (paramInt1 * 1000);
        a().timeStamp = paramLong3;
      }
      str1 = ((BaseChatPie)this.dq.get()).sessionInfo.aTl;
      String str2 = ((BaseChatPie)this.dq.get()).app.getCurrentAccountUin();
      if ((TextUtils.equals(str1, String.valueOf(paramLong1))) && (TextUtils.equals(str2, String.valueOf(paramLong2))))
      {
        if (paramInt3 == 2) {
          break label284;
        }
        bool = true;
        if (!bool) {
          break label300;
        }
        str1 = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          if (paramInt3 != 1) {
            break label290;
          }
          str1 = acfp.m(2131707440);
        }
        label246:
        getHandler().postDelayed(this.gH, paramInt2 * 1000);
      }
    }
    for (;;)
    {
      if (a() != null) {
        a().aD(bool, str1);
      }
      return;
      label284:
      bool = false;
      break;
      label290:
      str1 = acfp.m(2131707441);
      break label246;
      label300:
      str1 = "";
    }
  }
  
  void drT()
  {
    getHandler().removeCallbacks(this.gH);
  }
  
  public void onDestroy()
  {
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(this.gH);
    }
  }
  
  public void y(BaseChatPie paramBaseChatPie)
  {
    this.dq = new WeakReference(paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibo
 * JD-Core Version:    0.7.0.1
 */