import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class blz
  implements View.OnClickListener
{
  public blz(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    if (TroopAssistantActivity.a(this.a) != null)
    {
      TroopAssistantActivity.a(this.a).a(4);
      this.a.e();
      this.a.d();
    }
    if (TroopAssistantManager.a().c()) {
      TroopAssistantManager.a().f(this.a.app);
    }
    TroopAssistantActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     blz
 * JD-Core Version:    0.7.0.1
 */