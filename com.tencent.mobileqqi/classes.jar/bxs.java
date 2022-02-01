import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class bxs
  implements View.OnClickListener
{
  public bxs(ChatActivity paramChatActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.b, "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    ChatActivityFacade.d(this.a.b, this.a.a.jdField_a_of_type_JavaLangString);
    ChatActivity.a(this.a);
    paramView = null;
    String str = null;
    if (this.a.a.jdField_a_of_type_Int == 1006) {
      str = this.a.a.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      ChatActivityUtils.a(this.a.b, this.a, this.a.a.jdField_a_of_type_Int, paramView, this.a.a.d, str, true, this.a.a.b, true, true, null, "");
      ReportController.b(this.a.b, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      return;
      paramView = this.a.a.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxs
 * JD-Core Version:    0.7.0.1
 */