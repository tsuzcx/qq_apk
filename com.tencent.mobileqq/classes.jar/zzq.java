import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class zzq
  implements CompoundButton.OnCheckedChangeListener
{
  public zzq(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    alrv.a(this.a.app, paramBoolean);
    if (!paramBoolean) {
      new alrw().b(null);
    }
    ((alsm)this.a.app.a(168)).a(paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      awqx.b(null, "dc00898", "", "", "0X800A8B0", "0X800A8B0", i, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zzq
 * JD-Core Version:    0.7.0.1
 */