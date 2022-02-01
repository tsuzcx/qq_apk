import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class bzo
  implements View.OnClickListener
{
  public bzo(ChatActivity paramChatActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.jdField_a_of_type_Int == 3000)
    {
      ChatActivityUtils.a(this.a.b, this.a, this.a.a.jdField_a_of_type_JavaLangString, true, true, null);
      Long.valueOf(this.a.a.jdField_a_of_type_JavaLangString).longValue();
      return;
    }
    int i;
    switch (this.a.a.jdField_a_of_type_Int)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.a.b, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(i), "", "", "");
      PlusPanelUtils.a(this.a.b, this.a, this.a.a, true);
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzo
 * JD-Core Version:    0.7.0.1
 */