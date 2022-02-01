import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.16.1;
import com.tencent.mobileqq.widget.QQToast;

public class aaxt
  extends Handler
{
  public aaxt(SelectMemberActivity paramSelectMemberActivity, Looper paramLooper)
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
      do
      {
        return;
      } while ((this.this$0.pd == null) || (!this.this$0.pd.isShowing()));
      this.this$0.pd.dismiss();
      paramMessage = new Intent();
      paramMessage.putExtra("select_member_add_request_ok", true);
      this.this$0.setResult(-1, paramMessage);
      if (!TextUtils.isEmpty(this.this$0.beC))
      {
        paramMessage = this.this$0.beC;
        QQToast.a(this.this$0, 2, paramMessage, 1500).show(this.this$0.getTitleBarHeight());
        postDelayed(new SelectMemberActivity.16.1(this), 1500L);
        return;
      }
      if (this.this$0.bap) {}
      for (int i = 2131695124;; i = 2131695123)
      {
        paramMessage = this.this$0.getResources().getString(i);
        break;
      }
    } while ((this.this$0.pd == null) || (!this.this$0.pd.isShowing()));
    this.this$0.pd.dismiss();
    String str = (String)paramMessage.obj;
    paramMessage = str;
    if (str == null) {
      paramMessage = this.this$0.getString(2131695122);
    }
    QQToast.a(this.this$0, 1, paramMessage, 1500).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxt
 * JD-Core Version:    0.7.0.1
 */