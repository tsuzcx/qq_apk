import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uex
  implements View.OnClickListener
{
  public uex(AddFriendVerifyActivity paramAddFriendVerifyActivity, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    String str1 = AddFriendVerifyActivity.a(this.this$0, false);
    String str2 = this.this$0.aq.getText().toString().trim();
    if ((str2 != null) && (str1 != null) && (!str2.equals(str1))) {
      anot.a(this.this$0.app, "dc00898", "", "", "0X80077B0", "0X80077B0", 0, 0, "", "", "", "");
    }
    this.this$0.aN(str2, false);
    if ((this.this$0.getString(2131693133).equals(str2)) && (!AddFriendVerifyActivity.b(this.this$0))) {
      AddFriendVerifyActivity.a(this.this$0);
    }
    if (this.this$0.a != null)
    {
      anot.a(this.this$0.app, "dc00898", "", "", "0X8008439", "0X8008439", 0, 0, "", "", "", "");
      if ((!TextUtils.isEmpty(this.this$0.a.verifyMsg)) && (!this.this$0.a.verifyMsg.equals(this.this$0.aq.getText().toString()))) {
        anot.a(this.this$0.app, "dc00898", "", "", "0X800843A", "0X800843A", 0, 0, "", "", "", "");
      }
    }
    this.this$0.b(this.this$0.aq.getText().toString().trim(), null, "");
    anot.a(this.this$0.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.bDG), String.valueOf(this.bDH), "", "");
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.bDG + " subSourceId = " + this.bDH);
    }
    if (!TextUtils.isEmpty(this.this$0.aKJ)) {
      anot.a(this.this$0.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
    this.this$0.eP(this.bDG, this.bDI);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uex
 * JD-Core Version:    0.7.0.1
 */