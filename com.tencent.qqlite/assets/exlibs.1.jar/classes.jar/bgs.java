import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.tencent.mobileqq.activity.RegisterActivity;

public class bgs
  implements DialogInterface.OnClickListener
{
  public bgs(RegisterActivity paramRegisterActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity.startActivity(localIntent);
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity.a.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bgs
 * JD-Core Version:    0.7.0.1
 */