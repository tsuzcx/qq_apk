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

public class cmq
  implements View.OnClickListener
{
  public cmq(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this.a, this.a.getString(2131362785), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
      return;
    }
    if ((this.a.jdField_a_of_type_AndroidContentIntent != null) && (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ShowJoinDiscTips", false)))
    {
      DialogUtil.a(this.a, 230, this.a.getString(2131362935), this.a.getString(2131363217), 2131362790, 2131362788, new cmr(this), new cms(this)).show();
      ReportController.b(this.a.app, "CliOper", "", "", "Multi_call", "Show_join_discuss_tips", 0, 0, "", "", "", "");
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cmq
 * JD-Core Version:    0.7.0.1
 */