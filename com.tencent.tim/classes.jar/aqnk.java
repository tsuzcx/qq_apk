import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

final class aqnk
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface;
    if ((BaseApplicationImpl.getApplication().waitAppRuntime(null) instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
      switch (paramMessage.what)
      {
      }
    }
    for (;;)
    {
      return true;
      QQToast.a(localQQAppInterface.getApplication(), acfp.m(2131716318), 0).show();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), acfp.m(2131716317), 0).show();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), acfp.m(2131716316), 0).show();
      continue;
      QQToast.a(localQQAppInterface.getApplication(), acfp.m(2131716319), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnk
 * JD-Core Version:    0.7.0.1
 */