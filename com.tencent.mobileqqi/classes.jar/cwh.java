import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;

public class cwh
  implements View.OnClickListener
{
  public cwh(ModifyFriendInfoActivity paramModifyFriendInfoActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (2131230940 == i)
    {
      paramView = new ProfileActivity.AllInOne(this.a.jdField_a_of_type_JavaLangString, 1);
      paramView.g = this.a.jdField_b_of_type_JavaLangString;
      ProfileActivity.a(this.a, paramView);
    }
    do
    {
      return;
      if (2131231928 == i)
      {
        paramView = new Intent(this.a, EditActivity.class);
        paramView.putExtra("title", 2131562429).putExtra("limit", 96).putExtra("canPostNull", true).putExtra("hint", this.a.getResources().getString(2131562022)).putExtra("multiLine", false);
        if ((this.a.jdField_b_of_type_AndroidWidgetTextView.getText() != null) && (this.a.jdField_b_of_type_AndroidWidgetTextView.getText().length() > 0)) {
          paramView.putExtra("current", this.a.jdField_b_of_type_AndroidWidgetTextView.getText());
        }
        this.a.startActivityForResult(paramView, 1000);
        return;
      }
      if (2131231931 == i)
      {
        paramView = new Intent(this.a, MoveToGroupActivity.class).putExtra("friendUin", this.a.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)this.a.jdField_a_of_type_Int);
        this.a.startActivityForResult(paramView, 0);
        return;
      }
    } while (2131231934 != i);
    paramView = new Intent(this.a, ChatActivity.class);
    paramView.putExtra("uin", this.a.jdField_a_of_type_JavaLangString);
    paramView.putExtra("uinname", this.a.jdField_b_of_type_JavaLangString);
    paramView.putExtra("uintype", 0);
    this.a.startActivity(paramView.addCategory("android.intent.category.CHAT").addFlags(536870912));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwh
 * JD-Core Version:    0.7.0.1
 */