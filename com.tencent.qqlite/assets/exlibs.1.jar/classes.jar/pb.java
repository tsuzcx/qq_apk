import android.graphics.drawable.Drawable;
import com.tencent.biz.qrcode.activity.LoginManagerActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class pb
  extends Thread
{
  public pb(LoginManagerActivity paramLoginManagerActivity, String paramString) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_ComTencentBizQrcodeActivityLoginManagerActivity.app.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQrcodeActivityLoginManagerActivity.runOnUiThread(new pc(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pb
 * JD-Core Version:    0.7.0.1
 */