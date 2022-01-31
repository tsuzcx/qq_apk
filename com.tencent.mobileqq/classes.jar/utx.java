import android.app.Activity;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class utx
{
  public static int a;
  public static int b = 2;
  public Activity a;
  public String a;
  private List<wco> a;
  public vaq a;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public utx(Activity paramActivity, int paramInt1, String paramString, int paramInt2, vaq paramvaq)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.d = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt2;
    this.jdField_a_of_type_Vaq = paramvaq;
    if (paramInt2 == jdField_a_of_type_Int)
    {
      a();
      return;
    }
    if (paramInt2 == b)
    {
      b();
      return;
    }
    throw new IllegalStateException("setup profile list error because unknown list type.");
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList.add(new uul(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new uuj(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_AndroidAppActivity, 12, this.jdField_a_of_type_Vaq, false));
    this.jdField_a_of_type_JavaUtilList.add(new uui(this.jdField_a_of_type_AndroidAppActivity, "FeedSegment", this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131699693), 2130845704, 2130845705));
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(new uul(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new uun(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new uum(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
  }
  
  public List<wco> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utx
 * JD-Core Version:    0.7.0.1
 */