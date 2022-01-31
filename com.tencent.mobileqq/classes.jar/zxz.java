import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class zxz
  implements View.OnClickListener
{
  public zxz(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      this.a.getWindow().setSoftInputMode(2);
      this.a.a.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
      AddFriendVerifyActivity.a(this.a).clearFocus();
    }
    paramView = AddFriendVerifyActivity.a(this.a).getText().toString();
    if (TextUtils.isEmpty(paramView))
    {
      if (!this.a.isFinishing())
      {
        paramView = new mnk(this.a);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131634054));
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845213);
        paramView.a();
      }
      return;
    }
    if (paramView.length() > 90)
    {
      paramView = new Dialog(this.a, 2131690181);
      paramView.setContentView(2131496755);
      ((TextView)paramView.findViewById(2131299579)).setText(this.a.getString(2131625523));
      ((ProgressBar)paramView.findViewById(2131300960)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131312849)).setImageResource(2130839293);
      paramView.show();
      return;
    }
    this.a.a(AddFriendVerifyActivity.a(this.a).getText().toString(), true);
    if (badq.d(this.a))
    {
      AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0), 2000);
      return;
    }
    bbmy.a(this.a, 1, 2131628948, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     zxz
 * JD-Core Version:    0.7.0.1
 */