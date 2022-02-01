import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class joq
  extends Handler
{
  joq(jop paramjop, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "clear mJsApiWhiteList");
      }
      this.b.aQ.clear();
    } while (!(paramMessage.obj instanceof ConcurrentHashMap));
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "update new mJsApiWhiteList!");
    }
    this.b.aQ.putAll((ConcurrentHashMap)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     joq
 * JD-Core Version:    0.7.0.1
 */