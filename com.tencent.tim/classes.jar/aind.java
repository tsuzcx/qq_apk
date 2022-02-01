import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.limitchat.LimitChatDamon.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aind
{
  private static volatile aind a;
  private long Cj = -1L;
  private ConcurrentHashMap<String, Bundle> fJ = new ConcurrentHashMap();
  private Runnable gI;
  
  public static aind a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aind();
      }
      return a;
    }
    finally {}
  }
  
  public void ag(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm invoke, uin:" + paramString);
    }
    try
    {
      if (this.gI != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LimitChatDamon", 2, "sendMessageReadConfirm last request do not finish");
        }
        return;
      }
    }
    finally {}
    this.gI = new LimitChatDamon.1(this, paramString, paramQQAppInterface);
    if (this.gI != null) {
      ThreadManager.getSubThreadHandler().postDelayed(this.gI, 60000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aind
 * JD-Core Version:    0.7.0.1
 */