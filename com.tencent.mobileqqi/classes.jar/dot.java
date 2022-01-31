import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.managers.TroopAssistantManager;

public class dot
  implements View.OnClickListener
{
  public dot(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_b_of_type_Boolean = false;
    if (TroopAssistantActivity.a(this.a) != null)
    {
      TroopAssistantActivity.a(this.a).a(4);
      this.a.i();
      this.a.h();
    }
    if (TroopAssistantManager.a().c()) {
      TroopAssistantManager.a().f(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    TroopAssistantActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dot
 * JD-Core Version:    0.7.0.1
 */