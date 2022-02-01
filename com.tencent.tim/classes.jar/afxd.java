import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class afxd
  implements Handler.Callback
{
  public final String TAG = "ExtendFriendLimitChatStateMachine";
  private afxb jdField_a_of_type_Afxb;
  private afxc jdField_a_of_type_Afxc;
  private afxe jdField_a_of_type_Afxe;
  public afxd.a b;
  public final int cUY = 1;
  public final int cUZ = 2;
  public final int cVa = 4;
  public final int cVb = 6;
  public final int cVc = 7;
  protected boolean cbx;
  private Lock lock = new ReentrantLock();
  QQAppInterface mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper(), this);
  
  public afxd(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Afxc = new afxc(this, 100);
    this.jdField_a_of_type_Afxe = new afxe(this, 101);
    a(100, null);
  }
  
  public void Clear()
  {
    if (this.jdField_a_of_type_Afxc != null)
    {
      this.jdField_a_of_type_Afxc.clearStatus();
      this.jdField_a_of_type_Afxc = null;
    }
    if (this.jdField_a_of_type_Afxe != null)
    {
      this.jdField_a_of_type_Afxe.clearStatus();
      this.jdField_a_of_type_Afxe = null;
    }
    this.jdField_a_of_type_Afxb = null;
    this.cbx = false;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "machine Clear ");
    }
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void Is(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "onMatchPushMsg success:" + paramBoolean);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(this.mHandler, 7, Integer.valueOf(i)).sendToTarget();
      return;
    }
  }
  
  public void NB(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      QLog.e("ExtendFriendLimitChatStateMachine", 2, "requestmatch with wrong id");
      i = 1;
    }
    Message.obtain(this.mHandler, 1, i, i).sendToTarget();
    this.mHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt, aftr paramaftr)
  {
    this.lock.lock();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.lock.unlock();
      QLog.i("ExtendFriendLimitChatStateMachine", 2, "setStatus  " + paramInt);
      if (this.jdField_a_of_type_Afxb != null) {
        this.jdField_a_of_type_Afxb.c(paramaftr);
      }
      return;
      try
      {
        this.jdField_a_of_type_Afxb = this.jdField_a_of_type_Afxc;
        continue;
      }
      finally
      {
        this.lock.unlock();
      }
      this.jdField_a_of_type_Afxb = this.jdField_a_of_type_Afxe;
    }
  }
  
  public void a(afxd.a parama)
  {
    this.b = parama;
  }
  
  public void a(boolean paramBoolean, int paramInt, aftr paramaftr, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "onCSMatchResponseMsg success:" + paramBoolean + " retCode:" + paramInt);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(this.mHandler, 4, i, paramInt, new Object[] { paramaftr, paramString }).sendToTarget();
      return;
    }
  }
  
  public void a(boolean paramBoolean, aftr paramaftr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendLimitChatStateMachine", 2, "onMatchPushMsg success:" + paramBoolean + " info:" + paramaftr);
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Message.obtain(this.mHandler, 6, i, 0, paramaftr).sendToTarget();
      return;
    }
  }
  
  public void apK()
  {
    this.mHandler.sendEmptyMessage(2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.jdField_a_of_type_Afxb == null) {
      return true;
    }
    switch (paramMessage.what)
    {
    case 3: 
    case 5: 
    default: 
      return true;
    case 1: 
      int i = paramMessage.arg1;
      this.jdField_a_of_type_Afxb.NB(i);
      return true;
    case 2: 
      this.jdField_a_of_type_Afxb.apK();
      return true;
    case 4: 
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof Object[]))) {
          break label214;
        }
        Object localObject = (Object[])paramMessage.obj;
        if ((localObject == null) || (localObject.length != 2)) {
          break label197;
        }
        aftr localaftr = (aftr)localObject[0];
        localObject = (String)localObject[1];
        this.jdField_a_of_type_Afxb.b(bool1, paramMessage.arg2, localaftr, (String)localObject);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendLimitChatStateMachine", 2, "CS_RESPONSE_MSG mIsGetMatchInfoWaitingHandle");
        }
        this.cbx = false;
        return true;
        bool1 = false;
        break;
        this.jdField_a_of_type_Afxb.b(bool1, paramMessage.arg2, null, null);
        continue;
        this.jdField_a_of_type_Afxb.b(bool1, paramMessage.arg2, null, null);
        QLog.e("ExtendFriendLimitChatStateMachine", 2, "CS_RESPONSE_MSG obj err");
      }
    case 6: 
      label197:
      label214:
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      if (paramMessage.obj == null) {
        break;
      }
    }
    for (paramMessage = (aftr)paramMessage.obj;; paramMessage = null)
    {
      this.jdField_a_of_type_Afxb.b(bool1, paramMessage);
      return true;
      bool1 = bool2;
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      this.jdField_a_of_type_Afxb.IH(bool1);
      return true;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, aftr paramaftr, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxd
 * JD-Core Version:    0.7.0.1
 */