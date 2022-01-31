import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class afa
  implements View.OnClickListener
{
  public afa(ChatSettingForTroop paramChatSettingForTroop) {}
  
  @SuppressLint({"ServiceCast"})
  @TargetApi(11)
  public void onClick(View paramView)
  {
    try
    {
      paramView = String.format(this.a.getString(2131363652), new Object[] { this.a.a.f, this.a.a.c });
      if (Build.VERSION.SDK_INT < 11)
      {
        ((android.text.ClipboardManager)this.a.getSystemService("clipboard")).setText(paramView);
        return;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        paramView = "";
      }
      ((android.content.ClipboardManager)this.a.getSystemService("clipboard")).setText(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afa
 * JD-Core Version:    0.7.0.1
 */