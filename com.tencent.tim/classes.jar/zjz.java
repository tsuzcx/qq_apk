import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

class zjz
  extends Handler
{
  zjz(zju paramzju, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.this$0.a == null) || (this.this$0.a.app == null) || (!this.this$0.a.app.isLogin())) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 0: 
          paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
          this.this$0.a(35, paramMessage);
          return;
        case 28929: 
          paramMessage = paramMessage.getData();
        }
      } while (paramMessage == null);
      int i = paramMessage.getInt("result");
      if ((i == -1) || (i == -2))
      {
        if (i == -1) {
          paramMessage = this.this$0.a.getString(2131719254);
        }
        for (String str = this.this$0.a.getString(2131719253);; str = this.this$0.a.getString(2131719256))
        {
          try
          {
            if (this.this$0.Y != null)
            {
              if (this.this$0.Y.isShowing()) {
                this.this$0.Y.dismiss();
              }
              this.this$0.Y = null;
            }
            this.this$0.Y = aqha.a(this.this$0.a, 230, paramMessage, str, new zka(this), null);
            this.this$0.Y.setOnCancelListener(new zkb(this));
            this.this$0.Y.setOnDismissListener(new zkc(this));
            this.this$0.Y.show();
            return;
          }
          catch (Exception paramMessage) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          paramMessage.printStackTrace();
          return;
          paramMessage = this.this$0.a.getString(2131719257);
        }
      }
    } while (this.this$0.Y == null);
    this.this$0.Y.dismiss();
    return;
    paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
    this.this$0.a(34, paramMessage);
    return;
    paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
    this.this$0.a(33, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjz
 * JD-Core Version:    0.7.0.1
 */