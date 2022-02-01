import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class udy
  implements View.OnClickListener
{
  public udy(AddFriendVerifyActivity paramAddFriendVerifyActivity, StringBuffer paramStringBuffer, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    String str1 = this.f.toString();
    int i = 0;
    String str2;
    if (i < AddFriendVerifyActivity.a(this.this$0).size())
    {
      str2 = ((EditText)AddFriendVerifyActivity.a(this.this$0).get(i)).getText().toString().trim();
      if (!"".equals(str2)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        QQToast.a(this.this$0, 0, this.this$0.getString(2131690317), 0).show(this.this$0.getTitleBarHeight());
      }
      for (;;)
      {
        anot.a(this.this$0.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, String.valueOf(this.bDG), String.valueOf(this.bDH), "", "");
        if (QLog.isColorLevel()) {
          QLog.d("AddFriendVerifyActivity", 2, "reportClickEvent action: 0X80077B4  sourceId = " + this.bDG + " subSourceId = " + this.bDH);
        }
        if (!TextUtils.isEmpty(this.this$0.aKJ)) {
          anot.a(this.this$0.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
        }
        this.this$0.eP(this.bDG, this.bDI);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        str1 = str1.replaceFirst("\\$\\{answer\\}", Matcher.quoteReplacement(str2));
        i += 1;
        break;
        this.this$0.b(str1, null, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     udy
 * JD-Core Version:    0.7.0.1
 */