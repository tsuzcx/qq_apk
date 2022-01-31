import android.graphics.drawable.Drawable;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class qk
  extends Thread
{
  qk(qj paramqj, String paramString) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Qj.a.app.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Qj.a.runOnUiThread(new ql(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     qk
 * JD-Core Version:    0.7.0.1
 */