import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.qphone.base.remote.SimpleAccount;

class dlk
  implements Runnable
{
  dlk(dlj paramdlj) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Dli.a.e();
    this.a.jdField_a_of_type_Dli.a.a(this.a.jdField_a_of_type_Dli.a.getString(2131562096));
    Intent localIntent = new Intent(this.a.jdField_a_of_type_Dli.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    this.a.jdField_a_of_type_Dli.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dlk
 * JD-Core Version:    0.7.0.1
 */