import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class bzl
  implements ActionSheet.OnButtonClickListener
{
  bzl(bzk parambzk, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      ReportController.b(this.jdField_a_of_type_Bzk.a.b, "CliOper", "", this.jdField_a_of_type_Bzk.a.a.a, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
      paramView = (StrangerHandler)this.jdField_a_of_type_Bzk.a.b.a(28);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_Bzk.a.a.a)));
      paramView.b(localArrayList);
      if (ChatActivity.a(this.jdField_a_of_type_Bzk.a) == null) {
        ChatActivity.a(this.jdField_a_of_type_Bzk.a, new QQProgressDialog(this.jdField_a_of_type_Bzk.a, 0));
      }
      ChatActivity.a(this.jdField_a_of_type_Bzk.a).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzl
 * JD-Core Version:    0.7.0.1
 */