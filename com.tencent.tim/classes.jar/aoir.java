import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

class aoir
  implements Handler.Callback
{
  aoir(aoim paramaoim) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (this.a.uinList.size() == 0)
      {
        QLog.d("MatchViewHolder", 1, "MSG_START_ANIMATION uinList is empty!");
        return false;
      }
      this.a.startAnimation();
      if (this.a.handler.hasMessages(1)) {
        this.a.handler.removeMessages(1);
      }
      if ((this.a.uinList != null) && (this.a.uinList.size() > 3))
      {
        paramMessage = (String)this.a.uinList.get(3);
        Drawable localDrawable = aqhu.c(true);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localQQAppInterface != null) {
          aqdj.a(localQQAppInterface, 1, paramMessage, 4, localDrawable, localDrawable);
        }
      }
      this.a.handler.sendEmptyMessageDelayed(1, 5000L);
      return false;
    }
    paramMessage = (ArrayList)paramMessage.obj;
    if (this.a.isAnimating)
    {
      paramMessage = Message.obtain(this.a.handler, 2, paramMessage);
      this.a.handler.sendMessageDelayed(paramMessage, 500L);
      return false;
    }
    aoim.a(this.a, paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoir
 * JD-Core Version:    0.7.0.1
 */