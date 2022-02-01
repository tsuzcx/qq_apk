import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.qphone.base.remote.SimpleAccount;

class dlj
  implements Runnable
{
  dlj(dli paramdli) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Dlh.a.e();
    this.a.jdField_a_of_type_Dlh.a.a(this.a.jdField_a_of_type_Dlh.a.getString(2131562096));
    Intent localIntent = new Intent(this.a.jdField_a_of_type_Dlh.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    this.a.jdField_a_of_type_Dlh.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dlj
 * JD-Core Version:    0.7.0.1
 */