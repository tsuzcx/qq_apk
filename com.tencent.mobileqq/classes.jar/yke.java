import android.app.Activity;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class yke
{
  public static int a;
  public static int b = 2;
  public Activity a;
  public String a;
  private List<zsv> a;
  public yqx a;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public yke(Activity paramActivity, int paramInt1, String paramString, int paramInt2, yqx paramyqx)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.d = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt2;
    this.jdField_a_of_type_Yqx = paramyqx;
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
    this.jdField_a_of_type_JavaUtilList.add(new yks(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new ykq(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_AndroidAppActivity, 12, this.jdField_a_of_type_Yqx, false));
    this.jdField_a_of_type_JavaUtilList.add(new ykp(this.jdField_a_of_type_AndroidAppActivity, "FeedSegment", this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131698607), 2130846612, 2130846613));
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList.add(new yks(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new yku(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.add(new ykt(this.jdField_a_of_type_AndroidAppActivity, this.d, this.jdField_a_of_type_JavaLangString));
  }
  
  public List<zsv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yke
 * JD-Core Version:    0.7.0.1
 */