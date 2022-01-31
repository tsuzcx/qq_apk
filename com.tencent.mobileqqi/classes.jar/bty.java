import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;

public class bty
  implements View.OnClickListener
{
  public bty(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.getText().toString().length() > 30)
    {
      paramView = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 2131624405);
      paramView.setContentView(2130903942);
      ((TextView)paramView.findViewById(2131231029)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.getString(2131563294));
      ((ProgressBar)paramView.findViewById(2131231028)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131234123)).setImageResource(2130837961);
      paramView.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.getText().toString(), false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a(this.jdField_a_of_type_JavaLangString, AddFriendVerifyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity), true, this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.getText().toString(), this.jdField_a_of_type_Int, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bty
 * JD-Core Version:    0.7.0.1
 */