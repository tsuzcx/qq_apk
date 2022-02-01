import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class arif
  extends Handler
{
  arif(arie paramarie, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    arie.a locala = (arie.a)paramMessage.obj;
    paramMessage = locala.cAx;
    if ((paramMessage == null) || (paramMessage.length() == 0)) {}
    for (;;)
    {
      try
      {
        String str = this.c.mContext.getResources().getString(locala.msgId);
        paramMessage = str;
        if (this.c.mToast != null) {
          break label116;
        }
        this.c.mToast = QQToast.a(this.c.mContext, locala.icon, paramMessage, locala.duration).create(locala.offset);
        if (this.c.mToast != null) {
          this.c.mToast.show();
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      continue;
      try
      {
        label116:
        View localView = this.c.mToast.getView();
        ((TextView)localView.findViewById(2131379951)).setText(paramMessage);
        ((ImageView)localView.findViewById(2131379948)).setImageResource(QQToast.getIconRes(locala.icon));
        this.c.mToast.setDuration(locala.duration);
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        this.c.mToast = null;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQToastNotifier", 2, paramMessage.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     arif
 * JD-Core Version:    0.7.0.1
 */