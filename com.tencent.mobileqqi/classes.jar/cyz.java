import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.LoginActivity;

public class cyz
  implements Runnable
{
  public cyz(LoginActivity paramLoginActivity, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.a(this.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.runOnUiThread(new cza(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cyz
 * JD-Core Version:    0.7.0.1
 */