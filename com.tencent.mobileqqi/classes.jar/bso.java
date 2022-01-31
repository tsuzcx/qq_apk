import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class bso
  implements Runnable
{
  bso(bsn parambsn, String paramString, int paramInt) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Bsn.a.b.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bsn.a.runOnUiThread(new bsp(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bso
 * JD-Core Version:    0.7.0.1
 */