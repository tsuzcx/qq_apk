import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uew
  implements View.OnClickListener
{
  public uew(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    this.this$0.b("", null, "");
    anot.a(this.this$0.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.bDG), String.valueOf(this.bDH), "", "");
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.bDG + " subSourceId = " + this.bDH);
    }
    if (aqft.rj(AddFriendVerifyActivity.a(this.this$0))) {
      anot.a(this.this$0.app, "dc00898", "", "", "0X8008275", "0X8008275", 0, 0, "", "", "", "");
    }
    if (!TextUtils.isEmpty(this.this$0.aKJ)) {
      anot.a(this.this$0.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uew
 * JD-Core Version:    0.7.0.1
 */