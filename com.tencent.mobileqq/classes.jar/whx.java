import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.DiscActiveTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.statistics.ReportController;

public class whx
  implements View.OnClickListener
{
  public whx(DiscActiveTipsBar paramDiscActiveTipsBar) {}
  
  public void onClick(View paramView)
  {
    DiscActiveTipsBar.a(this.a).a();
    ChatActivityUtils.a(DiscActiveTipsBar.a(this.a), DiscActiveTipsBar.a(this.a), DiscActiveTipsBar.a(this.a).jdField_a_of_type_Int, DiscActiveTipsBar.a(this.a).jdField_a_of_type_JavaLangString, true, true, null, null);
    ReportController.b(DiscActiveTipsBar.a(this.a), "CliOper", "", "", "0X8003F00", "0X8003F00", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     whx
 * JD-Core Version:    0.7.0.1
 */