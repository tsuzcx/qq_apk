import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.qphone.base.remote.SimpleAccount;

class tty
  implements Runnable
{
  tty(ttx paramttx) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Ttw.a.c();
    this.a.jdField_a_of_type_Ttw.a.b(this.a.jdField_a_of_type_Ttw.a.getString(2131436356));
    Intent localIntent = new Intent(this.a.jdField_a_of_type_Ttw.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    localIntent.putExtra("fromWhere", this.a.jdField_a_of_type_Ttw.a.b);
    this.a.jdField_a_of_type_Ttw.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tty
 * JD-Core Version:    0.7.0.1
 */