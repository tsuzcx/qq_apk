import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;

public class asza
  extends Handler
{
  public asza(QSecFramework paramQSecFramework, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      if ((paramMessage.what == 1) && (!TextUtils.isEmpty((CharSequence)paramMessage.obj)))
      {
        long l = Long.parseLong((String)paramMessage.obj);
        if (l != 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QSecFramework", 2, "handle native msg for cookie:" + l);
          }
          QSecFramework.b(6L, l, 0L, 0L, null, null, null, null);
        }
      }
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asza
 * JD-Core Version:    0.7.0.1
 */