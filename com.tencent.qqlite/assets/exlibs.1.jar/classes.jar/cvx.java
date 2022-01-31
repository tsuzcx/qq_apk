import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SaveTrafficHandler;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class cvx
  extends Handler
{
  public cvx(SaveTrafficHandler paramSaveTrafficHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
      paramMessage = this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    }
    for (;;)
    {
      if (!paramMessage.hasNext()) {
        break label182;
      }
      try
      {
        Object localObject = (Map.Entry)paramMessage.next();
        if (localObject == null) {
          continue;
        }
        ((Integer)((Map.Entry)localObject).getKey()).intValue();
        localObject = (cvz)((Map.Entry)localObject).getValue();
        if (localObject == null) {
          continue;
        }
        if (((cvz)localObject).a == bool) {
          break label152;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)localObject);
        paramMessage.remove();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      bool = true;
      break;
      bool = false;
      break;
      label152:
      if (localException.b) {
        return;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localException);
      paramMessage.remove();
    }
    label182:
    if ((SaveTrafficHandler.c != bool) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.i))
    {
      int i = this.a.a();
      paramMessage = new cvz(this.a, i, bool);
      Handler localHandler = this.a.jdField_a_of_type_AndroidOsHandler;
      if (bool) {}
      for (long l = 30000L;; l = 5000L)
      {
        localHandler.postDelayed(paramMessage, l);
        this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), paramMessage);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cvx
 * JD-Core Version:    0.7.0.1
 */