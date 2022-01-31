import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.PredownloadTest;

public class cax
  implements View.OnClickListener
{
  public cax(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, PredownloadTest.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cax
 * JD-Core Version:    0.7.0.1
 */