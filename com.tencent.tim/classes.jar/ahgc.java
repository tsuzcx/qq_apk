import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ahgc
  implements Handler.Callback
{
  private static ahgc a;
  private Handler bI = new Handler(ThreadManager.getSubThreadLooper(), this);
  private Map<String, Integer> kP;
  
  public static ahgc a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ahgc();
      }
      return a;
    }
    finally {}
  }
  
  public void Ko(boolean paramBoolean)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 2, "onFirstFrameRendered");
    }
    this.bI.removeMessages(1);
    Message localMessage = this.bI.obtainMessage(1);
    if (paramBoolean) {}
    for (;;)
    {
      localMessage.arg1 = i;
      this.bI.sendMessageDelayed(localMessage, 2000L);
      return;
      i = 0;
    }
  }
  
  public void aOR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 2, "onPagePause");
    }
    this.bI.removeCallbacksAndMessages(null);
  }
  
  public void cc(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 1, "onDestroy");
    }
    if ((paramBoolean2) && (paramBoolean1)) {
      this.bI.sendEmptyMessageDelayed(1, 2000L);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return false;
        QLog.d("QFlutter.Reporter", 1, "init memory");
        this.kP = aqgz.g(BaseApplicationImpl.getContext());
        return false;
      } while (this.kP == null);
      if (paramMessage.arg1 == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ahgd.a(bool, true, this.kP);
        if (bool) {
          break;
        }
        this.kP = null;
        return false;
      }
    } while (this.kP == null);
    ahgd.a(true, false, this.kP);
    this.kP = null;
    return false;
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.Reporter", 2, "onCreate");
    }
    this.bI.removeCallbacksAndMessages(null);
    this.bI.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahgc
 * JD-Core Version:    0.7.0.1
 */