import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class xq
  implements View.OnClickListener
{
  public xq(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a)) {
      QQToast.a(this.a, this.a.getString(2131362916), 0).b(this.a.getTitleBarHeight());
    }
    do
    {
      return;
      if (paramView == this.a.jdField_a_of_type_AndroidWidgetButton)
      {
        if (this.a.d == -1011) {
          this.a.a(AddRequestActivity.a(this.a), this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ArrayOfByte, this.a.q, AddRequestActivity.b(this.a), AddRequestActivity.c(this.a), AddRequestActivity.b(this.a));
        }
        for (;;)
        {
          ReportController.b(this.a.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
          return;
          this.a.a(AddRequestActivity.a(this.a), AddRequestActivity.b(this.a), null, AddRequestActivity.c(this.a), AddRequestActivity.b(this.a));
        }
      }
    } while (paramView != this.a.b);
    if (AddRequestActivity.a(this.a, 1))
    {
      AddRequestActivity.a(this.a).b(2131363381);
      AddRequestActivity.a(this.a).show();
    }
    ReportController.b(this.a.app, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xq
 * JD-Core Version:    0.7.0.1
 */