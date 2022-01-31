import android.app.Activity;
import com.tencent.common.app.AppInterface;
import java.io.File;

public class vkm
  extends vkj
{
  private vhp a;
  
  public void a()
  {
    super.a();
    if (jdField_b_of_type_Int != 2)
    {
      String str = new File(this.jdField_b_of_type_JavaLangString).getParent();
      if (str != null) {
        bbdj.a(str);
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, AppInterface paramAppInterface, vhp paramvhp)
  {
    super.a(paramActivity, paramString1, paramString2, paramAppInterface);
    this.a = paramvhp;
  }
  
  protected boolean a(bbje parambbje)
  {
    if (parambbje.c == 2)
    {
      if (this.a != null) {
        this.a.a();
      }
      return true;
    }
    return super.a(parambbje);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vkm
 * JD-Core Version:    0.7.0.1
 */