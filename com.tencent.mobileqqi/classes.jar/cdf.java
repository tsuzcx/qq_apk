import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class cdf
  implements View.OnClickListener
{
  public cdf(ChatSettingForTroop paramChatSettingForTroop) {}
  
  @SuppressLint({"ServiceCast"})
  @TargetApi(11)
  public void onClick(View paramView)
  {
    if ((ChatSettingForTroop.a(this.a) != null) && (ChatSettingForTroop.a(this.a).isShowing())) {
      ChatSettingForTroop.a(this.a).dismiss();
    }
    if (Build.VERSION.SDK_INT < 11)
    {
      ((android.text.ClipboardManager)this.a.getSystemService("clipboard")).setText(this.a.a.f + "/n" + this.a.a.c);
      return;
    }
    ((android.content.ClipboardManager)this.a.getSystemService("clipboard")).setText(this.a.a.f + "/n" + this.a.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cdf
 * JD-Core Version:    0.7.0.1
 */