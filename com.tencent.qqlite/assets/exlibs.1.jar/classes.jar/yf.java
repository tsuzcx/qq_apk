import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.PredownloadTest;

public class yf
  implements View.OnClickListener
{
  public yf(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, PredownloadTest.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     yf
 * JD-Core Version:    0.7.0.1
 */