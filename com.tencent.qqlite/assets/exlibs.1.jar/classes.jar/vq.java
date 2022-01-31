import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class vq
  implements View.OnClickListener
{
  public vq(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b) {
      return;
    }
    paramView = this.a;
    boolean bool;
    label102:
    int i;
    if (!this.a.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.jdField_a_of_type_Boolean = bool;
      if (!this.a.jdField_a_of_type_Boolean) {
        break label194;
      }
      AccountManageActivity.g(this.a).setVisibility(8);
      AccountManageActivity.h(this.a).setVisibility(0);
      AccountManageActivity.i(this.a).setText(2131363430);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131427500));
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        ((ShaderAnimLayout)AccountManageActivity.a(this.a, this.a.jdField_a_of_type_AndroidViewView)).d();
        this.a.jdField_a_of_type_AndroidViewView = null;
      }
      int j = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      label153:
      if (i >= j) {
        break label301;
      }
      paramView = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((paramView != null) && (paramView.getTag() != null)) {
        break label254;
      }
    }
    for (;;)
    {
      i += 2;
      break label153;
      bool = false;
      break;
      label194:
      AccountManageActivity.j(this.a).setVisibility(0);
      AccountManageActivity.k(this.a).setVisibility(8);
      AccountManageActivity.l(this.a).setText(2131363433);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131427474));
      break label102;
      label254:
      paramView = paramView.findViewById(2131296454);
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) * AccountManageActivity.b(this.a)));
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    label301:
    this.a.b();
    this.a.a(this.a.jdField_a_of_type_Boolean);
    this.a.b = false;
    AccountManageActivity.a(this.a).postDelayed(new vr(this), 400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     vq
 * JD-Core Version:    0.7.0.1
 */