import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ugp
  extends MqqHandler
{
  public ugp(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (AssociatedAccountManageActivity.a(this.this$0) == null) {
        AssociatedAccountManageActivity.a(this.this$0, new arhz(this.this$0, this.this$0.getTitleBarHeight()));
      }
      if ((!this.this$0.isFinishing()) && (!AssociatedAccountManageActivity.a(this.this$0).isShowing()))
      {
        try
        {
          AssociatedAccountManageActivity.a(this.this$0).show();
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.e("AssociatedAccountManage", 2, "QQProgressDialog show exception.", localException);
          continue;
          if ((AssociatedAccountManageActivity.a(this.this$0) != null) && (AssociatedAccountManageActivity.a(this.this$0).isShowing()))
          {
            AssociatedAccountManageActivity.a(this.this$0).dismiss();
            AssociatedAccountManageActivity.a(this.this$0, null);
            continue;
            if (AssociatedAccountManageActivity.a(this.this$0) != null) {
              AssociatedAccountManageActivity.a(this.this$0).cancel();
            }
            AssociatedAccountManageActivity.a(this.this$0, QQToast.a(this.this$0, paramMessage.arg1, paramMessage.arg2, 0).show(this.this$0.getTitleBarHeight()));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ugp
 * JD-Core Version:    0.7.0.1
 */