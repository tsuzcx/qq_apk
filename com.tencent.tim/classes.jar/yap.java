import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class yap
  implements ausj.a
{
  yap(yam paramyam, ausj paramausj, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.this$0.b(this.e.senderuin, this.val$nick, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.TAG, 2, "del hot chat member onClick, uin=" + this.e.senderuin);
      }
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(this.this$0.a(), this.this$0.a().getString(2131696272), 0).show(this.this$0.a().getTitleBarHeight());
        return;
      }
    } while ((acfv)this.this$0.app.getBusinessHandler(35) == null);
    paramView = aqha.a(this.this$0.a(), 230).setMessage(2131694647).setNegativeButton(2131691040, new yar(this)).setPositiveButton(2131691042, new yaq(this));
    paramView.setTitle(2131694648);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yap
 * JD-Core Version:    0.7.0.1
 */