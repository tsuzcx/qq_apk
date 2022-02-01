import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ybd
  implements View.OnClickListener
{
  ybd(ybb paramybb) {}
  
  public void onClick(View paramView)
  {
    if (!ybb.c(this.this$0)) {
      if (ybb.a(this.this$0) == null)
      {
        ybb.e(this.this$0);
        QLog.e(this.this$0.TAG, 2, "onClick mExtendFriendUserInfo IS null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!ybb.a(this.this$0).enableQQCall) && (ybb.a(this.this$0).tagID != 10000))
      {
        ybb.e(this.this$0);
        QLog.e(this.this$0.TAG, 2, "onClick mExtendFriendUserInfo enableQQCall false" + ybb.a(this.this$0).tagID);
      }
      else
      {
        wja.bcO = true;
        wmj.a(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo, true, null, null);
        if (ybb.a(this.this$0) != null) {
          if (ybb.a(this.this$0).tagID == 1) {
            anot.a(this.this$0.app, "dc00898", "", "", "0X800AD92", "0X800AD92", 1, 0, "", "", "", "");
          } else {
            anot.a(this.this$0.app, "dc00898", "", "", "0X800AD92", "0X800AD92", 2, 0, "", "", ybb.a(this.this$0).tagName, "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybd
 * JD-Core Version:    0.7.0.1
 */