import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.qphone.base.remote.SimpleAccount;

class drb
  implements Runnable
{
  drb(dra paramdra) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Dqz.a.e();
    this.a.jdField_a_of_type_Dqz.a.a(this.a.jdField_a_of_type_Dqz.a.getString(2131562096));
    Intent localIntent = new Intent(this.a.jdField_a_of_type_Dqz.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    this.a.jdField_a_of_type_Dqz.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     drb
 * JD-Core Version:    0.7.0.1
 */