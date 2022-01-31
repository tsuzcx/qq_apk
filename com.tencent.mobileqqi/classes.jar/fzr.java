import android.app.Activity;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.jsp.DataApiPlugin;

class fzr
  implements Runnable
{
  fzr(fzq paramfzq, Activity paramActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_Fzq.a.callJs(this.jdField_a_of_type_Fzq.c, new String[] { "null", Integer.toString(this.jdField_a_of_type_Int) });
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Fzq.a.callJs(this.jdField_a_of_type_Fzq.c, new String[] { Util.b(this.jdField_a_of_type_JavaLangString), Integer.toString(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fzr
 * JD-Core Version:    0.7.0.1
 */