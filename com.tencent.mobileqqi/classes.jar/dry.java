import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ATroopMember;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;

class dry
  implements View.OnClickListener
{
  dry(drw paramdrw, TroopMemberListActivity.ATroopMember paramATroopMember) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_Drw.a.b) {
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_Drw.a.a(this.jdField_a_of_type_Drw.a.a, this.jdField_a_of_type_Drw.a.getString(2131562452), this.jdField_a_of_type_Drw.a.getString(2131562948));
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_Drw.a, 230).setMessage(2131561973).setPositiveButton(2131562539, new dsa(this)).setNegativeButton(2131561746, new drz(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dry
 * JD-Core Version:    0.7.0.1
 */