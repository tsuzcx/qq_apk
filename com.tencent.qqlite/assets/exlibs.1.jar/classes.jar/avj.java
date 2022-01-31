import android.view.View;
import android.view.View.OnClickListener;
import cannon.Visitor;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.MayKnowManActivity;
import com.tencent.mobileqq.statistics.ReportController;

class avj
  implements View.OnClickListener
{
  avj(avi paramavi, Visitor paramVisitor) {}
  
  public void onClick(View paramView)
  {
    paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_Avi.a, 1, String.valueOf(this.jdField_a_of_type_CannonVisitor.uin), null, 3003, 0, this.jdField_a_of_type_CannonVisitor.name, null, null, MayKnowManActivity.a(this.jdField_a_of_type_Avi.a));
    this.jdField_a_of_type_Avi.a.startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_Avi.a.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_frdoffer_add", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avj
 * JD-Core Version:    0.7.0.1
 */