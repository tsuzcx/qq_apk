import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

class afza
  implements Handler.Callback
{
  afza(afyv paramafyv) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (this.c.uinList.size() == 0)
      {
        QLog.d("MatchViewHolder", 1, "MSG_START_ANIMATION uinList is empty!");
        return false;
      }
      this.c.startAnimation();
      if (this.c.handler.hasMessages(1)) {
        this.c.handler.removeMessages(1);
      }
      paramMessage = (String)this.c.uinList.get(this.c.uinList.size() - 1);
      Drawable localDrawable = aqhu.c(true);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null) {
        aqdj.a(localQQAppInterface, 1, paramMessage, 4, localDrawable, localDrawable);
      }
      this.c.handler.sendEmptyMessageDelayed(1, 3000L);
      return false;
    }
    paramMessage = (ArrayList)paramMessage.obj;
    if (this.c.isAnimating)
    {
      paramMessage = Message.obtain(this.c.handler, 2, paramMessage);
      this.c.handler.sendMessageDelayed(paramMessage, 500L);
      return false;
    }
    afyv.a(this.c, paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afza
 * JD-Core Version:    0.7.0.1
 */