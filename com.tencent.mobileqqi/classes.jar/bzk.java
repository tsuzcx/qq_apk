import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class bzk
  implements View.OnClickListener
{
  public bzk(ChatActivity paramChatActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject == null) || (!(localObject instanceof Integer))) {
      return;
    }
    paramView = this.a.a.jdField_a_of_type_JavaLangString;
    if (this.a.a.jdField_a_of_type_Int == 1006) {
      paramView = this.a.a.f;
    }
    switch (((Integer)localObject).intValue())
    {
    default: 
      return;
    case 1: 
      ChatActivityUtils.a(this.a.b, this.a, this.a.a.jdField_a_of_type_Int, paramView, this.a.a.e, true);
      return;
    case 2: 
      ChatActivityUtils.a(this.a.b, this.a, this.a.a.jdField_a_of_type_Int, paramView, this.a.a.e, false);
      return;
    case 3: 
      if (ChatActivityUtils.a(this.a.b, this.a.a)) {
        ReportController.b(this.a.b, "CliOper", "", this.a.a.jdField_a_of_type_JavaLangString, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
      }
      paramView = this.a;
      localObject = this.a.a;
      String str = ChatActivity.a(this.a);
      if (this.a.getIntent().getStringExtra("param_return_addr") != null) {}
      for (boolean bool = true;; bool = false)
      {
        ChatActivityUtils.a(paramView, (SessionInfo)localObject, str, bool);
        return;
      }
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this.a, null);
    paramView.a(this.a.getResources().getString(2131562554));
    paramView.a(2131561963, 3);
    paramView.d(2131561746);
    paramView.a(new bzl(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzk
 * JD-Core Version:    0.7.0.1
 */