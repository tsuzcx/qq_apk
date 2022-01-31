import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AutoReplySettingActivity;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class cce
  implements View.OnClickListener
{
  public cce(AutoReplySettingActivity paramAutoReplySettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = BaseApplication.getContext().getSharedPreferences("share", 0);
    Intent localIntent = new Intent(this.a, EditActivity.class);
    localIntent.putExtra("title", 2131561873).putExtra("limit", 210).putExtra("current", paramView.getString("auto_reply_msg" + this.a.b.a(), this.a.getString(2131561450))).putExtra("canPostNull", false).putExtra("hint", this.a.getResources().getString(2131562624)).putExtra("multiLine", true);
    this.a.startActivityForResult(localIntent, 2010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cce
 * JD-Core Version:    0.7.0.1
 */