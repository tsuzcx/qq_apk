import android.app.Activity;
import com.tencent.common.app.AppInterface;
import java.io.File;

public class uxq
  extends uxn
{
  private uut a;
  
  public void a()
  {
    super.a();
    if (jdField_b_of_type_Int != 2)
    {
      String str = new File(this.jdField_b_of_type_JavaLangString).getParent();
      if (str != null) {
        bace.a(str);
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, AppInterface paramAppInterface, uut paramuut)
  {
    super.a(paramActivity, paramString1, paramString2, paramAppInterface);
    this.a = paramuut;
  }
  
  protected boolean a(bahx parambahx)
  {
    if (parambahx.c == 2)
    {
      if (this.a != null) {
        this.a.a();
      }
      return true;
    }
    return super.a(parambahx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxq
 * JD-Core Version:    0.7.0.1
 */