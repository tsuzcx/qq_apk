import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class eri
  implements View.OnClickListener
{
  public eri(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this.a, this.a.getString(2131562452), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
      return;
    }
    if ((this.a.jdField_a_of_type_AndroidContentIntent != null) && (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ShowJoinDiscTips", false)))
    {
      DialogUtil.a(this.a, 230, this.a.getString(2131560225), this.a.getString(2131562255), 2131560229, 2131560230, new erj(this), new erk(this)).show();
      ReportController.b(this.a.b, "CliOper", "", "", "Multi_call", "Show_join_discuss_tips", 0, 0, "", "", "", "");
      return;
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eri
 * JD-Core Version:    0.7.0.1
 */