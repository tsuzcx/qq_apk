package cooperation.weiyun;

import awpd.a;
import awpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class WeiyunAIOUtils$WeiyunCallbackImpl$1
  implements Runnable
{
  public WeiyunAIOUtils$WeiyunCallbackImpl$1(awpd.a parama) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null)
    {
      awpl.b(awpd.a.a(this.this$0), BaseActivity.sTopActivity, awpd.a.a(this.this$0));
      return;
    }
    QQToast.a(awpd.a.a(this.this$0), 2, 2131699597, 1).show(awpd.a.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl.1
 * JD-Core Version:    0.7.0.1
 */