import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.LoginActivity;

public class asz
  implements Runnable
{
  public asz(LoginActivity paramLoginActivity, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.a(this.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.runOnUiThread(new ata(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     asz
 * JD-Core Version:    0.7.0.1
 */