import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;

public class bys
  implements View.OnClickListener
{
  public bys(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.d) {
      return;
    }
    paramView = this.a;
    boolean bool;
    label102:
    int i;
    if (!this.a.c)
    {
      bool = true;
      paramView.c = bool;
      if (!this.a.c) {
        break label156;
      }
      AccountManageActivity.g(this.a).setVisibility(8);
      AccountManageActivity.h(this.a).setVisibility(0);
      AccountManageActivity.i(this.a).setText(2131561977);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131362099));
      int j = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      label115:
      if (i >= j) {
        break label263;
      }
      paramView = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if ((paramView != null) && (paramView.getTag() != null)) {
        break label216;
      }
    }
    for (;;)
    {
      i += 1;
      break label115;
      bool = false;
      break;
      label156:
      AccountManageActivity.j(this.a).setVisibility(0);
      AccountManageActivity.k(this.a).setVisibility(8);
      AccountManageActivity.l(this.a).setText(2131562001);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColorStateList(2131362073));
      break label102;
      label216:
      paramView = paramView.findViewById(2131230999);
      if (paramView != null)
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        localLayoutParams.width = ((int)(AccountManageActivity.a(this.a) * AccountManageActivity.b(this.a)));
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    label263:
    this.a.b();
    this.a.a(this.a.c);
    this.a.d = false;
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new byt(this), 400L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bys
 * JD-Core Version:    0.7.0.1
 */