import android.graphics.drawable.Drawable;
import com.tencent.biz.qrcode.activity.LoginManagerActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class bro
  extends Thread
{
  public bro(LoginManagerActivity paramLoginManagerActivity, String paramString) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_ComTencentBizQrcodeActivityLoginManagerActivity.b.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQrcodeActivityLoginManagerActivity.runOnUiThread(new brp(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bro
 * JD-Core Version:    0.7.0.1
 */