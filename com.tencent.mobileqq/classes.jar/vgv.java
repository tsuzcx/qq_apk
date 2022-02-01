import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class vgv
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public vgv a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = BaseApplicationImpl.context.getSharedPreferences("QCircle_crash_share", 0).getInt("QCircle_crash_count_" + paramInt, 0);
    return this;
  }
  
  public vgv a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public vgv b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public vgv c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public String d()
  {
    if ("Q_CIRCLE_PLUGIN_ASSET".equals(this.d)) {
      return "A";
    }
    if ("Q_CIRCLE_PLUGIN_NETWORK".equals(this.d)) {
      return "N";
    }
    if ("Q_CIRCLE_PLUGIN_TEST".equals(this.d)) {
      return "T";
    }
    return "U";
  }
  
  public vgv d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public vgv e(String paramString)
  {
    return this;
  }
  
  public String toString()
  {
    return "QCircleSampleInfo{mType='" + this.d + '\'' + ", mVersionCode=" + this.jdField_a_of_type_Int + ", mCrashCount=" + this.jdField_b_of_type_Int + ", HOST_SUPPORT_MINI =" + 1000 + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgv
 * JD-Core Version:    0.7.0.1
 */