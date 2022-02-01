import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aovx
  extends Handler
{
  public aovx(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.this$0.isFinishing()) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            case 1002: 
            case 1007: 
            default: 
              return;
            case 1001: 
              this.this$0.xa(false);
              if ((this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing())) {
                this.this$0.mProgress.dismiss();
              }
              QQToast.a(this.this$0, 2131698501, 1).show(this.this$0.getTitleBarHeight());
            }
          } while (!(paramMessage.obj instanceof String));
          paramMessage = (String)paramMessage.obj;
          try
          {
            this.this$0.cu.remove(paramMessage);
            return;
          }
          catch (UnsupportedOperationException paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.d("TroopBar", 2, paramMessage.toString());
        return;
        if ((this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing())) {
          this.this$0.mProgress.dismiss();
        }
        this.this$0.xa(false);
        this.this$0.bsq();
        return;
        if ((paramMessage.arg1 == 1) && (this.this$0.a != null)) {
          this.this$0.a.url = ((String)paramMessage.obj);
        }
      } while ((this.this$0.mProgress == null) || (!this.this$0.mProgress.isShowing()));
      this.this$0.bsq();
      return;
      this.this$0.xa(false);
      if ((this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing())) {
        this.this$0.mProgress.dismiss();
      }
      QQToast.a(this.this$0, 2131698479, 1).show(this.this$0.getTitleBarHeight());
      return;
      if ((paramMessage.obj instanceof String))
      {
        this.this$0.b.rb((String)paramMessage.obj);
        this.this$0.a = null;
        return;
      }
      this.this$0.b.N(this.this$0.cu);
    } while (this.this$0.cu.size() <= 0);
    this.this$0.a = null;
    return;
    this.this$0.cu.clear();
    this.this$0.b.removeAllItem();
    if ((Build.VERSION.SDK_INT >= 23) && (this.this$0.checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
    {
      this.this$0.requestPermissions(new aovy(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
      return;
    }
    TroopBarReplyActivity.a(this.this$0, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovx
 * JD-Core Version:    0.7.0.1
 */