import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;

public class dmg
  implements DialogInterface.OnClickListener
{
  public dmg(SubAccountMessageActivity paramSubAccountMessageActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, SubLoginActivity.class);
    paramDialogInterface.putExtra("is_need_bind", false);
    paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.startActivity(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.f();
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmg
 * JD-Core Version:    0.7.0.1
 */