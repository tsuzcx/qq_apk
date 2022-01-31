import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.qphone.base.remote.SimpleAccount;

class tqy
  implements Runnable
{
  tqy(tqx paramtqx) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Tqw.a.c();
    this.a.jdField_a_of_type_Tqw.a.b(this.a.jdField_a_of_type_Tqw.a.getString(2131436339));
    Intent localIntent = new Intent(this.a.jdField_a_of_type_Tqw.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    localIntent.putExtra("fromWhere", this.a.jdField_a_of_type_Tqw.a.b);
    this.a.jdField_a_of_type_Tqw.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqy
 * JD-Core Version:    0.7.0.1
 */