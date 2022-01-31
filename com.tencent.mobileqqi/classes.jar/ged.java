import android.app.Activity;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.jsp.DataApiPlugin;

class ged
  implements Runnable
{
  ged(gec paramgec, Activity paramActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_Gec.a.callJs(this.jdField_a_of_type_Gec.c, new String[] { "null", Integer.toString(this.jdField_a_of_type_Int) });
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Gec.a.callJs(this.jdField_a_of_type_Gec.c, new String[] { Util.b(this.jdField_a_of_type_JavaLangString), Integer.toString(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ged
 * JD-Core Version:    0.7.0.1
 */