import android.graphics.drawable.Drawable;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class bmt
  extends Thread
{
  bmt(bms parambms, String paramString) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Bms.a.b.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bms.a.runOnUiThread(new bmu(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmt
 * JD-Core Version:    0.7.0.1
 */