import android.app.Activity;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class uhe
{
  public static int a;
  public static int b = 2;
  public Activity a;
  public String a;
  private List<vpv> a;
  public unx a;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public uhe(Activity paramActivity, int paramInt1, String paramString, int paramInt2, unx paramunx)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.d = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt2;
    this.jdField_a_of_type_Unx = paramunx;
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
    this.jdField_a_of_type_JavaUtilList.add(new uhs(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new uhq(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_AndroidAppActivity, 12, this.jdField_a_of_type_Unx, false));
    this.jdField_a_of_type_JavaUtilList.add(new uhp(this.jdField_a_of_type_AndroidAppActivity, "FeedSegment", this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131633894), 2130845515, 2130845516));
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(new uhs(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new uhu(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new uht(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
  }
  
  public List<vpv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhe
 * JD-Core Version:    0.7.0.1
 */