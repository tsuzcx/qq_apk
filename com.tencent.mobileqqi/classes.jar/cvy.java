import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cannon.Visitor;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.MayKnowManActivity;
import com.tencent.mobileqq.statistics.ReportController;

class cvy
  implements View.OnClickListener
{
  cvy(cvx paramcvx, Visitor paramVisitor) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Cvx.a.startActivity(new Intent(this.jdField_a_of_type_Cvx.a, AddFriendLogicActivity.class).putExtra("uin", String.valueOf(this.jdField_a_of_type_CannonVisitor.uin)).putExtra("nick_name", this.jdField_a_of_type_CannonVisitor.name).putExtra("param_last_activity_name", MayKnowManActivity.a(this.jdField_a_of_type_Cvx.a)).putExtra("source_id", 3003));
    ReportController.b(this.jdField_a_of_type_Cvx.a.b, "CliOper", "", "", "Contacts_tab", "Contacts_tab_frdoffer_add", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cvy
 * JD-Core Version:    0.7.0.1
 */