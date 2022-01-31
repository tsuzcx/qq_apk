import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class vm
  implements Runnable
{
  vm(vl paramvl, String paramString, int paramInt) {}
  
  public void run()
  {
    Drawable localDrawable = this.jdField_a_of_type_Vl.a.app.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Vl.a.runOnUiThread(new vn(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     vm
 * JD-Core Version:    0.7.0.1
 */