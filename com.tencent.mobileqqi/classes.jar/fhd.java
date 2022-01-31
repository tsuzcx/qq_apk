import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;

class fhd
{
  public static final int a = 0;
  private static fhd jdField_a_of_type_Fhd;
  private static final String jdField_a_of_type_JavaLangString = "qq_process_gm";
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final float jdField_b_of_type_Float = 0.001F;
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = ";";
  private static final float jdField_c_of_type_Float = 1.0F;
  public static final int c = 2;
  private static final String jdField_c_of_type_JavaLangString = "\\|";
  private static final float jdField_d_of_type_Float = 0.01F;
  static final int jdField_d_of_type_Int = 3;
  private static final float jdField_e_of_type_Float = 2.0F;
  static final int jdField_e_of_type_Int = 15;
  private static final int f = 20;
  private static final int g = 200;
  private static final int h = 5;
  private static final int i = 100;
  private static final int j = 1;
  private static final int k = 30;
  private static final int l = 0;
  private static final int m = 1;
  private static final int n = 2;
  float jdField_a_of_type_Float = 1.2F;
  long jdField_a_of_type_Long = 720000L;
  float[] jdField_a_of_type_ArrayOfFloat = { 0.25F, 0.1F };
  int[] jdField_a_of_type_ArrayOfInt = { 47185920, 68157440, 89128960, 120586240 };
  int[] jdField_b_of_type_ArrayOfInt;
  private int o = 1;
  
  private fhd()
  {
    this.b = new int[] { 3840000, 1920000, 960000, 720000, 600000 };
    DeviceProfileManager.a().a("qq_process_gm");
    if (QLog.isColorLevel()) {
      QLog.d("qq_process_gm", 2, "config = " + null);
    }
    if (!TextUtils.isEmpty(null)) {
      throw new NullPointerException();
    }
  }
  
  public static fhd a()
  {
    if (jdField_a_of_type_Fhd == null) {}
    try
    {
      if (jdField_a_of_type_Fhd == null) {
        jdField_a_of_type_Fhd = new fhd();
      }
      return jdField_a_of_type_Fhd;
    }
    finally {}
  }
  
  public long a(long[][] paramArrayOfLong, long paramLong)
  {
    return 600000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fhd
 * JD-Core Version:    0.7.0.1
 */