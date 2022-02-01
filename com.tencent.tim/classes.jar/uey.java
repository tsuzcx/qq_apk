import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uey
  implements View.OnClickListener
{
  public uey(AddFriendVerifyActivity paramAddFriendVerifyActivity, EditText paramEditText, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    if ("".equals(this.at.getText().toString().trim())) {
      QQToast.a(this.this$0, 0, this.this$0.getString(2131690317), 0).show(this.this$0.getTitleBarHeight());
    }
    for (;;)
    {
      anot.a(this.this$0.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.bDG), String.valueOf(this.bDH), "", "");
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.bDG + " subSourceId = " + this.bDH);
      }
      if (!TextUtils.isEmpty(this.this$0.aKJ)) {
        anot.a(this.this$0.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 1, "", "", "", "");
      }
      this.this$0.eP(this.bDG, this.bDI);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aqiw.isNetSupport(this.this$0))
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.this$0.app.getBusinessHandler(1);
        String str1 = this.this$0.getIntent().getStringExtra("extra");
        String str2 = this.at.getText().toString().trim();
        int i = this.this$0.getIntent().getIntExtra("sub_source_id", 0);
        String str3 = this.this$0.getIntent().getStringExtra("src_name");
        localFriendListHandler.a(AddFriendVerifyActivity.a(this.this$0), str1, this.bDI, (byte)0, str2, this.bDG, i, false, null, false, null, str3, this.this$0.getIntent().getBundleExtra("flc_extra_param"));
      }
      else
      {
        QQToast.a(this.this$0, 1, this.this$0.getString(2131696272), 0).show(this.this$0.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uey
 * JD-Core Version:    0.7.0.1
 */